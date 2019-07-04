package QLDL_BUS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QLDL_DAL.HoSoDL_DAL;
import QLDL_DTO.HoSoDL_DTO;
import QLDL_DTO.LoaiDL_DTO;

public class HoSoDL_BUS {

	public static boolean Insert(HoSoDL_DTO hoSoDaiLy) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return HoSoDL_DAL.Insert(hoSoDaiLy);
	}

	public static  ResultSet getListHoSoDaiLy() throws ClassNotFoundException, SQLException {
			
			return HoSoDL_DAL.getListHoSoDaiLy();
			
	}



	public static ArrayList<HoSoDL_DTO> search(String text) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			return HoSoDL_DAL.search(text);
	}
	public static  HoSoDL_DTO getDaiLy(int MaDL) throws ClassNotFoundException, SQLException {
		
		return HoSoDL_DAL.getDaiLy(MaDL);
		
	}

	public static boolean UpdateNo(int maDL, int No) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		return HoSoDL_DAL.UpdateNo(maDL,No);
	}

}
