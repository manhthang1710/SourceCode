package model;

import java.util.ArrayList;
import java.util.Objects;

public class Ve implements Serializable{
	private int maVe;
	private String loaiVe;
	public Ve(int maVe, String loaiVe) {
		this.maVe = maVe;
		this.loaiVe = loaiVe;
	}
	public int getMaVe() {
		return maVe;
	}
	public void setMaVe(int maVe) {
		this.maVe = maVe;
	}
	public String getLoaiVe() { 
		return loaiVe;
	}
	public void setLoaiVe(String loaiVe) {
		this.loaiVe = loaiVe;
	}
	@Override
	public String toString() {
		return "Ve [maVe=" + maVe + ", loaiVe=" + loaiVe + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(loaiVe, maVe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ve other = (Ve) obj;
		return Objects.equals(loaiVe, other.loaiVe) && maVe == other.maVe;
	}
	public static ArrayList<Ve>getDSVe(){
		String[] arr_ve = {"Vé Thường",
						   "Vé Tháng",
						   "Vé Năm"};
		ArrayList<Ve> listVe = new ArrayList<Ve>();
		int i=0;
		for(String loaiVe : arr_ve) {
			Ve v = new Ve(i,loaiVe);
			listVe.add(v);
		}
		return listVe;
	}
	public static Ve getVeById(int loaiVe) {
	
		return Ve.getDSVe().get(loaiVe);
	}
	public static Ve getVeByTen(String loaiVe) {
		ArrayList<Ve> listVe = Ve.getDSVe();
		for(Ve ve : listVe) {
			if(ve.loaiVe.equals(loaiVe))
				return ve;
		}
		return null;
	}
	
}
