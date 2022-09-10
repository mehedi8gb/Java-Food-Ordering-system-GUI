package view.pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.Frame;
import orders.Orders;
import orders.paymentForm;


public class FoodMenu extends JPanel {

    private int bQty = 0;
    private int pQty = 0;
    private int orderNo = 0;
    private double burgerPrice = 10, pizzaPrice = 40, totalPrice;
    private paymentForm PF;
    private static Double totalCost = 0.0;
    private double pCost;
    private double bCost;



    
    private JLabel FoodmenuImage;
    private JPanel Header;
    private JLabel Qty1;
    private JLabel Qty2;
    private JLabel bPrice1;
    private JLabel bPrice2;
    private JButton backBtn;
    private JButton btnOrder1;
    private JButton btnOrder2;
    private JLabel itemBurger1;
    private JLabel itemIcon1;
    private JLabel itemIcon2;
    private JLabel itemLabel1;
    private JLabel itemLabel2;
    private JPanel itemPanel1;
    private JPanel itemPanel2;
    private JLabel itemPizza;
    private JLabel itemPrice1;
    private JLabel itemPrice2;
    private JLabel itemQty1;
    private JLabel itemQty2;
    private JLabel menuLabel;
    private JButton qtyMinus1;
    private JButton qtyMinus2;
    private JButton qtyPlus1;
    private JButton qtyPlus2;


