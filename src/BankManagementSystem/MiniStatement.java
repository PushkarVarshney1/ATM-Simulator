package BankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {
    JButton back;
    String pin, card;
    MiniStatement(String pin, String card) {
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
        JLabel title = new JLabel("Mini Statement");
        title.setFont(new Font("Raleway", Font.BOLD, 16));
        title.setForeground(Color.white);
        title.setBounds(250, 300, 400, 30);
        img.add(title);
        JLabel mini = new JLabel("");
        mini.setBounds(170, 340, 400, 150);
        mini.setForeground(Color.white);
        img.add(mini);
        String q = "SELECT * FROM bank WHERE cardno=? "
                 + "ORDER BY date DESC LIMIT 5";
        try {
            DBConnection con = new DBConnection();
            PreparedStatement pst = con.c.prepareStatement(q);
            pst.setString(1, card);
            ResultSet rs = pst.executeQuery();
            StringBuilder sb = new StringBuilder("<html>");
            while (rs.next()) {
                sb.append(rs.getString("date")).append("&nbsp;&nbsp;");
                sb.append(rs.getString("type")).append("&nbsp;&nbsp;");
                sb.append(rs.getString("amount")).append("<br><br>");
            }
            sb.append("</html>");
            mini.setText(sb.toString());
            rs.close();
            pst.close();
            con.c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        back = new JButton("Back");
        back.setBounds(355, 490, 150, 25);
        back.addActionListener(this);
        img.add(back);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Atm_Content(pin, card);
    }
}