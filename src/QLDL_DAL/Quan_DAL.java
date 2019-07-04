package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DTO.Quan_DTO;

public class Quan_DAL {

	public ArrayList<Quan_DTO> selectAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM quan";
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		ArrayList<Quan_DTO> dsQuan = new ArrayList<Quan_DTO>();
		while(rs.next()) {
			Quan_DTO Quan = new Quan_DTO();
			Quan.setMaQuan(rs.getInt("MaQuan"));
			Quan.setTenQuan(rs.getString("TenQuan"));
			dsQuan.add(Quan);
		}
		return dsQuan;
	}

	public Quan_DTO selectCondition(int maLoaiDL) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet getListQuan() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM quan";
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

	public static String getTenQuan(int MaQuan) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM quan where MaQuan="+MaQuan;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				return rs.getString("TenQuan");
			}
			return null;
	}



}
