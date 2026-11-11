package tuan08;

import java.time.LocalDate;
import java.util.Objects;

public class SinhVien {
    private final String maSV;
    protected String hoTen;
    protected LocalDate ngaySinh;
    protected String lop;
    protected MonHoc monHoc;
    protected int soTinChi;

    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setNgaySinh(LocalDate ngaySinh) { this.ngaySinh = Objects.requireNonNull(ngaySinh, "Ngày sinh không được null"); }
    public void setLop(String lop) { this.lop = lop; }
    public void setMonHoc(MonHoc monHoc) { this.monHoc = monHoc; }
    public void setSoTinChi(int soTinChi) { this.soTinChi = soTinChi; }
    public String getLoai() { return "Sinh viên"; }
    public String getThongTinRieng() { return ""; }
    
    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgaySinh() { return this.ngaySinh; }
    public int getNamSinh() { return ngaySinh.getYear(); }
    public String getLop() { return this.lop; }
    public MonHoc getMonHoc() { return this.monHoc; }
    public int getSoTinChi() { return soTinChi; }
    public double thanhTien() { return soTinChi * monHoc.getDonGia(); }

    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String lop, int soTinChi, MonHoc monHoc) {
        if (maSV == null || maSV.isBlank()) {
            throw new IllegalArgumentException("Mã sinh viên không được để trống");
        }
        this.maSV = maSV.trim();
        this.hoTen = hoTen;
        setNgaySinh(ngaySinh);
        this.lop = lop;
        this.monHoc = monHoc;
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return String.format(
            "[%s] %s | Lớp: %s | NS: %s | Môn: %s (%d tín x %,.0f) | TT: %,.0f VNĐ",
            maSV, hoTen, lop, ngaySinh,
            monHoc.getTenMon(), soTinChi, monHoc.getDonGia(),
            thanhTien());
    }
}
