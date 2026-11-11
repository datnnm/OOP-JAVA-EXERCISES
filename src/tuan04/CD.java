package tuan04;

public class CD {
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    public CD() {
        this(999999, "chưa xác định", 1, 1);
    }

    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    public int getMaCD() { return maCD; }
    public String getTuaCD() { return tuaCD; }
    public int getSoBaiHat() { return soBaiHat; }
    public double getGiaThanh() { return giaThanh; }

    public void setMaCD(int maCD) {
        this.maCD = maCD > 0 ? maCD : 999999;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD == null || tuaCD.isBlank() ? "chưa xác định" : tuaCD.trim();
    }

    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat > 0 ? soBaiHat : 1;
    }

    public void setGiaThanh(double giaThanh) {
        this.giaThanh = Double.isFinite(giaThanh) && giaThanh > 0 ? giaThanh : 1;
    }

    @Override
    public String toString() {
        return String.format("%-8d %-30s %10d %,15.2f", maCD, tuaCD, soBaiHat, giaThanh);
    }
}
