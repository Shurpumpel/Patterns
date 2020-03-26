package com.company;

public class WordExpression implements Expression {
    private String word;

    public WordExpression(String word) {
        this.word = word;
    }

    @Override
    public String interpret() {
        return word;
    }
}
