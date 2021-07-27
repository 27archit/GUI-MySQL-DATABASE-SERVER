package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project2a implements ActionListener
{

Frame f10;
Label l11;
Button b12,b13;

Project2a()
{

f10=new Frame("INSERT MORE FEILDS?");

l11=new Label("DO YOU WANT TO INSERT MORE ROWS?");
b12=new Button("YES");
b13=new Button("NO");

f10.setLayout(null);

l11.setBounds(30,80,210,20);
b12.setBounds(80,140,60,20);
b13.setBounds(160,140,60,20);

f10.add(l11);
f10.add(b12);
f10.add(b13);

f10.setSize(300,300);

f10.setVisible(true);

}

public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b12)
{
f10.setVisible(false);
Project2 a=new Project2();
}

else if(e.getSource()==b13)
{
f10.setVisible(false);
Project2.f2.setVisible(false);
}

}
}