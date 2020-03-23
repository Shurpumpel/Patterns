package com.company;

import javax.swing.*;

public class RealImage implements ImageInterface {
    private String file;
    public ImageIcon getImage() {
        return image;
    }
    private ImageIcon image;

    public RealImage(String file) {
        this.file = file;
        this.load();
    }

    @Override
    public void display() {
        System.out.println("Просмотр");
    }

    public void load(){
        System.out.println("Загрузка");
        image = new ImageIcon(file);

    }

}
