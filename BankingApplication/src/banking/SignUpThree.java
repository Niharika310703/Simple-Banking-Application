package banking;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JLabel type, l1, cardno, number, pin, pnumber, service;
    ButtonGroup AccountGrp;
    JCheckBox c1, c2, c3, c4, c5, c6, declaration;
    JButton submit, cancel;
    String formno;
    String pinnumber;

    SignUpThree(String formno) {
        this.formno = formno;
        setLayout(null);

        // Title
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 25));
        l1.setBounds(280, 80, 600, 30);
        add(l1);

        // Account Type
        type = new JLabel("Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(80, 150, 300, 30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 18));
        r1.setBackground(Color.white);
        r1.setBounds(80, 200, 250, 30);
        add(r1);

        r2 = new JRadioButton("FD Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 18));
        r2.setBackground(Color.white);
        r2.setBounds(350, 200, 250, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 18));
        r3.setBackground(Color.white);
        r3.setBounds(80, 250, 250, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 18));
        r4.setBackground(Color.white);
        r4.setBounds(350, 250, 250, 30);
        add(r4);

        AccountGrp = new ButtonGroup();
        AccountGrp.add(r1);
        AccountGrp.add(r2);
        AccountGrp.add(r3);
        AccountGrp.add(r4);

        // Card Number
        cardno = new JLabel("CARD NUMBER: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(80, 320, 300, 30);
        add(cardno);

        number = new JLabel("XXXX-XXXX-XXXX-1010");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(300, 320, 300, 30);
        add(number);

        // PIN
        pin = new JLabel("PIN NUMBER: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(80, 380, 300, 30);
        add(pin);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(300, 380, 300, 30);
        add(pnumber);

        // Service Section
        service = new JLabel("Service Required: ");
        service.setFont(new Font("Raleway", Font.BOLD, 20));
        service.setBounds(80, 430, 300, 30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 20));
        c1.setBounds(80, 480, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 20));
        c2.setBounds(360, 480, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 20));
        c3.setBounds(600, 480, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 20));
        c4.setBounds(80, 530, 250, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 20));
        c5.setBounds(360, 530, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 20));
        c6.setBounds(600, 530, 200, 30);
        add(c6);

        // Separate Declaration Checkbox
        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declaration.setBackground(Color.white);
        declaration.setFont(new Font("Raleway", Font.BOLD, 16));
        declaration.setBounds(80, 600, 700, 30);
        add(declaration);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.yellow);
        cancel.setFont(new Font("Raleway", Font.BOLD, 22));
        cancel.setBounds(150, 690, 200, 40);
        cancel.addActionListener(this);
        add(cancel);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.yellow);
        submit.setFont(new Font("Raleway", Font.BOLD, 22));
        submit.setBounds(550, 690, 200, 40);
        submit.addActionListener(this);
        add(submit);

        // Frame settings
        getContentPane().setBackground(Color.white);
        setTitle("PAGE 3 - ACCOUNT DETAILS");
        setSize(850, 850);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;

            if (r1.isSelected()) {
                accountType = "Savings Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 3107200300000000L);
             pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            
            // Use separate if conditions for multiple selections
            if (c1.isSelected()) facility += " ATM Card";
            if (c2.isSelected()) facility += " Internet Banking";
            if (c3.isSelected()) facility += " Mobile Banking";
            if (c4.isSelected()) facility += " EMAIL & SMS Alerts";
            if (c5.isSelected()) facility += " Cheque Book";
            if (c6.isSelected()) facility += " E-Statement";

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Connect conn = new Connect();
                    String query3 = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "','" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
                    String query4 = "INSERT INTO login VALUES('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";
                    conn.s.executeUpdate(query3);
                    conn.s.executeUpdate(query4);
                    JOptionPane.showMessageDialog(null, "Card Number : "+ cardnumber +"\n Pin: "+ pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
