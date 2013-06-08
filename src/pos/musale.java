package pos;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class musale  implements ActionListener,ItemListener
{
JFrame f;
Panel p;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
TextField t11,t2,t3,t4,t5,t6,t7,t8,t9,t10;
Button b1,b2,b3,b4,b5,b6;
Font f1,f2,f3,f4,f5,f6;
Checkbox c1,c2;
CheckboxGroup cbg;
Choice  t1;
String g = "";
musale ()
{
f=new JFrame("POS");
p=new Panel();
l1=new Label("Welcome:Manager");
l2=new Label("POINT   OF   SALE");
l14=new Label("Enter Salesperson_Id");

l3 = new Label("Name");
l4=  new Label("Father's_Name");
l5=new Label("Salesperson_Id");
l6=new Label("Password");
l7=new Label("Gender");
l9=new Label("Address");
l8=new Label("D.O.B.");
l10=new Label("Contact_No.");
l11=new Label("E-Mail_Id");
l12=new Label("Location");
l13= new 
Label("_______________________________________________________________________________________________");

l15= new 
Label("_______________________________________________________________________________________________________________________");
cbg = new CheckboxGroup();
c1= new Checkbox("Male",cbg,false);
c2= new Checkbox("Female",cbg,false);


t11=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();
t7=new TextField();
t8=new TextField();
t9=new TextField();
t10=new TextField();




try
      {   
        t1 = new  Choice();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from sprofile");
       while(rs.next())
       {
        String  a2 = rs.getString(3);
        t1.add(a2);
       }
      }
      catch(Exception e) { System.out.println(e); }
        

b1=new Button("Search");
b2=new Button("Update");
b3=new Button("Calendar");
b4=new Button("Close");
b5=new Button("Back");
b6=new Button("Logout");


 f1 = new Font("sherif", Font.BOLD | Font.ITALIC, 45);
        f2 = new Font("sherif", Font.BOLD | Font.ITALIC,30 );
           f3 = new Font("sherif", Font.BOLD | Font.ITALIC, 35);
        f4 = new Font("sherif", Font.BOLD, 20);
        f5 = new Font("sherif", Font.BOLD|Font.ITALIC, 15);
f6 = new Font("sherif", Font.BOLD|Font.ITALIC, 20);
         l1.setFont(f5);
        l2.setFont(f1);
        l3.setFont(f6);
        l4.setFont(f6);
        l5.setFont(f6);
        l6.setFont(f6);
        l7.setFont(f6);
        l8.setFont(f6);
        l9.setFont(f6);
        l10.setFont(f6);
        l11.setFont(f6);
        l12.setFont(f6);
        l13.setFont(f6);
        l14.setFont(f6);

        b1.setFont(f6);
        b2.setFont(f6);
        b3.setFont(f6);
        b4.setFont(f6);
        b5.setFont(f6);
        b6.setFont(f6);

}

void launch()
{
f.setSize(800,800);
p.setLayout(null);

l1.setBounds(600,10,150,36);

l2.setBounds(100,30,400,70);
l13.setBounds(2,90,1200,20);

l14.setBounds(80,150,250,30);
t1.setBounds(330,150,150,30);
b1.setBounds(500,150,100,30);
l15.setBounds(2,200,1200,20);

b6.setBounds(600,50,100,30);
l3.setBounds(100,250,100,30);
t2.setBounds(300,250,150,30);
l4.setBounds(100,300,150,30);
t3.setBounds(300,300,150,30);
l5.setBounds(100,350,150,30);
t4.setBounds(300,350,150,30);
l6.setBounds(100,400,100,30);
t5.setBounds(300,400,150,30);
l7.setBounds(100,450,100,30);
c1.setBounds(300,450,60,30);
c2.setBounds(400,450,60,30);
l8.setBounds(100,500,100,30);
t6.setBounds(300,500,150,30);
l9.setBounds(100,550,100,30);
t7.setBounds(300,550,150,30);
l10.setBounds(100,600,120,30);
t8.setBounds(300,600,150,30);

l11.setBounds(100,650,100,30);
t9.setBounds(300,650,150,30);
l12.setBounds(100,700,150,30);
t10.setBounds(300,700,150,30);
b2.setBounds(500,400,100,30);
b3.setBounds(500,500,100,30);
b4.setBounds(500,600,100,30);
b5.setBounds(650,150,100,30);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);

p.add(l1);
p.add(l2);
p.add(l13);
p.add(l14);
p.add(t1);
p.add(b1);
p.add(l15);
p.add(b5);
p.add(b6);




f.add(p);

f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void itemStateChanged(ItemEvent ie)
{
    
    if (ie.getSource()==c1)
    {String s = c1.getLabel();
    g=s;
    }
    else
    { 
    String s = c2.getLabel();
    g=s; 
    }
}
public void actionPerformed(ActionEvent ae)
{


String s1 = ae.getActionCommand();
	   
	if(s1.equals("Calendar"))
	{
		// DatePicker dp=new DatePicker(f);
	 //dp.displayDate(); 
		// f.getContentPane().add(p);
	    
		b3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		            t6.setText(new DatePicker(f).setPickedDate());
		            
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

   if(s1.equals("Search"))

{


        try
     {
         String data = t1.getSelectedItem();
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
       Statement  stm =con.createStatement();
       ResultSet  rs = stm.executeQuery("select * from sprofile  where Salesperson_Id='"+data+"' ");
       while(rs.next())
       {
        String  a2 = rs.getString(1);
        t2.setText(a2);
        String  a3 = rs.getString(2);
        t3.setText(a3);
         String  a4 = rs.getString(3);
        t4.setText(a4);

       String  a5 = rs.getString(4);
        t5.setText(a5);


      String  a6 = rs.getString(6);
        t6.setText(a6);

        String  a7 = rs.getString(7);
        t7.setText(a7);

         String  a8= rs.getString(8);
        t8.setText(a8);

        String  a9= rs.getString(9);
        t9.setText(a9);

        String  a10= rs.getString(10);
        t10.setText(a10);
        
        p.add(l3);
        p.add(t2);        
        p.add(l4);
        p.add(t3);
        p.add(l5);
        p.add(t4);
        p.add(l6);
        p.add(t5);
        p.add(l7);
        p.add(c1);
        p.add(c2);
        p.add(l8);
        p.add(t6);
        p.add(l9);
        p.add(t7);
        p.add(l10);
        p.add(t8);
        p.add(l11);
        p.add(t9);
        p.add(l12);
        p.add(t10);
        p.add(b2);
        p.add(b3);
        p.add(b4);



       }
     }
        
     catch(Exception e)   {     }
        
}
    

 else if(s1.equals("Update"))
{


String y2= t2.getText();
String y3= t3.getText();
String update_id = t4.getText();
String y4= t5.getText();
String y6= t6.getText();
 String y7= t7.getText();
  String y8= t8.getText();
 String y9= t9.getText();
String y10= t10.getText();
 try
 {
String y = t1.getSelectedItem();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");

 PreparedStatement  ps = con.prepareStatement("update sprofile  set Location=? , E_Mail_Id=? ,Contact_No =?, Address=?, D_O_B=?,Gender=?, Password=?, Salesperson_Id=?,salesman_father=?,salesman_name=? where  Salesperson_Id='"+y+"'  ");
  
ps.setString(1,y10);
ps.setString(2,y9);
ps.setString(3,y8);
ps.setString(4,y7);
ps.setString(5,y6);
ps.setString(6,g);
ps.setString(7,y4);
ps.setString(8,update_id);
ps.setString(9,y3);
ps.setString(10,y2);


ps.executeUpdate();
       JOptionPane.showMessageDialog(p,"data has been updated");
       f.dispose();
       manager p=new manager();
       p.method();
       
       
 }
catch(Exception e)
 { System.out.println(e); }
}



   


else if(s1.equals("Reset"))
{

t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");
}
else
if(s1.equals("Close"))
{
f.dispose();
}
else
{
f.dispose();
manager	 p = new manager();
        p.method();
}
    }
   


public static void main(String args[]){
musale e=new  musale ();
e.launch();
}}



    

