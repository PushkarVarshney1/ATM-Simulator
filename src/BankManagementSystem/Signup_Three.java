package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class Signup_Three extends JFrame implements ActionListener {

    String formno;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;

    public Signup_Three(String formno) {
        this.formno = formno;
        setLayout(null);
        setSize(850, 820);
        setLocation(350, 10);
        setTitle("Account Application Form:-Page 3");

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare data is correct");
        c7.setBackground(Color.white);
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.cyan);
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.cyan);
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup_Three("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accType = null;
            if (r1.isSelected()) accType = "Saving Account";
            else if (r2.isSelected()) accType = "Fixed Deposit";
            else if (r3.isSelected()) accType = "Current Account";
            else if (r4.isSelected()) accType = "Recurring Deposit";

            Random ran = new Random();
            long cNum = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardnumber = "" + Math.abs(cNum);
            
            long pNum = (ran.nextLong() % 9000L) + 1000L;
            String pinnumber = "" + Math.abs(pNum);

            String facility = "";
            if (c1.isSelected()) facility += "ATM Card, ";
            if (c2.isSelected()) facility += "Internet Banking, ";
            if (c3.isSelected()) facility += "Mobile Banking, ";
            if (c4.isSelected()) facility += "EMAIL & SMS, ";
            if (c5.isSelected()) facility += "Cheque Book, ";
            if (c6.isSelected()) facility += "E-Statement";

            String q1 = "INSERT INTO signupthree VALUES(?,?,?,?,?)";
            String q2 = "INSERT INTO login VALUES(?,?,?)";

            try {
                if (accType == null || !c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, 
                        "Select Account Type and Check Declaration");
                    return;
                }
                DBConnection con = new DBConnection();
                PreparedStatement pst1 = con.c.prepareStatement(q1);
                pst1.setString(1, formno);
                pst1.setString(2, accType);
                pst1.setString(3, cardnumber);
                pst1.setString(4, pinnumber);
                pst1.setString(5, facility);
                pst1.executeUpdate();

                PreparedStatement pst2 = con.c.prepareStatement(q2);
                pst2.setString(1, formno);
                pst2.setString(2, cardnumber);
                pst2.setString(3, pinnumber);
                pst2.executeUpdate();

                JOptionPane.showMessageDialog(null, 
                    "Card: " + cardnumber + "\n PIN: " + pinnumber);

                pst1.close();
                pst2.close();
                con.c.close();
                
                setVisible(false);
                new Login();
            } catch (Exception err) {
                System.out.println(err);
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login();
        }
    }
}