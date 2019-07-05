package QLDL_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JMonthChooser;

import QLDL_BUS.HoSoDL_BUS;
import QLDL_BUS.PhieuThuTien_BUS;
import QLDL_BUS.PhieuXuat_BUS;
import QLDL_DTO.HoSoDL_DTO;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmPhieuCongNo {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private	JMonthChooser Thang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPhieuCongNo window = new frmPhieuCongNo();
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
	public frmPhieuCongNo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 766, 432);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Đại lý","Nợ đầu","Số tiền mua hàng","Số tiền đã thu", "Phát sinh", "Nợ"
				}
			);
		
		Thang = new JMonthChooser();
		Thang.setBounds(95, 47, 98, 20);
		frame.getContentPane().add(Thang);
		
		JLabel lblNewLabel = new JLabel("Th\u00E1ng");
		lblNewLabel.setBounds(26, 53, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton Xem = new JButton("Xem");
		Xem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.setRowCount(0);
					ArrayList<HoSoDL_DTO> dsDaiLy = HoSoDL_BUS.selectThang(Thang.getMonth()+1);
					dsDaiLy.forEach(DaiLy -> {
							
							try {
								model.addRow(new Object[]{DaiLy.getTenDL(), 
										DaiLy.getTienNo()+PhieuThuTien_BUS.TongPhieuThu(Thang.getMonth()+1,DaiLy.getMaDL())-PhieuXuat_BUS.TongDoanhSo(Thang.getMonth()+1,DaiLy.getMaDL()),
										PhieuXuat_BUS.TongDoanhSo(Thang.getMonth()+1,DaiLy.getMaDL())
										,PhieuThuTien_BUS.TongPhieuThu(Thang.getMonth()+1,DaiLy.getMaDL()),
										PhieuXuat_BUS.TongDoanhSo(Thang.getMonth()+1,DaiLy.getMaDL())-PhieuThuTien_BUS.TongPhieuThu(Thang.getMonth()+1,DaiLy.getMaDL())
										,DaiLy.getTienNo()});
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
		Xem.setBounds(282, 44, 89, 23);
		frame.getContentPane().add(Xem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 730, 266);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}
}
