package tuan01;

import java.math.BigDecimal;

public class ToaDo {
    private String ten;
    private double x;
    private double y;

    public ToaDo() {
        this("O", 0, 0);
    }

    public ToaDo(double x, double y) {
        this("O", x, y);
    }

    public ToaDo(String ten, double x, double y) {
        setTen(ten);
        setX(x);
        setY(y);
    }

    public String getTen() { return ten; }
    public double getX() { return x; }
    public double getY() { return y; }

    public void setTen(String ten) {
        this.ten = ten == null || ten.isBlank() ? "O" : ten.trim();
    }

    public void setX(double x) {
        if (!Double.isFinite(x)) {
            throw new IllegalArgumentException("Tọa độ x phải hữu hạn");
        }
        this.x = x;
    }

    public void setY(double y) {
        if (!Double.isFinite(y)) {
            throw new IllegalArgumentException("Tọa độ y phải hữu hạn");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return ten + "(" + dinhDang(x) + "," + dinhDang(y) + ")";
    }

    private String dinhDang(double giaTri) {
        return BigDecimal.valueOf(giaTri).stripTrailingZeros().toPlainString();
    }
}
