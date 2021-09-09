package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project3 implements ActionListener , ItemListener
{
static Frame f3,f;
Button b14,b15,b1,b2;
static TextField t7,t;
Label l1,l2,l3,l4,l5;
static Choice c,c1,c2;
Connection co;
Statement st;
ResultSet rs;
ResultSetMetaData rsmd;
String s="";

Project3()
{

f3=new Frame("ADDING/UPDATING/DELETING FEILD");

l4=new Label("TABLE NAME");
l5=new Label("SELECT AN OPERATION!");
t7=new TextField();
b14=new Button("CONFIRM");
b15=new Button("CANCEL");

c=new Choice();
c.add("ADD A FIELD");
c.add("DELETE A FIELD");
c.add("UPDATE A FIELD");

f3.setLayout(null);

l4.setBounds(20,80,80,20);
t7.setBounds(120,80,160,20);
b14.setBounds(40,220,90,20);
b15.setBounds(160,220,90,20);
c.setBounds(70,160,140,20);
l5.setBounds(70,120,180,20);

f3.setSize(300,300);

f3.add(l4);
f3.add(t7);
f3.add(b14);
f3.add(b15);
f3.add(l5);
f3.add(c);

f3.setVisible(true);

b14.addActionListener(this);
b15.addActionListener(this);

f=new Frame();
l1=new Label("COLUMN NAME");
l2=new Label("COLUMN TYPE");
b1=new Button();
b2=new Button("CANCEL");
c1=new Choice();
c2=new Choice();
t=new TextField();
l3=new Label("VARIABLE LENGTH");
f.setLayout(null);
l1.setBounds(20,40,120,20);
l2.setBounds(20,80,120,20);
c1.setBounds(140,40,120,20);
c2.setBounds(140,80,120,20);
l3.setBounds(20,120,120,20);
t.setBounds(140,120,120,20);
b1.setBounds(40,160,100,20);
b2.setBounds(160,160,80,20);

f.add(l1);
f.add(l2);
f.add(c1);
f.add(c2);
f.add(b1);
f.add(b2);
f.setSize(300,200);
b1.addActionListener(this);
b2.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);

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

if(e.getSource()==b14)
{

if(c.getSelectedIndex()==0)
{
Project3a p3a=new Project3a();
}

else if(c.getSelectedIndex()==1)
{

try
{

st=co.createStatement();
rs=st.executeQuery("select * from "+t7.getText());
rsmd=rs.getMetaData();
int n=rsmd.getColumnCount();
for(int i=1;i<=n;i++)
{
c1.add(rsmd.getColumnName(i));
c2.add(rsmd.getColumnTypeName(i));
}
f.setVisible(true);
}catch(Exception ee)
{
System.out.print(ee);
}

b1.setLabel("DELETE FIELD");

}

else if(c.getSelectedIndex()==2)
{

try
{

c2.add("CHAR");
c2.add("VARCHAR");
c2.add("INT");
c2.add("TIMESTAMP");
c2.add("DATETIME");

st=co.createStatement();
rs=st.executeQuery("select * from "+t7.getText());
rsmd=rs.getMetaData();
int n=rsmd.getColumnCount();
//String s="";
for(int i=1;i<=n;i++)
{
c1.add(rsmd.getColumnName(i));
//s=s+rsmd.getColumnTypeName(i);
}
f.setVisible(true);
}catch(Exception ee)
{
System.out.print(ee);
}


b1.setLabel("UPDATE FIELD");

}


f3.setVisible(false);
}

else if(e.getSource()==b15)
{
f3.setVisible(false);
}

else if(e.getSource()==b1)
{

try{

st=co.createStatement();
if(c.getSelectedIndex()==1)
{

st.executeUpdate("Alter table "+t7.getText()+" drop column "+c1.getSelectedItem());     //+" "+c2.getSelectedItem());

}

else if(c.getSelectedIndex()==2)
{

if(c2.getSelectedItem()=="VARCHAR")
{
s=c2.getSelectedItem()+" ("+t.getText()+")";
}

else
{
s=c2.getSelectedItem();
}

st.executeUpdate("Alter table "+t7.getText()+" modify "+c1.getSelectedItem()+" "+s);

}

}catch(Exception ee)
{
System.out.print("Button "+ee);
}

}

else if(e.getSource()==b2)
{

f.setVisible(false);
f3.setVisible(false);

}

}

public void itemStateChanged(ItemEvent e)
{

if(c.getSelectedIndex()==1)
{
if(e.getSource()==c1)
{
int a=c1.getSelectedIndex();
c2.select(a);
}

else if(e.getSource()==c2)
{

int b=c2.getSelectedIndex();
c1.select(b);

}

}

else if(c.getSelectedIndex()==2)
{

if(c2.getSelectedItem()=="VARCHAR")
{
f.add(t);
f.add(l3);
}

}

}

}