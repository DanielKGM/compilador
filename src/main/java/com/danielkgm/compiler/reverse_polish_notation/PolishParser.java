package com.danielkgm.compiler.reverse_polish_notation;

import com.danielkgm.compiler.parser.ParserAbstract;
import com.danielkgm.compiler.parser.scanner.TokenType;

import java.util.ArrayList;
import java.util.List;

public class PolishParser extends ParserAbstract {

    private final List<String> output = new ArrayList<>();

    public PolishParser(byte[] input) {
        super(input);
    }

    public List<String> output() {
        return output;
    }

    void expr() {
        term();
        oper();
    }

    void number() {
        output.add("push " + currentToken.getLexeme());
        match(TokenType.NUMBER);
    }

    void term() {
        if (currentToken.getType() == TokenType.NUMBER) {
            number();
        } else if (currentToken.getType() == TokenType.IDENT) {
            output.add("push " + currentToken.getLexeme());
            match(TokenType.IDENT);
        } else {
            throw new Error("syntax error");
        }
    }

    void oper() {
        if (currentToken.getType() == TokenType.PLUS) {
            match(TokenType.PLUS);
            term();
            output.add("add");
            oper();
        } else if (currentToken.getType() == TokenType.MINUS) {
            match(TokenType.MINUS);
            term();
            output.add("sub");
            oper();
        }
    }

    void letStatement() {
        match(TokenType.LET);
        var id = currentToken.getLexeme();
        match(TokenType.IDENT);
        match(TokenType.EQ);
        expr();
        output.add("pop " + id);
        match(TokenType.SEMICOLON);
    }

    void printStatement() {
        match(TokenType.PRINT);
        expr();
        output.add("print");
        match(TokenType.SEMICOLON);
    }

    void statement() {
        if (currentToken.getType() == TokenType.PRINT) {
            printStatement();
        } else if (currentToken.getType() == TokenType.LET) {
            letStatement();
        } else {
            throw new Error("syntax error");
        }
    }

    void statements() {
        while (currentToken.getType() != TokenType.EOF) {
            statement();
        }
    }

    @Override
    public void parse() {
        statements();
    }
}
