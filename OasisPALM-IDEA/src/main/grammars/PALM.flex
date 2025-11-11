package org.openalgebra.oasispalmidea.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.openalgebra.oasispalmidea.language.psi.PALMTypes;
import com.intellij.psi.TokenType;

%%

%class PALMLexer
%public
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]

/* Define operators */
OPERATORS=("real"|"i"|"j"|"var"|"+"|"-"|"*"|"/"|"^"|"log"|"int"|"d"|"neg"|"pi"|"e"|"magnitude")

%state WAITING_VALUE

%%

/* Operators */
<YYINITIAL> {OPERATORS} { yybegin(YYINITIAL); return PALMTypes.OPERATOR; }

/* Numbers */
<YYINITIAL> [+-]?([0-9]+(\.[0-9]*)?|\.[0-9]+)([eE][+-]?[0-9]+)? { yybegin(YYINITIAL); return PALMTypes.NUMBER; }

/* Identifiers */
<YYINITIAL> [a-zA-Z_][a-zA-Z0-9_]* { yybegin(YYINITIAL); return PALMTypes.IDENTIFIER; }

/* Punctuators */
<YYINITIAL> "(" { return PALMTypes.START_EXPRESSION; }
<YYINITIAL> ")" { return PALMTypes.END_EXPRESSION; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }