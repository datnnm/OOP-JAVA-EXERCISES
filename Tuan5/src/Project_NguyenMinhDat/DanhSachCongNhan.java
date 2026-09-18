package Project_NguyenMinhDat;

public class DanhSachCongNhan {
	private CongNhan[] ds;
	private int soLuong;
	
	public DanhSachCongNhan(int n) {
		ds = new CongNhan[n];
		soLuong = 0;
	}
	
	public boolean themCongNhan(CongNhan cn) {
		if (soLuong < ds.length) {
			ds[soLuong] = cn;
			soLuong++;
			return true;
		}
		return false;
	}
	
	public void XuatDanhSach() {
		System.out.printf("%-10s %-15s %-15s %10s %10s%n", "Ma CN", "Ho", "Ten", "So SP", "Luong");
		for(int i = 0; i < soLuong; i++) {
			System.out.println(ds[i]);			
		}
	}	
	public int tinhSoLuong() {
			return soLuong;
	}
		
	public void XuatCongNhanTren200SP() {
		System.out.printf("%-10s %-15s %-15s %10s %10s%n", "Ma CN", "Ho", "Ten", "So SP", "Luong");
		for(int i = 0; i < soLuong; i++) {
			if(ds[i].getmSoSP() > 200) {
				System.out.println(ds[i]);
			}
		}
	}
		
	public void SapXepGiamDanTheoSoSP() {
		for(int i = 0; i < soLuong - 1; i++) {
			for(int j = i + 1; j < soLuong; j++) {
				if(ds[i].getmSoSP() < ds[j].getmSoSP()) {
					CongNhan temp = ds[i];
					ds[i] = ds[j];
					ds[j] = temp;
				}
			}
		}
	}
}
