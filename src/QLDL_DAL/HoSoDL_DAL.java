package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DTO.HoSoDL_DTO;

public class HoSoDL_DAL {

	public static boolean Insert(HoSoDL_DTO hoSoDaiLy) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "INSERT INTO hosodayly(MaDL ,TenDL, MaLoaiDL , DienThoai , DiaChi , MaQuan , Email , NgayTiepNhan, TienNo ) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ?)";
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, Dataconnect.getID("hosodayly", "MaDL"));
			ptmt.setString(2, hoSoDaiLy.getTenDL());
			ptmt.setInt(3, hoSoDaiLy.getMaLoaiDL());
			ptmt.setString(4, hoSoDaiLy.getDienThoai());
			ptmt.setString(5, hoSoDaiLy.getDiaChi());
			ptmt.setInt(6, hoSoDaiLy.getQuan());
			ptmt.setString(7, hoSoDaiLy.getEmail());
			ptmt.setDate(8, hoSoDaiLy.getNgayTiepNhan());
			ptmt.setInt(9, 0);
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

	public static ResultSet getListHoSoDaiLy() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		
		String query = "SELECT * FROM hosodaily";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			conn.close();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return null;	
	}

	public static ArrayList<HoSoDL_DTO> search(String key) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		 
		String query = "SELECT * FROM hosodayly WHERE `TenDL` LIKE '%"+key+"%'";
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<HoSoDL_DTO> dsDaiLy = new ArrayList<HoSoDL_DTO>();
			while(rs.next()) {
				HoSoDL_DTO DaiLy = new HoSoDL_DTO();
				DaiLy.setMaDL(rs.getInt("MaDL"));
				DaiLy.setTenDL(rs.getString("TenDL"));
				DaiLy.setMaLoaiDL(rs.getInt("MaLoaiDL"));
				DaiLy.setTienNo(rs.getInt("TienNo"));
				DaiLy.setMaQuan(rs.getInt("MaQuan"));
				//System.out.print(rs.getInt("MaDL"));
				//System.out.print(rs.getString("TenDL"));
				//System.out.print(rs.getInt("MaLoaiDL"));
				//System.out.print(rs.getInt("MaQuan"));
				dsDaiLy.add(DaiLy);
			}
			conn.close();
			return dsDaiLy;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return null;
	}

	public static HoSoDL_DTO getDaiLy(int maDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "SELECT * FROM hosodayly where MaDL="+maDL;
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				HoSoDL_DTO DaiLy = new HoSoDL_DTO();
				DaiLy.setMaDL(rs.getInt("MaDL"));
				DaiLy.setTenDL(rs.getString("TenDL"));
				DaiLy.setMaLoaiDL(rs.getInt("MaLoaiDL"));
				DaiLy.setTienNo(rs.getInt("TienNo"));
				DaiLy.setDiaChi(rs.getString("DiaChi"));
				DaiLy.setDienThoai(rs.getString("DienThoai"));
				DaiLy.setEmail(rs.getString("Email"));
				conn.close();
				return DaiLy;
			}
			conn.close();
			return null;
	}

	public static boolean UpdateNo(int maDL, int no) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "UPDATE hosodayly SET TienNo="+no+" where MaDL="+maDL;
		ptmt = conn.prepareStatement(query);
		if(ptmt.executeUpdate()!=0)
		{
			conn.close();
			return true;
		}
		conn.close();
		return false;
	}

	public static ArrayList<HoSoDL_DTO> selectThang(int Thang) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		 
		String query = "SELECT * FROM hosodayly WHERE MONTH(`NgayTiepNhan`)<= "+Thang;
		try {
			ptmt = conn.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			ArrayList<HoSoDL_DTO> dsDaiLy = new ArrayList<HoSoDL_DTO>();
			while(rs.next()) {
				HoSoDL_DTO DaiLy = new HoSoDL_DTO();
				DaiLy.setMaDL(rs.getInt("MaDL"));
				DaiLy.setTenDL(rs.getString("TenDL"));
				DaiLy.setMaLoaiDL(rs.getInt("MaLoaiDL"));
				DaiLy.setTienNo(rs.getInt("TienNo"));
				//System.out.print(rs.getInt("MaDL"));
				//System.out.print(rs.getString("TenDL"));
				//System.out.print(rs.getInt("MaLoaiDL"));
				//System.out.print(rs.getInt("MaQuan"));
				dsDaiLy.add(DaiLy);
			}
			conn.close();
			return dsDaiLy;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return null;
	}

	public static int DemQuan(int maQuan) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "SELECT COUNT(MaQuan) FROM hosodayly WHERE MaQuan="+maQuan;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ResultSet rs = ptmt.executeQuery();
		rs.next();
		int i=rs.getInt(1);
		conn.close();
		return i;
	}

	public static void Delete(int maDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		String query = "DELETE FROM hosodayly WHERE MaDL="+maDL;
		Connection conn = Dataconnect.connet();
		ptmt = conn.prepareStatement(query);
		ptmt.executeUpdate();
		conn.close();
	}

	public static boolean Update(HoSoDL_DTO hoSoDaiLy) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "UPDATE hosodayly SET TenDL='"+hoSoDaiLy.getTenDL()+"',MaLoaiDL="+hoSoDaiLy.getMaLoaiDL()+",DienThoai='"+hoSoDaiLy.getDienThoai()+
					"',DiaChi='"+hoSoDaiLy.getDiaChi()+"',MaQuan="+hoSoDaiLy.getMaQuan()+",Email='"+hoSoDaiLy.getEmail()+"' where MaDL="+hoSoDaiLy.getMaDL();
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
