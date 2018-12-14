import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio_211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // Propiedades
        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:mysql://localhost:3306/examen";
        String user = "root";
        String password = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
      }
      catch(ClassNotFoundException e){
            e.printStackTrace();
      }
        try{
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT apellido, salario, oficio, dnombre FROM empleados NATURAL JOIN departamentos");
           
            while(rs.next()){
                 String nombre = rs.getString("apellido");
                 int salario = rs.getInt("salario");
                 String oficio = rs.getString("oficio");
                 String nombredep = rs.getString("dnombre");
                 System.out.println("Apellidos: " + nombre + ". Salario: " + salario + ". Oficio: " + oficio + ". Nombre: " + nombredep);
            }
           
            rs.close();
            stmt.close();
      }
      catch(SQLException e){
            e.printStackTrace();
      }
      finally{
            if(conn != null){
                 try{
                      conn.close();
                 }
                 catch(SQLException e){
                      e.printStackTrace();
                 }
            }
      }
	}

}
