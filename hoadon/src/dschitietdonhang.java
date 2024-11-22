
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class dschitietdonhang implements ichithiethoadon{ 
    private static chitiethoadon[] ds = new chitiethoadon[0];
    Scanner sc = new Scanner(System.in);
    
 // Hàm đọc file
    public void docFile(String filePath, dssanpham dsSanPham) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Tách dữ liệu theo dấu phẩy
                if (parts.length == 3) { // Đảm bảo có đủ 3 phần tử: MaHD, MaSP, SoLuong
                    int maHD = Integer.parseInt(parts[0].trim());
                    int maSP = Integer.parseInt(parts[1].trim());
                    int soLuong = Integer.parseInt(parts[2].trim());

                    // Tạo đối tượng chitiethoadon
                    chitiethoadon ct = new chitiethoadon();
                    ct.setMaHD(maHD);
                    ct.setMaSP(maSP);
                    ct.setSoluong(soLuong);
                    ct.tinhtien(dsSanPham); // Tính tiền dựa trên thông tin sản phẩm
                    // Thêm vào mảng ds
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = ct;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng dữ liệu: " + e.getMessage());
        }
    }
    public void taoDS(dssanpham ds1)  {
        int n;
        System.out.println("Nhap vao so luong chi tiet hoa đon:");
        n = sc.nextInt();
        for (int i = ds.length; i < n; i++) {
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length-1] = new chitiethoadon();
            ds[i].nhapct(ds1);
        }
    }
   
    public void xuat() {
        for (chitiethoadon d : ds) {
            d.xuat();
        }
    }
    public int FindMHD(int id1){
        int l=0;
        int  r=ds.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(ds[mid].getMaHD()==id1)
            {
                return ds[mid].getThanhtien();
    
            } else 
                if(ds[mid].getMaHD()<id1){
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            }
            return 0;
        }
    @Override
       public double tongtien(int MaHD)
       {   int s=0;
        for (chitiethoadon d : ds) {
            if (MaHD == d.getMaHD()) {
                s = s + d.getThanhtien();
            }
        }
       return s;
       }
       public void xoa()
    {
        int id;
        System.out.println("nhap Ma SP can xoa: ");
        id=sc.nextInt();
        System.out.println("nhap vao ma hoa don");
        int id1=sc.nextInt();
        for(int i=0;i<ds.length;i++)
        {
            if(ds[i].getMaSP()==id&&ds[i].getMaHD()==id1)
            {
                ds[i]=ds[i+1];
                ds[i+1]=null;
                ds = Arrays.copyOf(ds, ds.length - 1);
            }
        }
    }
}