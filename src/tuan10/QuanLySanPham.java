package tuan10;

import java.util.*;
import java.util.stream.Collectors;


public class QuanLySanPham {
    private Map<String, SanPham> danhSachSanPham = new HashMap<>();

    public boolean themSanPham(SanPham sp) {
        if (danhSachSanPham.containsKey(sp.getMaSanPham())) {
            System.out.println("Loi: Trung ma san pham " + sp.getMaSanPham());
            return false;
        }
        danhSachSanPham.put(sp.getMaSanPham(), sp);
        return true;
    }

    public boolean xoaSanPham(String maSP) {
        if (danhSachSanPham.containsKey(maSP)) {
            danhSachSanPham.remove(maSP);
            return true;
        }
        return false;
    }

    public boolean suaSoLuongTon(String maSP, int soLuongMoi) {
        if (danhSachSanPham.containsKey(maSP)) {
            danhSachSanPham.get(maSP).setSoLuongTon(soLuongMoi);
            return true;
        }
        return false;
    }

    public List<SanPham> xuatSanPhamTheoLoai(String loai) {
        return danhSachSanPham.values().stream()
                .filter(sp -> sp.getLoai().equalsIgnoreCase(loai))
                .collect(Collectors.toList());
    }

    public List<SanPham> xuatSanPhamGiaBanCaoNhat() {
        if (danhSachSanPham.isEmpty()) return new ArrayList<>();
        
        double giaCaoNhat = danhSachSanPham.values().stream()
                .mapToDouble(SanPham::getGiaBan)
                .max()
                .orElse(0.0);

        return danhSachSanPham.values().stream()
                .filter(sp -> sp.getGiaBan() == giaCaoNhat)
                .collect(Collectors.toList());
    }
}
