// This is a generated file. Not intended for manual editing.
package org.openalgebra.oasispalmidea.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.openalgebra.oasispalmidea.language.psi.impl.*;

public interface PALMTypes {

  IElementType EXPRESSION = new PALMElementType("EXPRESSION");
  IElementType OPERAND = new PALMElementType("OPERAND");

  IElementType END_EXPRESSION = new PALMTokenType("END_EXPRESSION");
  IElementType IDENTIFIER = new PALMTokenType("IDENTIFIER");
  IElementType NUMBER = new PALMTokenType("NUMBER");
  IElementType OPERATOR = new PALMTokenType("OPERATOR");
  IElementType START_EXPRESSION = new PALMTokenType("START_EXPRESSION");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == EXPRESSION) {
        return new PALMExpressionImpl(node);
      }
      else if (type == OPERAND) {
        return new PALMOperandImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
