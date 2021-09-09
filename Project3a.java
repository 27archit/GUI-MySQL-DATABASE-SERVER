package my_db_server;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Project3a implements ActionListener
{
static Frame f;
Button b1,b2;
Label l1,l2,l3;
TextField t1,t2;
static Choice c1;
Connection co;
Statement st;

Project3a()
{
f=new Frame("PERFORMING OPERATIONS");

b1=new Button();
b2=new Button("CANCEL");

f.add(b1);
f.add(b2);

f.setLayout(null);

if(Project3.c.getSelectedIndex()==0)
{

b1.setLabel("ADD FEILD");

l1=new Label("FIELD NAME");
l2=new Label("SELECT DATATYPE");
l3=new Label("VARIABLE LENGTH OF DATATYPE");
t1=new TextField();
t2=new TextField();

c1=new Choice();
c1.add("VARCHAR");
c1.add("CHAR");
c1.add("INT");
c1.add("TIMESTAMP");
c1.add("DATETIME");
//c1.add("BLOB");
//c1.add("CLOB");
//c1.add("LONGBLOB");
//c1.add("TINYTEXT");
//c1.add("TINYINT");

f.add(l1);
f.add(l2);
f.add(t1);
f.add(c1);
f.add(t2);
f.add(l3);

l1.setBounds(20,40,200,20);
l2.setBounds(20,80,200,20);
l3.setBounds(20,120,200,20);

b1.setBounds(120,160,80,20);
b2.setBounds(220,160,80,20);

t1.setBounds(240,40,150,20);
t2.setBounds(240,120,150,20);

c1.setBounds(240,80,150,20);

f.setSize(420,200);
}

b1.addActionListener(this);
b2.addActionListener(this);

f.setVisible(true);

try{
Class.forName("com.mysql.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3206/"+Database.s,"root","archit27nov@gmail.com");
}catch(Exception e)
{
System.out.print(e);
}

}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{

try{

if(Project3.c.getSelectedIndex()==0)
{

st=co.createStatement();

if(c1.getSelectedIndex()==0)
{
st.executeUpdate("alter table "+Project3.t7.getText()+" add "+t1.getText()+" "+c1.getSelectedItem()+" ("+Integer.parseInt(t2.getText())+") ");

}

else
{

st.executeUpdate("alter table "+Project3.t7.getText()+" add "+t1.getText()+" "+c1.getSelectedItem());

}

}

}catch(Exception ee)
{
System.out.print("button "+ee);
}

}

else if(e.getSource()==b2)
{
f.setVisible(false);
}

}

}