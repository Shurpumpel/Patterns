package com.company;

import javax.swing.*;

public class ProxxyImage implements ImageInterface {
    private String file;
    private RealImage image;

    public RealImage getImage() {
        return image;
    }
    public ProxxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if(image == null){
            this.image = new RealImage(file);
        }
        image.display();
    }
}
