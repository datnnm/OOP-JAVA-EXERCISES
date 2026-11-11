package tuan07;

import java.time.LocalDate;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        QuanLyKhachHang ql = new QuanLyKhachHang();
        ql.themKH(new KhachHangVN("VN01", "Nguyễn Văn An", LocalDate.of(2018, 9, 10), 150, 2000, "sinh hoạt", 100));
        ql.themKH(new KhachHangVN("VN02", "Trần Thị Bình", LocalDate.of(2018, 9, 15), 80, 2000, "kinh doanh", 100));
        ql.themKH(new KhachHangVN("VN03", "Lê Văn Cường", LocalDate.of(2018, 10, 1), 120, 2200, "sản xuất", 120));
        ql.themKH(new KhachHangNuocNgoai("NN01", "John Smith", LocalDate.of(2018, 9, 20), 200, 3000, "Mỹ"));
        ql.themKH(new KhachHangNuocNgoai("NN02", "Emma Brown", LocalDate.of(2018, 9, 30), 100, 3000, "Anh"));
        ql.themKH(new KhachHangNuocNgoai("NN03", "Yuki Tanaka", LocalDate.of(2018, 8, 31), 150, 3000, "Nhật Bản"));

        System.out.println("DANH SÁCH HÓA ĐƠN TIỀN ĐIỆN");
        System.out.printf("%-6s %-24s %10s %8s %10s %14s%n", "Mã", "Họ tên", "Ngày", "Số kW", "Đơn giá", "Thành tiền");
        ql.layTatCa().forEach(System.out::println);
        System.out.printf("%nKhách Việt Nam: %d hóa đơn, %.1f kW%n", ql.demTheoLoai(KhachHangVN.class),
                ql.tongSoKWTieuThuTheoLoai(KhachHangVN.class));
        System.out.printf("Khách nước ngoài: %d hóa đơn, %.1f kW%n", ql.demTheoLoai(KhachHangNuocNgoai.class),
                ql.tongSoKWTieuThuTheoLoai(KhachHangNuocNgoai.class));
        System.out.printf("Trung bình tiền điện khách nước ngoài: %,.2f VNĐ%n", ql.trungBinhTienKhachNuocNgoai());
        System.out.println("\nHÓA ĐƠN THÁNG 09/2018");
        ql.layHoaDonTheoThang(YearMonth.of(2018, 9)).forEach(System.out::println);
    }
}
