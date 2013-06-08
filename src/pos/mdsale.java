package pos;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class mdsale  implements ActionListener
{

JFrame f;
Panel p;
//TextField t1;
Label l1,l2,l3,l4;
Button b1,b2,b4,b5;
Font f1,f2,f3,f4,f5;
Choice t11;

mdsale()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("Welcome:Admin");
l2= new Label("POINT   OF   SALE");
l3= new
Label("_____________________________________________________________________________________________________________________________________________________________________________________________________");

l4= new Label("Select Salesperson_Id");
//t1 = new TextField();

b1=new Button("Delete");
b2= new Button("Close");
b4= new Button("Back");
b5=new Button("LogOut");

//t1 = new TextField();


try
{   
  t11 = new Choice();
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
 Statement  stm =con.createStatement();
 ResultSet  rs = stm.executeQuery("select * from sprofile");
 while(rs.next())
 {
  String  a2 = rs.getString(3);
  t11.add(a2);
 }
}
catch(Exception e) { System.out.println(e); }
  



f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD|Font.ITALIC,30);
f3= new Font("sherif", Font.BOLD,25);
f4= new Font("sherif", Font.BOLD,20);
f5= new Font("sherif", Font.BOLD|Font.ITALIC,15);

l1.setFont(f5);
l2.setFont(f1);
l3.setFont(f5);
l4.setFont(f2);
b1.setFont(f4);
b2.setFont(f4);
b4.setFont(f4);
b5.setFont(f4);
}


void method()
{

f.setSize(800,800);
p.setLayout(null);

l1.setBounds(600,10,150,36);
l2.setBounds(100,30,400,70);
l3.setBounds(2,90,1200,20);
l4.setBounds(150,250,350,30);
t11.setBounds(550,250,200,30);
b1.setBounds(300,380,150,40);
b2.setBounds(100,380,150,40);
b4.setBounds(500,380,150,40);
b5.setBounds(600,50,100,30);

b1.addActionListener(this);
b2.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

p.add(t11);
p.add(l1);
p.add(l2);
p.add(l3);
p.add(l4);
p.add(b5);
p.add(b1);
p.add(b2);
p.add(b4);
f.add(p);

f.setVisible(true);
f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

}
    @Override
public void actionPerformed(ActionEvent ae)
{

String s1 = ae.getActionCommand();
String a1 = t11.getSelectedItem();
if(s1.equals("Delete"))
{
if (a1.equals(""))

         {
   JOptionPane.showMessageDialog(p,"invalid entry");
         }

    else




   try
     {
         int i=0;
         String data = t11.getSelectedItem();
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
        Statement  stm = con.createStatement();
        ResultSet  rs = stm.executeQuery("select * from sprofile");
        while(rs.next())
        {
           if(data.equals(rs.getString(3))) 
           {
               i = i+1;
                  PreparedStatement ps=con. prepareStatement("delete from sprofile   where  Salesperson_Id='"+data+"'  ");          
                     ps.executeUpdate();
                JOptionPane.showMessageDialog(p,"your  data has been deleted");
                f.dispose();
                 manager pj=new manager();
                 pj.method();
           }
        }
        if(i==0)
        {
            JOptionPane.showMessageDialog(p,"id is invalid or not available ");
        }            
}

catch(Exception e )
        {
    System.out.println(e);
    }
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
manager p = new manager();
        p.method();
}




    }
    
  
public static void main (String args[])
{
mdsale p= new mdsale();
p.method();
}



}



