package ru.mirea.lang.ast.expr;

import org.antlr.v4.runtime.Token;

public class BinOpNode extends ExprNode {
   public Token op;
   public  ExprNode left;
   public ExprNode right;

    public BinOpNode(Token op, ExprNode e1, ExprNode e2) {
        this.op = op;
        this.left = e1;
        this.right = e2;
    }
}
