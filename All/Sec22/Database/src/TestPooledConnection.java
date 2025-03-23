import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestPooledConnection {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HikariCPManager manager = new HikariCPManager();

        try{
            conn = HikariCPManager.getConnection();
            String sql = "select * from NHANVIEN";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                    System.out.print(rs.getString(i));
                    System.out.print("\t");
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            try{
                if(ps != null) ps.close();
                if(conn != null) conn.close();
                if(rs != null) rs.close();
            } catch(SQLException e){
                e.printStackTrace();
            }

            HikariCPManager.close();
        }
    }
}
