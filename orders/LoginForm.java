package orders;

import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class LoginForm extends JFrame {
    
    private String mobileNumber;
    private String amount;
    private String coupon;
    
    private File file = new File(System.getProperty("user.dir") + "\\src\\files\\Users.txt");
    private String password;
    private paymentForm PF;
    

        

    private JPasswordField PasswordField;
    private JPanel SignUpPanel;
    private JPanel headingPanel;
    private JButton loginBtn;
    private JLabel mobileNoLabel;
    private JTextField mobileNumberField;
    private JLabel passwordLabel;
    private JButton signUpBtn;
    private JLabel titleLabel;
 
    public LoginForm() {
 

        SignUpPanel = new JPanel();
        passwordLabel = new JLabel();
        signUpBtn = new JButton();
        mobileNumberField = new JTextField();
        mobileNoLabel = new JLabel();
        loginBtn = new JButton();
        PasswordField = new JPasswordField();
        headingPanel = new JPanel();
        titleLabel = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        setSize(460, 370);
        setLocationRelativeTo(null);
        SignUpPanel.setBackground(new Color(222, 228, 244));
        SignUpPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        SignUpPanel.setLayout(null);

        passwordLabel.setText("Password");
        SignUpPanel.add(passwordLabel);
        passwordLabel.setBounds(20, 110, 150, 34);

        signUpBtn.setBackground(new Color(0, 162, 237));
        signUpBtn.setText("Signup");
        signUpBtn.setFocusable(false);
        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        SignUpPanel.add(signUpBtn);
        signUpBtn.setBounds(230, 190, 200, 54);

        mobileNumberField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                mobileNumberFieldKeyReleased(evt);
            }
        });
        SignUpPanel.add(mobileNumberField);
        mobileNumberField.setBounds(190, 60, 240, 34);

        mobileNoLabel.setText("Mobile Number:");
        SignUpPanel.add(mobileNoLabel);
        mobileNoLabel.setBounds(20, 60, 150, 34);

        loginBtn.setBackground(new Color(0, 162, 237));
        loginBtn.setText("Login");
        loginBtn.setEnabled(false);
        loginBtn.setFocusable(false);
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        SignUpPanel.add(loginBtn);
        loginBtn.setBounds(20, 190, 190, 54);

        PasswordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                PasswordFieldKeyReleased(evt);
            }
        });
        SignUpPanel.add(PasswordField);
        PasswordField.setBounds(190, 110, 240, 40);

        getContentPane().add(SignUpPanel);
        SignUpPanel.setBounds(0, 50, 450, 280);

        headingPanel.setBackground(new Color(0, 163, 204));
        headingPanel.setLayout(null);

        titleLabel.setFont(new Font("Segoe UI", 1, 14)); 
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setText("Enter you credentials");
        headingPanel.add(titleLabel);
        titleLabel.setBounds(140, 10, 200, 30);

        getContentPane().add(headingPanel);
        headingPanel.setBounds(0, 0, 450, 50);
    }

     public void setPaymentForm(paymentForm pf){
     PF = pf;
    }

    
    private void signUpBtnActionPerformed(ActionEvent evt) {
         this.setVisible(false);
        PF.setVisible(true);
    }

    private void mobileNumberFieldKeyReleased(KeyEvent evt) {
        validationRules();
    }

    private void loginBtnActionPerformed(ActionEvent evt) {
        if (file.exists()) {
            try {
                String line;
                String vals[] = null;
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    vals = line.split(",");
                    if (this.password.equals(vals[2]) && this.mobileNumber.equals(vals[3])) {
                        Orders.setAuth(true);
                        this.dispose();
                        Orders.ID = vals[0].trim();
                        PF.getAuthUserData(vals[0]);
                        PF.tryAuth();
                        PF.setVisible(true);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void PasswordFieldKeyReleased(KeyEvent evt) {
        validationRules();
    }


    
    private void validationRules() {
        if (!mobileNumberField.getText().isEmpty() && !String.valueOf(PasswordField.getPassword()).isEmpty()) {
            loginBtn.setEnabled(true);
            this.mobileNumber = mobileNumberField.getText();
            this.password = String.valueOf(PasswordField.getPassword());
            
        } else {
            loginBtn.setEnabled(false);
        }
    }


}
