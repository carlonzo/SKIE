@file:Suppress("invisible_reference", "invisible_member")

package co.touchlab.skie.entrypoint

import co.touchlab.skie.compilerinject.compilerplugin.initPhaseContext
import co.touchlab.skie.compilerinject.interceptor.PhaseInterceptor
import co.touchlab.skie.compat.PhaseContext
import co.touchlab.skie.kir.descriptor.ObjCExportedInterfaceProvider
import co.touchlab.skie.compat.FrontendOutput
import co.touchlab.skie.compat.createObjCExportMapper
import org.jetbrains.kotlin.backend.konan.driver.phases.ProduceObjCExportInterfacePhase
import org.jetbrains.kotlin.backend.konan.getExportedDependencies
import org.jetbrains.kotlin.backend.konan.objcexport.ObjCExportedInterface

internal class ProduceObjCExportInterfacePhaseInterceptor :
    PhaseInterceptor<PhaseContext, FrontendOutput, ObjCExportedInterface> {

    override fun getInterceptedPhase(): Any = ProduceObjCExportInterfacePhase

    override fun intercept(
        context: PhaseContext,
        input: FrontendOutput,
        next: (PhaseContext, FrontendOutput) -> ObjCExportedInterface,
    ): ObjCExportedInterface {
        val konanConfig = context.konanConfig
        val mainSkieContext = EntrypointUtils.createMainSkieContext(
            initPhaseContext = context.config.configuration.initPhaseContext,
            konanConfig = konanConfig,
            kotlinObjCExportMapper = input.createObjCExportMapper(konanConfig),
            mainModuleDescriptor = input.moduleDescriptor,
            exportedDependencies = lazy { input.moduleDescriptor.getExportedDependencies(konanConfig) },
        )

        EntrypointUtils.runClassExportPhases(mainSkieContext)

        EntrypointUtils.runFrontendIrPhases(mainSkieContext)

        val result = next(context, input)

        mainSkieContext.objCExportedInterfaceProvider = ObjCExportedInterfaceProvider(result)

        return result
    }
}
