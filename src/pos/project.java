/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

class project implements ActionListener, ItemListener  {

    JFrame f;
    Panel p;
    TextField t1, t2;
    Label l1, l2, l3, l4,l5,l6,l7,l8;
    Font f1, f2, f3, f4, f5,f6;
    Button b5,b1,b2,b3;
    Choice c1, c2, c3;

    project() {
        f = new JFrame("POS");
        p = new Panel();
        l1 = new Label("Welcome:Admin");
        l2 = new Label("POINT    OF      SALE");
        l3 = new 
Label("_______________________________________________________________________________________________________________________");
        l4 = new Label("Please Choose Profile:");
         l5= new Label("Administrator");
       l6= new Label("Manager");
        l7= new Label("Salesperson");
        l8 = new 
Label("_________________________________________________________________________________________");
        c1= new Choice();
         c2= new Choice();
          c3= new Choice();
        b3 = new Button("LogOut");
        b5 = new Button("Close");
        b1 = new Button("View Inventory");
        b2 = new Button("Change Password");
        
        b3.addActionListener(this);
b5.addActionListener(this);

b1.addActionListener(this);
b2.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
        
        
        
        f1 = new Font("sherif", Font.BOLD | Font.ITALIC, 45);
        f2 = new Font("sherif", Font.BOLD | Font.ITALIC,30 );
           f3 = new Font("sherif", Font.BOLD | Font.ITALIC, 35);
        f4 = new Font("sherif", Font.BOLD, 20);
        f5 = new Font("sherif", Font.BOLD|Font.ITALIC, 15);
f6 = new Font("sherif", Font.BOLD|Font.ITALIC, 20);
        c1.add("View Profile");
       c1.add("Update Profile");
        
        c2.add("View Profile");
        c2.add("Create Profile");
        c2.add("Delete Profile");
        c2.add("Update Profile");
        
        c3.add("View Profile");
        c3.add("Create profile");
        c3.add("Delete Profile");
        c3.add("Update Profile");
        
        
        
        l1.setFont(f5);
        l2.setFont(f1);
        l4.setFont(f3);
        c1.setFont(f5);
        c2.setFont(f5);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        
              

        c3.setFont(f5);
        b3.setFont(f5);
        b5.setFont(f6);
        b1.setFont(f6);
        b2.setFont(f6);
    }

    void method() {

        f.setSize(800, 800);
        p.setLayout(null);

        l1.setBounds(650, 15, 170, 30);
        l2.setBounds(150, 40, 450, 70);
        l3.setBounds(10, 100, 1000, 45);
        l4.setBounds(200, 200, 400,40);
        l8.setBounds(200, 235, 400, 45);
        
        l5.setBounds(100,300, 200, 40);
        l6.setBounds(100, 400, 200, 40);
        l7.setBounds(100, 500, 200, 40);
        
        c1.setBounds(400, 300, 150, 40);
        c2.setBounds(400, 400, 150, 40);
        c3.setBounds(400, 500, 150, 40);
        
        b2.setBounds(370,600,200,50);
        b1.setBounds(100,600,200,50);
        b3.setBounds(650,45,100,30);
        b5.setBounds(600, 600, 150, 50);

        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l8);
        p.add(l5);
        p.add(c1);
        p.add(l6);
        p.add(c2);
        p.add(l7);
        p.add(c3);
        p.add(b1);
        p.add(b3);
        p.add(b5);
        p.add(b2);


        f.add(p);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
public void actionPerformed(ActionEvent ae)
{
    try
    {
String s1 = ae.getActionCommand();
if(s1.equals("LogOut")){
	f.dispose();
	start p = new start();
	        p.method();
	   
}
else if(s1.equals("View Inventory"))
{
 aiven p = new aiven();
        p.method();
    f.dispose();
 }


     else if (s1.equals("Change Password"))
     {
         change c = new change();
c.password();
f.dispose();
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
    
public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==c1)
{
   Object o= c1.getSelectedItem();

if( o.equals("View Profile"))
{
admin  a=new  admin ();
a.launch();
f.dispose();
}
else if
( o.equals("Update Profile"))
{
Aupdate  e=new  Aupdate ();
e.launch();
f.dispose();
}
}
        
        
        
else  if(ie.getSource()==c2)
 {
     Object o2= c2.getSelectedItem();
 
 if( o2.equals("Create Profile"))

{
    mcreate  e=new  mcreate ();
e.launch();
f.dispose();
}
         
         
else if( o2.equals("View Profile"))
{
    mview e=new mview();
e.launch();
    f.dispose();
}
else if( o2.equals("Update Profile"))
{
   mupdate e=new  mupdate ();
e.launch();
f.dispose();
}
else 
{
    
mdelete p= new mdelete();
p.method();
f.dispose();
}
  
 }
else if(ie.getSource()==c3)
{
    Object o3= c3.getSelectedItem();
    if(o3.equals("View Profile"))
    {
        sview a=new  sview ();
a.launch();
f.dispose();
}
    else if(o3.equals("Create profile"))
    {
       screate  e=new  screate ();
e.launch();
f.dispose();
    }
    else if(o3.equals("Update Profile"))
    {
    supdate  e=new  supdate();
e.launch();
f.dispose();
}
   
           
            
    else
    {
      sdelete p= new sdelete();
p.method();  
f.dispose();
    }
    }
    
    
    }

    public static void main(String args[]) {
        project p = new project();
        p.method();
    }
}

 