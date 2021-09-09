package my_db_server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.*;

class Database implements ActionListener
{

JFrame f;
JButton b1,b2,b3;
JTextField t1;
JLabel l1,l2;
JComboBox c1;
Connection co;
ResultSet rs;
PreparedStatement st;
static String s="";

Database()
{

f=new JFrame("CHOOSE DATABASE");
Container c=f.getContentPane();
b1=new JButton("CREATE");
b2=new JButton("CONFIRM");
b3=new JButton("CANCEL");
t1=new JTextField();
l1=new JLabel("CREATE A DATABASE");
l2=new JLabel("SELECT A DATABASE");

try{
Class.forName("com.mysql.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3206/project","root","archit27nov@gmail.com");
}catch(Exception e)
{
System.out.print(e);
}

try{

st=co.prepareStatement("Show Databases;");
rs=st.executeQuery();
Vector ar=new Vector();
int n=1;

while(rs.next())
{

ar.add(rs.getString(1));

}

final DefaultComboBoxModel aa=new DefaultComboBoxModel(ar);
c1=new JComboBox(aa);

}catch(Exception e)
{
System.out.print(e);
}

c.setLayout(null);
c.add(b1);
c.add(b2);
c.add(b3);
c.add(l1);
c.add(l2);
c.add(t1);
c.add(c1);

c.setBackground(Color.black);
l1.setForeground(Color.blue);
l2.setForeground(Color.blue);
t1.setBackground(Color.yellow);
c1.setBackground(Color.red);
b1.setBackground(Color.orange);
b2.setBackground(Color.green);
b3.setBackground(Color.white);

l1.setBounds(240,130,140,20);
l2.setBounds(440,130,140,20);
t1.setBounds(230,170,140,20);
b1.setBounds(255,210,90,20);
b2.setBounds(455,210,90,20);
b3.setBounds(355,250,90,20);
c1.setBounds(430,170,140,20);

f.setSize(800,400);
f.setVisible(true);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
s=t1.getText();

try
{
st=co.prepareStatement("create database "+s);
st.executeUpdate();
st.close();
}catch(Exception ee)
{
System.out.print(ee);
}

project pp=new project();
System.out.println(s);
}

else if(e.getSource()==b2)
{
s=c1.getSelectedItem().toString();
project pp=new project();
System.out.println(s);
}

else if(e.getSource()==b3)
{
System.exit(0);
}

}

/*
public static void connectionn()
{

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3206/"+s,"root","archit27nov@gmail.com");
System.out.print("\n"+s+"\n");
}catch(Exception e)
{
System.out.print("conn"+e);
}

}
*/

public static void main(String ar[])
{
Database f=new Database();
}
}