import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


	public class Basededatos {

	     // Propiedades
	     Connection conn = null;
	     Statement stmt = null;
	     Statement stmt2 = null;
	     Statement stmt3 = null;
	     PreparedStatement ps = null;
	     ResultSet rs = null;
	     ResultSet rs2 = null;
	     ResultSet rs3 = null;
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
	     
	     public void infoConsulta(String select, String select2, String select3){
	          if (conn != null){
	                try{
	                     stmt = conn.createStatement();
	                     rs = stmt.executeQuery(select);
	                     System.out.println("CLIENTES");
	                     while(rs.next()){
	                    	
	                          System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) +"\t" + rs.getString(4) + "\t" + rs.getString(5) +  "\t" + rs.getString(6)  );
	                          
	                     }
	                     System.out.println("----------------------------------");
	                     stmt2 = conn.createStatement();
	                     rs2 = stmt.executeQuery(select2);
	                     System.out.println("VENTAS");
	                     while(rs2.next()){
	                    	 
	                          System.out.println(rs2.getString(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3) +"\t" + rs2.getString(4) + "\t" + rs2.getString(5)  );
	                          
	                     }
	                     System.out.println("----------------------------------");
	                     stmt3 = conn.createStatement();
	                     rs3 = stmt.executeQuery(select3);
	                     System.out.println("PRODUCTOS");
	                     while(rs3.next()){
	                    	
	                          System.out.println(rs3.getString(1) + "\t" + rs3.getString(2) + "\t" + rs3.getString(3) +"\t" + rs3.getString(4) + "\t" + rs3.getString(5)   );
	                         
	                     }
	                     System.out.println("----------------------------------");
	                }
	                catch(SQLException e){
	                     e.printStackTrace();
	                }
	                finally{
	                     if (stmt != null){
	                          try{
	                               stmt.close();
	                          }
	                          catch(SQLException e){
	                               e.printStackTrace();
	                          }
	                     }
	                     if (rs != null){
	                          try{
	                               rs.close();
	                          }
	                          catch(SQLException e){
	                               e.printStackTrace();
	                          }
	                     }
	                }
	          }
	     } // Fin función infoConsulta()
}

