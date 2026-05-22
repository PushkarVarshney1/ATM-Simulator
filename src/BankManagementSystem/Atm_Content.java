package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Atm_Content extends JFrame implements ActionListener {
    JButton dep, exit, bal, pinbtn, mini, fast, wdraw;
    String pin, card;
    Atm_Content(String pin, String card) {
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
        JLabel text = new JLabel("Please Select Transaction Type");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        img.add(text);
        dep = new JButton("Deposit");
        dep.setBounds(170, 400, 150, 25);
        dep.addActionListener(this);
        img.add(dep);
        wdraw = new JButton("Cash Withdrawl");
        wdraw.setBounds(355, 400, 150, 25);
        wdraw.addActionListener(this);
        img.add(wdraw);
        fast = new JButton("Fast Cash");
        fast.setBounds(170, 435, 150, 25);
        fast.addActionListener(this);
        img.add(fast);
        mini = new JButton("Mini Statement");
        mini.setBounds(355, 435, 150, 25);
        mini.addActionListener(this);
        img.add(mini);
        pinbtn = new JButton("Pin Change");
        pinbtn.setBounds(170, 470, 150, 25);
        pinbtn.addActionListener(this);
        img.add(pinbtn);
        bal = new JButton("Balance Enquiry");
        bal.setBounds(355, 470, 150, 25);
        bal.addActionListener(this);
        img.add(bal);
        exit = new JButton("Exit");
        exit.setBounds(355,500, 150, 25);
        exit.addActionListener(this);
        img.add(exit);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Atm_Content("", "");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == dep) {
            setVisible(false);
            new Deposit(pin, card);
        } else if (e.getSource() == wdraw) {
            setVisible(false);
            new Withdrawl(pin, card);
        } else if (e.getSource() == fast) {
            setVisible(false);
            new Fastcash(pin, card);
        } else if (e.getSource() == pinbtn) {
            setVisible(false);
            new PinChange(pin, card);
        } else if (e.getSource() == bal) {
            setVisible(false);
            new BalanceEnquiry(pin, card);
        } else if (e.getSource() == mini) {
            setVisible(false);
            new MiniStatement(pin, card);
        }
    }
}