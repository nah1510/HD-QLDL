package QLDL_DTO;

public class Quan_DTO {
	private int MaQuan;
	private String TenQuan;
	public Quan_DTO() {
		this.MaQuan = 0; 
	}
	
	public Quan_DTO(int MaQuan , String TenQuan ) {
		this.MaQuan = MaQuan;
		this.TenQuan = TenQuan;
	}
	
	public int getMaQuan() {
		return MaQuan;
	}
	
	public void setMaQuan(int MaQuan) {
		this.MaQuan = MaQuan;
	}

	public String getTenQuan() {
		return TenQuan;
	}
	
	public void setTenQuan(String TenQuan) {
		this.TenQuan = TenQuan;
	}
}
