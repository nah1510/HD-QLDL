package QLDL_BUS;

import java.sql.SQLException;

import QLDL_DAL.PhieuXuat_DAL;
import QLDL_DTO.PhieuXuat_DTO;

public class PhieuXuat_BUS {

	public static boolean Insert(PhieuXuat_DTO phieuXuat) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return PhieuXuat_DAL.Insert(phieuXuat);
	}

	public static int TongDoanhSo(int MaDL, int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return PhieuXuat_DAL.TongDoanhSo(MaDL,i);
	}

	public static int SoPhieuXuat(int MaDL, int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return PhieuXuat_DAL.SoPhieuXuat(MaDL,i);
	}

	public static int sum(int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return PhieuXuat_DAL.sum(i);
	}

}
