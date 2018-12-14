import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Ejercicio2_8 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleados", "root", "");

            DatabaseMetaData dbmd = (DatabaseMetaData) conexion.getMetaData();

            ResultSet resul = null;

            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();

            System.out.println("INFORMACION SOBRE LA BASE DE DATOS:");
            System.out.println("===================================");
            System.out.printf("Nombre: %s %n", nombre);
            System.out.printf("Driver: %s %n", driver);
            System.out.printf("URL: %s %n", url);
            System.out.printf("Usuario: %s %n", usuario);

            resul = dbmd.getTables(null, "departamentos", null, null);

            while (resul.next()) {
                String catalogo = resul.getString(1);
                String esquema = resul.getString(2);
                String tabla = resul.getString(3);
                String tipo = resul.getString(4);
                System.out.printf("%s - Catalogo: %s. Esquema: %s,"
                        + " Nombre: %s %n", tipo, catalogo, esquema, tabla);
            }
            conexion.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}