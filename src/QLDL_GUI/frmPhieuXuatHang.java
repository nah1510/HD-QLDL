package QLDL_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import QLDL_BUS.CTPhieuXuat_BUS;
import QLDL_BUS.DonViTinh_BUS;
import QLDL_BUS.HoSoDL_BUS;
import QLDL_BUS.LoaiDL_BUS;
import QLDL_BUS.MatHang_BUS;
import QLDL_BUS.PhieuXuat_BUS;
import QLDL_DAL.Dataconnect;
import QLDL_DAL.LoaiDL_DAL;
import QLDL_DTO.CTPhieuXuat_DTO;
import QLDL_DTO.DonViTinh_DTO;
import QLDL_DTO.HoSoDL_DTO;
import QLDL_DTO.LoaiDL_DTO;
import QLDL_DTO.MatHang_DTO;
import QLDL_DTO.PhieuXuat_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Label;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmPhieuXuatHang {

	private JFrame frame;
	private JTextField txtSoLuong;
	private JTextField txtTongTien;
	private JTable tbChiTietPhieuXuat;
	private JTextField txtTenDL;
	private JTextField txtNo;
	private JTextField txtNoMax;
	private JComboBox cbxMatHang;
	private	JComboBox cbxDonVi;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(int args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPhieuXuatHang window = new frmPhieuXuatHang(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param args 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public frmPhieuXuatHang(int args) throws ClassNotFoundException, SQLException {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param MaDL 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize(int MaDL) throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 921, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mặt hàng","Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền"
				}
			);
		
		JLabel label = new JLabel("Số lượng");
		label.setBounds(628, 107, 66, 14);
		frame.getContentPane().add(label);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(704, 104, 146, 20);
		frame.getContentPane().add(txtSoLuong);
		
		JButton button_1 = new JButton("Lưu");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Integer.valueOf(txtTongTien.getText())+Integer.valueOf(txtNo.getText()) >Integer.valueOf(txtNoMax.getText()))
					{
						JOptionPane.showMessageDialog(null, "Tổng nợ sẽ vượt quá nợ tối đa");
					}
					else
					{	int maPhieuXuat=Dataconnect.getID("phieuxuat", "MaPhieuXuat");
						PhieuXuat_DTO PhieuXuat=new PhieuXuat_DTO(MaDL,Integer.valueOf(txtTongTien.getText()));
						PhieuXuat_BUS.Insert(PhieuXuat);
						//(int MaPhieuXuat, int MaMatHang,int MaDVT,int SoLuongXuat,int ThanhTien)
						for(int i=0;i<tbChiTietPhieuXuat.getRowCount();i++)
						{
							CTPhieuXuat_DTO CTPhieuXuat=new CTPhieuXuat_DTO
									(maPhieuXuat, QLDL_BUS.MatHang_BUS.selectCondition(
											tbChiTietPhieuXuat.getValueAt(i, 0).toString()).getMaMatHang(),
											DonViTinh_BUS.selectCondition(tbChiTietPhieuXuat.getValueAt(i, 1).toString()).getMaDVT(), 
											Integer.valueOf(tbChiTietPhieuXuat.getValueAt(i, 2).toString()),
											Integer.valueOf(tbChiTietPhieuXuat.getValueAt(i, 4).toString())
											);
							CTPhieuXuat_BUS.Insert(CTPhieuXuat);
							HoSoDL_BUS.UpdateNo(MaDL,Integer.valueOf(txtTongTien.getText())+Integer.valueOf(txtNo.getText()));
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});
		button_1.setBounds(660, 329, 121, 71);
		frame.getContentPane().add(button_1);
		
		JButton btnXa = new JButton("Xóa ");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=tbChiTietPhieuXuat.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
				}
				TongTien();
			}
		});
		btnXa.setBounds(439, 317, 112, 37);
		frame.getContentPane().add(btnXa);
		
		JLabel lblNewLabel = new JLabel("\u0110\u1EA1i l\u00FD");
		lblNewLabel.setBounds(21, 48, 66, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(660, 237, 121, 46);
		frame.getContentPane().add(txtTongTien);
		
		JLabel lblTngTin = new JLabel("Chi tiết phiếu xuất");
		lblTngTin.setBounds(156, 214, 164, 23);
		
		frame.getContentPane().add(lblTngTin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 248, 385, 162);
		frame.getContentPane().add(scrollPane);
		
		tbChiTietPhieuXuat = new JTable(model);
		scrollPane.setViewportView(tbChiTietPhieuXuat);
		txtTenDL = new JTextField();
		txtTenDL.setEditable(false);
		txtTenDL.setBounds(97, 45, 146, 20);
		frame.getContentPane().add(txtTenDL);
		txtTenDL.setColumns(10);
		HoSoDL_DTO DaiLy=new HoSoDL_DTO();
		DaiLy=HoSoDL_BUS.getDaiLy(MaDL);
		txtTenDL.setText(DaiLy.getTenDL());
		
		txtNo = new JTextField();
		txtNo.setEditable(false);
		txtNo.setColumns(10);
		txtNo.setBounds(405, 45, 146, 20);
		frame.getContentPane().add(txtNo);
		txtNo.setText(String.valueOf(DaiLy.getTienNo()));
		
		LoaiDL_DTO LoaiDL=LoaiDL_DAL.selectCondition(DaiLy.getMaLoaiDL());
		JLabel lblN = new JLabel("Nợ hiện tại");
		lblN.setBounds(329, 48, 66, 14);
		frame.getContentPane().add(lblN);
		
		JLabel lblNTia = new JLabel("Nợ tối đa");
		lblNTia.setBounds(628, 48, 66, 14);
		frame.getContentPane().add(lblNTia);
		
		txtNoMax = new JTextField();
		txtNoMax.setEditable(false);
		txtNoMax.setColumns(10);
		txtNoMax.setBounds(704, 45, 146, 20);
		frame.getContentPane().add(txtNoMax);
		txtNoMax.setText(String.valueOf(LoaiDL.getNoToiDa()));
		
		
		JLabel lblNewLabel_1 = new JLabel("Tổng tiền");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(683, 191, 79, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Thêm mặt hàng");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtSoLuong.getText().equals("")!=true) {
					MatHang_BUS MatHang_BUS=new MatHang_BUS();
					ArrayList<MatHang_DTO> listMatHang=new ArrayList <MatHang_DTO>();
					listMatHang=MatHang_BUS.selectAll();
					MatHang_DTO MatHang=listMatHang.get(cbxMatHang.getSelectedIndex());
					DonViTinh_BUS DonViTinh_BUS=new DonViTinh_BUS();
					ArrayList<DonViTinh_DTO> listDonViTinh=new ArrayList <DonViTinh_DTO>();
					listDonViTinh=DonViTinh_BUS.selectAll();
					DonViTinh_DTO DonViTinh=listDonViTinh.get(cbxDonVi.getSelectedIndex());
				int Row=tbChiTietPhieuXuat.getRowCount();
				if(Row==0) {
					Object[] data=new Object[6];
					data[0]=cbxMatHang.getSelectedItem();
					data[1]=cbxDonVi.getSelectedItem();
					data[2]=txtSoLuong.getText();
					data[3]=MatHang.getDonGia();
					data[4]=DonViTinh.getSoLuongDVT()*MatHang.getDonGia()*Integer.parseInt(data[2].toString());
					model.addRow(data);
				}
				else
				for(int i=0;i<tbChiTietPhieuXuat.getRowCount();i++)
				{ 
					if(tbChiTietPhieuXuat.getValueAt(i, 0).toString().equals(cbxMatHang.getSelectedItem())&&tbChiTietPhieuXuat.getValueAt(i, 1).toString().equals(cbxDonVi.getSelectedItem()))
					{
						tbChiTietPhieuXuat.setValueAt(Integer.parseInt(tbChiTietPhieuXuat.getValueAt(i, 2).toString())+Integer.parseInt(txtSoLuong.getText()), i, 2);
						tbChiTietPhieuXuat.setValueAt(DonViTinh.getSoLuongDVT()*MatHang.getDonGia()*Integer.parseInt(tbChiTietPhieuXuat.getValueAt(i, 2).toString()), i, 4);
						tbChiTietPhieuXuat.repaint();
						break;
					}
					else if(i==tbChiTietPhieuXuat.getRowCount()-1){
						Object[] data=new Object[5];
						data[0]=cbxMatHang.getSelectedItem();
						data[1]=cbxDonVi.getSelectedItem();
						data[2]=txtSoLuong.getText();
						data[3]=MatHang.getDonGia();
						data[4]=DonViTinh.getSoLuongDVT()*MatHang.getDonGia()*Integer.parseInt(data[2].toString());
						model.addRow(data);
						break;
					}
				}
				TongTien();
					
					
					
				} }catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(406, 168, 145, 37);
		frame.getContentPane().add(btnNewButton);
		
		cbxMatHang = new JComboBox();
		cbxMatHang.setBounds(97, 104, 146, 20);
		frame.getContentPane().add(cbxMatHang);
		MatHang_BUS MatHang_BUS=new MatHang_BUS();
		ResultSet rsMatHang= QLDL_BUS.MatHang_BUS.getListMatHang();
		while(rsMatHang.next()) {
			String name=rsMatHang.getString("TenMatHang");
			cbxMatHang.addItem(name);
		}
		
		cbxDonVi = new JComboBox();
		cbxDonVi.setBounds(405, 104, 146, 20);
		frame.getContentPane().add(cbxDonVi);
		DonViTinh_BUS DonViTinh_BUS=new DonViTinh_BUS();
		ResultSet rsDonViTinh= QLDL_BUS.DonViTinh_BUS.getList();
		while(rsDonViTinh.next()) {
			String name=rsDonViTinh.getString("TenDVT");
			cbxDonVi.addItem(name);
		}
		
		JLabel lblMtHng_1 = new JLabel("Mặt hàng");
		lblMtHng_1.setBounds(21, 107, 66, 14);
		frame.getContentPane().add(lblMtHng_1);
		
		JLabel lblnVTnh = new JLabel("Đơn vị tính");
		lblnVTnh.setBounds(329, 107, 66, 14);
		frame.getContentPane().add(lblnVTnh);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x=cbxDonVi.getSelectedItem().toString();
				try {
					System.out.print(tbChiTietPhieuXuat.getValueAt(0, 0).toString());
					System.out.print(QLDL_BUS.MatHang_BUS.selectCondition(tbChiTietPhieuXuat.getValueAt(0, 0).toString()).getMaMatHang());
				} catch (ClassNotFoundException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(97, 176, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
	void TongTien() {
		int sum = 0;
		int Rowmax=tbChiTietPhieuXuat.getRowCount();
		for(int row = 0; row < Rowmax ; row++) {
			sum+= Integer.parseInt( tbChiTietPhieuXuat.getValueAt(row, 4).toString());
		}
		String s=String.valueOf(sum);
		txtTongTien.setText(String.valueOf(sum));
	}
}
