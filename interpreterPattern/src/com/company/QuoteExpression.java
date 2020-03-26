package com.company;

public class QuoteExpression implements Expression {
    String quote;

    public QuoteExpression(String quote) {
        this.quote = quote;
    }

    @Override
    public String interpret() {
        if(quote.equals("”"))
            return "»";
        else
            return "«";
    }
}
