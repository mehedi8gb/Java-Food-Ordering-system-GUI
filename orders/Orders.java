package orders;

import Clock.Clock;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import view.Frame;

public class Orders extends JPanel {

   private Color defaultColor = new Color(255,255,255);
   private Color clickedColor = new Color(139,161,205);
   private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a"); 
   private Calendar cal = Calendar.getInstance();
   protected String EstimetedTIME;
   protected String TIME;
   private double total;
   private int quantity;
   private int TabbedPanelIndex;  
   private File orders = new File("H:\\java\\Food Ordering system\\files\\Orders.txt");
   

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private JButton BackBtn;
   private JButton CanceledBtn;
   private JLabel CancelledOrderLabel;
   private JPanel CancelledPanel;
   private JLabel DeleveredOrdersLabel;
   private JButton DeliveredBtn;
   private JPanel DeliveredPanel;
   private JTextField EstimedtedProccessingTime1;
   private JTextField EstimedtedProccessingTime2;
   private JTextField EstimedtedProccessingTime3;
   private JTextField EstimedtedProccessingTime4;
   private JLabel EstimedtedProccessingTimeLabel1;
   private JLabel EstimedtedProccessingTimeLabel2;
   private JLabel EstimedtedProccessingTimeLabel3;
   private JLabel EstimedtedProccessingTimeLabel4;
   private JLabel FoodName1;
   private JLabel FoodName2;
   private JLabel FoodName3;
   private JLabel FoodName5;
   private JPanel Header;
   private JLabel NameLabel;
   private JLabel NameLabel1;
   private JLabel NameLabel2;
   private JLabel NameLabel4;
   private JLabel OrderStatusLabel;
   private JLabel OrderStatusLabel1;
   private JLabel OrderStatusLabel2;
   private JLabel OrderStatusLabel4;
   private JLabel PriceLabel;
   private JLabel PriceLabel1;
   private JLabel PriceLabel2;
   private JLabel PriceLabel4;
   private JButton ProccessingBtn;
   private JLabel ProccessingOrdersLabel;
   private JPanel ProccessingPanel;
   private JPanel ProccessingPanelTotalInfo;
   private JLabel QtyLabel;
   private JLabel QtyLabel1;
   private JLabel QtyLabel2;
   private JLabel QtyLabel4;
   private JSeparator Separator;
   private JSeparator Separator1;
   private JSeparator Separator2;
   private JTabbedPane TabbedPanel;
   private JLabel currentTime;
   private JLabel currentTime1;
   private JLabel currentTime2;
   private JLabel foodIcon;
   private JLabel foodIcon1;
   private JLabel foodIcon2;
   private JLabel foodIcon4;
   private JPanel itemPanel1;
   private JPanel itemPanel2;
   private JPanel itemPanel3;
   private JPanel itemPanel4;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel orderNo1;
   private JLabel orderNo2;
   private JLabel orderNo3;
   private JLabel orderNo5;
   private JLabel orderNoLabel;
   private JLabel orderNoLabel1;
   private JLabel orderNoLabel2;
   private JLabel orderNoLabel4;
   private JLabel orderStatus1;
   private JLabel orderStatus2;
   private JLabel orderStatus3;
   private JLabel orderStatus5;
   private JLabel price1;
   private JLabel price2;
   private JLabel price3;
   private JLabel price5;
   private JLabel qty1;
   private JLabel qty2;
   private JLabel qty3;
   private JLabel qty5;
   private JPanel sideBar;
   private JLabel timeLabel1;
   private JLabel timeLabel2;
   private JLabel timeLabel3;
   // variables declaration END


