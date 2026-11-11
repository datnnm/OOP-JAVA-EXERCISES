package tuan10;

import java.time.LocalDate;

public class SanPhamDienTu extends SanPham{
	private double giaBan;
	private int thoiGianBaoHanh;
	public SanPhamDienTu(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int giaNhap, int soLuongTon,
			double giaBan, int thoiGianBaoHanh) {
		super(maSanPham, tenSanPham, ngaySanXuat, giaNhap, soLuongTon);
		this.giaBan = giaBan;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		if(giaBan < 0) {
			throw new IllegalArgumentException("Gia ban phai lon hon 0!");
		}
		else {
			this.giaBan = giaBan;
		}
		
	}
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		if(thoiGianBaoHanh < 0) {
			this.thoiGianBaoHanh = 1;
		}
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	
	public double giaBan() {
		return giaBan = getGiaNhap() + (getGiaNhap() * 0.1) + (thoiGianBaoHanh * 50000);
	}

	@Override
	public String toString() {
		return super.toString()+"SanPhamDienTu [giaBan=" + giaBan + ", thoiGianBaoHanh=" + thoiGianBaoHanh + "]";
	}
	@Override
	protected String getLoai() {
		// TODO Auto-generated method stub
		return "Dien tu";
	}
	
}
