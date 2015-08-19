package hello;
import java.sql.*;
public class TestMySQL {
	public static void main(String[] args){
		System.out.println("a");
		Connection con = null;

        PreparedStatement ps = null;

        try {

            // �h���C�o�N���X�����[�h
            //Class.forName("com.mysql.jdbc.Driver");

            // �f�[�^�x�[�X�֐ڑ�
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "run", "");

            // name,bloodType,age�̃f�[�^����������SQL�����쐬
            String sql = "select * from blog_table";

            // �X�e�[�g�����g�I�u�W�F�N�g�𐶐�
            ps = con.prepareStatement(sql);
            Statement stm = con.createStatement();
            
            // �N�G���[�����s���Č��ʃZ�b�g���擾
            ResultSet rs = stm.executeQuery(sql);
           while(rs.next()) {
            	String Id = rs.getString("blog");
            	System.out.println(Id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        //} catch (ClassNotFoundException e) {
        //	System.out.println("error1");
       //     e.printStackTrace();
        } finally {
            try {

                // close����
                if(ps != null){
                    ps.close();
                }

                // close����
                if(con != null){
                    con.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
	}
}
