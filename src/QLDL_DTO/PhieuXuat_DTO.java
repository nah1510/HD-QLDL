package QLDL_DTO;

import java.sql.Date;

public class PhieuXuat_DTO {
	private int MaPhieuXuat;
	private int MaDL;
	private int TongTriGia;
	private Date NgayLapPhieu;
	
	public PhieuXuat_DTO() {
		this.MaPhieuXuat = 0; 
	}

	public PhieuXuat_DTO(int MaDL, int TongTriGia ) {
		this.MaDL = MaDL;
		this.TongTriGia = TongTriGia;
		this.NgayLapPhieu=new java.sql.Date(System.currentTimeMillis());
	}
	
	public int getMaDL() {
		return this.MaDL;
	}
	
	public int getMaPhieuXuat() {
		return this.MaPhieuXuat;
	}
	
	public int getTongTriGia() {
		return this.TongTriGia;
	}
	
	public Date getNgayLapPhieu() {
		return this.NgayLapPhieu;
	}
}
