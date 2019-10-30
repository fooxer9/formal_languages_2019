package ru.mirea.lang;

import java.util.regex.Pattern;

public enum TokenType {
    ID ("[a-zA-Z]"),
    NUMBER("[0-9]+"),
    ADD("\\+"),
    MUL("\\*"),
    MINUS("-"),
    DIV("/"),
    SPACE("[ \t\r\n]+"),
    OPEN_BRACKET("\\("),
    CLOSE_BRACKET("\\)");

    final Pattern pattern;

    TokenType(String regexp) {
        pattern = Pattern.compile(regexp);
    }
}
