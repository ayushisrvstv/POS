package pos;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


class schange implements ActionListener
{
JFrame f ;
Panel p;
TextField t1,t2,t3;
Label l1,l2,l3,l4,l5,l6,l7,l8;
Button b1,b2,b3,b4,b5;
Font f1,f2,f3;
schange()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("POINT  OF  SALE ");
l2= new Label("Welcome:Salesperson");
l3= new Label("____________________________________________________________________________________________________________________________________________");
l4= new Label("Please Enter Details For Change Password");
l5= new Label("_________________________________________________________________________________________________________________________________________________________");
l6= new Label("Old password");
l7= new Label("New password");
l8= new Label("Retype Password");
b1= new Button("Generate");
b2= new Button("Reset");
b3= new Button("Close");
b4= new Button("Back");
b5=new Button("LogOut");
t1 = new TextField();
t2 = new TextField();
t3 = new TextField();
f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD,25);
f3= new Font("sherif", Font.BOLD,15);

l1.setFont(f1);
l2.setFont(f3);
l3.setFont(f2);
l4.setFont(f2);
l5.setFont(f2);
l6.setFont(f2);
l7.setFont(f2);
l8.setFont(f2);
b1.setFont(f2);
b2.setFont(f2);
b3.setFont(f2);
b4.setFont(f2);
b5.setFont(f3);
}
void password()
{
f.setSize(800,800);
p.setLayout(null);

b5.setBounds(610,40,100,30);
l1.setBounds(150,10,400,70);
l2.setBounds(610,10,180,25);
l3.setBounds(1,70,800,30);
l4.setBounds(150,115,600,30);
l5.setBounds(1,150,800,30);
l6.setBounds(70,250,200,30);
t1.setBounds(400,250,150,30);
l7.setBounds(70,350,200,30);
t2.setBounds(400,350,150,30);
l8.setBounds(70,450,220,30);
t3.setBounds(400,450,150,30);


b1.setBounds(70,550,150,30);
b2.setBounds(250,550,120,30);
b3.setBounds(450,550,120,30);
b4.setBounds(650,550,120,30);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);



p.add(l1);
p.add(l2);
p.add(l3);
p.add(l4);
p.add(l5);
p.add(l6);
p.add(l7);
p.add(l8);
p.add(t1);
p.add(t2);
p.add(t3);
p.add(b1);
p.add(b2);
p.add(b5);
p.add(b3);
p.add(b4);

f.add(p);

f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public void actionPerformed(ActionEvent ae)
{
    try
    {
String s1 = ae.getActionCommand();
if(s1.equals("Generate"))
{
String a1 = t1.getText();
String a2 = t2.getText();
String a3 = t3.getText();



   if ((a1.equals("")) || (a2.equals("")) || (a3.equals("")) )
{
JOptionPane.showMessageDialog(p,"All the fields should be filled");

}
else

	if(a2.equals(a3))
	{
		
	try
	 {

	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");

	 PreparedStatement  ps = con.prepareStatement("update sprofile set Password=? where Password=?  ");
	  ps.setString(1,a2);
	 ps.setString(2,a1);

	ps.executeUpdate();
	       JOptionPane.showMessageDialog(p,"data has been updated");
	       f.dispose();
	       salesperson p= new salesperson();
	       p.method();
	 
	 }
	catch(Exception e)
	 { System.out.println(e); }
	}
	 
	}

else
     if(s1.equals("Reset"))
{
t1.setText("");
t2.setText("");
t3.setText("");

}
else
if(s1.equals("Close"))
{
f.dispose();
}
else
	
if(s1.equals("LogOut"))
{
	f.dispose();
	start p = new start();
	        p.method();
	   
}


else
{
    f.dispose();
salesperson p = new salesperson();
        p.method();
}
    }
    catch(Exception e)
    {
    }
    }
public static void main (String args[])
{
schange c = new schange();
c.password();
}
}




