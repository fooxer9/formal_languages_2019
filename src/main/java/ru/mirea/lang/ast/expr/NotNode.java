package ru.mirea.lang.ast.expr;

public class NotNode extends ExprNode {
   public ExprNode val;
   public NotNode(ExprNode val) { this.val = val;}
}
