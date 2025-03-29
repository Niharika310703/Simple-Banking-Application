package banking;
import javax.swing.*;

import java.awt.event.*; 
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.*;


public class SignUpOne extends JFrame implements ActionListener {
	long random; JDateChooser date;
	JLabel formno;
	JRadioButton male, female, married, unmarried, other;
	ButtonGroup genderGrp, marriedGrp; JButton next, clear;
	JTextField nameText, emailText, cityText, addressText, stateText, pincodeText;
	JLabel fromno, personDetails, name, dob, gender, email, marital, address, city, state, pincode;
	SignUpOne(){
		setLayout(null);
		Random ran = new Random();
		random= Math.abs(ran.nextLong() % 9000L+1000);
		formno = new JLabel("APPLICATION FORM NO. "+ random);
		formno.setFont(new Font("Raleway", Font.BOLD, 35));
		formno.setBounds(150,20,600,40);
		add(formno);
		
		personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(240,70,600,40);
		add(personDetails);
		
	    name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 18));
		name.setBounds(100,150,600,30);
		add(name);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Raleway", Font.BOLD, 18));
		nameText.setBounds(300,150,400,30);
		add(nameText);
		
		dob  = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 18));
		dob.setBounds(100,210,600,30);
		add(dob);
		
		date= new JDateChooser();
		date.setBounds(300,210,400,30);
		date.setForeground(Color.black);
		date.setFont(new Font("Raleway", Font.BOLD, 14));
		add(date);
		
		
		gender  = new JLabel("Gender: ");
		gender.setFont(new Font("Raleway", Font.BOLD, 18));
		gender.setBounds(100,260,600,30);
		add(gender);
		
		male = new JRadioButton("Male");
	    male.setBounds(300, 270,80,30);
	    male.setBackground(Color.white);
	    male.setFont(new Font("Raleway", Font.BOLD, 14));
	    add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450,270,90,30);
		female.setFont(new Font("Raleway", Font.BOLD, 14));
		female.setBackground(Color.white);
		add(female);
		
		genderGrp = new ButtonGroup();
		genderGrp.add(male);
		genderGrp.add(female);
		
		email  = new JLabel("Email Address: ");
		email.setFont(new Font("Raleway", Font.BOLD, 18));
		email.setBounds(100,320,600,30);
		add(email);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Raleway", Font.BOLD, 18));
		emailText.setBounds(300,320,400,30);
		add(emailText);
		
		marital  = new JLabel("Marital Status: ");
		marital.setFont(new Font("Raleway", Font.BOLD, 18));
		marital.setBounds(100,380,600,30);
		add(marital);
		
		married = new JRadioButton("Married");
	    married.setBounds(300, 380,80,30);
	    married.setFont(new Font("Raleway", Font.BOLD, 14));
	    married.setBackground(Color.white);
	    add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,380,120,30);
		unmarried.setFont(new Font("Raleway", Font.BOLD, 14));
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(600,380,90,30);
		other.setFont(new Font("Raleway", Font.BOLD, 14));
		other.setBackground(Color.white);
		add(other);
		
		marriedGrp = new ButtonGroup();
		marriedGrp.add(married);
		marriedGrp.add(unmarried);
		marriedGrp.add(other);
		address  = new JLabel("Address: ");
		address.setFont(new Font("Raleway", Font.BOLD, 18));
		address.setBounds(100,440,600,30);
		add(address);
		
		addressText = new JTextField();
		addressText.setFont(new Font("Raleway", Font.BOLD, 18));
		addressText.setBounds(300,440,400,30);
		add(addressText);
		
		city  = new JLabel("City: ");
		city.setFont(new Font("Raleway", Font.BOLD, 18));
		city.setBounds(100,500,600,30);
		add(city);
		
		cityText = new JTextField();
		cityText.setFont(new Font("Raleway", Font.BOLD, 18));
		cityText.setBounds(300,500,400,30);
		add(cityText);
		
		state  = new JLabel("State: ");
		state.setFont(new Font("Raleway", Font.BOLD, 18));
		state.setBounds(100,560,600,30);
		add(state);
		
		stateText = new JTextField();
		stateText.setFont(new Font("Raleway", Font.BOLD, 18));
		stateText.setBounds(300,560,400,30);
		add(stateText);
		
		pincode  = new JLabel("Pincode: ");
		pincode.setFont(new Font("Raleway", Font.BOLD, 18));
		pincode.setBounds(100,620,600,30);
		add(pincode);
		
		pincodeText = new JTextField();
		pincodeText.setFont(new Font("Raleway", Font.BOLD, 18));
		pincodeText.setBounds(300,620,400,30);
		add(pincodeText);
		
		clear = new JButton("Clear");
		clear.setBounds(230,700,100,30);
		clear.setBackground(Color.black);
		clear.setFont(new Font("Raleway", Font.BOLD, 20));
		clear.setForeground(Color.yellow);
		clear.addActionListener(this);
		add(clear);
		
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setFont(new Font("Raleway", Font.BOLD, 20));
		next.setForeground(Color.yellow);
		next.setBounds(620,700,100,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(800,800);
		setUndecorated(true);
		setLocation(350,20);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == clear) {
	        // Clear all the input fields
	        nameText.setText("");
	        date.setDate(null);
	        emailText.setText("");
	        addressText.setText("");
	        cityText.setText("");
	        stateText.setText("");
	        pincodeText.setText("");
	        genderGrp.clearSelection();
	        marriedGrp.clearSelection();
	        
	    } else if (ae.getSource() == next) {
	        // Proceed with the next button action
	        String formno = "" + random;
	        String name = nameText.getText();
	        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
	        
	        String gender = null;
	        if (male.isSelected()) {
	            gender = "Male";
	        } else if (female.isSelected()) {
	            gender = "Female";
	        }

	        String email = emailText.getText();
	        String marital = null;
	        if (married.isSelected()) {
	            marital = "Married";
	        } else if (unmarried.isSelected()) {
	            marital = "Unmarried";
	        } else if (other.isSelected()) {
	            marital = "Other";
	        }
	        
	        String address = addressText.getText();
	        String city = cityText.getText();
	        String state = stateText.getText();
	        String pincode = pincodeText.getText();

	        try {
	            if (name.equals("")) {
	                JOptionPane.showMessageDialog(null, "Name is required");
	            } else {
	                Connect c = new Connect();
	                String query1 = "INSERT INTO signup (formno, name, dob, gender, email, marital, address, city, state, pincode) " +
	                                "VALUES ('" + formno + "', '" + name + "', '" + dob + "', '" + gender + "', '" + email + "', " +
	                                "'" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pincode + "')";
	                c.s.executeUpdate(query1);
	                JOptionPane.showMessageDialog(null, "Data Saved Successfully!");
	                setVisible(false);
	                new SignUpTwo(formno).setVisible(true);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}

	
 public static void main(String[] args) {
	new SignUpOne();
}
}










