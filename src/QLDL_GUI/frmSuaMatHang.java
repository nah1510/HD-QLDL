package QLDL_GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import QLDL_BUS.MatHang_BUS;
import QLDL_BUS.ThamSo_BUS;
import QLDL_DTO.MatHang_DTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSuaMatHang {

	private JFrame frame;
	private JTextField txtTenMatHang;
	private JTextField txtDonGia;
	private JTextField txtSoLuongTon;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(int args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSuaMatHang window = new frmSuaMatHang(args);
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
	public frmSuaMatHang(int a) throws ClassNotFoundException, SQLException {
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(int ma) throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 365);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		MatHang_DTO MatHang= MatHang_BUS.getMatHang(ma);
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						MatHang_DTO mathang=new MatHang_DTO(txtTenMatHang.getText(),Integer.valueOf(txtDonGia.getText()),Integer.valueOf(txtSoLuongTon.getText()));
				
						if(MatHang_BUS.update(mathang,ma)==true) {
							JOptionPane.showMessageDialog(null, "Update Employee Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Update Employee Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
					}
				} catch (HeadlessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSa.setBounds(148, 214, 89, 35);
		frame.getContentPane().add(btnSa);
		
		JLabel label = new JLabel("Số Lượng Tồn");
		label.setBounds(10, 186, 89, 14);
		frame.getContentPane().add(label);
		
		txtTenMatHang = new JTextField();
		txtTenMatHang.setColumns(10);
		txtTenMatHang.setBounds(111, 65, 221, 20);
		frame.getContentPane().add(txtTenMatHang);
		txtTenMatHang.setText(MatHang.getTenMatHang());
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(111, 124, 221, 20);
		frame.getContentPane().add(txtDonGia);
		txtDonGia.setText(String.valueOf(MatHang.getDonGia()));
		
		JLabel label_1 = new JLabel("Đơn giá");
		label_1.setBounds(10, 127, 89, 14);
		frame.getContentPane().add(label_1);
		
		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(111, 183, 221, 20);
		frame.getContentPane().add(txtSoLuongTon);
		txtSoLuongTon.setText(String.valueOf(MatHang.getSoLuongTon()));
		
		JLabel label_2 = new JLabel("Tên mặt hàng");
		label_2.setBounds(10, 68, 112, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Mã mặt hàng");
		label_3.setBounds(10, 14, 77, 14);
		frame.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(111, 11, 221, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setText(String.valueOf(MatHang.getMaMatHang()));
	}

}
