package com.company;

public class Context {


    Expression evaluate(String str){
        int pos = str.length()-1;
        String result = "";
        char nextSymbol = 0;
        pos = 0;
        while(pos < str.length()){
            if(pos != str.length()-1)
                nextSymbol = str.charAt(pos + 1);
            else
                nextSymbol = 0;

            String symbolsOfExpression = " (-“”\n";
            if(symbolsOfExpression.contains(String.valueOf(str.charAt(pos)))) {
                Expression left = new WordExpression(str.substring(0, pos));
                Expression right = evaluate(str.substring(pos + 1, str.length()));
                switch (str.charAt(pos)) {
                    case ' ':
                        String dots = " ,.)!?";
                        if (dots.contains(String.valueOf(nextSymbol))) {
                            return new ExtraSpaceExpression(left, right);
                        }
                    case '(':
                        if (nextSymbol == ' ') {

                            return new ExtraSpaceExpression(left, right);
                        }
                    case '-':
                        if (nextSymbol == ' ') {
                            return new DefisExpression(left, right);
                        }
                    case '”':
                        return new QuoteExpression(left, right, String.valueOf(str.charAt(pos)));
                    case '“':
                        return new QuoteExpression(left, right, String.valueOf(str.charAt(pos)));
                    case '\n':
                        if(nextSymbol == '\n'){
                            return new ExtraEnterExpression(left, right);
                        }
                }
            }
            pos++;

        }
        return new WordExpression(str);
    }
}
