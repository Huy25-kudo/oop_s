import java.util.Scanner;

public class qlsp {
    public static void main(String[] args) {
    dssanpham sp = new dssanpham();
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    int choice;
    do {
        System.out.println("\n1. Tạo danh sách sản phẩm");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Nhập thêm sản phẩm");
        System.out.println("5. Tìm sản phẩm theo tên");
        System.out.println("6. Tìm sản phẩm gần đúng tên");
        System.out.println("7. Thoát");
        System.out.print("Nhập lựa chọn: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                sp.taoDS();
                break;
            case 2:
                sp.showDs();
                break;
            case 3:
                sp.xoa();
                break;
            case 4:
                sp.nhapSP();
                break;
            case 5:
                sp.TimTheoTen();
                break;
            case 6:
                sp.timGanDungTen();
                break;
            case 7:
                System.out.println("Thoát chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    } while (choice != 7);

}

}
