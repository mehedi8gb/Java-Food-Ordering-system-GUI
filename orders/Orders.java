package orders;

import Clock.Clock;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import view.Frame;
import view.pages.MainMenu;


public class Orders extends JPanel {

    public static boolean Auth;

    private Color defaultColor = new Color(255, 255, 255);
    private Color clickedColor = new Color(139, 161, 205);
    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
    private Calendar cal = Calendar.getInstance();
    protected String EstimetedTIME;
    protected String TIME;
    public static double total;
    public static Orders orderObj;
    public static String Coupons[] = {"OFF10", "OFF20", "OFF30"};
    public static String CouponStatus;
    private static int burgerStatus = 0;
    private static int pizzaStatus = 0;
    private int quantity;
    private int TabbedPanelIndex;

    private static File orders = new File(System.getProperty("user.dir")+"\\files\\Orders.txt");
    private static File users = new File(System.getProperty("user.dir")+"\\files\\Users.txt");
    private static MainMenu MainMenu;

    private Double BurgerCost, PizzaCost;
    private Integer BurgerQty, PizzaQty;

    private static paymentForm PF;
    public static String ID;


    JButton BackBtn;
    JButton CancelOrderBtn1;
    JButton CancelOrderBtn2;
    JButton CanceledBtn;
    JLabel CancelledOrderLabel;
    JPanel CancelledPanel;
    JLabel DeleveredOrdersLabel;
    JButton DeliveredBtn;
    JPanel DeliveredPanel;
    JTextField EstimedtedProccessingTime1;
    JTextField EstimedtedProccessingTime2;
    JLabel EstimedtedProccessingTimeLabel1;
    JLabel EstimedtedProccessingTimeLabel2;
    JLabel FoodName1;
    JLabel FoodName2;
    JPanel Header;
    JLabel NameLabel;
    JLabel NameLabel1;
    JLabel OrderStatusLabel;
    JLabel OrderStatusLabel1;
    JLabel PaymentStatusField;
    JLabel PriceLabel;
    JLabel PriceLabel1;
    JButton ProccessingBtn;
    JLabel ProccessingOrdersLabel;
    JPanel ProccessingPanel;
    JLabel QtyLabel;
    JLabel QtyLabel1;
    JSeparator Separator;
    JSeparator Separator1;
    JSeparator Separator2;
    JTabbedPane TabbedPanel;
    JPanel TotalinfoPanel;
    JLabel currentTime;
    JLabel currentTime1;
    JLabel currentTime2;
    JLabel foodIcon;
    JLabel foodIcon1;
    JPanel itemPanel1;
    JPanel itemPanel2;
    JLabel paymentStatusLabel;
    JLabel ordersLabel;
    JLabel orderNo1;
    JLabel orderNo2;
    JLabel orderNoLabel;
    JLabel orderNoLabel1;
    JLabel orderStatus1;
    JLabel orderStatus2;
    JButton payBtn;
    JLabel price1;
    JLabel price2;
    JLabel qty1;
    JLabel qty2;
    JPanel sideBar;
    JLabel timeLabel1;
    JLabel timeLabel2;
    JLabel timeLabel3;
    JLabel totalCostField;
    JLabel totalCostLabel;
    JLabel totalitemField;
    JLabel totalitemLabel;

