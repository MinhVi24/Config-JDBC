package Entity;

import java.sql.Connection;
import java.util.Scanner;

import Dao.BanGiaoVuDAO;
import Dao.LopHocDAO;
import Dao.NguoiDangKyDAO;


public class LopHocManagement {
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc3 = new Scanner(System.in);
	static Scanner sc4 = new Scanner(System.in);
	static Scanner sc5 = new Scanner(System.in);
	static Scanner sc6 = new Scanner(System.in);

	public static void main(String[] args) {
		BanGiaoVuDAO bGV = new BanGiaoVuDAO();
		LopHocDAO gV = new LopHocDAO();
		NguoiDangKyDAO nDK = new NguoiDangKyDAO();
		Connection conn = JDBConnection.getConnection();
		do {

			System.out.println("-------------------------------------");
			System.out.println("ỨNG DỤNG ĐĂNG KÝ HỌC NĂNG KHIẾU CHO TRẺ TỪ 5 - 15 TUỔI");
			System.out.println();
			System.out.println("1. Ban Giáo Vụ");
			System.out.println("2. Phụ Huynh");
			System.out.println("-------------------------------------");
			String choice = sc.nextLine();
			outer: switch (choice) {
			case "1":
				do {
					System.out.println("1. Đăng Ký Tài Khoản Mới");
					System.out.println("2. Đăng Nhập (Trường Hợp Bạn Đã Có Tài Khoản)");
					System.out.println("0. Thoát");
					String choice2 = sc2.nextLine();
					outer1: switch (choice2) {
					case "1":
						bGV.dKBGV(conn);
						break;
					case "2":
						bGV.dNBGV(conn);
						break;
					case "0":
						break outer;
					default:
						break;
					}
					do {
						System.out.println("---------------------------");
						System.out.println("1. Thêm, Sửa, Xóa Thông Tin Môn Học");
						System.out.println("2. Thêm, Sửa, Xóa Thông Tin Giáo Viên");
						System.out.println("3. Thêm, Sửa, Xóa Thông Tin Lớp Học");
						System.out.println("4. Hiển Thị Toàn Bộ Thông Tin Lớp Học Có Học Viên Đăng Ký Chờ Xác Nhận");
						System.out.println("5. Sắp Xếp Theo Chiều Giảm Dần Của Số Lượng HVDK Chờ Xác Nhận");
						System.out
								.println("6. Hiển Thị Toàn Bộ Thông Tin Lớp Học Có Học Viên Đăng Ký Đã Được Xác Nhận");
						System.out.println("7. Sắp Xếp Theo Chiều Giảm Dần Của Số Lượng HVDK Đã Được Xác Nhận");
						System.out.println("8. Hiển Thị Thông Tin Cá Nhân Học Viên Đã Đăng Ký Chờ Xác Nhận");
						System.out.println("9. Xác Nhận Trạng Thái Của Từng Học Viên");
						System.out.println("10. Xác Nhận Trạng Thái Của Toàn Bộ Học Viên");
						System.out.println("11. Hiển Thị Thông Tin Cá Nhân Học Viên Đã Được Xác Nhận");
						System.out.println("12. Xóa Thông Tin Học Viên Đăng Ký Đang Chờ Xác Nhận");
						System.out.println("13. Xóa Thông Tin Học Viên Đăng Ký Đã Được Xác Nhận");
						System.out.println("0. Thoát");
						String choice4 = sc4.nextLine();
						outer1: switch (choice4) {
						case "1":
							do {
								System.out.println("1. Thêm Thông Tin Môn Học");
								System.out.println("2. Sửa Thông Tin Môn Học");
								System.out.println("3. Xóa Thông Tin Môn Học");
								System.out.println("0. Thoát");
								String choice6 = sc6.nextLine();
								switch (choice6) {
								case "1":
									gV.insertMonHoc(conn);
									break;
								case "2":
									gV.updateMonHoc(conn);
									break;
								case "3":
									gV.deleteMonHoc(conn);
									break;
								case "0":
									break outer1;
								default:
									break;
								}
							} while (true);
						case "2":
							do {
								System.out.println("1. Thêm Thông Tin Giáo Viên");
								System.out.println("2. Sửa Thông Tin Giáo Viên");
								System.out.println("3. Xóa Thông Tin Giáo Viên");
								System.out.println("0. Thoát");
								String choice6 = sc6.nextLine();
								switch (choice6) {
								case "1":
									gV.insertGiaoVien(conn);
									break;
								case "2":
									gV.updateGiaoVien(conn);
									break;
								case "3":
									gV.deleteGiaoVien(conn);
									break;
								case "0":
									break outer1;
								default:
									break;
								}

							} while (true);

						case "3":
							do {
								System.out.println("1. Thêm Thông Tin Lớp Học");
								System.out.println("2. Sửa Thông Tin Lớp Học");
								System.out.println("3. Xóa Thông Tin Lớp Học");
								System.out.println("0. Thoát");
								String choice6 = sc6.nextLine();
								switch (choice6) {
								case "1":
									gV.insertLopHoc(conn);
									break;
								case "2":
									gV.updateLopHoc(conn);
									break;
								case "3":
									gV.deleteLopHoc(conn);
									break;
								case "0":
									break outer1;
								default:
									break;
								}

							} while (true);
						case "4":
							gV.displayAllChoXacNhan(conn);
							break;
						case "5":
							gV.sortAllChoXacNhan(conn);
							break;
						case "6":
							gV.displayAllDaXacNhan(conn);
							break;
						case "7":
							gV.sortAllDaXacNhan(conn);
							break;
						case "8":
							gV.displayHocVienDaDK(conn);
							break;
						case "9":
							gV.updateHVToXacNhan(conn);
							break;
						case "10":
							gV.updateAllToXacNhan(conn);
							break;
						case "11":
							gV.displayHocVienDaXN(conn);
							break;
						case "12":
							gV.deleteHocVienChoXN(conn);
							break;
						case "13":
							gV.deleteHocVienDaXN(conn);
							break;
						case "0":
							break outer;
						default:
							break;
						}
					} while (true);
				} while (true);

			case "2":
				do {
					System.out.println(
							"1. Hiển Thị Thông Tin Các Lớp Học Có Thể Đăng Ký (Không Vượt Quá 2 Tuần So Với Ngày Khai Giảng)");
					System.out.println("2. Đăng Ký Môn Học Lớp Năng Khiếu");
					System.out.println("3. Tìm Kiếm Thông Tin Đã Đăng Ký (Hiển Thị Những Lớp Học Đã Đăng Ký Và Tổng Học Phí");
					System.out.println("4. Sửa Thông Tin Học Viên Đã Đăng Ký");
					System.out.println("5. Xóa Thông Tin Học Viên và Môn Học Đã Đăng Ký (Trạng Thái Chờ Xác Nhận)");
					System.out.println("0. Thoát");
					String choice5 = sc5.nextLine();
					switch (choice5) {
					case "1":
						nDK.displayLopHocDK(conn);
						break;
					case "2":
						nDK.insertHocVienDK(conn);
						break;
					case "3":
						nDK.findHocVienDK(conn);
						break;
					case "4":
						nDK.updateTTHocVien(conn);
						break;
					case "5":
						nDK.deleteHocVienvaLopHoc(conn);
						break;
					case "0":
						break outer;
					default:
						break;
					}
				} while (true);
			default:
				break;
			}
		} while (true);

	}

}
