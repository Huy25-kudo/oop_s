public class qlbh {
    public qlbh(){};
  public static void nhapfile(dssanpham sp,dschitietdonhang ct,dshoadon hd)
  {
    sp.docFile("sanpham.txt");
    hd.docFile("hoadon.txt");
    ct.docFile("chitietdonhang.txt",sp);
  }

}
