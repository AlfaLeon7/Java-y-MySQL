import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio6 {
	
	public static void main(String[]args) throws SQLException {
		Basededatos2 bd2 = new Basededatos2();
		Scanner input = new Scanner(System.in);
		bd2.conectarBD();
		PreparedStatement st = bd2.ps;
		 PreparedStatement ps = bd2.conn.prepareStatement("SELECT * FROM (?) WHERE (?) = (?);");
		int idcliente;
		int idproducto;
		int cantidad;
		
		System.out.println("Insertar identificador de venta");
		
		int idventa = input.nextInt();
		String hayidventa = "SELECT * FROM ventas WHERE IDVENTA = '" + idventa + "'";
		
	    
	    ResultSet rs = ps.executeQuery(hayidventa);

	    if (!rs.next()) {
	    	System.out.println("Insertar identificador de cliente");
			 idcliente = input.nextInt();
			 String hayidcliente = "SELECT * FROM clientes WHERE ID = '" + idcliente + "'";
			 
		rs =	 ps.executeQuery(hayidcliente);
			 if(rs.next()) {
				 System.out.println("Insertar identificador de producto");
				 idproducto = input.nextInt();
				 String hayidproducto = "SELECT * FROM productos WHERE ID = '" + idproducto + "'";
				rs= ps.executeQuery(hayidproducto);
				 if(rs.next()) {
					 System.out.println("Insertar cantidad");
					 cantidad = input.nextInt();
					 if(cantidad>0) {
						 bd2.insertarVenta(idventa, "2012-07-16", idcliente, idproducto, cantidad);
						 System.out.println("Filas insertadas");
					 }
				 }
			 }
	    } else {
	        System.out.println("El valor ya existe");
	        System.exit(1);
	    }
	    
	    bd2.cerrarConexion();
	    
		
		
	}

}
