package tuan10;

import java.time.LocalDate;

public class SanPhamThucPham extends SanPham {
	private double giaBan;
	private LocalDate ngayHetHan;

	public SanPhamThucPham(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int giaNhap, int soLuongTon,
			LocalDate ngayHetHan) {
		super(maSanPham, tenSanPham, ngaySanXuat, giaNhap, soLuongTon);
		this.ngayHetHan = ngayHetHan;
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
	
	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if(ngayHetHan != null && ngayHetHan.isBefore(LocalDate.now())) {
			this.ngayHetHan = null;
		}
		this.ngayHetHan = ngayHetHan;
	}	
	
	public double giaBan(LocalDate ngayHetHan) {
		if(ngayHetHan != null && ngayHetHan.isBefore(LocalDate.now())) {
			this.giaBan = 0;
		}
		else {
			this.giaBan = getGiaNhap() + (getGiaNhap() * 0.05);
		}
		return giaBan;
	}

	@Override
	public String toString() {
		return super.toString()+"SanPhamThucPham [giaBan=" + giaBan + ", ngayHetHan=" + ngayHetHan + "]";
	}

	@Override
	protected String getLoai() {
		// TODO Auto-generated method stub
		return "Thuc pham";
	}
	
	
}