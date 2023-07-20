
package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection {
	public static Connection getConnection() {
		String URL = "jdbc:sqlserver://localhost:1433;databaseName=sinhhoathe;user = SA;password = 12345;trustServerCertificate=true";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ket noi voi database khong thanh cong");
		}
		return conn;
	}
	public static void closeConnection(Connection c, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (c != null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
