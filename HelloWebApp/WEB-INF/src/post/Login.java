package post;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession(true);
		String name=request.getParameter("name");
		//request.setAttribute("name",name);
		session.setAttribute("name",name);
		request.setAttribute("name",session.getAttribute("name"));
		RequestDispatcher dispatch = request.getRequestDispatcher("/blog");
		dispatch.forward(request, response);
	}

}
