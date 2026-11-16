@file:Suppress("invisible_reference", "invisible_member")

package co.touchlab.skie.compat

import org.jetbrains.kotlin.backend.konan.driver.phases.FrontendPhaseOutput
import org.jetbrains.kotlin.backend.konan.objcexport.ObjCExportMapper

internal typealias FrontendOutput = FrontendPhaseOutput.Full

internal fun FrontendOutput.createObjCExportMapper(konanConfig: KonanConfig): ObjCExportMapper =
    ObjCExportMapper(frontendServices.deprecationResolver, unitSuspendFunctionExport = konanConfig.unitSuspendFunctionObjCExport)
