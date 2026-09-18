package Project_NguyenMinhDat;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap so cong nhan: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		DanhSachCongNhan ds = new DanhSachCongNhan(n);
		for(int i = 0; i < n; i++) {
			System.out.println("\nCong nhan thu " + (i + 1));
			
			System.out.print("Ma cong nhan: ");
			String ma = sc.nextLine();
			
			System.out.print("Ho: ");
			String ho = sc.nextLine();
			
			System.out.print("Ten: ");
			String ten = sc.nextLine();
			
			System.out.print("So san pham: ");
			int soSP = sc.nextInt();
			sc.nextLine();
			ds.themCongNhan(new CongNhan(ma, ho, ten, soSP));
		}
		System.out.println("\nDanh sach cong nhan:");
		ds.XuatDanhSach();
		System.out.println("\nSo luong cong nhan: " + ds.tinhSoLuong());
		ds.tinhSoLuong();
		System.out.println("\nCong nhan lam tren 200 san pham: ");
		ds.XuatCongNhanTren200SP();
		ds.SapXepGiamDanTheoSoSP();
		System.out.println("\nDanh sach sau khi sap xep giam dan:");
		ds.XuatDanhSach();
	}

}
