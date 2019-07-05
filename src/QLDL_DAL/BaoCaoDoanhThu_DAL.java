package QLDL_DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaoCaoDoanhThu_DAL {

	public static void insert(int maBaoCaoDoanhSo, int month) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptmt = null; 
			String query = "INSERT INTO baocaodoanhso(MaBaoCaoDoanhSo ,Thang ) VALUES ( ? , ? )";
			Connection conn = Dataconnect.connet();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, maBaoCaoDoanhSo);
			ptmt.setInt(2, month);
			if( ptmt.executeUpdate() != 0) {
				conn.close();
				System.err.println(true);
			}
				
			else {
				System.err.println(false);
				conn.close();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
