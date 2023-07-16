
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Entity.JDBConnection;
import Entity.LopHoc;
import Entity.NguoiDangKy;

public class LopHocDAO {
	Scanner input = new Scanner(System.in);

	public void insertMonHoc(Connection conn) {
		Statement st = null;
		try {
			st = conn.createStatement();
			String maMonHoc = inputMa("Nhập Mã Môn Học: ");
			System.out.println("Nhập Tên Môn Học: ");
			String tenMonHoc = input.nextLine();
			System.out.println("Nhập Học Phí: ");
			int hocPhi = Integer.parseInt(input.nextLine());
			String sql = "INSERT INTO MONHOC VALUES ('" + maMonHoc + "', N'" + tenMonHoc + "', '" + hocPhi + "');";
			int up = st.executeUpdate(sql);
			if (up != 0) {
				System.out.println("Bạn Đã Thêm Môn Học Thành Công");
			} else {
				System.out.println("Thêm Môn Học Không Thành Công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Nhập Sai Format Học Phí");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, null);
		}
	}

	public void updateMonHoc(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String maMonHoc = inputMa("Nhập Mã Môn Học Bạn Muốn Update: ");
			String sql = "SELECT * FROM MONHOC WHERE MAMONHOC = '" + maMonHoc + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				System.out.println("Nhập Thông Tin UPDATE");
				System.out.println("---------------------");
				System.out.println("Nhập Tên Môn Học: ");
				String tenMonHoc = input.nextLine();
				System.out.println("Nhập Học Phí: ");
				int hocPhi = Integer.parseInt(input.nextLine());
				String sql2 = "UPDATE MONHOC SET TENMONHOC = '" + tenMonHoc + "', HOCPHI = '" + hocPhi
						+ "' WHERE MAMONHOC = '" + maMonHoc + "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Update Thành Công");
				} else {
					System.out.println("Update Không Thành Công");
				}
			} else {
				System.out.println("Không Có Môn Học Bạn Muốn Update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void deleteMonHoc(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String maMonHoc = inputMa("Nhập Mã Môn Học Bạn Muốn Xóa: ");
			String sql = "SELECT * FROM MONHOC WHERE MAMONHOC = '" + maMonHoc + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				String sql2 = "DELETE FROM MONHOC WHERE MAMONHOC '" + maMonHoc + "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Xóa Thông Tin Thành Công");
				} else {
					System.out.println("Xóa Thông Tin Không Thành Công");
				}
			} else {
				System.out.println("Không Có Mã Môn Học Bạn Muốn Xóa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void insertGiaoVien(Connection conn) {
		Statement st = null;
		try {
			st = conn.createStatement();
			String maGiaoVien = inputMa("Nhập Mã Giáo Viên: ");
			System.out.println("Nhập Tên Giáo Viên: ");
			String tenGiaoVien = input.nextLine();
			String maMonHoc = inputMa("Nhập Mã Môn Học: ");
			String sql = "INSERT INTO GIAOVIEN VALUES ('" + maGiaoVien + "', N'" + tenGiaoVien + "', '" + maMonHoc
					+ "');";
			int up = st.executeUpdate(sql);
			if(up != 0) {
				System.out.println("Bạn Đã Thêm Giáo Viên Thành Công");
			} else {
				System.out.println("Thêm Giáo Viên Không Thành Công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, null);
		}
	}

	public void updateGiaoVien(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String maGiaoVien = inputMa("Nhập Mã Giáo Viên Bạn Muốn Update: ");
			String sql = "SELECT * FROM GIAOVIEN WHERE MAGIAOVIEN = '" + maGiaoVien + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				System.out.println("Nhập Thông Tin UPDATE");
				System.out.println("---------------------");
				System.out.println("Nhập Tên Giáo Viên: ");
				String tenGiaoVien = input.nextLine();
				String maMonHoc = inputMa("Nhập Mã Môn Học: ");
				String sql2 = "UPDATE MONHOC SET TENGIAOVIEN = '" + tenGiaoVien + "', MAMONHOC = '" + maMonHoc
						+ "' WHERE MAGIAOVIEN = '" + maGiaoVien + "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Update Thành Công");
				} else {
					System.out.println("Update Không Thành Công");
				}
			} else {
				System.out.println("Không Có Mã Giáo Viên Bạn Muốn Update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void deleteGiaoVien(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String maGiaoVien = inputMa("Nhập Mã Giáo Viên Bạn Muốn Xóa: ");
			String sql = "SELECT * FROM GIAOVIEN WHERE MAGIAOVIEN = '" + maGiaoVien + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				String sql2 = "DELETE FROM GIAOVIEN WHERE MAGIAOVIEN '" + maGiaoVien + "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Xóa Thông Tin Thành Công");
				} else {
					System.out.println("Xóa Thông Tin Không Thành Công");
				}
			} else {
				System.out.println("Không Có Mã Giáo Viên Bạn Muốn Xóa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void insertLopHoc(Connection conn) {
		Statement st = null;
		try {
			st = conn.createStatement();
//			String maLopHoc = inputMa("Nhập Mã Lớp: ");
			String maLopHoc = checkDTBLH();
			System.out.println("Nhập Phòng Học: ");
			String phongHoc = input.nextLine();
			System.out.println("Nhập Số Buổi: ");
			String soBuoi = input.nextLine();
			Date ngayKhaiGiang = inputDate("Nhập Ngày Khai Giảng: ");
			System.out.println("Nhập Thời Gian Học: ");
			String thoiGianHoc = input.nextLine();
			System.out.println("Nhập Giờ Học: ");
			String gioHoc = input.nextLine();
			System.out.println("Nhập Số Lượng Tối Đa: ");
			int sLToiDa = Integer.parseInt(input.nextLine());
			int sLDaDangKy = 0;
//			String maGiaoVien = inputMa("Nhập Mã Giáo Viên: ");
			String maGiaoVien = checkDTBLGV();
//			String maMonHoc = inputMa("Nhập Mã Môn Học: ");
			String maMonHoc = checkDTBLMH();
			String sql = "INSERT INTO LOPHOC VALUES ('" + maLopHoc + "', N'" + phongHoc + "', N'" + soBuoi + "', " + "'"
					+ ngayKhaiGiang + "', N'" + thoiGianHoc + "', " + "'" + gioHoc + "', '" + sLToiDa + "', '"
					+ sLDaDangKy + "', '" + maGiaoVien + "', '" + maMonHoc + "');";
			int up = st.executeUpdate(sql);
			if (up != 0) {
				System.out.println("Bạn Đã Thêm Lớp Học Thành Công");
			} else {
				System.out.println("Thêm Lớp Học Không Thành Công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Bạn Hãy Nhập Đúng Format Số Nguyên");
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Hệ Thống");
		} finally {
			JDBConnection.closeConnection(null, st, null);
		}
	}

	public void updateLopHoc(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String maLopHoc = inputMa("Nhập Mã Lớp Học Bạn Muốn Update: ");
			String sql = "SELECT * FROM LOPHOC WHERE MALOPHOC = '" + maLopHoc + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				System.out.println("Nhập Thông Tin UPDATE");
				System.out.println("---------------------");
				System.out.println("Nhập Phòng Học: ");
				String phongHoc = input.nextLine();
				System.out.println("Nhập Số Buổi: ");
				String soBuoi = input.nextLine();
				Date ngayKhaiGiang = inputDate("Nhập Ngày Khai Giảng: ");
				System.out.println("Nhập Thời Gian Học: ");
				String thoiGianHoc = input.nextLine();
				System.out.println("Nhập Giờ Học: ");
				String gioHoc = input.nextLine();
				System.out.println("Nhập Số Lượng Tối Đa: ");
				int sLToiDa = Integer.parseInt(input.nextLine());
				int sLDaDangKy = 0;
				String maGiaoVien = inputMa("Nhập Mã Giáo Viên: ");
				String maMonHoc = inputMa("Nhập Mã Môn Học: ");
				String sql2 = "UPDATE LOPHOC SET PHONGHOC = '" + phongHoc + "', SOBUOI = '" + soBuoi
						+ "', NGAYKHAIGIANG = '" + ngayKhaiGiang + "', " + "THOIGIANHOC = '" + thoiGianHoc
						+ "', GIOHOC = '" + gioHoc + "', SLTOIDA = '" + sLToiDa + "', MAGIAOVIEN = '" + maGiaoVien
						+ "', " + "MAMONHOC = '" + maMonHoc + "', TRANGTHAI = '" + sLDaDangKy + "' WHERE MALOPHOC = '"
						+ maLopHoc + "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Update Thành Công");
				} else {
					System.out.println("Update Không Thành Công");
				}
			} else {
				System.out.println("Không Có Lớp Học Bạn Muốn Update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void deleteLopHoc(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String maLopHoc = inputMa("Nhập Mã Lớp Học Bạn Muốn Xóa: ");
			String sql = "SELECT * FROM LOPHOC WHERE MALOPHOC = '" + maLopHoc + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				String sql2 = "DELETE FROM LOPHOC WHERE MALOPHOC '" + maLopHoc + "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Xóa Thông Tin Thành Công");
				} else {
					System.out.println("Xóa Thông Tin Không Thành Công");
				}
			} else {
				System.out.println("Không Có Mã Lớp Học Bạn Muốn Xóa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void displayAllChoXacNhan(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LopHoc> lhList = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, giaovien.tengiaovien, \n"
					+ "lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc,lophoc.sltoida,\n"
					+ " monhoc.hocphi, count(*) as sohocvien\n" + "FROM Lophoc \n"
					+ "JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc\n"
					+ "JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien\n"
					+ "JOIN dangky on lophoc.malophoc = dangky.malophoc\n" + "WHERE dangky.trangthai = '0'\n"
					+ "GROUP BY lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, \n"
					+ "giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang,\n"
					+ "lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi;";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					LopHoc lHoc = new LopHoc(rs.getString("maLopHoc"), rs.getString("maMonHoc"),
							rs.getString("tenMonHoc"), rs.getString("maGiaoVien"), rs.getString("tenGiaoVien"),
							rs.getString("phongHoc"), rs.getString("soBuoi"), rs.getDate("ngayKhaiGiang"),
							rs.getString("thoiGianHoc"), rs.getString("gioHoc"), rs.getInt("sLToiDa"),
							rs.getInt("sohocvien"), rs.getInt("hocPhi"));
					lhList.add(lHoc);
				}
			} else {
				System.out.println("Không Có Thông Tin Lớp Học Có Học Viên Đã Đăng Ký Chờ Xác Nhận");
			}
			for (int i = 0; i < lhList.size(); i++) {
				System.out.println(lhList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Hệ Thống");
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void sortAllChoXacNhan(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LopHoc> lhList = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, giaovien.tengiaovien, \n"
					+ "lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc,lophoc.sltoida,\n"
					+ " monhoc.hocphi, count(*) as sohocvien\n" + "FROM Lophoc \n"
					+ "JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc\n"
					+ "JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien\n"
					+ "JOIN dangky on lophoc.malophoc = dangky.malophoc\n" + "WHERE dangky.trangthai = '0'\n"
					+ "GROUP BY lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, \n"
					+ "giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang,\n"
					+ "lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi\n" + "ORDER BY sohocvien desc;";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					LopHoc lHoc = new LopHoc(rs.getString("maLopHoc"), rs.getString("maMonHoc"),
							rs.getString("tenMonHoc"), rs.getString("maGiaoVien"), rs.getString("tenGiaoVien"),
							rs.getString("phongHoc"), rs.getString("soBuoi"), rs.getDate("ngayKhaiGiang"),
							rs.getString("thoiGianHoc"), rs.getString("gioHoc"), rs.getInt("sLToiDa"),
							rs.getInt("sohocvien"), rs.getInt("hocPhi"));
					lhList.add(lHoc);
				}
			} else {
				System.out.println("Không Có Thông Tin Lớp Học Có Học Viên Đã Đăng Ký Chờ Xác Nhận");
			}
			for (int i = 0; i < lhList.size(); i++) {
				System.out.println(lhList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Hệ Thống");
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void displayAllDaXacNhan(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LopHoc> lhList = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, giaovien.tengiaovien, \n"
					+ "lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc,lophoc.sltoida,\n"
					+ " monhoc.hocphi, count(*) as sohocvien\n" + "FROM Lophoc \n"
					+ "JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc\n"
					+ "JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien\n"
					+ "JOIN dangky on lophoc.malophoc = dangky.malophoc\n" + "WHERE dangky.trangthai = '1'\n"
					+ "GROUP BY lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, \n"
					+ "giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang,\n"
					+ "lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi;";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					LopHoc lHoc = new LopHoc(rs.getString("maLopHoc"), rs.getString("maMonHoc"),
							rs.getString("tenMonHoc"), rs.getString("maGiaoVien"), rs.getString("tenGiaoVien"),
							rs.getString("phongHoc"), rs.getString("soBuoi"), rs.getDate("ngayKhaiGiang"),
							rs.getString("thoiGianHoc"), rs.getString("gioHoc"), rs.getInt("sLToiDa"),
							rs.getInt("sohocvien"), rs.getInt("hocPhi"));
					lhList.add(lHoc);
				}
			} else {
				System.out.println("Không Có Thông Tin Lớp Học Có Học Viên Đã Được Xác Nhận");
			}
			for (int i = 0; i < lhList.size(); i++) {
				System.out.println(lhList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Hệ Thống");
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void sortAllDaXacNhan(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<LopHoc> lhList = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, giaovien.tengiaovien, \n"
					+ "lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang, lophoc.thoigianhoc, lophoc.giohoc,lophoc.sltoida,\n"
					+ " monhoc.hocphi, count(*) as sohocvien\n" + "FROM Lophoc \n"
					+ "JOIN monhoc on lophoc.mamonhoc = monhoc.mamonhoc\n"
					+ "JOIN giaovien on lophoc.magiaovien = giaovien.magiaovien\n"
					+ "JOIN dangky on lophoc.malophoc = dangky.malophoc\n" + "WHERE dangky.trangthai = '1'\n"
					+ "GROUP BY lophoc.malophoc, monhoc.mamonhoc, monhoc.tenmonhoc, giaovien.magiaovien, \n"
					+ "giaovien.tengiaovien, lophoc.phonghoc, lophoc.sobuoi, lophoc.ngaykhaigiang,\n"
					+ "lophoc.thoigianhoc, lophoc.giohoc, lophoc.sltoida, monhoc.hocphi\n" + "ORDER BY sohocvien desc;";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					LopHoc lHoc = new LopHoc(rs.getString("maLopHoc"), rs.getString("maMonHoc"),
							rs.getString("tenMonHoc"), rs.getString("maGiaoVien"), rs.getString("tenGiaoVien"),
							rs.getString("phongHoc"), rs.getString("soBuoi"), rs.getDate("ngayKhaiGiang"),
							rs.getString("thoiGianHoc"), rs.getString("gioHoc"), rs.getInt("sLToiDa"),
							rs.getInt("sohocvien"), rs.getInt("hocPhi"));
					lhList.add(lHoc);
				}
			} else {
				System.out.println("Không Có Thông Tin Lớp Học Có Học Viên Đã Được Xác Nhận");
			}
			for (int i = 0; i < lhList.size(); i++) {
				System.out.println(lhList.get(i));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Đã Xảy Ra Lỗi Hệ Thống");
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void displayHocVienDaDK(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<NguoiDangKy> dkList = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT nguoidangky.hotenhv, nguoidangky.sdt, nguoidangky.diachi, nguoidangky.ngaysinh, nguoidangky.email, \n"
					+ "nguoidangky.hotenph, dangky.malophoc, dangky.trangthai\n" + "FROM NguoiDangKy\n"
					+ "JOIN DangKy ON nguoidangky.hotenhv = dangky.hotenhv AND nguoidangky.sdt = dangky.sdt\n"
					+ "WHERE TrangThai = '0';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					NguoiDangKy hV = new NguoiDangKy(rs.getString("hoTenHV"), rs.getString("sDT"),
							rs.getString("diaChi"), rs.getDate("ngaySinh"), rs.getString("email"),
							rs.getString("hoTenPH"), rs.getString("maLopHoc"), rs.getString("trangThai"));
					dkList.add(hV);
				}
			} else {
				System.out.println("Không Có Thông Tin Học Viên Cần Xác Nhận");
			}

			for (int i = 0; i < dkList.size(); i++) {
				System.out.println(dkList.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}
	}

	public void updateAllToXacNhan(Connection conn) {
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "update dangky set trangthai = '1' where trangthai = '0';";
			int up = st.executeUpdate(sql);
			if (up != 0) {
				System.out.println("Bạn Đã Xác Nhận Thành Công");
			} else {
				System.out.println("Xác Nhận Không Thành Công");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, null);
		}
	}

	public void updateHVToXacNhan(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String hoTenHV = inputTen("Nhập Họ và Tên Học Viên: ");
			System.out.println("Nhập Số Điện Thoại Của Học Viên: ");
			String sDT = input.nextLine();
			String sql = "SELECT * FROM DANGKY WHERE HOTENHV = '" + hoTenHV + "' AND SDT = '" + sDT + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				String sql2 = "Update Dangky set Trangthai = '1' Where Trangthai = '0' And HotenHV = '" + hoTenHV
						+ "' And SDT = '" + sDT + "';";
				int up = st.executeUpdate(sql2);
				if (up != 0) {
					System.out.println("Bạn Đã Xác Nhận Thành Công");
				} else {
					System.out.println("Xác Nhận Không Thành Công");
				}
			} else {
				System.out.println("Không Có Thông Tin Bạn Muốn Update");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}

	}

	public void displayHocVienDaXN(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		ArrayList<NguoiDangKy> hVXN = new ArrayList<>();
		try {
			st = conn.createStatement();
			String sql = "SELECT nguoidangky.hotenhv, nguoidangky.sdt, nguoidangky.diachi, nguoidangky.ngaysinh, nguoidangky.email, \n"
					+ "nguoidangky.hotenph, dangky.malophoc, dangky.trangthai\n" + "FROM NguoiDangKy\n"
					+ "JOIN DangKy ON nguoidangky.hotenhv = dangky.hotenhv\n"
					+ "JOIN DangKy ON nguoidangky.sdt = dangky.sdt\n" + "WHERE TrangThai = '1';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					NguoiDangKy a = new NguoiDangKy(rs.getString("hoTenHV"), rs.getString("sDT"),
							rs.getString("diaChi"), rs.getDate("ngaySinh"), rs.getString("email"),
							rs.getString("hoTenPH"), rs.getString("maLopHoc"), rs.getString("trangThai"));
					hVXN.add(a);
				}
				for (int i = 0; i < hVXN.size(); i++) {
					System.out.println(hVXN.get(i));
				}
			} else {
				System.out.println("Không Có Thông Tin Học Viên Đã Được Xác Nhận");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}

	}

	public void deleteHocVienChoXN(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String hoTenHV = inputTen("Nhập Họ và Tên Học Viên: ");
			System.out.println("Nhập Số Điện Thoại Của Học Viên: ");
			String sDT = input.nextLine();
			String sql = "SELECT * FROM NGUOIDANGKY WHERE hoTenHV = '" + hoTenHV + "' AND sDT = '" + sDT + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				System.out.println("Thong tin hoc vien:");
				System.out.println(
						rs.getString("hoTenHV") + " | " + rs.getString("sDT") + " | " + rs.getString("hoTenPH"));
				System.out.println("---------------------------");
				System.out.println("1. Xóa Học Viên");
				System.out.println("0. Thoát");
				String choice = input.nextLine();
				switch (choice) {
				case "1":
					String sql2 = "DELETE FROM DANGKY WHERE HOTENHV = '" + hoTenHV + "' AND SDT = '" + sDT
							+ "' AND TRANGTHAI = '0';";
					int up1 = st.executeUpdate(sql2);
					if (up1 != 0) {

						String sql3 = "DELETE FROM NGUOIDANGKY WHERE HOTENHV = '" + hoTenHV + "' AND SDT = '" + sDT
								+ "';";
						int up2 = st.executeUpdate(sql3);
						if (up1 != 0 && up2 != 0) {
							System.out.println("Bạn Đã Xóa Thông Tin Thành Công");
						} else {
							System.out.println("Xóa Không Thành Công");
						}
					}
				case "0":
					break;
				default:
					break;
				}
			} else {
				System.out.println("Không Có Thông Tin Học Viên Bạn Muốn Xóa");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}

	}

	public void deleteHocVienDaXN(Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String hoTenHV = inputTen("Nhập Họ và Tên Học Viên: ");
			System.out.println("Nhập Số Điện Thoại Của Học Viên: ");
			String sDT = input.nextLine();
			String sql = "SELECT * FROM NGUOIDANGKY WHERE hoTenHV = '" + hoTenHV + "' AND sDT = '" + sDT + "';";
			rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				rs.next();
				System.out.println("Thong tin hoc vien:");
				System.out.println(
						rs.getString("hoTenHV") + " | " + rs.getString("sDT") + " | " + rs.getString("hoTenPH"));
				System.out.println("---------------------------");
				System.out.println("1. Xóa Học Viên");
				System.out.println("0. Thoát");
				String choice = input.nextLine();
				switch (choice) {
				case "1":
					String sql2 = "DELETE FROM DANGKY WHERE HOTENHV = '" + hoTenHV + "' AND SDT = '" + sDT
							+ "' AND TRANGTHAI = '1';";
					int up1 = st.executeUpdate(sql2);
					if (up1 != 0) {

						String sql3 = "DELETE FROM NGUOIDANGKY WHERE HOTENHV = '" + hoTenHV + "' AND SDT = '" + sDT
								+ "';";
						int up2 = st.executeUpdate(sql3);
						if (up1 != 0 && up2 != 0) {
							System.out.println("Bạn Đã Xóa Thông Tin Thành Công");
						} else {
							System.out.println("Xóa Không Thành Công");
						}
					}
				case "0":
					break;
				default:
					break;
				}
			} else {
				System.out.println("Không Có Thông Tin Học Viên Bạn Muốn Xóa");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBConnection.closeConnection(null, st, rs);
		}

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

	public Date inputDate(String message) {
		do {
			try {
				System.out.println(message);
				Date aDate = Date.valueOf(input.nextLine());
				return aDate;
			} catch (IllegalArgumentException e) {
				System.out.println("Bạn Đã Nhập Sai Format (YYYY-MM-DD)");
			} catch (Exception e) {
				System.out.println("Đã Xảy Ra Lỗi");
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

	public String checkDTBLH(){
        int Count=0;
        int k = 1;
        String Dulieu=null;
        do {
            try {
                Connection conn = JDBConnection.getConnection();
                Statement stmt = conn.createStatement();
                System.out.print("Nhập Mã lớp muốn Thêm: ");
                Dulieu = input.nextLine();
                String sql = " SELECT COUNT(MALOPHOC)AS HI FROM LOPHOC WHERE MALOPHOC ='" + Dulieu + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Count = rs.getInt("HI");
                }
                if (Count == k) {
                    System.out.println("Lớp học muốn thêm đã có trong Database, Vui lòng nhập lại ");
                } else {
                    break;
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (IllegalArgumentException se) {
                System.out.println("incorrect format");
                Count = k;
            } catch (Exception e) {
                System.out.println("Exception e");
                Count = k;
            }
        } while (Count == k);
        return Dulieu;
    }
    public String checkDTBLGV(){
        int Count=0;
        int k = 0;
        String Dulieu = null;
        do {
            try {
                Connection conn = JDBConnection.getConnection();
                Statement stmt = conn.createStatement();
                System.out.print("Nhập MaGV : ");
                Dulieu = input.nextLine();
                String sql = " SELECT COUNT(MAGIAOVIEN) AS HI FROM GIAOVIEN WHERE MAGIAOVIEN ='" + Dulieu + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Count = rs.getInt("HI");
                }
                if (Count == k) {
                    System.out.println("Mã Giáo Viên Bạn Thêm Không Đúng, Vui lòng nhập lại");
                } else {
                    break;
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (IllegalArgumentException se) {
                System.out.println("incorrect format");
                Count = k;
            } catch (Exception e) {
                System.out.println("Exception e");
                Count = k;
            }
        } while (Count == k);
        return Dulieu;  
    }
    public String checkDTBLMH(){
        int Count=0;
        int k = 0;
        String Dulieu= null;
        do {
            try {
                Connection conn = JDBConnection.getConnection();
                Statement stmt = conn.createStatement();
                System.out.print("Nhập MaMH : ");
                Dulieu = input.nextLine();
                String sql = " SELECT COUNT(MAMONHOC) AS HI FROM MONHOC WHERE MAMONHOC ='" + Dulieu + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Count = rs.getInt("HI");
                }
                if (Count == k) {
                    System.out.println(
                            "Mã Môn Học Bạn Thêm Không Đúng, Vui lòng nhập lại ");
                } else {
                    break;
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (IllegalArgumentException se) {
                System.out.println("incorrect format");
                Count = k;
            } catch (Exception e) {
                System.out.println("Exception e");
                Count = k;
            }
        } while (Count == k);
        return Dulieu;  
    }
    public String checkDTBDK(){
        int Count=0;
        int k = 0;
        String Dulieu= null;
        do {
            try {
                Connection conn = JDBConnection.getConnection();
                Statement stmt = conn.createStatement();
                System.out.print("Nhập SDT Học Viên muốn Thay đổi Trạng Thái: ");
                Dulieu = input.nextLine();
                String sql = " SELECT COUNT(SDT) AS HI FROM DANGKY WHERE SDT ='" + Dulieu + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Count = rs.getInt("HI");
                }
                if (Count == k) {
                    System.out.println(
                            "SDT Học Viên muốn Thay đổi KHÔNG tồn tại trong Database ");
                } else {
                    break;
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (IllegalArgumentException se) {
                System.out.println("incorrect format");
                Count = k;
            } catch (Exception e) {
                System.out.println("Exception e");
                Count = k;
            }
        } while (Count == k);
        return Dulieu;
    }

}
