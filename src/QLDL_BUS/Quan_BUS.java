package QLDL_BUS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DAL.Quan_DAL;
import QLDL_DTO.Quan_DTO;

public class Quan_BUS {
	private static Quan_DAL dal;
	public Quan_BUS(){
		dal = new Quan_DAL();
	}
	public static ArrayList< Quan_DTO> selectAll() throws ClassNotFoundException, SQLException {
		return dal.selectAll();
	}
	
	public Quan_DTO selectCondition (int MaLoaiDL) throws ClassNotFoundException, SQLException{
		return dal.selectCondition(MaLoaiDL);
	}
	
	public static  ResultSet getListQuan() throws ClassNotFoundException, SQLException {
		
		return dal.getListQuan();
		
	}

public static  String getTenQuan(int MaQuan) throws ClassNotFoundException, SQLException {
		
		return dal.getTenQuan(MaQuan);
		
	}
}
