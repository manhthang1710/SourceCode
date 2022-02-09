package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class KhachHang implements Serializable{
	private int maKhachHang;
	private String tenKhachHang;
	private Ve loaiVe;
	private Date ngaySinh;
	private boolean gioiTinh;
	private float soDienThoai;
	public KhachHang() {	
	}
	public KhachHang(int maKhachHang, String tenKhachHang, Ve loaiVe, Date ngaySinh, boolean gioiTinh,
			float soDienThoai) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.loaiVe = loaiVe;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public Ve getLoaiVe() {
		return loaiVe;
	}
	public void setLoaiVe(Ve loaiVe) {
		this.loaiVe = loaiVe;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public float getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(float soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", loaiVe=" + loaiVe
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(gioiTinh, loaiVe, maKhachHang, ngaySinh, soDienThoai, tenKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return gioiTinh == other.gioiTinh && Objects.equals(loaiVe, other.loaiVe) && maKhachHang == other.maKhachHang
				&& Objects.equals(ngaySinh, other.ngaySinh)
				&& Float.floatToIntBits(soDienThoai) == Float.floatToIntBits(other.soDienThoai)
				&& Objects.equals(tenKhachHang, other.tenKhachHang);
	}
	
}