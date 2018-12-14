import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Basededatos2 {
	Connection conn = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    DatabaseMetaData d = null;
    String url = "jdbc:mysql://localhost:3306/unidad2";
    String user = "root";
    String password = "";
    String driver = "com.mysql.jdbc.Driver";
    
    public void conectarBD(){
        
        // Cargra del Driver
        try{
              Class.forName(driver);
        }
        catch(ClassNotFoundException e){
              e.printStackTrace();
        }
       
        // Conexión a Base de datos
        try{
              conn = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
              e.printStackTrace();
        }
   } // fin función conectarBD
  
   public void cerrarConexion(){
        if (conn != null){
              try{
                   conn.close();
              }
              catch(SQLException e){
                   e.printStackTrace();
              }
        }
   } // Fin función cerrarConexion()
	
	public void insertarVenta(int idventa, String fecha, int idcliente, int idproducto, int cantidad ){
        
        try{
              conn.setAutoCommit(false); 
              ps = conn.prepareStatement("INSERT INTO ventas VALUES((?),(?),(?), (?), (?));");
              ps.setInt(1, idventa);
              ps.setString(2, fecha);
              ps.setInt(3,idcliente);
              ps.setInt(4, idproducto);
              ps.setInt(5, cantidad);
              ps.executeUpdate();
              conn.commit(); // Al finalizar sentencias hago commit
              conn.setAutoCommit(true); // Y vuelvo a activar autocommit para resto de aplicación
        }
        catch(SQLException e){
              try{
                   conn.rollback(); // Si algo falla hago rollback para dejarlo como antes
              }
              catch(SQLException ex){
                   ex.printStackTrace();
              }   
        }
        finally{
              if (ps != null){
                   try{
                        ps.close();
                   }
                   catch(SQLException e){
                        e.printStackTrace();
                   }
              }
        }
   } // Fin función insertarDept(x, x, x)
  
}
