import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem";
    try(Connection conn = DriverManager.getConnection(url);
        Statement stmn = conn.createStatement()){
        stmn.execute("CREATE TABLE person(\n" +
                "    id INT NOT NULL ,\n" +
                "    name VARCHAR(20),\n" +
                "    surname VARCHAR(30),\n" +
                "    age INT,\n" +
                "    PRIMARY KEY (id)\n" +
                "    );");
        stmn.executeUpdate("INSERT INTO person VALUES (1,'Anna','Stratulat',9);\n" +
                "INSERT INTO person VALUES (9,'Tatiana','Bradu',64);\n" +
                "INSERT INTO person VALUES (3,'Ion','Negru',23);\n" +
                "INSERT INTO person VALUES (4,'Andrei','Sclifos',45);\n" +
                "INSERT INTO person VALUES (5,'Anton','Ursu',39);\n" +
                "INSERT INTO person VALUES (6,'Ariel','Ermuraki',26);\n" +
                "INSERT INTO person VALUES (8,'Artiom','Stratulat',26);");
        ResultSet resultSet = stmn.executeQuery("SELECT * FROM person;");

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getInt(4));

            resultSet.close();

        }
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }





    }
}