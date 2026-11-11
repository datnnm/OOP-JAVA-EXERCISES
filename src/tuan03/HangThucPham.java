package tuan03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {
    private static final DateTimeFormatter DINH_DANG_NGAY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final String maHang;
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        if (maHang == null || maHang.isBlank()) {
            throw new IllegalArgumentException("Mã hàng không được để trống");
        }
        this.maHang = maHang.trim();
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    public HangThucPham(String maHang) {
        this(maHang, null, 0, null, null);
    }

    public String getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }
    public double getDonGia() { return donGia; }
    public LocalDate getNgaySanXuat() { return ngaySanXuat; }
    public LocalDate getNgayHetHan() { return ngayHetHan; }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang == null || tenHang.isBlank() ? "xxx" : tenHang.trim();
    }

    public void setDonGia(double donGia) {
        this.donGia = Double.isFinite(donGia) && donGia >= 0 ? donGia : 0;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        LocalDate homNay = LocalDate.now();
        this.ngaySanXuat = ngaySanXuat != null && ngaySanXuat.isBefore(homNay) ? ngaySanXuat : homNay;
        if (ngayHetHan == null || ngayHetHan.isBefore(this.ngaySanXuat)) {
            ngayHetHan = this.ngaySanXuat;
        }
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan != null && ngayHetHan.isAfter(ngaySanXuat) ? ngayHetHan : ngaySanXuat;
    }

    public boolean isHetHan() {
        return ngayHetHan.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("%-10s %-16s %,18.2f %15s %15s %15s", maHang, tenHang, donGia,
                ngaySanXuat.format(DINH_DANG_NGAY), ngayHetHan.format(DINH_DANG_NGAY),
                isHetHan() ? "Hết hạn" : "Chưa hết hạn");
    }
}
