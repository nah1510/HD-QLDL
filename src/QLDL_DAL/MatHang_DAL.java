package QLDL_DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DTO.CTPhieuXuat_DTO;
import QLDL_DTO.DonViTinh_DTO;
import QLDL_DTO.HoSoDL_DTO;
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

	public static Integer demSoMH() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT COUNT(MaMatHang) FROM mathang ";
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

	public static boolean insert(MatHang_DTO mathang) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "INSERT INTO mathang(MaMatHang ,TenMatHang, DonGia , SoLuongTon  ) VALUES ( ? , ? , ? , ?)";
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, Dataconnect.getID("mathang", "MaMatHang"));
			ptmt.setString(2, mathang.getTenMatHang());
			ptmt.setInt(3, mathang.getDonGia());
			ptmt.setInt(4, mathang.getSoLuongTon());
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

	public static ArrayList<MatHang_DTO> search(String text) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		 
		String query = "SELECT * FROM mathang WHERE `TenMatHang` LIKE '%"+text+"%'";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<MatHang_DTO> dsMatHang = new ArrayList<MatHang_DTO>();
			while(rs.next()) {
				MatHang_DTO MatHang = new MatHang_DTO();
				MatHang.setMaMatHang(rs.getInt("MaMatHang"));
				MatHang.setTenMatHang(rs.getString("TenMatHang"));
				MatHang.setDonGia(rs.getInt("DonGia"));
				MatHang.setSoLuongTon(rs.getInt("SoLuongTon"));
				//System.out.print(rs.getInt("MaDL"));
				//System.out.print(rs.getString("TenDL"));
				//System.out.print(rs.getInt("MaLoaiDL"));
				//System.out.print(rs.getInt("MaQuan"));
				dsMatHang.add(MatHang);
			}
			conn.close();
			return dsMatHang;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return null;
	}

	public static void Delete(int MaMatHang) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "DELETE FROM MatHang WHERE MaMatHang="+MaMatHang;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ptmt.executeUpdate();
		conn.close();
	}

	public static MatHang_DTO getMatHang(int ma) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM mathang where MaMatHang="+ma;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			MatHang_DTO MatHang=new MatHang_DTO();
			MatHang.setMaMatHang(rs.getInt("MaMatHang"));
			MatHang.setTenMatHang(rs.getString("TenMatHang"));
			MatHang.setDonGia(rs.getInt("DonGia"));
			MatHang.setSoLuongTon(rs.getInt("SoLuongTon"));
			conn.close();
			return MatHang;

	}

	public static boolean update(MatHang_DTO mathang, int ma) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "UPDATE mathang SET TenMatHang='"+mathang.getTenMatHang()+"',DonGia="+mathang.getDonGia()+",SoLuongTon="+mathang.getSoLuongTon()+" where MaMatHang="+ma;
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
