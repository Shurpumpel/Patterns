package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Frame extends JFrame{
    private JFrame frame;
    private ImageInterface image;
    private int prevX;
    private int prevY;

    public Frame(ImageInterface image) {
        this.image = image;
        this.frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        label.setPreferredSize(new Dimension(215,215));
        panel.add(label);
        frame.add(panel);
        frame.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && e.getButton() == 3){
                    image.display();
                    ImageIcon icon = ((ProxxyImage)image).getImage().getImage();
                    System.out.println("Panel x = " + panel.getX() + " y = " + panel.getY());
                    System.out.println("Label x = " + label.getX() + " y = " + label.getY());
                    label.setIcon(icon);
                    System.out.println("Panel x = " + panel.getX() + " y = " + panel.getY());
                    frame.repaint();
                }
            }
        });

        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if(e.getModifiersEx() == 1024)
                    UpdateLocation(e);
            }


            public void UpdateLocation(MouseEvent e){
                System.out.println("Panel x = " + panel.getX() + " y = " + panel.getY());
                panel.setLocation(e.getX()-350, e.getY()-150);
                repaint();
            }
        });
        frame.setVisible(true);
    }


}
