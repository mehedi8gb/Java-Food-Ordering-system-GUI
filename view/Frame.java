package view;

import javax.swing.*;
import orders.*;
import view.pages.MainMenu;

 
public class Frame extends JFrame {
public static MainMenu Menu;
public static String tabelNo = "5";

public static JFrame MainFrame;

    public  Frame() {
        MainFrame = this;
        Menu = new MainMenu();
        Orders.setMainMenuRef(Menu);
        Menu.setVisible(true);
        
        getContentPane().add(Menu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Restuarent Food Ordering System");
        setFocusable(false);

        pack();
        setVisible(true);
        
    }
}
