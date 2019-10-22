package ru.mirea.lang;

import java.util.regex.Pattern;

public enum TokenType {
    ID ("[a-zA-Z]"),
    NUMBER("[0-9]+"),
    ADD("\\+"),
    SPACE("[ \t\r\n]+");

    final Pattern pattern;

    TokenType(String regexp) {
        pattern = Pattern.compile(regexp);
    }
}
