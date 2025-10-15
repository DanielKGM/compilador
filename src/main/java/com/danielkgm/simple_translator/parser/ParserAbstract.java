package com.danielkgm.simple_translator.parser;

public abstract class ParserAbstract {
    protected byte[] input;
    protected int current;

    protected char peek() {
        if (current < input.length) {
            return (char) input[current];
        }

        return '\0';
    }

    protected void match(char c) {
        if (c == peek()) {
            current++;
        } else {
            throw new Error("syntax error");
        }
    }
}