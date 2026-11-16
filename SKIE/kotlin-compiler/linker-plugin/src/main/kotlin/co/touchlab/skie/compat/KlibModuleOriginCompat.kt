package co.touchlab.skie.compat

import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.library.KotlinLibrary
import org.jetbrains.kotlin.library.metadata.DeserializedKlibModuleOrigin
import org.jetbrains.kotlin.library.metadata.klibModuleOrigin

// Kotlin 2.5.0 removed both `ModuleDescriptor.konanLibrary` and `ModuleDescriptor.kotlinLibrary`.
internal val ModuleDescriptor.kotlinLibraryOrNull: KotlinLibrary?
    get() = (klibModuleOrigin as? DeserializedKlibModuleOrigin)?.library
