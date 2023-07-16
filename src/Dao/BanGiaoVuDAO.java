
package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Entity.JDBConnection;



public class BanGiaoVuDAO {
	public static final int MYSQL_DUPLICATE_PK = 2627;
	Scanner input = new Scanner(System.in);

	public void dKBGV(Connection conn) {
		Statement st = null;
		do {
			try {
				st = conn.createStatement();
				String maGiaoVu = inputMa("Nhập Mã Giáo Vụ: ");
				String matKhau = inputMK("Nhập Mật Khẩu: ");
				String sql = "INSERT INTO BANGIAOVU VALUES ('" + maGiaoVu + "', '" + matKhau + "');";
				st.executeUpdate(sql);
				System.out.println("Bạn Đã Đăng Ký Thành Công Tài Khoản Mới");
				return;
			} catch (SQLException e) {
				if(e.getErrorCode() == MYSQL_DUPLICATE_PK ){
					System.out.println("Mã Giáo Vụ Đã Tồn Tại, Bạn Vui Lòng Nhập Mã Khác");
			    }
			} catch (Exception e) {
				System.out.println("Đã Xảy Ra Lỗi");
			} finally {
				JDBConnection.closeConnection(null, st, null);
			}
		} while (true);
	}

	public void dNBGV(Connection conn) {
		LopHocDAO a = new LopHocDAO();
		Statement st = null;
		ResultSet rs = null;
		do {
			try {
				st = conn.createStatement();
				System.out.println("Đăng Nhập Mã Giáo Vụ: ");
				String m = input.nextLine();
				System.out.println("Đăng Nhập Mật Khẩu: ");
				String mk = input.nextLine();
				String sql = "SELECT * FROM BANGIAOVU WHERE MAGIAOVU = '" + m + "' AND MATKHAU = '" + mk + "';";
				rs = st.executeQuery(sql);
				if (!rs.isBeforeFirst()) {
					System.out.println("Tài Khoản Không Tồn Tại, Bạ Vui Lòng Đăng Nhập Lại");
					System.out.println("--------------------------");
				} else {
					System.out.println("Bạn Đã Đăng Nhập Thành Công");
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Đã Xảy Ra Lỗi");
			} finally {
				JDBConnection.closeConnection(null, st, rs);
			}
		} while (true);
	}
	

	public String inputMa(String message) {
		do {
			System.out.println(message);
			String m = input.nextLine();
			if (m.length() == 5) {
				return m;
			} else {
				System.out.println("Bạn Hãy Nhập Đúng 5 Ký Tự");
			}
		} while (true);
	}
	public String inputMK(String message) {
		do {
			System.out.println(message);
			String mk = input.nextLine();
			if (mk.length() >= 5 && mk.length() <= 15) {
				return mk;
			} else {
				System.out.println("Bạn Vui Lòng Nhập Mật Khẩu Từ 5 Đến 15 Ký Tự");
			}
		} while (true);
	}


}
