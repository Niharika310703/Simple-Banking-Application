package banking;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame{
     String pinnumber;
	public MiniStatement(String pinnumber) {
		 this.pinnumber = pinnumber;
		  setLayout(null);
		  setTitle("Mini Statement");
		  
		  JLabel text = new JLabel();
		  add(text);
		  
		  JLabel bank = new JLabel("My Bank");
		  bank.setBounds(160,20,100,20);
		  bank.setFont(new Font("Raleway", Font.BOLD,16));
		  add(bank);
		  
		  JLabel card = new JLabel() ;
		  card.setBounds(20,80,300,25);
		  card.setFont(new Font("Raleway", Font.BOLD,13));
		  add(card);
		  JLabel mini = new JLabel();
		  mini.setBounds(20, 140, 350, 400);
	        mini.setFont(new Font("Raleway", Font.PLAIN, 15));
	        mini.setVerticalAlignment(JLabel.TOP);
		  add(mini);
		  
		  JLabel bal= new JLabel();
		  bal.setBounds(20,350,300,20);
		  bal.setFont(new Font("Raleway", Font.PLAIN, 15));
		  add(bal);
		  
		  try {
			  Connect conn = new Connect();
			 ResultSet rs= conn.s.executeQuery("select * from login where pinnumber='"+pinnumber+"' ");
			 while(rs.next()) {
				 card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
			 }
		  }
		  catch(Exception e) {
			  System.out.println(e);
		  }
		  
		  try {
			  Connect  conn = new Connect();
			  int balance=0;
			  ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber ='"+pinnumber+"'");
			  StringBuilder statement = new StringBuilder("<html>");
	            
	            while (rs.next()) {
	                statement.append(rs.getString("date"))
	                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
	                        .append(rs.getString("type"))
	                        .append("&nbsp;&nbsp;&nbsp;&nbsp;")
	                        .append("₹")
	                        .append(rs.getString("amount"))
	                        .append("<br>");
	                if(rs.getString("type").equals("Deposit")) {
						  balance+= Integer.parseInt(rs.getString("amount"));
					  }else {
						  balance-= Integer.parseInt(rs.getString("amount"));
					  }
	                }
	            statement.append("</html>");
	            mini.setText(statement.toString());
	            bal.setText("Your Current Balance: Rs."+balance);
		  }
		  catch(Exception e) {
			  System.out.println(e);
		  }
		  
		  mini.setBounds(20,140,400,200);
		  add(mini);
		  
		  setSize(400, 600);
		  setLocation(20, 20);
		//  setUndecorated(true);
		  getContentPane().setBackground(Color.white);
		  setVisible(true);
	}

	public static void main(String[] args) {
	
       new MiniStatement("");
	}

}
