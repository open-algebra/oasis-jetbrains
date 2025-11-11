package org.openalgebra.oasispalmidea.language

import com.intellij.lexer.FlexAdapter
import org.openalgebra.oasispalmidea.lexer.PALMLexer

class PALMLexerAdapter : FlexAdapter(PALMLexer(null))