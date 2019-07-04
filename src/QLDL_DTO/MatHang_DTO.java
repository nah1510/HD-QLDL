package QLDL_DTO;

public class MatHang_DTO {
	private int MaMatHang;
	private String TenMatHang;
	private int DonGia;
	private int SoLuongTon;
	
	public MatHang_DTO( ) {
		this.MaMatHang = 0;
	}
	
	public MatHang_DTO(String TenMatHang , int DonGia, int SoLuongTon ) {
		this.TenMatHang = TenMatHang;
		this.DonGia = DonGia;
		this.SoLuongTon = SoLuongTon;
	}
	
	public int getMaMatHang() {
		return MaMatHang;
	}
	
	public void setMaMatHang(int MaMatHang) {
		this.MaMatHang = MaMatHang;
	}

	public String getTenMatHang() {
		return TenMatHang;
	}
	
	public void setTenMatHang(String TenMatHang) {
		this.TenMatHang = TenMatHang;
	}
	
	public int getDonGia() {
		return DonGia;
	}
	
	public void setDonGia(int DonGia) {
		this.DonGia = DonGia;
	}
	
	public int getSoLuongTon() {
		return SoLuongTon;
	}
	
	public void setSoLuongTon(int SoLuongTon) {
		this.SoLuongTon = SoLuongTon;
	}
}
