package tuan01;

import java.util.Locale;

public class HinhTronMain {
    public static void main(String[] args) {
        HinhTron hinh = new HinhTron(new ToaDo("O", 5, 5), 10.5);
        System.out.printf(Locale.ROOT,
                "Hình tròn có tâm %s với bán kính %.1f có diện tích và chu vi lần lượt là %.3f và %.3f.%n",
                hinh.getTam(), hinh.getBanKinh(), hinh.tinhDienTich(), hinh.tinhChuVi());
    }
}
