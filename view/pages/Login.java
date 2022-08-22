package view.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import view.Frame;

public class Login extends JFrame {

    private File Tables = new File(System.getProperty("user.dir")+"\\files\\Tables.txt");
    private String pass;
    private String TableNo;


    
    private JLabel Background;
    private JLabel PasswordLabel;
    private JLabel TableNoLabel;
    private JTextField TableNoText;
    private JLabel TitleLabel;
    private JButton btnClear;
    private JButton btnExit;
    private JButton btnLogin;
    private JPasswordField passwordText;
     
    public Login() {
        TableNoText = new JTextField();
        TableNoLabel = new JLabel();
        TitleLabel = new JLabel();
        PasswordLabel = new JLabel();
        passwordText = new JPasswordField();
        btnClear = new JButton();
        btnExit = new JButton();
        btnLogin = new JButton();
        Background = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Panel");
        setBounds(new Rectangle(0, 0, 0, 0));
        setName("Login"); 
        setSize(new Dimension(0, 0));
        getContentPane().setLayout(null);

        TableNoText.setFont(new Font("Segoe UI", 1, 14)); 
        TableNoText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                TableNoTextKeyReleased(evt);
            }
        });
        getContentPane().add(TableNoText);
        TableNoText.setBounds(330, 240, 310, 26);

        TableNoLabel.setFont(new Font("Segoe UI", 1, 14)); 
        TableNoLabel.setForeground(new Color(255, 255, 255));
        TableNoLabel.setText("Table No.");
        getContentPane().add(TableNoLabel);
        TableNoLabel.setBounds(230, 240, 100, 20);

        TitleLabel.setFont(new Font("Segoe UI", 1, 36)); 
        TitleLabel.setForeground(new Color(255, 204, 153));
        TitleLabel.setText("Login");
        getContentPane().add(TitleLabel);
        TitleLabel.setBounds(380, 130, 94, 48);

        PasswordLabel.setFont(new Font("Segoe UI", 1, 14)); 
        PasswordLabel.setForeground(new Color(255, 255, 255));
        PasswordLabel.setText("Password");
        getContentPane().add(PasswordLabel);
        PasswordLabel.setBounds(230, 290, 64, 20);

        passwordText.setFont(new Font("Segoe UI", 1, 14)); 
        passwordText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                passwordTextKeyReleased(evt);
            }
        });
        getContentPane().add(passwordText);
        passwordText.setBounds(330, 290, 310, 26);

        btnClear.setFont(new Font("Tahoma", 1, 14)); 
        btnClear.setText("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(330, 340, 150, 30);

        btnExit.setFont(new Font("Tahoma", 1, 14)); 
        btnExit.setText("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(490, 340, 150, 30);

        btnLogin.setFont(new Font("Tahoma", 1, 14)); 
        btnLogin.setText("Login");
        btnLogin.setEnabled(false);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(230, 390, 410, 50);

        Background.setIcon(new ImageIcon(getClass().getResource("/test/images/pureBG.png"))); 
        getContentPane().add(Background);
        Background.setBounds(0, -190, 1320, 1100);

        pack();
        this.setSize(800,680);
        this.setLocationRelativeTo(null);
    }
    
    
    
    public void clear() {
        TableNoText.setText("");
        passwordText.setText("");
    }

    public void validated() {
        TableNo = TableNoText.getText();
        pass = String.valueOf(passwordText.getPassword());
        if (TableNo.isEmpty() || pass.isEmpty()) {
            btnLogin.setEnabled(false);
        } else {
            btnLogin.setEnabled(true);
        }
        
    }


   
    private void TableNoTextKeyReleased(KeyEvent e) {
        validated();
    }


    private void passwordTextKeyReleased(KeyEvent e) {
        validated();
    }

    private void btnClearActionPerformed(ActionEvent e) {
 
        clear();
    }

    private void btnExitActionPerformed(ActionEvent e) {
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        try {                                         
//   getting data from users file 
            Scanner inputBuffer = new Scanner(Tables);
            try {
                 while (inputBuffer.hasNext()) {
                    String line = inputBuffer.nextLine();
                    String [] values = line.split(",");
                    
 //  checking authentication
            if (values[1].equals(TableNo) && values[2].equals(pass)) {
                setVisible(false);
                new Frame();
                System.out.println(values[0]+" Authorized");
                break;
            } 
             if(!inputBuffer.hasNext() && !TableNo.equals(values[1]) && !pass.equals(values[2])){
            JOptionPane.showMessageDialog(null, "Credentials Mismatched", "Something went wrong!", JOptionPane.ERROR_MESSAGE);
            }
                } // end while
            } catch (HeadlessException ev) {
                System.out.println(ev);
            }
           

        } catch (FileNotFoundException er) {
            System.out.println(er);
        }
    }
}
