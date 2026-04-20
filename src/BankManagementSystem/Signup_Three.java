package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Signup_Three extends JFrame implements ActionListener{
	String formno;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String query_signup_one,query_signup_two;
	Signup_Three(String formno,String query_signup_one,String query_signup_two){
		this.query_signup_one=query_signup_one;
		this.query_signup_two=query_signup_two;
		this.formno=formno;
		setLayout(null);
		setSize(850,980);
		setLocation(350,10);
		
		setTitle("New Account Application Form:-Page3");
		
		JLabel l1=new JLabel("Page 3 : Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(300,40,400,40);
		add(l1);
		
		JLabel type=new JLabel("Account Type:");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,120,200,40);
		add(type);
		
		r1=new JRadioButton("Saving Account:");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(150, 180, 200, 40);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account:");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350, 180, 250, 40);
		add(r2);
		
		r3=new JRadioButton("Current Account:");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(150, 220, 180, 40);
		add(r3);
		
		r4=new JRadioButton("Zero Balance Account:");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350, 220, 300, 40);
		add(r4);
		ButtonGroup groupaccount=new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card=new JLabel("Card Number        :");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100,280,300,40);
		add(card);
		
		JLabel cardhint=new JLabel("(Your 16 digit card number)");
		cardhint.setFont(new Font("Arial",Font.ITALIC,14));
		cardhint.setBounds(100,320,300,20);
		add(cardhint);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-"+formno.substring(2));
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(350,280,400,40);
		add(number);
		
		JLabel pin=new JLabel("Pin Number           :");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,350,300,40);
		add(pin);
		
		JLabel pinhint=new JLabel("(Your 4 digit pin number)");
		pinhint.setFont(new Font("Arial",Font.ITALIC,14));
		pinhint.setBounds(100,390,300,20);
		add(pinhint);
		
		JLabel pinno=new JLabel("XXXX");
		pinno.setFont(new Font("Raleway",Font.BOLD,22));
		pinno.setBounds(350,350,400,40);
		add(pinno);
		
		JLabel services=new JLabel("Services Required");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,430,300,40);
		add(services);
		
		c1=new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Raleway",Font.ITALIC,14));
		c1.setBounds(100,470,300,30);
		add(c1);
		
		c2=new JCheckBox("INTERNET BANKING");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Raleway",Font.ITALIC,14));
		c2.setBounds(450,470,300,30);
		add(c2);
		
		c3=new JCheckBox("MOBILE BANKING");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Raleway",Font.ITALIC,14));
		c3.setBounds(100,500,300,30);
		add(c3);
		
		c4=new JCheckBox("EMAIL & SMS");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Raleway",Font.ITALIC,14));
		c4.setBounds(450,500,300,30);
		add(c4);
		
		c5=new JCheckBox("CHECK BOOK");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Raleway",Font.ITALIC,14));
		c5.setBounds(100,530,300,30);
		add(c5);
		
		c6=new JCheckBox("E-STATEMENT");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Raleway",Font.ITALIC,14));
		c6.setBounds(450,530,300,30);
		add(c6);
		
		c7=new JCheckBox("I Hereby declares that above enter details are corrects to the best of my knowledge");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Raleway",Font.ITALIC,12));
		c7.setBounds(100,600,500,14);
		add(c7);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.cyan);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(500,640,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.cyan);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(650,640,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup_Three("123456","","");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			String accType=null;
			if(r1.isSelected()) {
				accType="Saving Account";
			}
			else if(r2.isSelected()) {
				accType="Fixed Deposit Account";
			}
			else if(r3.isSelected()) {
				accType="Current Account";
			}
			else if(r4.isSelected()) {
				accType="Zero Balance Account";
			}
			String cardnumber="5412"+formno.substring(0)+formno.substring(0);
			Random random=new Random();
			String no=""+(Math.abs(random.nextInt())%10000+1000);
			String pinnumber=no.substring(0,4);
			String facility="";
			if(c1.isSelected()) {
				facility+="ATM CARD, ";
			}
			if(c2.isSelected()) {
				facility+="INTERNET BANKING, ";
			}
			if(c3.isSelected()) {
				facility+="MOBILE BANKING, ";
			}
			if(c4.isSelected()) {
				facility+="EMAIL & SMS, ";
			}
			if(c5.isSelected()) {
				facility+="CHECK BOOK, ";
			}
			if(c6.isSelected()) {
				facility+="E-STATEMENT ";
			}
			try {
				DBConnection con=new DBConnection();
				String query1="insert into signupthree values('"+formno+"','"+accType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
				String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
				con.s.executeUpdate(query1);
				con.s.executeUpdate(query2);
				con.s.executeUpdate(query_signup_one);
				con.s.executeUpdate(query_signup_two);
				
				JOptionPane.showMessageDialog(null, "Card Number "+cardnumber+"\n Pin:"+pinnumber);
			}
			catch(Exception err) {
				System.out.println(err);
			}
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
			new Login();
		}
		
	}

}
