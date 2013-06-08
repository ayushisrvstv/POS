/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class salesperson implements ActionListener
{
    JFrame f;
Panel p;

Label l1,l2,l3;
Button b1,b2,b3,b4,b5,b6,b7;

Font f1,f2,f3,f4;
salesperson()
        {
f= new JFrame("POS");
p= new Panel();
l1= new Label("Welcome:Salesperson");
l2= new Label("POINT    OF      SALE");
l3=new 
Label("______________________________________________________________________________________________________________________________________________________");


b1=new Button("View Inventory");
b2=new Button("Generate Bill");
b3=new Button("Close");
b4=new Button("Back");
b5 = new Button("Salesperson Profile");
b6 = new Button("Change Password");
b7=new Button("LogOut");

f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD|Font.ITALIC,20);
f3= new Font("sherif", Font.ITALIC,30);
f4= new Font("sherif", Font.BOLD|Font.ITALIC,15);


l1.setFont(f4);
l2.setFont(f1);
l3.setFont(f2);
b7.setFont(f4);
b1.setFont(f2);
b2.setFont(f2);
b3.setFont(f2);
b4.setFont(f2);
b5.setFont(f2);
b6.setFont(f2);
b7.setFont(f4);
 }
void method()
{
f.setSize(800,800);
p.setLayout(null);

l1.setBounds(600,5,200,20);

l2.setBounds(100,30,500,70);
l3.setBounds(1,120,800,30);

b7.setBounds(600,50,100,30);

b5.setBounds(240,200,250,30);


b1.setBounds(120,350,250,30);
b2.setBounds(420,350,200,30);
b3.setBounds(70,450,150,30);
b6.setBounds(240,550,250,30);

b4.setBounds(550,450,150,30);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
p.add(l2);
p.add(l1);
p.add(l3);
p.add(b7);


p.add(b5);
p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);
p.add(b6);

f.add(p);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public void actionPerformed(ActionEvent ae)
    {
        try
        {
        String s1=ae.getActionCommand();

        if(s1.equals("LogOut"))
    	{
    		f.dispose();
    		start p = new start();
    		        p.method();
    		   
    	}

    else
        
        
if(s1.equals("Close"))
{
f.dispose();
}
            else if(s1.equals("Salesperson Profile"))
{
svprofile a=new  svprofile();
a.launch();
f.dispose();
}
 else if (s1.equals("View Inventory"))
{
 sinven p = new sinven();
        p.method();
        f.dispose();
 }
 else if (s1.equals("Generate Bill"))
{
sgenerate b=new sgenerate ();
b.method();
f.dispose();
 }
  else if (s1.equals("Change Password"))     
  {
      schange c = new schange();
c.password();
f.dispose();
  }
 else
{
    f.dispose();
start p= new start();
p.method();
 }
        }
   
    catch(Exception e)
    {
    }
    }
public static void main (String args[])
{
salesperson s=new salesperson();
s.method();
}
}
