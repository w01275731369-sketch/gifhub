package quanlynhansu;

public class Nguoi {
    protected String hoTen;
    protected String diaChi;
    protected String soDienThoai;

    public Nguoi() {}

    public Nguoi(String hoTen, String diaChi, String soDienThoai) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }


    public String getHoTen()
    {
        return hoTen;
    }
    public void setHoTen(String hoTen)
    {
        this.hoTen = hoTen;
    }

    public String getDiaChi()
    {
        return diaChi;
    }
    public void setDiaChi(String diaChi)
    {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai()
    {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai)
    {
        this.soDienThoai = soDienThoai;
    }
}
