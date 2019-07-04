package QLDL_BUS;

import QLDL_DAL.PhieuXuat_DAL;
import QLDL_DTO.PhieuXuat_DTO;

public class PhieuXuat_BUS {

	public static boolean Insert(PhieuXuat_DTO phieuXuat) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return PhieuXuat_DAL.Insert(phieuXuat);
	}

}
