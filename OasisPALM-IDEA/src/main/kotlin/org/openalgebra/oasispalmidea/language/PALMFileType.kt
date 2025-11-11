package org.openalgebra.oasispalmidea.language

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.util.NlsSafe
import org.jetbrains.annotations.NonNls
import javax.swing.Icon

object PALMFileType: LanguageFileType(PALMLanguage) {
    override fun getName(): @NonNls String {
       return "PALM File"
    }

    override fun getDescription(): @NlsContexts.Label String {
       return "Oasis PALM"
    }

    override fun getDefaultExtension(): @NlsSafe String {
        return "palm"
    }

    override fun getIcon(): Icon? {
       return PALMIcons.FILE
    }

}