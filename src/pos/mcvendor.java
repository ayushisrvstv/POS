/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class mcvendor implements ActionListener
{

JFrame f;
Panel p;
TextField t1,t2,t3,t4,t5,t6;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
Button b1,b2,b3,b4,b5;
Font f1,f2,f3,f4,f5,f6;

mcvendor()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("Welcome:Manager");
l2= new Label("POINT   OF   SALE");
l3= new 
Label("_______________________________________________________________________________________________");
l4= new Label("Create Vendor");
l5= new Label("_______________________________________________");
l6= new Label("Company_Name");
l7= new Label("Product_Name");
l8= new Label("Contactperson_Name");
l9= new Label("Contact_Number");
l10= new Label("E-mail_Id");
l11=new Label("Contact_Person_Id");

t1 = new TextField();
t2 = new TextField();
t3 = new TextField();
t4 = new TextField();
t5 = new TextField();
t6 = new TextField();
f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD|Font.ITALIC,30);
f3= new Font("sherif", Font.BOLD,25);
f4= new Font("sherif", Font.BOLD,20);
f5= new Font("sherif", Font.BOLD|Font.ITALIC,15);
f6 = new Font("sherif", Font.BOLD|Font.ITALIC, 20);
b1= new Button("Create");
b2= new Button("Reset");
b3= new Button("Close");
b4= new Button("Back");
b5=new Button("LogOut");
l1.setFont(f5);
l2.setFont(f1);
l3.setFont(f5);
l4.setFont(f2);
l5.setFont(f2);
l6.setFont(f6);
l7.setFont(f6);
l8.setFont(f6);
l9.setFont(f6);
l10.setFont(f6);
l11.setFont(f6);

b1.setFont(f4);
 b2.setFont(f4);
 b3.setFont(f4);
b4.setFont(f4);
b5.setFont(f5);
}

void launch()
{
f.setSize(800,800);
p.setLayout(null);

l1.setBounds(600,10,150,36);

l2.setBounds(100,30,400,70);
l3.setBounds(2,90,1200,20);
l4.setBounds(250,150,250,30);
l5.setBounds(250,170,230,30);
l11.setBounds(150,220,220,30);
t6.setBounds(450,220,200,30);

l6.setBounds(150,280,200,30);
t1.setBounds(450,280,200,30);

l7.setBounds(150,350,240,30);
t2.setBounds(450,350,200,30);
l8.setBounds(150,430,240,30);
t3.setBounds(450,430,200,30);
l9.setBounds(150,510,200,30);
t4.setBounds(450,510,200,30);
l10.setBounds(150,580,200,30);
t5.setBounds(450,580,200,30);

b1.setBounds(80,650,150,40);
b2.setBounds(280,650,150,40);
b3.setBounds(480,650,150,40);
b4.setBounds(660,650,130,40);
b5.setBounds(600,50,100,30);

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
p.add(l11);
p.add(t6);
p.add(l6);
p.add(t1);
p.add(b5);
p.add(l7);
p.add(t2);
p.add(l8);
p.add(t3);
p.add(l9);
p.add(t4);
p.add(l10);
p.add(t5);

p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);
f.add(p);

f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae)
{ 
        String s1=ae.getActionCommand();

        

        if(s1.equals("LogOut")){
        	f.dispose();
        	start p = new start();
        	        p.method();
        	   
        }
        else  
        
        if(s1.equals("Create"))
{
   
 String y1= t1.getText();    
        
String y2= t2.getText();
String y3= t3.getText();
String y4= t4.getText();
String y5= t5.getText();
String y6= t6.getText();

 try
 {

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
 PreparedStatement  ps = con.prepareStatement("insert into cvendor values(?,?,?,?,?,?)");
ps.setString(2,y1);
       ps.setString(3,y2);
       ps.setString(4,y3);
       ps.setString(5,y4);
        
       ps.setString(6,y5);
       
        ps.setString(1,y6);

ps.executeUpdate();
       JOptionPane.showMessageDialog(p,"data has been saved");
       t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");

 }
catch(Exception e)
 { System.out.println(e); }
}


        else   if(s1.equals("Reset"))
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
}
else
if(s1.equals("Close"))
{
f.dispose();
}
else
{
f.dispose();
manager p= new manager();
p.method();
}
    }
    

public static void main(String args[]){
mcvendor e=new mcvendor ();
e.launch();
}}





