package Controllor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.KhachHang;
import model.Ve;
import view.QLKHview;

public class QLKHController implements ActionListener{
	QLKHview view;
	
	public QLKHController(QLKHview view) {
		super();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		//JOptionPane.showMessageDialog(view,"Bạn Vừa nhấn Vào: "+cm);
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuachon("Thêm");
		}else if(cm.equals("Lưu")) {
			try {
				this.view.thucHienThemKhachHang();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (cm.equals("Cập Nhật")) {
			this.view.hienThiThongTinKhachHangDaChon();
		} else if (cm.equals("Xóa")) {
			this.view.thucHienXoa();
		}else if (cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		}else if (cm.equals("Tìm Kiếm")) {
			this.view.thucHienTim();
		}else if (cm.equals("Hủy tìm")) {
			this.view.thucHienTaiLaiDuLieu ();
		}else if (cm.equals("AboutMe")) {
			this.view.hienThiAboutMe();
		}else if (cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if (cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if (cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}
}
}