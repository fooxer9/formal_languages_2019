package ru.mirea.lang;

public abstract class ExprNode {
}

class NumberNode extends ExprNode{
    Token number;

    public NumberNode(Token n) {
        this.number = n;
    }
}

class VarNode extends ExprNode{
    Token id;

    public VarNode(Token id) {
        this.id = id;
    }
}
class BinOpNode extends ExprNode {
    Token op;
    ExprNode left;
    ExprNode right;

    public BinOpNode(Token op, ExprNode e1, ExprNode e2) {
        this.op = op;
        this.left = e1;
        this.right = e2;
    }
}
