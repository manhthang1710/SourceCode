package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.KhachHang;
import model.QLKHModel;
import model.Ve;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controllor.QLKHController;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class QLKHview extends JFrame {

	private JPanel contentPane;
	public QLKHModel model;
	public JTextField textField_SoVeTimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_SoDT;
	public ButtonGroup btn_gioiTinh;
	public JComboBox JcomboBox_LoaiVe;
	public JRadioButton RadioButton_Nam;
	public JRadioButton RadioButton_Nu;
	public JComboBox JcomboBox_LoaiVeTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLKHview frame = new QLKHview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLKHview() {
		this.model = new QLKHModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 684);
		ActionListener action = new QLKHController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuFile = new JMenu("File");
		MenuFile.setForeground(Color.BLACK);
		MenuFile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(MenuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		MenuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		MenuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		MenuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		MenuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setForeground(Color.BLACK);
		menuAbout.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("AboutMe");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lebel_LoaiVe1 = new JLabel("Lo\u1EA1i V\u00E9");
		lebel_LoaiVe1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lebel_LoaiVe1.setBounds(54, 20, 74, 50);
		contentPane.add(lebel_LoaiVe1);
		
		 JcomboBox_LoaiVeTimKiem = new JComboBox();
		JcomboBox_LoaiVeTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ArrayList<Ve> listVe = Ve.getDSVe();
		JcomboBox_LoaiVeTimKiem.addItem("Chọn Loại Vé");
		for(Ve ve : listVe) {
			JcomboBox_LoaiVeTimKiem.addItem(ve.getLoaiVe());
		}
		JcomboBox_LoaiVeTimKiem.setBounds(141, 20, 151, 50);
		contentPane.add(JcomboBox_LoaiVeTimKiem);
		
		JLabel label_SoVeTimKiem = new JLabel("S\u1ED1 V\u00E9");
		label_SoVeTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_SoVeTimKiem.setBounds(377, 20, 57, 50);
		contentPane.add(label_SoVeTimKiem);
		
		textField_SoVeTimKiem = new JTextField();
		textField_SoVeTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoVeTimKiem.setBounds(444, 23, 88, 47);
		contentPane.add(textField_SoVeTimKiem);
		textField_SoVeTimKiem.setColumns(10);
		
		JButton btn_tim = new JButton("T\u00ECm Ki\u1EBFm");
		btn_tim.addActionListener(action);
		btn_tim.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_tim.setBounds(586, 20, 99, 50);
		contentPane.add(btn_tim);
		
		JLabel label_DSKHguixe = new JLabel("Danh S\u00E1ch Kh\u00E1ch H\u00E0ng G\u1EEDi Xe");
		label_DSKHguixe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_DSKHguixe.setBounds(20, 80, 279, 41);
		contentPane.add(label_DSKHguixe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 815, 145);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 v\u00E9", "             T\u00EAn KH", " Lo\u1EA1i V\u00E9", " Ng\u00E0y Sinh", "   Gi\u1EDBi T\u00EDnh", "       So \u0110T"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(42);
		table.getColumnModel().getColumn(1).setPreferredWidth(143);
		table.getColumnModel().getColumn(2).setPreferredWidth(74);
		table.getColumnModel().getColumn(3).setPreferredWidth(61);
		table.getColumnModel().getColumn(4).setPreferredWidth(68);
		table.getColumnModel().getColumn(5).setPreferredWidth(92);
		scrollPane.setViewportView(table);
		
		JLabel lebel_TtKH = new JLabel("Thông Tin Khách Hàng");
		lebel_TtKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lebel_TtKH.setBounds(20, 270, 215, 34);
		contentPane.add(lebel_TtKH);
		
		JLabel leble_SoVe = new JLabel("Số Vé");
		leble_SoVe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		leble_SoVe.setBounds(30, 314, 57, 34);
		contentPane.add(leble_SoVe);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_ID.setColumns(10);
		textField_ID.setBounds(126, 314, 251, 47);
		contentPane.add(textField_ID);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(126, 371, 251, 47);
		contentPane.add(textField_HoVaTen);
		
		JLabel lebel_HoVaTen = new JLabel("Họ Và Tên");
		lebel_HoVaTen.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lebel_HoVaTen.setBounds(29, 376, 99, 34);
		contentPane.add(lebel_HoVaTen);
		
		JLabel lebel_LoaiVe2 = new JLabel("Loại Vé");
		lebel_LoaiVe2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lebel_LoaiVe2.setBounds(29, 430, 99, 34);
		contentPane.add(lebel_LoaiVe2);
		
		JcomboBox_LoaiVe = new JComboBox();
		JcomboBox_LoaiVe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JcomboBox_LoaiVe.addItem("Chọn Loại Vé");
		for(Ve ve : listVe) {
			JcomboBox_LoaiVe.addItem(ve.getLoaiVe());
		}
		JcomboBox_LoaiVe.setBounds(126, 428, 251, 47);
		contentPane.add(JcomboBox_LoaiVe);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(126, 495, 251, 47);
		contentPane.add(textField_NgaySinh);
		
		JLabel lebel_NgaySinh = new JLabel("Ngày Sinh");
		lebel_NgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lebel_NgaySinh.setBounds(29, 500, 99, 34);
		contentPane.add(lebel_NgaySinh);
		
		RadioButton_Nam = new JRadioButton("Nam");
		RadioButton_Nam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RadioButton_Nam.setBounds(597, 365, 64, 30);
		contentPane.add(RadioButton_Nam);
		
		JLabel lebel_GioiTinh = new JLabel("Giới Tính");
		lebel_GioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lebel_GioiTinh.setBounds(493, 365, 88, 34);
		contentPane.add(lebel_GioiTinh);
		
	    RadioButton_Nu = new JRadioButton("Nữ");
		RadioButton_Nu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RadioButton_Nu.setBounds(679, 365, 57, 30);
		contentPane.add(RadioButton_Nu);
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(RadioButton_Nam);
		btn_gioiTinh.add(RadioButton_Nu);
		
		JLabel lebel_SoDT = new JLabel("Số ĐT");
		lebel_SoDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lebel_SoDT.setBounds(493, 430, 99, 34);
		contentPane.add(lebel_SoDT);
		
		textField_SoDT = new JTextField();
		textField_SoDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoDT.setColumns(10);
		textField_SoDT.setBounds(562, 426, 251, 47);
		contentPane.add(textField_SoDT);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBounds(10, 299, 815, 250);
		contentPane.add(verticalBox_1);
		
		JButton Button_Them = new JButton("Thêm");
		Button_Them.addActionListener(action);
		Button_Them.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Button_Them.setBounds(18, 559, 110, 50);
		contentPane.add(Button_Them);
		
		JButton Button_Xoa = new JButton("Xóa");
		Button_Xoa.addActionListener(action);
		Button_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Button_Xoa.setBounds(189, 559, 110, 50);
		contentPane.add(Button_Xoa);
		
		JButton Button_CapNhat = new JButton("Cập Nhật");
		Button_Xoa.addActionListener(action);
		Button_CapNhat.addActionListener(action);
		Button_CapNhat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Button_CapNhat.setBounds(358, 559, 110, 50);
		contentPane.add(Button_CapNhat);
		
		JButton Button_Luu = new JButton("Lưu");
		Button_Luu.addActionListener(action);
		Button_Luu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Button_Luu.setBounds(540, 559, 110, 50);
		contentPane.add(Button_Luu);
		
		JButton Button_HuyBo = new JButton("Hủy Bỏ");
		Button_HuyBo.addActionListener(action);
		Button_HuyBo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Button_HuyBo.setBounds(703, 559, 110, 50);
		contentPane.add(Button_HuyBo);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_2.setBounds(10, 552, 815, 57);
		contentPane.add(verticalBox_2);
		
		JButton btn_Hủy = new JButton("Hủy tìm");
		btn_Hủy.addActionListener(action);
		btn_Hủy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_Hủy.setBounds(703, 20, 99, 50);
		contentPane.add(btn_Hủy);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.setBounds(10, 10, 815, 72);
		contentPane.add(verticalBox);
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_NgaySinh.setText("");
		textField_SoDT.setText("");
		JcomboBox_LoaiVe.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	public void themKhachHangVaoTable(KhachHang kh) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
     	model_table.addRow(
				new Object[]{
						kh.getMaKhachHang() + "",
						kh.getTenKhachHang(),
						kh.getLoaiVe().getDSVe(),
						kh.getNgaySinh().getDate() + "/" + (kh.getNgaySinh().getMonth() + 1) + "/"	+ (kh.getNgaySinh().getYear() + 1900),
						(kh.isGioiTinh() ? "Nam" : "Nữ"),
						kh.getSoDienThoai() + ""
				 });
	}
	public void themHoacCapNhatKhachHang(KhachHang kh) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(kh)) {
		this.model.insert(kh);
		this.themKhachHangVaoTable(kh);
		}else {
			this.model.update(kh);
			int soLuongDong = model_table.getRowCount();
			for(int i = 0;i<soLuongDong;i++) {
				String id = model_table.getValueAt( i,0)+"";
				if(id.equals(kh.getMaKhachHang()+""));
				model_table.setValueAt(kh.getMaKhachHang()+"",i,0);
				model_table.setValueAt(kh.getTenKhachHang()+"",i,1);
				model_table.setValueAt(kh.getLoaiVe().getDSVe()+"",i,2);
				model_table.setValueAt(kh.getNgaySinh().getDate() + "/" + (kh.getNgaySinh().getMonth() + 1) + "/"	+ (kh.getNgaySinh().getYear() + 1900)+"",i,3);
				model_table.setValueAt((kh.isGioiTinh() ? "Nam" : "Nữ"),i,4);
				model_table.setValueAt(kh.getSoDienThoai()+"",i,5);
			}
		}
	}

