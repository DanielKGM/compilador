package com.danielkgm.compiler.reverse_polish_notation;

import com.danielkgm.compiler.parser.ParserAbstract;
import com.danielkgm.compiler.parser.scanner.TokenType;

public class PolishParser extends ParserAbstract {

    public PolishParser(byte[] input) {
        super(input);
    }

    void expr() {
        number();
        oper();
    }

    void number() {
        System.out.println("push " + currentToken.getLexeme());
        match(TokenType.NUMBER);
    }

    void oper() {
        if (currentToken.getType() == TokenType.PLUS) {
            match(TokenType.PLUS);
            number();
            System.out.println("add");
            oper();
        } else if (currentToken.getType() == TokenType.MINUS) {
            match(TokenType.MINUS);
            number();
            System.out.println("sub");
            oper();
        }
    }

    @Override
    public void parse() {
        expr();
    }

}
