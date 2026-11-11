package tuan09;

public abstract class PhongHoc {
	private final String maPhong;
	private String dayNha;
	private double dienTich;
	private int soBongDen;
	
	public String getMaPhong() {
		return maPhong;
	}
	public String getDayNha() {
		return dayNha;
	}
	public void setDayNha(String dayNha) {
		if (dayNha == null || dayNha.isBlank()) {
			throw new IllegalArgumentException("Dãy nhà không được để trống");
		}
		this.dayNha = dayNha.trim();
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		if (!Double.isFinite(dienTich) || dienTich <= 0) {
			throw new IllegalArgumentException("Diện tích phải lớn hơn 0");
		}
		this.dienTich = dienTich;
	}
	public int getSoBongDen() {
		return soBongDen;
	}
	public void setSoBongDen(int soBongDen) {
		if (soBongDen < 0) {
			throw new IllegalArgumentException("Số bóng đèn không được âm");
		}
		this.soBongDen = soBongDen;
	}
	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		if (maPhong == null || maPhong.isBlank()) {
			throw new IllegalArgumentException("Mã phòng không được để trống");
		}
		this.maPhong = maPhong.trim();
		setDayNha(dayNha);
		setDienTich(dienTich);
		setSoBongDen(soBongDen);
	}
	
	@Override
	public String toString() {
		return "PhongHoc [maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + ", soBongDen="
				+ soBongDen + "]";
	}
	
	public boolean datChuan()
	{
		return soBongDen >= Math.ceil(dienTich / 10);
	}
}
