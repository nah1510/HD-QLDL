package QLDL_GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.Quan_BUS;
import QLDL_BUS.ThamSo_BUS;
import QLDL_DAL.HoSoDL_DAL;
import QLDL_DTO.HoSoDL_DTO;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.Quan_DTO;
import QLDL_BUS.HoSoDL_BUS;


import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class frmTiepNhanDaiLy {

	
	private static int MaLoaiDL = 0;
	private JFrame frame;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JComboBox cbxLoaiDL;
	private JComboBox cbxQuan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTiepNhanDaiLy window = new frmTiepNhanDaiLy();
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
	public frmTiepNhanDaiLy() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 667, 312);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Th\u00EAm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoaiDL_BUS LoaiDL_bus=new LoaiDL_BUS();
					ArrayList<LoaiDL_DTO> listLoaiDL_DTO=new ArrayList <LoaiDL_DTO>();
					listLoaiDL_DTO=LoaiDL_bus.selectAll();
					LoaiDL_DTO LoaiDL=listLoaiDL_DTO.get(cbxLoaiDL.getSelectedIndex());
					Quan_BUS Quan_bus=new Quan_BUS();
					//ArrayList<Quan_DTO> listQuan_DTO=new ArrayList <Quan_DTO>();
					//listQuan_DTO=Quan_bus.selectAll();
					//Quan_DTO Quan=listQuan_DTO.get(cbxQuan.getSelectedIndex());
					Quan_DTO Quan=Quan_bus.selectAll().get(cbxQuan.getSelectedIndex());
					 
					HoSoDL_DTO HoSoDaiLy = new HoSoDL_DTO(txtTen.getText(),LoaiDL.getMaLoaiDL(), txtSDT.getText(), txtDiaChi.getText(), Quan.getMaQuan(), txtEmail.getText(), new java.sql.Date(System.currentTimeMillis()));
					if(HoSoDL_DAL.DemQuan(Quan.getMaQuan())==ThamSo_BUS.SoDaiLyToiDa()) 
						{
							JOptionPane.showMessageDialog(null, "Quận bạn chọn đã đủ số đại lý");
						}
					else
						{
							if(HoSoDL_BUS.Insert(HoSoDaiLy) == true) {
								JOptionPane.showMessageDialog(null, "Insert Employee Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Insert Employee Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
							}
						}
					} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(261, 190, 89, 35);
		frame.getContentPane().add(button);
		
		JLabel lbTenDL = new JLabel("T\u00EAn \u0111\u1EA1i l\u00FD");
		lbTenDL.setBounds(10, 14, 89, 14);
		frame.getContentPane().add(lbTenDL);
		
		JLabel lblLoiiL = new JLabel("Lo\u1EA1i \u0111\u1EA1i l\u00FD");
		lblLoiiL.setBounds(330, 14, 112, 14);
		frame.getContentPane().add(lblLoiiL);
		
		JLabel label_2 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		label_2.setBounds(330, 73, 89, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblinThoi = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblinThoi.setBounds(10, 73, 89, 14);
		frame.getContentPane().add(lblinThoi);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(64, 11, 221, 20);
		frame.getContentPane().add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(64, 70, 221, 20);
		frame.getContentPane().add(txtSDT);
		
		JLabel lblQun = new JLabel("Qu\u1EADn");
		lblQun.setBounds(10, 132, 89, 14);
		frame.getContentPane().add(lblQun);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setBounds(330, 132, 89, 14);
		frame.getContentPane().add(label_4);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(409, 129, 221, 20);
		frame.getContentPane().add(txtEmail);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(409, 70, 221, 20);
		frame.getContentPane().add(txtDiaChi);
		
		cbxLoaiDL = new JComboBox();
		cbxLoaiDL.setMaximumRowCount(100);
		cbxLoaiDL.setBounds(409, 11, 221, 20);
		frame.getContentPane().add(cbxLoaiDL);
		
		cbxQuan = new JComboBox();
		cbxQuan.setMaximumRowCount(100);
		cbxQuan.setBounds(64, 129, 221, 20);
		frame.getContentPane().add(cbxQuan);
		LoaiDL_BUS LoaiDL_bus=new LoaiDL_BUS();
		ResultSet rsDsLoaiDL= LoaiDL_bus.getListLoaiDaiLy();
		while(rsDsLoaiDL.next()) {
			String name=rsDsLoaiDL.getString("TenLoaiDL");
			cbxLoaiDL.addItem(name);
		}
		Quan_BUS Quan_bus=new Quan_BUS();
		ResultSet rsDsQuan= Quan_bus.getListQuan();
		while(rsDsQuan.next()) {
			String name=rsDsQuan.getString("TenQuan");
			cbxQuan.addItem(name);
		}
	}
}