   public Orders() { 
        Header = new JPanel();
        jLabel4 = new JLabel();
        sideBar = new JPanel();
        BackBtn = new JButton();
        ProccessingBtn = new JButton();
        DeliveredBtn = new JButton();
        CanceledBtn = new JButton();
        TabbedPanel = new JTabbedPane();
        ProccessingPanel = new JPanel();
        ProccessingOrdersLabel = new JLabel();
        Separator = new JSeparator();
        itemPanel1 = new JPanel();
        foodIcon = new JLabel();
        PriceLabel = new JLabel();
        price1 = new JLabel();
        NameLabel = new JLabel();
        FoodName1 = new JLabel();
        orderNoLabel = new JLabel();
        orderNo1 = new JLabel();
        QtyLabel = new JLabel();
        qty1 = new JLabel();
        orderStatus1 = new JLabel();
        OrderStatusLabel = new JLabel();
        EstimedtedProccessingTimeLabel1 = new JLabel();
        EstimedtedProccessingTime1 = new JTextField();
        itemPanel2 = new JPanel();
        foodIcon1 = new JLabel();
        PriceLabel1 = new JLabel();
        price2 = new JLabel();
        NameLabel1 = new JLabel();
        FoodName2 = new JLabel();
        orderNoLabel1 = new JLabel();
        orderNo2 = new JLabel();
        QtyLabel1 = new JLabel();
        qty2 = new JLabel();
        orderStatus2 = new JLabel();
        OrderStatusLabel1 = new JLabel();
        EstimedtedProccessingTimeLabel2 = new JLabel();
        EstimedtedProccessingTime2 = new JTextField();
        currentTime = new JLabel();
        timeLabel2 = new JLabel();
        ProccessingPanelTotalInfo = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        DeliveredPanel = new JPanel();
        DeleveredOrdersLabel = new JLabel();
        Separator1 = new JSeparator();
        currentTime1 = new JLabel();
        timeLabel1 = new JLabel();
        itemPanel3 = new JPanel();
        foodIcon4 = new JLabel();
        PriceLabel4 = new JLabel();
        price5 = new JLabel();
        NameLabel4 = new JLabel();
        FoodName5 = new JLabel();
        orderNoLabel4 = new JLabel();
        orderNo5 = new JLabel();
        QtyLabel4 = new JLabel();
        qty5 = new JLabel();
        orderStatus5 = new JLabel();
        OrderStatusLabel4 = new JLabel();
        EstimedtedProccessingTimeLabel3 = new JLabel();
        EstimedtedProccessingTime3 = new JTextField();
        itemPanel4 = new JPanel();
        foodIcon2 = new JLabel();
        PriceLabel2 = new JLabel();
        price3 = new JLabel();
        NameLabel2 = new JLabel();
        FoodName3 = new JLabel();
        orderNoLabel2 = new JLabel();
        orderNo3 = new JLabel();
        QtyLabel2 = new JLabel();
        qty3 = new JLabel();
        orderStatus3 = new JLabel();
        OrderStatusLabel2 = new JLabel();
        EstimedtedProccessingTimeLabel4 = new JLabel();
        EstimedtedProccessingTime4 = new JTextField();
        CancelledPanel = new JPanel();
        CancelledOrderLabel = new JLabel();
        Separator2 = new JSeparator();
        currentTime2 = new JLabel();
        timeLabel3 = new JLabel();

        setLayout(null);

        Header.setBackground(new Color(51, 51, 51));
        Header.setLayout(null);

        jLabel4.setFont(new Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new Color(204, 204, 255));
        jLabel4.setText("Orders");
        Header.add(jLabel4);
        jLabel4.setBounds(620, 50, 70, 30);

        add(Header);
        Header.setBounds(0, -40, 1300, 90);

        sideBar.setBackground(new Color(191, 191, 191));
        sideBar.setLayout(null);

        BackBtn.setText("Back");
        BackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BackBtnActionPerformed(e);
            }
        });
        sideBar.add(BackBtn);
        BackBtn.setBounds(10, 180, 130, 40);

        ProccessingBtn.setBackground(new Color(139, 161, 205));
        ProccessingBtn.setText("Proccessing");
        ProccessingBtn.setRequestFocusEnabled(false);
        ProccessingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProccessingBtnActionPerformed(e);
            }
        });
        sideBar.add(ProccessingBtn);
        ProccessingBtn.setBounds(10, 30, 130, 40);

        DeliveredBtn.setText("Delivered");
        DeliveredBtn.setFocusable(false);
        DeliveredBtn.setRequestFocusEnabled(false);
        DeliveredBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeliveredBtnActionPerformed(e);
            }
        });
        sideBar.add(DeliveredBtn);
        DeliveredBtn.setBounds(10, 80, 130, 40);

        CanceledBtn.setText("Canceled");
        CanceledBtn.setFocusable(false);
        CanceledBtn.setRequestFocusEnabled(false);
        CanceledBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CanceledBtnActionPerformed(e);
            }
        });
        sideBar.add(CanceledBtn);
        CanceledBtn.setBounds(10, 130, 130, 40);

        add(sideBar);
        sideBar.setBounds(0, 50, 160, 720);

        ProccessingPanel.setBackground(new Color(215, 221, 255));
        ProccessingPanel.setLayout(null);

        ProccessingOrdersLabel.setText("Proccessing Orders");
        ProccessingPanel.add(ProccessingOrdersLabel);
        ProccessingOrdersLabel.setBounds(10, 30, 130, 16);
        ProccessingPanel.add(Separator);
        Separator.setBounds(10, 50, 1150, 10);

        itemPanel1.setName(""); // NOI18N
        itemPanel1.setPreferredSize(new Dimension(730, 230));
        itemPanel1.setLayout(null);

        foodIcon.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        foodIcon.setIcon(new ImageIcon(getClass().getResource("/images/foods/burger.jpg"))); // NOI18N
        itemPanel1.add(foodIcon);
        foodIcon.setBounds(60, 30, 250, 160);

        PriceLabel.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        PriceLabel.setText("Price:");
        itemPanel1.add(PriceLabel);
        PriceLabel.setBounds(330, 60, 80, 18);

        price1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        price1.setText("10$");
        itemPanel1.add(price1);
        price1.setBounds(450, 60, 100, 20);

        NameLabel.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        NameLabel.setText("Item Name:");
        itemPanel1.add(NameLabel);
        NameLabel.setBounds(330, 30, 80, 18);

        FoodName1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        FoodName1.setForeground(new Color(255, 102, 102));
        FoodName1.setText("Burger");
        itemPanel1.add(FoodName1);
        FoodName1.setBounds(450, 30, 170, 20);

        orderNoLabel.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNoLabel.setText("Order no:");
        itemPanel1.add(orderNoLabel);
        orderNoLabel.setBounds(330, 120, 80, 18);

        orderNo1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNo1.setText("00");
        itemPanel1.add(orderNo1);
        orderNo1.setBounds(450, 120, 100, 20);

        QtyLabel.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        QtyLabel.setText("Quantity:");
        itemPanel1.add(QtyLabel);
        QtyLabel.setBounds(330, 90, 80, 18);

        qty1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        qty1.setText("0");
        itemPanel1.add(qty1);
        qty1.setBounds(450, 90, 90, 20);

        orderStatus1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderStatus1.setForeground(new Color(51, 153, 0));
        orderStatus1.setText("Currently No Orders found");
        itemPanel1.add(orderStatus1);
        orderStatus1.setBounds(450, 150, 260, 20);

        OrderStatusLabel.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        OrderStatusLabel.setText("Order Status:");
        itemPanel1.add(OrderStatusLabel);
        OrderStatusLabel.setBounds(330, 150, 110, 18);

        EstimedtedProccessingTimeLabel1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        EstimedtedProccessingTimeLabel1.setForeground(new Color(0, 153, 153));
        EstimedtedProccessingTimeLabel1.setText("Food will be delivered on:");
        itemPanel1.add(EstimedtedProccessingTimeLabel1);
        EstimedtedProccessingTimeLabel1.setBounds(80, 200, 180, 17);

        EstimedtedProccessingTime1.setEditable(false);
        EstimedtedProccessingTime1.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        EstimedtedProccessingTime1.setText("not set");
        EstimedtedProccessingTime1.setEnabled(false);
        itemPanel1.add(EstimedtedProccessingTime1);
        EstimedtedProccessingTime1.setBounds(280, 200, 90, 20);

        ProccessingPanel.add(itemPanel1);
        itemPanel1.setBounds(10, 60, 780, 240);

        itemPanel2.setLayout(null);

        foodIcon1.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        foodIcon1.setIcon(new ImageIcon(getClass().getResource("/images/foods/pizza.jpg"))); // NOI18N
        itemPanel2.add(foodIcon1);
        foodIcon1.setBounds(60, 30, 250, 160);

        PriceLabel1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        PriceLabel1.setText("Price:");
        itemPanel2.add(PriceLabel1);
        PriceLabel1.setBounds(330, 60, 80, 18);

        price2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        price2.setText("40$");
        itemPanel2.add(price2);
        price2.setBounds(450, 60, 100, 20);

        NameLabel1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        NameLabel1.setText("Item Name:");
        itemPanel2.add(NameLabel1);
        NameLabel1.setBounds(330, 30, 80, 18);

        FoodName2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        FoodName2.setForeground(new Color(255, 102, 102));
        FoodName2.setText("Pizza");
        itemPanel2.add(FoodName2);
        FoodName2.setBounds(450, 30, 170, 20);

        orderNoLabel1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNoLabel1.setText("Order no:");
        itemPanel2.add(orderNoLabel1);
        orderNoLabel1.setBounds(330, 120, 80, 18);

        orderNo2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNo2.setText("00");
        itemPanel2.add(orderNo2);
        orderNo2.setBounds(450, 120, 100, 20);

        QtyLabel1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        QtyLabel1.setText("Quantity:");
        itemPanel2.add(QtyLabel1);
        QtyLabel1.setBounds(330, 90, 80, 18);

        qty2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        qty2.setText("0");
        itemPanel2.add(qty2);
        qty2.setBounds(450, 90, 90, 20);

        orderStatus2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderStatus2.setForeground(new Color(51, 153, 0));
        orderStatus2.setText("Currently No Orders found");
        itemPanel2.add(orderStatus2);
        orderStatus2.setBounds(450, 150, 260, 20);

        OrderStatusLabel1.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        OrderStatusLabel1.setText("Order Status:");
        itemPanel2.add(OrderStatusLabel1);
        OrderStatusLabel1.setBounds(330, 150, 110, 18);

        EstimedtedProccessingTimeLabel2.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        EstimedtedProccessingTimeLabel2.setForeground(new Color(0, 153, 153));
        EstimedtedProccessingTimeLabel2.setText("Food will be delivered on:");
        itemPanel2.add(EstimedtedProccessingTimeLabel2);
        EstimedtedProccessingTimeLabel2.setBounds(80, 200, 180, 17);

        EstimedtedProccessingTime2.setEditable(false);
        EstimedtedProccessingTime2.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        EstimedtedProccessingTime2.setText("not set");
        EstimedtedProccessingTime2.setEnabled(false);
        itemPanel2.add(EstimedtedProccessingTime2);
        EstimedtedProccessingTime2.setBounds(280, 200, 90, 20);

        ProccessingPanel.add(itemPanel2);
        itemPanel2.setBounds(10, 320, 780, 240);

        currentTime.setText("0");
        ProccessingPanel.add(currentTime);
        currentTime.setBounds(960, 20, 100, 16);

        timeLabel2.setText("Current Time:");
        ProccessingPanel.add(timeLabel2);
        timeLabel2.setBounds(860, 20, 100, 16);

        ProccessingPanelTotalInfo.setLayout(null);

        jLabel1.setText("Totsl Item:");
        ProccessingPanelTotalInfo.add(jLabel1);
        jLabel1.setBounds(26, 29, 57, 20);

        jLabel2.setText("00");
        ProccessingPanelTotalInfo.add(jLabel2);
        jLabel2.setBounds(132, 29, 57, 20);

        jLabel3.setText("Total Costs:");
        ProccessingPanelTotalInfo.add(jLabel3);
        jLabel3.setBounds(26, 67, 75, 20);

        jLabel5.setText("0$");
        ProccessingPanelTotalInfo.add(jLabel5);
        jLabel5.setBounds(132, 67, 57, 20);

        ProccessingPanel.add(ProccessingPanelTotalInfo);
        ProccessingPanelTotalInfo.setBounds(850, 60, 220, 120);

        TabbedPanel.addTab("tab1", ProccessingPanel);

        DeliveredPanel.setBackground(new Color(233, 224, 249));
        DeliveredPanel.setLayout(null);

        DeleveredOrdersLabel.setText("Delevered Orders");
        DeliveredPanel.add(DeleveredOrdersLabel);
        DeleveredOrdersLabel.setBounds(10, 30, 130, 16);
        DeliveredPanel.add(Separator1);
        Separator1.setBounds(10, 50, 1150, 10);

        currentTime1.setText("0");
        DeliveredPanel.add(currentTime1);
        currentTime1.setBounds(960, 20, 100, 16);

        timeLabel1.setText("Current Time:");
        DeliveredPanel.add(timeLabel1);
        timeLabel1.setBounds(860, 20, 100, 16);

        itemPanel3.setName(""); // NOI18N
        itemPanel3.setPreferredSize(new Dimension(730, 230));
        itemPanel3.setLayout(null);

        foodIcon4.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        foodIcon4.setIcon(new ImageIcon(getClass().getResource("/images/foods/burger.jpg"))); // NOI18N
        itemPanel3.add(foodIcon4);
        foodIcon4.setBounds(60, 30, 250, 160);

        PriceLabel4.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        PriceLabel4.setText("Price:");
        itemPanel3.add(PriceLabel4);
        PriceLabel4.setBounds(330, 60, 80, 18);

        price5.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        price5.setText("10$");
        itemPanel3.add(price5);
        price5.setBounds(450, 60, 100, 20);

        NameLabel4.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        NameLabel4.setText("Item Name:");
        itemPanel3.add(NameLabel4);
        NameLabel4.setBounds(330, 30, 80, 18);

        FoodName5.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        FoodName5.setForeground(new Color(255, 102, 102));
        FoodName5.setText("Burger");
        itemPanel3.add(FoodName5);
        FoodName5.setBounds(450, 30, 170, 20);

        orderNoLabel4.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNoLabel4.setText("Order no:");
        itemPanel3.add(orderNoLabel4);
        orderNoLabel4.setBounds(330, 120, 80, 18);

        orderNo5.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNo5.setText("00");
        itemPanel3.add(orderNo5);
        orderNo5.setBounds(450, 120, 100, 20);

        QtyLabel4.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        QtyLabel4.setText("Quantity:");
        itemPanel3.add(QtyLabel4);
        QtyLabel4.setBounds(330, 90, 80, 18);

        qty5.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        qty5.setText("0");
        itemPanel3.add(qty5);
        qty5.setBounds(450, 90, 90, 20);

        orderStatus5.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderStatus5.setForeground(new Color(51, 153, 0));
        orderStatus5.setText("Currently No Orders found");
        itemPanel3.add(orderStatus5);
        orderStatus5.setBounds(450, 150, 260, 20);

        OrderStatusLabel4.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        OrderStatusLabel4.setText("Order Status:");
        itemPanel3.add(OrderStatusLabel4);
        OrderStatusLabel4.setBounds(330, 150, 110, 18);

        EstimedtedProccessingTimeLabel3.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        EstimedtedProccessingTimeLabel3.setForeground(new Color(0, 153, 153));
        EstimedtedProccessingTimeLabel3.setText("Food will be delivered on:");
        itemPanel3.add(EstimedtedProccessingTimeLabel3);
        EstimedtedProccessingTimeLabel3.setBounds(80, 200, 180, 17);

        EstimedtedProccessingTime3.setEditable(false);
        EstimedtedProccessingTime3.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        EstimedtedProccessingTime3.setText("not set");
        EstimedtedProccessingTime3.setEnabled(false);
        itemPanel3.add(EstimedtedProccessingTime3);
        EstimedtedProccessingTime3.setBounds(280, 200, 90, 20);

        DeliveredPanel.add(itemPanel3);
        itemPanel3.setBounds(10, 60, 780, 240);

        itemPanel4.setLayout(null);

        foodIcon2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        foodIcon2.setIcon(new ImageIcon(getClass().getResource("/images/foods/pizza.jpg"))); // NOI18N
        itemPanel4.add(foodIcon2);
        foodIcon2.setBounds(60, 30, 250, 160);

        PriceLabel2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        PriceLabel2.setText("Price:");
        itemPanel4.add(PriceLabel2);
        PriceLabel2.setBounds(330, 60, 80, 18);

        price3.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        price3.setText("40$");
        itemPanel4.add(price3);
        price3.setBounds(450, 60, 100, 20);

        NameLabel2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        NameLabel2.setText("Item Name:");
        itemPanel4.add(NameLabel2);
        NameLabel2.setBounds(330, 30, 80, 18);

        FoodName3.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        FoodName3.setForeground(new Color(255, 102, 102));
        FoodName3.setText("Pizza");
        itemPanel4.add(FoodName3);
        FoodName3.setBounds(450, 30, 170, 20);

        orderNoLabel2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNoLabel2.setText("Order no:");
        itemPanel4.add(orderNoLabel2);
        orderNoLabel2.setBounds(330, 120, 80, 18);

        orderNo3.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderNo3.setText("00");
        itemPanel4.add(orderNo3);
        orderNo3.setBounds(450, 120, 100, 20);

        QtyLabel2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        QtyLabel2.setText("Quantity:");
        itemPanel4.add(QtyLabel2);
        QtyLabel2.setBounds(330, 90, 80, 18);

        qty3.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        qty3.setText("0");
        itemPanel4.add(qty3);
        qty3.setBounds(450, 90, 90, 20);

        orderStatus3.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        orderStatus3.setForeground(new Color(51, 153, 0));
        orderStatus3.setText("Currently No Orders found");
        itemPanel4.add(orderStatus3);
        orderStatus3.setBounds(450, 150, 260, 20);

        OrderStatusLabel2.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        OrderStatusLabel2.setText("Order Status:");
        itemPanel4.add(OrderStatusLabel2);
        OrderStatusLabel2.setBounds(330, 150, 110, 18);

        EstimedtedProccessingTimeLabel4.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        EstimedtedProccessingTimeLabel4.setForeground(new Color(0, 153, 153));
        EstimedtedProccessingTimeLabel4.setText("Food will be delivered on:");
        itemPanel4.add(EstimedtedProccessingTimeLabel4);
        EstimedtedProccessingTimeLabel4.setBounds(80, 200, 180, 17);

        EstimedtedProccessingTime4.setEditable(false);
        EstimedtedProccessingTime4.setFont(new Font("Tahoma", 1, 13)); // NOI18N
        EstimedtedProccessingTime4.setText("not set");
        EstimedtedProccessingTime4.setEnabled(false);
        itemPanel4.add(EstimedtedProccessingTime4);
        EstimedtedProccessingTime4.setBounds(280, 200, 90, 20);

        DeliveredPanel.add(itemPanel4);
        itemPanel4.setBounds(10, 320, 780, 240);

        TabbedPanel.addTab("tab2", DeliveredPanel);

        CancelledPanel.setBackground(new Color(243, 210, 210));
        CancelledPanel.setLayout(null);

        CancelledOrderLabel.setText("Cancelled Orders");
        CancelledPanel.add(CancelledOrderLabel);
        CancelledOrderLabel.setBounds(10, 30, 130, 16);
        CancelledPanel.add(Separator2);
        Separator2.setBounds(10, 50, 1150, 10);

        currentTime2.setText("0");
        CancelledPanel.add(currentTime2);
        currentTime2.setBounds(960, 20, 100, 16);

        timeLabel3.setText("Current Time:");
        CancelledPanel.add(timeLabel3);
        timeLabel3.setBounds(860, 20, 100, 16);

        TabbedPanel.addTab("tab3", CancelledPanel);

        add(TabbedPanel);
        TabbedPanel.setBounds(160, 10, 1150, 710);



       
        ProccessingBtn.setBackground(clickedColor);
        DeliveredBtn.setBackground(defaultColor);
        CanceledBtn.setBackground(defaultColor);
        BackBtn.setBackground(defaultColor);      
         setTime(); 
                 
    }
    

    public Orders(int orderNo, double totalPrice, String FoodName, int qty) {
        this.total = totalPrice;
        this.quantity = qty;
        
       //        adding order detailes to the file
       if (orders.exists()) {  
          
 
                System.out.println("File already exists.");
                
                try{      
                    FileWriter fileWriter = new FileWriter(orders, true);

                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(orderNo+","+FoodName+","+totalPrice+","+qty+","+"pending"+","+(FoodName.equals("Burger") ?  setEstimetedTime(10): setEstimetedTime(30))+"\n");
                }

                    System.out.println("Done");
                } catch(IOException e) {
                    System.out.println("operation failed!! "+e);
                }
       
       }
    }
    
    public String setEstimetedTime(int times){
        cal.add(Calendar.MINUTE,times);
        EstimetedTIME = timeFormat.format(cal.getTime()); 
        return EstimetedTIME;   
    }
    public void setTime(){        
        java.util.Timer timer = new java.util.Timer();
        // Clock task = ;         
        timer.schedule(new Clock(this), 0,1000);
    }


    private void BackBtnActionPerformed(ActionEvent e) {
        this.setVisible(false);
        Frame.Menu.setVisible(true);
//        ProccessingBtn.setBackground(defaultColor);
//        DeliveredBtn.setBackground(defaultColor);
//        CanceledBtn.setBackground(defaultColor);
    }

    private void CanceledBtnActionPerformed(ActionEvent e) {
        TabbedPanel.setSelectedIndex(2);
        this.TabbedPanelIndex = 2;
        ProccessingBtn.setBackground(defaultColor);
        DeliveredBtn.setBackground(defaultColor);
        CanceledBtn.setBackground(clickedColor);
        BackBtn.setBackground(defaultColor);
    }

    private void ProccessingBtnActionPerformed(ActionEvent e) {
        TabbedPanel.setSelectedIndex(0);
        this.TabbedPanelIndex = 0;
        ProccessingBtn.setBackground(clickedColor);
        DeliveredBtn.setBackground(defaultColor);
        CanceledBtn.setBackground(defaultColor);
        BackBtn.setBackground(defaultColor);
    }

    private void DeliveredBtnActionPerformed(ActionEvent e) {
        TabbedPanel.setSelectedIndex(1);
        this.TabbedPanelIndex = 1;
        ProccessingBtn.setBackground(defaultColor);
        DeliveredBtn.setBackground(clickedColor);
        CanceledBtn.setBackground(defaultColor);
        BackBtn.setBackground(defaultColor);
    }


