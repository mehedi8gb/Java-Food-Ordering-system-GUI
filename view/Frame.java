package view;

import javax.swing.*;
import view.pages.MainMenu;

public class Frame extends JFrame {
    
    public static MainMenu Menu;
    public static JFrame MainFrame;

    public Frame() {
        MainFrame = this;
        Menu = new MainMenu();
        Menu.setVisible(true);
        getContentPane().add(Menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Restuarent Food Ordering System");
        setFocusable(false);
        pack();
        setVisible(true);

    }
}
