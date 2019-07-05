package QLDL_DTO;

import java.sql.Date;

public class PhieuThuTien_DTO {
	private int MaPhieuThuTien;
	private int MaDaiLy;
	private int SoTienThu;
	private Date NgayThuTien;
	
	public PhieuThuTien_DTO() {
		this.MaPhieuThuTien=0;
	}
	
	public PhieuThuTien_DTO(int MaDaiLy,int SoTienThu,Date NgayThuTien) {
		this.MaDaiLy=MaDaiLy;
		this.SoTienThu=SoTienThu;
		this.NgayThuTien=NgayThuTien;
	}
	
	public int getMaPhieuThuTien() {
		return MaPhieuThuTien;
	}
	public void setMaPhieuThuTien(int maPhieuThuTien) {
		MaPhieuThuTien = maPhieuThuTien;
	}
	public int getMaDaiLy() {
		return MaDaiLy;
	}
	public void setMaDaiLy(int maDaiLy) {
		MaDaiLy = maDaiLy;
	}
	public int getSoTienThu() {
		return SoTienThu;
	}
	public void setSoTienThu(int soTienThu) {
		SoTienThu = soTienThu;
	}
	public Date getNgayThuTien() {
		return NgayThuTien;
	}
	public void setNgayThuTien(Date ngayThuTien) {
		NgayThuTien = ngayThuTien;
	}
}
