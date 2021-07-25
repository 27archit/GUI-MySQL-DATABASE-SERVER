package my_db_server;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project1a implements ActionListener
{
static Frame f7;
Button b4,b5;
Label l6;

Project1a()
{
f7=new Frame("WANT TO ADD MORE FEILDS?");

l6=new Label("DO YOU WANT TO ADD MORE FEILDS?");
b4=new Button("YES");
b5=new Button("NO");

f7.setLayout(null);

l6.setBounds(30,80,210,20);
b4.setBounds(80,140,60,20);
b5.setBounds(160,140,60,20);

f7.add(l6);
f7.add(b4);
f7.add(b5);

f7.setSize(300,180);

f7.setVisible(true);

b4.addActionListener(this);
b5.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b4)
{
Project1b b=new Project1b();
f7.setVisible(false);
}

else if(e.getSource()==b5)
{
f7.setVisible(false);
Project1.f1.setVisible(false);
}

}

}