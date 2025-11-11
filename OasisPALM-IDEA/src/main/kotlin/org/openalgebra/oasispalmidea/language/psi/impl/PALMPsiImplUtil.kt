package org.openalgebra.oasispalmidea.language.psi.impl

import org.openalgebra.oasispalmidea.language.psi.PALMExpression
import org.openalgebra.oasispalmidea.language.psi.PALMOperand
import org.openalgebra.oasispalmidea.language.psi.PALMTypes

object PALMPsiImplUtil {
    @JvmStatic
    fun getOperatorText(element: PALMExpression): String? {
        val operatorNode = element.node.findChildByType(PALMTypes.OPERATOR)
        return operatorNode?.text
    }

    @JvmStatic
    fun getOperands(element: PALMExpression): List<PALMOperand> {
        return element.children.filterIsInstance<PALMOperand>()
    }
}