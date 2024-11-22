import java.util.Scanner;
public class qlbh {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
         @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
         dssanpham ds = new dssanpham();
         dshoadon hoadon = new dshoadon();
         dschitietdonhang chitietdonhang = new dschitietdonhang();
        ds.docFile("sanpham.txt");
        hoadon.docFile("hoadon.txt");
        chitietdonhang.docFile("chitietdonhang.txt",ds);
        dssanpham ds2 = new dssanpham();
        dschitietdonhang ds1 = new dschitietdonhang();
        dshoadon ds3 = new dshoadon();
        ds2.taoDS();
        ds1.taoDS(ds2);
        ds3.TaoDS(ds1);
        ds3.sua();
    }
}
