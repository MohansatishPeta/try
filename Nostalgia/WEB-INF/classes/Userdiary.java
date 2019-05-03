
 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.sql.*;
  
 public class Userdiary extends HttpServlet {
  
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
         PrintWriter out = res.getWriter();
         res.setContentType("text/html");
         out.println("<html><body>");
         try {
             Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
             Cookie c[]=req.getCookies();
             String nm=c[1].getValue(); 
             Statement stmt = con.createStatement();
              String query="select * from abcdef";/*+nm;*/
             ResultSet rs = stmt.executeQuery(query);
	     out.println("<html><body bgcolor=cyam>");
		out.println("<html><body bgcolor=cyam>");
		out.print("Name: "+c[1].getValue()); 
             out.println("<center><h1><font color=blue>MEMORIES</font></h1></center>");

             out.println("<hr size=10 color=green width=100%>");
             out.println("<center><table border=2 width=60% height=60% bordercolor=maroon>");
             out.println("<tr><th><font color=cyan>TITLE</font></th><th><font color=cyan>MESSAGE</font></th><th><font color=cyan>DATE</font></th><tr>");
             while (rs.next()) {
                 String n1= rs.getString("title");
                 String n2 = rs.getString("message");
                 String n3= rs.getString("date_of_written");        
                 out.println("<tr><td>" + n1 + "</td><td>" + n2 + "</td><td>" + n3 + "</td></tr>"); 
             }
             out.println("</table></center>");
             out.println("</html></body>");
             con.close();
            }
             catch (Exception e) {
             out.println("error");
         }
     }
 }