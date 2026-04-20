package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Atm_Content extends JFrame implements ActionListener{

	JButton deposit,exit,balancenquiry,pinchange,ministatement,fastcash,withdrawl;
	String pin,card;
	Atm_Content(String pin,String card){
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
		
		
		JLabel text=new JLabel("Please Select Your Transaction Type");
		text.setBounds(200,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD,16));
		img.add(text);
		
		deposit=new JButton("Deposit");
		deposit.setBackground(Color.black);
		deposit.setForeground(Color.white);
		deposit.setBounds(180,399,130,28);
		deposit.setFocusPainted(false);
		deposit.addActionListener(this);
		img.add(deposit);
		
		withdrawl=new JButton("Cash Withdrawl");
		withdrawl.setBackground(Color.black);
		withdrawl.setForeground(Color.white);
		withdrawl.setBounds(360,399,130,28);
		withdrawl.addActionListener(this);
		withdrawl.setFocusPainted(false);
		img.add(withdrawl);
		
		fastcash=new JButton("Fast Cash");
		fastcash.setBackground(Color.black);
		fastcash.setForeground(Color.white);
		fastcash.setBounds(180,432,130,28);
		fastcash.addActionListener(this);
		fastcash.setFocusPainted(false);
		img.add(fastcash);
		
		ministatement=new JButton("Mini Statement");
		ministatement.setBackground(Color.black);
		ministatement.setForeground(Color.white);
		ministatement.setBounds(360,432,130,28);
		ministatement.setFocusPainted(false);
		ministatement.addActionListener(this);
		img.add(ministatement);
		
		pinchange=new JButton("Pin Change");
		pinchange.setBackground(Color.black);
		pinchange.setForeground(Color.white);
		pinchange.setBounds(180,463,130,28);
		pinchange.setFocusPainted(false);
		pinchange.addActionListener(this);
		img.add(pinchange);
		
		balancenquiry=new JButton("Balance Enquiry");
		balancenquiry.setBackground(Color.black);
		balancenquiry.setForeground(Color.white);
		balancenquiry.setBounds(360,463,130,28);
		balancenquiry.setFocusPainted(false);
		balancenquiry.addActionListener(this);
		img.add(balancenquiry);
		
		exit=new JButton("Exit");
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.setBounds(360,495,130,28);
		exit.setFocusPainted(false);
		exit.addActionListener(this);
		img.add(exit);
		
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Atm_Content("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit) {
			System.exit(0);
		}
		else if(e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pin,card);
		}
		else if(e.getSource()==withdrawl) {
			setVisible(false);
			new Withdrawl(pin,card);
		}
		else if(e.getSource()==fastcash) {
			setVisible(false);
			new Fastcash(pin,card);
		}
		else if(e.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pin,card);
		}else if(e.getSource()==balancenquiry) {
			setVisible(false);
			new BalanceEnquiry(pin,card);
		}
		else {
			setVisible(false);
			new MiniStatement(pin,card);
		}
	}

}
