package QLDL_GUI;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import QLDL_BUS.DonViTinh_BUS;
import QLDL_BUS.MatHang_BUS;
import QLDL_BUS.ThamSo_BUS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmThayDoiSoLuongDonViTinh {

	private JFrame frame;
	private JTextField maxDonViTinh;
	private JTextField txtDVT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThayDoiSoLuongDonViTinh window = new frmThayDoiSoLuongDonViTinh();
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
	public frmThayDoiSoLuongDonViTinh() throws ClassNotFoundException, SQLException {
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
					if(Integer.valueOf(txtDVT.getText())<DonViTinh_BUS.demSoDonViTinh_BUS())
					{
						JOptionPane.showMessageDialog(null, "Số đơn vị tính đã có nhiều hơn số đơn vị tính tối đa bạn đã nhập");
					}
					else
					{
						ThamSo_BUS.upSoDonViTInh(Integer.valueOf(txtDVT.getText()));
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
		button.setBounds(202, 144, 89, 23);
		frame.getContentPane().add(button);
		
		maxDonViTinh = new JTextField();
		maxDonViTinh.setText("5");
		maxDonViTinh.setEditable(false);
		maxDonViTinh.setColumns(10);
		maxDonViTinh.setBounds(266, 83, 86, 20);
		frame.getContentPane().add(maxDonViTinh);
		
		JLabel lblSnV = new JLabel("S\u1ED1 \u0111\u01A1n v\u1ECB t\u00EDnh t\u1ED1i \u0111a hi\u1EC7n t\u1EA1i");
		lblSnV.setBounds(49, 86, 207, 14);
		frame.getContentPane().add(lblSnV);
		
		txtDVT = new JTextField();
		txtDVT.setText("0");
		txtDVT.setColumns(10);
		txtDVT.setBounds(266, 55, 86, 20);
		frame.getContentPane().add(txtDVT);
		
		JLabel lblSLngn = new JLabel("S\u1ED1 l\u01B0\u1EE3ng \u0111\u01A1n v\u1ECB t\u00EDnh");
		lblSLngn.setBounds(49, 58, 207, 14);
		frame.getContentPane().add(lblSLngn);
		load();
	}
	void load() throws ClassNotFoundException, SQLException {
		maxDonViTinh.setText(String.valueOf(ThamSo_BUS.SoDonViTinh()));
	}
}
