package QLDL_DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DTO.CTPhieuXuat_DTO;
import QLDL_DTO.DonViTinh_DTO;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.MatHang_DTO;

public class MatHang_DAL {
	public ArrayList<MatHang_DTO> selectAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM mathang";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<MatHang_DTO> dsMatHang_DTO = new ArrayList<MatHang_DTO>();
			while(rs.next()) {
				MatHang_DTO MatHang = new MatHang_DTO();
				MatHang.setMaMatHang(rs.getInt("MaMatHang"));
				MatHang.setTenMatHang(rs.getString("TenMatHang"));
				MatHang.setDonGia(rs.getInt("DonGia"));
				MatHang.setSoLuongTon(rs.getInt("SoLuongTon"));
				dsMatHang_DTO.add(MatHang);
			}
			return dsMatHang_DTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	}

	public MatHang_DTO selectCondition(int maLoaiDL) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet getListMatHang() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM mathang";
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

	public MatHang_DTO selectCondition(String string) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM mathang where TenMatHang='"+string+"'";
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			MatHang_DTO MatHang = new MatHang_DTO();
			MatHang.setMaMatHang(rs.getInt("MaMatHang"));
			MatHang.setTenMatHang(string);
			MatHang.setDonGia(rs.getInt("DonGia"));
			MatHang.setSoLuongTon(rs.getInt("SoLuongTon"));
			return MatHang;
		}
		return null;
	}
}
