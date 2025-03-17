import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static void run(String URL) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("""
                                SELECT *
                                FROM PHANCONG pc
                                JOIN NHANVIEN nv
                                ON pc.MANV = nv.MANV
                                WHERE nv.LOAINV = 1"""))
        {

            System.out.println("Successfully connected to Quan Ly Chuyen Bay!");

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "  ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
