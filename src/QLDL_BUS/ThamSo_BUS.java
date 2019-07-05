package QLDL_BUS;

import java.sql.SQLException;

import QLDL_DAL.ThamSo_DAL;

public class ThamSo_BUS {

	public static int SoDaiLyToiDa() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return ThamSo_DAL.SoDaiLyToiDa();
	}

	public static void upSoLuongDaiLy(Integer SoluongDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ThamSo_DAL.upSoLuongDaiLy(SoluongDL);
	}

	public static int SoLoaiDaiLyToiDa() throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return ThamSo_DAL.SoLoaiDaiLyToiDa();
	}

	public static void upSoLuongLoaiDaiLy(Integer valueOf) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ThamSo_DAL.upSoLuongLoaiDaiLy(valueOf);
	}

	public static int SoMatHang()throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return ThamSo_DAL.SoMatHang();
	}

	public static void upSoLuongMatHang(Integer valueOf) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ThamSo_DAL.upSoLuongMatHang(valueOf);
	}

	public static int SoDonViTinh() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return ThamSo_DAL.SoDonViTinh();
	}

	public static void upSoDonViTInh(Integer valueOf)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ThamSo_DAL.upSoDonViTInh(valueOf);
	}
	
}
