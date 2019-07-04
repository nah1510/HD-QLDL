package QLDL_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class frmMain {

	private JFrame frmQLDL;
	private static JPanel contentPane;
	static JDesktopPane desktopPane = new JDesktopPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new frmMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMain() {
		frmQLDL = new JFrame();
		frmQLDL.setTitle("Quản lý các đại lý");
		frmQLDL.setBounds(100, 100, 450, 300);
		frmQLDL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQLDL.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 240);
		frmQLDL.getContentPane().add(panel);
		
		JMenuBar menuBar = new JMenuBar();
		frmQLDL.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Nhân viên");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thêm");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Xóa");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sửa");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tìm kiếm");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Đại lý");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Tiếp nhận đại lý");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmThemNV.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		frmQLDL.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));

		desktopPane.setBorder(UIManager.getBorder("Button.border"));
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.SOUTH);
	}
}
