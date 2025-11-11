package org.openalgebra.oasispalmidea.language

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NotNull
import org.openalgebra.oasispalmidea.language.psi.PALMTypes

object PALMSyntaxHighlighter : SyntaxHighlighterBase() {
    @NotNull
    override fun getHighlightingLexer(): Lexer {
        return PALMLexerAdapter()
    }

    public override fun getTokenHighlights(tokenType: IElementType): @NotNull Array<TextAttributesKey?> =
        when (tokenType) {
            /* Operators */
            PALMTypes.OPERATOR -> OPERATOR_KEYS

            /* Numbers */
            PALMTypes.NUMBER -> NUMBER_KEYS

            /* Identifiers */
            PALMTypes.IDENTIFIER -> IDENTIFIER_KEYS

            /* Punctuators */
            PALMTypes.START_EXPRESSION,
            PALMTypes.END_EXPRESSION -> PUNCTUATOR_KEYS

            else -> EMPTY_KEYS
        } as Array<TextAttributesKey?>


    val OPERATOR = createTextAttributesKey("PALM_OPERATOR", DefaultLanguageHighlighterColors.KEYWORD)
    val NUMBER = createTextAttributesKey("PALM_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val IDENTIFIER = createTextAttributesKey("PALM_IDENTIFIER", DefaultLanguageHighlighterColors.STRING)
    val PUNCTUATOR = createTextAttributesKey("PALM_SEPARATOR", DefaultLanguageHighlighterColors.PARENTHESES)

    val SEPARATOR: TextAttributesKey? =
        createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
    val KEY: TextAttributesKey? = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD)
    val VALUE: TextAttributesKey? = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
    val COMMENT: TextAttributesKey? =
        createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val BAD_CHARACTER: TextAttributesKey? =
        createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

    private val OPERATOR_KEYS = arrayOf(OPERATOR)
    private val NUMBER_KEYS = arrayOf<TextAttributesKey?>(NUMBER)
    private val IDENTIFIER_KEYS = arrayOf<TextAttributesKey?>(IDENTIFIER)
    private val PUNCTUATOR_KEYS = arrayOf<TextAttributesKey?>(PUNCTUATOR)
    private val BAD_CHAR_KEYS = arrayOf<TextAttributesKey?>(BAD_CHARACTER)
    private val SEPARATOR_KEYS = arrayOf<TextAttributesKey?>(SEPARATOR)
    private val KEY_KEYS = arrayOf<TextAttributesKey?>(KEY)
    private val VALUE_KEYS = arrayOf<TextAttributesKey?>(VALUE)
    private val COMMENT_KEYS = arrayOf<TextAttributesKey?>(COMMENT)
    private val EMPTY_KEYS = kotlin.arrayOfNulls<TextAttributesKey>(0)

}