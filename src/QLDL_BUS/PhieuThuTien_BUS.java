package QLDL_BUS;

import java.sql.SQLException;

import QLDL_DAL.PhieuThuTien_DAL;
import QLDL_DTO.PhieuThuTien_DTO;

public class PhieuThuTien_BUS {

	public static boolean Insert(PhieuThuTien_DTO phieuThu) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return PhieuThuTien_DAL.Insert(phieuThu);
	}

	public static int TongPhieuThu(int i, int maDL) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return PhieuThuTien_DAL.TongPhieuThu( i,  maDL);
	}

}
