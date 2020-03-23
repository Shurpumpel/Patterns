package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame{
    private JFrame frame;
    private ImageInterface image;

    public Frame getFrame() {
        return this;
    }

    public Frame(ImageInterface image) {
        this.image = image;
        this.frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && e.getButton() == 3){
                    image.display();
                }
            }
        });
        frame.setVisible(true);
    }

}
