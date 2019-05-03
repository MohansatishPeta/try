<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%


String a=request.getParameter("uname");
String b=request.getParameter("mailid");
String c=request.getParameter("subject");
String d=request.getParameter("message"); 
String e=request.getParameter("condt");
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
  
PreparedStatement ps=con.prepareStatement("insert into nostqueries values(?,?,?,?,?)");  
  
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);  
ps.setString(4,d);  
ps.setString(5,e); 
int i=0;          
i=ps.executeUpdate(); 

if(i>0)  {
out.println("Your message is received we will respond soon.."); 
  } 
     
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {
out.println("Error"); 

e1.printStackTrace();}  


%>
 