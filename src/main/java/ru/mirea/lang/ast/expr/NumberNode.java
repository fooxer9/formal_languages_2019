package ru.mirea.lang.ast.expr;

import org.antlr.v4.runtime.Token;

public class NumberNode extends ExprNode{
    public Token number;

    public NumberNode(Token n) {
        this.number = n;
    }
}
