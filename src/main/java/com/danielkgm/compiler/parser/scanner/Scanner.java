package com.danielkgm.compiler.parser.scanner;

import java.util.Map;

public class Scanner {

    private static final Map<String, TokenType> KEYWORDS = Map.of(
            "let", TokenType.LET);

    private byte[] input;
    private int current;

    public Scanner(byte[] input) {
        this.input = input;
    }

    public Map<String, TokenType> getKEYWORDS() {
        return KEYWORDS;
    }

    private char peek() {
        if (current < input.length) {
            return (char) input[current];
        }

        return '\0';
    }

    private void advance() {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    private Token number() {
        int start = current;

        while (Character.isDigit(peek())) {
            advance();
        }

        String n = new String(input, start, current - start);
        return new Token(TokenType.NUMBER, n);
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || Character.isDigit((c));
    }

    private void skipWhitespace() {
        char ch = peek();
        while (ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n') {
            advance();
            ch = peek();
        }
    }

    private Token identifier() {
        int start = current;
        while (isAlphaNumeric(peek()))
            advance();

        String id = new String(input, start, current - start);
        TokenType type = KEYWORDS.get(id);
        if (type == null)
            type = TokenType.IDENT;
        return new Token(type, id);
    }

    public Token nextToken() {
        skipWhitespace();
        char ch = peek();

        if (isAlpha(ch)) {
            return identifier();
        }

        if (ch == '0') {
            advance();
            return new Token(TokenType.NUMBER, Character.toString(ch));
        }

        if (Character.isDigit(ch)) {
            return number();
        }

        switch (ch) {
            case '+':
                advance();
                return new Token(TokenType.PLUS, "+");
            case '-':
                advance();
                return new Token(TokenType.MINUS, "-");
            case '=':
                advance();
                return new Token(TokenType.EQ, "=");
            case ';':
                advance();
                return new Token(TokenType.SEMICOLON, ";");
            case '\0':
                return new Token(TokenType.EOF, "EOF");
            default:
                throw new Error("lexical error at " + ch);
        }

    }

}
