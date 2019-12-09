package ru.mirea.lang.ast;

import org.antlr.v4.runtime.Token;

public class PrintNode extends StatementNode {
    public Token val;
    public PrintNode(Token val) { this.val = val;}
}
