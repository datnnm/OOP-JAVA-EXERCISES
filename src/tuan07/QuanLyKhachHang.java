package tuan07;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHang implements QuanLyKhachHangds {
    private final List<KhachHang> danhSach = new ArrayList<>();

    @Override
    public boolean themKH(KhachHang khachHang) {
        return khachHang != null && timTheoMa(khachHang.getMaKhachHang()) == null && danhSach.add(khachHang);
    }

    @Override
    public boolean capNhat(String ma, double donGia) {
        KhachHang khachHang = timTheoMa(ma);
        if (khachHang == null || !Double.isFinite(donGia) || donGia < 0) {
            return false;
        }
        khachHang.setDonGia(donGia);
        return true;
    }

    @Override
    public boolean xoaMa(String ma) {
        return danhSach.removeIf(khachHang -> khachHang.getMaKhachHang().equalsIgnoreCase(ma));
    }

    public KhachHang timTheoMa(String ma) {
        for (KhachHang khachHang : danhSach) {
            if (khachHang.getMaKhachHang().equalsIgnoreCase(ma)) {
                return khachHang;
            }
        }
        return null;
    }

    public List<KhachHang> layTatCa() {
        return new ArrayList<>(danhSach);
    }

    public int demTheoLoai(Class<? extends KhachHang> loai) {
        return (int) danhSach.stream().filter(loai::isInstance).count();
    }

    public double tongSoKWTieuThuTheoLoai(Class<? extends KhachHang> loai) {
        return danhSach.stream().filter(loai::isInstance).mapToDouble(KhachHang::getSoKW).sum();
    }

    public double trungBinhTienKhachNuocNgoai() {
        return danhSach.stream().filter(KhachHangNuocNgoai.class::isInstance)
                .mapToDouble(KhachHang::ThanhTien).average().orElse(0);
    }

    public List<KhachHang> layHoaDonTheoThang(YearMonth thang) {
        List<KhachHang> ketQua = new ArrayList<>();
        for (KhachHang khachHang : danhSach) {
            if (YearMonth.from(khachHang.getNgay()).equals(thang)) {
                ketQua.add(khachHang);
            }
        }
        return ketQua;
    }
}
