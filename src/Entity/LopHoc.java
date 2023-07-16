

package Entity;

import java.sql.Date;

public class LopHoc {
	private String maLopHoc;
	private String maMonHoc;
	private String tenMonHoc;
	private String maGiaoVien;
	private String tenGiaoVien;
	private String phongHoc;
	private String soBuoi;
	private Date ngayKhaiGiang;
	private String thoiGianHoc;
	private String gioHoc;
	private int sLToiDa;
	private int sLDaDangKy;
	private int hocPhi;
	public LopHoc(String maLopHoc, String maMonHoc,
			String tenMonHoc, String maGiaoVien, String tenGiaoVien, String phongHoc, String soBuoi, Date ngayKhaiGiang, String thoiGianHoc,
			String gioHoc, int sLToiDa, int sLDaDangKy, int hocPhi) {
		this.maLopHoc = maLopHoc;
		this.phongHoc = phongHoc;
		this.soBuoi = soBuoi;
		this.ngayKhaiGiang = ngayKhaiGiang;
		this.thoiGianHoc = thoiGianHoc;
		this.gioHoc = gioHoc;
		this.sLToiDa = sLToiDa;
		this.sLDaDangKy = sLDaDangKy;
		this.maGiaoVien = maGiaoVien;
		this.tenGiaoVien = tenGiaoVien;
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.hocPhi = hocPhi;
	}
	
	public LopHoc(String maMonHoc, String tenMonHoc, int hocPhi) {
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
		this.hocPhi = hocPhi;
	}

	public LopHoc(String maLopHoc, String tenMonHoc, String tenGiaoVien,
			Date ngayKhaiGiang, String thoiGianHoc, String gioHoc, int sLDaDangKy, int hocPhi) {
		this.maLopHoc = maLopHoc;
		this.tenMonHoc = tenMonHoc;
		this.tenGiaoVien = tenGiaoVien;
		this.ngayKhaiGiang = ngayKhaiGiang;
		this.thoiGianHoc = thoiGianHoc;
		this.gioHoc = gioHoc;
		this.sLDaDangKy = sLDaDangKy;
		this.hocPhi = hocPhi;
	}
	
	

	public LopHoc(String tenMonHoc, String tenGiaoVien, String phongHoc, String soBuoi, Date ngayKhaiGiang,
			String thoiGianHoc, String gioHoc, int hocPhi) {
		this.tenMonHoc = tenMonHoc;
		this.tenGiaoVien = tenGiaoVien;
		this.phongHoc = phongHoc;
		this.soBuoi = soBuoi;
		this.ngayKhaiGiang = ngayKhaiGiang;
		this.thoiGianHoc = thoiGianHoc;
		this.gioHoc = gioHoc;
		this.hocPhi = hocPhi;
	}
	

	public LopHoc(int hocPhi) {
		this.hocPhi = hocPhi;
	}

	public LopHoc() {
	}
	public String getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public String getPhongHoc() {
		return phongHoc;
	}
	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}
	public String getSoBuoi() {
		return soBuoi;
	}
	public void setSoBuoi(String soBuoi) {
		this.soBuoi = soBuoi;
	}
	public Date getNgayKhaiGiang() {
		return ngayKhaiGiang;
	}
	public void setNgayKhaiGiang(Date ngayKhaiGiang) {
		this.ngayKhaiGiang = ngayKhaiGiang;
	}
	public String getThoiGianHoc() {
		return thoiGianHoc;
	}
	public void setThoiGianHoc(String thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}
	public String getGioHoc() {
		return gioHoc;
	}
	public void setGioHoc(String gioHoc) {
		this.gioHoc = gioHoc;
	}
	public int getsLToiDa() {
		return sLToiDa;
	}
	public void setsLToiDa(int sLToiDa) {
		this.sLToiDa = sLToiDa;
	}
	public int getsLDaDangKy() {
		return sLDaDangKy;
	}
	public void setsLDaDangKy(int sLDaDangKy) {
		this.sLDaDangKy = sLDaDangKy;
	}
	public String getMaGiaoVien() {
		return maGiaoVien;
	}
	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}
	public String getTenGiaoVien() {
		return tenGiaoVien;
	}
	public void setTenGiaoVien(String tenGiaoVien) {
		this.tenGiaoVien = tenGiaoVien;
	}
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public int getHocPhi() {
		return hocPhi;
	}
	public void setHocPhi(int hocPhi) {
		this.hocPhi = hocPhi;
	}

	@Override
	public String toString() {
		return "LopHoc [maLopHoc=" + maLopHoc + ", maMonHoc=" + maMonHoc + ", tenMonHoc=" + tenMonHoc + ", maGiaoVien="
				+ maGiaoVien + ", tenGiaoVien=" + tenGiaoVien + ", phongHoc=" + phongHoc + ", soBuoi=" + soBuoi
				+ ", ngayKhaiGiang=" + ngayKhaiGiang + ", thoiGianHoc=" + thoiGianHoc + ", gioHoc=" + gioHoc
				+ ", sLToiDa=" + sLToiDa + ", sLDaDangKy=" + sLDaDangKy + ", hocPhi=" + hocPhi + "]";
	}
	
	
	

}