public KhachHang getKhachHangDangChon() {
	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	 int i_row = table.getSelectedRow();
	 model_table.getValueAt(i_row, 0);
	 int maKhachHang = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenKhachHang = 	model_table.getValueAt(i_row, 1)+"";
		Ve ve = Ve.getVeByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = (model_table.getValueAt(i_row, 3)+"");
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float soDienThoai = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		KhachHang kh = new KhachHang();
		return kh;
	
}
	public void hienThiThongTinKhachHangDaChon() {
		KhachHang kh = getKhachHangDangChon();
		
			this.textField_ID.setText(kh.getMaKhachHang()+"");
			this.textField_HoVaTen.setText(kh.getTenKhachHang());
			this.JcomboBox_LoaiVe.setSelectedItem(kh.getLoaiVe().getDSVe());
			String s_ngaySinh = kh.getNgaySinh().getDate() + "/" + (kh.getNgaySinh().getMonth() + 1) + "/"	+ (kh.getNgaySinh().getYear() + 1900);
			
			this.textField_NgaySinh.setText(s_ngaySinh+"");
			if(kh.isGioiTinh()) {
				RadioButton_Nam.setSelected(true);
			}else {
				RadioButton_Nu.setSelected(true);
			}
			//this.btn_gioiTinh.setSelected(null, gioiTinh);
			this.textField_SoDT.setText(kh.getSoDienThoai()+"");
			
			
			
	
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		 int i_row = table.getSelectedRow();
		 int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Khách hàng này");
		 if(luaChon==JOptionPane.YES_OPTION) {
		 KhachHang kh = getKhachHangDangChon();
		 this.model.delete(kh);
		 model_table.removeRow(i_row);
		
	}
	}
	public void thucHienThemKhachHang() {
		int maKhachHang = Integer.valueOf(this.textField_ID.getText());
		String tenKhachHang = this.textField_HoVaTen.getText();	
		int loaiVe = this.JcomboBox_LoaiVe.getSelectedIndex()-1;
		Ve ve = Ve.getVeById(loaiVe);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		if(this.RadioButton_Nam.isSelected()) {
			gioiTinh = true;
		}else if(this.RadioButton_Nu.isSelected()) {
			gioiTinh = false;
		}
		float soDienThoai = Float.valueOf(this.textField_SoDT.getText());
		KhachHang kh = new KhachHang(maKhachHang,tenKhachHang,ve,ngaySinh,gioiTinh,soDienThoai);
		this.themHoacCapNhatKhachHang(kh);
		
	}

	public void thucHienTim() {
		//Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		//Thuc hien tim kiem
		int loaiVe = this.JcomboBox_LoaiVeTimKiem.getSelectedIndex()-1;
		String soVeKhachHangTimKiem = this.textField_SoVeTimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> soVeCuaKhachHangCanXoa = new TreeSet<Integer>();
		if(loaiVe>=0) {
			Ve veDaChon = Ve.getVeById(loaiVe);
		for(int i = 0;i<soLuongDong;i++) {
			String DSVe = model_table.getValueAt( i,2)+"";
			String id = model_table.getValueAt( i,0)+"";
			if( !DSVe.equals((veDaChon.getLoaiVe()))) {
				soVeCuaKhachHangCanXoa.add(Integer.valueOf(id));
			}
			
		}
	}	
		if(soVeKhachHangTimKiem.length()>0) {
			for(int i = 0;i<soLuongDong;i++) {
				String id = model_table.getValueAt( i,0)+"";
				if( !id.equals(soVeKhachHangTimKiem)) {
					soVeCuaKhachHangCanXoa.add(Integer.valueOf(id));
				}
			}	
	}
		for (Integer soVeCanXoa : soVeCuaKhachHangCanXoa) {
			System.out.println(soVeCanXoa);
			soLuongDong = model_table.getRowCount();
			for(int i = 0;i<soLuongDong;i++) {
				String idTrongTable = model_table.getValueAt( i,0)+"";
				if(idTrongTable.equals(soVeCanXoa.toString())) {
					System.out.println("Đã Xóa"+i);
					try {
					model_table.removeRow(i);
					} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
		}
}

	public void thucHienTaiLaiDuLieu() {
		while(true) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		if(soLuongDong==0)
			break;
		else
			try {
				model_table.removeRow(0);
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		for(KhachHang kh : this.model.getDsKhachHang()) {
			this.themKhachHangVaoTable(kh);
		}
		
	}

	public void hienThiAboutMe() {
		JOptionPane.showMessageDialog(this,"Phần Mềm Quản Lý Bãi Giữ Xe 4.0");
		
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this,
				"Bạn có chắc chắn muốn Thoát Khỏi Chương Trình?",
				"Exit",
			JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(KhachHang kh : this.model.getDsKhachHang()) {
				oos.writeObject(kh);
			}
			oos.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			saveFile(file.getAbsolutePath());
		}
	}
	}
	public void openFile(File file) {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
				
				KhachHang kh = null;
				while((kh= (KhachHang) ois.readObject())!=null) {
					ds.add(kh);
			}
			
			ois.close();
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsKhachHang(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file.getAbsolutePath());
			thucHienTaiLaiDuLieu();
	}
		
	}
}
