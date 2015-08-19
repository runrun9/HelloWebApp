package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		doGet(request, response);
	}
	public void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
                throws ServletException, IOException {
		
	    response.setContentType("text/html; charset=Shift_JIS");
	    

	    /* HTML �o�͗p PrintWriter */
	    PrintWriter out = response.getWriter();
	    int i=1;
	    /* HTML�o�� */
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Hello!</title>");
	    out.println("</head>"); 
	    out.println("<body>");
	    String msg = "";
	    try {	
	    	Class.forName("com.mysql.jdbc.Driver");
	      msg = "�h���C�o�̃��[�h�ɐ������܂���";
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "run", "");
	      msg="�ڑ��ł���";
	      String sql = "select * from blog_table";
	      Statement stm = con.createStatement();
	      ResultSet rs = stm.executeQuery(sql);
	      while(rs.next()) {
          	String Id = rs.getString("blog");
          	System.out.println(Id);
          	msg=Id;
          }
	    }catch (ClassNotFoundException e){
	      msg = "�h���C�o�̃��[�h�Ɏ��s���܂���1";
	      e.printStackTrace();
	    }catch (Exception e){
	      msg = "�h���C�o�̃��[�h�Ɏ��s���܂���2";
	    }
	    out.println("<H1>");
	    out.println("�悤����"+i+msg);
	    out.println("<H1>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
		
	}
}