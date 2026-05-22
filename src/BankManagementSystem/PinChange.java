package BankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class PinChange extends JFrame implements ActionListener {
    JButton change, back;
    JPasswordField newpin, re;
    String pin, card;
    PinChange(String pin, String card) {
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
        JLabel txt = new JLabel("Change Your Pin");
        txt.setForeground(Color.white);
        txt.setFont(new Font("System", Font.BOLD, 16));
        txt.setBounds(270, 300, 400, 20);
        img.add(txt);
        JLabel p1 = new JLabel("New Pin:");
        p1.setForeground(Color.white);
        p1.setFont(new Font("System", Font.BOLD, 16));
        p1.setBounds(160, 350, 150, 20);
        img.add(p1);
        newpin = new JPasswordField();
        newpin.setBounds(300, 350, 190, 30);
        img.add(newpin);
        JLabel p2 = new JLabel("Re-Enter Pin:");
        p2.setForeground(Color.white);
        p2.setFont(new Font("System", Font.BOLD, 16));
        p2.setBounds(160, 400, 150, 20);
        img.add(p2);
        re = new JPasswordField();
        re.setBounds(300, 400, 190, 30);
        img.add(re);
        change = new JButton("Change");
        change.setBounds(355, 450, 150, 30);
        change.addActionListener(this);
        img.add(change);
        back = new JButton("Back");
        back.setBounds(355, 490, 150, 30);
        back.addActionListener(this);
        img.add(back);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PinChange("", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            String np = new String(newpin.getPassword());
            String rp = new String(re.getPassword());
            if (np.length() != 4) {
                JOptionPane.showMessageDialog(null, 
                    "Enter 4 digit PIN");
                return;
            }
            if (!np.equals(rp)) {
                JOptionPane.showMessageDialog(null, 
                    "PIN mismatch");
                return;
            }
            String q1 = "UPDATE login SET pinnumber=? "
                      + "WHERE cardnumber=?";
            String q2 = "UPDATE signupthree SET pinnumber=? "
                      + "WHERE cardnumber=?";
            try {
                DBConnection con = new DBConnection();
                PreparedStatement pst1 = con.c.prepareStatement(q1);
                pst1.setString(1, np);
                pst1.setString(2, card);
                pst1.executeUpdate();
                PreparedStatement pst2 = con.c.prepareStatement(q2);
                pst2.setString(1, np);
                pst2.setString(2, card);
                pst2.executeUpdate();
                JOptionPane.showMessageDialog(null, 
                    "PIN Changed Successfully");
                pst1.close();
                pst2.close();
                con.c.close();
                setVisible(false);
                new Atm_Content(np, card);
            } catch (Exception err) {
                System.out.println(err);
            }
        } else {
            setVisible(false);
            new Atm_Content(pin, card);
        }
    }
}