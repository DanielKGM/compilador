package com.danielkgm.compiler.parser;

import com.danielkgm.compiler.parser.scanner.Scanner;
import com.danielkgm.compiler.parser.scanner.Token;

public abstract class ParserAbstract implements ParserInterface {

    protected Scanner scan;
    protected Token currentToken;

    protected ParserAbstract(byte[] input, Scanner scan) {
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