package tuan09;

public class PhongHocMayTinh extends PhongHoc {
	private int soMayTinh;

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		if (soMayTinh < 0) {
			throw new IllegalArgumentException("Số máy tính không được âm");
		}
		this.soMayTinh = soMayTinh;
	}
	
	

	public PhongHocMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		setSoMayTinh(soMayTinh);
	}

	public PhongHocMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	@Override
	public String toString() {
	    return super.toString() + ", soMayTinh=" + soMayTinh;
	}
	
	@Override
	public boolean datChuan()
	{
		return super.datChuan() && soMayTinh >= Math.ceil(getDienTich() / 1.5);
	}
}
