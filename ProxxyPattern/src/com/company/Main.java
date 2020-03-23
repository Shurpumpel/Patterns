package com.company;

public class Main {

    public static void main(String[] args) {
        ImageInterface image = new ProxxyImage("C:\\Users\\alfdt\\Desktop\\Patterns\\ProxxyPattern\\src\\com\\company\\Images\\ezik.jpg");
        Frame frame = new Frame(image);
    }
}
