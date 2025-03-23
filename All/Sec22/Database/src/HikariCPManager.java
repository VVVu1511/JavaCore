import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class HikariCPManager {
    public static HikariDataSource dataSource;
    public static HikariConfig config = null;

    HikariCPManager(){
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlserver://DESKTOP-0E72VR4:1433;databaseName=QLyChuyenBay;integratedSecurity=true;encrypt=false");
        config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        config.setMaximumPoolSize(50);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(){
        if(dataSource != null){
            dataSource.close();
        }
    }
}
