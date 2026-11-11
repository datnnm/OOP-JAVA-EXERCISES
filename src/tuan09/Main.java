package tuan09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyPhongHoc ql = new QuanLyPhongHoc();
        int chon = -1;

        do {
            System.out.println("\n========== QUAN LY PHONG HOC ==========");
            System.out.println("1. Them phong hoc ly thuyet");
            System.out.println("2. Them phong hoc may tinh");
            System.out.println("3. Them phong hoc thi nghiem");
            System.out.println("4. Hien thi tat ca phong hoc");
            System.out.println("5. Tim phong hoc theo ma");
            System.out.println("6. Hien thi phong hoc dat chuan");
            System.out.println("7. Sap xep tang dan theo day nha");
            System.out.println("8. Sap xep giam dan theo dien tich");
            System.out.println("9. Sap xep tang dan theo so bong den");
            System.out.println("10. Cap nhat so may tinh");
            System.out.println("11. Xoa phong hoc");
            System.out.println("12. Tinh tong so phong hoc");
            System.out.println("13. Tim phong may co 60 may tinh");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            if (!sc.hasNextLine()) {
                break;
            }
            try {
                chon = Integer.parseInt(sc.nextLine().trim());

                switch (chon) {
                case 1: {
                    System.out.print("Ma phong: ");
                    String ma = sc.nextLine();
                    System.out.print("Day nha: ");
                    String day = sc.nextLine();
                    System.out.print("Dien tich: ");
                    double dt = Double.parseDouble(sc.nextLine());
                    System.out.print("So bong den: ");
                    int den = Integer.parseInt(sc.nextLine());
                    System.out.print("So may chieu (0: khong, 1: co): ");
                    int mc = Integer.parseInt(sc.nextLine());

                    PhongHocLT p =
                        new PhongHocLT(ma, day, dt, den, mc);

                    if (ql.themPhongHoc(p))
                        System.out.println("Them thanh cong!");
                    else
                        System.out.println("Ma phong da ton tai!");
                    break;
                }

                case 2: {
                    System.out.print("Ma phong: ");
                    String ma = sc.nextLine();
                    System.out.print("Day nha: ");
                    String day = sc.nextLine();
                    System.out.print("Dien tich: ");
                    double dt = Double.parseDouble(sc.nextLine());
                    System.out.print("So bong den: ");
                    int den = Integer.parseInt(sc.nextLine());
                    System.out.print("So may tinh: ");
                    int may = Integer.parseInt(sc.nextLine());

                    PhongHocMayTinh p =
                        new PhongHocMayTinh(ma, day, dt, den, may);

                    if (ql.themPhongHoc(p))
                        System.out.println("Them thanh cong!");
                    else
                        System.out.println("Ma phong da ton tai!");
                    break;
                }

                case 3: {
                    System.out.print("Ma phong: ");
                    String ma = sc.nextLine();
                    System.out.print("Day nha: ");
                    String day = sc.nextLine();
                    System.out.print("Dien tich: ");
                    double dt = Double.parseDouble(sc.nextLine());
                    System.out.print("So bong den: ");
                    int den = Integer.parseInt(sc.nextLine());
                    System.out.print("Chuyen nganh: ");
                    String cn = sc.nextLine();
                    System.out.print("Suc chua: ");
                    int scua = Integer.parseInt(sc.nextLine());
                    System.out.print("So bon rua: ");
                    int bon = Integer.parseInt(sc.nextLine());

                    PhongHocTN p =
                        new PhongHocTN(ma, day, dt, den, cn, scua, bon);

                    if (ql.themPhongHoc(p))
                        System.out.println("Them thanh cong!");
                    else
                        System.out.println("Ma phong da ton tai!");
                    break;
                }

                case 4:
                    ql.hienThiTatCa();
                    break;

                case 5: {
                    System.out.print("Nhap ma phong can tim: ");
                    String ma = sc.nextLine();
                    PhongHoc p = ql.timPhongHoc(ma);

                    if (p != null)
                        System.out.println(p);
                    else
                        System.out.println("Khong tim thay phong!");
                    break;
                }

                case 6:
                    ql.hienThiDanhSach(ql.layPhongDatChuan());
                    break;

                case 7:
                    ql.sapXepTangTheoDayNha();
                    ql.hienThiTatCa();
                    break;

                case 8:
                    ql.sapXepGiamTheoDienTich();
                    ql.hienThiTatCa();
                    break;

                case 9:
                    ql.sapXepTangTheoSoBongDen();
                    ql.hienThiTatCa();
                    break;

                case 10: {
                    System.out.print("Ma phong may tinh: ");
                    String ma = sc.nextLine();
                    System.out.print("So may tinh moi: ");
                    int may = Integer.parseInt(sc.nextLine());

                    if (ql.capNhatSoMayTinh(ma, may))
                        System.out.println("Cap nhat thanh cong!");
                    else
                        System.out.println(
                            "Khong tim thay phong may hoac so may khong hop le!"
                        );
                    break;
                }

                case 11: {
                    System.out.print("Nhap ma phong can xoa: ");
                    String ma = sc.nextLine();

                    PhongHoc p = ql.timPhongHoc(ma);
                    if (p == null) {
                        System.out.println("Khong tim thay phong!");
                        break;
                    }

                    System.out.println("Thong tin phong: " + p);
                    System.out.print("Ban co chac chan muon xoa? (y/n): ");
                    String xacNhan = sc.nextLine();

                    if (xacNhan.equalsIgnoreCase("y")) {
                        ql.xoaPhongHoc(ma);
                        System.out.println("Da xoa phong hoc!");
                    } else {
                        System.out.println("Da huy thao tac xoa.");
                    }
                    break;
                }

                case 12:
                    System.out.println(
                        "Tong so phong hoc: " + ql.tinhTongSoPhong()
                    );
                    break;

                case 13:
                    ql.hienThiDanhSach(ql.layPhongMayCo60May());
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Dữ liệu không hợp lệ. " + e.getMessage());
            }
        } while (chon != 0);

        sc.close();
    }
}
