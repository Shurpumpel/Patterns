package com.company;

public class Main {

    public static void main(String[] args) {
        Context context = new Context();
        Expression expression = context.evaluate("fknjed    flkdn");
        System.out.println(expression.interpret());
    }
}
