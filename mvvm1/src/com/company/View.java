package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    static ViewModel viewModel = new ViewModel();
    public static void main(String[] args) {
        JFrame frame = getFrame();
        JPanel framePanel = getFramePanel();
        frame.add(framePanel);
    }

    static JFrame getFrame(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2-250, dimension.height/2-150, 600,400);
        frame.setTitle("My Frame");
        return frame;
    }

    static JPanel getFramePanel(){
        JPanel framePanel = new JPanel();
        framePanel.setLayout(new BorderLayout());

        JTextArea list = new JTextArea();
        list.setText(viewModel.createStringWithValues());
        list.setBorder(BorderFactory.createTitledBorder("Значения(через пробел)"));
        list.setEditable(false);
        framePanel.add(list, BorderLayout.CENTER);

        JTextField sumField = new JTextField("150");
        sumField.setEditable(false);
        JPanel sumLabelPanel = new JPanel();
        sumLabelPanel.add(new JLabel("Количество удаленных:"));
        JTextField countField = new JTextField("150");
        sumField.setEditable(false);
        sumLabelPanel.add(countField);
        sumLabelPanel.add(new JLabel(";"));
        sumLabelPanel.add(new JLabel("Сумма удаленных"));
        sumLabelPanel.add(sumField);
        countField.setText(viewModel.getCount());
        sumField.setText(viewModel.getSum());
        framePanel.add(sumLabelPanel, BorderLayout.SOUTH);

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        framePanel.add(eastPanel, BorderLayout.EAST);
        eastPanel.add(new JLabel("Удалить число:"));
        JTextArea toRemove = new JTextArea();
        toRemove.setBorder(BorderFactory.createLineBorder(Color.gray));
        eastPanel.add(toRemove);
        JButton removeButton = new JButton("Удалить");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModel.removeValue(toRemove.getText());
                list.setText(viewModel.createStringWithValues());
                countField.setText(viewModel.getCount());
                sumField.setText(viewModel.getSum());
            }
        });
        JPanel removeButtonPanel = new JPanel();
        removeButtonPanel.add(removeButton);
        eastPanel.add(removeButtonPanel);

        JPanel northPanel = new JPanel();
        framePanel.add(northPanel, BorderLayout.NORTH);
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        northPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        northPanel.add(new JLabel("Добавить число: "));
        JTextField toInsert = new JTextField();
        toInsert.setBorder(BorderFactory.createLineBorder(Color.gray));
        northPanel.add(toInsert);
        JButton insertButton = new JButton("Добавить");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModel.addValue(toInsert.getText());
                list.setText(viewModel.createStringWithValues());
            }
        });
        northPanel.add(insertButton);


        return framePanel;
    }
}
