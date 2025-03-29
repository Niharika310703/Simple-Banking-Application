package banking;
import javax.swing.*;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Withdrawl extends JFrame implements ActionListener{
	JLabel withdrawl;
	JTextField withdrawText;
	JButton withdrawBut, exit;
	String pinnumber;
	
	Withdrawl(String pinnumber) {
		
		this.pinnumber= pinnumber;
		setLayout(null);
		
	 ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	 Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	 ImageIcon i3 = new ImageIcon(i2);
	 
	 JLabel image= new JLabel(i3);
	  image.setBounds(0, 0, 900, 900);
	  add(image);
	  
	  withdrawl = new JLabel("Enter the amount you want to  Withdraw");
	  withdrawl.setForeground(Color.white);
	  withdrawl.setBounds(180, 310, 600, 30);
	  withdrawl.setFont(new Font("System", Font.BOLD,17));
	  image.add( withdrawl);
	  
	  withdrawText= new JTextField();
	  withdrawText.setBackground(Color.white);
	  withdrawText.setBounds(180, 370, 300, 25);
	  withdrawText.setFont(new Font("Raleway", Font.BOLD,17));
	  image.add(withdrawText);
	  
	  withdrawBut = new JButton("Withdraw");
	  withdrawBut.setBounds(375,525,135,32);
	  withdrawBut.setForeground(Color.black);
	  withdrawBut.addActionListener(this);
	  image.add( withdrawBut);
	  
	  
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
		  
		  if(ae.getSource()== withdrawBut) {
			  
			String amount =  withdrawText.getText();
			Date date = new Date();
			
			
			
			if(amount.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
				return;
			}
			else {
				try {
				Connect conn = new Connect();
				String query1= "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawl','"+amount+"')";
				conn.s.executeUpdate(query1);
				JOptionPane.showMessageDialog(null,"Rs."+amount+" Withdrawn Succesfully");
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
	new Withdrawl("");
}
}
