@file:Suppress("invisible_reference", "invisible_member")

package co.touchlab.skie.kir.descriptor

import co.touchlab.skie.compat.KonanConfig
import org.jetbrains.kotlin.utils.ResolvedDependenciesSupport
import org.jetbrains.kotlin.utils.ResolvedDependency
import kotlin.io.path.exists
import kotlin.io.path.readText

// Kotlin 2.5.0 changed `externalDependenciesFile` to a `java.nio.file.Path`. See the `2.4.0..2.4.20` source set for details.
internal fun getExternalDependencies(konanConfig: KonanConfig): Set<ResolvedDependency> {
    val externalDependenciesFile = konanConfig.externalDependenciesFile ?: return emptySet()
    if (!externalDependenciesFile.exists()) return emptySet()

    return ResolvedDependenciesSupport
        .deserialize(externalDependenciesFile.readText()) { _, _ -> }
        .modules
        .toSet()
}
