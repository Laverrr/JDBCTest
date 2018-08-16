import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.*;
import java.util.Arrays;

/**
 * Created by L on 2018/8/16.
 */
public class Test {

    @org.junit.Test
    public void conn() throws SQLException {
        String sql="SELECT * FROM book WHERE bid=? AND bname=?";

        JDBCUtil jdbcUtil = new JDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,14);
        ps.setString(2,"小王子");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String id = rs.getString("bname");
            System.out.println(id);
        }
        rs.close();
        ps.close();
        connection.close();
    }
//    @org.junit.Test
//    public void update() throws SQLException {
//        String sql="UPDATE book SET bname=? WHERE bid=?";
//
//        JDBCUtil jdbcUtil = new JDBCUtil();
//        Connection connection = jdbcUtil.getConnection();
//        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setInt(2,14);
//        ps.setString(1,"小小王子");
//        int i = ps.executeUpdate();
//        System.out.println(i);
//    }
    @org.junit.Test
    public void update() throws SQLException {
        String url="jdbc:mysql://localhost:3306/bookstore?useSSL=false&characterEncoding=utf8";
        String driver="com.mysql.jdbc.Driver";
        String user="root";
        String pwd="root";

        String sql="UPDATE book SET bname=? WHERE bid=?";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(url, user, pwd);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"小王子");
        ps.setInt(2,14);
        ps.execute();
        ps.close();
        conn.close();
    }
}
