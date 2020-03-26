package com.company;

public class ExtraSpaceExpression implements Expression {
    private Expression left;
    private Expression right;

    public ExtraSpaceExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String interpret() {
        return left.interpret() + right.interpret();
    }
}
