package orders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import view.pages.FoodMenu;

public class paymentForm extends JFrame {

    private File file = new File(System.getProperty("user.dir") + "\\src\\files\\Users.txt");
    private File ordersFile = new File(System.getProperty("user.dir") + "\\src\\files\\Orders.txt");
    private File ordersTempFile = new File(System.getProperty("user.dir") + "\\src\\files\\Orders-temp.txt");
    private File tempFile = new File(System.getProperty("user.dir") + "\\src\\files\\Users-Temp.txt");
    private static Integer ID = 0;
    private static String name, address, mobileNumber, amount,coupon, password;
    public static String userPaymentStatus = "unpaid";
    private Orders OrderObj;
    private LoginForm LF;
    public static Boolean orderCondition;
    private FoodMenu FM;
    public static String FoodType = "";



    

    private JButton LoginBtn;
    private JPasswordField PasswordField;
    private JPanel SignUpPanel;
    private JTextField addressField;
    private JLabel addressLabel;
    private JTextField amountField;
    private JLabel amountLabel;
    private JButton completePayBtn;
    private JTextField couponField;
    private JLabel couponLabel;
    private JPanel headingPanel;
    private JLabel mobileNoLabel;
    private JTextField mobileNumberField;
    private JTextField nameField;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel titleLabel;


    public paymentForm() {
        getId();
        headingPanel = new JPanel();
        titleLabel = new JLabel();
        SignUpPanel = new JPanel();
        amountField = new JTextField();
        amountLabel = new JLabel();
        couponField = new JTextField();
        couponLabel = new JLabel();
        LoginBtn = new JButton();
        nameField = new JTextField();
        nameLabel = new JLabel();
        mobileNumberField = new JTextField();
        mobileNoLabel = new JLabel();
        completePayBtn = new JButton();
        passwordLabel = new JLabel();
        addressLabel = new JLabel();
        addressField = new JTextField();
        PasswordField = new JPasswordField();

        setTitle("user information and payment");
        setBackground(new Color(0, 0, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        headingPanel.setBackground(new Color(0, 163, 204));
        headingPanel.setLayout(null);

        titleLabel.setFont(new Font("Segoe UI", 1, 14)); 
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setText("Clear due payment & create your profile");
        headingPanel.add(titleLabel);
        titleLabel.setBounds(80, 10, 330, 30);

        getContentPane().add(headingPanel);
        headingPanel.setBounds(0, 0, 450, 50);

        SignUpPanel.setBackground(new Color(222, 228, 244));
        SignUpPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        SignUpPanel.setLayout(null);

        amountField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                amountFieldKeyReleased(evt);
            }
        });
        SignUpPanel.add(amountField);
        amountField.setBounds(190, 180, 240, 34);

        amountLabel.setText("Enter Amount:");
        SignUpPanel.add(amountLabel);
        amountLabel.setBounds(30, 180, 150, 34);

