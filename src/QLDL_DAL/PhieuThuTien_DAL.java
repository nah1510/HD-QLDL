package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import QLDL_DTO.PhieuThuTien_DTO;

public class PhieuThuTien_DAL {

	public static boolean Insert(PhieuThuTien_DTO phieuThu) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "INSERT INTO phieuthutien(MaPhieuThuTien ,MaDaiLy , SoTienThu , NgayThuTien  ) VALUES ( ? , ? , ? , ? )";
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, Dataconnect.getID("phieuthutien", "MaPhieuThuTien"));
			ptmt.setInt(2, phieuThu.getMaDaiLy());
			ptmt.setInt(3, phieuThu.getSoTienThu());
			ptmt.setDate(4, phieuThu.getNgayThuTien());
			if( ptmt.executeUpdate() != 0) {
				System.err.println(true);
				conn.close();
				return true;
			}
				
			else {
				System.err.println(false);
				conn.close();
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static int TongPhieuThu(int thang, int maDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "SELECT SUM(SoTienThu) FROM phieuthutien WHERE MONTH(NgayThuTien)="+thang+" and MaDaiLy="+maDL;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		int i=rs.getInt(1);
		conn.close();
		return i;
	}

}
