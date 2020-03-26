package com.company;

public class ExtraEnterExpression implements Expression {
    private Expression left;
    private Expression right;

    public ExtraEnterExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public String interpret() {
        return left.interpret() + right.interpret();
    }
}
