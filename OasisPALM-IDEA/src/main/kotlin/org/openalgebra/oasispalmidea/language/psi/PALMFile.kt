package org.openalgebra.oasispalmidea.language.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.openalgebra.oasispalmidea.language.PALMFileType
import org.openalgebra.oasispalmidea.language.PALMLanguage


class PALMFile(viewProvider: FileViewProvider?) : PsiFileBase(viewProvider!!, PALMLanguage) {
    override fun getFileType(): FileType {
        return PALMFileType
    }

    override fun toString(): String {
        return "PALM File"
    }
}