package my_db_server;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Project5 implements ActionListener
{
Frame f5,fc;
Button b1,b2,b3,b4,b5,b6;
Label l1,l2,l3;
TextField t1;
TextArea ta;
Choice c1,c2;
Connection co;
Statement st;
ResultSet rs;
ResultSetMetaData rsmd;
JTable t;
JScrollPane jsp;
DefaultTableModel dtm;

Project5()
{
f5=new Frame("FETCHING RECORDS");
dtm=new DefaultTableModel();
t=new JTable(dtm);
b1=new Button("SHOW");
b2=new Button("RESET");
b3=new Button("CONDITIONS");
b4=new Button("BACK");
l1=new Label("TABLE NAME");
t1=new TextField();
ta=new TextArea();
f5.setLayout(null);
l1.setBounds(20,40,80,30);
t1.setBounds(120,40,160,30);
b1.setBounds(20,90,60,40);
b2.setBounds(90,90,60,40);
b3.setBounds(160,90,80,40);
b4.setBounds(250,90,60,40);
ta.setBounds(10,150,300,140);
f5.add(l1);
f5.add(t1);
f5.add(b1);
f5.add(b2);
f5.add(b3);
f5.add(ta);
f5.add(b4);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
f5.setSize(330,300);
f5.setVisible(true);

//Conditional frame
fc=new Frame("CONDITIONS");
fc.setLayout(null);
c1=new Choice();
c2=new Choice();
c2.add("A PARTICULAR VALUE");
c2.add("ASCENDING ORDER");
c2.add("DESCENDING ORDER");
c2.add("GREATER THAN OR EQUALS TO");
c2.add("LESSER THAN OR EQUALS TO");
c2.add("BETWEEN 2 VALUES");
c2.add("GREATER THAN");
c2.add("LESSER THAN");
l2=new Label("SELECT THE FIELD OF THE TABLE");
l3=new Label("SELECT OPERATION");
b5=new Button("CONFIRM");
b6=new Button("CANCEL");
c1.setBounds(30,80,200,20);
l2.setBounds(30,40,200,20);
c2.setBounds(30,170,200,20);
l3.setBounds(30,130,200,20);
b5.setBounds(80,230,60,20);
b6.setBounds(160,230,60,20);
fc.add(c1);
fc.add(c2);
fc.add(b5);
fc.add(b6);
fc.add(l2);
fc.add(l3);
b5.addActionListener(this);
fc.setSize(300,300);


try
{
Class.forName("com.mysql.jdbc.Driver");
co=DriverManager.getConnection("jdbc:mysql://localhost:3206/"+Database.s,"root","archit27nov@gmail.com");
}
catch(Exception ee)
{
System.out.println(ee);
}
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
}
else if(e.getSource()==b2)
{
t1.setText(" ");
}
else if(e.getSource()==b3)
{
try{
st=co.createStatement();
rs=st.executeQuery("select * from "+t1.getText());
rsmd=rs.getMetaData();
int n=rsmd.getColumnCount();
for(int i=1;i<=n;i++)
{
c1.add(rsmd.getColumnName(i));
}
f5.setVisible(false);
fc.setVisible(true);
}catch(Exception ee)
{
System.out.print(ee);
}
}
else if(e.getSource()==b4)
{
f5.setVisible(false);
}

else if(e.getSource()==b5)
{

}

else if(e.getSource()==b6)
{
fc.setVisible(false);
}

}
}