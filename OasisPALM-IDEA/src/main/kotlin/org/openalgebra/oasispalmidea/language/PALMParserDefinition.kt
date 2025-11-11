package org.openalgebra.oasispalmidea.language

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.jetbrains.annotations.NotNull
import org.openalgebra.oasispalmidea.language.psi.PALMFile
import org.openalgebra.oasispalmidea.language.psi.PALMTokenSets
import org.openalgebra.oasispalmidea.language.psi.PALMTypes
import org.openalgebra.oasispalmidea.parser.PALMParser


internal class PALMParserDefinition : ParserDefinition {
    @NotNull
    override fun createLexer(project: Project?): Lexer {
        return PALMLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY
    }

    @NotNull
    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    @NotNull
    override fun createParser(project: Project?): PsiParser {
        return PALMParser()
    }

    @NotNull
    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    @NotNull
    override fun createFile(p0: FileViewProvider): PsiFile {
        return PALMFile(p0)
    }

    @NotNull
    public override fun createElement(node: ASTNode?): PsiElement {
        return PALMTypes.Factory.createElement(node)
    }

    companion object {
        val FILE: IFileElementType = IFileElementType(PALMLanguage)
    }
}