package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{

	JTextField amount;
	JButton withdraw,back;
	String pin,card;
	
	Withdrawl(String pin,String card){
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
		
		JLabel text=new JLabel("Enter the Amount you want to Withdraw");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(185, 300, 400, 20);
		img.add(text);
		
		amount =new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBackground(Color.gray);
		amount.setForeground(Color.white);
		amount.setBounds(170, 350, 320, 25);
		img.add(amount);
		
		withdraw=new JButton("Withdraw");
		withdraw.setBackground(Color.black);
		withdraw.setForeground(Color.white);
		withdraw.setFocusPainted(false);
		withdraw.setBounds(355, 463, 150, 30);
		withdraw.addActionListener(this);
		img.add(withdraw);
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(355,495,150,28);
		back.setFocusPainted(false);
		back.addActionListener(this);
		img.add(back);
		
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Withdrawl("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==withdraw) {
			String with=amount.getText();
			Date date=new Date();
			if(with.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdrawl");
			}
			else{
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
					if(balance<Integer.parseInt(with)) {
						JOptionPane.showMessageDialog(null, "Insufficient Balace");
						return;
					}
					String query =
							  "INSERT INTO bank(cardno, date, type, amount) " +
							  "VALUES ('" + card + "','" + date + "','Withdrawl'," + with + ")";
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs '"+with+"' Withdraw Successfully");
					setVisible(false);
					new Atm_Content(pin, card);
				}
				catch(Exception err) {
					System.out.println(err);
				}
			}
		}
		else {
			setVisible(false);
			new Atm_Content(pin,card);
		}
	}

}
