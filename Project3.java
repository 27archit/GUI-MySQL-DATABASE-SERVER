package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project3 implements ActionListener , ItemListener
{
static Frame f3,f;
Button b14,b15,b1,b2;
TextField t7;
Label l1,l2,l4,l5;
static Choice c,c1,c2;
Connection co;
Statement st;
ResultSet rs;
ResultSetMetaData rsmd;

Project3()
{

f3=new Frame("ADDING/UPDATING/DELETING FEILD");

l4=new Label("TABLE NAME");
l5=new Label("SELECT AN OPERATION!");
t7=new TextField();
b14=new Button("SHOW FEILDS");
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
f.setLayout(null);
l1.setBounds(20,40,120,20);
l2.setBounds(20,80,120,20);
c1.setBounds(140,40,120,20);
c2.setBounds(140,80,120,20);
b1.setBounds(40,120,100,20);
b2.setBounds(160,120,80,20);

f.add(l1);
f.add(l2);
f.add(c1);
f.add(c2);
f.add(b1);
f.add(b2);
f.setSize(300,200);
b1.addActionListener(this);

try{
Class.forName("com.mysql.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3206/project","root","archit27nov@gmail.com");
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

else if(c.getSelectedIndex()==1 || c.getSelectedIndex()==2)
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

if(c.getSelectedIndex()==1)
{
b1.setLabel("DELETE FIELD");
}

else if(c.getSelectedIndex()==2)
{
b1.setLabel("UPDATE FIELD");
}

}
f3.setVisible(false);
}

else if(e.getSource()==b15)
{
f3.setVisible(false);
}

else if(e.getSource()==b1)
{

}

else if(e.getSource()==b2)
{
f.setVisible(false);
}

}

public void itemStateChanged(ItemEvent e)
{
if(e.getSource()==c1)
{

if(c1.getSelectedIndex()==0)
{
c2.select(0);
}

else if(c1.getSelectedIndex()==1)
{
c2.select(1);
}

}

else if(e.getSource()==c2)
{

if(c2.getSelectedIndex()==0)
{
c1.select(0);
}

else if(c2.getSelectedIndex()==1)
{
c1.select(1);
}

}

}

}