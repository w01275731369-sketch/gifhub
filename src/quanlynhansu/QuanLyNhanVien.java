package quanlynhansu;

import java.util.*;

public class QuanLyNhanVien {
    private ArrayList<NhanVien> ds = new ArrayList<>();
    private HashMap<String, PhongBan> danhSachPhong = new HashMap<>();

    public QuanLyNhanVien() {
        String[] tenPB = { "Phòng Tài Chính", "Phòng Hành Chính", "Phòng Kinh Doanh",
                "Phòng CSKH", "Phòng CNTT", "Phòng Marketing" };
        for (String ten : tenPB) {
            danhSachPhong.put(ten, new PhongBan(ten));
        }
    }

    public void themNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Nhân viên chính thức");
        System.out.println("2. Nhân viên thử việc");
        System.out.print("Chọn loại: ");
        int chon = sc.nextInt();
        sc.nextLine();

        NhanVien nv = (chon == 1) ? new NhanVienChinhThuc() : new NhanVienThuViec();
        nv.nhapThongTin(sc);

        PhongBan pb = danhSachPhong.get(nv.getPhongBan());
        if (pb != null && !pb.coTheThemChucVu(nv.getChucVu())) {
            System.out.println("⚠️ Không thể thêm nhân viên này do đã có người giữ chức vụ đó!");
            return;
        }

        ds.add(nv);
        if (pb != null) pb.ganNhanVien(nv);
        System.out.println("✅ Đã thêm nhân viên thành công!");
    }

    public void hienThiDS() {
        if (ds.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.printf("%-6s %-20s %-20s %-15s %-20s %-10s %-10s %-10s %-12s %-20s %-25s\n",
                "ID", "Họ tên", "Địa chỉ", "SĐT", "Phòng ban", "LươngCB", "Hệ số",
                "Thưởng", "Lương", "Chức vụ", "Trạng thái");
        for (NhanVien nv : ds)
            nv.hienThiThongTin();
    }

    public void timKiemTheoTen(String ten) {
        boolean found = false;
        for (NhanVien nv : ds) {
            if (nv.getHoTen().equalsIgnoreCase(ten)) {
                nv.hienThiThongTin();
                found = true;
            }
        }
        if (!found) System.out.println("❌ Không tìm thấy nhân viên!");
    }

    public void xoaNhanVien(long id) {
        Iterator<NhanVien> it = ds.iterator();
        while (it.hasNext()) {
            NhanVien nv = it.next();
            if (nv.getIdNhanVien() == id) {
                it.remove();
                System.out.println("🗑️ Đã xóa nhân viên " + nv.getHoTen());
                return;
            }
        }
        System.out.println("❌ Không tìm thấy mã nhân viên!");
    }

    public void suaThongTin(long id) {
        for (NhanVien nv : ds) {
            if (nv.getIdNhanVien() == id) {
                Scanner sc = new Scanner(System.in);
                System.out.println("✏️ Sửa thông tin nhân viên ID: " + id);
                System.out.print("Nhập địa chỉ mới: ");
                nv.setDiaChi(sc.nextLine());
                System.out.print("Nhập SĐT mới: ");
                nv.setSoDienThoai(sc.nextLine());
                System.out.println("✅ Đã cập nhật thông tin!");
                return;
            }
        }
        System.out.println("❌ Không tìm thấy nhân viên!");
    }

    public void sapXepTheoTen() {
        ds.sort(Comparator.comparing(NhanVien::getHoTen, String.CASE_INSENSITIVE_ORDER));
        System.out.println("✅ Đã sắp xếp danh sách theo tên!");
    }

    public void hienThiPhongBan() {
        for (PhongBan pb : danhSachPhong.values()) {
            pb.hienThiThongTinPhong();
        }
    }

    public void timKiemTheoID(long id) {
        for (NhanVien nv : ds) {
            if (nv.getIdNhanVien() == id) {
                System.out.printf("%-6s %-20s %-20s %-15s %-20s %-10s %-10s %-10s %-12s %-20s %-25s\n",
                        "ID", "Họ tên", "Địa chỉ", "SĐT", "Phòng ban",
                        "LươngCB", "Hệ số", "Thưởng", "Lương", "Chức vụ", "Trạng thái");
                nv.hienThiThongTin();
                return;
            }
        }
        System.out.println("❌ Không tìm thấy nhân viên có ID = " + id);
    }
}
