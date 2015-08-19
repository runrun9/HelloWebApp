package post;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Post extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
 //(1)エンコード方式の指定
 res.setContentType("text/html; charset=Windows-31J");
 //(2)パラメータのエンコード方式の指定
 req.setCharacterEncoding("Windows-31J");

 //(3)PrintWriterオブジェクトの生成
 PrintWriter out = res.getWriter();
 out.println("<HTML>");
 out.println("<BODY>");
 //(4)name1パラメータの取得
 out.println(req.getParameter("name1") + "<br>");
 //(5)vehicleパラメータの取得
 String vehicle[ ] = req.getParameterValues("vehicle");
 for (int i = 0; i < vehicle.length; i++ ) {
  out.println(vehicle[i] + "<br>");
 }

 out.println("</BODY>");
 out.println("</HTML>");
}
}