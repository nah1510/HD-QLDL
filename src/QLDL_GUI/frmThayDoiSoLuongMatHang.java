package QLDL_GUI;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.MatHang_BUS;
import QLDL_BUS.ThamSo_BUS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmThayDoiSoLuongMatHang {

	private JFrame frame;
	private JTextField txtMaxMatHang;
	private JTextField txtSLMH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThayDoiSoLuongMatHang window = new frmThayDoiSoLuongMatHang();
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
	public frmThayDoiSoLuongMatHang() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Thay đổi");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Integer.valueOf(txtSLMH.getText())<MatHang_BUS.demSoMH())
					{
						JOptionPane.showMessageDialog(null, "Số mặt hàng đã có nhiều hơn số mặt hàng tối đa bạn đã nhập");
					}
					else
					{
						ThamSo_BUS.upSoLuongMatHang(Integer.valueOf(txtSLMH.getText()));
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
		button.setBounds(215, 172, 89, 23);
		frame.getContentPane().add(button);
		
		txtMaxMatHang = new JTextField();
		txtMaxMatHang.setText("5");
		txtMaxMatHang.setEditable(false);
		txtMaxMatHang.setColumns(10);
		txtMaxMatHang.setBounds(279, 111, 86, 20);
		frame.getContentPane().add(txtMaxMatHang);
		
		JLabel lblSLngMt_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng m\u1EB7t h\u00E0ng t\u1ED1i \u0111a hi\u1EC7n t\u1EA1i");
		lblSLngMt_1.setBounds(62, 114, 207, 14);
		frame.getContentPane().add(lblSLngMt_1);
		
		txtSLMH = new JTextField();
		txtSLMH.setText("0");
		txtSLMH.setColumns(10);
		txtSLMH.setBounds(279, 83, 86, 20);
		frame.getContentPane().add(txtSLMH);
		
		JLabel lblSLngMt = new JLabel("S\u1ED1 l\u01B0\u1EE3ng m\u1EB7t h\u00E0ng");
		lblSLngMt.setBounds(62, 86, 207, 14);
		frame.getContentPane().add(lblSLngMt);
		load();
	}
	void load() throws ClassNotFoundException, SQLException {
		txtMaxMatHang.setText(String.valueOf(ThamSo_BUS.SoMatHang()));
	}
}
