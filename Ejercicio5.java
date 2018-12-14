
public class Ejercicio5 {

	public static void main(String[]args) {
		Basededatos bd = new Basededatos();
		
		bd.conectarBD();
		bd.infoConsulta("SELECT * FROM clientes", "SELECT * FROM ventas" , "SELECT * FROM productos");
		bd.cerrarConexion();
}
}
