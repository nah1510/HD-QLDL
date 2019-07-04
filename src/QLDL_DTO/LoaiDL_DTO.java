package QLDL_DTO;

public class LoaiDL_DTO {
	private int MaLoaiDL;
	private String TenLoaiDL;
	private int NoToiDa ;
	public LoaiDL_DTO() {
		this.MaLoaiDL = 0; 
	}
	
	public LoaiDL_DTO(String TenLoaiDL , int NoToiDa ) {
		this.TenLoaiDL = TenLoaiDL;
		this.NoToiDa = NoToiDa;
	}
	
	public int getMaLoaiDL() {
		return MaLoaiDL;
	}
	
	public void setMaLoaiDL(int MaLoaiDL) {
		this.MaLoaiDL = MaLoaiDL;
	}

	public String getTenLoaiDL() {
		return TenLoaiDL;
	}
	
	public void setTenLoaiDL(String TenLoaiDL) {
		this.TenLoaiDL = TenLoaiDL;
	}
	
	public int getNoToiDa() {
		return NoToiDa;
	}
	
	public void setNoToiDa(int NoToiDa) {
		this.NoToiDa = NoToiDa;
	}
	
}
