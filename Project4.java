package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project4 implements ActionListener
{
Frame f1;
Label l1;
TextField t1;
Button b1,b2;
Project4()
{
f1=new Frame("UPDATING OR DELETING A RECORD");
l1=new Label("TABLE NAME :");
t1=new TextField();
b1=new Button("SHOW FIELD");
b2=new Button("CANCEL");
f1.setLayout(null);
l1.setBounds(20,40,80,20);
t1.setBounds(120,40,100,20);
b1.setBounds(60,90,100,30);
b2.setBounds(60,130,70,30);
f1.add(l1);
f1.add(t1);
f1.add(b1);
f1.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
f1.setSize(250,250);
f1.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
}
else if(e.getSource()==b2)
{
f1.setVisible(false);
}

}
}