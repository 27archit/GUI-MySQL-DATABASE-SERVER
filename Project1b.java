package my_db_server;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project1b implements ActionListener
{
static Frame f8;
Button b6,b7;
Label l7,l8,l9;
TextField t4,t5;
Choice c3;

Project1b()
{

f8=new Frame("ADDING MORE FEILDS TO TABLE");

l7=new Label("FEILD NAME");
l8=new Label("SELECT DATATYPE");
l9=new Label("VARIABLE LENGTH OF DATATYPE");

t4=new TextField();
t5=new TextField();

b6=new Button("ADD");
b7=new Button("CANCEL");

c3=new Choice();
c3.add("VARCHAR");
c3.add("CHAR");
c3.add("INT");
c3.add("TIMESTAMP");
c3.add("DATETIME");
c3.add("BLOB");
c3.add("CLOB");
c3.add("LONGBLOB");
c3.add("TINYTEXT");
c3.add("TINYINT");

f8.setLayout(null);

l7.setBounds(20,40,200,20);
l8.setBounds(20,80,200,20);
l9.setBounds(20,120,200,20);

b6.setBounds(140,160,60,20);
b7.setBounds(220,160,60,20);

t4.setBounds(240,40,150,20);
t5.setBounds(240,120,150,20);

c3.setBounds(240,80,150,20);

f8.add(l7);
f8.add(l8);
f8.add(l9);
f8.add(b6);
f8.add(b7);
f8.add(t5);
f8.add(t4);
f8.add(c3);

f8.setSize(420,200);

f8.setVisible(true);

b6.addActionListener(this);
b7.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b6)
{
Project1a a=new Project1a();
f8.setVisible(false);
}

else if(e.getSource()==b7)
{
Project1.f1.setVisible(false);
Project1a.f7.setVisible(false);
f8.setVisible(false);
}

}

}