package quanlynhansu;

import java.util.Scanner;

    public class UI {
        public static void main(String[] args) {
            QuanLyNhanVien ql = new QuanLyNhanVien();
            Scanner sc = new Scanner(System.in);
            int chon;

            do {
                System.out.println("\n===== MENU QUẢN LÝ NHÂN VIÊN =====");
                System.out.println("1. Thêm nhân viên");
                System.out.println("2. Hiển thị danh sách");
                System.out.println("3. Tìm kiếm theo tên");
                System.out.println("4. Xóa nhân viên");
                System.out.println("5. Sửa thông tin nhân viên");
                System.out.println("6. Sắp xếp theo tên");
                System.out.println("7. Hiển thị phòng ban");
                System.out.println("8. Tìm kiếm theo ID");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                chon = sc.nextInt();
                sc.nextLine();

                switch (chon) {
                    case 1 -> ql.themNhanVien();
                    case 2 -> ql.hienThiDS();
                    case 3 -> {
                        System.out.print("Nhập tên cần tìm: ");
                        ql.timKiemTheoTen(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Nhập ID nhân viên cần xóa: ");
                        ql.xoaNhanVien(sc.nextLong());
                        sc.nextLine();
                    }
                    case 5 -> {
                        System.out.print("Nhập ID nhân viên cần sửa: ");
                        ql.suaThongTin(sc.nextLong());
                        sc.nextLine();
                    }
                    case 6 -> ql.sapXepTheoTen();
                    case 7 -> ql.hienThiPhongBan();
                    case 8 -> {
                        System.out.print("Nhập ID nhân viên cần tìm: ");
                        long id = sc.nextLong();
                        sc.nextLine();
                        ql.timKiemTheoID(id);
                    }
                    case 0 -> System.out.println("👋 Tạm biệt!");
                    default -> System.out.println("❌ Lựa chọn không hợp lệ!");
                }
            } while (chon != 0);
        }
    }


