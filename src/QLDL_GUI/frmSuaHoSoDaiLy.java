package QLDL_GUI;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import QLDL_BUS.HoSoDL_BUS;
import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.Quan_BUS;
import QLDL_BUS.ThamSo_BUS;
import QLDL_DAL.HoSoDL_DAL;
import QLDL_DTO.HoSoDL_DTO;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.Quan_DTO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSuaHoSoDaiLy {

	private JFrame frame;
	private JTextField txtMaDL;
	private JTextField txtTenDL;
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
					frmSuaHoSoDaiLy window = new frmSuaHoSoDaiLy(args);
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
	public frmSuaHoSoDaiLy(int args) throws ClassNotFoundException, SQLException {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(int MaDL) throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 713, 414);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMiL = new JLabel("M\u00E3 \u0111\u1EA1i l\u00FD");
		lblMiL.setBounds(10, 30, 66, 14);
		frame.getContentPane().add(lblMiL);
		
		txtMaDL = new JTextField();
		txtMaDL.setText("Duy Nguyễn");
		txtMaDL.setEditable(false);
		txtMaDL.setColumns(10);
		txtMaDL.setBounds(79, 27, 221, 20);
		frame.getContentPane().add(txtMaDL);
		HoSoDL_DTO DaiLy=new HoSoDL_DTO();
		DaiLy=HoSoDL_BUS.getDaiLy(MaDL);
		txtMaDL.setText(String.valueOf(DaiLy.getMaDL()));
		
		JLabel label_1 = new JLabel("Điện thoại");
		label_1.setBounds(10, 77, 89, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Nợ");
		label_2.setBounds(343, 215, 89, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblTniL = new JLabel("T\u00EAn \u0111\u1EA1i l\u00FD");
		lblTniL.setBounds(343, 139, 89, 14);
		frame.getContentPane().add(lblTniL);
		
		txtTenDL = new JTextField();
		txtTenDL.setColumns(10);
		txtTenDL.setBounds(424, 133, 221, 20);
		frame.getContentPane().add(txtTenDL);
		txtTenDL.setText(DaiLy.getTenDL());
		
		txtEmail = new JTextField();
		txtEmail.setText("duy@gmail.com");
		txtEmail.setColumns(10);
		txtEmail.setBounds(424, 74, 221, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setText(DaiLy.getEmail());
		
		txtNo = new JTextField();
		txtNo.setEditable(false);
		txtNo.setText("Duy Nguyễn");
		txtNo.setColumns(10);
		txtNo.setBounds(424, 212, 221, 20);
		frame.getContentPane().add(txtNo);
		txtNo.setText(String.valueOf(DaiLy.getTienNo()));
		
		txtSDT = new JTextField();
		txtSDT.setText("Duy Nguyễn");
		txtSDT.setColumns(10);
		txtSDT.setBounds(79, 74, 221, 20);
		frame.getContentPane().add(txtSDT);
		txtSDT.setText(DaiLy.getDienThoai());
		
		txtDiaChi = new JTextField();
		txtDiaChi.setText("219 Đường số 12");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(424, 27, 221, 20);
		frame.getContentPane().add(txtDiaChi);
		txtDiaChi.setText(DaiLy.getDiaChi());
		
		JLabel label_4 = new JLabel("Địa chỉ");
		label_4.setBounds(343, 30, 89, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(343, 77, 89, 14);
		frame.getContentPane().add(label_5);
		
		JComboBox cbxLoaiDL = new JComboBox();
		cbxLoaiDL.setBounds(79, 136, 221, 20);
		frame.getContentPane().add(cbxLoaiDL);
		
		JLabel lblLoiiL = new JLabel("Lo\u1EA1i \u0111\u1EA1i l\u00FD");
		lblLoiiL.setBounds(10, 139, 66, 14);
		frame.getContentPane().add(lblLoiiL);
		
		JComboBox cbxQuan = new JComboBox();
		cbxQuan.setBounds(79, 212, 221, 20);
		frame.getContentPane().add(cbxQuan);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EADn");
		lblNewLabel.setBounds(10, 215, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoSoDL_DTO DaiLy=new HoSoDL_DTO();
					DaiLy=HoSoDL_BUS.getDaiLy(MaDL);
					LoaiDL_BUS LoaiDL_bus=new LoaiDL_BUS();
					ArrayList<LoaiDL_DTO> listLoaiDL_DTO=new ArrayList <LoaiDL_DTO>();
					listLoaiDL_DTO=LoaiDL_bus.selectAll();
					LoaiDL_DTO LoaiDL=listLoaiDL_DTO.get(cbxLoaiDL.getSelectedIndex());
					Quan_BUS Quan_bus=new Quan_BUS();
					//ArrayList<Quan_DTO> listQuan_DTO=new ArrayList <Quan_DTO>();
					//listQuan_DTO=Quan_bus.selectAll();
					//Quan_DTO Quan=listQuan_DTO.get(cbxQuan.getSelectedIndex());
					Quan_DTO Quan=Quan_bus.selectAll().get(cbxQuan.getSelectedIndex());
					//	(int MaDL, String TenDL , int MaLoaiDL , String DienThoai , String DiaChi , int MaQuan , String Email  
					HoSoDL_DTO HoSoDaiLy = new HoSoDL_DTO(DaiLy.getMaDL(),txtTenDL.getText(),LoaiDL.getMaLoaiDL(), txtSDT.getText(), txtDiaChi.getText(), Quan.getMaQuan(), txtEmail.getText());
					if(HoSoDL_DAL.DemQuan(Quan.getMaQuan())==ThamSo_BUS.SoDaiLyToiDa()) 
						{
							JOptionPane.showMessageDialog(null, "Quận bạn chọn đã đủ số đại lý");
						}
					else
						{
							if(HoSoDL_BUS.Update(HoSoDaiLy) == true) {
								JOptionPane.showMessageDialog(null, "Update Employee Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "Update Employee Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
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
		btnNewButton.setBounds(269, 317, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		Quan_BUS Quan_bus=new Quan_BUS();
		ResultSet rsDsQuan= Quan_bus.getListQuan();
		while(rsDsQuan.next()) {
			String name=rsDsQuan.getString("TenQuan");
			cbxQuan.addItem(name);
		}
		LoaiDL_BUS LoaiDL_bus=new LoaiDL_BUS();
		ResultSet rsDsLoaiDL= LoaiDL_bus.getListLoaiDaiLy();
		while(rsDsLoaiDL.next()) {
			String name=rsDsLoaiDL.getString("TenLoaiDL");
			cbxLoaiDL.addItem(name);
		}
	}
}
