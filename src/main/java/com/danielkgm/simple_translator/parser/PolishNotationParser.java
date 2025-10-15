package com.danielkgm.simple_translator.parser;

public class PolishNotationParser extends ParserAbstract implements ParserInterface {

    public PolishNotationParser(byte[] input) {
        this.input = input;
    }

    private void expr() {
        digit();
        oper();
    }

    private void digit() {
        if (!Character.isDigit(peek())) {
            throw new Error("syntax error");
        }

        System.out.println("push " + peek());
        match(peek());
    }

    private void oper() {
        if (peek() == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (peek() == '-') {
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
