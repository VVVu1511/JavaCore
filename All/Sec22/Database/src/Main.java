

public class Main {
    private final static String URL = "jdbc:sqlserver://DESKTOP-0E72VR4:1433;databaseName=QLyChuyenBay;integratedSecurity=true;encrypt=false";

    public static void main(String[] args) {
        DBConnection.run(URL);
    }
}
