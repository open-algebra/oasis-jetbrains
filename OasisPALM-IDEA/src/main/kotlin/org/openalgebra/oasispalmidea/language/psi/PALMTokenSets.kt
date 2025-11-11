package org.openalgebra.oasispalmidea.language.psi

import com.intellij.psi.tree.TokenSet
import org.openalgebra.oasispalmidea.language.psi.PALMTypes

interface PALMTokenSets {
    companion object {
        val PUNCTUATORS: TokenSet = TokenSet.create(
            PALMTypes.START_EXPRESSION,
            PALMTypes.END_EXPRESSION,
        )
    }
}