    public FoodMenu() {
        itemPanel2 = new JPanel();
        btnOrder2 = new JButton();
        itemQty2 = new JLabel();
        qtyMinus2 = new JButton();
        qtyPlus2 = new JButton();
        itemIcon2 = new JLabel();
        Qty2 = new JLabel();
        itemLabel2 = new JLabel();
        itemPizza = new JLabel();
        itemPrice2 = new JLabel();
        bPrice2 = new JLabel();
        backBtn = new JButton();
        Header = new JPanel();
        menuLabel = new JLabel();
        itemPanel1 = new JPanel();
        btnOrder1 = new JButton();
        itemQty1 = new JLabel();
        qtyMinus1 = new JButton();
        qtyPlus1 = new JButton();
        itemIcon1 = new JLabel();
        Qty1 = new JLabel();
        itemLabel1 = new JLabel();
        itemBurger1 = new JLabel();
        itemPrice1 = new JLabel();
        bPrice1 = new JLabel();
        FoodmenuImage = new JLabel();

        setLayout(null);

        itemPanel2.setBackground(new Color(233, 224, 230));
        itemPanel2.setLayout(null);

        btnOrder2.setFont(new Font("Segoe UI Semibold", 1, 14)); 
        btnOrder2.setText("Order now");
        btnOrder2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOrder2ActionPerformed(evt);
            }
        });
        itemPanel2.add(btnOrder2);
        btnOrder2.setBounds(130, 270, 130, 49);

        itemQty2.setFont(new Font("Segoe UI", 1, 14)); 
        itemQty2.setText("Quantity: ");
        itemPanel2.add(itemQty2);
        itemQty2.setBounds(20, 260, 70, 20);

        qtyMinus2.setFont(new Font("Segoe UI Black", 1, 18)); 
        qtyMinus2.setText("-");
        qtyMinus2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                qtyMinus2ActionPerformed(evt);
            }
        });
        itemPanel2.add(qtyMinus2);
        qtyMinus2.setBounds(70, 290, 50, 30);

        qtyPlus2.setFont(new Font("Segoe UI Black", 1, 14)); 
        qtyPlus2.setText("+");
        qtyPlus2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                qtyPlus2MouseClicked(evt);
            }
        });
        qtyPlus2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                qtyPlus2ActionPerformed(evt);
            }
        });
        itemPanel2.add(qtyPlus2);
        qtyPlus2.setBounds(10, 290, 50, 30);

        itemIcon2.setIcon(new ImageIcon(getClass().getResource("/test/images/foods/pizza.jpg"))); 
        itemIcon2.setText("a");
        itemPanel2.add(itemIcon2);
        itemIcon2.setBounds(10, 0, 250, 230);

        Qty2.setFont(new Font("Segoe UI", 1, 14)); 
        Qty2.setText("0");
        itemPanel2.add(Qty2);
        Qty2.setBounds(90, 260, 20, 20);

        itemLabel2.setFont(new Font("Segoe UI", 1, 14)); 
        itemLabel2.setText("Dish:");
        itemPanel2.add(itemLabel2);
        itemLabel2.setBounds(20, 230, 32, 20);

        itemPizza.setFont(new Font("Segoe UI", 1, 14)); 
        itemPizza.setForeground(new Color(255, 102, 102));
        itemPizza.setText("Pizza");
        itemPanel2.add(itemPizza);
        itemPizza.setBounds(60, 230, 60, 20);

        itemPrice2.setFont(new Font("Segoe UI", 1, 14)); 
        itemPrice2.setText("Price:");
        itemPanel2.add(itemPrice2);
        itemPrice2.setBounds(140, 230, 50, 20);

        bPrice2.setFont(new Font("Segoe UI", 1, 14)); 
        bPrice2.setForeground(new Color(255, 102, 102));
        bPrice2.setText("40.0 BDT");
        itemPanel2.add(bPrice2);
        bPrice2.setBounds(190, 230, 80, 20);

        add(itemPanel2);
        itemPanel2.setBounds(320, 110, 270, 330);

        backBtn.setText("Back");
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn);
        backBtn.setBounds(30, 70, 110, 30);

        Header.setBackground(new Color(51, 51, 51));
        Header.setLayout(null);

        menuLabel.setFont(new Font("Gadugi", 1, 18)); 
        menuLabel.setForeground(new Color(204, 204, 255));
        menuLabel.setText("Food Menu");
        Header.add(menuLabel);
        menuLabel.setBounds(620, 40, 170, 40);

        add(Header);
        Header.setBounds(-20, -30, 1300, 90);

        itemPanel1.setBackground(new Color(233, 224, 230));
        itemPanel1.setLayout(null);

        btnOrder1.setFont(new Font("Segoe UI Semibold", 1, 14)); 
        btnOrder1.setText("Order now");
        btnOrder1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOrder1ActionPerformed(evt);
            }
        });
        itemPanel1.add(btnOrder1);
        btnOrder1.setBounds(130, 270, 130, 49);

        itemQty1.setFont(new Font("Segoe UI", 1, 14)); 
        itemQty1.setText("Quantity: ");
        itemPanel1.add(itemQty1);
        itemQty1.setBounds(20, 260, 70, 20);

        qtyMinus1.setFont(new Font("Segoe UI Black", 1, 18)); 
        qtyMinus1.setText("-");
        qtyMinus1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                qtyMinus1ActionPerformed(evt);
            }
        });
        itemPanel1.add(qtyMinus1);
        qtyMinus1.setBounds(70, 290, 50, 30);

        qtyPlus1.setFont(new Font("Segoe UI Black", 1, 14)); 
        qtyPlus1.setText("+");
        qtyPlus1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                qtyPlus1ActionPerformed(evt);
            }
        });
        itemPanel1.add(qtyPlus1);
        qtyPlus1.setBounds(10, 290, 50, 30);

        itemIcon1.setIcon(new ImageIcon(getClass().getResource("/test/images/foods/burger.jpg"))); 
        itemIcon1.setText("a");
        itemPanel1.add(itemIcon1);
        itemIcon1.setBounds(10, 10, 250, 210);

        Qty1.setFont(new Font("Segoe UI", 1, 14)); 
        Qty1.setText("0");
        itemPanel1.add(Qty1);
        Qty1.setBounds(90, 260, 20, 20);

        itemLabel1.setFont(new Font("Segoe UI", 1, 14)); 
        itemLabel1.setText("Dish:");
        itemPanel1.add(itemLabel1);
        itemLabel1.setBounds(20, 230, 32, 20);

        itemBurger1.setFont(new Font("Segoe UI", 1, 14)); 
        itemBurger1.setForeground(new Color(255, 102, 102));
        itemBurger1.setText("Burger");
        itemPanel1.add(itemBurger1);
        itemBurger1.setBounds(60, 230, 60, 20);

        itemPrice1.setFont(new Font("Segoe UI", 1, 14)); 
        itemPrice1.setText("Price:");
        itemPanel1.add(itemPrice1);
        itemPrice1.setBounds(140, 230, 50, 20);

        bPrice1.setFont(new Font("Segoe UI", 1, 14)); 
        bPrice1.setForeground(new Color(255, 102, 102));
        bPrice1.setText("10.0 BDT");
        itemPanel1.add(bPrice1);
        bPrice1.setBounds(190, 230, 80, 20);

        add(itemPanel1);
        itemPanel1.setBounds(30, 110, 270, 330);

        FoodmenuImage.setIcon(new ImageIcon(getClass().getResource("/test/images/food-menu-bg.jpg"))); 
        add(FoodmenuImage);
        FoodmenuImage.setBounds(0, 60, 1290, 720);

    }
