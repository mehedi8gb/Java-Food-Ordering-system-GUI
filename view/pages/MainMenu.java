package view.pages;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import orders.Orders;
import view.Frame;

public class MainMenu extends JPanel {
    // Variables declaration

    private File ordrData = new File("H:\\java\\Food Ordering system\\files\\Orders.txt");
    private javax.swing.JButton Exit;
    private javax.swing.JButton FoodMenu;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel MainMenuBG;
    private javax.swing.JButton Orders;
    private javax.swing.JLabel jLabel4;
    // Variables declaration END

    // All Frames and Panels Objects
    private Orders orders;
    private FoodMenu FMenu; 

    public MainMenu() {
        FMenu = new FoodMenu();
        orders = new Orders();
        FoodMenu = new javax.swing.JButton();
        Orders = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Header = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MainMenuBG = new javax.swing.JLabel();

        setPreferredSize(new Dimension(1280, 720));
        setLayout(null);

        FoodMenu.setIcon(new ImageIcon(getClass().getResource("/images/place order.png")));
        FoodMenu.setText("Food Menu");
        FoodMenu.setFocusable(false);
        FoodMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FoodMenuActionPerformed(e);
            }
        });
        add(FoodMenu);
        FoodMenu.setBounds(520, 160, 240, 50);

        Orders.setIcon(new ImageIcon(getClass().getResource("/images/View Bills & Order Placed Details.png")));
        Orders.setText("Orders");
        Orders.setFocusable(false);
        Orders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrdersActionPerformed(e);
            }
        });
        add(Orders);
        Orders.setBounds(520, 230, 240, 50);
        
        Exit.setIcon(new ImageIcon(getClass().getResource("/images/exit.png"))); 
        Exit.setText("Exit");
        Exit.setFocusable(false);
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExitActionPerformed(e);
            }
        });
        add(Exit);
        Exit.setBounds(520, 300, 240, 50);

        Header.setBackground(new Color(51, 51, 51));
        Header.setLayout(null);

        jLabel4.setFont(new Font("Gadugi", 1, 18)); 
        jLabel4.setForeground(new Color(204, 204, 255));
        jLabel4.setText("Main Menu");
        Header.add(jLabel4);
        jLabel4.setBounds(610, 40, 120, 40);

        add(Header);
        Header.setBounds(-20, -30, 1300, 90);

        MainMenuBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pureBG.png"))); 
        MainMenuBG.setText("jLabel1");
        add(MainMenuBG);
        MainMenuBG.setBounds(0, 0, 1280, 770);

    }

    private void FoodMenuActionPerformed(ActionEvent e) {
        setVisible(false);
        FMenu.setVisible(true);
        Frame.MainFrame.add(FMenu);

    }

    private void OrdersActionPerformed(ActionEvent e) {
        try {                                         
            setVisible(false);
            orders.setVisible(true);
            Frame.MainFrame.add(orders);
            String [] values;
            String line; 

//   getting data from file 
            Scanner inputBuffer = new Scanner(ordrData);
            try {
                    while (inputBuffer.hasNext()) {
                    line = inputBuffer.nextLine();
                    values = line.split(",");
                    
 // order checking condition 
            if (values[4].equals("pending") && values[1].equals("Burger")) {
                orders.getItemPanel1().setVisible(true);
                orders.getOrderNo1().setText(values[0]);
                orders.getFoodName1().setText(values[1]);
                orders.getPrice1().setText(values[2]+"$");
                orders.getQty1().setText(values[3]+" piece");
                orders.getOrderStatus1().setText(values[4]);
                orders.getEstimedtedProccessingTime1().setText(values[5]);
                System.out.println(values[0]+" showable");
            } else {
                orders.getItemPanel1().setVisible(true);
                System.out.println(values[0]);
            }
            
//            pizza component
     if (values[4].equals("pending") && values[1].equals("Pizza")) {
                orders.getItemPanel2().setVisible(true);
                orders.getOrderNo2().setText(values[0]);
                orders.getFoodName2().setText(values[1]);
                orders.getPrice2().setText(values[2]+"$");
                orders.getQty2().setText(values[3]+" piece");
                orders.getOrderStatus2().setText(values[4]);
                orders.getEstimedtedProccessingTime2().setText(values[5]);
                System.out.println(values[0]+" showable");
            } else {
                orders.getItemPanel2().setVisible(true);
                System.out.println(values[0]);
            }
                    
                }
            }
            
            catch (Exception ev) {
                ev.printStackTrace();
            }
            inputBuffer.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private void ExitActionPerformed(ActionEvent e) {
       
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        processBuilder.command("cmd.exe", "/c", "cls && delclass.bat");

        try {
            processBuilder.start();
            System.out.println("All genareted Class files cleared!");
        } catch (IOException ev) {
            ev.printStackTrace();
        } 
      System.exit(0);
    }

}
