package org.openalgebra.oasispalmidea.language

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import org.openalgebra.oasispalmidea.language.psi.PALMExpression
import org.openalgebra.oasispalmidea.language.psi.PALMTypes

class PALMAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PALMExpression) {
            annotate(element, holder)
        }
    }

    fun annotate(element: PALMExpression, holder: AnnotationHolder) {
        // Check Arity
        val op = element.operatorText
        val operands = element.operands
        val expected = when (op) {
            "i","j","pi","e" -> 0
            "real", "var","neg","magnitude"  -> 1
            "+" , "-" , "*" , "/", "^", "log", "int", "d", -> 2
            else -> null
        }

        if (expected != null && operands.size != expected) {
            holder.newAnnotation(
                HighlightSeverity.ERROR,
                "Operator '$op' expects $expected operand(s), found ${operands.size}")
                .range(element.textRange)
                .create()
        }

        // real Number check
        when (op) {
            "real" -> {
                if (operands.size == expected && element.operands[0].firstChild.elementType != PALMTypes.NUMBER) { // Argument should be a number
                    holder.newAnnotation(
                        HighlightSeverity.ERROR,
                        "Operator 'real' expects a numeric operand")
                        .range(element.operands[0].textRange)
                        .create()
                }
            }
            "var" -> {
                if (operands.size == expected && element.operands[0].firstChild.elementType != PALMTypes.IDENTIFIER) { // Argument should be a variable
                    holder.newAnnotation(
                        HighlightSeverity.ERROR,
                        "Operator 'var' expects a variable name, not a numeric operand")
                        .range(element.operands[0].textRange)
                        .create()
                }
            }
        }
    }
}
