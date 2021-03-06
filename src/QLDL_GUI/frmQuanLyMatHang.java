package QLDL_GUI;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import QLDL_BUS.HoSoDL_BUS;
import QLDL_BUS.MatHang_BUS;
import QLDL_BUS.Quan_BUS;
import QLDL_DAL.LoaiDL_DAL;
import QLDL_DTO.HoSoDL_DTO;
import QLDL_DTO.MatHang_DTO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmQuanLyMatHang {

	private JFrame frame;
	private JTextField txtTraCui;
	private DefaultTableModel model;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuanLyMatHang window = new frmQuanLyMatHang();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public frmQuanLyMatHang() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 406);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã mặt hàng","Tên mặt hàng", "Đơn giá", "Số lượng tồn"
				}
			);
		
		txtTraCui = new JTextField();
		txtTraCui.setColumns(10);
		txtTraCui.setBounds(10, 55, 241, 20);
		frame.getContentPane().add(txtTraCui);
		
		JButton button = new JButton("T\u00ECm ki\u1EBFm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					timkiem();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(261, 54, 89, 23);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 545, 216);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton button_3 = new JButton("X\u00F3a");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()>=0)
				{
					int i=(int)table.getValueAt(table.getSelectedRow(), 0);
					try {
						MatHang_BUS.Delete((int)table.getValueAt(table.getSelectedRow(), 0));
						timkiem();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_3.setBounds(388, 54, 71, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("S\u1EEDa");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()>=0)
				{
					try {
						new frmSuaMatHang((int)table.getValueAt(table.getSelectedRow(), 0));
						frmSuaMatHang.main((int)table.getValueAt(table.getSelectedRow(), 0));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_4.setBounds(388, 100, 71, 23);
		frame.getContentPane().add(button_4);
		timkiem();
	}
	void timkiem() throws ClassNotFoundException, SQLException {
		model.setRowCount(0);
		ArrayList<MatHang_DTO> dsMatHang = MatHang_BUS.search((String)txtTraCui.getText());
		dsMatHang.forEach(MatHang -> {
			model.addRow(new Object[]{MatHang.getMaMatHang(), MatHang.getTenMatHang(),MatHang.getDonGia(), MatHang.getSoLuongTon()});
		});
	}
}
