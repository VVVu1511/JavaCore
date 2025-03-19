import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {
    public static void run(String URL) {
        try (Connection connection = DriverManager.getConnection(URL)) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter an employee type: ");
//            int id = Integer.parseInt(scanner.nextLine());

//            String query = "SELECT * from NHANVIEN where LOAINV = 1";

            Statement stmt = connection.createStatement();

//            boolean result = stmt.execute(query);
//
//            var rs = stmt.getResultSet();
//
//            boolean found = (rs != null && rs.next());
//
//            System.out.println("Artist was " + (found ? "found" : "not found"));
//
//            System.out.println("result = " + result);

            String table = "NHANVIEN";
            String columnName = "MANV";
            String columnValue = "15";

//            insertRecord(stmt, table, new String[]{columnName}, new String[]{columnValue});

            ResultSet rs = stmt.executeQuery("select * from %s".formatted(table));

            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.printf("%-30s",rs.getMetaData().getColumnName(i).toUpperCase());
            }

            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.printf("%-30s",rs.getString(i));
                }
                System.out.println();
            }



//            ResultSet rs = stmt.executeQuery(query);
//
//            System.out.println("Successfully connected to Quan Ly Chuyen Bay!");
//
//            int columnCount = rs.getMetaData().getColumnCount();
//
//            for (int i = 1; i <= columnCount; i++) {
//                System.out.printf("%-30s",rs.getMetaData().getColumnName(i).toUpperCase());
//            }
//
//            System.out.println();
//
//            while (rs.next()) {
//                for (int i = 1; i <= columnCount; i++) {
//                    System.out.printf("%-30s",rs.getString(i));
//                }
//                System.out.println();
//            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static boolean printRecords(ResultSet rs) throws SQLException {
        boolean foundData = false;
        int columnCount = rs.getMetaData().getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-30s",rs.getMetaData().getColumnName(i).toUpperCase());
        }

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s",rs.getString(i));
            }
            System.out.println();
            foundData = true;
        }

        return foundData;
    }

    private static boolean executeSelect(Statement statement, String table, String columnName, String columnValue) throws SQLException{
        String query = "select * from %s where %s = '%s'".
                formatted(table, columnName, columnValue);

        var rs = statement.executeQuery(query);
        if(rs != null){
            return printRecords(rs);
        }

        return false;
    }

    private static  boolean insertRecord(Statement statement, String table, String []columnNames, String[] columnValues) throws SQLException {
        String colNames = String.join(",", columnNames);
        String colValues = String.join(",", columnValues);

        String query  = "insert into %s(%s) values ('%s')".
                formatted(table, colNames,colValues);

        boolean result = statement.execute(query);

        return result;
    }
}
