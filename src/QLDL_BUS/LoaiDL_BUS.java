package QLDL_BUS;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DAL.LoaiDL_DAL;
import QLDL_DTO.LoaiDL_DTO;
public class LoaiDL_BUS {
	private static LoaiDL_DAL dal;
	public LoaiDL_BUS(){
		dal = new LoaiDL_DAL();
	}
	public ArrayList<LoaiDL_DTO> selectAll() throws ClassNotFoundException, SQLException {
		return dal.selectAll();
	}
	
	public static LoaiDL_DTO selectCondition (int MaLoaiDL) throws ClassNotFoundException, SQLException{
		return dal.selectCondition(MaLoaiDL);
	}
	
	public static  ResultSet getListLoaiDaiLy() throws ClassNotFoundException, SQLException {
		
		return dal.getListLoaiDaiLy();
		
	}
	public static Object getTenLoaiDL(int maLoaiDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dal.getTenLoaiDL(maLoaiDL);
	}
}
