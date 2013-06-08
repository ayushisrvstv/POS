/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class mvvendor  implements ActionListener
{

JFrame f;
Panel p;
TextField t1,t2,t3,t4,t5,t7;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
Button b2,b3,b4,b5,b6,b7;
Font f1,f2,f3,f4,f5,f6;
Choice  t6;

mvvendor()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("Welcome:Manager");
l2= new Label("POINT   OF   SALE");
l3= new 
Label("_____________________________________________________________________________________________________________________________________________________________________________________________________");
l4= new Label("View Vendor Form");
l5= new Label("_________________________________________________________");
l11= new Label("Contact_Person_Id");

l6= new Label("Company_Name");
l7= new Label("Product_Name");
l8= new Label("Contactperson_Name");
l9= new Label("Contact_Number");
l10= new Label("E-mail_Id");

t1 = new TextField();
t2 = new TextField();
t3 = new TextField();
t4 = new TextField();
t5 = new TextField();
t6 = new Choice();
t7 = new TextField();
f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD|Font.ITALIC,30);
f3= new Font("sherif", Font.BOLD,25);
f4= new Font("sherif", Font.BOLD,20);
f5= new Font("sherif", Font.BOLD|Font.ITALIC,15);
f6 = new Font("sherif", Font.BOLD|Font.ITALIC, 20);

b2= new Button("Reset");
b3= new Button("Close");
b4= new Button("Back");
b5= new Button("Search");
b6=new Button("Logout");

l1.setFont(f5);
l2.setFont(f1);
l3.setFont(f6);
l4.setFont(f2);
l5.setFont(f2);
l6.setFont(f6);
l7.setFont(f6);
l8.setFont(f6);
l9.setFont(f6);
l10.setFont(f6);
l11.setFont(f6);

b5.setFont(f4);
b6.setFont(f5);
 b2.setFont(f4);
 b3.setFont(f4);
b4.setFont(f4);



    try
     {
        // String data = t6.getSelectedItem();
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from cvendor");
       while(rs.next())
       {
          String  first = rs.getString(1);
          t6.add(first);
       }
     }
     

     catch(Exception e) { System.out.println(e);  }    
 }

void launch()
{
f.setSize(800,800);
p.setLayout(null);

l1.setBounds(600,10,150,36);

l2.setBounds(100,30,400,70);
l3.setBounds(2,90,1200,30);
l4.setBounds(250,150,400,30);
l5.setBounds(250,170,300,30);
l11.setBounds(150,230,300,30);
t6.setBounds(450,230,150,30);
b5.setBounds(630,230,150,30);
b6.setBounds(600,50,100,30);

b5.addActionListener(this);


l6.setBounds(150,300,200,30);
t1.setBounds(450,300,150,30);
l7.setBounds(150,370,150,30);
t2.setBounds(450,370,150,30);

l8.setBounds(150,440,220,30);
t3.setBounds(450,440,150,30);
l9.setBounds(150,510,200,30);
t4.setBounds(450,510,150,30);
l10.setBounds(150,580,150,30);
t5.setBounds(450,580,150,30);


b2.setBounds(150,650,150,40);
b3.setBounds(350,650,150,40);
b4.setBounds(550,650,130,40);

b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b6.addActionListener(this);




p.add(l1);
p.add(l2);
p.add(l3);
p.add(l4);
p.add(l5);
p.add(l11);
p.add(t6);
p.add(l6);
p.add(b5);
p.add(t1);
p.add(b6);
p.add(l7);
p.add(t2);
p.add(l8);
p.add(t3);
p.add(l9);
p.add(t4);
p.add(l10);
p.add(t5);
//p.add(b4);

p.add(b2);
p.add(b3);
p.add(b4);
f.add(p);

f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae)
{
  
    
String s1 = ae.getActionCommand();

if(s1.equals("LogOut")){
	f.dispose();
	start p = new start();
	        p.method();
	   
}
else     

if(s1.equals("Search")) 
{
 
        try
     {
         String data = t6.getSelectedItem();
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from cvendor  where Contact_Person_ID='"+data+"' ");
       while(rs.next())
       {
        String  a2 = rs.getString(2);
        t1.setText(a2);
        String  a3 = rs.getString(3);
        t2.setText(a3);
         String  a4 = rs.getString(4);
        t3.setText(a4);

       String  a5 = rs.getString(5);
        t4.setText(a5);
  

      String  a6 = rs.getString(6);
        t5.setText(a6);

        

        

       }
     }
     

     catch(Exception e) { System.out.println(e);  }
 
}
 else  if(s1.equals("Reset"))
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t7.setText("");


}
else
if(s1.equals("Close"))
{
f.dispose();
}
else
{f.dispose();
manager p = new manager();
p.method();
   


}
    }


 


public static void main(String args[]){
mvvendor e=new  mvvendor ();
e.launch();
}}




