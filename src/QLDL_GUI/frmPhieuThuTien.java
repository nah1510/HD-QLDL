package QLDL_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import QLDL_BUS.HoSoDL_BUS;
import QLDL_DTO.HoSoDL_DTO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPhieuThuTien {

	private JFrame frame;
	private JTextField txtDaiLy;
	private JTextField txtTien;
	private JTextField txtEmail;
	private JTextField txtNo;
	private JTextField txtSDT;
	private JTextField txtDiaChi;

	/**
	 * Launch the application.
	 */
	public static void main(int args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPhieuThuTien window = new frmPhieuThuTien(args);
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
	public frmPhieuThuTien(int args) throws ClassNotFoundException, SQLException {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(int MaDL) throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 712, 437);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Đại lý");
		label.setBounds(24, 49, 66, 14);
		frame.getContentPane().add(label);
		
		HoSoDL_DTO DaiLy=new HoSoDL_DTO();
		DaiLy=HoSoDL_BUS.getDaiLy(MaDL);
		txtDaiLy = new JTextField();
		txtDaiLy.setText("Duy Nguyễn");
		txtDaiLy.setEditable(false);
		txtDaiLy.setColumns(10);
		txtDaiLy.setBounds(93, 46, 221, 20);
		frame.getContentPane().add(txtDaiLy);
		txtDaiLy.setText(DaiLy.getTenDL());
		
		JLabel label_3 = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		label_3.setBounds(24, 96, 89, 14);
		frame.getContentPane().add(label_3);
		
		JLabel lblN = new JLabel("N\u1EE3");
		lblN.setBounds(24, 158, 89, 14);
		frame.getContentPane().add(lblN);
		
		JLabel lblSTinThu = new JLabel("S\u1ED1 ti\u1EC1n thu");
		lblSTinThu.setBounds(357, 158, 89, 14);
		frame.getContentPane().add(lblSTinThu);
		
		txtTien = new JTextField();
		txtTien.setColumns(10);
		txtTien.setBounds(438, 152, 221, 20);
		frame.getContentPane().add(txtTien);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(438, 93, 221, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setText(DaiLy.getEmail());
		
		txtNo = new JTextField();
		txtNo.setText("Duy Nguy\u1EC5n");
		txtNo.setEditable(false);
		txtNo.setColumns(10);
		txtNo.setBounds(93, 155, 221, 20);
		frame.getContentPane().add(txtNo);
		txtNo.setText(String.valueOf(DaiLy.getTienNo()));
		
		txtSDT = new JTextField();
		txtSDT.setText("Duy Nguy\u1EC5n");
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(93, 93, 221, 20);
		frame.getContentPane().add(txtSDT);
		txtSDT.setText(DaiLy.getDienThoai());
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(438, 46, 221, 20);
		frame.getContentPane().add(txtDiaChi);
		txtDiaChi.setText(DaiLy.getDiaChi());
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setBounds(357, 49, 89, 14);
		frame.getContentPane().add(lblaCh);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(357, 96, 89, 14);
		frame.getContentPane().add(lblEmail);
		
		JButton btnNewButton = new JButton("Nh\u1EADp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(txtTien.getText())>Integer.valueOf(txtNo.getText())){
					JOptionPane.showMessageDialog(null, "Số tiền thu không được lớn hơn nợ của đại lý");
				}
				else {
					try {
						//HoSoDL_BUS.UpdateNo(MaDL,Integer.valueOf(txtNo.getText())-Integer.valueOf(txtTien.getText()));
						if(HoSoDL_BUS.UpdateNo(MaDL,Integer.valueOf(txtNo.getText())-Integer.valueOf(txtTien.getText()))== true)
						{
							txtNo.setText(String.valueOf(Integer.valueOf(txtNo.getText())-Integer.valueOf(txtTien.getText())));
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
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(293, 266, 89, 46);
		frame.getContentPane().add(btnNewButton);
	}
}
