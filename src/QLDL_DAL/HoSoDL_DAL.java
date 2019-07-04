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
				System.err.println(true);
				return true;
			}
				
			else {
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
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				//System.out.print(rs.getInt("MaDL"));
				//System.out.print(rs.getString("TenDL"));
				//System.out.print(rs.getInt("MaLoaiDL"));
				//System.out.print(rs.getInt("MaQuan"));
				dsDaiLy.add(DaiLy);
			}
			return dsDaiLy;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				return DaiLy;
			}
			return null;
	}

	public static boolean UpdateNo(int maDL, int no) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ptmt = null; 
		Connection conn = Dataconnect.connet();
		String query = "UPDATE hosodayly SET TienNo="+no+" where MaDL="+maDL;
		ptmt = conn.prepareStatement(query);
		if(ptmt.executeUpdate()!=0)
			return true;
		return false;
	}

}
