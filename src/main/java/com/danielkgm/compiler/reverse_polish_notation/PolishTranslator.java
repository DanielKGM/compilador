package com.danielkgm.compiler.reverse_polish_notation;

public class PolishTranslator {
    public static void main(String[] args) {
        String input = "let a = 23 + 23;";
        PolishParser p = new PolishParser(input.getBytes());
        p.parse();

    }
}