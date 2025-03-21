import java.sql.*;
import java.util.Scanner;

public class DBConnection {
    static final String query1 = "select * from NHANVIEN";
    static final String query2 = "update NHANVIEN set LUONG = 100000 where TEN = 'Quang'";
    static final String query3 = "delete from NHANVIEN where MAN = 1001";
    static final String query4 = """
                                    select len(MACB) as length_code
                                    from LICHBAY
                                """;
    static final String query5 = "update NHANVIEN set LUONG = 200000 where TEN = 'Phong'";
    static final String query6 = "insert into LICHBAY values ({d '2005-11-15'}, '100',11,'B727')";

    public static void run(String URL) throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);
        Savepoint savepoint1 = connection.setSavepoint("savepoint1");

        try {
            Statement statement = connection.createStatement();
//            statement.addBatch(query2);
//            statement.addBatch(query5);
//            statement.addBatch(query6);
            //            statement.addBatch(query1);

//            statement.executeBatch();

            ResultSet resultSet = statement.executeQuery(query4);
            int columnCount = resultSet.getMetaData().getColumnCount();

            while(resultSet.next()) {
                for(int i =1 ; i <= columnCount ; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback(savepoint1);
            System.exit(1);
        }
    }
}
