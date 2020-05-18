package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Frame extends JFrame{
    private JFrame frame;
    private ImageInterface image;

    private boolean isImageLoaded = false;

    public Frame(ImageInterface image) {
        this.image = image;
        this.frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        label.setPreferredSize(new Dimension(215,215));
        label.setLayout(null);
        panel.add(label);
        frame.add(panel);
        panel.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && e.getButton() == 3){
                    if(!isImageLoaded) {
                        image.display();
                        ImageIcon icon = ((ProxxyImage) image).getImage().getImage();
                        System.out.println("Panel x = " + panel.getX() + " y = " + panel.getY());
                        System.out.println("Label x = " + label.getX() + " y = " + label.getY());
                        label.setIcon(icon);
                        repaint();
                        System.out.println("Panel x = " + panel.getX() + " y = " + panel.getY());
                    }
                    isImageLoaded = true;
                }
                repaint();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(e.getModifiersEx() == 1024)
                    UpdateLocation(e);
            }


            public void UpdateLocation(MouseEvent e){
                System.out.println("Panel x = " + panel.getX() + " y = " + panel.getY());
                System.out.println("Label x = " + label.getX() + " y = " + label.getY());
                label.setLocation(e.getX()-160, e.getY()-150);
                repaint();
            }
        });
        frame.setVisible(true);
    }


}