        couponField.setText("do you have any coupons?");
        couponField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                couponFieldMouseClicked(evt);
            }
        });
   
        SignUpPanel.add(couponField);
        couponField.setBounds(190, 230, 240, 34);

        couponLabel.setText("Coupons:");
        SignUpPanel.add(couponLabel);
        couponLabel.setBounds(30, 230, 150, 34);

        LoginBtn.setBackground(new Color(0, 162, 237));
        LoginBtn.setText("Already registered?");
        LoginBtn.setFocusable(false);
        LoginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        SignUpPanel.add(LoginBtn);
        LoginBtn.setBounds(230, 370, 200, 54);

        nameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });
        SignUpPanel.add(nameField);
        nameField.setBounds(190, 30, 240, 34);

        nameLabel.setText("Your Name:");
        SignUpPanel.add(nameLabel);
        nameLabel.setBounds(30, 30, 150, 34);

        mobileNumberField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                mobileNumberFieldKeyReleased(evt);
            }
        });
        SignUpPanel.add(mobileNumberField);
        mobileNumberField.setBounds(190, 130, 240, 34);

        mobileNoLabel.setText("Mobile Number:");
        SignUpPanel.add(mobileNoLabel);
        mobileNoLabel.setBounds(30, 130, 150, 34);

        completePayBtn.setBackground(new Color(0, 162, 237));
        completePayBtn.setText("Complete Payment");
        completePayBtn.setEnabled(false);
        completePayBtn.setFocusable(false);
        completePayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                completePayBtnActionPerformed(evt);
            }
        });
        SignUpPanel.add(completePayBtn);
        completePayBtn.setBounds(20, 370, 190, 54);

        passwordLabel.setText("Password:");
        SignUpPanel.add(passwordLabel);
        passwordLabel.setBounds(30, 80, 150, 34);

        addressLabel.setText("Address:");
        SignUpPanel.add(addressLabel);
        addressLabel.setBounds(30, 280, 150, 34);

        addressField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                addressFieldKeyReleased(evt);
            }
        });
        SignUpPanel.add(addressField);
        addressField.setBounds(190, 280, 240, 34);

        PasswordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                PasswordFieldKeyReleased(evt);
            }
        });
        SignUpPanel.add(PasswordField);
        PasswordField.setBounds(190, 80, 240, 40);

        getContentPane().add(SignUpPanel);
        SignUpPanel.setBounds(0, 50, 450, 450);
        tryAuth();
        setSize(460, 540);
        setLocationRelativeTo(null);
    }

    public void setPaymentFormAndOrderObj(Orders orders, LoginForm lf, FoodMenu FM) {
        this.OrderObj = orders;
        this.LF = lf;
        this.FM = FM;
    }


    public void tryAuth() {
        if (Orders.Auth) {
            LoginBtn.setEnabled(false);
            nameField.setText(name);
            mobileNumberField.setText(mobileNumber);
            addressField.setText(address);
            amountField.setText(String.valueOf(Orders.getTotal()));
            FoodMenu.setTotalCost(0.0);
        }
    }

    public void getAuthUserData(String id) {
        String vals[];
        try {
            String line;
            BufferedReader BR = new BufferedReader(new FileReader(file));
            while ((line = BR.readLine()) != null) {
                vals = line.split(",");
                if (id.equals(vals[0])) {
                    paymentForm.ID = Integer.parseInt(id);
                    paymentForm.name = vals[1];
                    paymentForm.password = vals[2];
                    paymentForm.mobileNumber = vals[3];
                    paymentForm.address = vals[6];
                    paymentForm.userPaymentStatus = vals[7];
                }
            }
            BR.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void getId() {
        String vals[];
        try {
            String line;
            BufferedReader BR = new BufferedReader(new FileReader(file));
            while ((line = BR.readLine()) != null) {
                vals = line.split(",");
                ID = Integer.parseInt(vals[0]);
                Orders.ID = String.valueOf(ID);
                ID++;
            }
            BR.close();
            System.out.println("latest ID: " + ID);

        } catch (Exception ex) {
            System.out.println(ex + " getId()");
        }

    }

    private void addUser() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") + "\\src\\files\\Users.txt"), true));
            bufferedWriter.write(ID + "," + name + "," + password + "," + mobileNumber + "," + Orders.ApplyCoupon(coupon) + "," + coupon + "," + address + "," + "unpaid" + "\n");
            bufferedWriter.close();
            System.out.println("User Added & current ID: "+ ID);
            Orders.ID = String.valueOf(ID);
            Orders.setAuth(true);
        } catch (IOException ex) {
            System.out.println(ex + " addUSer()");
        }
    }
    private void LoginBtnActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        LF.setVisible(true);

    }

    private void nameFieldKeyReleased(KeyEvent evt) {
        validationRules();
    }

    private void mobileNumberFieldKeyReleased(KeyEvent evt) {
        validationRules();
    }

    private void amountFieldKeyReleased(KeyEvent evt) {
        validationRules();
    }


    private void couponFieldMouseClicked(MouseEvent evt) {
        couponField.setText("");
    }


    private void completePayBtnActionPerformed(ActionEvent evt) {
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                String currentLineToCheckExistingUser;
                String currentLine;
                String currentData;

                while ((currentLineToCheckExistingUser = reader.readLine()) != null) {
                    String[] trimLine = currentLineToCheckExistingUser.split(",");
                    if (!trimLine[0].equals(String.valueOf(Orders.ID))) {
                        addUser();
                        break;
                    } else {
                        System.out.println("user exists!");
                         Orders.setAuth(true);
                    }
                }
                reader.close();
                BufferedReader Reader = new BufferedReader(new FileReader(file));
                while ((currentLine = Reader.readLine()) != null) {
                    // trim newline when comparing with ID
                    currentLine = currentLine.trim();
                    String[] trimLine = currentLine.split(",");

                    if (trimLine[0].equals(String.valueOf(Orders.ID))) {
                        writer.write(trimLine[0] + "," + trimLine[1] + "," + trimLine[2] + "," + trimLine[3] + "," + Orders.ApplyCoupon(this.coupon) + "," + this.coupon + "," + trimLine[6] + "," + "paid" + "\n");
                        continue;
                    }
                    writer.write(currentLine + "\n");
                }
                writer.close();
                reader.close();
                BufferedWriter BW = new BufferedWriter(new FileWriter(file));
                BufferedReader BR = new BufferedReader(new FileReader(tempFile));

                while ((currentData = BR.readLine()) != null) {
                    BW.write(currentData + "\n");
                }

                BW.close();
                BR.close();

                BufferedReader orderReader = new BufferedReader(new FileReader(ordersFile));
                BufferedWriter orderWriter = new BufferedWriter(new FileWriter(ordersTempFile));
                String currentLineData;
                
                while ((currentLineData = orderReader.readLine()) != null) {
                    
                    String trimLine[] = currentLineData.split(",");
                    if (trimLine[4].trim().equals(String.valueOf(Orders.ID))) {
                        orderWriter.write(trimLine[0] + "," + trimLine[1] + "," + trimLine[2] + "," + trimLine[4] + "," + amountField.getText() + "," + trimLine[5] + "," + trimLine[6] + "," + trimLine[7] + "," + trimLine[8] + "," + "paid" + "\n");
                        continue;
                    }
                    orderWriter.write(currentLineData + "\n");
                }
                orderReader.close();
                orderWriter.close();
                
                BufferedReader ReadTempOrderFile = new BufferedReader(new FileReader(ordersTempFile));
                BufferedWriter WriteOrderFile = new BufferedWriter(new FileWriter(ordersFile));
                String currentOrderData;
                 while ((currentOrderData = ReadTempOrderFile.readLine()) != null) {
                    WriteOrderFile.write(currentOrderData + "\n");
                }
                 WriteOrderFile.close();
                 ReadTempOrderFile.close();
                 
                if (Orders.CouponStatus == null) {

                    JOptionPane.showMessageDialog(this, "You're registered & Payment completed successfully!", "Authentication success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, Orders.CouponStatus, "Authorization and coupon apply success", JOptionPane.INFORMATION_MESSAGE);
                }
                Orders.setAuth(true);
                OrderObj.orderPageLogic();
                OrderObj.updateTotalInfoPanel();
                this.setVisible(false);
                FM.AuthCheck(FoodType);
            } catch (Exception e) {
                System.out.println(e + " completePayBtnActionPerformed");
            }

        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    private void addressFieldKeyReleased(KeyEvent evt) {
        validationRules();
    }

    private void PasswordFieldKeyReleased(KeyEvent evt) {
        validationRules();
    }


    private void validationRules() {
        if (!nameField.getText().isEmpty() && !addressField.getText().isEmpty()
                && !mobileNumberField.getText().isEmpty() && !amountField.getText().isEmpty()
                && !String.valueOf(PasswordField.getPassword()).isEmpty()) {
            completePayBtn.setEnabled(true);
            name = nameField.getText();
            address = addressField.getText();
            password = String.valueOf(PasswordField.getPassword());
            mobileNumber = mobileNumberField.getText();
            amount = amountField.getText();

            if (couponField.getText().equals("do you have any coupons?")) {
                coupon = "no coupon";
            } else {
                coupon = couponField.getText();
            }
        } else {
            completePayBtn.setEnabled(false);
        }
    }

//    unnesseccery 
//    public void isSatisfyOrderCondition(Boolean B, String F) {
//        if (B) {
//            switch (F) {
//                case "Burger" -> FM.createBurgerOrder();
//                case "Pizza" -> FM.createPizzaOrder();
//                default -> {
//                }
//            }
//        }
//    }

    public JButton getLoginBtn() {
        return LoginBtn;
    }

    public JTextField getAmountField() {
        return amountField;
    }

}
