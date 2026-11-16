package co.touchlab.skie.compat

import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.resolve.diagnostics.findPsi

internal fun DeclarationDescriptor.findPsiCompat(): PsiElement? = findPsi()
