package my_db_server;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
class Project6 implements ActionListener
{
Frame f6;
TextArea ta;
Button b1,b2;
Label l1;
Connection co;
ResultSet rs;
Statement st;

Project6()
{
f6=new Frame("EXISTING TABELS");
ta=new TextArea();
b1=new Button("SHOW");
b2=new Button("BACK");
l1=new Label("YOU CAN SEE ALL THE TABELS HERE");
f6.setLayout(null);
ta.setBounds(20,80,220,150); 
l1.setBounds(20,50,220,20);
b1.setBounds(30,240,50,30);
b2.setBounds(120,240,50,30);
f6.setSize(280,300);
f6.setVisible(true);
f6.add(ta);
f6.add(b1);
f6.add(b2);
f6.add(l1);
b1.addActionListener(this);
b2.addActionListener(this);
try
{
Class.forName("com.mysql.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3206/project","root","archit27nov@gmail.com");
}
catch(Exception ee)
{
System.out.println(ee);
}
}


public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b1)
{
try
{

st=co.createStatement();

rs=st.executeQuery("show tables");

String s=" ";

while(rs.next())
{

s=s+rs.getString(1)+"\n";

}
ta.setText(s);
}

catch(Exception eee)
{
System.out.println(eee);
}
}


else if(e.getSource()==b2)
{
f6.setVisible(false);
}
}
}