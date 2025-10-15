package com.danielkgm.compiler.parser;

import com.danielkgm.compiler.parser.scanner.Scanner;

public abstract class ParserAbstract {

    protected Scanner scan;
    protected char currentToken;

    protected ParserAbstract(byte[] input) {
        scan = new Scanner(input);
        currentToken = scan.nextToken();
    }

    protected void match(char t) {

        if (currentToken != t) {
            throw new Error("syntax error");
        }

        nextToken();
    }

    protected void nextToken() {
        currentToken = scan.nextToken();
    }
}