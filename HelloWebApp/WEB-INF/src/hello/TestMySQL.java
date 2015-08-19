package hello;
import java.sql.*;
public class TestMySQL {
	public static void main(String[] args){
		System.out.println("a");
		Connection con = null;

        PreparedStatement ps = null;

        try {

            // ドライバクラスをロード
            //Class.forName("com.mysql.jdbc.Driver");

            // データベースへ接続
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "run", "");

            // name,bloodType,ageのデータを検索するSQL文を作成
            String sql = "select * from blog_table";

            // ステートメントオブジェクトを生成
            ps = con.prepareStatement(sql);
            Statement stm = con.createStatement();
            
            // クエリーを実行して結果セットを取得
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

                // close処理
                if(ps != null){
                    ps.close();
                }

                // close処理
                if(con != null){
                    con.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
	}
}
