package com.danielkgm.interpreter;

import com.danielkgm.compiler.reverse_polish_notation.PolishParser;

public class Main {
    public static void main(String[] args) {

        String input = """
                let a = 1 + 1 - 1 + 2 - 3 + 10 + 11;
                let b = 0;
                let c = 5 + 4 + 3 + 2 + 1;
                print a + b + c;
                    """;

        PolishParser p = new PolishParser(input.getBytes());
        p.parse();

        Interpreter i = new Interpreter(p.getOutput());
        i.run();

    }

}
