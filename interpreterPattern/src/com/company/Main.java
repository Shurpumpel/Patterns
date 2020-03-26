package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String text = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/company/TextFile"));
            int ch;
            while((ch = reader.read()) != -1) {
                if((char)ch == '\r')
                    continue;
                text += (char) ch;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Context context = new Context();
        Expression expression = context.evaluate(text);
        System.out.println("Введенный текст:");
        System.out.println(text);
        System.out.println("********************************************");
        System.out.println("Исправленный текст:");
        System.out.println(expression.interpret());
    }
}
