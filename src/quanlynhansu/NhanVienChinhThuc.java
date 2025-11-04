package quanlynhansu;

import java.util.Scanner;

public class NhanVienChinhThuc extends NhanVien implements ChamCong {

    public NhanVienChinhThuc() {
        this.trangThai = "Đang làm việc";
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        System.out.print("Nhập lương cơ bản: ");
        luongCoBan = sc.nextDouble();
        System.out.print("Nhập hệ số lương: ");
        heSo = sc.nextDouble();
        System.out.print("Nhập tiền thưởng: ");
        thuong = sc.nextDouble();
        sc.nextLine();
        tinhLuong();
    }

    @Override
    public void tinhLuong() {
        luong = TinhLuong.tinhLuongChinhThuc(this) + thuong;
    }

    @Override
    public void lamViec() {
        System.out.println(hoTen + " đang làm việc chính thức.");
    }
}
