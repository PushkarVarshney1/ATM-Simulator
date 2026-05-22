package BankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit, back;
    String pin, card;
    Deposit(String pin, String card) {
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
        JLabel txt = new JLabel("Enter amount to deposit");
        txt.setForeground(Color.white);
        txt.setFont(new Font("System", Font.BOLD, 16));
        txt.setBounds(190, 300, 400, 20);
        img.add(txt);
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        img.add(amount);
        deposit = new JButton("Deposit");
        deposit.setBounds(355, 430, 150, 30);
        deposit.addActionListener(this);
        img.add(deposit);
        back = new JButton("Back");
        back.setBounds(355, 480, 150, 30);
        back.addActionListener(this);
        img.add(back);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Deposit("", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String w = amount.getText();
            Date d = new Date();
            // 1. Check if the field is empty
            if (w.equals("")) {
                JOptionPane.showMessageDialog(null, 
                    "Enter amount to deposit");
                return;
            }
            // 2. Check if the input is a valid decimal number
            try {
                Double.parseDouble(w);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Please enter a valid number (e.g., 100.50)");
                return; //if it's not a number 
            }
            // 3. If it passes the checks, execute the database query
            String q = "INSERT INTO bank(cardno, date, type, amount) "
                     + "VALUES(?,?,?,?)";
            try {
                DBConnection con = new DBConnection();
                PreparedStatement pst = con.c.prepareStatement(q);
                pst.setString(1, card);
                pst.setString(2, d.toString());
                pst.setString(3, "Deposit");
                pst.setString(4, w);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, 
                    "Rs " + w + " Deposited Successfully");
                pst.close();
                con.c.close();
                setVisible(false);
                new Atm_Content(pin, card);
            } catch (Exception err) {
                System.out.println(err);
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Atm_Content(pin, card);
        }
    }
}