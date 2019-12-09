package ru.mirea.lang;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import ru.mirea.lang.antlr.ExprLexer;
import ru.mirea.lang.antlr.ExprParser;
import ru.mirea.lang.ast.*;
import ru.mirea.lang.ast.expr.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<StatementNode> convertExpr(List<ExprParser.ExprContext> exprs) {
        List<StatementNode> stList = new ArrayList<>();
        for (ExprParser.ExprContext exp : exprs) {
            StatementNode statementNode = convertStatement(exp);
            stList.add(statementNode);
        }
        return stList;
    }

    private static List<StatementNode> convertProgram(ExprParser.ProgramContext programContext) {
        return convertExpr(programContext.expr());
    }


    private static StatementNode convertStatement(ExprParser.ExprContext expr) {
        if (expr.state_print() != null) {
            if (expr.state_print().ID() != null)
                return new PrintNode(expr.state_print().ID().getSymbol());
        } else if (expr.state_assign() != null) {
            ExprNode val = null;
            VarNode var = null;
            if (expr.state_assign().var != null) {
                var = new VarNode(expr.state_assign().var);
            }
            if (expr.state_assign().val != null) {
                val = convertBin(expr.state_assign().val);
            }
            return new AssignNode(var, val);
        }
        return null;
    }

    static private ExprNode convertBin(ExprParser.BitContext bin) {

        ExprNode left = convertMul(bin.left);
        for (int i = 0; i < bin.right.size(); i++) {
            ExprNode right = convertMul(bin.right.get(i));
            Token op = bin.op.get(i);
            left = new BinOpNode(op, left, right);
        }
        return left;

    }

    public static ExprNode convertValue(ExprParser.ValueContext c) {
        if (c.HEXNUM() != null) {
            return new NumberNode(c.HEXNUM().getSymbol());
        } else if (c.ID() != null) {
            return new VarNode(c.ID().getSymbol());
        } else if (c.value() != null) {
            return new NotNode(convertValue(c.value()));
        } else if (c.bit() != null) {
            return convertBin(c.bit());
        }
        return null;
    }

    public static ExprNode convertMul(ExprParser.OperandContext bin) {
        ExprNode left = convertValue(bin.left);
        for (int i = 0; i < bin.right.size(); i++) {
            ExprNode right = convertValue(bin.right.get(i));
            Token op = bin.op.get(i);
            left = new BinOpNode(op, left, right);
        }
        return left;
    }

    public static void main(String[] args) {
        String sProgram = "a:=1 AND 1 OR 0A AND 0F;b:=NOT 0F; print b; print a;";
        ExprLexer lexer = new ExprLexer(CharStreams.fromString(sProgram));
        ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
        parser.addErrorListener(new ConsoleErrorListener());
        try {
            ExprParser.ProgramContext programContext = parser.program();
            List<StatementNode> program = convertProgram(programContext);
            Interpretator interpretator = new Interpretator();
            Map<String, Integer> varargs = new HashMap<>();
            interpretator.evalProgram(program, varargs);
        } catch (ParseCancellationException e) {
            e.printStackTrace();
        }
    }

}



