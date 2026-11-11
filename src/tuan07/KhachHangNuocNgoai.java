package tuan07;

import java.time.LocalDate;

public class KhachHangNuocNgoai extends KhachHang {
    private String quocTinh;

    public KhachHangNuocNgoai(String ma, String hoTen, LocalDate ngay, double soKW, double donGia, String quocTinh) {
        super(ma, hoTen, ngay, soKW, donGia);
        setQuocTinh(quocTinh);
    }

    public String getQuocTinh() { return quocTinh; }

    public void setQuocTinh(String quocTinh) {
        if (quocTinh == null || quocTinh.isBlank()) {
            throw new IllegalArgumentException("Quốc tịch không được để trống");
        }
        this.quocTinh = quocTinh.trim();
    }

    @Override
    public double ThanhTien() {
        return getSoKW() * getDonGia();
    }

    @Override
    public String toString() {
        return super.toString() + "  Quốc tịch: " + quocTinh;
    }
}
