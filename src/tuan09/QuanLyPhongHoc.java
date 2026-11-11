package tuan09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyPhongHoc {
    private final List<PhongHoc> ds;

    public QuanLyPhongHoc() {
        ds = new ArrayList<PhongHoc>();
    }

    public boolean themPhongHoc(PhongHoc p) {
        if (p == null || timPhongHoc(p.getMaPhong()) != null) {
            return false;
        }
        ds.add(p);
        return true;
    }

    public PhongHoc timPhongHoc(String maPhong) {
        for (PhongHoc p : ds) {
            if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<PhongHoc> getDanhSach() {
        return new ArrayList<PhongHoc>(ds);
    }

    public ArrayList<PhongHoc> layPhongDatChuan() {
        ArrayList<PhongHoc> kq = new ArrayList<PhongHoc>();

        for (PhongHoc p : ds) {
            if (p.datChuan()) {
                kq.add(p);
            }
        }
        return kq;
    }

    public void sapXepTangTheoDayNha() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return p1.getDayNha().compareToIgnoreCase(p2.getDayNha());
            }
        });
    }

    public void sapXepGiamTheoDienTich() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Double.compare(
                    p2.getDienTich(), p1.getDienTich()
                );
            }
        });
    }

    public void sapXepTangTheoSoBongDen() {
        Collections.sort(ds, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Integer.compare(
                    p1.getSoBongDen(), p2.getSoBongDen()
                );
            }
        });
    }

    public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
        PhongHoc p = timPhongHoc(maPhong);

        if (p instanceof PhongHocMayTinh && soMayMoi >= 0) {
            PhongHocMayTinh pm = (PhongHocMayTinh) p;
            pm.setSoMayTinh(soMayMoi);
            return true;
        }
        return false;
    }

    public boolean xoaPhongHoc(String maPhong) {
        PhongHoc p = timPhongHoc(maPhong);

        if (p != null) {
            ds.remove(p);
            return true;
        }
        return false;
    }

    public int tinhTongSoPhong() {
        return ds.size();
    }

    public ArrayList<PhongHocMayTinh> layPhongMayCo60May() {
        ArrayList<PhongHocMayTinh> kq =
            new ArrayList<PhongHocMayTinh>();

        for (PhongHoc p : ds) {
            if (p instanceof PhongHocMayTinh) {
                PhongHocMayTinh pm = (PhongHocMayTinh) p;

                if (pm.getSoMayTinh() == 60) {
                    kq.add(pm);
                }
            }
        }
        return kq;
    }

    public void hienThiDanhSach(List<? extends PhongHoc> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (PhongHoc p : danhSach) {
            System.out.println(p);
        }
    }

    public void hienThiTatCa() {
        hienThiDanhSach(ds);
    }
}
