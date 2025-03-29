package banking;
import javax.swing.*;

import java.awt.event.*; 
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.*;


public class SignUpTwo extends JFrame implements ActionListener {
	private static final long serialVersionUID=1L;
	long random;
	JComboBox<String> religionText, catText, incomeText, occuText, eduText;
	JRadioButton yes, no;
	ButtonGroup accountGrp;
	JButton next, clear;
	JTextField   aadharText, panText;
	JLabel  additionalDetails, religion, category, income, 
	education, occupation, panno, aadharno, qualification, existingAccount;
	String formno;
	
	
	SignUpTwo(String formno){
		this.formno=formno;
		setLayout(null);
		
		
		setTitle("NEW ACCOUNT APLICATION FOR - PAGE 2");

		
		additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(240,70,600,40);
		add(additionalDetails);
		
	    religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 18));
		religion.setBounds(100,150,600,30);
		add(religion);
		
		String[] s= {"Hindu", "Muslim", "Christian", "Sikh","Other"};
		religionText = new JComboBox<>(new DefaultComboBoxModel<>(s));
		religionText.setBounds(300,150,400,30);
		religionText.setBackground(Color.white);
		
		add(religionText);
		
	
		
		category  = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 18));
		category.setBounds(100,210,600,30);
		add(category);
		
		String[] cat= {"General","OBC", "SC", "ST","Other"};
		catText = new JComboBox<>(new DefaultComboBoxModel<>(cat));
		catText.setBounds(300,210,400,30);
		catText.setBackground(Color.white);
		add(catText);
		
		
		income  = new JLabel("Income: ");
		income.setFont(new Font("Raleway", Font.BOLD, 18));
		income.setBounds(100,260,600,30);
		add(income);
		
		String[] inco= {"Null","<1,50,000 ", "<2,50,000", "<5,00,000","Upto 10,00,000"};
		incomeText = new JComboBox<>(new DefaultComboBoxModel<>(inco));
		incomeText.setBounds(300,260,400,30);
		incomeText.setBackground(Color.white);
		add(incomeText);
		
		
		education  = new JLabel("Educational");
		education.setFont(new Font("Raleway", Font.BOLD, 18));
		education.setBounds(100,320,600,30);
		add(education);
		qualification  = new JLabel("Qualification: ");
		qualification.setFont(new Font("Raleway", Font.BOLD, 18));
		qualification.setBounds(100,350,600,30);
		add(qualification);
		
		String[] edu= {"Non- Graduate"," Gradute ", "Post Graduate", "Doctrate","Others"};
		 eduText = new JComboBox<>(new DefaultComboBoxModel<>(edu));
		eduText.setBounds(300,335,400,30);
		eduText.setBackground(Color.white);
		add(eduText);
		
		occupation  = new JLabel("Occupation: ");
		occupation.setFont(new Font("Raleway", Font.BOLD, 18));
		occupation.setBounds(100,400,600,30);
		add(occupation);
		 
		String[] occu= {"Salaried","Self-Employeed", "Businessman", "Student","Retired","Others"};
		 occuText = new JComboBox<>(new DefaultComboBoxModel<>(occu));
		occuText.setBounds(300,400,400,30);
		occuText.setBackground(Color.white);
		
		add(occuText);
		
		
		aadharno  = new JLabel("Aadhar Nunmber: ");
		aadharno.setFont(new Font("Raleway", Font.BOLD, 18));
		aadharno.setBounds(100,470,600,30);
		add(aadharno);
		
		aadharText = new JTextField();
		aadharText.setFont(new Font("Raleway", Font.BOLD, 18));
		aadharText.setBounds(300,470,400,30);
		add(aadharText);
		
		panno = new JLabel("PAN Number: ");
		panno.setFont(new Font("Raleway", Font.BOLD, 18));
		panno.setBounds(100,520,600,30);
		add(panno);
		
		panText = new JTextField();
		panText.setFont(new Font("Raleway", Font.BOLD, 18));
		panText.setBounds(300,520,400,30);
		add(panText);
		
		existingAccount  = new JLabel("Existing Account: ");
		existingAccount.setFont(new Font("Raleway", Font.BOLD, 18));
		existingAccount.setBounds(100,580,600,30);
		add(existingAccount);
		
	
		yes = new JRadioButton("Yes");
	    yes.setBounds(300,580,80,30);
	    yes.setBackground(Color.white);
	    yes.setFont(new Font("Raleway", Font.BOLD, 14));
	    add(yes);
		
		no = new JRadioButton("No");
		no.setBounds(450,580,90,30);
		no.setFont(new Font("Raleway", Font.BOLD, 14));
		no.setBackground(Color.white);
		add(no);
		
		accountGrp = new ButtonGroup();
		accountGrp.add(yes);
		accountGrp.add(no);
	
		
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
	    	religionText.setSelectedIndex(-1);   // Clear selection
	    	catText.setSelectedIndex(-1);
	    	incomeText.setSelectedIndex(-1);
	    	eduText.setSelectedIndex(-1);
	    	occuText.setSelectedIndex(-1);
            aadharText.setText("");
	        panText.setText("");
	        accountGrp.clearSelection();
	        
	        
	    } else if (ae.getSource() == next) {
	        // Proceed with the next button action
	        
	        String religion = (String)religionText.getSelectedItem();
	       // String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
	        
	        String category = (String)catText.getSelectedItem();
	        String income = (String)incomeText.getSelectedItem();
	        String education = (String)eduText.getSelectedItem();
	        String occupation = (String)occuText.getSelectedItem();
	        
	        String aadhar = aadharText.getText();
	        String pan = panText.getText();
	        
	        String existingAccount = null;
	        if (yes.isSelected()) {
	            existingAccount = "Yes";
	        } else if (no.isSelected()) {
	            existingAccount = "No";
	        }


	        

	        try {
	                Connect c = new Connect();
	                String query2 = "INSERT INTO signuptwo "
	                		+ "VALUES ('" + formno + "', '" + religion + "', '" +category+ "', '" + income + "', '" + education + "', " +
	                                "'" + occupation + "', '" + aadhar + "', '" + pan + "', '" + existingAccount + "')";
	                c.s.executeUpdate(query2);
	                JOptionPane.showMessageDialog(null, "Data Saved Successfully!");
	                 setVisible(false);
	                 new SignUpThree(formno).setVisible(true);
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}

	
 public static void main(String[] args) {
	new SignUpTwo("");
}
}










