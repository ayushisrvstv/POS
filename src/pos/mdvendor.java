/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class mdvendor implements ActionListener {

    JFrame f;
    Panel p;
    Choice t1;
    Label l1, l2, l3, l4, l5, l6;
    Button b1, b2, b3, b4,b5;
    Font f1, f2, f3, f4, f5;

    mdvendor() {
        f = new JFrame("POS");
        p = new Panel();
        l1 = new Label("Welcome:Admin");
        l2 = new Label("POINT   OF   SALE");
        l3 = new Label("_____________________________________________________________________________________________________________________________________________________________________________________________________");
        l4 = new Label("Delete Vendor Form");
        l5 = new Label("______________________________________________________________________________________");
        l6 = new Label("Choose Contact_Person_Id");
        t1 = new Choice();

        b1 = new Button("Delete");
        b2 = new Button("Reset");
        b3 = new Button("Close");
        b4 = new Button("Back");
        b5=new Button("LogOut");



        f1 = new Font("sherif", Font.BOLD | Font.ITALIC, 45);
        f2 = new Font("sherif", Font.BOLD | Font.ITALIC, 30);
        f3 = new Font("sherif", Font.BOLD, 35);
        f4 = new Font("sherif", Font.BOLD, 20);
        f5 = new Font("sherif", Font.BOLD | Font.ITALIC, 15);

        l1.setFont(f5);
        l2.setFont(f1);
        l3.setFont(f2);
        l4.setFont(f3);
        l5.setFont(f2);
        l6.setFont(f2);
        b1.setFont(f4);
        b2.setFont(f4);
        b3.setFont(f4);
        b4.setFont(f4);
        b5.setFont(f5);
        try {
            //String data = t1.getSelectedItem();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:raman1");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from cvendor");
            while (rs.next()) {
                String first = rs.getString(1);
                t1.add(first);
            }
        } catch (Exception e) {
            System.out.println(e);
        }





    }

    void method() {

        f.setSize(800, 800);
        p.setLayout(null);

        l1.setBounds(600, 10, 150, 36);
        l2.setBounds(100, 30, 400, 70);
        l3.setBounds(2, 90, 1200, 30);
        l4.setBounds(200, 180, 350, 30);
        l5.setBounds(200, 215, 350, 30);
        l6.setBounds(100, 360, 400, 30);
        t1.setBounds(510, 360, 150, 30);
        b1.setBounds(300, 480, 150, 40);
        b2.setBounds(100, 600, 150, 40);
        b3.setBounds(300, 600, 150, 40);
        b4.setBounds(500, 600, 150, 40);
        b5.setBounds(600,50,100,30);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);


        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(t1);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        f.add(p);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        try {

            String s1 = ae.getActionCommand();

            if(s1.equals("LogOut")){
            	f.dispose();
            	start p = new start();
            	        p.method();
            	   
            }
            else     
            
            
            if (s1.equals("Delete")) {

                try {
                    String data = t1.getSelectedItem();
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:odbc:raman1");



                    PreparedStatement ps = con.prepareStatement("delete from cvendor  where  Contact_Person_Id='" + data + "'  ");

                    ps.executeUpdate();


                    JOptionPane.showMessageDialog(p, "data has been deleted");
                    f.dispose();
                    mdvendor p = new mdvendor();
                    p.method();
                    

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (s1.equals("Close")) {
                f.dispose();
            } else {
                f.dispose();
                project p = new project();
                p.method();
            }
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {
        mdvendor p = new mdvendor();
        p.method();
    }
}
