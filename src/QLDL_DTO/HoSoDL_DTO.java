package QLDL_DTO;

import java.sql.Date;

public class HoSoDL_DTO {
	private int MaDL;
	private String TenDL;
	private int MaLoaiDL;
	private String DienThoai;
	private String DiaChi;
	private int MaQuan;
	private String Email;
	private Date NgayTiepNhan;
	private int TienNo;

	public HoSoDL_DTO() {
		this.MaDL = 0; 
	}
	
	public HoSoDL_DTO( String TenDL , int MaLoaiDL , String DienThoai , String DiaChi , int MaQuan , String Email , Date NgayTiepNhan) {
		this.TenDL = TenDL;
		this.MaLoaiDL = MaLoaiDL;
		this.DienThoai = DienThoai;
		this.DiaChi = DiaChi;
		this.MaQuan = MaQuan;
		this.Email = Email;
		this.NgayTiepNhan = NgayTiepNhan;
	}

	public int getMaQuan() {
		return MaQuan;
	}

	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public void setNgayTiepNhan(Date ngayTiepNhan) {
		NgayTiepNhan = ngayTiepNhan;
	}

	public void setMaDL(int MaDL) {
		this.MaDL= MaDL;
	}
	
	public void setTenDL(String TenDL) {
		this.TenDL= TenDL;
	}
	
	public String getTenDL() {
		return TenDL;
	}

	public int getMaLoaiDL() {
		return MaLoaiDL;
	}
	
	public int getTienNo() {
		return TienNo;
	}
	
	public void setTienNo(int TienNo) {
		this.TienNo= TienNo;
	}
	
	public void setMaQuan(int MaQuan) {
		this.MaQuan= MaQuan;
	}
	
	public void setMaLoaiDL(int MaLoaiDL) {
		this.MaLoaiDL= MaLoaiDL;
	}

	public String getDienThoai() {
		return DienThoai;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public int getQuan() {
		return MaQuan;
	}
	public String getEmail() {
		return Email;
	}
	
	public Date getNgayTiepNhan() {
		return NgayTiepNhan;
	}
	
	public int getMaDL() {
		return MaDL;
	}
}
