import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;   
  
public class Write extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String a=request.getParameter("title");
String b=request.getParameter("message");
String c=request.getParameter("date_of_written");           
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
          Cookie c1[]=request.getCookies();
            String nm=c1[0].getValue();

 String query="insert into "+nm+" values(?,?,?)";
 PreparedStatement pk=con.prepareStatement(query); 
pk.setString (1,a);
pk.setString (2,b);
pk.setString (3,c);


 
/* String query="insert into "+nm+"values("+a+","+b+","+c+")";*/

    /* String query ="insert into "+nm+"values("+a+","+b+","+c+")";*/
/*   String query ="insert into abcdef values(?,?,?)";*/
 /*PreparedStatement pk=con.prepareStatement(query);/*("insert into abcdef values(?,?,?)"); */

        
int i=pk.executeUpdate();  
if(i>0)  {
out.print(nm);
out.print("<h2><center>You data saved..</center></h2>");

			RequestDispatcher rd=request.getRequestDispatcher("contentwrite.html");
			rd.include(request,response);  
       
  }

else{   
			out.print("<h2><center>Error</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response); 
}    
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {e1.printStackTrace();}  
          
 
}  
  
}  