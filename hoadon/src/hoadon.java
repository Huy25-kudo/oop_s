
import java.time.LocalDate;
import java.util.Scanner;

public class hoadon {
    private int MaHD;
    private int MaNV;
    private int MaKH;
    private LocalDate ngayin;
    private double tongtien;
    public hoadon() {
    };
   
    public hoadon(int MaHD,int MaNV,int  MaKH,LocalDate ngayin,double tongtien) 
{
    this.MaHD = MaHD;
    this.MaNV = MaNV;
    this.MaKH = MaKH;
    this.ngayin=ngayin;
    this.tongtien = tongtien;
}
    public hoadon(hoadon hd) 
    {
        this.MaHD = hd.MaHD;
        this.MaNV = hd.MaNV;
        this.MaKH = hd.MaKH;
        
        this.ngayin = hd.ngayin;
        this.tongtien = hd.tongtien;

    }
    public void nhap(dschitietdonhang ds1){
      Scanner sc =new Scanner(System.in);
        System.out.println("Nhap MaHD :");
      this.MaHD=sc.nextInt();
      System.out.println("Nhap vao  MaNV :");
      this.MaNV=sc.nextInt();
      System.out.println("Nhap vao MaKH: ");
      this.MaKH=sc.nextInt();
      System.out.println("nhap ngay thang: \n ");
      int ngay=sc.nextInt();
      System.out.print("/");
      int thang=sc.nextInt();
      System.out.print("/");
      int nam=sc.nextInt();
      this.ngayin=LocalDate.of(nam, thang, ngay);
      this.tongtien=ds1.tongtien(this.MaHD);
    }
    public void xuat(){
        System.out.println("MaHD: "+this.MaHD);
        System.out.println("Ma Khach Hang : "+this.MaKH);
        System.out.println("Ma nhan vien:  "+this.MaNV);
        System.out.println("ngay  in: "+this.ngayin);
        System.out.println("tong tien: "+this.tongtien);

    }

    public int getMaHD(){
        return this.MaHD;
    }
    public void setMaHD(int MaHD){
        this.MaHD = MaHD;
    }
    public int getMaSP(){
        return this.MaNV;
    }
    public void setMaSP(int MaNV){
        this.MaNV=MaNV;
    }
    public int getMaKH(){
        return this.MaKH;
    }
    public void setMaKH(int MaKH){
        this.MaKH=MaKH;
    }
    public LocalDate getNgayin()
    {
        return this.ngayin;
    }
    public void setNgayin(int ngay,int thang,int nam)
    {
        this.ngayin=LocalDate.of(ngay,thang,nam);
    }
}
    