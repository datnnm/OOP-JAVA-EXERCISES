package tuan05;

import java.util.Scanner;

public class QuanLyCongNhan {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int soCongNhan = nhapSo(sc, "Nhập số công nhân: ", 1);
            DanhSachCongNhan ds = new DanhSachCongNhan(soCongNhan);

            for (int i = 1; i <= soCongNhan; i++) {
                System.out.println("\nCông nhân thứ " + i);
                System.out.print("Họ: ");
                String ho = sc.nextLine();
                System.out.print("Tên: ");
                String ten = sc.nextLine();
                int soSP = nhapSo(sc, "Số sản phẩm: ", 1);
                ds.themCongNhan(new CongNhan(String.format("CN%03d", i), ho, ten, soSP));
            }

            while (true) {
                System.out.println("\n1. In danh sách   2. Lọc trên 200 sản phẩm");
                System.out.println("3. Sắp xếp giảm theo sản phẩm   4. Đếm công nhân   0. Thoát");
                switch (nhapSo(sc, "Chọn chức năng: ", 0)) {
                    case 0:
                        return;
                    case 1:
                        inDanhSach(ds.layDanhSach());
                        break;
                    case 2:
                        inDanhSach(ds.layCongNhanTren200SanPham());
                        break;
                    case 3:
                        ds.sapXepGiamTheoSoSanPham();
                        inDanhSach(ds.layDanhSach());
                        break;
                    case 4:
                        System.out.println("Số công nhân: " + ds.getSize());
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ.");
                }
            }
        }
    }

    private static int nhapSo(Scanner sc, String loiNhac, int toiThieu) {
        while (true) {
            System.out.print(loiNhac);
            try {
                int so = Integer.parseInt(sc.nextLine().trim());
                if (so >= toiThieu) {
                    return so;
                }
            } catch (NumberFormatException e) {
                // Nhập lại nếu dữ liệu không phải số nguyên.
            }
            System.out.println("Hãy nhập số nguyên từ " + toiThieu + " trở lên.");
        }
    }

    private static void inDanhSach(CongNhan[] danhSach) {
        System.out.printf("%-8s %-28s %12s %12s%n", "Mã CN", "Họ tên", "Sản phẩm", "Lương");
        for (CongNhan congNhan : danhSach) {
            System.out.println(congNhan);
        }
    }
}
