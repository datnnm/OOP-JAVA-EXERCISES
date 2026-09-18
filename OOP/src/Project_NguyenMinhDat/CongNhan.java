package Project_NguyenMinhDat;

public class CongNhan {

	private String maCn;
	private String mHo;
	private String mTen;
	private int mSoSP;
	
	public CongNhan() {
		this.maCn = "";
		this.mHo = "";
		this.mSoSP = 1;
		this.mTen = "";
		
	}
	
	public CongNhan(String maCn, String mHo, String mTen, int mSoSP) {
		this.maCn = maCn;
		this.mHo = mHo;
		this.mTen = mTen;
		if (mSoSP > 0)
			this.mSoSP = mSoSP;
		else
			this.mSoSP = 1;
	}
	
	
	public String getMaCn() {
		return maCn;
	}


	public void setMaCn(String maCn) {
		this.maCn = maCn;
	}


	public String getmHo() {
		return mHo;
	}


	public void setmHo(String mHo) {
		this.mHo = mHo;
	}


	public String getmTen() {
		return mTen;
	}


	public void setmTen(String mTen) {
		this.mTen = mTen;
	}


	public int getmSoSP() {
		return mSoSP;
	}


	public void setmSoSP(int mSoSP) {
		this.mSoSP = mSoSP;
	}
	
	public double tinhLuong() {
		double donGia;
		if (mSoSP < 200)
			donGia = 0.5;
		else if (mSoSP < 400)
			donGia = 0.55;
		else if (mSoSP < 600)
			donGia = 0.6;
		else
			donGia = 0.65;
		return mSoSP * donGia;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-15s %-15s %10d %10.2f", maCn, mHo, mTen, mSoSP, tinhLuong());
	}
}
