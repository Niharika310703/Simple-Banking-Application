package banking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener  {
	String pinnumber;
	JLabel text, pinText, repinText;
	JPasswordField newpin, newrepin;
	JButton change, exit;
	PinChange(String pinnumber){
	       this.pinnumber= pinnumber;
		  setLayout(null);
		  
		  ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm.jpg"));
		  Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		  ImageIcon i3 = new ImageIcon(i2);
		  JLabel image = new JLabel(i3);
		  image.setBounds(0,0,900,900);
		  add(image);
		
		  text = new JLabel("CHANGE YOUR PIN");
		  text.setBounds(250, 300, 200, 35);
		  text.setFont(new Font("Raleway", Font.BOLD, 16));
		  text.setForeground(Color.white);
		  image.add(text);
		  
		  pinText = new JLabel("New PIN");
		  pinText.setBounds(160, 360, 150, 30);
		  pinText.setFont(new Font("Raleway", Font.BOLD, 16));
		  pinText.setForeground(Color.white);
		  image.add(pinText);
		  
		  newpin= new JPasswordField();
		  newpin.setFont(new Font("Raleway", Font.BOLD, 16));
		  newpin.setBounds(320, 360, 180, 25);
		  image.add(newpin);
		  
		  
		  repinText = new JLabel("Re-Enter New PIN");
		  repinText.setBounds(160, 400, 180, 30);
		  repinText.setFont(new Font("Raleway", Font.BOLD, 16));
		  repinText.setForeground(Color.white);
		  image.add(repinText);
		  
		  newrepin= new JPasswordField();
		  newrepin.setFont(new Font("Raleway", Font.BOLD, 16));
		  newrepin.setBounds(320, 400, 180, 25);
		  image.add(newrepin);
		  
		  change = new JButton("Change");
		  change.setBounds(375,525,135,32);
		  change.addActionListener(this);
		  image.add(change);
		  
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
	   if(ae.getSource()==change) {
				try {
					String newPin = newpin.getText();
					String rePin= newrepin.getText();
					if(!newPin.equals(rePin)) {
						JOptionPane.showMessageDialog(null,"Entered PIN does not match");
						return ;
					}
					if(newPin.isEmpty()|| rePin.isEmpty()) {
						JOptionPane.showMessageDialog(null,"Please Enter PIN in both fields");
						return ;
					}
					
					Connect conn = new Connect();
					String q1 = "update bank set pinnumber='"+rePin+"' where pinnumber='"+pinnumber+"' ";
					String q2 = "update login set pinnumber='"+rePin+"' where pinnumber = '"+pinnumber+"'";
					String q3 = "update signupthree set pinnumber='"+rePin+"' where pinnumber = '"+pinnumber+"'";
				    
					conn.s.executeUpdate(q1);
					conn.s.executeUpdate(q2);
					conn.s.executeUpdate(q3);
					JOptionPane.showMessageDialog(null, "PIN changed successfully!");
					setVisible(false);
					new Transaction(rePin).setVisible(true);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
	    else {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
	  
	}
	
public static void main(String[] args) {
	new PinChange("").setVisible(true);
}
}
