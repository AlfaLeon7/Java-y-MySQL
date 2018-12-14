import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.midi.Soundbank;

public class Ejercicio2_10 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			int emp_no = Integer.parseInt(args[0]);
			String apellido = args[1];
			String oficio = args[2];
			int dir = Integer.parseInt(args[3]);
			double salario = Double.parseDouble(args[4]);

			double comision = Double.parseDouble(args[5]);
			int dept_no = Integer.parseInt(args[6]);

			if (existeDepartamento(dept_no, conexion)) {
				String sql = "INSERT INTO empleados(emp_no,apellido,oficio,dir,salario,comision,dept_no)" + "VALUES("
						+ emp_no + ",'" + apellido + "','" + oficio + "'," + dir + "," + salario + "," + comision + ","
						+ dept_no + ");";

				System.out.println(sql);
				Statement sentencia = conexion.createStatement();
				int filas = sentencia.executeUpdate(sql);
				System.out.println("filas afectadas: " + filas);
				sentencia.close();
			} else {
				System.out.println("Imposible insertar el departamento");
			}

			conexion.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean existeDepartamento(int dept_no, Connection conexion) throws SQLException {

		Statement sentencia = conexion.createStatement();

		ResultSet rs = sentencia.executeQuery("SELECT * FROM departamentos WHERE depto_no = " + dept_no);

		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}
}
