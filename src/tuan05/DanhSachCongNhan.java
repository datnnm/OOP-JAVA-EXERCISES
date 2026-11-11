package tuan05;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachCongNhan {
    private final CongNhan[] danhSach;
    private int soLuong;

    public DanhSachCongNhan(int sucChua) {
        danhSach = new CongNhan[sucChua];
    }

    public boolean themCongNhan(CongNhan congNhan) {
        if (congNhan == null || soLuong == danhSach.length) {
            return false;
        }
        danhSach[soLuong++] = congNhan;
        return true;
    }

    public int getSize() {
        return soLuong;
    }

    public CongNhan[] layDanhSach() {
        return Arrays.copyOf(danhSach, soLuong);
    }

    public CongNhan[] layCongNhanTren200SanPham() {
        return Arrays.stream(danhSach, 0, soLuong)
                .filter(congNhan -> congNhan.getSoSP() > 200)
                .toArray(CongNhan[]::new);
    }

    public void sapXepGiamTheoSoSanPham() {
        Arrays.sort(danhSach, 0, soLuong, Comparator.comparingInt(CongNhan::getSoSP).reversed());
    }
}
