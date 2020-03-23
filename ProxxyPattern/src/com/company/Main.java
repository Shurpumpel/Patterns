package com.company;

public class Main {

    public static void main(String[] args) {
        ImageInterface image = new ProxxyImage("src/com/company/Images/krosh.png");
        Frame frame = new Frame(image);
    }
}
