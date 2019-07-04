package QLDL_DTO;



public class DonViTinh_DTO {
	private int MaDVT;
	private String TenDVT;
	private int SoLuongDVT;
	
	public void setMaDVT(int MaDVT) {
		this.MaDVT= MaDVT;
	}
	
	public void setTenDVT(String TenDVT) {
		this.TenDVT= TenDVT;
	}
	
	public void setSoLuongDVTT(int SoLuongDVT) {
		this.SoLuongDVT= SoLuongDVT;
	}
	
	public int getMaDVT() {
		return MaDVT;
	}

	public int getSoLuongDVT() {
		return SoLuongDVT;
	}
	
	public String getTenDVT() {
		return TenDVT;
	}
}
