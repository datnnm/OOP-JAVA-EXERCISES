package tuan05;

public class CongNhan {
    private String maCN;
    private String ho;
    private String ten;
    private int soSP;

    public CongNhan() {
        this("CN001", "Chưa xác định", "Chưa xác định", 1);
    }

    public CongNhan(String maCN, String ho, String ten, int soSP) {
        setMaCN(maCN);
        setHo(ho);
        setTen(ten);
        setSoSP(soSP);
    }

    public String getMaCN() { return maCN; }
    public String getHo() { return ho; }
    public String getTen() { return ten; }
    public int getSoSP() { return soSP; }

    public void setMaCN(String maCN) {
        if (maCN == null || maCN.isBlank()) {
            throw new IllegalArgumentException("Mã công nhân không được để trống");
        }
        this.maCN = maCN.trim();
    }

    public void setHo(String ho) {
        this.ho = ho == null || ho.isBlank() ? "Chưa xác định" : ho.trim();
    }

    public void setTen(String ten) {
        this.ten = ten == null || ten.isBlank() ? "Chưa xác định" : ten.trim();
    }

    public void setSoSP(int soSP) {
        if (soSP <= 0) {
            throw new IllegalArgumentException("Số sản phẩm phải lớn hơn 0");
        }
        this.soSP = soSP;
    }

    public double tinhLuong() {
        int bac1 = Math.min(soSP, 199);
        int bac2 = Math.max(0, Math.min(soSP, 399) - 199);
        int bac3 = Math.max(0, Math.min(soSP, 599) - 399);
        int bac4 = Math.max(0, soSP - 599);
        return bac1 * 0.50 + bac2 * 0.55 + bac3 * 0.60 + bac4 * 0.65;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-28s %12d %,12.2f", maCN, ho + " " + ten, soSP, tinhLuong());
    }
}
