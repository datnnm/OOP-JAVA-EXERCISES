package tuan04;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class CDList {
    private final CD[] danhSach;
    private int soLuong;

    public CDList(int sucChua) {
        danhSach = new CD[sucChua];
    }

    public int getCount() {
        return soLuong;
    }

    public boolean themCD(CD cd) {
        if (cd == null || soLuong == danhSach.length || timViTri(cd.getMaCD()) >= 0) {
            return false;
        }
        danhSach[soLuong++] = cd;
        return true;
    }

    public boolean xoa(int maCD) {
        int viTri = timViTri(maCD);
        if (viTri < 0) {
            return false;
        }
        System.arraycopy(danhSach, viTri + 1, danhSach, viTri, soLuong - viTri - 1);
        danhSach[--soLuong] = null;
        return true;
    }

    public boolean capNhatGia(int maCD, double giaThanh) {
        int viTri = timViTri(maCD);
        if (viTri < 0 || !Double.isFinite(giaThanh) || giaThanh <= 0) {
            return false;
        }
        danhSach[viTri].setGiaThanh(giaThanh);
        return true;
    }

    public double tinhTongGiaThanh() {
        double tong = 0;
        for (int i = 0; i < soLuong; i++) {
            tong += danhSach[i].getGiaThanh();
        }
        return tong;
    }

    public CD[] layDanhSach() {
        return Arrays.copyOf(danhSach, soLuong);
    }

    public void sapXepGiamTheoGia() {
        Arrays.sort(danhSach, 0, soLuong, Comparator.comparingDouble(CD::getGiaThanh).reversed());
    }

    public void sapXepTangTheoTua() {
        Collator thuTuTiengViet = Collator.getInstance(Locale.forLanguageTag("vi-VN"));
        Arrays.sort(danhSach, 0, soLuong, Comparator.comparing(CD::getTuaCD, thuTuTiengViet));
    }

    private int timViTri(int maCD) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaCD() == maCD) {
                return i;
            }
        }
        return -1;
    }
}
