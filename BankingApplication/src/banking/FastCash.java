package banking;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
	String pinnumber;
	JLabel text;
	JButton deposit, withdraw, exit, fastcash, ministatement, pinchange, balanceEnq;
  FastCash(String pinnumber){
	  this.pinnumber = pinnumber;
	  setLayout(null);
	  
	  ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	  Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  
	  JLabel image= new JLabel(i3);
	  image.setBounds(0, 0, 900, 900);
	  add(image);
	  
	  text = new JLabel("Select Withdrawl Amount");
	  text.setBounds(220, 320, 700, 35);
	  text.setFont(new Font("Raleway", Font.BOLD, 16));
	  text.setForeground(Color.white);
	  image.add(text);
	  
	  deposit= new JButton("Rs.100");
	  deposit.setBounds(160, 450, 135, 32);
	  deposit.setForeground(Color.black);
	  deposit.addActionListener(this);
	  image.add(deposit);
	  
	  withdraw= new JButton("Rs.500");
	  withdraw.setBounds(375, 450, 135, 32);
	  withdraw.setForeground(Color.black);
	  withdraw.addActionListener(this);
	  image.add(withdraw);
	  
	  fastcash= new JButton("Rs.1000");
	  fastcash.setBounds(160, 488, 135, 32);
	  fastcash.setForeground(Color.black);
	  fastcash.addActionListener(this);
	  image.add(fastcash);
	  
	  ministatement= new JButton("Rs.2000");
	  ministatement.setBounds(375, 488, 135, 35);
	  ministatement.setForeground(Color.black);
	  ministatement.addActionListener(this);
	  image.add(ministatement);
	  
	  
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
	  if(ae.getSource()==exit) {
		  setVisible(false);
		  new Transaction(pinnumber).setVisible(true);
	  }
	  else  { 
		  String amount = (((JButton)ae.getSource())).getText().substring(3);
		  Connect conn = new Connect();
		  try {
			  ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber= '"+pinnumber+"'");
			  int balance =0;
			  while(rs.next()) {
				  if(rs.getString("type").equals("Deposit")) {
					  balance+= Integer.parseInt(rs.getString("amount"));
				  }else {
					  balance-= Integer.parseInt(rs.getString("amount"));
				  }
			  }
			  if(ae.getSource()!= exit && balance < Integer.parseInt(amount)) {
				  JOptionPane.showMessageDialog(null, "Insufficient Balance");
				  return;
			  }
			  Date date = new Date();
			  String query= "insert into bank values('"+pinnumber+"','"+date+"', 'Withdrawl','"+amount+"')";
			  conn.s.executeUpdate(query);
			  JOptionPane.showMessageDialog(null, "Rs."+amount+" Withdrawl Successfully!");
			  setVisible(false);
			  new Transaction(pinnumber).setVisible(true);
		  }
		  catch(Exception e) {
			  System.out.println(e);
		  }
			  }
	   
  }
  public static void main(String[] args) {
	new FastCash("");
}
}
