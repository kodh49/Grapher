package sql;
import java.sql.*;

public class DBA {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/grapher?useSSL=false";
    static final String USERNAME = "root"; //Database ID
    static final String PASSWORD = ""; //Database Password

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public DBA() {
        System.out.print("Grapher 데이터베이스 접속 : ");
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            if (conn != null) System.out.println("성공");
            else System.out.println("실패");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void tableCreate() {
        String query = "DELETE FROM chart;";
        try {
            //Access database
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
            } catch (ClassNotFoundException e) {
            System.out.println("Class not found Exception");
        } catch (SQLException e) {
            System.out.println("SQL Exception : "+e.getMessage());
        }
    }


    public void tableInsert(String name, double xval, double yval) { // name 은 table 의 이름
        TableName tn = new TableName(xval, yval);
        String query = "INSERT INTO "+name+" "+"VALUE (" + tn.xval + ", " + tn.yval +");";
        //System.out.println(query);
        // Upload data
        try {
            //Access database
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found Exception");
        } catch (SQLException e) {
            System.out.println("SQL Exception : "+e.getMessage());
        }
    }

    public void tableSelect(String name) { //name 은 table 의 이름
        String query = "SELECT * FROM "+name+"";
        TableName tn = new TableName();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            // Print data
            while (rs.next()) {
                tn.setXval(rs.getDouble("xval"));
                tn.setYval(rs.getDouble("yval"));
                System.out.println("xval : "+tn.getXval()+" yval : "+tn.getYval());
            }
            stmt.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found Exception");
        } catch (SQLException e) {
            System.out.println("SQL Exception : "+e.getMessage());
        }
    }

}
