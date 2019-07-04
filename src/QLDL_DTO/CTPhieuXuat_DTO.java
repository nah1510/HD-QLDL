package QLDL_DTO;

public class CTPhieuXuat_DTO {
	private int MaCTPhieuXuat;
	private int MaPhieuXuat;
	private int MaMatHang;
	private int MaDVT;
	private int SoLuongXuat;
	private int ThanhTien;
	
	public  CTPhieuXuat_DTO(){
		this.MaCTPhieuXuat=0;
	}
	
	public  CTPhieuXuat_DTO(int MaPhieuXuat, int MaMatHang,int MaDVT,int SoLuongXuat,int ThanhTien) {
		this.MaPhieuXuat=MaPhieuXuat;
		this.MaMatHang=MaMatHang;
		this.MaDVT=MaDVT;
		this.SoLuongXuat=SoLuongXuat;
		this.ThanhTien=ThanhTien;
	}

	public int getMaCTPhieuXuat() {
		return MaCTPhieuXuat;
	}

	public void setMaCTPhieuXuat(int maCTPhieuXuat) {
		MaCTPhieuXuat = maCTPhieuXuat;
	}

	public int getMaMatHang() {
		return MaMatHang;
	}

	public void setMaMatHang(int maMatHang) {
		MaMatHang = maMatHang;
	}

	public int getMaDVT() {
		return MaDVT;
	}

	public void setMaDVT(int maDVT) {
		MaDVT = maDVT;
	}

	public int getSoLuongXuat() {
		return SoLuongXuat;
	}

	public void setSoLuongXuat(int soLuongXuat) {
		SoLuongXuat = soLuongXuat;
	}

	public int getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(int thanhTien) {
		ThanhTien = thanhTien;
	}

	public int getMaPhieuXuat() {
		return MaPhieuXuat;
	}

	public void setMaPhieuXuat(int maPhieuXuat) {
		MaPhieuXuat = maPhieuXuat;
	}
	

}

