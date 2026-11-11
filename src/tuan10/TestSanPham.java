package tuan10;

import java.time.LocalDate;

public class TestSanPham {
    public static void main(String[] args) {
        QuanLySanPham ql = new QuanLySanPham();    
        SanPham sp1 = new SanPhamThucPham("TP01", "Sua tuoi TH True Milk", LocalDate.of(2026, 10, 1), 30000, 100, LocalDate.of(2026, 12, 31));
        SanPham sp2 = new SanPhamThucPham("TP02", "Banh mi an lien", LocalDate.of(2026, 9, 1), 15000, 20, LocalDate.of(2026, 10, 15));
        SanPham sp3 = new SanPhamDienTu("DT01", "Dien thoai iPhone 18", LocalDate.of(2025, 5, 20), 20000000, 15, 12, 0);
        SanPham sp4 = new SanPhamDienTu("DT02", "Laptop Asus ROG", LocalDate.of(2026, 1, 10), 30000000, 8, 24, 0);
        SanPham sp5 = new SanPhamDienTu("DT03", "Chuot Logitech G102", LocalDate.of(2026, 3, 15), 400000, 50, 6, 0);
        System.out.println("THUC THI THEM SAN PHAM");
        ql.themSanPham(sp1);
        ql.themSanPham(sp2);
        ql.themSanPham(sp3);
        ql.themSanPham(sp4);
        ql.themSanPham(sp5);
        SanPham spTrung = new SanPhamDienTu("DT01", "Day dien", LocalDate.now(), 100000, 5, 12, 0);
        ql.themSanPham(spTrung);
        System.out.println("\nCAP NHAT SO LUONG TON KHO");
        if(ql.suaSoLuongTon("DT01", 99)) {
            System.out.println("Cap nhat so luong san pham DT01 thanh cong!");
        }
        ql.xuatSanPhamTheoLoai("Dien tu");
        ql.xuatSanPhamTheoLoai("Thuc pham");
        ql.xuatSanPhamGiaBanCaoNhat();
        System.out.println("\nXOA SAN PHAM");
        if (ql.xoaSanPham("TP02")) {
            System.out.println("Xoa thanh cong san pham ma TP02!");
        }
    }
}