//  setter and getter methods 

   
    public double getTotal() {
        return total;
    }
    public int getTabbedPanelIndex() {
        return this.TabbedPanelIndex;
    }
    
    public JPanel getItemPanel1() {
        return itemPanel1;
    }
    public JPanel getItemPanel2() {
        return itemPanel2;
    }
    
    public JLabel getPrice1() {
        return price1;
    }

    public JLabel getFoodName1() {
        return FoodName1;
    }

    public JLabel getOrderNo1() {
        return orderNo1;
    }

    public JLabel getQty1() {
        return qty1;
    }
    public JLabel getOrderStatus1() {
        return orderStatus1;
    }
    
    public JLabel getPrice2() {
        return price2;
    }

    public JLabel getFoodName2() {
        return FoodName2;
    }

    public JLabel getOrderNo2() {
        return orderNo2;
    }

    public JLabel getQty2() {
        return qty2;
    }
    public JLabel getOrderStatus2() {
        return orderStatus2;
    }
    public JTextField getEstimedtedProccessingTime1() {
        return EstimedtedProccessingTime1;
    }
    public JTextField getEstimedtedProccessingTime2() {
        return EstimedtedProccessingTime2;
    }

    public JButton getCanceledBtn() {
        return CanceledBtn;
    }

    public JButton getDeliveredBtn() {
        return DeliveredBtn;
    }

    public JButton getProccessingBtn() {
        return ProccessingBtn;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public Color getClickedColor() {
        return clickedColor;
    }
    public JLabel getCurrentTime() {
        return currentTime;
    }
    public JLabel getCurrentTime1() {
        return currentTime1;
    }
    public JLabel getCurrentTime2() {
        return currentTime2;
    }
    
  
}
