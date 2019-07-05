package QLDL_GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.MatHang_BUS;
import QLDL_BUS.ThamSo_BUS;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.MatHang_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmThemLoaiDaiLy {

	private JFrame frame;
	private JTextField txtTenLoaiDL;
	private JTextField txtNomax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThemLoaiDaiLy window = new frmThemLoaiDaiLy();
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
	public frmThemLoaiDaiLy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTenLoaiDL = new JTextField();
		txtTenLoaiDL.setBounds(181, 72, 86, 20);
		frame.getContentPane().add(txtTenLoaiDL);
		txtTenLoaiDL.setColumns(10);
		
		txtNomax = new JTextField();
		txtNomax.setBounds(181, 114, 86, 20);
		frame.getContentPane().add(txtNomax);
		txtNomax.setColumns(10);
		
		JLabel xxx = new JLabel("T\u00EAn lo\u1EA1i \u0110\u1EA1i l\u00FD");
		xxx.setBounds(55, 75, 86, 14);
		frame.getContentPane().add(xxx);
		
		JLabel lblNewLabel_1 = new JLabel("N\u1EE3 t\u1ED1i \u0111a");
		lblNewLabel_1.setBounds(55, 117, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(LoaiDL_BUS.demLoaiDL()==ThamSo_BUS.SoLoaiDaiLyToiDa())
					{
						JOptionPane.showMessageDialog(null, "Số loại đại lý đã vượt quy định");
					}
					else
					{
						LoaiDL_DTO LoaiDL=new LoaiDL_DTO(txtTenLoaiDL.getText(),Integer.valueOf(txtNomax.getText()));
				
						if(LoaiDL_BUS.insert(LoaiDL)==true) {
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
		btnNewButton.setBounds(178, 181, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
