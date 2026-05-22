package BankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pin, card;
    BalanceEnquiry(String pin, String card) {
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
        double balance = 0;
        String q = "SELECT SUM(CASE WHEN type='Deposit' "
                 + "THEN amount ELSE -amount END) "
                 + "AS bal FROM bank WHERE cardno=?";
        try {
            DBConnection con = new DBConnection();
            PreparedStatement pst = con.c.prepareStatement(q);
            pst.setString(1, card);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble("bal");
            }
            rs.close();
            pst.close();
            con.c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel total = new JLabel("Balance: Rs " + balance);
        total.setFont(new Font("Raleway", Font.BOLD, 16));
        total.setForeground(Color.white);
        total.setBounds(170, 300, 400, 30);
        img.add(total);
        back = new JButton("Back");
        back.setBounds(355, 480, 150, 30);
        back.addActionListener(this);
        img.add(back);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Atm_Content(pin, card);
    }
}