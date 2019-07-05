package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DTO.DonViTinh_DTO;
import QLDL_DTO.MatHang_DTO;

public class DonViTinh_DAL {

	public static DonViTinh_DTO selectCondition(int maDVT) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DonViTinh_DTO> selectAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM donvitinh";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<DonViTinh_DTO> dsDonViTinh_DTO = new ArrayList<DonViTinh_DTO>();
			while(rs.next()) {
				DonViTinh_DTO DonViTinh = new DonViTinh_DTO();
				DonViTinh.setMaDVT(rs.getInt("MaDVT"));
				DonViTinh.setTenDVT(rs.getString("TenDVT"));
				DonViTinh.setSoLuongDVTT(rs.getInt("SoLuongDVT"));
				dsDonViTinh_DTO.add(DonViTinh);
			}
			return dsDonViTinh_DTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	}

	public ResultSet getListDVT() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM DonViTinh";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	public DonViTinh_DTO selectCondition(String tenDVT) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM donvitinh where TenDVT='"+tenDVT+"'";
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			DonViTinh_DTO DonViTinh = new DonViTinh_DTO();
			DonViTinh.setMaDVT(rs.getInt("MaDVT"));
			DonViTinh.setTenDVT(rs.getString("TenDVT"));
			DonViTinh.setSoLuongDVTT(rs.getInt("SoLuongDVT"));
			return DonViTinh;
		}
		return null;
	}

	public static Integer demSoDonViTinh() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT COUNT(MaDVT) FROM donvitinh ";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			int i=rs.getInt(1);
			conn.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}


}
