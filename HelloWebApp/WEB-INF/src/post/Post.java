package post;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Post extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
 //(1)�G���R�[�h�����̎w��
 res.setContentType("text/html; charset=Windows-31J");
 //(2)�p�����[�^�̃G���R�[�h�����̎w��
 req.setCharacterEncoding("Windows-31J");

 //(3)PrintWriter�I�u�W�F�N�g�̐���
 PrintWriter out = res.getWriter();
 out.println("<HTML>");
 out.println("<BODY>");
 //(4)name1�p�����[�^�̎擾
 out.println(req.getParameter("name1") + "<br>");
 //(5)vehicle�p�����[�^�̎擾
 String vehicle[ ] = req.getParameterValues("vehicle");
 for (int i = 0; i < vehicle.length; i++ ) {
  out.println(vehicle[i] + "<br>");
 }

 out.println("</BODY>");
 out.println("</HTML>");
}
}