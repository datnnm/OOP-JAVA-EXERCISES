package tuan01;

public class HinhChuNhatMain {
    public static void main(String[] args) {
        HinhChuNhat h1 = new HinhChuNhat(3, 6);
        System.out.println("Chieu dai hinh chu nhat: " + h1.getChieuDai());
        System.out.println("Chieu rong hinh chu nhat: " + h1.getChieuRong());
        System.out.println("Chu vi hình chữ nhật: " + h1.getChuVi());
        System.out.println("Dien tich hcn: " + h1.getDT());
    }
}
