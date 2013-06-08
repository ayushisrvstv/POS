package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ViewTotalSale implements ActionListener
{

    JFrame f;
    Panel p;
    TextField t1, t2;
    Label l1, l2, l3, l4, l5, l6, l7;
    Button b1, b2, b3, b4,b5,b6;
    Font f1, f2, f3, f4, f5;

    ViewTotalSale() {
        f = new JFrame("POS");
        p = new Panel();
        l1 = new Label("Welcome:Manager");
        l2 = new Label("POINT   OF   SALE");
        l3 = new Label("_______________________________________________________________");
        l4 = new Label("Date");

        l5 = new Label("_____________________________________________________________");
        l6 = new Label("Total Sale");
        l7 = new Label("Sale Detail");

        b1 = new Button("View");
        b2 = new Button("Reset");
        b3 = new Button("Back");
        b4 = new Button("Close");
        b5 = new Button("LogOut");
        b6=new Button("Calendar");

        f1 = new Font("Sheriff", Font.BOLD | Font.ITALIC, 45);
        f2 = new Font("Sheriff", Font.BOLD | Font.ITALIC, 30);
        f3 = new Font("Sheriff", Font.BOLD | Font.ITALIC, 35);
        f4 = new Font("Sheriff", Font.BOLD | Font.ITALIC, 20);
        f5 = new Font("Sheriff", Font.BOLD | Font.ITALIC, 15);
        t1 = new TextField();

        t2 = new TextField();
        l1.setFont(f5);
        l2.setFont(f1);
        l3.setFont(f2);
        l7.setFont(f2);
        l5.setFont(f2);

        l4.setFont(f2);
        l6.setFont(f2);

        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        b5.setFont(f5);
        b6.setFont(f2);
    }

    void method() {
        f.setSize(800, 900);
        p.setLayout(null);
        l1.setBounds(610, 10, 180, 25);
        l2.setBounds(150, 10, 400, 70);
        l3.setBounds(1, 70, 800, 30);
        l7.setBounds(280, 150, 400, 40);
        l5.setBounds(200, 160, 300, 40);
        l4.setBounds(100, 300, 150, 30);
        t1.setBounds(350, 300, 150, 30);
        b1.setBounds(250, 400, 150, 35);
        l6.setBounds(100, 500, 150, 30);
        t2.setBounds(350, 500, 150, 30);
        b2.setBounds(100, 600, 150, 35);
        b3.setBounds(300, 600, 150, 35);
        b4.setBounds(500, 600, 150, 35);
        b5.setBounds(610,40,100,30);
        b6.setBounds(540, 300, 150, 30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);


        p.add(l2);
        p.add(l1);
        p.add(l3);
        p.add(l7);
        p.add(l4);
        p.add(t1);
        p.add(l5);
        p.add(l6);
        p.add(t2);
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

public void actionPerformed(ActionEvent ae)
    {
    int  total_sale = 0;
    String s1 = ae.getActionCommand();
    
    if(s1.equals("Calendar"))
	{
		// DatePicker dp=new DatePicker(f);
	 //dp.displayDate(); 
		// f.getContentPane().add(p);
	    
		b6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		            t1.setText(new DatePicker(f).setPickedDate());
		            
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
    
    
    
    if(s1.equals("View"))
    {
    
    try
    {
    String data = t1.getText();
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection  con = DriverManager.getConnection("jdbc:odbc:raman1");
    Statement  stm =con.createStatement();
    ResultSet  rs = stm.executeQuery("select * from bill where  sale_date='"+data+"' ");
    while(rs.next())
    {
       String  s7 = rs.getString(7);
       int  sale = Integer.parseInt(s7);
        total_sale = sale + total_sale;
    }
      String tsale = String.valueOf(total_sale);
      t2.setText(tsale);
    }
    
    
    catch(Exception e) { System.out.println(e);  }
    
    }
    
   
    else
       
     if(s1.equals("Reset"))
    {
    t1.setText("");
    t2.setText("");
    
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
    public static void main(String args[]) {
    	ViewTotalSale ve = new ViewTotalSale();
        ve.method();
    }
}
