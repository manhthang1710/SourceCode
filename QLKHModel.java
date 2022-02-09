package model;

import java.util.ArrayList;

public class QLKHModel {
	private ArrayList<KhachHang> dsKhachHang;
	private String luaChon;
	private String tenFile;

	public QLKHModel() {
		this.dsKhachHang = new ArrayList<KhachHang>();
		this.luaChon = "";
		this.tenFile = "";
	}
	public QLKHModel(ArrayList<KhachHang> dsKhachHang) {
		
		this.dsKhachHang = dsKhachHang;
	}
	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}
	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}
	public void insert(KhachHang khachHang) {
		this.dsKhachHang.add(khachHang);
	}
	public void delete(KhachHang kh) {
		for(KhachHang khachHang : dsKhachHang) {
			if(khachHang.getMaKhachHang()==kh.getMaKhachHang())
				this.dsKhachHang.remove(khachHang);
			
		}
}
	public void update(KhachHang khachHang) {
		this.delete(khachHang);
		this.insert(khachHang);
	}
	public String getLuachon() {
		return luaChon;
	}
	public void setLuachon(String luachon) {
		this.luaChon = luachon;
	}
	
	public String getTenFile() {
		return tenFile;
	}
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	public boolean kiemTraTonTai(KhachHang kh) {
		for(KhachHang khachHang : dsKhachHang) {
		if(khachHang.getMaKhachHang()== kh.getMaKhachHang())
			return true;
	}
	return false;
}
	
}