package tuan06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham implements Comparable<HangThucPham> {
    private static final DateTimeFormatter DINH_DANG_NGAY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static int demSoLuong;

    private final int id;
    private final String maHang;
    private String tenHang;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private float gia;

    public HangThucPham() {
        this(String.format("MH%03d", demSoLuong + 1), "Hàng mặc định", LocalDate.now(), LocalDate.now().plusDays(1), 1);
    }

    public HangThucPham(String maHang, String tenHang, LocalDate ngaySanXuat, LocalDate ngayHetHan, float gia) {
        if (maHang == null || maHang.isBlank()) {
            throw new IllegalArgumentException("Mã hàng không được để trống");
        }
        this.maHang = maHang.trim();
        capNhatThongTin(tenHang, ngaySanXuat, ngayHetHan, gia);
        this.id = ++demSoLuong;
    }

    public int getId() { return id; }
    public String getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }
    public LocalDate getNgaySanXuat() { return ngaySanXuat; }
    public LocalDate getNgayHetHan() { return ngayHetHan; }
    public float getGia() { return gia; }
    public static int getDemSoLuong() { return demSoLuong; }

    public void setTenHang(String tenHang) {
        capNhatThongTin(tenHang, ngaySanXuat, ngayHetHan, gia);
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        capNhatThongTin(tenHang, ngaySanXuat, ngayHetHan, gia);
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        capNhatThongTin(tenHang, ngaySanXuat, ngayHetHan, gia);
    }

    public void setGia(float gia) {
        capNhatThongTin(tenHang, ngaySanXuat, ngayHetHan, gia);
    }

    void capNhatThongTin(String tenHang, LocalDate ngaySanXuat, LocalDate ngayHetHan, float gia) {
        if (tenHang == null || tenHang.isBlank()) {
            throw new IllegalArgumentException("Tên hàng không được để trống");
        }
        if (!KiemTraNgaySanXuat(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày sản xuất không được ở tương lai");
        }
        if (!KiemTraNgayHetHan(ngaySanXuat, ngayHetHan)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất");
        }
        if (!Float.isFinite(gia) || gia < 0) {
            throw new IllegalArgumentException("Giá phải là số hữu hạn không âm");
        }
        this.tenHang = tenHang.trim();
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.gia = gia;
    }

    public boolean KiemTraNgaySanXuat(LocalDate ngaySanXuat) {
        return ngaySanXuat != null && !ngaySanXuat.isAfter(LocalDate.now());
    }

    public boolean KiemTraNgayHetHan(LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        return ngaySanXuat != null && ngayHetHan != null && ngayHetHan.isAfter(ngaySanXuat);
    }

    public boolean KiemTraHetHan() {
        return ngayHetHan.isBefore(LocalDate.now());
    }

    public String TrangThaiChiTiet() {
        long soNgay = ngayHetHan.toEpochDay() - LocalDate.now().toEpochDay();
        if (soNgay < 0) {
            return "Hết hạn";
        }
        return soNgay == 0 ? "Hết hạn hôm nay" : "Còn " + soNgay + " ngày";
    }

    @Override
    public int compareTo(HangThucPham hangKhac) {
        return Integer.compare(id, hangKhac.id);
    }

    @Override
    public String toString() {
        return String.format("| %7d | %-10s | %-20s | %10s | %10s | %,10.2f | %-16s |",
                id, maHang, tenHang, ngaySanXuat.format(DINH_DANG_NGAY), ngayHetHan.format(DINH_DANG_NGAY),
                gia, TrangThaiChiTiet());
    }
}
