package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class project implements ActionListener , ItemListener
{
Frame f;
Label l1;
Choice c1;
Button b1;

project()
{

f=new Frame("WELCOME USER");

l1=new Label("SELECT AN OPERATION YOU WANT TO PERFORM?");

c1=new Choice();
c1.add("CREATE A NEW TABLE");
c1.add("INSERT RECORDS INTO AN EXISTING TABLE");
c1.add("ADD OR UPDATE OR DELETE A FEILD");
c1.add("UPDATE OR DELETE A RECORD");
c1.add("FETCH RECORD");
c1.add("SHOW EXISTING TABLES");

b1=new Button("CONFIRM");

f.setLayout(null);

l1.setBounds(20,80,320,20);
c1.setBounds(20,120,300,20);
b1.setBounds(140,160,80,20);

f.add(l1);
f.add(c1);
f.add(b1);

f.setSize(360,320);

f.setVisible(true);

b1.addActionListener(this);

c1.addItemListener(this);

}

public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b1)
{
if(c1.getSelectedIndex()==0)
{
Project1 p1=new Project1();
}

else if(c1.getSelectedIndex()==1)
{
Project2 p2=new Project2();
}

else if(c1.getSelectedIndex()==2)
{
Project3 p3=new Project3();
}

else if(c1.getSelectedIndex()==3)
{
Project4 p4=new Project4();
}

else if(c1.getSelectedIndex()==4)
{
Project5 p5=new Project5();
}

else if(c1.getSelectedIndex()==5)
{
Project6 p6=new Project6();
}
}

}

public void itemStateChanged(ItemEvent e)
{
if(e.getSource()==c1)
{

}

}

public static void main(String ar[])
{
project p=new project();
}
}
