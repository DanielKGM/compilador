package com.danielkgm.compiler.reverse_polish_notation;

public class PolishTranslator {
    public static void main(String[] args) {
        String input = """
                let a = 42 + 5 - 8;
                let b = 56 + 8;
                print a + b + 6;
                    """;
        PolishParser p = new PolishParser(input.getBytes());
        p.parse();

    }
}