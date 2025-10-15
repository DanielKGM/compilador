package com.danielkgm.compiler.parser.scanner;

public class Token {

    final TokenType type;
    final String lexeme;

    public Token(TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "<" + type + ">" + lexeme + "</" + type + ">";
    }

}