@file:Suppress("invisible_reference", "invisible_member")

package co.touchlab.skie.compat

import org.jetbrains.kotlin.backend.konan.LinkKlibsContext
import org.jetbrains.kotlin.backend.konan.LinkKlibsOutput
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.resolve.BindingContext

internal val LinkKlibsOutput.mainIrModule: IrModuleFragment
    get() = irModulesToCompile.first()

// Kotlin 2.5.0 no longer exposes the K1 binding context to the backend. SKIE generates IR only from descriptors, so it does not need one.
internal val LinkKlibsContext.bindingContextCompat: BindingContext
    get() = BindingContext.EMPTY
