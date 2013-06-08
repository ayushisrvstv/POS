/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class mpurchase implements ActionListener
{

JFrame f;
Panel p;
TextField t3,t4,t5,t6,t7,t8;
Label l1,l2,l3,l4,l5,l6,l7,l9,l10,l11,l14,l15;
Button b1,b2,b3,b4,b5,b6,b7,b8;
Checkbox c1,c2;
Choice t2;

Font f1,f2,f3,f4;
mpurchase()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("POINT  OF  SALE");
l2= new Label("Welcome:Manager");
l3= new Label("Purchase Record Form ");
l4= new Label("Product_Id");
l5= new Label("Product_Name");
l6= new Label("Company_Name");
l7= new Label("Quantity");
l9= new Label("Date");
l10= new Label("Amount_Per_Quantity");
l11= new Label("Total Amount");
l14= new 
Label("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
l15= new 
Label("_____________________________________________________________________________________________________________________________________________________________________________________________________");
b1= new Button("Total");
b2= new Button("Update");
b3= new Button("Reset");
b4= new Button("Close");
b5= new Button("Back");
b6= new Button("Search");
b7=new Button("LogOut");
b8=new Button("Calendar");

f1= new Font("sherif", Font.BOLD|Font.ITALIC,20);
f2= new Font("sherif", Font.BOLD,15);
f3= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f4= new Font("sherif", Font.BOLD|Font.ITALIC,30);

t2 = new Choice();
t3 = new TextField();
t4 = new TextField();
t5 = new TextField();
t6 = new TextField();
t7 = new TextField();
t8 = new TextField();


l1.setFont(f3);
l2.setFont(f2);
l3.setFont(f4);
l4.setFont(f1);
l5.setFont(f1);
l6.setFont(f1);
l7.setFont(f1);

l9.setFont(f1);
l10.setFont(f1);
l11.setFont(f1);

l14.setFont(f2);
l15.setFont(f2);
b7.setFont(f2);
b1.setFont(f1);
b2.setFont(f1);
b3.setFont(f1);
b4.setFont(f1);
b5.setFont(f1);
b6.setFont(f1);
b8.setFont(f1);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
try
      {   
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from purchaserecord");
       while(rs.next())
       {
        String  a2 = rs.getString(3);
        t2.add(a2);
       }
      }
      catch(Exception e) { System.out.println(e); }
        



}

void method()
{
f.setSize(800,900);

p.setLayout(null);

l2.setBounds(650,5,200,25);
l1.setBounds(150,10,400,75);
l14.setBounds(5,100,800,5);
l3.setBounds(200,120,400,30);


l15.setBounds(5,150,800,30);

l4.setBounds(70,200,200,30);
t2.setBounds(350,200,150,30);
b6.setBounds(620,200,150,30);
b7.setBounds(650,40,100,30);

l5.setBounds(70,250,250,30);
t3.setBounds(350,250,150,30);

l6.setBounds(70,300,200,30);
t4.setBounds(350,300,150,30);

l7.setBounds(70,350,200,30);
t5.setBounds(350,350,150,30);



l9.setBounds(70,400,200,30);
b8.setBounds(600,400,150,30);
t6.setBounds(350,400,150,30);

l10.setBounds(70,450,250,30);
t7.setBounds(350,450,150,30);

l11.setBounds(70,500,200,30);
t8.setBounds(350,500,150,30);

b1.setBounds(600,500,150,30);
b2.setBounds(70,600,150,30);
b3.setBounds(250,600,150,30);
b4.setBounds(430,600,150,30);
b5.setBounds(600,600,150,30);



p.add(l2);
p.add(l1);
p.add(l14);

p.add(l3);


p.add(l15);
p.add(l4);
p.add(t2);

p.add(l5);

p.add(t3);
p.add(l6);

p.add(t4);
p.add(l7);
p.add(t5);
p.add(b7);
p.add(b8);



p.add(l9);
p.add(t6);

p.add(l10);
p.add(t7);

p.add(l11);
p.add(t8);


p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);
p.add(b5);
p.add(b6);


f.add(p);

f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public  void  actionPerformed(ActionEvent   ae) 
{
  String  s1 = ae.getActionCommand();
  
  if(s1.equals("Calendar"))
	{
		// DatePicker dp=new DatePicker(f);
	 //dp.displayDate(); 
		// f.getContentPane().add(p);
	    
		b8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		            t6.setText(new DatePicker(f).setPickedDate());
		            
		    }
		});
	         
	}
	else
  
  if(s1.equals("LogOut")){
		f.dispose();
		start p = new start();
		        p.method();
		   
	}
  else
  
   if(s1.equals("Total"))
{
   String  s2 = t5.getText();
   String  s3 = t7.getText();
   double  d2 = Double.valueOf(s2);
   double  d3 = Double.valueOf(s3);
   double  total_amount = d2 * d3;
   String total = String.valueOf(total_amount);
   t8.setText(total);
}

   else
       if(s1.equals("Update"))
 
{



String y3= t3.getText();
String y4 = t4.getText();
String y5= t5.getText();
String y6= t6.getText();
 String y7= t7.getText();
 
 
 try
 {
String y = t2.getSelectedItem();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");

//PreparedStatement  ps = con.prepareStatement("update purchaserecord  set Company_Name= ?, Amount_per_quantity= ?,Product_Name = ?, Quantity=?, Date=?   where  Product_Id ='"+y+"'  ");
PreparedStatement   ps = con.prepareStatement("update purchaserecord  set Company_Name=?,Amount=?,Product_Name=?,Quantity=?,purchase_date=?  where Product_Id='"+y+"' ");
ps.setString(1,y4);
ps.setString(2,y7);
ps.setString(3,y3);
ps.setString(4,y5);
ps.setString(5,y6);


ps.executeUpdate();
    JOptionPane.showMessageDialog(p,"data has been updated");
 }
catch(Exception e)
 { System.out.println(e); }
}

         
    

    

  else
   if(s1.equals("Reset"))
    {
           
       t3.setText("");
  t4.setText("");
  t5.setText("");
  t6.setText("");
  t7.setText("");
  t8.setText("");
    }
   else
    if(s1.equals("Close"))  
{
   f.dispose();
 
}
    
    else if (s1.equals("Search"))
    
            {
                
        try
     {
         String data = t2.getSelectedItem();
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from purchaserecord  where Product_Id='"+data+"' ");
       while(rs.next())
       {
      
        String  a3 = rs.getString(2);
        t3.setText(a3);
         String  a4 = rs.getString(1);
        t4.setText(a4);

       String  a5 = rs.getString(4);
        t5.setText(a5);


      String  a6 = rs.getString(5);
        t6.setText(a6);

        String  a7 = rs.getString(6);
        t7.setText(a7);

       

       }
     }
        
     catch(Exception e)   {     }
        
}
    

    else 
   {
    f.dispose();
manager p= new manager();
p.method();
   }




}

public static void main (String args[])
{

mpurchase p= new mpurchase();
p.method();
}
}



