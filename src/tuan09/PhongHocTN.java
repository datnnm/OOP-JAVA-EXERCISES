package tuan09;

public class PhongHocTN extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private int soBonChua;

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        if (sucChua < 0) {
            throw new IllegalArgumentException("Sức chứa không được âm");
        }
        this.sucChua = sucChua;
    }

    public int getSoBonChua() {
        return soBonChua;
    }

    public void setSoBonChua(int soBonChua) {
        if (soBonChua < 0) {
            throw new IllegalArgumentException("Số bồn rửa không được âm");
        }
        this.soBonChua = soBonChua;
    }

    public PhongHocTN(String maPhong, String dayNha,
                      double dienTich, int soBongDen,
                      String chuyenNganh, int sucChua,
                      int soBonChua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        setChuyenNganh(chuyenNganh);
        setSucChua(sucChua);
        setSoBonChua(soBonChua);
    }

    @Override
    public String toString() {
        return super.toString()
                + ", chuyenNganh=" + chuyenNganh
                + ", sucChua=" + sucChua
                + ", soBonChua=" + soBonChua;
    }

    @Override
    public boolean datChuan() {
        return super.datChuan() && soBonChua > 0;
    }
}
