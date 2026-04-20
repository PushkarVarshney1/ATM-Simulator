package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Fastcash extends JFrame implements ActionListener{

	JButton b1,b2,b3,b4,b5,b6,cancel;
	String pin,card;
	Fastcash(String pin,String card){
		this.pin=pin;
		this.card=card;
		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 860, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(0, 0, 900, 860);
		add(img);
		
		
		JLabel text=new JLabel("Select Withdraw Ammount");
		text.setBounds(200,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		img.add(text);
		
		b1=new JButton("Rs.100");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(180,399,130,28);
		b1.setFocusPainted(false);
		b1.addActionListener(this);
		img.add(b1);
		
		b2=new JButton("Rs.500");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(360,399,130,28);
		b2.addActionListener(this);
		b2.setFocusPainted(false);
		img.add(b2);
		
		b3=new JButton("Rs.1000");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBounds(180,432,130,28);
		b3.addActionListener(this);
		b3.setFocusPainted(false);
		img.add(b3);
		
		b4=new JButton("Rs.2000");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		b4.setBounds(360,432,130,28);
		b4.setFocusPainted(false);
		b4.addActionListener(this);
		img.add(b4);
		
		b5=new JButton("Rs.5000");
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		b5.setBounds(180,463,130,28);
		b5.setFocusPainted(false);
		b5.addActionListener(this);
		img.add(b5);
		
		b6=new JButton("Rs.10000");
		b6.setBackground(Color.black);
		b6.setForeground(Color.white);
		b6.setBounds(360,463,130,28);
		b6.setFocusPainted(false);
		b6.addActionListener(this);
		img.add(b6);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(360,495,130,28);
		cancel.setFocusPainted(false);
		cancel.addActionListener(this);
		img.add(cancel);
		
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fastcash("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel) {
			setVisible(false);
			new Atm_Content(pin,card);
		}
		else{
			String amount=((JButton) e.getSource()).getText().substring(3);
			try {
				DBConnection con=new DBConnection();
				ResultSet rs=con.s.executeQuery("select * from bank where cardno='" + card + "'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")){
						balance+=Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
				}
				if(balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balace");
					return;
				}
				Date date=new Date();
				String query =
						  "INSERT INTO bank(cardno, date, type, amount) " +
						  "VALUES ('" + card + "','" + date + "','Withdrawl'," + amount + ")";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs '"+amount+"' Withdraw Successfully");
				setVisible(false);
				new Atm_Content(pin, card);
			}
			catch(Exception err) {
				System.out.println(err);
			}
			
		}
		
	}

}
