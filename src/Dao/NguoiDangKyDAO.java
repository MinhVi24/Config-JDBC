
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

import Entity.JDBConnection;
import Entity.LopHoc;

public class NguoiDangKyDAO {
	static Scanner input = new Scanner(System.in);

	public void displayLopHocDK(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LopHoc> lHList = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT monhoc.tenmonhoc, giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi\n"
					+ "FROM Lophoc \n" + "JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc\n"
					+ "JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien\n"
					+ "WHERE NGAYKHAIGIANG > (getDATE() - 7*2)";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				LopHoc a = new LopHoc(rs.getString("tenMonHoc"), rs.getString("tenGiaoVien"), rs.getString("phongHoc"),
						rs.getString("soBuoi"), rs.getDate("ngayKhaiGiang"), rs.getString("thoiGianHoc"),
						rs.getString("gioHoc"), rs.getInt("hocPhi"));
				lHList.add(a);
			}

			for (int i = 0; i < lHList.size(); i++) {
				System.out.println(lHList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi");
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}

	}

	public void insertHocVienDK(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String hoTenHV = inputTen("Nhập Họ và Tên Học Viên: ");
			String sDT = inputSDT(conn, "Nhập Số Điện Thoại Của Học Viên: ");
			System.out.println("Nhập Địa Chỉ Học Viên: ");
			String diaChi = input.nextLine();
//			Date ngaySinh = inputNgaySinh(conn, "Nhập Ngày Sinh Của Học Viên: ");
			Date ngaySinh = inputDate("Nhập Ngày Sinh Của Học Viên: ");
			String sql = "SELECT * FROM NGUOIDANGKY WHERE '" + ngaySinh + "' < (getDate() - 5*365) AND '" + ngaySinh
					+ "' > (getDate() - 15*365);";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();

			} else {
				System.out.println("Tuổi Của Bé Nằm Ngoài Độ Tuổi Quy Định Là Từ 5 Đến 15 Tuổi");
				System.out.println("0. Thoát");
				String choice = input.nextLine();
				switch (choice) {
				case "0":
					return;
				}
			}

