@file:Suppress("invisible_reference", "invisible_member")

package co.touchlab.skie.kir.descriptor

import co.touchlab.skie.compat.KonanConfig
import co.touchlab.skie.compat.allLibraries
import org.jetbrains.kotlin.konan.library.isImplicitlyLoadedFromKotlinNativeDistribution
import org.jetbrains.kotlin.library.KotlinLibrary

internal fun getDefaultLibraries(konanConfig: KonanConfig): Set<KotlinLibrary> =
    konanConfig.allLibraries
        .filter { it.isImplicitlyLoadedFromKotlinNativeDistribution }
        .toSet()
