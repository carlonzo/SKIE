@file:Suppress("invisible_reference", "invisible_member")

package co.touchlab.skie.compat

import org.jetbrains.kotlin.backend.konan.driver.phases.K1FrontendPhaseOutput
import org.jetbrains.kotlin.backend.konan.objcexport.ObjCExportMapper

internal typealias FrontendOutput = K1FrontendPhaseOutput

// Kotlin 2.5.0 removed `FrontendServices`; `ObjCExportMapper` now takes `LanguageVersionSettings` instead of a `DeprecationResolver`.
internal fun FrontendOutput.createObjCExportMapper(konanConfig: KonanConfig): ObjCExportMapper =
    ObjCExportMapper(konanConfig.languageVersionSettings, unitSuspendFunctionExport = konanConfig.unitSuspendFunctionObjCExport)
