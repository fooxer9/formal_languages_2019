package ru.mirea.lang.ast.expr;

import org.antlr.v4.runtime.Token;
import ru.mirea.lang.ast.expr.ExprNode;

public class VarNode extends ExprNode {
    public Token id;

    public VarNode(Token id) {
        this.id = id;
    }
}