//new 

    public void setPaymentForm(paymentForm pf) {
        PF = pf;
    }

    private void setOrderNo() {

        if (orderNo == 0) {
            try {
                String line;
                String[] fullList;
                BufferedReader bw = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\files\\Orders.txt"));
                while ((line = bw.readLine()) != null) {
                    fullList = line.split(",");
                    orderNo = Integer.parseInt(fullList[0]);
                    orderNo++;
                    MainMenu.order.getOrderNo1().setText(String.valueOf(orderNo));
                    MainMenu.order.getOrderNo2().setText(String.valueOf(orderNo));
                }
                bw.close();
                System.out.println("latest Order no: " + orderNo);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            orderNo++;
            MainMenu.order.getOrderNo1().setText(String.valueOf(orderNo));
            MainMenu.order.getOrderNo2().setText(String.valueOf(orderNo));
        }
    }

    public void AuthCheck(String foodType) {
        if (Orders.isAuth()) {
            if (foodType.equals("Burger")) {
                createBurgerOrder("paid");
                System.out.println(foodType);
            } else if (foodType.equals("Pizza")) {
                createPizzaOrder("paid");
                System.out.println(foodType);
            }
        }
    }



    private void qtyPlus2ActionPerformed(ActionEvent evt) {
        if (pQty >= 0 && pQty < 50) {
            ++pQty;
            double tmp = pizzaPrice * pQty;
            pCost = tmp;
            totalCost = tmp + bCost;
            totalPrice = tmp;
            bPrice2.setText(String.valueOf(tmp + " BDT"));
            Qty2.setText(String.valueOf(pQty));
        }
    }

    private void qtyMinus2ActionPerformed(ActionEvent evt) {
        if (pQty > 1 && pQty < 50) {
            --pQty;
            double tmp = pizzaPrice * pQty;
            pCost = tmp;
            totalCost = tmp - bCost;
            totalPrice = tmp;
            bPrice2.setText(String.valueOf(tmp + " BDT"));
            Qty2.setText(String.valueOf(pQty));
        }
    }

    private void backBtnActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Frame.Menu.setVisible(true);
    }

    private void qtyPlus2MouseClicked(MouseEvent evt) {

    }

    private void btnOrder2ActionPerformed(ActionEvent evt) {
        paymentForm.FoodType = "Pizza";
        if (Orders.isAuth()) {
            createPizzaOrder("unpaid");
        }
        else if (pQty == 0) {
             JOptionPane.showMessageDialog(null, "No item selected for order please add by clicking plus button!", "Order issues", JOptionPane.ERROR_MESSAGE);
        }
        else {
            
            PF.setVisible(true);
            PF.getAmountField().setText(String.valueOf(totalCost));
            PF.getAmountField().setEditable(false);
            PF.tryAuth();
        }
    }

    private void btnOrder1ActionPerformed(ActionEvent evt) {
        paymentForm.FoodType = "Burger";
        if (Orders.isAuth()) {
            createBurgerOrder("unpaid");
        } else if (bQty == 0) {
             JOptionPane.showMessageDialog(null, "No item selected for order please add by clicking plus button!", "Order issues", JOptionPane.ERROR_MESSAGE);
        } else {
            PF.setVisible(true);
            PF.getAmountField().setText(String.valueOf(totalCost));
            PF.getAmountField().setEditable(false);
            PF.tryAuth();
            AuthCheck("Burger");

        }
    }

    private void qtyMinus1ActionPerformed(ActionEvent evt) {
        if (bQty > 1 && bQty < 50) {
            --bQty;
            double tmp = burgerPrice * bQty;
            bCost = tmp;
            totalCost = tmp - pCost;
            totalPrice = tmp;
            bPrice1.setText(String.valueOf(tmp + " BDT"));
            Qty1.setText(String.valueOf(bQty));
        }
    }


    private void qtyPlus1ActionPerformed(ActionEvent evt) {
        if (bQty >= 0 && bQty < 50) {
            ++bQty;
            double tmp = burgerPrice * bQty;
            bCost = tmp;
            totalCost = tmp + pCost;
            totalPrice = tmp;
            bPrice1.setText(String.valueOf(tmp + " BDT"));
            Qty1.setText(String.valueOf(bQty));
        }
    }

    public double getBurgerPrice() {
        return burgerPrice;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }




    public static Double getTotalCost() {
        return totalCost;
    }

    public static void setTotalCost(Double a) {
        totalCost = a;
    }

    public void createBurgerOrder(String paymentStatus) {
        if (bQty != 0) {
            String orderCreatedAt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            setOrderNo();
            // 0 = burger
            Orders order = new Orders(orderNo, totalPrice, Orders.ID, "Burger", bQty, orderCreatedAt, paymentStatus);
            System.out.println(totalPrice + "\n" + bQty + "\n");
            bQty = 0;
            Qty1.setText(String.valueOf(bQty));
            bPrice1.setText(String.valueOf(burgerPrice + "$"));
            totalPrice = 0;
            JOptionPane.showMessageDialog(null, "Order Successfully Created check the order area!", "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "No item selected for order please add by clicking plus button!", "Order issues", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void createPizzaOrder(String paymentStatus) {
        if (pQty != 0) {
            String orderCreatedAt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            setOrderNo();
            Orders Order = new Orders(orderNo, totalPrice, Orders.ID, "Pizza", pQty, orderCreatedAt, paymentStatus); // 0 = burger
            System.out.println(totalPrice + "\n" + pQty + "\n");
            pQty = 0;
            Qty2.setText(String.valueOf(pQty));
            bPrice2.setText(String.valueOf(pizzaPrice + "$"));
            totalPrice = 0;
            JOptionPane.showMessageDialog(null, "Order Successfully Created check the order area!", "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "No item selected for order please add by clicking plus button!", "Order issues", JOptionPane.ERROR_MESSAGE);
        }
    }

}
