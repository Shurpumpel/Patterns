package com.company;

public class DefisExpression implements Expression {
    private Expression left;
    private Expression right;

    public DefisExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String interpret() {
        return left.interpret() + "—"+ right.interpret();
    }
}
