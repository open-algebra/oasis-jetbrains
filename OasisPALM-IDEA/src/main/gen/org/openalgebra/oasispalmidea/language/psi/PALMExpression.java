// This is a generated file. Not intended for manual editing.
package org.openalgebra.oasispalmidea.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PALMExpression extends PsiElement {

  @NotNull
  List<PALMOperand> getOperandList();

  @Nullable String getOperatorText();

  @NotNull List<@NotNull PALMOperand> getOperands();

}
