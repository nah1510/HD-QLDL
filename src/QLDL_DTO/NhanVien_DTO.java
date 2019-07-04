package QLDL_DTO;
import java.sql.Date;
public class NhanVien_DTO {
	private int MaNhanVien;
	private String TenNhanVien;
	private Date NgaySinh;
	private int CMND;
	private String ChucVu;
	private String Email;
	private String Password;
	private Date NgayVaoLam;
	
	public NhanVien_DTO() {
		this.MaNhanVien = 0; 
	}
	
	public NhanVien_DTO(int MaNhanVien , String TenNhanVien , Date NgaySinh , int CMND , String ChucVu , String Email , String Password , Date NgayVaoLam) {
		this.MaNhanVien = MaNhanVien;
		this.TenNhanVien = TenNhanVien;
		this.NgaySinh = NgaySinh;
		this.CMND = CMND;
		this.ChucVu = ChucVu;
		this.Email = Email;
		this.Password = Password;
		this.NgayVaoLam = NgayVaoLam;
	}
	
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	
	public void setMaNhanVien(int MaNhanVien) {
		this.MaNhanVien = MaNhanVien;
	}

	public String getTenNhanVien() {
		return TenNhanVien;
	}
	
	public void setTenNhanVien(String TenNhanVien) {
		this.TenNhanVien = TenNhanVien;
	}
	
	public Date getNgaySinh() {
		return NgaySinh;
	}
	
	public void setNgaySinh(Date NgaySinh) {
		this.NgaySinh = NgaySinh;
	}
	
	public int getCMND() {
		return CMND;
	}
	
	public void setCMND(int CMND) {
		this.CMND = CMND;
	}
	
	public String getChucVu() {
		return ChucVu;
	}
	
	public void setChucVu(String ChucVu) {
		this.ChucVu = ChucVu;
	}

	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String Password) {
		this.Password = Password;
	}

	public Date getNgayVaoLam() {
		return NgayVaoLam;
	}
	public void setNgayVaoLam(Date NgayVaoLam) {
		this.NgayVaoLam = NgayVaoLam;
	}

	

}
