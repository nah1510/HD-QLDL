package QLDL_GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.MatHang_BUS;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.MatHang_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSuaLoaiDaiLy {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(int args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSuaLoaiDaiLy window = new frmSuaLoaiDaiLy(args);
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
	public frmSuaLoaiDaiLy(int a) throws ClassNotFoundException, SQLException {
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(int ma) throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		LoaiDL_DTO LoaiDL= LoaiDL_BUS.getLoaiDL(ma);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 74, 86, 20);
		frame.getContentPane().add(textField);
		textField.setText(LoaiDL.getTenLoaiDL());
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 116, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setText(String.valueOf(LoaiDL.getNoToiDa()));
		
		JLabel label = new JLabel("Tên loại Đại lý");
		label.setBounds(10, 77, 86, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Nợ tối đa");
		label_1.setBounds(10, 119, 86, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiDL_DTO LoaiDL=new LoaiDL_DTO(textField.getText(),Integer.valueOf(textField_1.getText()));
				try {
					if(LoaiDL_BUS.update(LoaiDL,ma)==true) {
						JOptionPane.showMessageDialog(null, "Update Employee Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Update Employee Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
}
				} catch (HeadlessException e1) {
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
		btnLu.setBounds(133, 183, 89, 23);
		frame.getContentPane().add(btnLu);
		
		JLabel lblMLoii = new JLabel("M\u00E3 lo\u1EA1i \u0111\u1EA1i l\u00FD");
		lblMLoii.setBounds(10, 28, 86, 14);
		frame.getContentPane().add(lblMLoii);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(136, 25, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setText(String.valueOf(LoaiDL.getMaLoaiDL()));
	}

}
