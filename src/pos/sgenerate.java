/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class sgenerate  implements ActionListener, ItemListener
{
JFrame f;
Panel p;
TextField t1,t2,t4,t5,t6,t7;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
Button b1,b2,b3,b4,b5,b6,b7;
Choice c;
Font f1,f2,f4,f5;
  int  aquantity=0;
   int  equantity=0;
     int  uquantity=0;
    int  total_amount =0 ;
sgenerate()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("Welcome:Salesperson");
l2= new Label("POINT    OF      SALE");
l3=new 
Label("______________________________________________________________________________________________________________________________________________________");
l4=new Label("Bill_Id");
l5=new Label("Bill_No");
l6=new Label("Product_Name");
c=new Choice();

l7=new Label("Date");
l8=new Label("Quantity");
l9=new Label("Amount");
l10=new Label("Total_Amount");
b1=new Button("Reset");
b2=new Button("Back");
b3=new Button("Close");
b4=new Button("Save");
b5=new Button("Total");
b6=new Button("LogOut");
b7=new Button("Calendar");

f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD|Font.ITALIC,30);
f4= new Font("sherif", Font.ITALIC,30);
f5= new Font("sherif", Font.BOLD|Font.ITALIC,15);
t1 = new TextField();
t2 = new TextField();

t4 = new TextField();
t5 = new TextField();
t6 = new TextField();
t7= new TextField();
l1.setFont(f5);
l2.setFont(f1);
l3.setFont(f5);
l4.setFont(f4);
l5.setFont(f4);
l6.setFont(f4);
l7.setFont(f4);
l8.setFont(f4);
l9.setFont(f4);
b1.setFont(f5);
b2.setFont(f5);
b3.setFont(f5);
b4.setFont(f5);
b6.setFont(f5);
b7.setFont(f5);
c.setFont(f5);

 c.addItemListener(this);


try
      {   
      
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from  product_table");
       while(rs.next())
       {
        String  s = rs.getString(2);
        c.add(s);
        
       }
               rs.close();
               
               
      }

      catch(Exception e) { System.out.println(e); }

try
      {   
      
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  cont = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stmt =cont.createStatement();
       ResultSet  rst = stmt.executeQuery("select * from  update_bill");
       while(rst.next())
       {
        String  s = rst.getString(1);
         String  s1 = rst.getString(2);
     t1.setText(s1);
        t2.setText(s);
         int m =Integer.parseInt(s);
         int n =Integer.parseInt(s1);
         int j = m+1;
         int k = n+1;
     PreparedStatement  ps = cont.prepareStatement("update update_bill set billnumber='"+j+"',billid='"+k+"'  where   bill_id='"+n+"'  ")  ; 
             ps.executeUpdate();
       }
        
         
               
               
      }

      catch(Exception e) { System.out.println(e); }






        
 }
void method()
{
f.setSize(800,800);
p.setLayout(null);




l1.setBounds(600,5,200,20);

l2.setBounds(100,30,500,70);


b6.setBounds(610,40,100,30);
l3.setBounds(1,110,800,20);
l4.setBounds(80,150,150,30);
t1.setBounds(300,150,150,30);
l5.setBounds(80,220,150,35);
t2.setBounds(300,220,150,30);
l8.setBounds(70,300,150,30);
t5.setBounds(300,300,150,30);



l7.setBounds(70,370,150,30);
t4.setBounds(300,370,150,30);
l6.setBounds(70,460,220,30);
c.setBounds(300,460,250,30);
l9.setBounds(70,540,150,30);
t6.setBounds(300,540,150,30);
l10.setBounds(70,590,150,30);
t7.setBounds(300,590,150,30);
b5.setBounds(500,590,80,20);

b1.setBounds(500,220,150,30);
b2.setBounds(500,300,150,30);
b3.setBounds(80,650,150,30);
b4.setBounds(300,650,150,30);
b7.setBounds(500, 370, 150, 30);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b7.addActionListener(this);
p.add(l2);
p.add(l1);
p.add(l3);
p.add(l4);
p.add(t1);
p.add(l5);
p.add(t2);
p.add(l6);
p.add(b6);
p.add(c);


p.add(l7);
p.add(t4);
p.add(l8);
p.add(t5);
p.add(l9);
p.add(t6);
p.add(l10);
p.add(t7);
p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);
p.add(b5);
p.add(b7);
f.add(p);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}
@Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==c)
       {
    String  s = c.getSelectedItem();
    try
      {   
      
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from  product_table  where  Product_Name='"+s+"' ");
       while(rs.next())
       {
       String  s4 = rs.getString(4);
       String available_quantity = rs.getString(3);
      aquantity = Integer.parseInt(available_quantity);
       String  entered_quantity = t5.getText();
       t6.setText(s4);
         equantity = Integer.parseInt(entered_quantity);
      uquantity = aquantity - equantity ;
      System.out.println(uquantity);

        
       }
               rs.close();
                PreparedStatement  ps = con.prepareStatement("update  product_table set Quantity='"+uquantity+"'  where  Product_Name='"+s+"' ") ;
ps.executeUpdate();
      }
           
        catch(Exception e1) {   }
       }
}


public void actionPerformed(ActionEvent ae)
{
   try
   {
String s1 = ae.getActionCommand();

if(s1.equals("Calendar"))
{
	
	b7.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent ae) {
	            t4.setText(new DatePicker(f).setPickedDate());
	            
	    }
	});
         
}
else

if(s1.equals("LogOut"))
{
	f.dispose();
	start p = new start();
	        p.method();
	   
}


else
if(s1.equals("Save"))
{
String a1 = t1.getText();
String a2 = t2.getText();
String pname = c.getSelectedItem();
String a4 = t4.getText();
String a5 = t5.getText();
String a6 = t6.getText();




   if ((a1.equals("")) || (a2.equals("")) ||  (a4.equals("")) || (a5.equals(""))||(a6.equals("")) )
{
JOptionPane.showMessageDialog(p,"incomplete data");

}
else

{
try
      {   
      
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
     PreparedStatement  ps = con.prepareStatement("insert into bill values(?,?,?,?,?,?,?)");
    ps.setString(1,a1);
     ps.setString(2,a2);
         ps.setString(3,pname); 
        ps.setString(4,a4);  
           ps.setString(5,a5);   
            ps.setString(6,a6); 
              ps.setInt(7,total_amount); 
            ps.executeUpdate();
            JOptionPane.showMessageDialog(p,"data saved");
    }
      catch(Exception e)   {   }
   }
}
   else
     if(s1.equals("Reset"))
{
t1.setText("");
t2.setText("");

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
if(s1.equals("Total"))
{
    System.out.println("select here please");
String  a = t5.getText();
String  b = t6.getText();
int ab = Integer.parseInt(a);
int cd = Integer.parseInt(b);
total_amount = ab * cd;
String tamount = String.valueOf(total_amount);
t7.setText(tamount);
}
        
     
else
{
f.dispose();
salesperson s=new salesperson();
s.method();
}
    }
   catch(Exception  e) {   }
   } 

   
 
public static void main (String args[])
{
sgenerate b=new sgenerate ();
b.method();
}}