package QLDL_BUS;

import QLDL_DAL.CTPhieuXuat_DAL;
import QLDL_DAL.PhieuXuat_DAL;
import QLDL_DTO.CTPhieuXuat_DTO;

public class CTPhieuXuat_BUS {

	public static boolean Insert(CTPhieuXuat_DTO cTPhieuXuat) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return CTPhieuXuat_DAL.Insert(cTPhieuXuat);
	}

}
