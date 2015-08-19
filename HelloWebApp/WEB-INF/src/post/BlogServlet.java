package post;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class BlogServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		doGet(request, response);
	}
	public void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
                throws ServletException, IOException {
		Connection con = null;
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		try {
			/////////////////////////////////////////// 
			//�P�C�@�h���C�o�[�����[�h���ADB�֐ڑ�
			///////////////////////////////////////////
			// �h���C�o�N���X�����[�h
			Class.forName("com.mysql.jdbc.Driver");
			
			// �f�[�^�x�[�X�֐ڑ�
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=sjis", "run", "");
			/////////////////////////////////////////// 
			//�Q�C�@��ʏ�œ��͂��ꂽ�p�����[�^���擾���ADB�ɓo�^
			/////////////////////////////////////////// 
			String value=request.getParameter("blog");
			String delete=request.getParameter("delete");
			if(delete!=null){
				String sql="delete from blog_table";
				PreparedStatement ps=con.prepareStatement(sql);
				int i=ps.executeUpdate();
			}
			else if((value!=null)&&value.trim().length()>0){
				String sql="insert into blog_table(blog)values(?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,value);
				int i=ps.executeUpdate();
			}
			/////////////////////////////////////////// 
			//�R�C�@�u���O��DB���璊�o���A��ʂɐݒ肷��
			///////////////////////////////////////////
			// ��������SQL�����쐬
			String sql = "select blog from blog_table;";
			// �X�e�[�g�����g�I�u�W�F�N�g�𐶐����A�p�����[�^��ݒ�
			PreparedStatement ps = con.prepareStatement(sql);
			// �N�G���[�����s���Č��ʃZ�b�g���擾
			ResultSet rs = ps.executeQuery();
			
			/////////////////////////////////////////// 
			// 4 �������ʂ���ʂ֓n��
			///////////////////////////////////////////
			request.setAttribute("BlogList", rs);
			HttpSession session=request.getSession(true);
			request.setAttribute("name",session.getAttribute("name"));
			/////////////////////////////////////////// 
			// 5 ��ʂ�\������
			///////////////////////////////////////////
			RequestDispatcher dispatch = request.getRequestDispatcher("/blog.jsp");
			dispatch.forward(request, response);
			
		//} catch (ClassNotFoundException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//	System.out.println("error1");
		} catch (ClassNotFoundException e){
		      e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error2");
		} finally {			
		}
		
	}
}
