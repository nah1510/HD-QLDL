package QLDL_GUI;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.MatHang_BUS;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.MatHang_DTO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmQuanLyLoaiDaiLy {

	private JFrame frame;
	private JTextField txtTraCui;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuanLyLoaiDaiLy window = new frmQuanLyLoaiDaiLy();
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
	public frmQuanLyLoaiDaiLy() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 393);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã loại đại lý","Tên loại đại lý", "Nợ tối đa"
				}
			);
		
		txtTraCui = new JTextField();
		txtTraCui.setColumns(10);
		txtTraCui.setBounds(10, 34, 241, 20);
		frame.getContentPane().add(txtTraCui);
		
		JButton button = new JButton("Tìm kiếm");
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
		button.setBounds(261, 31, 89, 23);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 545, 216);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton button_1 = new JButton("Xóa");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()>=0)
				{
					int i=(int)table.getValueAt(table.getSelectedRow(), 0);
					try {
						LoaiDL_BUS.Delete((int)table.getValueAt(table.getSelectedRow(), 0));
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
		button_1.setBounds(388, 11, 71, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Sửa");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()>=0)
				{
					try {
						new frmSuaLoaiDaiLy((int)table.getValueAt(table.getSelectedRow(), 0));
						frmSuaLoaiDaiLy.main((int)table.getValueAt(table.getSelectedRow(), 0));
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
		button_2.setBounds(388, 57, 71, 23);
		frame.getContentPane().add(button_2);
		timkiem();
	}
	void timkiem() throws ClassNotFoundException, SQLException {
		model.setRowCount(0);
		ArrayList<LoaiDL_DTO> dsLoaiDL = LoaiDL_BUS.search((String)txtTraCui.getText());
		dsLoaiDL.forEach(LoaiDL -> {
			model.addRow(new Object[]{LoaiDL.getMaLoaiDL(), LoaiDL.getTenLoaiDL(),LoaiDL.getNoToiDa(),});
		});
	}
}
