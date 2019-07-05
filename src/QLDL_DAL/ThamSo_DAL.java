package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThamSo_DAL {

	public static int SoDaiLyToiDa() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT SoDaiLyToiDa FROM thamso";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			int i=rs.getInt("SoDaiLyToiDa");
			conn.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}

	public static void upSoLuongDaiLy(Integer soluongDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "UPDATE thamso SET SoDaiLyToiDa="+soluongDL;
		ptmt =conn.prepareStatement(query);
		ptmt.executeUpdate();
		conn.close();
	}

	public static int SoLoaiDaiLyToiDa() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM thamso";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			int i=rs.getInt("SoLuongLoaiDaiLy");
			conn.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}

	public static void upSoLuongLoaiDaiLy(Integer valueOf) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "UPDATE thamso SET SoLuongLoaiDaiLy="+valueOf;
		ptmt =conn.prepareStatement(query);
		ptmt.executeUpdate();
		conn.close();
	}

	public static int SoMatHang() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM thamso";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			int i=rs.getInt("SoMatHang");
			conn.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}

	public static void upSoLuongMatHang(Integer valueOf) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "UPDATE thamso SET SoMatHang="+valueOf;
		ptmt =conn.prepareStatement(query);
		ptmt.executeUpdate();
		conn.close();
	}

	public static int SoDonViTinh() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM thamso";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			int i=rs.getInt("SoDonViTinh");
			conn.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}

	public static void upSoDonViTInh(Integer valueOf) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "UPDATE thamso SET SoDonViTinh="+valueOf;
		ptmt =conn.prepareStatement(query);
		ptmt.executeUpdate();
		conn.close();
	}


}
