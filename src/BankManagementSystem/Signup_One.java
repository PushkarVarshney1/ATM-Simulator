package BankManagementSystem;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;

public class Signup_One extends JFrame implements ActionListener{

	JTextField namefield,pincodefield,statefield,
	cityfield,addressfield,emailfield,dobfield,
	fathernamefield;
	JRadioButton male,female,other,married,unmarried;
	int fno;
	
	Signup_One(){
		setLayout(null);
		setSize(850,800);
		setLocation(350,10);
		
		fno=generateformno();
		JLabel formno=new JLabel("APPLICATION FORM NO:-  "+fno);
		formno.setFont(new Font("Raleway",Font.BOLD,30));
		formno.setBounds(180,20,600,40);
		add(formno);
		
		JLabel personalDetails=new JLabel("Page 1 : Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,18));
		personalDetails.setBounds(290,70,400,20);
		add(personalDetails);
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(120,140,200,30);
		add(name);
		
		namefield=new JTextField();
		namefield.setFont(new Font("Raleway",Font.BOLD,14));
		namefield.setBounds(300,140,400,30);
		add(namefield);
		
		JLabel fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(120,190,200,30);
		add(fname);
		
		fathernamefield=new JTextField();
		fathernamefield.setFont(new Font("Raleway",Font.BOLD,14));
		fathernamefield.setBounds(300,190,400,30);
		add(fathernamefield);
		
		JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(120,240,200,30);
		add(dob);
		
		dobfield = new JTextField();
		dobfield.setFont(new Font("Arial", Font.BOLD, 14));
		dobfield.setBounds(300, 240, 300, 30);
		dobfield.setToolTipText("dd-MM-yyyy");
		add(dobfield);

		
		JLabel dobHint = new JLabel("Format: dd-MM-yyyy");
		dobHint.setFont(new Font("Arial", Font.PLAIN, 12));
		dobHint.setBounds(600, 240, 200, 30);
		add(dobHint);
		
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(120,290,200,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450, 290, 100, 30);
		female.setBackground(Color.white);
		add(female);
		
		other=new JRadioButton("Other");
		other.setBackground(Color.white);
		other.setBounds(600, 290, 60, 30);
		add(other);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);
		
		JLabel email=new JLabel("Email Address:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(120,340,200,30);
		add(email);
		
		emailfield=new JTextField();
		emailfield.setFont(new Font("Raleway",Font.BOLD,14));
		emailfield.setBounds(300,340,400,30);
		add(emailfield);
		
		JLabel marital=new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(120,390,200,30);
		add(marital);
		
		married=new JRadioButton("Married");
		married.setBounds(300, 390, 120, 30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(500, 390, 200, 30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		ButtonGroup maritalgroup=new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		
		JLabel address=new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(120,440,200,30);
		add(address);
		
		addressfield=new JTextField();
		addressfield.setFont(new Font("Raleway",Font.BOLD,14));
		addressfield.setBounds(300,440,400,30);
		add(addressfield);
		
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(120,490,200,30);
		add(city);
		
		cityfield=new JTextField();
		cityfield.setFont(new Font("Raleway",Font.BOLD,14));
		cityfield.setBounds(300,490,400,30);
		add(cityfield);
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(120,540,200,30);
		add(state);
		
		statefield=new JTextField();
		statefield.setFont(new Font("Raleway",Font.BOLD,14));
		statefield.setBounds(300,540,400,30);
		add(statefield);
		
		JLabel pincode=new JLabel("Pin Code:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(120,590,200,30);
		add(pincode);
		
		pincodefield=new JTextField();
		pincodefield.setFont(new Font("Raleway",Font.BOLD,14));
		pincodefield.setBounds(300,590,400,30);
		add(pincodefield);
		
		JButton next=new JButton("Next");
		next.setBackground(Color.cyan);
		next.setFont(new Font("Railway",Font.BOLD,14));
		next.setBounds(620,650,80,30);
		add(next);
		next.addActionListener(this);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup_One();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		dobvalidator();
		String formno=""+fno;
		String name=namefield.getText();
		String fathername=fathernamefield.getText();
		String dob=dobfield.getText();
		String gender= "Other";
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailfield.getText();
		String marital=null;
		if(married.isSelected()) {
			marital="Married";
		}
		else if(unmarried.isSelected()) {
			marital="Female";
		}
		String address=addressfield.getText();
		String pincode=pincodefield.getText();
		String city=cityfield.getText();
		String state=statefield.getText();
		try {
			DBConnection con=new DBConnection();
			String query_signup_one="insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
			
			
			setVisible(false);
			new Signup_Two(formno,query_signup_one);
		}
		catch(Exception err) {
			System.out.println(err);
		}
		
	}
	public void dobvalidator() {
		DateTimeFormatter formatter =
		        DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate dob;

		try {
		    dob = LocalDate.parse(dobfield.getText().trim(), formatter);

		    // Age validation (18+)
		    if (dob.isAfter(LocalDate.now().minusYears(18))) {
		        JOptionPane.showMessageDialog(this,
		                "Age must be 18 years or above");
		        return;
		    }

		} catch (DateTimeParseException err) {
		    JOptionPane.showMessageDialog(this,
		            "Invalid date format.\nPlease use dd-MM-yyyy");
		    return;
		}
	}
	private int generateformno() {
		ResultSet rs = null;
		int seq = 0;

		try {
			DBConnection con= new DBConnection();

		    // Insert dummy row to generate number
		    con.s.executeUpdate("INSERT INTO formno VALUES ()");

		    // Fetch generated value
		    rs = con.s.executeQuery("SELECT LAST_INSERT_ID()");

		    if (rs.next()) {
		        seq = rs.getInt(1);
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
		return seq;
	}

}
