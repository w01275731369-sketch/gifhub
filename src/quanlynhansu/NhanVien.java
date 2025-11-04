package quanlynhansu;

import java.util.Scanner;

public abstract class NhanVien extends Nguoi {
    protected long idNhanVien;
    protected double luongCoBan;
    protected double heSo;
    protected double luong;
    protected double thuong;
    protected String phongBan;
    protected String chucVu;
    protected String trangThai;

    protected static long autoID = 1000;

    public NhanVien() {
        this.idNhanVien = autoID++;
    }

    // 🧮 Mỗi loại nhân viên tự định nghĩa cách tính lương
    public abstract void tinhLuong();

    // 🧾 Nhập thông tin cơ bản
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        diaChi = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        soDienThoai = sc.nextLine();

        // ✅ Gọi phương thức chọn phòng ban và chức vụ từ class PhongBan
        phongBan = PhongBan.chonPhongBan(sc);
        chucVu = PhongBan.chonChucVu(sc);
    }

    // 📋 Hiển thị thông tin nhân viên
    public void hienThiThongTin() {
        System.out.printf("%-6d %-20s %-20s %-15s %-20s %-10.2f %-10.2f %-10.2f %-12.2f %-20s %-25s\n",
                idNhanVien, hoTen, diaChi, soDienThoai, phongBan,
                luongCoBan, heSo, thuong, luong, chucVu, trangThai);
    }

    // 🧩 Getter & Setter
    public long getIdNhanVien() { return idNhanVien; }
    public String getPhongBan() { return phongBan; }
    public String getChucVu() { return chucVu; }
    public void setPhongBan(String phongBan) { this.phongBan = phongBan; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public void setSoDienThoai(String sdt) { this.soDienThoai = sdt; }
    public double getThuong() { return thuong; }
    public void setThuong(double thuong) { this.thuong = thuong; }
}
