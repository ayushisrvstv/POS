/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.awt.*;
import  javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class start implements ActionListener
{
JFrame f;
Panel p;
TextField t1,t2;
Label l1,l2,l3,l4,l5,l6,l7;
Button b3,b4,b5;
Choice c1;

Font f1,f2,f3,f4,f5;


start()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("POINT    OF      SALE");
l2= new 
Label("______________________________________________________________________________________________________________________________________________________________________________________________");
l3= new Label("LOGIN PAGE");
l4= new Label("---------------------------------------------------");

l5= new Label("User Id");
l6= new Label("Password");
l7= new Label("Usertype");


b3= new Button("Login");
b4= new Button("Reset");
b5= new Button("Close");

f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD|Font.ITALIC,30);
f3= new Font("sherif", Font.BOLD,25);
f4= new Font("sherif", Font.BOLD,20);
f5= new Font("sherif", Font.BOLD|Font.ITALIC,15);
c1=new Choice();
t1 = new TextField();
t2 = new TextField();



l1.setFont(f1);
l2.setFont(f5);
l3.setFont(f2);
l4.setFont(f5);
l5.setFont(f3);
t1.setFont(f4);
l6.setFont(f3);
t2.setFont(f3);
l7.setFont(f3);

c1.setFont(f5);


b3.setFont(f4);
 b4.setFont(f4);
 b5.setFont(f4);

}


void method()
{

f.setSize(900,1000);
p.setLayout(null);

l1.setBounds(250,10,450,70);
l2.setBounds(10,80,1000,30);
l3.setBounds(380,150,200,50);
l4.setBounds(376,180,220,40);
l5.setBounds(40,250,150,30);
t1.setBounds(250,250,250,30);
l6.setBounds(40,350,150,30);
t2.setBounds(250,350,250,30);
l7.setBounds(40,450,150,30);
c1.setBounds(250,450,250,30);
t2.setEchoChar('*');

b3.setBounds(170,650,150,40);
b4.setBounds(420,650,150,40);
b5.setBounds(650,650,150,40);

b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

c1.add("Administrator");
c1.add("Manager");
c1.add("Salesperson");

p.add(l1);
p.add(l2);
p.add(l3);
p.add(l4);
p.add(l5);
p.add(t1);
p.add(l6);
p.add(t2);
p.add(l7);
p.add(c1);

p.add(b3);
p.add(b4);
p.add(b5);

f.add(p);

f.setVisible(true);
f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

}

    @Override
public void actionPerformed(ActionEvent ae)
{
    try
    {
String s1 = ae.getActionCommand();

if ((s1.equals("Reset")))
       
{
     t1.setText("");
     t2.setText("");

}
  else if((s1.equals("Login")))
  {
      
      String a1 = t1.getText();
      String a2 = t2.getText();
       String  type= c1.getSelectedItem();
      if ((a1.equals("")) || (a2.equals("")) )
   {
JOptionPane.showMessageDialog(p,"please fill the text");
   }
     else
      {
         if(type.equals("Administrator"))
         {
           try
           {
               int i=0;
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
             Statement  stm = con.createStatement();
         ResultSet rs = stm.executeQuery("select * from  aprofile");
          while(rs.next())
          {
              if(a1.equals(rs.getString(3))    && (a2.equals(rs.getString(4))))
              {
                  i=i+1;
        project p = new project();
        p.method();
        f.dispose();
              }
          }
          if(i==0)
              {
               JOptionPane.showMessageDialog(p,"you are not a valid user");   
              }  
           }
           catch(Exception e) {   }
         } 
         else
        	 //System.out.println("what");
             if(type.equals("Manager"))
             {
                   try
           {
               int i=0;
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
             Statement  stm = con.createStatement();
             System.out.println("hi");
         ResultSet rs = stm.executeQuery("select * from  mprofile");
         System.out.println("here");
          while(rs.next())
          {
        	  System.out.println("where");
              if(a1.equals(rs.getString(3))    && (a2.equals(rs.getString(4))))
              {
                  i=i+1;
       manager p= new manager();
p.method();
f.dispose();
              }
          }
              if(i==0)
              { System.out.println("here is the prob");
               JOptionPane.showMessageDialog(p,"you are not a valid user");   
              }
           }
           catch(Exception e) {   }
             }
         else
             {
                 try{
               int i=0;
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
             Statement  stm = con.createStatement();
         ResultSet rs = stm.executeQuery("select * from  sprofile");
          while(rs.next())
          {
              if(a1.equals(rs.getString(3))    && (a2.equals(rs.getString(4))))
              {
                  i=i+1;
                   salesperson s=new salesperson();
                   s.method();
                   f.dispose();
              }
          }
              if(i==0)        
          
              {
            	  System.out.println("no.its here");
               JOptionPane.showMessageDialog(p,"you are not a valid user");
               
               
              }
           }
           catch(Exception e) {   } 
             }
    
      }
  }


  else 
{
f.dispose();
}

    }  
    
    catch(Exception e)
    {
    }
    }



public static void main (String args[])
{
start p= new start();
p.method();
}

   
}

