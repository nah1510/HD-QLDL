package QLDL_DTO;

public class BaoCaoDoanhThu_DTO {
	private int MaBaoCaoDoanhThu;
	private int Thang;
	
	public BaoCaoDoanhThu_DTO() {
		MaBaoCaoDoanhThu = 0;
	}
	public BaoCaoDoanhThu_DTO( int thang) {
		Thang = thang;
	}
	public int getMaBaoCaoDoanhThu() {
		return MaBaoCaoDoanhThu;
	}
	
	public void setMaBaoCaoDoanhThu(int maBaoCaoDoanhThu) {
		MaBaoCaoDoanhThu = maBaoCaoDoanhThu;
	}
	public int getThang() {
		return Thang;
	}
	public void setThang(int thang) {
		Thang = thang;
	}
	
	
}
