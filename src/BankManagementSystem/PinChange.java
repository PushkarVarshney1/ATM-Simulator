package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JButton change,cancel;
	JPasswordField newpin,re;
	String pin,card;
	
	PinChange(String pin,String card){
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
		
		JLabel text=new JLabel("Change Your Pin");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(270, 300, 400, 20);
		img.add(text);
		
		JLabel pintext=new JLabel("New Pin            :");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(160, 350, 400, 20);
		img.add(pintext);
		
		newpin=new JPasswordField();
		newpin.setBounds(300, 350, 190, 30);
		newpin.setBackground(Color.gray);
		newpin.setForeground(Color.white);
		newpin.setFont(new Font("Arial",Font.BOLD,14));
		img.add(newpin);
		
		JLabel repin=new JLabel("Re-Enter Pin     :");
		repin.setForeground(Color.white);
		repin.setFont(new Font("System",Font.BOLD,16));
		repin.setBounds(160, 400, 400, 20);
		img.add(repin);
		
		re=new JPasswordField();
		re.setBounds(300, 400, 190, 30);
		re.setBackground(Color.gray);
		re.setForeground(Color.white);
		re.setFont(new Font("Arial",Font.BOLD,14));
		img.add(re);
		
		change=new JButton("Change");
		change.setBackground(Color.black);
		change.setForeground(Color.white);
		change.setFocusPainted(false);
		change.setBounds(340, 463, 150, 30);
		change.addActionListener(this);
		img.add(change);
		
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
		new PinChange("","");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==change) {
			String newp=newpin.getText();
			String repin=re.getText();
			if(!(newp.length()==4)) {
				JOptionPane.showMessageDialog(null, "Enter Valid Pin of 4 digits");
				return;
			}
			else if(!newp.equals(repin)) {
				JOptionPane.showMessageDialog(null, "Pin Does Not Match!!!");
				return;
			}
			try {
				DBConnection con=new DBConnection();
				String query1="update login set pinnumber='" + newp + "' where cardnumber='" + card + "';";
				String query2="update signupthree set pinnumber='" + newp + "' where cardnumber='" + card + "';";
				con.s.executeUpdate(query1);
				con.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
				setVisible(false);
				new Atm_Content(pin, card);
			}
			catch(Exception err) {
				System.out.println(err);
			}
		}
		else {
			setVisible(false);
			new Atm_Content(pin,card);
		}
		
	}

}
