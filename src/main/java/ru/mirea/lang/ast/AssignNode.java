package ru.mirea.lang.ast;

import ru.mirea.lang.ast.expr.VarNode;
import ru.mirea.lang.ast.expr.ExprNode;

public class AssignNode extends StatementNode {
    public VarNode val;
    public ExprNode assign;

    public AssignNode(VarNode val, ExprNode assign) {
        this.val = val;
        this.assign = assign;
    }
}
