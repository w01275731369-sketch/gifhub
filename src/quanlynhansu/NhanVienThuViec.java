package quanlynhansu;

import java.util.Scanner;

public class NhanVienThuViec extends NhanVien implements ChamCong {

    private int soGioLam;

    public NhanVienThuViec() {
        this.trangThai = "Đang thử việc";
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhập số giờ làm việc: ");
        soGioLam = sc.nextInt();
        System.out.print("Nhập tiền thưởng (nếu có): ");
        thuong = sc.nextDouble();
        sc.nextLine();
        tinhLuong();
    }

    @Override
    public void tinhLuong() {
        // Giả sử lương thử việc = 30,000 VND/giờ
        luongCoBan = soGioLam * 30000;
        luong = luongCoBan + thuong;
    }

    @Override
    public void lamViec() {
        System.out.println(hoTen + " đang làm việc part-time (thử việc).");
    }
}
