@file:Suppress("invisible_reference", "invisible_member")

package co.touchlab.skie.compat

import org.jetbrains.kotlin.backend.konan.LinkKlibsContext
import org.jetbrains.kotlin.backend.konan.LinkKlibsOutput
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.resolve.BindingContext

internal val LinkKlibsOutput.mainIrModule: IrModuleFragment
    get() = irModule

internal val LinkKlibsContext.bindingContextCompat: BindingContext
    get() = bindingContext
