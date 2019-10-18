package ru.mirea.lang;

public class ParserExample {

    private final char[] symbols;
    private int pos = 0;

    public ParserExample(char[] symbols) {
        this.symbols = symbols;
    }

    private void error(String message) {
        throw new RuntimeException(message + " в позиции " + pos);
    }

    private boolean match(char expected) {
        if (pos < symbols.length) {
            char c = symbols[pos];
            if (c == expected) {
                pos++;
                return true;
            }
        }
        return false;
    }

    private void require(char c) {
        if (!match(c))
            error("Ожидается " + c);
    }

    public void parse() {
        require('Ч');
        while (pos < symbols.length) {
            require('+');
            require('Ч');
        }
    }

    public static void main(String[] args) {
        String text = "Ч+Ч";
        ParserExample p = new ParserExample(text.toCharArray());
        p.parse();
    }
}
