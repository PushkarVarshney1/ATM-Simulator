package BankManagementSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
	
	JButton login,clear,signup;
	JTextField cardText;
	JPasswordField pinText;
	
	
	Login(){
		setTitle("Automated Teller Machine");
		setLayout(null);
		setLocation(350,200);
		setSize(800,480);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(100, 10, 100, 100);
		add(label);
		
		getContentPane().setBackground(Color.white);
		
		JLabel text=new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(230,45,400,40);
		add(text);
		
		JLabel cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120,150,150,30);
		add(cardno);
		
		cardText=new JTextField();
		cardText.setBounds(300, 150, 250, 30);
		cardText.setFont(new Font("Arial",Font.BOLD,14));
		add(cardText);
	
		JLabel pin=new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,400,30);
		add(pin);
		
		pinText=new JPasswordField();
		pinText.setBounds(300, 220, 250, 30);
		pinText.setFont(new Font("0Arial",Font.BOLD,14));
		add(pinText);
		
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 110, 30);
		login.setBackground(Color.CYAN);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(440, 300, 110, 30);
		clear.setBackground(Color.CYAN);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 250, 30);
		signup.setBackground(Color.CYAN);
		signup.addActionListener(this);
		add(signup);
		
		setVisible(true); // at the end  so that all the things are visible..
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==clear) {
			cardText.setText("");
			pinText.setText("");
		}
		else if(e.getSource()==login) {
			String card=cardText.getText();
			String pin=pinText.getText();
			String query="select * from login where cardnumber='"+card+"' and pinnumber='"+pin+"';";
			try {
				DBConnection con=new DBConnection();
				ResultSet rs=con.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Atm_Content(pin,card);
		        }
				else {
					JOptionPane.showMessageDialog(null,
			                "Incorrect CardNumber or Pin");
				}
			}
			catch(Exception err) {
				System.out.println(err);
			}
		}
		else if(e.getSource()==signup) {
			setVisible(false);
			new Signup_One();
		}
		
	}

}
