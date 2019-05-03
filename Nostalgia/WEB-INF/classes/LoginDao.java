import java.sql.*;

public class LoginDao {

public static boolean validate(String mailid,String pass){
boolean status=false;
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	
	PreparedStatement ps=con.prepareStatement("select * from nostlog where uname=? and psw=?");
	ps.setString(1,mailid);
	ps.setString(2,pass);
	ResultSet rs=ps.executeQuery();
	status=rs.next();
	
	
}catch(Exception e){System.out.println(e);}
return status;
}
}
