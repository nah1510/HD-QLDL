package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import QLDL_DTO.CTPhieuXuat_DTO;

public class CTPhieuXuat_DAL {

	public static boolean Insert(CTPhieuXuat_DTO cTPhieuXuat) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "INSERT INTO ctphieuxuat(MaCTPhieuXuat,MaPhieuXuat ,MaMatHang, MaDVT, SoLuongXuat,ThanhTien  ) VALUES ( ? , ? , ? , ? ,?,?)";
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, Dataconnect.getID("ctphieuxuat", "MaCTPhieuXuat"));
			ptmt.setInt(2, cTPhieuXuat.getMaPhieuXuat());
			ptmt.setInt(3, cTPhieuXuat.getMaMatHang());
			ptmt.setInt(4, cTPhieuXuat.getMaDVT());
			ptmt.setInt(5, cTPhieuXuat.getSoLuongXuat());
			ptmt.setInt(6, cTPhieuXuat.getThanhTien());
			if( ptmt.executeUpdate() != 0) {
				System.err.println(true);
				return true;
			}
				
			else {
				System.err.println(false);
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
