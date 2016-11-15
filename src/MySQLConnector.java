import java.sql.*;

public class MySQLConnector {
    public static void main(String[] args) {
        Connection con = null;
        try {
            // JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "]");
            System.out.println("MySQLに接続できました。");
            
            /*
            // データの取得処理
            Statement stm = con.createStatement();
            String sql = "select * from programing";
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("取得結果 -> " + id + ":" + name);
            }
            */
            
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードに失敗しました。");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("MySQLのクローズに失敗しました。");
                }
            }
        }
    }
}