package com.danielkgm.simple_translator;

import com.danielkgm.simple_translator.parser.PolishNotationParser;

public class SimpleTranslator {
    public static void main(String[] args) {
        String input = "2+2-1";
        PolishNotationParser p = new PolishNotationParser(input.getBytes());
        p.parse();

    }
}