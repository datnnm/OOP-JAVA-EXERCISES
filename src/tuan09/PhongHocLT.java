package tuan09;

public class PhongHocLT extends PhongHoc {
	private int mayChieu;

	public int getMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(int mayChieu) {
		if (mayChieu < 0) {
			throw new IllegalArgumentException("Số máy chiếu không được âm");
		}
		this.mayChieu = mayChieu;
	}

	public PhongHocLT(String maPhong, String dayNha, double dienTich, int soBongDen, int mayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		setMayChieu(mayChieu);
	}

	public PhongHocLT(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	@Override
	public String toString() {
	    return super.toString() + ", mayChieu=" + mayChieu;
	}
	
	@Override
	public boolean datChuan()
	{
		return super.datChuan() && mayChieu > 0;
	}

}
