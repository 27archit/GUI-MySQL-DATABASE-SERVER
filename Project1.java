package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project1 implements ActionListener , ItemListener
{
static Frame f1;
Label l2,l3,l4,l5;
TextField t1,t2,t3;
Button b2,b3;
Choice c2;
Connection co;

Project1()
{
f1=new Frame("CREATING NEW TABLE");

l2=new Label("TABLE NAME");
l3=new Label("FEILD NAME");
l4=new Label("DATATYPE");
l5=new Label("VARIABLE LENGTH OF DATATYPE");

b2=new Button("CREATE");
b3=new Button("CANCEL");

t1=new TextField();
t2=new TextField();
t3=new TextField();

c2=new Choice();
c2.add("VARCHAR");
c2.add("CHAR");
c2.add("INT");
c2.add("TIMESTAMP");
c2.add("DATETIME");
c2.add("BLOB");
c2.add("CLOB");
c2.add("LONGBLOB");
c2.add("TINYTEXT");
c2.add("TINYINT");

f1.setLayout(null);

l2.setBounds(20,40,200,20);
l3.setBounds(20,80,200,20);
l4.setBounds(20,120,200,20);
l5.setBounds(20,160,200,20);

b2.setBounds(140,200,60,20);
b3.setBounds(220,200,60,20);

t1.setBounds(240,40,150,20);
t2.setBounds(240,80,150,20);
t3.setBounds(240,160,150,20);

c2.setBounds(240,120,150,20);

f1.add(l2);
f1.add(l3);
f1.add(l4);
f1.add(l5);
f1.add(b2);
f1.add(b3);
f1.add(t1);
f1.add(t2);
f1.add(t3);
f1.add(c2);

f1.setForeground(Color.blue);
f1.setBackground(Color.green);

f1.setSize(420,240);
f1.setVisible(true);

b2.addActionListener(this);
b3.addActionListener(this);

c2.addItemListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3206/"+Database.s,"root","archit27nov@gmail.com");
}catch(Exception e)
{
System.out.print("conn"+e);
}

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2)
{
my_db_server.Project1a p1_1=new my_db_server.Project1a();
}

else if(e.getSource()==b3)
{
f1.setVisible(false);
}

}

public void itemStateChanged(ItemEvent e)
{
if(e.getSource()==c2)
{

}

}
}