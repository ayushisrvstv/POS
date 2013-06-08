/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class welcomepage  implements ActionListener
{

JFrame f;
Panel p;
Label l1,l2,l3;
Button b1;
Font f1,f2,f3,f4,f5;

welcomepage()
{
f= new JFrame("POS ");
p= new Panel();

l1= new Label("POINT   OF   SALE");
l2= new 
Label("_______________________________________________________________________________________________________________________________________________________________________________________________");
l3= new Label("For  Entering  Click Below  :");

b1=new Button("Enter");

f1= new Font("sherif", Font.BOLD|Font.ITALIC,45);
f2= new Font("sherif", Font.BOLD|Font.ITALIC,30);
f3= new Font("sherif", Font.BOLD,25);
f4= new Font("sherif", Font.BOLD,20);
f5= new Font("sherif", Font.BOLD|Font.ITALIC,15);

l1.setFont(f1);
l2.setFont(f4);
l3.setFont(f2);

b1.setFont(f4);
 
}

void method()
{

f.setSize(800,800);
p.setLayout(null);

l1.setBounds(100,30,400,70);
l2.setBounds(2,90,1200,20);
l3.setBounds(100,250,650,30);
b1.setBounds(230,370,150,40);

p.add(l1);
p.add(l2);
p.add(l3);
p.add(b1);
f.add(p);
b1.addActionListener(this);
f.setVisible(true);
f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

}
public void actionPerformed(ActionEvent ae)
{
    String s= ae.getActionCommand();
    if(s.equals("Enter"))
    {f.dispose();
  start p= new start();
p.method();  
    
}
}


public static void main (String args[])
{
welcomepage p= new welcomepage();
p.method();
}
}

