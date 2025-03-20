import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {
    static final String query1 = "select * from NHANVIEN";
    static final String query2 = "update NHANVIEN set LUONG = 100000 where TEN = 'Phong'";
    static final String query3 = "delete from NHANVIEN where MANV = 15";
    static final String query4 = """
                                    select cb1.MACB, cb1.GIODI, cb1.GIODEN
                                    from CHUYENBAY cb1
                                    where cb1.GIODI <= all(
                                                select cb2.GIODI
                                    from CHUYENBAY cb2
                                )
                                """;

    public static void run(String URL) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            Statement statement = connection.createStatement();
//            statement.executeUpdate(query3);

            ResultSet resultSet = statement.executeQuery(query4);
            int columnCount = resultSet.getMetaData().getColumnCount();

            while(resultSet.next()) {
                for(int i =1 ; i <= columnCount ; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
