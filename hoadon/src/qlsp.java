
public class qlsp {
      
    public static void main(String[] args) {
        dssanpham sp = new dssanpham();
        dschitietdonhang ct = new dschitietdonhang();
        dshoadon hd = new dshoadon();
        qlbh ql = new qlbh();
        ql.nhapfile(sp,ct,hd);
        ql.choose(sp, ct, hd);
        ql.ghiFile(sp, ct, hd);
    }

}
