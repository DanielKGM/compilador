package com.danielkgm.compiler.reverse_polish_notation;

import com.danielkgm.compiler.parser.ParserAbstract;
import com.danielkgm.compiler.parser.scanner.TokenType;

public class PolishParser extends ParserAbstract {

    private final StringBuilder output = new StringBuilder();

    public PolishParser(byte[] input) {
        super(input);
    }

    public String getOutput() {
        return output.toString();
    }

    private void emit(String cmd) {
        output.append(cmd).append(System.lineSeparator());
    }

    void expr() {
        term();
        oper();
    }

    void number() {
        emit("PUSH " + currentToken.getLexeme());
        match(TokenType.NUMBER);
    }

    void term() {
        if (currentToken.getType() == TokenType.NUMBER) {
            number();
        } else if (currentToken.getType() == TokenType.IDENT) {
            emit("PUSH " + currentToken.getLexeme());
            match(TokenType.IDENT);
        } else {
            throw new Error("syntax error");
        }
    }

    void oper() {
        if (currentToken.getType() == TokenType.PLUS) {
            match(TokenType.PLUS);
            term();
            emit("ADD");
            oper();
        } else if (currentToken.getType() == TokenType.MINUS) {
            match(TokenType.MINUS);
            term();
            emit("SUB");
            oper();
        }
    }

    void letStatement() {
        match(TokenType.LET);
        var id = currentToken.getLexeme();
        match(TokenType.IDENT);
        match(TokenType.EQ);
        expr();
        emit("POP " + id);
        match(TokenType.SEMICOLON);
    }

    void printStatement() {
        match(TokenType.PRINT);
        expr();
        emit("PRINT");
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
