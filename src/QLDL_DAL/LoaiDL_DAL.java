package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import QLDL_DTO.LoaiDL_DTO;

public class LoaiDL_DAL {

	public ArrayList<LoaiDL_DTO> selectAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM loaidaily";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<LoaiDL_DTO> dsLoaiDL = new ArrayList<LoaiDL_DTO>();
			while(rs.next()) {
				LoaiDL_DTO LoaiDL = new LoaiDL_DTO();
				LoaiDL.setMaLoaiDL(rs.getInt("MaLoaiDL"));
				LoaiDL.setTenLoaiDL(rs.getString("TenLoaiDL"));
				LoaiDL.setNoToiDa(rs.getInt("NoToiDa"));
				dsLoaiDL.add(LoaiDL);
			}
			return dsLoaiDL;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
		
		
	}

	public static LoaiDL_DTO selectCondition(int maLoaiDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "SELECT * FROM loaidaily where MaLoaiDL = "+maLoaiDL;
		Connection conn = Dataconnect.connet();
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			LoaiDL_DTO LoaiDL = new LoaiDL_DTO();
			LoaiDL.setMaLoaiDL(rs.getInt("MaLoaiDL"));
			LoaiDL.setTenLoaiDL(rs.getString("TenLoaiDL"));
			LoaiDL.setNoToiDa(rs.getInt("NoToiDa"));
			
			return LoaiDL;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	}

	public ResultSet getListLoaiDaiLy() throws ClassNotFoundException, SQLException{
		//get connection
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM loaidaily";
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

	public static Object getTenLoaiDL(int maLoaiDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM loaidaily where MaLoaiDL="+maLoaiDL;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				return rs.getString("TenLoaiDL");
			}
			return null;
	}



}