			String email = inputEmail(conn, "Nhập Email: ");
			String hoTenPH = inputTen("Nhập Họ và Tên Phụ Huynh: ");
			String sql1 = "INSERT INTO NGUOIDANGKY VALUES ('" + hoTenHV + "', '" + sDT + "', '" + diaChi + "', '"
					+ ngaySinh + "', '" + email + "', '" + hoTenPH + "');";
			st.executeUpdate(sql1);
			do {
				String sql2 = "SELECT hoTenHV, sDT FROM NGUOIDANGKY WHERE hoTenHV = '" + hoTenHV + "' AND sDT = '" + sDT
						+ "';";
				rs = st.executeQuery(sql2);
				if (rs.isBeforeFirst()) {
					rs.next();
					String maLopHoc = inputMaLopHoc("Bạn Hãy Chọn Mã Lớp Học Muốn Đăng Ký: ");
					String trangThai = "0";
					String sql3 = "INSERT INTO DANGKY VALUES ('" + rs.getString("hoTenHV") + "', '"
							+ rs.getString("sDT") + "', '" + maLopHoc + "', '" + trangThai + "');";
					int up = st.executeUpdate(sql3);
					if (up != 0) {
						System.out.println("Bạn Đã Đăng Ký Thành Công, Xin Chờ Xác Nhận Từ Ban Giáo Vụ");
						System.out.println("Bạn Có Muốn Đăng Ký Thêm Lớp Học Khác Không?");
						System.out.println("1. Có");
						System.out.println("2. Không");
						String choice = input.nextLine();
						switch (choice) {
						case "1":
							break;
						case "2":
							return;
						default:
							return;
						}
					} else {
						System.out.println("Bạn Chưa Đăng Ký Thành Công");
					}
				}
			} while (true);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void updateTTHocVien(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String hoTenHV = inputTen("Nhập Họ và Tên Học Viên: ");
			System.out.println("Nhập Số Điện Thoại Của Học Viên: ");
			String sDT = input.nextLine();
			String sql = "SELECT hoTenHV, sDT FROM NGUOIDANGKY WHERE hoTenHV = '" + hoTenHV + "' AND sDT = '" + sDT
					+ "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				System.out.println("Nhập Thông Tin Update Của Học Viên");
				System.out.println("----------------------------------");
				System.out.println("Nhập Địa Chỉ Học Viên: ");
				String diaChi = input.nextLine();
				Date ngaySinh = inputNgaySinh(conn, "Nhập Ngày Sinh Của Học Viên: ");
				String email = inputEmail(conn, "Nhập Email: ");
				String hoTenPH = inputTen("Nhập Họ và Tên Phụ Huynh: ");
				String sql2 = "UPDATE NGUOIDANGKY SET DIACHI = '" + diaChi + "', NGAYSINH = '" + ngaySinh
						+ "', EMAIL = '" + email + "', HOTENPH = '" + hoTenPH + "'" + "WHERE HOTENHV = '" + hoTenHV
						+ "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Update Thành Công");
				} else {
					System.out.println("Update Không Thành Công");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void deleteHocVienvaLopHoc(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String hoTenHV = inputTen("Nhập Họ và Tên Học Viên: ");
			System.out.println("Nhập Số Điện Thoại Của Học Viên: ");
			String sDT = input.nextLine();
			String sql = "SELECT hoTenHV, sDT FROM NGUOIDANGKY WHERE hoTenHV = '" + hoTenHV + "' AND sDT = '" + sDT
					+ "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				String sql2 = "DELETE FROM DANGKY WHERE HOTENHV = '" + hoTenHV + "' AND TRANGTHAI = '0';";
				int up1 = st.executeUpdate(sql2);
				if (up1 != 0) {

					String sql3 = "DELETE FROM NGUOIDANGKY WHERE HOTENHV = '" + hoTenHV + "';";
					int up2 = st.executeUpdate(sql3);
					if (up1 != 0 && up2 != 0) {
						System.out.println("Bạn Đã Xóa Thông Tin Thành Công");
					} else {
						System.out.println("Xóa Không Thành Công");
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}

	}

	public void findHocVienDK(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LopHoc> fHVList = new ArrayList<>();
		try {
			st = conn.createStatement();
			String hoTenHV = inputTen("Nhập Họ và Tên Học Viên: ");
			System.out.println("Nhập Số Điện Thoại Của Học Viên: ");
			String sDT = input.nextLine();
			String sql = "SELECT dangky.hotenhv, dangky.sdt, monhoc.tenmonhoc, giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc, monhoc.hocphi\n"
					+ "FROM Lophoc \n" + "JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc\n"
					+ "JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien\n"
					+ "JOIN dangky on lophoc.malophoc = dangky.malophoc\n" + "WHERE hotenhv = '" + hoTenHV
					+ "' And sdt = '" + sDT + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					LopHoc a = new LopHoc(rs.getString("tenMonHoc"), rs.getString("tenGiaoVien"),
							rs.getString("phongHoc"), rs.getString("soBuoi"), rs.getDate("ngayKhaiGiang"),
							rs.getString("thoiGianHoc"), rs.getString("gioHoc"), rs.getInt("hocPhi"));
					fHVList.add(a);
				}
				System.out.println("Thông Tin Các Lớp Bạn Đã Đăng Ký: ");
				for (int i = 0; i < fHVList.size(); i++) {
					System.out.println(fHVList.get(i));
				}
			} else {
				System.out.println("Không Có Thông Tin Học Viên Mà Bạn Tìm Kiếm");
				System.out.println("-------------------------------------------");
			}
			JDBConnection.closeConnection(null, null, rs);

			String sql2 = "SELECT dangky.hotenhv, dangky.sdt, sum(monhoc.hocphi) as TongHocPhi\n" + "FROM DangKy\n"
					+ "JOIN LOPHOC ON DangKy.malophoc = LopHoc.malophoc\n"
					+ "JOIN GIAOVIEN ON lophoc.magiaovien = giaovien.magiaovien\n"
					+ "JOIN MONHOC ON lophoc.mamonhoc = monhoc.mamonhoc\n" + "WHERE hotenhv = '" + hoTenHV
					+ "' And sdt = '" + sDT + "'" + "GROUP BY dangky.hotenhv, dangky.sdt;";
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				System.out.println("Tổng Học Phí: ");
				System.out.println(rs.getInt("TongHocPhi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}

	}

	public void displayTongHocPhi(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "SELECT dangky.hotenhv, dangky.sdt, sum(monhoc.hocphi) as TongHocPhi\n" + "FROM DangKy\n"
					+ "JOIN LOPHOC ON DangKy.malophoc = LopHoc.malophoc\n"
					+ "JOIN GIAOVIEN ON lophoc.magiaovien = giaovien.magiaovien\n"
					+ "JOIN MONHOC ON lophoc.mamonhoc = monhoc.mamonhoc\n" + "WHERE "
					+ "GROUP BY dangky.hotenhv, dangky.sdt;";
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String inputMaLopHoc(String message) {
		do {
			System.out.println(message);
			System.out.println("1. Hội Họa _ Thứ 2, 4, 6 _ 9h30-10h30");
			System.out.println("2. Hội Họa _ Thứ 3, 5, 7 _ 9h30-10h30");
			System.out.println("3. Múa _ Thứ 3, 5 _ 8h30-9h30 ");
			System.out.println("4. Múa _ Thứ 7, CN _ 14h30-15h30 ");
			System.out.println("5. Cờ Vua _ Cả Tuần _ 16h30-17h30");
			System.out.println("6. Bóng Bàn _ Thứ 2, 4, 6 _ 15h30-16h30");
			System.out.println("7. Bóng Bàn _ Thứ 3, 5, 7 _ 15h30-16h30");
			System.out.println("9. Đã Chọn Xong");
			String choiceMH = input.nextLine();
			switch (choiceMH) {
			case "1":
				return "L0001";
			case "2":
				return "L0002";
			case "3":
				return "L0003";
			case "4":
				return "L0004";
			case "5":
				return "L0005";
			case "6":
				return "L0006";
			case "7":
				return "L0007";
			default:
				break;
			}

		} while (true);
	}

	public String inputTen(String message) {
		do {
			System.out.println(message);
			String ten = input.nextLine();
			if (ten.length() > 30) {
				System.out.println("Vui Lòng Nhập Dưới 30 Ký Tự");
			} else if (ten.isEmpty()) {
				System.out.println("Vui Lòng Nhập Thông Tin");
			} else {
				return ten;
			}
		} while (true);
	}

	public String inputSDT(Connection conn, String message) {
		Statement st = null;
		ResultSet rs = null;
		do {
			try {
				st = conn.createStatement();
				System.out.println(message);
				String so = input.nextLine();
				Pattern check = Pattern.compile("^[0-9]{10}$");
				if (check.matcher(so).find()) {
					String sql = "SELECT * FROM NGUOIDANGKY WHERE SDT = '" + so + "'";
					rs = st.executeQuery(sql);
					if (!rs.isBeforeFirst()) {
						return so;
					} else {
						System.out.println("Số Điện Thoại Đã Tồn Tại, Vui Lòng Nhập Lại");
					}
				} else {
					System.out.println("Số Điện Thoại Phải Bao Gồm 10 Số, Vui Lòng Nhập Lại");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Đã Xảy Ra Lỗi Hệ Thống");
			} finally {
				JDBConnection.closeConnection(null, st, rs);
			}
		} while (true);
	}

	public Date inputNgaySinh(Connection conn, String message) {
		Statement st = null;
		ResultSet rs = null;
		do {
			try {
				System.out.println(message);
				Date aDate = Date.valueOf(input.nextLine());
				st = conn.createStatement();
				String sql = "SELECT * FROM NGUOIDANGKY WHERE '" + aDate + "' < (getDate() - 5*365) AND '" + aDate
						+ "' > (getDate() - 15*365);";
				rs = st.executeQuery(sql);
				if (rs.isBeforeFirst()) {
					rs.next();
					return aDate;
				} else {
					System.out.println("Tuổi Của Bé Nằm Ngoài Độ Tuổi Quy Định Là Từ 5 Đến 15 Tuổi");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Bạn Đã Nhập Sai Format (YYYY-MM-DD)");
			} catch (Exception e) {
				System.out.println("Đã Xảy Ra Lỗi");
			} finally {
				JDBConnection.closeConnection(null, st, rs);
			}
		} while (true);

	}

	public void DateValidation(Date B) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -5);
		calendar.add(Calendar.MONTH, +1);
		calendar.getTime();
		String stringDate = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		calendar.add(Calendar.YEAR, -15);
		calendar.getTime();
		String stringDateEnd = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DATE);
		java.util.Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
		java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(stringDateEnd);
		if (date1.compareTo(B) < 0)
			System.out.println("Con Của Bạn Chưa Đủ tuổi Đăng Ký");
		;
		if (date2.compareTo(B) >= 0)
			System.out.println("Con Của Bạn Quá tuổi Đăng Ký");
		;
	}

	public String inputEmail(Connection conn, String message) {
		Statement st = null;
		ResultSet rs = null;
		do {
			try {
				st = conn.createStatement();
				System.out.println(message);
				String eM = input.nextLine();
				Pattern check = Pattern.compile("^(.+)@(\\S+)$");
				if (check.matcher(eM).find()) {
					String sql = "SELECT * FROM NGUOIDANGKY WHERE EMAIL = '" + eM + "';";
					rs = st.executeQuery(sql);
					if (!rs.isBeforeFirst()) {
						return eM;
					} else {
						System.out.println("Email Đã Tồn Tại, Bạn Vui Lòng Nhập Lại");
					}
				} else {
					System.out.println("Bạn Đã Nhập Sai Format, Vui Lòng Nhập Lại");
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

	public void checkNgayDK(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "SELECT * FROM LOPHOC WHERE NGAYKHAIGIANG < (getDate() - 7*2)";
			rs = st.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				return;
			} else {
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Date inputDate(String message) {
		do {
			try {
				System.out.println(message);
				Date aDate = Date.valueOf(input.nextLine());
				return aDate;
			} catch (IllegalArgumentException e) {
				System.out.println("Bạn Đã Nhập Sai Format Ngày, YYYY-MM-DD");
			} catch (Exception e) {
				System.out.println("Đã Xảy Ra Lỗi");
			}

		} while (true);
	}

}
