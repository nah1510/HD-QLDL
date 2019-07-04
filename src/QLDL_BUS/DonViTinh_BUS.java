package QLDL_BUS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DAL.DonViTinh_DAL;
import QLDL_DAL.MatHang_DAL;
import QLDL_DTO.DonViTinh_DTO;
import QLDL_DTO.MatHang_DTO;

public class DonViTinh_BUS {
	private static DonViTinh_DAL dal;
	public DonViTinh_BUS(){
		dal = new DonViTinh_DAL();
	}
	public ArrayList< DonViTinh_DTO> selectAll() throws ClassNotFoundException, SQLException {
		return dal.selectAll();
	}
	
	public DonViTinh_DTO selectCondition (int MaDVT) throws ClassNotFoundException, SQLException{
		return dal.selectCondition(MaDVT);
	}
	
	public static DonViTinh_DTO selectCondition (String TenDVT) throws ClassNotFoundException, SQLException{
		return dal.selectCondition(TenDVT);
	}
	
	public static  ResultSet getList() throws ClassNotFoundException, SQLException {
		
		return dal.getListDVT();
		
	}

}
