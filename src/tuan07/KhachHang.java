package tuan07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class KhachHang {
    private static final DateTimeFormatter DINH_DANG_NGAY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final String maKhachHang;
    private String hoTen;
    private LocalDate ngayLapHoaDon;
    private double soKW;
    private double donGia;

    protected KhachHang(String maKhachHang, String hoTen, LocalDate ngayLapHoaDon, double soKW, double donGia) {
        if (maKhachHang == null || maKhachHang.isBlank()) {
            throw new IllegalArgumentException("Mã khách hàng không được để trống");
        }
        this.maKhachHang = maKhachHang.trim();
        setHoTen(hoTen);
        setNgayLapHoaDon(ngayLapHoaDon);
        setSoKW(soKW);
        setDonGia(donGia);
    }

    public String getMaKhachHang() { return maKhachHang; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgay() { return ngayLapHoaDon; }
    public double getSoKW() { return soKW; }
    public double getDonGia() { return donGia; }

    public void setHoTen(String hoTen) {
        if (hoTen == null || hoTen.isBlank()) {
            throw new IllegalArgumentException("Họ tên không được để trống");
        }
        this.hoTen = hoTen.trim();
    }

    public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
        this.ngayLapHoaDon = Objects.requireNonNull(ngayLapHoaDon, "Ngày lập hóa đơn không được null");
    }

    public void setSoKW(double soKW) {
        if (!Double.isFinite(soKW) || soKW < 0) {
            throw new IllegalArgumentException("Số kW phải là số hữu hạn không âm");
        }
        this.soKW = soKW;
    }

    public void setDonGia(double donGia) {
        if (!Double.isFinite(donGia) || donGia < 0) {
            throw new IllegalArgumentException("Đơn giá phải là số hữu hạn không âm");
        }
        this.donGia = donGia;
    }

    public abstract double ThanhTien();

    @Override
    public String toString() {
        return String.format("%-6s %-24s %10s %,8.1f %,10.2f %,14.2f",
                maKhachHang, hoTen, ngayLapHoaDon.format(DINH_DANG_NGAY), soKW, donGia, ThanhTien());
    }
}
