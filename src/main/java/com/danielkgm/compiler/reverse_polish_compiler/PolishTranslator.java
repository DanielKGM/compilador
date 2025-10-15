package com.danielkgm.compiler.reverse_polish_compiler;

public class PolishTranslator {
    public static void main(String[] args) {
        String input = "2+1+2-1-3+2";
        PolishParser p = new PolishParser(input.getBytes());
        p.parse();

    }
}