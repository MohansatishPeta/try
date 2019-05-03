import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("mailid");
		String p=request.getParameter("userpass");

                Cookie c1=new Cookie("userName",n);
		 response.addCookie(c1);
		request.setAttribute("mailid",n);
		if(LoginDao.validate(n, p)){
                    out.print("<h2><center>Welcome</center></h2>");
                            out.print(n);
			RequestDispatcher rd=request.getRequestDispatcher("afterlogin.html");
			rd.forward(request,response);

		}
		else{
			out.print("<h2><center>Sorry mailid or password error</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
		
		out.close();
	}

}
