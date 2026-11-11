package tuan07;

import java.time.LocalDate;

public class KhachHangVN extends KhachHang {
    private String doiTuong;
    private double dinhMuc;

    public KhachHangVN(String ma, String hoTen, LocalDate ngay, double soKW, double donGia,
                      String doiTuong, double dinhMuc) {
        super(ma, hoTen, ngay, soKW, donGia);
        setDoiTuong(doiTuong);
        setDinhMuc(dinhMuc);
    }

    public String getDoiTuong() { return doiTuong; }
    public double getDinhMuc() { return dinhMuc; }

    public void setDoiTuong(String doiTuong) {
        if (!"sinh hoạt".equalsIgnoreCase(doiTuong) && !"kinh doanh".equalsIgnoreCase(doiTuong)
                && !"sản xuất".equalsIgnoreCase(doiTuong)) {
            throw new IllegalArgumentException("Đối tượng phải là sinh hoạt, kinh doanh hoặc sản xuất");
        }
        this.doiTuong = doiTuong;
    }

    public void setDinhMuc(double dinhMuc) {
        if (!Double.isFinite(dinhMuc) || dinhMuc < 0) {
            throw new IllegalArgumentException("Định mức phải là số hữu hạn không âm");
        }
        this.dinhMuc = dinhMuc;
    }

    @Override
    public double ThanhTien() {
        double trongDinhMuc = Math.min(getSoKW(), dinhMuc);
        double vuotDinhMuc = getSoKW() - trongDinhMuc;
        return trongDinhMuc * getDonGia() + vuotDinhMuc * getDonGia() * 2.5;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("  %-12s Định mức %.1f", doiTuong, dinhMuc);
    }
}
