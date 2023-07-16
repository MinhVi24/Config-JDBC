
package Entity;

public class BanGiaoVu {
	private String maGiaoVu;
	private String matKhau;
	public BanGiaoVu(String maGiaoVu, String matKhau) {
		this.maGiaoVu = maGiaoVu;
		this.matKhau = matKhau;
	}
	public BanGiaoVu() {
	}
	@Override
	public String toString() {
		return "BanGiaoVu [maGiaoVu=" + maGiaoVu + ", matKhau=" + matKhau + "]";
	}
	public String getMaGiaoVu() {
		return maGiaoVu;
	}
	public void setMaGiaoVu(String maGiaoVu) {
		this.maGiaoVu = maGiaoVu;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
	

}
