package tuan02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SV sv1 = new SV(1001, "Nguyễn Văn An", 8.5, 9);
        SV sv2 = new SV(1002, "Trần Văn Bình", 7.5, 8);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập mã sinh viên: ");
            int ma = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Nhập họ tên: ");
            String ten = sc.nextLine();
            System.out.print("Nhập điểm lý thuyết: ");
            double diemLT = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Nhập điểm thực hành: ");
            double diemTH = Double.parseDouble(sc.nextLine().trim());

            SV sv3 = new SV();
            sv3.setMaSV(ma);
            sv3.setHoTen(ten);
            sv3.setDiemLT(diemLT);
            sv3.setDiemTH(diemTH);
            if (args.length > 0 && "--constructor".equals(args[0])) {
                sv3 = new SV(ma, ten, diemLT, diemTH);
            }

            System.out.printf("%n%-8s %-28s %8s %8s %8s%n", "MSSV", "Họ tên", "Điểm LT", "Điểm TH", "Điểm TB");
            System.out.println(sv1);
            System.out.println(sv2);
            System.out.println(sv3);
        } catch (NumberFormatException e) {
            System.out.println("Mã sinh viên và điểm phải nhập bằng số.");
        }
    }
}
