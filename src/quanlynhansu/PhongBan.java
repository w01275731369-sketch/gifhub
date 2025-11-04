package quanlynhansu;

import java.util.Scanner;

public class PhongBan {
    private String tenPhong;
    private NhanVien truongPhong;
    private NhanVien phoPhong;

    public PhongBan(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public static String chonPhongBan(Scanner sc) {
        System.out.println("\n--- Chọn phòng ban ---");
        System.out.println("1. Phòng Tài Chính");
        System.out.println("2. Phòng Hành Chính");
        System.out.println("3. Phòng Kinh Doanh");
        System.out.println("4. Phòng CSKH");
        System.out.println("5. Phòng CNTT");
        System.out.println("6. Phòng Marketing");
        System.out.print("Chọn (1–6): ");
        int chon = sc.nextInt(); sc.nextLine();

        return switch (chon) {
            case 1 -> "Phòng Tài Chính";
            case 2 -> "Phòng Hành Chính";
            case 3 -> "Phòng Kinh Doanh";
            case 4 -> "Phòng CSKH";
            case 5 -> "Phòng CNTT";
            case 6 -> "Phòng Marketing";
            default -> "Không xác định";
        };
    }

    public static String chonChucVu(Scanner sc) {
        System.out.println("\n--- Chọn chức vụ ---");
        System.out.println("1. Trưởng phòng");
        System.out.println("2. Phó phòng");
        System.out.println("3. Nhân viên");
        System.out.print("Chọn (1–3): ");
        int chon = sc.nextInt(); sc.nextLine();

        return switch (chon) {
            case 1 -> "Trưởng phòng";
            case 2 -> "Phó phòng";
            case 3 -> "Nhân viên";
            default -> "Không xác định";
        };
    }

    // ✅ Kiểm tra xem có thể thêm chức vụ này vào phòng không
    public boolean coTheThemChucVu(String chucVu) {
        if (chucVu.equalsIgnoreCase("Trưởng phòng") && truongPhong != null) return false;
        if (chucVu.equalsIgnoreCase("Phó phòng") && phoPhong != null) return false;
        return true;
    }

    // ✅ Gán nhân viên vào chức vụ tương ứng
    public void ganNhanVien(NhanVien nv) {
        if (nv == null) return;
        if (nv.getChucVu().equalsIgnoreCase("Trưởng phòng")) truongPhong = nv;
        if (nv.getChucVu().equalsIgnoreCase("Phó phòng")) phoPhong = nv;
    }

    public void hienThiThongTinPhong() {
        System.out.println("Phòng: " + tenPhong);
        System.out.println("  Trưởng phòng: " + (truongPhong != null ? truongPhong.getHoTen() : "Chưa có"));
        System.out.println("  Phó phòng: " + (phoPhong != null ? phoPhong.getHoTen() : "Chưa có"));
    }

    public String getTenPhong() { return tenPhong; }
}
