package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.MatHang_DTO;

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
				String x=rs.getString("TenLoaiDL");
				conn.close();
				return x;
			}
			conn.close();
			return null;
	}

	public static Integer demLoaiDL() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT COUNT(MaLoaiDL) FROM loaidaily ";
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

	public static boolean insert(LoaiDL_DTO loaiDL) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "INSERT INTO loaidaily(MaLoaiDL ,TenLoaiDL, NoToiDa ) VALUES ( ? , ? , ? )";
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, Dataconnect.getID("loaidaily", "MaLoaiDL"));
			ptmt.setString(2, loaiDL.getTenLoaiDL());
			ptmt.setInt(3, loaiDL.getNoToiDa());
			if( ptmt.executeUpdate() != 0) {
				conn.close();
				System.err.println(true);
				return true;
			}
				
			else {
				conn.close();
				System.err.println(false);
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<LoaiDL_DTO> search(String text) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		 
		String query = "SELECT * FROM loaidaily WHERE `TenLoaiDL` LIKE '%"+text+"%'";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<LoaiDL_DTO> dsLoaiDL = new ArrayList<LoaiDL_DTO>();
			while(rs.next()) {
				LoaiDL_DTO LoaiDL = new LoaiDL_DTO();
				LoaiDL.setMaLoaiDL(rs.getInt("MaLoaiDL"));
				LoaiDL.setTenLoaiDL(rs.getString("TenLoaiDL"));
				LoaiDL.setNoToiDa(rs.getInt("NoToiDa"));
				//System.out.print(rs.getInt("MaDL"));
				//System.out.print(rs.getString("TenDL"));
				//System.out.print(rs.getInt("MaLoaiDL"));
				//System.out.print(rs.getInt("MaQuan"));
				dsLoaiDL.add(LoaiDL);
			}
			conn.close();
			return dsLoaiDL;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return null;
	}

	public static void Delete(int valueAt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "DELETE FROM loaidaily WHERE MaLoaiDL="+valueAt;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ptmt.executeUpdate();
		conn.close();
	}

	public static LoaiDL_DTO getLoaiDL(int ma) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM loaidaily where MaLoaiDL="+ma;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			LoaiDL_DTO LoaiDL=new LoaiDL_DTO();
			LoaiDL.setMaLoaiDL(rs.getInt("MaLoaiDL"));
			LoaiDL.setTenLoaiDL(rs.getString("TenLoaiDL"));
			LoaiDL.setNoToiDa(rs.getInt("NoToiDa"));
			conn.close();
			return LoaiDL;

	}

	public static boolean update(LoaiDL_DTO loaiDL, int ma) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "UPDATE loaidaily SET TenLoaiDL='"+loaiDL.getTenLoaiDL()+"',NoToiDa="+loaiDL.getNoToiDa()+" where MaLoaiDL="+ma;
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			if( ptmt.executeUpdate() != 0) {
				conn.close();
				System.err.println(true);
				return true;
			}
				
			else {
				conn.close();
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
