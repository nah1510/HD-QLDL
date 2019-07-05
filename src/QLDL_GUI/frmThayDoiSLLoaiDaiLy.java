package QLDL_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import QLDL_BUS.HoSoDL_BUS;
import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.Quan_BUS;
import QLDL_BUS.ThamSo_BUS;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.Quan_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmThayDoiSLLoaiDaiLy {

	private JFrame frame;
	private JTextField txtMaxLoaiDaiLy;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThayDoiSLLoaiDaiLy window = new frmThayDoiSLLoaiDaiLy();
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
	public frmThayDoiSLLoaiDaiLy() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Thay đổi");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Integer.valueOf(textField_1.getText())<LoaiDL_BUS.demLoaiDL())
					{
						JOptionPane.showMessageDialog(null, "Số loại đại lý đã có nhiều hơn số loại đại lý tối đa bạn đã nhập");
					}
					else
					{
						ThamSo_BUS.upSoLuongLoaiDaiLy(Integer.valueOf(textField_1.getText()));
						load();
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(198, 151, 89, 23);
		frame.getContentPane().add(button);
		
		txtMaxLoaiDaiLy = new JTextField();
		txtMaxLoaiDaiLy.setText("5");
		txtMaxLoaiDaiLy.setEditable(false);
		txtMaxLoaiDaiLy.setColumns(10);
		txtMaxLoaiDaiLy.setBounds(262, 90, 86, 20);
		frame.getContentPane().add(txtMaxLoaiDaiLy);
		
		JLabel lblSLngLoi_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng lo\u1EA1i \u0111\u1EA1i l\u00FD t\u1ED1i \u0111a hi\u1EC7n t\u1EA1i");
		lblSLngLoi_1.setBounds(45, 93, 207, 14);
		frame.getContentPane().add(lblSLngLoi_1);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(262, 62, 86, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblSLngLoi = new JLabel("S\u1ED1 l\u01B0\u1EE3ng lo\u1EA1i \u0111\u1EA1i l\u00FD");
		lblSLngLoi.setBounds(45, 65, 207, 14);
		frame.getContentPane().add(lblSLngLoi);
		load();
	}
	void load() throws ClassNotFoundException, SQLException {
		txtMaxLoaiDaiLy.setText(String.valueOf(ThamSo_BUS.SoLoaiDaiLyToiDa()));
	}
}
