package QLDL_BUS;

import QLDL_DAL.BaoCaoDoanhThu_DAL;

public class BaoCaoDoanhThu_BUS {

	public static void insert(int maBaoCaoDoanhSo, int month) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		BaoCaoDoanhThu_DAL.insert(maBaoCaoDoanhSo,month);
	}

}
