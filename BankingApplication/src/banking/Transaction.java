package banking;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Transaction extends JFrame implements ActionListener {
	String pinnumber;
	JLabel text;
	JButton deposit, withdraw, exit, fastcash, ministatement, pinchange, balanceEnq;
   Transaction(String pinnumber){
	  this.pinnumber = pinnumber;
	  setLayout(null);
	  
	  ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
	  Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  
	  JLabel image= new JLabel(i3);
	  image.setBounds(0, 0, 900, 900);
	  add(image);
	  
	  text = new JLabel("Please select your Transaction");
	  text.setBounds(220, 320, 700, 35);
	  text.setFont(new Font("Raleway", Font.BOLD, 16));
	  text.setForeground(Color.white);
	  image.add(text);
	  
	  deposit= new JButton("Deposit");
	  deposit.setBounds(160, 450, 135, 32);
	  deposit.setForeground(Color.black);
	  deposit.addActionListener(this);
	  image.add(deposit);
	  
	  withdraw= new JButton("Cash Withdrawl");
	  withdraw.setBounds(375, 450, 135, 32);
	  withdraw.setForeground(Color.black);
	  withdraw.addActionListener(this);
	  image.add(withdraw);
	  
	  fastcash= new JButton("Fast Cash");
	  fastcash.setBounds(160, 488, 135, 32);
	  fastcash.setForeground(Color.black);
	  fastcash.addActionListener(this);
	  image.add(fastcash);
	  
	  ministatement= new JButton("Mini Statement");
	  ministatement.setBounds(375, 488, 135, 35);
	  ministatement.setForeground(Color.black);
	  ministatement.addActionListener(this);
	  image.add(ministatement);
	  
	  pinchange= new JButton("Pin Change");
	  pinchange.setBounds(160, 525, 135, 32);
	  pinchange.setForeground(Color.black);
	  pinchange.addActionListener(this);
	  image.add(pinchange);
	  
	  balanceEnq= new JButton("Balance Enquiry");
	  balanceEnq.setBounds(375, 525, 135, 32);
	  balanceEnq.setForeground(Color.black);
	  balanceEnq.addActionListener(this);
	  image.add(balanceEnq);
	  
	  exit= new JButton("Exit");
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
	  if(ae.getSource()==deposit) {
		  
		  setVisible(false);
		  new Deposit(pinnumber).setVisible(true);
	
	  }
	  else if(ae.getSource()==withdraw) {
				  
				  setVisible(false);
				  new Withdrawl(pinnumber).setVisible(true);
			
			  }
	  else if(ae.getSource()==fastcash) {
		  
		  setVisible(false);
		  new FastCash(pinnumber).setVisible(true);
	
	  }
 else if(ae.getSource()==pinchange) {
		  
		  setVisible(false);
		  new PinChange(pinnumber).setVisible(true);
	
	  }
 else if(ae.getSource()==balanceEnq) {
	  
	  setVisible(false);
	  new BalanceEnquiry(pinnumber).setVisible(true);

 }
 else if(ae.getSource()==ministatement) {
	  new MiniStatement(pinnumber).setVisible(true);

}
	  else if(ae.getSource()==exit) {
		  System.exit(0);
	  }
  }
  public static void main(String[] args) {
	new Transaction("");
}
}
