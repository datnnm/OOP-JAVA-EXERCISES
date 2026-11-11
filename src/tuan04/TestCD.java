package tuan04;

import java.util.Scanner;

public class TestCD {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int sucChua;
            do {
                sucChua = nhapSoNguyen(sc, "Nhập sức chứa danh sách CD: ");
            } while (sucChua <= 0);
            CDList ds = new CDList(sucChua);

            while (true) {
                System.out.println("\n1. Thêm CD   2. Xóa CD   3. Cập nhật giá   4. In danh sách");
                System.out.println("5. Tổng giá thành   6. Sắp xếp theo giá giảm dần");
                System.out.println("7. Sắp xếp theo tựa tăng dần   8. Đếm CD   0. Thoát");
                try {
                    switch (nhapSoNguyen(sc, "Chọn chức năng: ")) {
                        case 0:
                            return;
                        case 1:
                            int ma = nhapSoNguyen(sc, "Mã CD: ");
                            System.out.print("Tựa CD: ");
                            String tua = sc.nextLine();
                            int soBai = nhapSoNguyen(sc, "Số bài hát: ");
                            double gia = nhapGia(sc);
                            System.out.println(ds.themCD(new CD(ma, tua, soBai, gia))
                                    ? "Đã thêm CD." : "Mã CD trùng hoặc danh sách đã đầy.");
                            break;
                        case 2:
                            System.out.println(ds.xoa(nhapSoNguyen(sc, "Mã CD cần xóa: "))
                                    ? "Đã xóa CD." : "Không tìm thấy CD.");
                            break;
                        case 3:
                            int maSua = nhapSoNguyen(sc, "Mã CD cần cập nhật: ");
                            System.out.println(ds.capNhatGia(maSua, nhapGia(sc))
                                    ? "Đã cập nhật giá." : "Mã CD hoặc giá thành không hợp lệ.");
                            break;
                        case 4:
                            inDanhSach(ds);
                            break;
                        case 5:
                            System.out.printf("Tổng giá thành: %,.2f%n", ds.tinhTongGiaThanh());
                            break;
                        case 6:
                            ds.sapXepGiamTheoGia();
                            inDanhSach(ds);
                            break;
                        case 7:
                            ds.sapXepTangTheoTua();
                            inDanhSach(ds);
                            break;
                        case 8:
                            System.out.println("Số CD: " + ds.getCount());
                            break;
                        default:
                            System.out.println("Chức năng không hợp lệ.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Giá thành phải nhập bằng số.");
                }
            }
        }
    }

    private static int nhapSoNguyen(Scanner sc, String loiNhac) {
        while (true) {
            System.out.print(loiNhac);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập số nguyên.");
            }
        }
    }

    private static double nhapGia(Scanner sc) {
        System.out.print("Giá thành: ");
        return Double.parseDouble(sc.nextLine().trim());
    }

    private static void inDanhSach(CDList ds) {
        System.out.printf("%-8s %-30s %10s %15s%n", "Mã CD", "Tựa CD", "Số bài hát", "Giá thành");
        for (CD cd : ds.layDanhSach()) {
            System.out.println(cd);
        }
    }
}
