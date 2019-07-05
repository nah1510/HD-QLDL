package QLDL_GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import QLDL_BUS.MatHang_BUS;
import QLDL_BUS.ThamSo_BUS;
import QLDL_DAL.MatHang_DAL;
import QLDL_DTO.MatHang_DTO;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmThemMatHang {

	private JFrame frame;
	private JTextField txtTenMatHang;
	private JTextField txtDonGia;
	private JTextField txtSoLuongTon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThemMatHang window = new frmThemMatHang();
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
	public frmThemMatHang() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 401, 367);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Thêm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(MatHang_BUS.demSoMH()==ThamSo_BUS.SoMatHang())
					{
						JOptionPane.showMessageDialog(null, "Số mặt hàng đã vượt quy định");
					}
					else
					{
						MatHang_DTO mathang=new MatHang_DTO(txtTenMatHang.getText(),Integer.valueOf(txtDonGia.getText()),Integer.valueOf(txtSoLuongTon.getText()));
				
						if(MatHang_BUS.insert(mathang)==true) {
							JOptionPane.showMessageDialog(null, "Insert Employee Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Insert Employee Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
					}
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
		button.setBounds(148, 255, 89, 35);
		frame.getContentPane().add(button);
		
		JLabel lblSLngTn = new JLabel("S\u1ED1 L\u01B0\u1EE3ng T\u1ED3n");
		lblSLngTn.setBounds(10, 178, 89, 14);
		frame.getContentPane().add(lblSLngTn);
		
		txtTenMatHang = new JTextField();
		txtTenMatHang.setColumns(10);
		txtTenMatHang.setBounds(111, 57, 221, 20);
		frame.getContentPane().add(txtTenMatHang);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(111, 116, 221, 20);
		frame.getContentPane().add(txtDonGia);
		
		JLabel lblnGi = new JLabel("\u0110\u01A1n gi\u00E1");
		lblnGi.setBounds(10, 119, 89, 14);
		frame.getContentPane().add(lblnGi);
		
		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(111, 175, 221, 20);
		frame.getContentPane().add(txtSoLuongTon);
		
		JLabel lblTnMtHng = new JLabel("T\u00EAn m\u1EB7t h\u00E0ng");
		lblTnMtHng.setBounds(10, 60, 112, 14);
		frame.getContentPane().add(lblTnMtHng);
	}

}
