package BankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pin, card;
    Withdrawl(String pin, String card) {
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
        JLabel txt = new JLabel("Enter amount to withdraw");
        txt.setForeground(Color.white);
        txt.setFont(new Font("System", Font.BOLD, 16));
        txt.setBounds(190, 300, 400, 20);
        img.add(txt);
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        img.add(amount);
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 430, 150, 30);
        withdraw.addActionListener(this);
        img.add(withdraw);
        back = new JButton("Back");
        back.setBounds(355, 480, 150, 30);
        back.addActionListener(this);
        img.add(back);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Withdrawl("", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String w = amount.getText();
            Date d = new Date();
            if (w.equals("")) {
                JOptionPane.showMessageDialog(null, 
                    "Enter amount to withdraw");
                return;
            }
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
                double balance = 0;
                if (rs.next()) {
                    balance = rs.getDouble("bal");
                }
                if (balance < Double.parseDouble(w)) {
                    JOptionPane.showMessageDialog(null, 
                        "Insufficient Balance");
                    return;
                }
                PreparedStatement pst2 = con.c.prepareStatement(q2);
                pst2.setString(1, card);
                pst2.setString(2, d.toString());
                pst2.setString(3, "Withdrawl");
                pst2.setString(4, w);
                pst2.executeUpdate();
                JOptionPane.showMessageDialog(null, 
                    "Rs " + w + " Withdrawn Successfully");
                rs.close();
                pst1.close();
                pst2.close();
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