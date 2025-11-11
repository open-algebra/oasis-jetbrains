// This is a generated file. Not intended for manual editing.
package org.openalgebra.oasispalmidea.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.openalgebra.oasispalmidea.language.psi.PALMTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.openalgebra.oasispalmidea.language.psi.*;

public class PALMExpressionImpl extends ASTWrapperPsiElement implements PALMExpression {

  public PALMExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PALMVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PALMVisitor) accept((PALMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PALMOperand> getOperandList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PALMOperand.class);
  }

  @Override
  public @Nullable String getOperatorText() {
    return PALMPsiImplUtil.getOperatorText(this);
  }

  @Override
  public @NotNull List<@NotNull PALMOperand> getOperands() {
    return PALMPsiImplUtil.getOperands(this);
  }

}
