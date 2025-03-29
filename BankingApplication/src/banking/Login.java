package banking;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	 JButton login, signup, clear;
	 JTextField cardText; JPasswordField pinText;
	Login(){
		setLayout(null);
		setTitle("BANKING SYSTEM");
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/download.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2) ;
		JLabel label= new JLabel(i3);
		label.setBounds(70,10,150,150);
		add(label);
		
		 JLabel text = new JLabel("Welcome to MyBank");
		 text.setFont(new Font("Osward", Font.BOLD, 38));
		 text.setBounds(250, 40, 500, 50);
		 add(text);
		 
		 JLabel cardno = new JLabel("CARD NUMBER:");
		 cardno.setFont(new Font("Osward", Font.BOLD, 18));
		 cardno.setBounds(150, 150, 150, 30);
		 add(cardno);
		 
		 cardText = new JTextField();
		 cardText.setBounds(300,150, 230,30);
		 cardText.setFont(new Font("Arial",Font.BOLD, 16));
		 add(cardText);
		 
		 JLabel pin = new JLabel("PIN:");
		 pin.setFont(new Font("Osward", Font.BOLD, 18));
		 pin.setBounds(150, 200, 150, 30);
		 add(pin);

		 pinText = new JPasswordField();
		 pinText.setBounds(300,200, 230,30);
		 pinText.setFont(new Font("Arial",Font.BOLD, 17));
		 add(pinText);
		 
		login = new JButton("Login");
		login.setBounds(300,250,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.yellow);
		login.addActionListener(this);
		add(login);
		
		
		clear = new JButton("Clear");
		clear.setBounds(430,250,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.yellow);
		clear.addActionListener(this);
		add(clear);
		

		signup = new JButton("Sign-Up");
		signup.setBounds(300,300,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.yellow);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		
		setSize(800,500);
		
		setVisible(true);
		setLocation(450,200);
	}
	
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()== clear) {
		cardText.setText("");
		pinText.setText("");
	} else if(ae.getSource()== login) {
		Connect conn = new Connect();
		String cardnumber = cardText.getText();
		String pinnumber = pinText.getText();
		String query = "select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
		try {
			ResultSet rs = conn.s.executeQuery(query);
			if(rs.next()) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
			}
			
		} catch(Exception e) {
			
			System.out.println(e);
		}
		
	} else if(ae.getSource()== signup) {
		setVisible(false);
		 new SignUpOne().setVisible(true);
	}
	
}
  public static void main(String[] args) {
	new Login();
	
}
}
