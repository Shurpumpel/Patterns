package com.company;

public class QuoteExpression implements Expression {
    private Expression left;
    private Expression right;
    private String quote;

    public QuoteExpression(Expression left, Expression right, String quote) {
        this.left = left;
        this.right = right;
        this.quote = quote;
    }

    @Override
    public String interpret() {
        if(quote.equals("”"))
            return left.interpret() + "»" + right.interpret();
        if (quote.equals("“"))
            return left.interpret() + "«" + right.interpret();
        return left.interpret() + quote + right.interpret();
    }
}
