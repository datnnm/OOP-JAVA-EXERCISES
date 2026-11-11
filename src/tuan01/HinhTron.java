package tuan01;

public class HinhTron {
    private static final double PI = 3.14;

    private double banKinh;
    private ToaDo tam;

    public HinhTron() {
        this(new ToaDo(), 1);
    }

    public HinhTron(ToaDo tam, double banKinh) {
        setTam(tam);
        setBanKinh(banKinh);
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        if (!Double.isFinite(banKinh) || banKinh < 0) {
            throw new IllegalArgumentException("Bán kính phải là số hữu hạn không âm");
        }
        this.banKinh = banKinh;
    }

    public ToaDo getTam() {
        return tam;
    }

    public void setTam(ToaDo tam) {
        this.tam = java.util.Objects.requireNonNull(tam, "Tâm không được null");
    }

    public double tinhChuVi() {
        return 2 * PI * banKinh;
    }

    public double tinhDienTich() {
        return PI * banKinh * banKinh;
    }
}
