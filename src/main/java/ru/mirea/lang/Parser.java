package ru.mirea.lang;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private void error(String message) {
        if (pos < tokens.size()) {
            Token t = tokens.get(pos);
            throw new RuntimeException(message + " в позиции " + t.pos);
        } else {
            throw new RuntimeException(message + " в конце файла");
        }
    }

    private Token match(TokenType expected) {
        if (pos < tokens.size()) {
            Token c = tokens.get(pos);
            if (c.type == expected) {
                pos++;
                return c;
            }
        }
        return null;
    }

    private Token require(TokenType expected) {
        Token t = match(expected);
        if (t == null)
            error("Ожидается " + expected);
        return t;
    }

    public ExprNode elem() {
        Token n = match(TokenType.NUMBER);
        if (n != null)
            return new NumberNode(n);
        Token id = match (TokenType.ID);
        if (id != null)
            return new VarNode(id);
        error("Ожидается число или переменная");
        return null;
    }
    public ExprNode mnozh() {

        if ((match(TokenType.OPEN_BRACKET)) != null)  {
            ExprNode e = parse();
            require(TokenType.CLOSE_BRACKET);
            return e;
        }
        else {
            return elem();
        }
    }
    public ExprNode slag() {
        ExprNode e1 = mnozh();
        Token op;
        while (((op=match(TokenType.MUL)) != null) ||  ((op=match(TokenType.DIV)) != null)) {
            ExprNode e2 = mnozh();
            BinOpNode e0 = new BinOpNode(op,e1,e2);
            e1 = e0;
        }
        return e1;
    }

    public ExprNode parse() { // теперь Expr
        ExprNode e1 = slag();
        Token op;
        //while (pos < tokens.size()) { // exist '+'
        while (((op = match(TokenType.ADD)) != null) || ((op = match(TokenType.MINUS)) != null))  {
            ExprNode e2 = slag();
            BinOpNode e0  = new BinOpNode(op, e1, e2);
            e1 = e0;
        }
        return e1;
    }

    public static int eval(ExprNode n) {
        if (n instanceof NumberNode) {
            NumberNode nn = (NumberNode) n;
            return Integer.parseInt(nn.number.text);
        } else if (n instanceof BinOpNode) {
            BinOpNode bon = (BinOpNode) n;
            int l = eval(bon.left);
            int r = eval(bon.right);
            if (bon.op.type == TokenType.ADD)
                return l+r;
            else if (bon.op.type == TokenType.MUL)
                return l*r;
            else if (bon.op.type == TokenType.DIV)
                return l/r;
            else if (bon.op.type == TokenType.MINUS)
                return l-r;
        } else if (n instanceof VarNode){
            VarNode vn = (VarNode) n;
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        String text = "1 + (2+2)*2 - 4/2";
        Lexer l = new Lexer(text);
        List<Token> tokens = l.lex();
        tokens.removeIf(t -> t.type == TokenType.SPACE);
        for (Token t: tokens) {
            System.out.println(t.type + " " + t.text);
        }
        Parser p = new Parser(tokens);
        int result = eval(p.parse());
        System.out.println(result);
    }
}
