
package Entity;

import java.sql.Date;

public class NguoiDangKy {
	private String hoTenHV;
	private String sDT;
	private String diaChi;
	private Date ngaySinh;
	private String email;
	private String hoTenPH;
	private String maLopHoc;
	private String trangThai;
	public NguoiDangKy(String hoTenHV, String sDT, String diaChi, Date ngaySinh, String email, String hoTenPH,
			String maLopHoc, String trangThai) {
		this.hoTenHV = hoTenHV;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.hoTenPH = hoTenPH;
		this.maLopHoc = maLopHoc;
		this.trangThai = trangThai;
	}
	public NguoiDangKy() {
	}
	public String getHoTenHV() {
		return hoTenHV;
	}
	public void setHoTenHV(String hoTenHV) {
		this.hoTenHV = hoTenHV;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHoTenPH() {
		return hoTenPH;
	}
	public void setHoTenPH(String hoTenPH) {
		this.hoTenPH = hoTenPH;
	}
	public String getMaLopHoc() {
		return maLopHoc;
	}
	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "NguoiDangKy [hoTenHV=" + hoTenHV + ", sDT=" + sDT + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh
				+ ", email=" + email + ", hoTenPH=" + hoTenPH + ", maLopHoc=" + maLopHoc + ", trangThai=" + trangThai
				+ "]";
	}
	
	
	
	
	

}
