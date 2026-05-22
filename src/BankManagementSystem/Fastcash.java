package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Fastcash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, back;
    String pin, card;
    Fastcash(String pin, String card) {
        this.pin = pin;
        this.card = card;
        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        ImageIcon i1 = new ImageIcon(
            ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(
            900, 860, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 860);
        add(img);
        JLabel txt = new JLabel("Select Withdraw Amount");
        txt.setBounds(210, 300, 700, 35);
        txt.setForeground(Color.white);
        txt.setFont(new Font("Raleway", Font.BOLD, 16));
        img.add(txt);
        b1 = new JButton("Rs 100");
        b1.setBounds(170, 400, 150, 25);
        b1.addActionListener(this);
        img.add(b1);
        b2 = new JButton("Rs 500");
        b2.setBounds(355, 400, 150, 25);
        b2.addActionListener(this);
        img.add(b2);
        b3 = new JButton("Rs 1000");
        b3.setBounds(170, 432, 150, 25);
        b3.addActionListener(this);
        img.add(b3);
        b4 = new JButton("Rs 2000");
        b4.setBounds(355, 432, 150, 25);
        b4.addActionListener(this);
        img.add(b4);
        b5 = new JButton("Rs 5000");
        b5.setBounds(170, 465, 150, 25);
        b5.addActionListener(this);
        img.add(b5);
        b6 = new JButton("Rs 10000");
        b6.setBounds(355, 465, 150, 25);
        b6.addActionListener(this);
        img.add(b6);
        back = new JButton("Back");
        back.setBounds(355, 500, 150, 25);
        back.addActionListener(this);
        img.add(back);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Fastcash("", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Atm_Content(pin, card);
        } else {
            String amt = ((JButton) e.getSource()).getText();
            amt = amt.replace("Rs ", "");
            String q1 = "SELECT SUM(CASE WHEN type='Deposit' "
                      + "THEN amount ELSE -amount END) "
                      + "AS bal FROM bank WHERE cardno=?";
            String q2 = "INSERT INTO bank"
                      + "(cardno, date, type, amount) "
                      + "VALUES(?,?,?,?)";
            try {
                DBConnection con = new DBConnection();
                PreparedStatement pst1 = con.c.prepareStatement(q1);
                pst1.setString(1, card);
                ResultSet rs = pst1.executeQuery();
                double bal = 0;
                if (rs.next()) bal = rs.getDouble("bal");
                if (bal < Double.parseDouble(amt)) {
                    JOptionPane.showMessageDialog(null, 
                        "Insufficient Balance");
                    return;
                }
                PreparedStatement pst2 = con.c.prepareStatement(q2);
                pst2.setString(1, card);
                pst2.setString(2, new Date().toString());
                pst2.setString(3, "Withdrawl");
                pst2.setString(4, amt);
                pst2.executeUpdate();
                JOptionPane.showMessageDialog(null, 
                    "Rs " + amt + " Withdrawn");
                rs.close();
                pst1.close();
                pst2.close();
                con.c.close();
                setVisible(false);
                new Atm_Content(pin, card);
            } catch (Exception err) {
                System.out.println(err);
            }
        }
    }
}