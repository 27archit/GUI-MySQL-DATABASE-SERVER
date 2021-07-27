package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project2 implements ActionListener
{

static Frame f2,f9;
Button b8,b9,b10,b11;
Label l[],l10;
TextField t[],t6;
Connection co;
Statement st;
ResultSet rs;
ResultSetMetaData rsmd;

Project2()
{

f2=new Frame("INSERTING RECORDS");
f9=new Frame("INSERTING RECORDS INTO THE TABLE");

l10=new Label("TABLE NAME");
t6=new TextField();
b8=new Button("CONFIRM");
b9=new Button("CANCEL");

f2.setLayout(null);

l10.setBounds(20,120,80,20);
t6.setBounds(120,120,160,20);
b8.setBounds(60,200,80,20);
b9.setBounds(160,200,80,20);

f2.add(l10);
f2.add(t6);
f2.add(b8);
f2.add(b9);

f2.setSize(300,300);

f2.setVisible(true);

b8.addActionListener(this);
b9.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3206/project","root","archit27nov@gmail.com");
}catch(Exception e)
{
System.out.print("conn"+e);
}

}

public void actionPerformed(ActionEvent e)
{

if(e.getSource()==b8)
{
try
{
int top=40;
st=co.createStatement();
rs=st.executeQuery("select * from "+t6.getText());
rsmd=rs.getMetaData();
int n=rsmd.getColumnCount();
f9.setLayout(null);
l=new Label[n];
t=new TextField[n];
for(int i=0;i<n;i++)
{
l[i]=new Label(rsmd.getColumnName(i+1));
t[i]=new TextField();
l[i].setBounds(20,top,80,20);
t[i].setBounds(120,top,160,20);
f9.add(l[i]);
f9.add(t[i]);
top = top + 40;
}

b10=new Button("CONFIRM");
b11=new Button("CANCEL");

b10.setBounds(80,top,60,20);
b11.setBounds(160,top,60,20);

f9.add(b11);
f9.add(b10);
f9.setSize(300,(top + 40));

b10.addActionListener(this);
b11.addActionListener(this);

f9.setVisible(true);
}catch(Exception ee)
{
System.out.print(ee);
}
}

else if(e.getSource()==b9)
{
f2.setVisible(false);
}

else if(e.getSource()==b10)
{
Project2a p2a=new Project2a();
try{
st=co.createStatement();
rs=st.executeQuery("select * from "+t6.getText());
rsmd=rs.getMetaData();
int n=rsmd.getColumnCount();
for(int i=1;i<=n;i++)
{
t[i-1].setText("");				
}
f9.setVisible(false);
}catch(Exception ee)
{
System.out.print(ee);
}
}

else if(e.getSource()==b11)
{
f9.setVisible(false);
}

}

}