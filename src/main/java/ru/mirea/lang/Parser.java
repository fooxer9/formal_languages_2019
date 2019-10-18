package ru.mirea.lang;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private void error(String message) {
        if (pos < tokens.size()) {
            Token t = tokens.get(pos);
            throw new RuntimeException(message + " в позиции " + t.pos);
        } else {
            throw new RuntimeException(message + " в конце файла");
        }
    }

    private Token match(TokenType expected) {
        if (pos < tokens.size()) {
            Token c = tokens.get(pos);
            if (c.type == expected) {
                pos++;
                return c;
            }
        }
        return null;
    }

    private Token require(TokenType expected) {
        Token t = match(expected);
        if (t == null)
            error("Ожидается " + expected);
        return t;
    }

    public List<Token> parse() {
        List<Token> numbers = new ArrayList<>();
        Token n1 = require(TokenType.NUMBER);
        numbers.add(n1);
        while (pos < tokens.size()) {
            require(TokenType.ADD);
            Token n2 = require(TokenType.NUMBER);
            numbers.add(n2);
        }
        return numbers;
    }

    public static int eval(List<Token> program) {
        int sum = 0;
        for (Token t : program) {
            sum += Integer.parseInt(t.text);
        }
        return sum;
    }

    public static void main(String[] args) {
        String text = "10 + 20";
        Lexer l = new Lexer(text);
        List<Token> tokens = l.lex();
        tokens.removeIf(t -> t.type == TokenType.SPACE);
        Parser p = new Parser(tokens);
        List<Token> numbers = p.parse();
        int result = eval(numbers);
        System.out.println(result);
    }
}
