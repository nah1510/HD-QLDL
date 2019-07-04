package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import QLDL_DTO.PhieuXuat_DTO;

public class PhieuXuat_DAL {

	public static boolean Insert(PhieuXuat_DTO phieuXuat) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "INSERT INTO phieuxuat(MaPhieuXuat ,MaDL, TongTriGia , NgayLapPhieu ) VALUES ( ? , ? , ? , ? )";
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, Dataconnect.getID("phieuxuat", "MaPhieuXuat"));
			ptmt.setInt(2, phieuXuat.getMaDL());
			ptmt.setInt(3, phieuXuat.getTongTriGia());
			ptmt.setDate(4, phieuXuat.getNgayLapPhieu());
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
