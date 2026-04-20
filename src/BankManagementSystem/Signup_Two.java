package BankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Signup_Two extends JFrame implements ActionListener{

	JTextField pan,aadhar;
	JRadioButton syes,sno,eyes,eno;
	JComboBox<String[]> category,income,education,occupation,religion;
	String formno;
	String query_signup_one;
	
	Signup_Two(String formno, String query_signup_one){
		this.query_signup_one=query_signup_one;
		this.formno=formno;
		setLayout(null);
		setSize(850,800);
		setLocation(350,10);
		
		setTitle("New Account Application Form:-Page2");
		
		JLabel additionalDetails=new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,18));
		additionalDetails.setBounds(320,70,400,20);
		add(additionalDetails);
		
		JLabel Religion=new JLabel("Religion:");
		Religion.setFont(new Font("Raleway",Font.BOLD,20));
		Religion.setBounds(120,140,200,30);
		add(Religion);
		
		religion=new JComboBox(new String[] {"Hindu","Muslim","Sikh","Christian","Other"});
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.white);
		add(religion);
		
		JLabel Category=new JLabel("Category:");
		Category.setFont(new Font("Raleway",Font.BOLD,20));
		Category.setBounds(120,190,200,30);
		add(Category);
		
		category=new JComboBox(new String[] {"General","SC","ST","OBC","Other"});
		category.setBounds(300,190,400,30);
		category.setFont(new Font("Raleway",Font.BOLD,14));
		category.setBackground(Color.white);
		add(category);
		
		JLabel Income=new JLabel("Income:");
		Income.setFont(new Font("Raleway",Font.BOLD,20));
		Income.setBounds(120,240,200,30);
		add(Income);
		
		income=new JComboBox(new String[] {"<100000","<200000","<250000","<500000","<800000",">800000"});
		income.setBounds(300,240,400,30);
		income.setFont(new Font("Raleway",Font.BOLD,14));
		income.setBackground(Color.white);
		add(income);
		
		JLabel Qualification=new JLabel("Qualification:");
		Qualification.setFont(new Font("Raleway",Font.BOLD,20));
		Qualification.setBounds(120,290,200,30);
		add(Qualification);
		
		JLabel Highest=new JLabel("Highest:");
		Highest.setFont(new Font("System",Font.ITALIC,15));
		Highest.setBounds(150,310,200,20);
		add(Highest);
		
		education=new JComboBox(new String[] {"Non-Graduate","Graduate","Post-Graduate","Other"});
		education.setFont(new Font("Raleway",Font.BOLD,14));
		education.setBackground(Color.white);
		education.setBounds(300,290,400,30);
		add(education);
		
		JLabel Occupation=new JLabel("Occupation:");
		Occupation.setFont(new Font("Raleway",Font.BOLD,20));
		Occupation.setBounds(120,340,200,30);
		add(Occupation);
		
		occupation=new JComboBox(new String[] {"Business","Job","Retired","Other"});
		occupation.setFont(new Font("Raleway",Font.BOLD,14));
		occupation.setBounds(300,340,400,30);
		occupation.setBackground(Color.white);
		add(occupation);
		
		JLabel Pan=new JLabel("Pan Number:");
		Pan.setFont(new Font("Raleway",Font.BOLD,20));
		Pan.setBounds(120,390,200,30);
		add(Pan);
		
		pan=new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300,390,400,30);
		add(pan);
		
		JLabel Aadhar=new JLabel("Aadhar Number:");
		Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		Aadhar.setBounds(120,440,200,30);
		add(Aadhar);
		
		aadhar=new JTextField();
		aadhar.setFont(new Font("Raleway",Font.BOLD,14));
		aadhar.setBounds(300,440,400,30);
		add(aadhar);
		
		JLabel state=new JLabel("Senior Citizen:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(120,490,200,30);
		add(state);
		
		syes=new JRadioButton("Yes");
		syes.setFont(new Font("Raleway",Font.BOLD,14));
		syes.setBounds(400,490,100,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setFont(new Font("Raleway",Font.BOLD,14));
		sno.setBounds(500,490,100,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup senior=new ButtonGroup();
		senior.add(syes);
		senior.add(sno);
		
		JLabel pincode=new JLabel("Exisiting Account:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(120,540,400,30);
		add(pincode);
		
		eyes=new JRadioButton("Yes");
		eyes.setFont(new Font("Raleway",Font.BOLD,14));
		eyes.setBounds(400,540,100,30);
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setFont(new Font("Raleway",Font.BOLD,14));
		eno.setBounds(500,540,100,30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup exist=new ButtonGroup();
		exist.add(eyes);
		exist.add(eno);
		
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
		new Signup_Two("","");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String Religion=(String)religion.getSelectedItem();
		String Category=(String)category.getSelectedItem();
		String Income=(String)income.getSelectedItem();
		String Education=(String)education.getSelectedItem();
		String Occupation=(String)occupation.getSelectedItem();
		String senior=null;
		String Pan=pan.getText();
		String Aadhar=aadhar.getText();
		if(syes.isSelected()) {
			senior="Yes";
		}
		else {
			senior="No";
		}
		String exist=null;
		if(eyes.isSelected()) {
			exist="Yes";
		}
		else {
			exist="No";
		}
		try {
			DBConnection con=new DBConnection();
			String query_signup_two="insert into signuptwo values('"+formno+"','"+Religion+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+Pan+"','"+Aadhar+"','"+exist+"','"+senior+"')";
			
		
			setVisible(false);
			new Signup_Three(formno,query_signup_one,query_signup_two);
		}
		catch(Exception err) {
			System.out.println(err);
		}
	}
	

}
