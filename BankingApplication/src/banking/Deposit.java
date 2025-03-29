package banking;
import javax.swing.*;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Deposit extends JFrame implements ActionListener{
	JLabel deposit;
	JTextField depositText;
	JButton depositBut, exit;
	String pinnumber;
	
	Deposit(String pinnumber) {
		
		this.pinnumber= pinnumber;
		setLayout(null);
		
	 ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	 Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	 ImageIcon i3 = new ImageIcon(i2);
	 
	 JLabel image= new JLabel(i3);
	  image.setBounds(0, 0, 900, 900);
	  add(image);
	  
	  deposit = new JLabel("Enter the amount you want to Deposit");
	  deposit.setForeground(Color.white);
	  deposit.setBounds(180, 310, 600, 30);
	  deposit.setFont(new Font("System", Font.BOLD,17));
	  image.add(deposit);
	  
	  depositText= new JTextField();
	  depositText.setBackground(Color.white);
	  depositText.setBounds(180, 370, 300, 25);
	  depositText.setFont(new Font("Raleway", Font.BOLD,17));
	  image.add(depositText);
	  
	  depositBut = new JButton("Deposit");
	  depositBut.setBounds(375,525,135,32);
	  depositBut.setForeground(Color.black);
	  depositBut.addActionListener(this);
	  image.add(depositBut);
	  
	  
	  exit= new JButton("Back");
	  exit.setBounds(375, 561, 135, 32);
	  exit.setForeground(Color.black);
	  exit.addActionListener(this);
	  image.add(exit);
	  
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	  public void actionPerformed(ActionEvent ae) {
		  
		  if(ae.getSource()==depositBut) {
			  
			String amount = depositText.getText();
			Date date = new Date();
			
			
			
			if(amount.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
				return;
			}
			else {
				try {
				Connect conn = new Connect();
				String query1= "insert into bank values('"+pinnumber+"', '"+date+"','Deposit','"+amount+"')";
				conn.s.executeUpdate(query1);
				JOptionPane.showMessageDialog(null,"Rs."+amount+" Deposited Succesfully");
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		  } 
		  
		  else if(ae.getSource()==exit) {
			  setVisible(false);
			  new Transaction(pinnumber).setVisible(true);
			  
		  }
	  }
	
public static void main(String[] args) {
	new Deposit("");
}
}
