
 
 package pos;
 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class minven implements ActionListener {

    JFrame f;
    Panel p;
    TextField  t2,t3,t4;
    Label l1, l2, l3, l4,l5,l6,l7,l8,l9;
    Font f1, f2, f3, f4, f5,f6;
    Button b2, b3,b1,b4,b5;
    Choice t1;

    minven() {
        f = new JFrame("POS");
        p = new Panel();
        l1 = new Label("Welcome:Manager");
        l2 = new Label("POINT    OF      SALE");
        l3 = new 
Label("______________________________________________________________________________________________________________________________________________________________________________________________");
        l4 = new Label("Inventory Details");
         l5= new Label("Product Name");
       l6= new Label("Product_name");
       l8 = new Label("Product_Id");
       l9 = new Label("Quantity");
               l7= new 
Label("_________________________________________________________________________________________");
        b1 = new Button("Search");
        b2 = new Button("Back");
        b3 = new Button("Close");
        b4 = new Button("Reset");
        b5 = new Button("LogOut"); 
      try
      {   
        t1 = new  Choice();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from product_table");
       while(rs.next())
       {
        String  a2 = rs.getString(2);
        t1.add(a2);
       }
      }
      catch(Exception e) { System.out.println(e); }
        
        
        
        
        
        
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        





        f1 = new Font("sherif", Font.BOLD | Font.ITALIC, 45);
        f2 = new Font("sherif", Font.BOLD | Font.ITALIC,30 );
           f3 = new Font("sherif", Font.BOLD | Font.ITALIC, 35);
        f4 = new Font("sherif", Font.BOLD, 20);
        f5 = new Font("sherif", Font.BOLD|Font.ITALIC, 15);
f6 = new Font("sherif", Font.BOLD|Font.ITALIC, 20);
        



        l1.setFont(f5);
        l2.setFont(f1);
        l3.setFont(f2);

        l4.setFont(f3);

       l7.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);

       

        b1.setFont(f6);  
        b2.setFont(f6);
        b3.setFont(f6);
        b4.setFont(f6);
        b5.setFont(f6);
     
    }

    void method() {

        f.setSize(800, 800);
        p.setLayout(null);
        
        b5.setBounds(650,50,100,30);
        l1.setBounds(650, 15, 150, 30);
        l2.setBounds(150, 40, 450, 70);
        l3.setBounds(10, 100, 1000, 45);
        l4.setBounds(280, 150, 400,40);
        l7.setBounds(200,180,400,40);
        l5.setBounds(100,250, 220, 40);
        t1.setBounds(350,260,250,40);
        b1.setBounds(650,250,150,30);
        l6.setBounds(100,320, 230, 40);
        t2.setBounds(350,320,200,40);
         l8.setBounds(100,380, 200, 40);
          t3.setBounds(350,380,200,40);
          l9.setBounds(100,450, 200, 40);
           t4.setBounds(350,450,200,40);
        b2.setBounds(650,180, 150, 30);
        b3.setBounds(520,530, 150, 50);
        b4.setBounds(100,530,150,50);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

 p.add(l5);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l7);
        p.add(b5);       
        f.add(p);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
public void actionPerformed(ActionEvent ae)
{
    
   
String s1 = ae.getActionCommand();


if(s1.equals("LogOut"))
{
	f.dispose();
	start p = new start();
	        p.method();
	   
}

if(s1.equals("Search"))
{
String a1 = t1.getSelectedItem();
  
 try
     {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from product_table  where Product_Name='"+a1+"' ");
       while(rs.next())
       {
        String y2 = rs.getString(2);
        t2.setText(y2);
        String  y3 = rs.getString(1);
        t3.setText(y3);
         String  y4 = rs.getString(3);
        t4.setText(y4);

       
  
        p.add(l6);
        p.add(t2);
        p.add(l8);
        p.add(t3);
        p.add(l9);
        p.add(t4);   
        p.add(b3);
        p.add(b4);



      


       }
     }
     

     catch(Exception e) { System.out.println(e);  }
 
}
 
   

else  if(s1.equals("Reset"))
{

t2.setText("");
t3.setText("");
t4.setText("");

}
else
if(s1.equals("Close"))
{
f.dispose();
}
else
{
f.dispose();
manager p = new manager();
        p.method();
   
}
    }
    


    public static void main(String args[]) {
       minven p = new minven();
        p.method();
    }
}

