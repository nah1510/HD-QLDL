package QLDL_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.Quan_BUS;
import QLDL_DAL.LoaiDL_DAL;
import QLDL_DAL.Quan_DAL;
import QLDL_DTO.HoSoDL_DTO;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.Quan_DTO;
import QLDL_BUS.HoSoDL_BUS;

public class frmTraCuuDaiLy {

	private JFrame frmTraCui;
	private JTextField txtTraCui;
	private JTable tbDanhSachDaiLy;
	private JButton btnThemPhieuXuat;
	private DefaultTableModel model;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTraCuuDaiLy window = new frmTraCuuDaiLy();
					window.frmTraCui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmTraCuuDaiLy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTraCui = new JFrame();
		frmTraCui.setTitle("Tra c\u1EE9u \u0111\u1EA1i l\u00FD");
		frmTraCui.setBounds(100, 100, 733, 434);
		frmTraCui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTraCui.getContentPane().setLayout(null);
		
		txtTraCui = new JTextField();
		txtTraCui.setBounds(143, 75, 241, 20);
		frmTraCui.getContentPane().add(txtTraCui);
		txtTraCui.setColumns(10);
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"MaDL","DaiLy", "Loai", "Quan", "TienNo"
				}
			);
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		TimKiem();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*try {
					model.setRowCount(0);
					ArrayList<HoSoDL_DTO> dsDaiLy = HoSoDL_BUS.search((String)txtTraCui.getText());
					dsDaiLy.forEach(DaiLy -> {
						try {
							model.addRow(new Object[]{DaiLy.getMaDL(), DaiLy.getTenDL(),LoaiDL_DAL.getTenLoaiDL(DaiLy.getMaLoaiDL()), Quan_BUS.getTenQuan(DaiLy.getQuan()),DaiLy.getTienNo()});
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
				}*/
				TimKiem();
			}
		});
		btnNewButton.setBounds(394, 74, 89, 23);
		frmTraCui.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 697, 216);
		frmTraCui.getContentPane().add(scrollPane);
		
		tbDanhSachDaiLy = new JTable(model);
		scrollPane.setViewportView(tbDanhSachDaiLy);
		
		btnThemPhieuXuat = new JButton("Th\u00EAm");
		btnThemPhieuXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						try {
							if (tbDanhSachDaiLy.getSelectedRow()>=0)
							{
								new frmPhieuXuatHang((int)tbDanhSachDaiLy.getValueAt(tbDanhSachDaiLy.getSelectedRow(), 0));
								frmPhieuXuatHang.main((int)tbDanhSachDaiLy.getValueAt(tbDanhSachDaiLy.getSelectedRow(), 0));
							}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
			}
		});
		btnThemPhieuXuat.setBounds(548, 74, 89, 23);
		frmTraCui.getContentPane().add(btnThemPhieuXuat);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbDanhSachDaiLy.getSelectedRow()>=0)
				{
					try {
						new frmPhieuThuTien((int)tbDanhSachDaiLy.getValueAt(tbDanhSachDaiLy.getSelectedRow(), 0));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmPhieuThuTien.main((int)tbDanhSachDaiLy.getValueAt(tbDanhSachDaiLy.getSelectedRow(), 0));
				}
			}
		});
		btnNewButton_1.setBounds(361, 121, 89, 23);
		frmTraCui.getContentPane().add(btnNewButton_1);
	}
	
	private void TimKiem() {
		try {
			model.setRowCount(0);
			ArrayList<HoSoDL_DTO> dsDaiLy = HoSoDL_BUS.search((String)txtTraCui.getText());
			dsDaiLy.forEach(DaiLy -> {
				try {
					model.addRow(new Object[]{DaiLy.getMaDL(), DaiLy.getTenDL(),LoaiDL_DAL.getTenLoaiDL(DaiLy.getMaLoaiDL()), Quan_BUS.getTenQuan(DaiLy.getQuan()),DaiLy.getTienNo()});
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
}
