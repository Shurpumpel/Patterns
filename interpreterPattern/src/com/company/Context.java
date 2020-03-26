package com.company;

public class Context {
    Expression evaluate(String str){
        int pos = str.length()-1;
        String result = "";

        while(pos > 0){
            if(str.charAt(pos) != ' '){
                pos--;
            }else{
                Expression left = evaluate(str.substring(0, pos));
                Expression right = evaluate(str.substring(pos + 1, str.length()));
                pos--;
                if(right.interpret().equals(""))
                    return new ManySpaceExpression(left, right);
            }

        }
        return new WordExpression(result);
    }
}
