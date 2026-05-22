package BankManagementSystem;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.util.HashMap;
import java.util.Map;

public class Signup_One extends JFrame implements ActionListener {

    JTextField namefield, fathernamefield, emailfield;
    JTextField addressfield, pincodefield;
    JFormattedTextField dobfield;
    JComboBox<String> stateCombo, cityCombo;
    JRadioButton male, female, other, married, unmarried;
    int fno;
    Map<String, String[]> locData = new HashMap<>();

    public Signup_One() {
        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);

        fno = generateformno();
        JLabel formno = new JLabel("FORM NO: " + fno);
        formno.setFont(new Font("Raleway", Font.BOLD, 30));
        formno.setBounds(180, 20, 600, 40);
        add(formno);

        JLabel pageDetails = new JLabel("Page 1 : Details");
        pageDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        pageDetails.setBounds(290, 70, 400, 20);
        add(pageDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(120, 140, 200, 30);
        add(name);

        namefield = new JTextField();
        namefield.setFont(new Font("Raleway", Font.BOLD, 14));
        namefield.setBounds(300, 140, 400, 30);
        add(namefield);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(120, 190, 200, 30);
        add(fname);

        fathernamefield = new JTextField();
        fathernamefield.setFont(new Font("Raleway", Font.BOLD, 14));
        fathernamefield.setBounds(300, 190, 400, 30);
        add(fathernamefield);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(120, 240, 200, 30);
        add(dob);

        try {
            MaskFormatter dateMask = new MaskFormatter("##-##-####");
            dateMask.setPlaceholderCharacter('x');
            dobfield = new JFormattedTextField(dateMask);
        } catch (Exception e) {
            dobfield = new JFormattedTextField();
        }
        dobfield.setFont(new Font("Arial", Font.BOLD, 14));
        dobfield.setBounds(300, 240, 300, 30);
        add(dobfield);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(120, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(600, 290, 60, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(120, 340, 200, 30);
        add(email);

        emailfield = new JTextField();
        emailfield.setFont(new Font("Raleway", Font.BOLD, 14));
        emailfield.setBounds(300, 340, 400, 30);
        add(emailfield);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(120, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500, 390, 200, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(120, 440, 200, 30);
        add(address);

        addressfield = new JTextField();
        addressfield.setFont(new Font("Raleway", Font.BOLD, 14));
        addressfield.setBounds(300, 440, 400, 30);
        add(addressfield);

        locData.put("-Select State-", new String[]{"-Select City-"});
        locData.put("UttarPradesh", new String[]{"Lucknow", "Kanpur", "Noida", "Mathura", "Agra", "GorakhPur", "Hathras","Kasganj"});
        locData.put("UttaraKhand", new String[]{"Rishikesh", "Roorkee", "Haldwani", "Haridwar", "Dehradun"});
        locData.put("Haryana", new String[]{"Hisar", "Ambala", "Panipat", "Faridabad", "Gurugram"});
        locData.put("Punjab", new String[]{"Bathinda", "Patiala", "Jalandhar", "Amritsar", "Ludhiana"});
        locData.put("Maharashtra", new String[]{"Mumbai", "Pune", "Nagpur","Chhatrapati Sambhajinagar (Aurangabad)","Nashik"});
        locData.put("Delhi", new String[]{"New Delhi", "South Delhi"});
        locData.put("Karnataka", new String[]{"Bengaluru", "Mysore","Belagavi (Belgaum)","Mangaluru","Hubballi-Dharwad"});

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(120, 490, 200, 30);
        add(state);

        String[] statesArray = locData.keySet().toArray(new String[0]);
        stateCombo = new JComboBox<>(statesArray);
        stateCombo.setBounds(300, 490, 400, 30);
        stateCombo.setBackground(Color.white);
        add(stateCombo);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(120, 540, 200, 30);
        add(city);

        cityCombo = new JComboBox<>(new String[]{"-Select City-"});
        cityCombo.setBounds(300, 540, 400, 30);
        cityCombo.setBackground(Color.white);
        add(cityCombo);

        stateCombo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selState = (String) e.getItem();
                    String[] cList = locData.get(selState);
                    cityCombo.setModel(new DefaultComboBoxModel<>(cList));
                }
            }
        });

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(120, 590, 200, 30);
        add(pincode);

        pincodefield = new JTextField();
        pincodefield.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodefield.setBounds(300, 590, 400, 30);
        add(pincodefield);

        JButton next = new JButton("Next");
        next.setBackground(Color.cyan);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(620, 650, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup_One();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + fno;
        String name = namefield.getText();
        String fname = fathernamefield.getText();
        String dob = dobfield.getText();
        String gender = "Other";
        if (male.isSelected()) gender = "Male";
        else if (female.isSelected()) gender = "Female";

        String email = emailfield.getText();
        String marital = "Unmarried";
        if (married.isSelected()) marital = "Married";

        String address = addressfield.getText();
        String city = (String) cityCombo.getSelectedItem();
        String state = (String) stateCombo.getSelectedItem();
        String pin = pincodefield.getText();

        if (state.equals("-Select State-") || city.equals("-Select City-")) {
            JOptionPane.showMessageDialog(null, "Select State and City");
            return;
        }

        String q = "INSERT INTO signup VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            DBConnection con = new DBConnection();
            PreparedStatement pst = con.c.prepareStatement(q);
            pst.setString(1, formno);
            pst.setString(2, name);
            pst.setString(3, fname);
            pst.setString(4, dob);
            pst.setString(5, gender);
            pst.setString(6, email);
            pst.setString(7, marital);
            pst.setString(8, address);
            pst.setString(9, city);
            pst.setString(10, pin);
            pst.setString(11, state);
            pst.executeUpdate();
            pst.close();
            con.c.close();
            
            setVisible(false);
            new Signup_Two(formno);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    private int generateformno() {
        int seq = 0;
        try {
            DBConnection con = new DBConnection();
            Statement stmt = con.c.createStatement();
            stmt.executeUpdate("INSERT INTO formno VALUES ()");
            ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                seq = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            con.c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return seq;
    }
}