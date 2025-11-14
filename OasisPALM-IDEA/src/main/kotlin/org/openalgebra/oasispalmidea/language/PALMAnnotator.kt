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

        // Unknown operator check
        if (expected == null) {
            holder.newAnnotation(
                HighlightSeverity.ERROR,
                "Unknown operator '$op'")
                .range(element.textRange)
                .create()
            return
        }

        // Arity check
        if (operands.size != expected) {
            holder.newAnnotation(
                HighlightSeverity.ERROR,
                "Operator '$op' expects $expected operand(s), found ${operands.size}")
                .range(element.textRange)
                .create()
            return
        }

        // (real Number) check
        if (op == "real") {
            val firstOperand = element.operands[0]
            if (firstOperand.firstChild.elementType != PALMTypes.NUMBER) {
                holder.newAnnotation(
                    HighlightSeverity.ERROR,
                    "Operator 'real' expects a numeric operand")
                    .range(firstOperand.textRange)
                    .create()
            }
            return
        }

        // (var Identifier) check
        if (op == "var") {
            val firstOperand = element.operands[0]
            if (firstOperand.firstChild.elementType != PALMTypes.IDENTIFIER) {
                holder.newAnnotation(
                    HighlightSeverity.ERROR,
                    "Operator 'var' expects a variable name, not a numeric operand")
                    .range(firstOperand.textRange)
                    .create()
            }
            return
        }

        // Ensure Number only for 'real' and Identifier only for 'var'
        for (operand in operands) {
            when (operand.firstChild.elementType) {
                PALMTypes.IDENTIFIER -> {
                    holder.newAnnotation(
                        HighlightSeverity.ERROR,
                        "Operator '$op' does not accept variable names as operands"
                    )
                        .range(operand.textRange)
                        .create()
                }

                PALMTypes.NUMBER -> {
                    holder.newAnnotation(
                        HighlightSeverity.ERROR,
                        "Operator '$op' does not accept numeric operands"
                    )
                        .range(operand.textRange)
                        .create()
                }
            }
        }
    }
}
