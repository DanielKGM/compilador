package com.danielkgm.compiler.parser;

import com.danielkgm.compiler.parser.scanner.Scanner;
import com.danielkgm.compiler.parser.scanner.Token;
import com.danielkgm.compiler.parser.scanner.TokenType;

public abstract class ParserAbstract implements ParserInterface {

    protected Scanner scan;
    protected Token currentToken;

    protected ParserAbstract(byte[] input) {
        this.scan = new Scanner(input);
        currentToken = this.scan.nextToken();
    }

    protected void match(TokenType t) {
        if (currentToken.getType() == t) {
            nextToken();
        } else {
            throw new Error("syntax error");
        }
    }

    protected void nextToken() {
        currentToken = scan.nextToken();
    }
}