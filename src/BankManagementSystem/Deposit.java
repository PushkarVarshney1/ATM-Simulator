package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{

	JTextField amount;
	JButton deposit,back;
	String pin,card;
	
	Deposit(String pin,String card){
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
		
		JLabel text=new JLabel("Enter the Amount you want to deposit");
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
		
		deposit=new JButton("Deposit");
		deposit.setBackground(Color.black);
		deposit.setForeground(Color.white);
		deposit.setFocusPainted(false);
		deposit.setBounds(355, 463, 150, 30);
		deposit.addActionListener(this);
		img.add(deposit);
		
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
		new Deposit("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==deposit) {
			String withdraw=amount.getText();
			Date date=new Date();
			if(withdraw.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
			}
			else{
				try {
					DBConnection con=new DBConnection();
					String query =
							  "INSERT INTO bank(cardno, date, type, amount) " +
							  "VALUES ('" + card + "','" + date + "','Deposit'," + withdraw + ")";
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs '"+withdraw+"' Deposited Successfully");
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
