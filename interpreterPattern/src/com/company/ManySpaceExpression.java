package com.company;

public class ManySpaceExpression implements Expression {
    private Expression left;
    private Expression right;

    public ManySpaceExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String interpret() {
        return left.interpret() + right.interpret();
    }
}
