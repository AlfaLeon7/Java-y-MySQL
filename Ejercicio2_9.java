import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class Ejercicio2_9 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","");

            Statement sentencia = conexion.createStatement();

            ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos");

            ResultSetMetaData rsmd = resul.getMetaData();

            int nColumnas = rsmd.getColumnCount();
            String nula;
            System.out.printf("Numero de columnas recuperadas: %d%n",nColumnas);
            for(int i=1;i<=nColumnas;i++) {
                System.out.printf("Columna %d: %n", i);
                System.out.printf(" Nombre: %s %n Tipo: %s %n ",rsmd.getColumnName(i), rsmd.getColumnTypeName(i));

                if(rsmd.isNullable(i)==0) {
                    nula = "NO";
                }else {
                    nula = "SI";
                }
                System.out.printf(" Puede ser nula?: %s %n ", nula);

                System.out.printf(" Maximo ancho de la columna: %d %n", rsmd.getColumnDisplaySize(i));
            }

            sentencia.close();
            resul.close();
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