    public Orders() {
        orderObj = this;

        Header = new JPanel();
        ordersLabel = new JLabel();
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
        CancelOrderBtn1 = new JButton();
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
        CancelOrderBtn2 = new JButton();
        currentTime = new JLabel();
        timeLabel2 = new JLabel();
        TotalinfoPanel = new JPanel();
        totalitemLabel = new JLabel();
        totalitemField = new JLabel();
        totalCostLabel = new JLabel();
        totalCostField = new JLabel();
        payBtn = new JButton();
        PaymentStatusField = new JLabel();
        paymentStatusLabel = new JLabel();
        DeliveredPanel = new JPanel();
        DeleveredOrdersLabel = new JLabel();
        Separator1 = new JSeparator();
        currentTime1 = new JLabel();
        timeLabel1 = new JLabel();
        CancelledPanel = new JPanel();
        CancelledOrderLabel = new JLabel();
        Separator2 = new JSeparator();
        currentTime2 = new JLabel();
        timeLabel3 = new JLabel();

        setLayout(null);

        Header.setBackground(new Color(51, 51, 51));
        Header.setLayout(null);

        ordersLabel.setFont(new Font("Gadugi", 1, 18)); 
        ordersLabel.setForeground(new Color(204, 204, 255));
        ordersLabel.setText("Orders");
        Header.add(ordersLabel);
        ordersLabel.setBounds(620, 50, 70, 30);

        add(Header);
        Header.setBounds(0, -40, 1300, 90);

        sideBar.setBackground(new Color(191, 191, 191));
        sideBar.setLayout(null);

        BackBtn.setText("Back");
        BackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        sideBar.add(BackBtn);
        BackBtn.setBounds(10, 180, 130, 40);

        ProccessingBtn.setBackground(new Color(139, 161, 205));
        ProccessingBtn.setText("Proccessing");
        ProccessingBtn.setRequestFocusEnabled(false);
        ProccessingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ProccessingBtnActionPerformed(evt);
            }
        });
        sideBar.add(ProccessingBtn);
        ProccessingBtn.setBounds(10, 30, 130, 40);

        DeliveredBtn.setText("Delivered");
        DeliveredBtn.setFocusable(false);
        DeliveredBtn.setRequestFocusEnabled(false);
        DeliveredBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DeliveredBtnActionPerformed(evt);
            }
        });
        sideBar.add(DeliveredBtn);
        DeliveredBtn.setBounds(10, 80, 130, 40);

        CanceledBtn.setText("Canceled");
        CanceledBtn.setFocusable(false);
        CanceledBtn.setRequestFocusEnabled(false);
        CanceledBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CanceledBtnActionPerformed(evt);
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

        itemPanel1.setName(""); 
        itemPanel1.setPreferredSize(new Dimension(730, 230));

        itemPanel1.setLayout(null);

        foodIcon.setFont(new Font("Segoe UI", 1, 14)); 
        foodIcon.setIcon(new ImageIcon(getClass().getResource("/test/images/foods/burger.jpg"))); 
        itemPanel1.add(foodIcon);
        foodIcon.setBounds(60, 30, 250, 160);

        PriceLabel.setFont(new Font("Segoe UI", 1, 13)); 
        PriceLabel.setText("Price:");
        itemPanel1.add(PriceLabel);
        PriceLabel.setBounds(330, 60, 80, 18);

        price1.setFont(new Font("Segoe UI", 1, 13)); 
        price1.setText("10 BDT");
        itemPanel1.add(price1);
        price1.setBounds(450, 60, 100, 20);

        NameLabel.setFont(new Font("Segoe UI", 1, 13)); 
        NameLabel.setText("Item Name:");
        itemPanel1.add(NameLabel);
        NameLabel.setBounds(330, 30, 80, 18);

        FoodName1.setFont(new Font("Segoe UI", 1, 13)); 
        FoodName1.setForeground(new Color(255, 102, 102));
        FoodName1.setText("Burger");
        itemPanel1.add(FoodName1);
        FoodName1.setBounds(450, 30, 170, 20);

        orderNoLabel.setFont(new Font("Segoe UI", 1, 13)); 
        orderNoLabel.setText("Order no:");
        itemPanel1.add(orderNoLabel);
        orderNoLabel.setBounds(330, 120, 80, 18);

        orderNo1.setFont(new Font("Segoe UI", 1, 13)); 
        orderNo1.setText("00");
        itemPanel1.add(orderNo1);
        orderNo1.setBounds(450, 120, 100, 20);

        QtyLabel.setFont(new Font("Segoe UI", 1, 13)); 
        QtyLabel.setText("Quantity:");
        itemPanel1.add(QtyLabel);
        QtyLabel.setBounds(330, 90, 80, 18);

        qty1.setFont(new Font("Segoe UI", 1, 13)); 
        qty1.setText("0");
        itemPanel1.add(qty1);
        qty1.setBounds(450, 90, 90, 20);

        orderStatus1.setFont(new Font("Segoe UI", 1, 13)); 
        orderStatus1.setForeground(new Color(51, 153, 0));
        orderStatus1.setText("Currently No Orders found");
        itemPanel1.add(orderStatus1);
        orderStatus1.setBounds(450, 150, 260, 20);

        OrderStatusLabel.setFont(new Font("Segoe UI", 1, 13)); 
        OrderStatusLabel.setText("Order Status:");
        itemPanel1.add(OrderStatusLabel);
        OrderStatusLabel.setBounds(330, 150, 110, 18);

        EstimedtedProccessingTimeLabel1.setFont(new Font("Tahoma", 1, 14)); 
        EstimedtedProccessingTimeLabel1.setForeground(new Color(0, 153, 153));
        EstimedtedProccessingTimeLabel1.setText("Food will be delivered at:");
        itemPanel1.add(EstimedtedProccessingTimeLabel1);
        EstimedtedProccessingTimeLabel1.setBounds(80, 200, 180, 17);

        EstimedtedProccessingTime1.setEditable(false);
        EstimedtedProccessingTime1.setFont(new Font("Tahoma", 1, 13)); 
        EstimedtedProccessingTime1.setText("not set");
        EstimedtedProccessingTime1.setEnabled(false);

        itemPanel1.add(EstimedtedProccessingTime1);
        EstimedtedProccessingTime1.setBounds(280, 200, 90, 20);

        CancelOrderBtn1.setBackground(new Color(220, 28, 28));
        CancelOrderBtn1.setFont(new Font("Tahoma", 1, 13)); 
        CancelOrderBtn1.setForeground(new Color(255, 255, 255));
        CancelOrderBtn1.setIcon(new ImageIcon(getClass().getResource("/test/images/close.png"))); 
        CancelOrderBtn1.setText("Cancel Order");
        CancelOrderBtn1.setFocusable(false);
        CancelOrderBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CancelOrderBtn1ActionPerformed(evt);
            }
        });
        itemPanel1.add(CancelOrderBtn1);
        CancelOrderBtn1.setBounds(610, 190, 160, 40);

        ProccessingPanel.add(itemPanel1);
        itemPanel1.setBounds(10, 60, 780, 240);

        itemPanel2.setLayout(null);

        foodIcon1.setFont(new Font("Segoe UI", 1, 14)); 
        foodIcon1.setIcon(new ImageIcon(getClass().getResource("/test/images/foods/pizza.jpg"))); 
        itemPanel2.add(foodIcon1);
        foodIcon1.setBounds(60, 30, 250, 160);

        PriceLabel1.setFont(new Font("Segoe UI", 1, 13)); 
        PriceLabel1.setText("Price:");
        itemPanel2.add(PriceLabel1);
        PriceLabel1.setBounds(330, 60, 80, 18);

        price2.setFont(new Font("Segoe UI", 1, 13)); 
        price2.setText("40 BDT");
        itemPanel2.add(price2);
        price2.setBounds(450, 60, 100, 20);

        NameLabel1.setFont(new Font("Segoe UI", 1, 13)); 
        NameLabel1.setText("Item Name:");
        itemPanel2.add(NameLabel1);
        NameLabel1.setBounds(330, 30, 80, 18);

        FoodName2.setFont(new Font("Segoe UI", 1, 13)); 
        FoodName2.setForeground(new Color(255, 102, 102));
        FoodName2.setText("Pizza");
        itemPanel2.add(FoodName2);
        FoodName2.setBounds(450, 30, 170, 20);

        orderNoLabel1.setFont(new Font("Segoe UI", 1, 13)); 
        orderNoLabel1.setText("Order no:");
        itemPanel2.add(orderNoLabel1);
        orderNoLabel1.setBounds(330, 120, 80, 18);

        orderNo2.setFont(new Font("Segoe UI", 1, 13)); 
        orderNo2.setText("00");
        itemPanel2.add(orderNo2);
        orderNo2.setBounds(450, 120, 100, 20);

        QtyLabel1.setFont(new Font("Segoe UI", 1, 13)); 
        QtyLabel1.setText("Quantity:");
        itemPanel2.add(QtyLabel1);
        QtyLabel1.setBounds(330, 90, 80, 18);

        qty2.setFont(new Font("Segoe UI", 1, 13)); 
        qty2.setText("0");
        itemPanel2.add(qty2);
        qty2.setBounds(450, 90, 90, 20);

        orderStatus2.setFont(new Font("Segoe UI", 1, 13)); 
        orderStatus2.setForeground(new Color(51, 153, 0));
        orderStatus2.setText("Currently No Orders found");
        itemPanel2.add(orderStatus2);
        orderStatus2.setBounds(450, 150, 260, 20);

        OrderStatusLabel1.setFont(new Font("Segoe UI", 1, 13)); 
        OrderStatusLabel1.setText("Order Status:");
        itemPanel2.add(OrderStatusLabel1);
        OrderStatusLabel1.setBounds(330, 150, 110, 18);

        EstimedtedProccessingTimeLabel2.setFont(new Font("Tahoma", 1, 14)); 
        EstimedtedProccessingTimeLabel2.setForeground(new Color(0, 153, 153));
        EstimedtedProccessingTimeLabel2.setText("Food will be delivered at:");
        itemPanel2.add(EstimedtedProccessingTimeLabel2);
        EstimedtedProccessingTimeLabel2.setBounds(80, 200, 180, 17);

        EstimedtedProccessingTime2.setEditable(false);
        EstimedtedProccessingTime2.setFont(new Font("Tahoma", 1, 13)); 
        EstimedtedProccessingTime2.setText("not set");
        EstimedtedProccessingTime2.setEnabled(false);
    
        itemPanel2.add(EstimedtedProccessingTime2);
        EstimedtedProccessingTime2.setBounds(280, 200, 90, 20);

        CancelOrderBtn2.setBackground(new Color(220, 28, 28));
        CancelOrderBtn2.setFont(new Font("Tahoma", 1, 13)); 
        CancelOrderBtn2.setForeground(new Color(255, 255, 255));
        CancelOrderBtn2.setIcon(new ImageIcon(getClass().getResource("/test/images/close.png"))); 
        CancelOrderBtn2.setText("Cancel Order");
        CancelOrderBtn2.setFocusable(false);
        CancelOrderBtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CancelOrderBtn2ActionPerformed(evt);
            }
        });
        itemPanel2.add(CancelOrderBtn2);
        CancelOrderBtn2.setBounds(610, 190, 160, 40);

        ProccessingPanel.add(itemPanel2);
        itemPanel2.setBounds(10, 320, 780, 240);

        currentTime.setText("0");
        ProccessingPanel.add(currentTime);
        currentTime.setBounds(960, 20, 100, 16);

        timeLabel2.setText("Current Time:");
        ProccessingPanel.add(timeLabel2);
        timeLabel2.setBounds(860, 20, 100, 16);

        TotalinfoPanel.setLayout(null);

        totalitemLabel.setText("Total Item:");
        TotalinfoPanel.add(totalitemLabel);
        totalitemLabel.setBounds(30, 30, 120, 20);

        totalitemField.setText("00 Piece");
        TotalinfoPanel.add(totalitemField);
        totalitemField.setBounds(180, 30, 70, 20);

        totalCostLabel.setText("Total Costs:");
        TotalinfoPanel.add(totalCostLabel);
        totalCostLabel.setBounds(30, 70, 120, 20);

        totalCostField.setText("0.0 BDT");
        TotalinfoPanel.add(totalCostField);
        totalCostField.setBounds(180, 70, 70, 20);

        payBtn.setBackground(new Color(0, 162, 237));
        payBtn.setFont(new Font("Segoe UI", 1, 13)); 
        payBtn.setForeground(new Color(255, 255, 255));
        payBtn.setText("Pay Now");
        payBtn.setFocusable(false);
        payBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });
        TotalinfoPanel.add(payBtn);
        payBtn.setBounds(30, 180, 210, 40);

        PaymentStatusField.setText("no due");
        TotalinfoPanel.add(PaymentStatusField);
        PaymentStatusField.setBounds(180, 110, 70, 20);

        paymentStatusLabel.setText("Payment Status:");
        TotalinfoPanel.add(paymentStatusLabel);
        paymentStatusLabel.setBounds(30, 110, 120, 16);

        ProccessingPanel.add(TotalinfoPanel);
        TotalinfoPanel.setBounds(830, 60, 270, 240);

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


        updateTotalInfoPanel();
        ProccessingBtn.setBackground(clickedColor);
        DeliveredBtn.setBackground(defaultColor);
        CanceledBtn.setBackground(defaultColor);
        BackBtn.setBackground(defaultColor);

        setTime();
    }

    public void setPaymentForm(paymentForm pf) {
        PF = pf;
    }

 
    public Orders(int orderNo, double totalPrice, String userID, String FoodName, int qty, String createdAt, String paymentStatus) {
//        this.total += totalPrice;
        this.quantity = qty;

        //        adding order detailes to the file 
        if (orders.exists()) {

            System.out.println("File already exists.");

            try {
                FileWriter fileWriter = new FileWriter(orders, true);

                try ( BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(orderNo + "," + FoodName + "," + totalPrice + "," + qty + "," + ID + "," + "pending" + "," + (FoodName.equals("Burger") ? setEstimetedTime(5) : setEstimetedTime(10)) + "," + createdAt + ",0" + "," + paymentStatus + "\n");
                    bufferedWriter.close();
                    fileWriter.close();
                }

                System.out.println("Done");
            } catch (IOException e) {
                System.out.println("operation failed!! " + e);
            }

        }
    }

    public static void setMainMenuRef(MainMenu o) {
        MainMenu = o;
    }

    public static Double ApplyCoupon(String c) {
        String coupon = c.trim();
        if (Coupons[0].equals(coupon)) {
            CouponStatus = "You have 10% discount for this " + '"' + coupon + '"' + " coupon ";
            return total -= (total * 10 / 100);

        } else if (Coupons[1].equals(coupon)) {
            CouponStatus = "You have 20% discount for this " + '"' + coupon + '"' + " coupon ";
            return total -= (total * 20 / 100);
        } else if (Coupons[2].equals(coupon)) {
            CouponStatus = "You have 30% discount for this " + '"' + coupon + '"' + " coupon ";
            return total -= (total * 30 / 100);
        } else {
            CouponStatus = null;
            return total;
        }
    }

    public void setItemAllInfos(Double BurgerCost, Double PizzaCost, Integer BurgerQty, Integer PizzaQty) {
        if (Auth) {
            this.BurgerCost = BurgerCost;
            this.BurgerQty = BurgerQty;
            this.PizzaCost = PizzaCost;
            this.PizzaQty = PizzaQty;
            Orders.total = PizzaCost + BurgerCost;

            String[] vals = null;
            try {
                Scanner IB = new Scanner(users);
                while (IB.hasNext()) {
                    String line = IB.nextLine();
                    vals = line.split(",");
                    if (vals[0].equals(Orders.ID) && vals[5].equals("paid")) {
                        PaymentStatusField.setText("paid");
                        PaymentStatusField.setForeground(Color.green);
                        Orders.total = Double.parseDouble(vals[4]);

                    } else {
                        PaymentStatusField.setText("unpaid");
                        PaymentStatusField.setForeground(Color.red);
                    }
                }
//            Scanner inputBuffer = new Scanner(orders);
//            while (inputBuffer.hasNext()) {
//                String line = inputBuffer.nextLine();
//                vals = line.split(",");
//                if (vals[0].equals(ID) && vals[9].equals("paid")) {
//                    PaymentStatusField.setText("paid");
//                    PaymentStatusField.setForeground(Color.green);
//                    Orders.total = Double.parseDouble(vals[2]);
//                    
//                } else {
//                    PaymentStatusField.setText("unpaid");
//                    PaymentStatusField.setForeground(Color.red);
//                }
//            }
                totalCostField.setText(String.valueOf(Orders.total) + " BDT");
                totalitemField.setText(String.valueOf(BurgerQty + PizzaQty));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    private String[] getOrderData() {
        String[] vals = null;
        try {
//   getting data from file 
            Scanner inputBuffer = new Scanner(orders);
            try {
                while (inputBuffer.hasNext()) {
                    String line = inputBuffer.nextLine();
                    vals = line.split(",");
                    if (vals[5].equals("pending") && vals[1].equals("Burger")) {
                        burgerStatus = 1;
                    } else if (vals[5].equals("delivered") && vals[1].equals("Burger")) {
                        burgerStatus = 2;
                    } else if (vals[5].equals("cancelled") && vals[1].equals("Burger")) {
                        burgerStatus = 3;
                    }

                    if (vals[5].equals("pending") && vals[1].equals("Pizza")) {
                        pizzaStatus = 1;
                    } else if (vals[5].equals("delivered") && vals[1].equals("Pizza")) {
                        pizzaStatus = 2;
                    } else if (vals[5].equals("cancelled") && vals[1].equals("Pizza")) {
                        pizzaStatus = 3;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return vals;
    }

    public void removeLineFromFile(String lineToRemove) {
        try {

            File tempFile = new File(System.getProperty("user.dir")+"\\files\\Temp.txt");
            File inputFile = new File(System.getProperty("user.dir")+"\\files\\Orders.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            String currentData;
            String orderCancelledAt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                currentLine = currentLine.trim();
                String[] trimLine = currentLine.split(",");
                if (trimLine[0].equals(lineToRemove.trim())) {
                    trimLine[5] = "cancelled";
                    writer.write(trimLine[0] + "," + trimLine[1] + "," + trimLine[2] + "," + trimLine[3] + "," + trimLine[4] + "," + "cancelled" + "," + trimLine[6] + "," + trimLine[7] + "," + orderCancelledAt + ",unpaid" + "\n");
                    continue;
                }
                writer.write(currentLine + "\n");
            }
            writer.close();
            reader.close();
            BufferedWriter BW = new BufferedWriter(new FileWriter(inputFile));
            BufferedReader BR = new BufferedReader(new FileReader(tempFile));

            while ((currentData = BR.readLine()) != null) {
                BW.write(currentData + "\n");
            }

            BW.close();
            BR.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String setEstimetedTime(int times) {
        cal.add(Calendar.MINUTE, times);
        EstimetedTIME = timeFormat.format(cal.getTime());
        return EstimetedTIME;
    }

    private void setTime() {
        java.util.Timer timer = new java.util.Timer();
        Clock task = new Clock(this);
        timer.schedule(task, 0, 1000);
    }

    public void orderPageLogic() {
//        if (Auth) {
        String v[] = getOrderData();

        //   Burger order page logics 
        switch (burgerStatus) {
            case 1 -> {
                ProccessingPanel.add(itemPanel1);
                orderStatus1.setForeground(new Color(51, 153, 0));
                CancelOrderBtn1.setEnabled(true);
                CancelOrderBtn1.setVisible(true);
                payBtn.setEnabled(true);
            }
            case 2 -> {
                ProccessingPanel.remove(itemPanel1);
                DeliveredPanel.add(itemPanel1);
                payBtn.setEnabled(true);
            }
            case 3 -> {
                ProccessingPanel.remove(itemPanel1);
                DeliveredPanel.remove(itemPanel1);
                orderStatus1.setText("cancelled");
                orderStatus1.setForeground(Color.RED);
                CancelOrderBtn1.setEnabled(false);
            }
            default -> {
                orderStatus1.setText("no active order found");
                EstimedtedProccessingTime1.setText("not set");
                CancelOrderBtn1.setEnabled(false);
                payBtn.setEnabled(false);
            }
        }
        //  Pizza logics 
        switch (pizzaStatus) {
            case 1 -> {
                ProccessingPanel.add(itemPanel2);
                orderStatus2.setForeground(new Color(51, 153, 0));
                CancelOrderBtn2.setEnabled(true);
                CancelOrderBtn2.setVisible(true);
                payBtn.setEnabled(true);
            }
            case 2 -> {
                ProccessingPanel.remove(itemPanel2);
                DeliveredPanel.add(itemPanel2);
                payBtn.setEnabled(true);
            }
            case 3 -> {
                ProccessingPanel.remove(itemPanel2);
                DeliveredPanel.remove(itemPanel2);
                orderStatus2.setText("cancelled");
                orderStatus2.setForeground(Color.RED);
                CancelOrderBtn2.setEnabled(false);
                payBtn.setEnabled(false);
            }
            default -> {
                orderStatus2.setText("no active order found");
                EstimedtedProccessingTime2.setText("not set");
                CancelOrderBtn2.setEnabled(false);
                payBtn.setEnabled(false);
            }
        }
//        }
    }

    private void cancelPageLogic() {
        String v[] = getOrderData();
        switch (pizzaStatus) {
            case 1 -> {
                CancelledPanel.remove(itemPanel2);
                DeliveredPanel.remove(itemPanel2);
            }
            case 2 -> {
                CancelledPanel.remove(itemPanel2);
                ProccessingPanel.remove(itemPanel2);
            }
            case 3 -> {
                CancelledPanel.add(itemPanel2);
                orderStatus2.setText("order cancelled");
                orderStatus2.setForeground(Color.RED);
                orderNo2.setText(v[0]);
                price2.setText(v[2]);
                qty2.setText(v[3]);

                EstimedtedProccessingTime2.setText("not set");
                CancelOrderBtn2.setVisible(false);
            }
            default -> {
                orderStatus2.setText("no active order found");
                EstimedtedProccessingTime2.setText("not set");
                CancelOrderBtn2.setEnabled(false);
            }
        }

        switch (burgerStatus) {
            case 1 -> {
                CancelledPanel.remove(itemPanel1);
            }
            case 2 -> {
                CancelledPanel.remove(itemPanel1);
            }
            case 3 -> {
                CancelledPanel.add(itemPanel1);
                orderStatus1.setText("order cancelled!");
                orderStatus1.setForeground(Color.RED);
                orderNo1.setText(v[0]);
                price1.setText(v[2]);
                qty1.setText(v[3]);
                CancelOrderBtn1.setVisible(false);
            }
            default -> {
                orderStatus1.setText("no active order found");
                EstimedtedProccessingTime1.setText("not set");
                CancelOrderBtn1.setEnabled(false);
            }
        }
    }

    private void deliveredPageLogic() {
        String v[] = getOrderData();
        switch (pizzaStatus) {
            case 1 -> {
                CancelledPanel.remove(itemPanel2);
                DeliveredPanel.remove(itemPanel2);
                ProccessingPanel.add(itemPanel2);
            }
            case 2 -> {
                DeliveredPanel.add(itemPanel2);
                CancelledPanel.remove(itemPanel2);
                ProccessingPanel.remove(itemPanel2);

                orderStatus2.setText("food already delivered");
                orderStatus2.setForeground(Color.GREEN);

                orderNo2.setText(v[0]);
                price2.setText(v[2]);
                qty2.setText(v[3]);
//                orderStatus2.setText(v[5]);
                EstimedtedProccessingTime2.setText(v[6]);
                CancelOrderBtn1.setVisible(false);
            }
            case 3 -> {
                CancelledPanel.add(itemPanel2);
                ProccessingPanel.remove(itemPanel2);
                DeliveredPanel.remove(itemPanel2);
            }
            default -> {
                orderStatus2.setText("no active order found");
                EstimedtedProccessingTime2.setText("not set");
                CancelOrderBtn2.setEnabled(false);
            }
        }

        switch (burgerStatus) {
            case 1 -> {
                CancelledPanel.remove(itemPanel1);
                DeliveredPanel.remove(itemPanel1);
                ProccessingPanel.add(itemPanel1);
            }
            case 2 -> {
                DeliveredPanel.add(itemPanel1);
                CancelledPanel.remove(itemPanel1);
                ProccessingPanel.remove(itemPanel1);

                orderStatus1.setText("food already delivered");
                orderStatus1.setForeground(Color.GREEN);
                orderNo1.setText(v[0]);
                price1.setText(v[2]);
                qty1.setText(v[3]);
//                orderStatus1.setText(v[5]);
                EstimedtedProccessingTime1.setText(v[6]);
                CancelOrderBtn1.setVisible(false);
            }
            case 3 -> {
                CancelledPanel.add(itemPanel1);
                ProccessingPanel.remove(itemPanel1);
                DeliveredPanel.remove(itemPanel1);
            }
            default -> {
                orderStatus1.setText("no active order found");
                EstimedtedProccessingTime1.setText("not set");
                CancelOrderBtn1.setEnabled(false);
            }
        }
    }

    public void updateTotalInfoPanel() {
//        if (Auth) {
        BufferedReader BW;

        try {
            this.quantity = 0;
            BW = new BufferedReader(new FileReader(orders));
            String line;
            String[] Split;
//            Double BurgerCost = 0.0, PizzaCost = 0.0;
//            Integer BurgerQty = 0, PizzaQty = 0;
            while ((line = BW.readLine()) != null) {
                Split = line.split(",");
                if (Split[5].trim().equals("pending") || Split[5].trim().equals("delivered")) {
                    this.quantity += Integer.parseInt(Split[3].trim());
                    PaymentStatusField.setText(Split[9]);

//                    BurgerCost += Double.parseDouble(Split[2]);
//                    BurgerQty += Integer.parseInt(Split[3]);
//                    String pis = (BurgerQty > 1) ? " Pieces" : " Piece";
//                    FoodName1.setText(Split[1]);
//                    price1.setText(BurgerCost + " BDT");
//                    qty1.setText(BurgerQty + pis);
//                    orderStatus1.setText(Split[5]);
//                    EstimedtedProccessingTime1.setText(Split[6]);
//
//                    PizzaCost += Double.parseDouble(Split[2]);
//                    PizzaQty += Integer.parseInt(Split[3]);
//                    String Pis = (PizzaQty > 1) ? " Pieces" : " Piece";
//                    itemPanel2.setVisible(true);
//                    orderNo2.setText(Split[0]);
//                    FoodName2.setText(Split[1]);
//                    price2.setText(PizzaCost + " BDT");
//                    qty2.setText(PizzaQty + Pis);
//                    orderStatus2.setText(Split[5]);
//                    EstimedtedProccessingTime2.setText(Split[6]);

                    System.out.println("ID-" + Split[0]);
                    System.out.println("esisted-ID-" + ID);
                    System.out.println("QTY-" + Split[3]);
                }

            }
            BW.close();
            String pis = (this.quantity > 1) ? " Pieces" : " Piece";
            totalitemField.setText(String.valueOf(this.quantity) + pis);
            totalCostField.setText(String.valueOf(Orders.total));

        } catch (Exception ex) {
            System.out.println("System sucks at: " + ex);
        }
//        }
    }



    private void BackBtnActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Frame.Menu.setVisible(true);
//        ProccessingBtn.setBackground(defaultColor);
//        DeliveredBtn.setBackground(defaultColor);
//        CanceledBtn.setBackground(defaultColor);
    }

    private void CanceledBtnActionPerformed(ActionEvent evt) {
        this.TabbedPanelIndex = 2;
        TabbedPanel.setSelectedIndex(2);
        updateTotalInfoPanel();
        cancelPageLogic();
        ProccessingBtn.setBackground(defaultColor);
        DeliveredBtn.setBackground(defaultColor);
        CanceledBtn.setBackground(clickedColor);
        BackBtn.setBackground(defaultColor);
    }

    private void ProccessingBtnActionPerformed(ActionEvent evt) {
        MainMenu.getOrderDatas();
        updateTotalInfoPanel();
        TabbedPanel.setSelectedIndex(0);
        orderPageLogic();
        this.TabbedPanelIndex = 0;
        ProccessingBtn.setBackground(clickedColor);
        DeliveredBtn.setBackground(defaultColor);
        CanceledBtn.setBackground(defaultColor);
        BackBtn.setBackground(defaultColor);
    }//GEN-LAST:event_ProccessingBtnActionPerformed

    private void DeliveredBtnActionPerformed(ActionEvent evt) {
        TabbedPanel.setSelectedIndex(1);
        updateTotalInfoPanel();
        this.TabbedPanelIndex = 1;
        deliveredPageLogic();
        ProccessingBtn.setBackground(defaultColor);
        DeliveredBtn.setBackground(clickedColor);
        CanceledBtn.setBackground(defaultColor);
        BackBtn.setBackground(defaultColor);
    }

    private void CancelOrderBtn1ActionPerformed(ActionEvent evt) {

        if (orders.exists()) {
//   getting data from file 
            Scanner inputBuffer;
            try {
                inputBuffer = new Scanner(orders);

                while (inputBuffer.hasNext()) {
                    String line = inputBuffer.nextLine();
                    String[] values = line.split(",");

                    this.itemPanel1.setVisible(true);
                    // order checking condition 
                    if (values[5].equals("pending") && values[1].equals("Burger")) {
                        removeLineFromFile(values[0]);
                        this.orderNo1.setText("0");
                        this.FoodName1.setText("Burger");
                        this.price1.setText(MainMenu.FMenu.getBurgerPrice() + " BDT");
                        this.qty1.setText("0 piece");
                        this.orderStatus1.setText("Order Cancelled!");
                        this.EstimedtedProccessingTime1.setText("not set");
                        CancelOrderBtn1.setEnabled(false);
                        orderStatus1.setForeground(Color.RED);
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    private void CancelOrderBtn2ActionPerformed(ActionEvent evt) {
        if (orders.exists()) {
//   getting data from file 
            Scanner inputBuffer;
            try {
                inputBuffer = new Scanner(orders);

                while (inputBuffer.hasNext()) {
                    String line = inputBuffer.nextLine();
                    String[] values = line.split(",");
                    this.itemPanel2.setVisible(true);

//            pizza component
                    if (values[5].equals("pending") && values[1].equals("Pizza")) {
                        removeLineFromFile(values[0]);
                        this.itemPanel2.setVisible(true);
                        this.orderNo2.setText("0");
                        this.FoodName2.setText("Pizza");
                        this.price2.setText(MainMenu.FMenu.getPizzaPrice() + " BDT");
                        this.qty2.setText("0 piece");
                        this.orderStatus2.setText("Order Cancelled!");
                        CancelOrderBtn2.setEnabled(false);
                        orderStatus2.setForeground(Color.RED);
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void payBtnActionPerformed(ActionEvent evt) {

        PF.setVisible(true);
        if (Orders.Auth) {
            PF.getAuthUserData(Orders.ID);
            if (paymentForm.userPaymentStatus.equals("paid")) {
                PF.getLoginBtn().setEnabled(false);
            } else {
                PF.getLoginBtn().setEnabled(true);
            }
        }
        PF.tryAuth();

    }


   

    public static double getTotal() {
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

    public static boolean isAuth() {
        return Auth;
    }

    public static void setAuth(boolean aAuth) {
        Auth = aAuth;
    }

    public static String[] getCoupons() {
        return Coupons;
    }

    public String getID() {
        return ID;
    }

    public static void setID(String aID) {
        ID = aID;
    }

}
