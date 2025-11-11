package org.openalgebra.oasispalmidea.language.psi

import com.intellij.psi.tree.IElementType
import org.openalgebra.oasispalmidea.language.PALMLanguage

class PALMTokenType(debugName: String) : IElementType(debugName, PALMLanguage) {
    override fun toString(): String {
        return "PALMTokenType." + super.toString()
    }
}