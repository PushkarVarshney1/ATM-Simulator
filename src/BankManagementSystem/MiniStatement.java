package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class MiniStatement extends JFrame implements ActionListener{
	JButton cancel;
	JPasswordField newpin,re;
	String pin,card;
	
	MiniStatement(String pin,String card){
		this.pin=pin;
		this.card=card;
		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setTitle("Mini Statement");
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 860, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(0, 0, 900, 860);
		add(img);
		JLabel total=new JLabel("Your Mini Statement");
		total.setFont(new Font("Raleway",Font.BOLD,16));
		total.setForeground(Color.white);
		total.setBounds(250,300,400,30);
		img.add(total);
		
		cancel=new JButton("Back");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(340,495,150,28);
		cancel.setFocusPainted(false);
		cancel.addActionListener(this);
		img.add(cancel);
		
		setUndecorated(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("", "");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Atm_Content(pin, card);
		
	}

}
