package com.danielkgm.compiler.parser;

public class PolishNotationParser extends ParserAbstract implements ParserInterface {

    public PolishNotationParser(byte[] input) {
        super(input);
    }

    private void expr() {
        digit();
        oper();
    }

    void digit() {

        if (!Character.isDigit(currentToken)) {
            throw new Error("syntax error");
        }

        System.out.println("push " + currentToken);
        match(currentToken);

    }

    void oper() {
        if (currentToken == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (currentToken == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }

    @Override
    public void parse() {
        expr();
    }

}
