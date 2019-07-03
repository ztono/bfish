package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class BaseDao {

    private String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
    private String user = "root";
    private String pswd = "123456";
    private java.sql.Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void getConnection(){
        if(conn == null){
            try {
                conn = DriverManager.getConnection(url, user, pswd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ResultSet executeQuery(String query, List<Object> params){
        getConnection();
        try {
            pstmt = conn.prepareStatement(query);
            if(params!=null && params.size()>0){
                for(int i=0;i<params.size();i++){
                    pstmt.setObject(i+1, params.get(i));  //琛ㄧず缁欑i+1涓崰浣嶇璧嬪??
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int executeUpdate(String query, List<Object> params){
        int result = 0;
        getConnection();
        try {
            pstmt = conn.prepareStatement(query);
            if(params!=null && params.size()>0){
                for(int i=0;i<params.size();i++){
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.close();
        }
        return result;
    }

    

    public void close(){        
            try {
                if(rs!=null){
                    rs.close();
                    rs = null;
                }
                if(pstmt!=null){
                    pstmt.close();
                    pstmt = null;
                }
                if(conn!=null){
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

}
