package com.danielkgm.compiler.parser.scanner;

public abstract class Scanner {

    private byte[] input;
    private int current;

    protected Scanner(byte[] input) {
        this.input = input;
    }

    protected char peek() {
        if (current < input.length) {
            return (char) input[current];
        }

        return '\0';
    }

    protected void advance() {
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

    public Token nextToken() {
        char ch = peek();

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
            case '\0':
                return new Token(TokenType.EOF, "EOF");
            default:
                throw new Error("lexical error at " + ch);
        }
    }

}
