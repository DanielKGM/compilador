package com.danielkgm.compiler.reverse_polish_notation;

public class PolishTranslator {
    public static void main(String[] args) {
        String input = "221+1+332-1-3+2";
        PolishParser p = new PolishParser(input.getBytes());
        p.parse();

    }
}