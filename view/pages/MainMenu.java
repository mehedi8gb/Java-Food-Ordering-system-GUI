package view.pages;

import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import orders.LoginForm;
import orders.Orders;
import orders.paymentForm;
import view.Frame;


public class MainMenu extends JPanel {

    private File ordrData = new File(System.getProperty("user.dir")+"\\files\\Orders.txt");
    
//    All Frames and Panels Objects 
   public static paymentForm PF;
   public static Orders order;
   public static FoodMenu FMenu;
   public static LoginForm LF;
    

   
   private JButton Exit;
   private JButton FoodMenu;
   private JPanel Header;
   private JLabel MainMenuBG;
   private JButton OrdersBtn;
   private JLabel MenuLebel;
   
    public MainMenu() {
        order = new Orders();
        PF = new paymentForm();
        FMenu = new FoodMenu();
        LF = new LoginForm();
        
        order.setPaymentForm(PF);
        FMenu.setPaymentForm(PF);
        LF.setPaymentForm(PF);
        PF.setPaymentFormAndOrderObj(order, LF, FMenu);
       
         
        FoodMenu = new JButton();
        OrdersBtn = new JButton();
        Exit = new JButton();
        Header = new JPanel();
        MenuLebel = new JLabel();
        MainMenuBG = new JLabel();

        setPreferredSize(new Dimension(1280, 720));
        setLayout(null);

        FoodMenu.setIcon(new ImageIcon(getClass().getResource("/test/images/place order.png"))); 
        FoodMenu.setText("Food Menu");
        FoodMenu.setFocusable(false);
        FoodMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FoodMenuActionPerformed(evt);
            }
        });
        add(FoodMenu);
        FoodMenu.setBounds(520, 160, 240, 50);

        OrdersBtn.setIcon(new ImageIcon(getClass().getResource("/test/images/View Bills & Order Placed Details.png"))); 
        OrdersBtn.setText("Orders");
        OrdersBtn.setFocusable(false);
        OrdersBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                OrdersBtnActionPerformed(evt);
            }
        });
        add(OrdersBtn);
        OrdersBtn.setBounds(520, 230, 240, 50);

        Exit.setIcon(new ImageIcon(getClass().getResource("/test/images/exit.png"))); 
        Exit.setText("Exit");
        Exit.setFocusable(false);
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        add(Exit);
        Exit.setBounds(520, 300, 240, 50);

        Header.setBackground(new Color(51, 51, 51));
        Header.setLayout(null);

        MenuLebel.setFont(new Font("Gadugi", 1, 18)); 
        MenuLebel.setForeground(new Color(204, 204, 255));
        MenuLebel.setText("Main Menu");
        Header.add(MenuLebel);
        MenuLebel.setBounds(610, 40, 120, 40);

        add(Header);
        Header.setBounds(-20, -30, 1300, 90);

        MainMenuBG.setIcon(new ImageIcon(getClass().getResource("/test/images/pureBG.png"))); 
        MainMenuBG.setText("jLabel1");
        add(MainMenuBG);
        MainMenuBG.setBounds(0, 0, 1280, 770);
        
        
    }


    private void FoodMenuActionPerformed(ActionEvent evt) {
        setVisible(false);
        FMenu.setVisible(true);
        Frame.MainFrame.add(FMenu);
        
    }

    private void OrdersBtnActionPerformed(ActionEvent evt) {
            setVisible(false);
            order.setVisible(true);
            order.orderPageLogic();
            order.updateTotalInfoPanel();
            Frame.MainFrame.add(order);
            getOrderDatas();
            
            
    }

    private void ExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
 
    public void getOrderDatas(){
//  if(Orders.Auth){
  
        try {  
//   getting data from file 
            Scanner inputBuffer = new Scanner(ordrData);
            String line;
            Double BurgerCost = 0.0, PizzaCost = 0.0;
            Integer BurgerQty = 0, PizzaQty = 0;
                    while (inputBuffer.hasNext()) {
                    line = inputBuffer.nextLine();
                    String [] values = line.split(",");
                    
 // order checking condition 
            if (values[5].equals("pending") && values[1].equals("Burger")) {
                BurgerCost += Double.parseDouble(values[2]);
                BurgerQty += Integer.parseInt(values[3]);
                String pis = (BurgerQty > 1) ? " Pieces" : " Piece";
                order.getItemPanel1().setVisible(true);
                order.getOrderNo1().setText(values[0]);
                order.getFoodName1().setText(values[1]);
                order.getPrice1().setText(BurgerCost+" BDT");
                order.getQty1().setText(BurgerQty+pis);
                order.getOrderStatus1().setText(values[5]);
                order.getEstimedtedProccessingTime1().setText(values[6]);
                System.out.println(values[0]+" showable");
            } 
            if(!Orders.Auth){
                order.getItemPanel2().setVisible(true);
                System.out.println("Order ID:"+values[0]);
            }
            
//            pizza component
     if (values[5].equals("pending") && values[1].equals("Pizza")) {
                PizzaCost += Double.parseDouble(values[2]);
                PizzaQty += Integer.parseInt(values[3]);
                String pis = (PizzaQty > 1) ? " Pieces" : " Piece";
                order.getItemPanel2().setVisible(true);
                order.getOrderNo2().setText(values[0]);
                order.getFoodName2().setText(values[1]);
                order.getPrice2().setText(PizzaCost+" BDT");
                order.getQty2().setText(PizzaQty+pis);
                order.getOrderStatus2().setText(values[5]);
                order.getEstimedtedProccessingTime2().setText(values[6]);
                System.out.println(values[0]+" showable");
            } 
                if(!Orders.Auth){
                order.getItemPanel2().setVisible(true);
                System.out.println("Order ID:"+values[0]);
            }
      
            order.setItemAllInfos(BurgerCost, PizzaCost, BurgerQty, PizzaQty);
                }
        } catch (FileNotFoundException ex) {
            System.out.println("getOrderDatas() "+ex);
        }
      
//  }
    }

}
