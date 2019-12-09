package ru.mirea.lang;

import org.antlr.v4.runtime.Token;
import ru.mirea.lang.ast.*;
import ru.mirea.lang.ast.expr.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Interpretator {

    public void evalProgram(List<StatementNode> program, Map<String, Integer> varargs ) {
        for (StatementNode s: program) evalStatement(s,varargs);
    }

    public int getVar(Token id, Map<String,Integer> varargs) {
        Integer id_value = varargs.get(id.getText());
        if (id_value == null) {
            System.out.println("Please enter value of " + id.getText());
            Scanner in = new Scanner(System.in);
            id_value = in.nextInt();
        }
        return id_value;
    }

    public void evalStatement(StatementNode statement, Map <String, Integer> varargs) {
        if (statement instanceof PrintNode) { // handle 'print ID'
            PrintNode printNode = (PrintNode) statement;
            int id_val = getVar(printNode.val,varargs);
            String hex = Integer.toHexString(id_val);
            System.out.println(hex);
        }
        else if (statement instanceof AssignNode) { // handle assign
            AssignNode assignNode = (AssignNode) statement;
            VarNode var = assignNode.val;
            if (assignNode.assign instanceof NumberNode) { // ID := NUMBER
                NumberNode nn = (NumberNode) assignNode.assign;
                int assign = toHex(nn.number.getText());
                varargs.put(var.id.getText(),assign);
            } else if
            (assignNode.assign instanceof VarNode) { //ID := VAR
                VarNode vn = (VarNode) assignNode.assign;
                int assign = getVar(vn.id,varargs);
                varargs.put(var.id.getText(),assign);
            }
            else { // ID := bin_expr or not_expr
                //System.out.println("GO TO EVAL EXPR");
                int result = evalExpr(assignNode.assign, varargs);
                varargs.put(var.id.getText(),result);
            }
        }
    }

    public int evalExpr(ExprNode node, Map <String, Integer> varargs) {
        if (node instanceof VarNode) { // just var inside the bin
            VarNode varNode = (VarNode) node;
            return getVar(varNode.id,varargs);
        }
        else if (node instanceof NumberNode) { // just num inside the bin
            NumberNode numberNode = (NumberNode) node;
            return toHex(numberNode.number.getText());
        }
        else if (node instanceof NotNode) { // handle NOT id's
            NotNode notNode = (NotNode) node;
            if (notNode.val instanceof VarNode) {
                //System.out.println("NOTNODE VAR");
                VarNode notVal = (VarNode) notNode.val;
                int id_value = getVar(notVal.id, varargs);
                id_value = ~id_value;
                varargs.put(notVal.id.getText(), id_value);
                return id_value;
            } else if
            (notNode.val instanceof NumberNode) { // handle NOT just numbers
                //System.out.println("NOTNODE NUM");
                NumberNode nn = (NumberNode) notNode.val;
                int notnn = toHex(nn.number.getText());
                //System.out.println(notnn);
                return ~notnn;
                //System.out.println(notnn);
            } else if
            (notNode.val instanceof BinOpNode) { //handle NOT Bin Oper
                //System.out.println("NOT NODE BIN");

                BinOpNode binOpNode = (BinOpNode) notNode.val;
                return evalBin(binOpNode, varargs);
            }
        } else if (node instanceof BinOpNode) { // handle BinOper
            //System.out.println("BIN OP");
            BinOpNode binOpNode = (BinOpNode) node;
            return evalBin(binOpNode,varargs);
        }
        return 0;
    }

    public int evalBin(BinOpNode binOpNode,  Map <String,Integer> varargs) {
        int l = evalExpr(binOpNode.left,varargs);
        int r = evalExpr(binOpNode.right,varargs);
        //System.out.println(binOpNode.op.getText());
        if (binOpNode.op.getText().equals("AND")) {
            return l & r;
        } else if (binOpNode.op.getText().equals("OR")) {
            return l | r;
        } else if (binOpNode.op.getText().equals("XOR")) {
            return l^r;
        }
        return 0;

    }

    public int toHex (String sHex) {
        int decimal = Integer.parseInt(sHex,16);
        return decimal;
    }
}
