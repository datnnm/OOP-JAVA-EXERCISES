package tuan02;

public class SV {
    private int maSV;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    public SV() {
        this(1, "Chưa xác định", 0, 0);
    }

    public SV(int maSV, String hoTen, double diemLT, double diemTH) {
        setMaSV(maSV);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    public int getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public double getDiemLT() { return diemLT; }
    public double getDiemTH() { return diemTH; }

    public void setMaSV(int maSV) {
        this.maSV = maSV > 0 ? maSV : 1;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen == null || hoTen.isBlank() ? "Chưa xác định" : hoTen.trim();
    }

    public void setDiemLT(double diemLT) {
        this.diemLT = diemLT >= 0 && diemLT <= 10 ? diemLT : 0;
    }

    public void setDiemTH(double diemTH) {
        this.diemTH = diemTH >= 0 && diemTH <= 10 ? diemTH : 0;
    }

    public double getDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    @Override
    public String toString() {
        return String.format("%-8d %-28s %8.2f %8.2f %8.2f", maSV, hoTen, diemLT, diemTH, getDiemTB());
    }
}
