package QLDL_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import QLDL_BUS.BaoCaoDoanhThu_BUS;
import QLDL_BUS.CTPhieuXuat_BUS;
import QLDL_BUS.HoSoDL_BUS;
import QLDL_BUS.PhieuXuat_BUS;
import QLDL_BUS.Quan_BUS;
import QLDL_DAL.Dataconnect;
import QLDL_DAL.LoaiDL_DAL;
import QLDL_DTO.HoSoDL_DTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JYearChooser;

public class frmBaoCaoDoanhSo {

	private JFrame frame;
	private JMonthChooser Thang;
	private JTable table;
	private DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBaoCaoDoanhSo window = new frmBaoCaoDoanhSo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmBaoCaoDoanhSo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 483);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Đại lý","Số phiếu xuất", "Tổng trị giá", "Tỉ lệ"
				}
			);
		JButton btnXemDoanhSo = new JButton("Xem Doanh S\u1ED1");
		btnXemDoanhSo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.setRowCount(0);
					int maBaoCaoDoanhSo=Dataconnect.getID("baocaodoanhso", "MaBaoCaoDoanhSo");
					int Sum=PhieuXuat_BUS.sum(Thang.getMonth()+1) ;
					System.out.print(Sum);
					BaoCaoDoanhThu_BUS.insert(maBaoCaoDoanhSo,Thang.getMonth()+1);
					ArrayList<HoSoDL_DTO> dsDaiLy = HoSoDL_BUS.search("");
				
					dsDaiLy.forEach(DaiLy -> {
						try {
							
							model.addRow(new Object[]{DaiLy.getTenDL(), PhieuXuat_BUS.SoPhieuXuat(DaiLy.getMaDL(),Thang.getMonth()+1),PhieuXuat_BUS.TongDoanhSo(Thang.getMonth()+1,DaiLy.getMaDL())
									,(double)Math.round((float)PhieuXuat_BUS.TongDoanhSo(Thang.getMonth()+1,DaiLy.getMaDL())/Sum*100*100)/100});
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnXemDoanhSo.setBounds(207, 40, 129, 40);
		frame.getContentPane().add(btnXemDoanhSo);
		
		JLabel lblNewLabel = new JLabel("Th\u00E1ng");
		lblNewLabel.setBounds(10, 53, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		Thang = new JMonthChooser();
		Thang.setBounds(66, 47, 131, 20);
		frame.getContentPane().add(Thang);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 431, 285);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}
}
