package tuan10;

import java.time.LocalDate;

public abstract class SanPham {
	protected String maSanPham;
	protected String tenSanPham;
	protected LocalDate ngaySanXuat;
	protected double giaNhap;
	protected int soLuongTon;
	
	public SanPham() {
		this.maSanPham = "xxx";
		this.tenSanPham = "Chua xac dinh";
		this.ngaySanXuat = LocalDate.now();
		this.giaNhap = 1.0;
		this.soLuongTon = 0;
	}

	public SanPham(String maSanPham, String tenSanPham, LocalDate ngaySanXuat, int giaNhap, int soLuongTon) {
		setMaSanPham(maSanPham);
		setTenSanPham(tenSanPham);
		setNgaySanXuat(ngaySanXuat);
		setGiaNhap(giaNhap);
		setSoLuongTon(soLuongTon);
	}
	
	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		if(maSanPham == null || maSanPham.trim().isEmpty()) {
			throw new IllegalArgumentException("Ma san pham khong duoc trong");
		}
		else {
			this.maSanPham = maSanPham;
		}
		
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		if(tenSanPham == null || tenSanPham.trim().isEmpty()) {
			throw new IllegalArgumentException("Ten san pham khong duoc trong");
		} else {
			this.tenSanPham = tenSanPham;
		}
		
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if(ngaySanXuat != null && ngaySanXuat.isAfter(LocalDate.now())) {
			this.ngaySanXuat = LocalDate.now();
		}
		else {
			this.ngaySanXuat = ngaySanXuat;
		}
		
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(int giaNhap) {
		if(giaNhap < 0) {
			throw new IllegalArgumentException("Gia nhap khong duoc nho hon 0!");
		}
		else {
			this.giaNhap = giaNhap;
		}
		
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		if(soLuongTon < 0) {
			throw new IllegalArgumentException("So luong ton khong duoc nho hon 0!");
		}
		else {
			this.soLuongTon = soLuongTon;
		}
		
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", ngaySanXuat=" + ngaySanXuat
				+ ", giaNhap=" + giaNhap + ", soLuongTon=" + soLuongTon + "]";
	}

	protected abstract String getLoai();

	protected abstract double getGiaBan();
	
	
	
}
