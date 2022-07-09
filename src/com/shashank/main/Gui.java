package com.shashank.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui implements ActionListener {
    private int clicks = 0;
    private JLabel label = new JLabel("Temp:                     ");

    private JLabel label1 = new JLabel("Humidity:                 ");

    private JLabel label2 = new JLabel("Wind Speed:                 ");

    private JLabel label3 = new JLabel("Wind Angle:                 ");

    private JTextField  text  =new JTextField(" ");


    private JFrame frame = new JFrame();

    public Gui() {
        ImagePanel kpanel = new ImagePanel(
                new ImageIcon("img.png").getImage());
        frame.getContentPane().add(kpanel);
        frame.pack();
        frame.setVisible(true);
        // the clickable button
        JButton button = new JButton("Find");
        button.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(text);
        panel.add(button);
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Weather App");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        String location = text.getText();



        weatherapprunner.api(location);




          label.setText( Info.temp);

          label1.setText( Info.hum);

         label2.setText(Info.ws);

         label3.setText(Info.wa);

    }

    // create one Frame
    public static void main(String[] args) {
        new Gui();
    }
}class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}
