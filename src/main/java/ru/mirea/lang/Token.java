package ru.mirea.lang;

public class Token {

    final TokenType type;
    final String text;
    final int pos;

    public Token(TokenType type, String text, int pos) {
        this.type = type;
        this.text = text;
        this.pos = pos;
    }
}
