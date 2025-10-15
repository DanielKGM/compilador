package com.danielkgm.compiler.reverse_polish_notation;

import com.danielkgm.compiler.parser.ParserAbstract;
import com.danielkgm.compiler.parser.scanner.TokenType;

public class PolishParser extends ParserAbstract {

    public PolishParser(byte[] input) {
        super(input);
    }

    void expr() {
        term();
        oper();
    }

    void number() {
        System.out.println("push " + currentToken.getLexeme());
        match(TokenType.NUMBER);
    }

    void term() {
        if (currentToken.getType() == TokenType.NUMBER)
            number();
        else if (currentToken.getType() == TokenType.IDENT) {
            System.out.println("push " + currentToken.getLexeme());
            match(TokenType.IDENT);
        } else
            throw new Error("syntax error");
    }

    void oper() {
        if (currentToken.getType() == TokenType.PLUS) {
            match(TokenType.PLUS);
            term();
            System.out.println("add");
            oper();
        } else if (currentToken.getType() == TokenType.MINUS) {
            match(TokenType.MINUS);
            term();
            System.out.println("sub");
            oper();
        }
    }

    void letStatement() {
        match(TokenType.LET);
        var id = currentToken.getLexeme();
        match(TokenType.IDENT);
        match(TokenType.EQ);
        expr();
        System.out.println("pop " + id);
        match(TokenType.SEMICOLON);
    }

    @Override
    public void parse() {
        letStatement();
    }

}
