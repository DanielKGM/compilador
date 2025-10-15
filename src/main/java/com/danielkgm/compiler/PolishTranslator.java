package com.danielkgm.compiler;

import com.danielkgm.compiler.parser.PolishNotationParser;

public class PolishTranslator {
    public static void main(String[] args) {
        String input = "2+1+2-1-3+2";
        PolishNotationParser p = new PolishNotationParser(input.getBytes());
        p.parse();

    }
}