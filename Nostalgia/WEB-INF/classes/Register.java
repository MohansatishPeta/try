import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;   
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String a=request.getParameter("UserName");
String b=request.getParameter("PASSWORD");
String c=request.getParameter("EMAIL");
String d=request.getParameter("MOBILE"); 
String e=request.getParameter("DOB"); 
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
 String query="create table "+a+"(title varchar2(40),message varchar2(400),date_of_written varchar2(60))";
 PreparedStatement pk=con.prepareStatement(query); 
 pk.executeUpdate ();  

PreparedStatement ps=con.prepareStatement(  
"insert into nostlog values(?,?,?,?,?)");  
  
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);  
ps.setString(4,d);  
ps.setString(5,e);   

        
int i=ps.executeUpdate();  
if(i>0)  {
out.print("<h2><center>You are successfully registered</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);  
       
  }

else{   
			out.print("<h2><center>Sorry Username or MailId already registered..</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response); 
}    
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {
		out.print("<h2><center>Sorry mailid or user name alredy registered</center></h2>");
e1.printStackTrace();}  
          
 
}  
  
}  