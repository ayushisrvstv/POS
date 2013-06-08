/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class manager implements ActionListener ,ItemListener
{
JFrame f;
Panel p;
Label l1,l2,l3,l4,l5,l6,l7,l8;
Choice c1,c2,c3;
Button b1,b2,b3,b4,b5,b6;
Font f1,f2,f3,f4;
manager()
{
f= new JFrame("POS");
p= new Panel();
l1= new Label("POINT  OF  SALE ");
l2= new Label("Welcome: Manager");
l7 = new Label("Please Choose");
l8 = new Label("__________________________________________________________________________");
l3=new Label("______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
l4 = new Label("Salesperson Profile");
 l5 = new Label("Sale"); 
 l6 = new Label("Vendor Profile"); 

b1= new Button("View Inventory");
b2= new Button("Manager Profile");
b3= new Button("Purchase Record");
b4= new Button("Close");
b5= new Button("LogOut");
b6= new Button("Change Password");

c1 = new Choice();
c2 = new Choice();
c3 = new Choice();
f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD,30);
f3= new Font("sherif", Font.BOLD,25);
f4= new Font("sherif", Font.BOLD,15);

l1.setFont(f1);
l2.setFont(f4);
l3.setFont(f2);
l7.setFont(f2);
l8.setFont(f2);

l4.setFont(f3);
l5.setFont(f3);
l6.setFont(f3);
c1.setFont(f4);
c2.setFont(f4);
c3.setFont(f4);
b1.setFont(f3);
b2.setFont(f3);
b3.setFont(f3);
b4.setFont(f3);
b5.setFont(f4);
b6.setFont(f3);
}

void method()
{
f.setSize(800,900);

p.setLayout(null);

l2.setBounds(650,10,150,25);
l1.setBounds(150,10,400,70);
l3.setBounds(1,70,800,45);
l7.setBounds(250,150,400,30);
l8.setBounds(210,172,300,45);
l4.setBounds(70,270,240,30);
l5.setBounds(70,350,200,30);
l6.setBounds(70,420,200,30);
c1.setBounds(450,270,150,20);
c2.setBounds(450,350,150,20);
c3.setBounds(450,420,150,20);
b1.setBounds(20,550,200,30);
b2.setBounds(260,550,240,30);
b3.setBounds(550,550,240,30);
b6.setBounds(20,650,250,30);
b4.setBounds(300,650,150,30);
b5.setBounds(650,40,100,30);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);

c1.add("View");
c1.add("Delete");
c1.add("Create");
c1.add("Update");
//c2.add("View");
c2.add("Total Sale");
c3.add("View");
c3.add("Delete");
c3.add("Create");
c3.add("Update");

p.add(l2);
p.add(l1);
p.add(l3);
p.add(l7);
p.add(l8);
p.add(l4);
p.add(l5);

p.add(l6);

p.add(c1);
p.add(c2);

p.add(c3);

p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);


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
    try
    {
String s1 = ae.getActionCommand();

if (s1.equals("View Inventory"))
{

  minven p = new minven();
        p.method();
        f.dispose();
       
}
else if(s1.equals("Purchase Record"))   
{
    mpurchase p= new mpurchase();
p.method();
f.dispose();
}


    

 else if (s1.equals("Manager Profile"))
{
mmview  e=new mmview();
e.launch();
f.dispose();
}

else if(s1.equals("Close"))
{
f.dispose();
}
else if(s1.equals("Change Password"))
{
   mchange c = new mchange();
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
public void itemStateChanged(ItemEvent ie)
{
    
 if (ie.getSource()==c1)
 {
     Object o = c1.getSelectedItem();
  
 
  if (o.equals("View"))
  {
      mvsale  a=new  mvsale ();
a.launch();
f.dispose();
  }
  else if(o.equals("Delete"))
          {
   mdsale p= new mdsale();
p.method();
f.dispose();
          }
  else if (o.equals("Create"))
  {
      mcsale  e=new   mcsale ();
e.launch();
f.dispose();
}
  else if (o.equals("Update"))
  {
     musale  e=new musale ();
e.launch();
f.dispose();
}
 } 
         
 else  if (ie.getSource()==c2)   
   {
 //Object o1 = c2.getSelectedItem();
 
   /* if (o1.equals("View"))
  {
  
	   ViewSale ve=new ViewSale();
                  ve.method();
 f.dispose();
  }
  

  else   */  
  {
  
 ViewTotalSale ve=new ViewTotalSale();
                  ve.method();
 f.dispose();
  }    
  
}
  
 else if(ie.getSource()==c3) 
 {
 Object o2 = c3.getSelectedItem();
 
 if (o2.equals("View"))
 {
 mvvendor  e=new  mvvendor ();
e.launch();
f.dispose();
 }
 else if (o2.equals("Delete"))
 {
 mdvendor  dv = new mdvendor();
dv.method();
f.dispose();
 }
 else if (o2.equals("Create"))
 {
     mcvendor e=new  mcvendor ();
e.launch();
f.dispose();
 }
 else
 {
     
     muvendor  e=new muvendor ();
e.launch();
f.dispose();
}}}
public static void main (String args[])
{

manager p= new manager();
p.method();
}
}





