package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public static int TongDoanhSo(int Thang, int maDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "SELECT SUM(TongTriGia) FROM phieuxuat WHERE MONTH(NgayLapPhieu)="+Thang+" and MaDL="+maDL;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		int i=rs.getInt(1);
		conn.close();
		return i;
	}

	public static int SoPhieuXuat(int MaDL, int Thang) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "SELECT COUNT(MaPhieuXuat) FROM phieuxuat WHERE MaDL="+MaDL+" and MONTH(NgayLapPhieu)="+Thang;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		int i=rs.getInt(1);
		conn.close();
		return i;
	}

	public static int sum(int Thang) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "SELECT SUM(TongTriGia) FROM phieuxuat WHERE MONTH(NgayLapPhieu)="+Thang;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		int i=rs.getInt(1);
		conn.close();
		return i;
	}

}
