package QLDL_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import QLDL_BUS.HoSoDL_BUS;
import QLDL_BUS.Quan_BUS;
import QLDL_BUS.ThamSo_BUS;
import QLDL_DTO.Quan_DTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frmThayDoiSoLuongDaiLyToiDaTrongQuan {

	private JFrame frame;
	private JTextField txtMaxDaiLy;
	private JTextField txtUpSL;
	private JLabel lblSLngi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThayDoiSoLuongDaiLyToiDaTrongQuan window = new frmThayDoiSoLuongDaiLyToiDaTrongQuan();
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
	public frmThayDoiSoLuongDaiLyToiDaTrongQuan() throws ClassNotFoundException, SQLException {
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

		JButton btnNewButton = new JButton("Thay \u0111\u1ED5i");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int max = Max();
				if(Integer.valueOf(txtUpSL.getText())<max)
				{
					JOptionPane.showMessageDialog(null, "Đã có quận có nhiều hơn số đại lý bạn vừa nhập");
				}
				else
				{
					try {
						ThamSo_BUS.upSoLuongDaiLy(Integer.valueOf(txtUpSL.getText()));
						load();
					} catch (NumberFormatException e) {
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
			}
		});
		btnNewButton.setBounds(197, 127, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		txtMaxDaiLy = new JTextField();
		txtMaxDaiLy.setEditable(false);
		txtMaxDaiLy.setBounds(261, 66, 86, 20);
		frame.getContentPane().add(txtMaxDaiLy);
		txtMaxDaiLy.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 l\u01B0\u1EE3ng \u0111\u1EA1i l\u00FD t\u1ED1i \u0111a trong qu\u1EADn hi\u1EC7n t\u1EA1i");
		lblNewLabel.setBounds(44, 69, 207, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtUpSL = new JTextField();
		txtUpSL.setText("0");
		txtUpSL.setColumns(10);
		txtUpSL.setBounds(261, 38, 86, 20);
		frame.getContentPane().add(txtUpSL);
		
		lblSLngi = new JLabel("S\u1ED1 l\u01B0\u1EE3ng \u0111\u1EA1i l\u00FD t\u1ED1i \u0111a trong qu\u1EADn");
		lblSLngi.setBounds(44, 41, 207, 14);
		frame.getContentPane().add(lblSLngi);
		load();
	}

	void load() throws ClassNotFoundException, SQLException {
		txtMaxDaiLy.setText(String.valueOf(ThamSo_BUS.SoDaiLyToiDa()));
	}
	int Max() {
		int max = 0;
		try {
			ArrayList<Quan_DTO> listQuan_DTO=new ArrayList <Quan_DTO>();
			Quan_BUS Quan_bus=new Quan_BUS();
			listQuan_DTO=Quan_bus.selectAll();
		
		for(int i=0;i<listQuan_DTO.size();i++)
		{
			if(max<HoSoDL_BUS.DemQuan(listQuan_DTO.get(i).getMaQuan()))
				max=HoSoDL_BUS.DemQuan(listQuan_DTO.get(i).getMaQuan());

		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
}
