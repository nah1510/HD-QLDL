package QLDL_BUS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DAL.MatHang_DAL;
import QLDL_DAL.Quan_DAL;
import QLDL_DTO.CTPhieuXuat_DTO;
import QLDL_DTO.MatHang_DTO;
import QLDL_DTO.Quan_DTO;

public class MatHang_BUS {
	private static MatHang_DAL dal;
	public MatHang_BUS(){
		dal = new MatHang_DAL();
	}
	public ArrayList< MatHang_DTO> selectAll() throws ClassNotFoundException, SQLException {
		return dal.selectAll();
	}
	
	public MatHang_DTO selectCondition (int MaLoaiDL) throws ClassNotFoundException, SQLException{
		return dal.selectCondition(MaLoaiDL);
	}
	
	public static  ResultSet getListMatHang() throws ClassNotFoundException, SQLException {
		
		return dal.getListMatHang();
		
	}
	public static MatHang_DTO selectCondition(String string) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dal.selectCondition(string);
	}
}
