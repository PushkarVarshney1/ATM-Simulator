package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup_Two extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> category, income;
    JComboBox<String> education, occupation, religion;
    String formno;

    public Signup_Two(String formno) {
        this.formno = formno;
        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);
        setTitle("Account Application Form:-Page 2");

        JLabel addDetails = new JLabel("Page 2: Details");
        addDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        addDetails.setBounds(320, 70, 400, 20);
        add(addDetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(120, 140, 200, 30);
        add(rel);

        String[] valRel = {"Hindu", "Muslim", "Sikh", "Jain", "Other"};
        religion = new JComboBox<>(valRel);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(120, 190, 200, 30);
        add(cat);

        String[] valCat = {"General", "SC", "ST", "OBC", "Other"};
        category = new JComboBox<>(valCat);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(120, 240, 200, 30);
        add(inc);

        String[] valInc = {"<1,00,000", "1 lakh to 2.5 lakh", "2.5 lakh to 5 lakh", ">5,00,000"};
        income = new JComboBox<>(valInc);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(120, 290, 200, 30);
        add(edu);

        JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(120, 315, 200, 30);
        add(qual);

        String[] valEdu = {"Non-Graduate", "Graduate", "Post-Graduate"};
        education = new JComboBox<>(valEdu);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(120, 390, 200, 30);
        add(occ);

        String[] valOcc = {"Job", "Business", "Student", "Other"};
        occupation = new JComboBox<>(valOcc);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel pno = new JLabel("PAN Number:");
        pno.setFont(new Font("Raleway", Font.BOLD, 20));
        pno.setBounds(120, 440, 200, 30);
        add(pno);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel ano = new JLabel("Aadhar Number:");
        ano.setFont(new Font("Raleway", Font.BOLD, 20));
        ano.setBounds(120, 490, 200, 30);
        add(ano);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(120, 540, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);

        JLabel exis = new JLabel("Existing Account:");
        exis.setFont(new Font("Raleway", Font.BOLD, 20));
        exis.setBounds(120, 590, 200, 30);
        add(exis);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);

        JButton next = new JButton("Next");
        next.setBackground(Color.cyan);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup_Two("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sRel = (String) religion.getSelectedItem();
        String sCat = (String) category.getSelectedItem();
        String sInc = (String) income.getSelectedItem();
        String sEdu = (String) education.getSelectedItem();
        String sOcc = (String) occupation.getSelectedItem();
        String senior = syes.isSelected() ? "Yes" : "No";
        String exist = eyes.isSelected() ? "Yes" : "No";
        String sPan = pan.getText().toUpperCase();
        String sAadhar = aadhar.getText();

        if (!sPan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
            JOptionPane.showMessageDialog(null, "Invalid PAN format");
            return;
        }

        if (!sAadhar.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null, "Invalid Aadhar");
            return;
        }

        String q = "INSERT INTO signuptwo VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            DBConnection con = new DBConnection();
            PreparedStatement pst = con.c.prepareStatement(q);
            pst.setString(1, formno);
            pst.setString(2, sRel);
            pst.setString(3, sCat);
            pst.setString(4, sInc);
            pst.setString(5, sEdu);
            pst.setString(6, sOcc);
            pst.setString(7, sPan);
            pst.setString(8, sAadhar);
            pst.setString(9, exist);
            pst.setString(10, senior);
            pst.executeUpdate();
            pst.close();
            con.c.close();

            setVisible(false);
            new Signup_Three(formno);
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}