package com.danielkgm.compiler.parser.scanner;

public class Scanner {

    private byte[] input;
    private int current;

    public Scanner(byte[] input) {
        this.input = input;
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

    public char nextToken() {
        char ch = peek();

        if (Character.isDigit(ch)) {
            advance();
            return ch;
        }

        switch (ch) {
            case '+', '-':
                advance();
                return ch;
            default:
                break;
        }

        return '\0';
    }

}
