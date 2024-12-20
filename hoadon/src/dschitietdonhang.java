
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class dschitietdonhang implements ichithiethoadon{ 
    private static chitiethoadon[] ds = new chitiethoadon[0];
    Scanner sc = new Scanner(System.in);
    
 // Hàm đọc file
    public void docFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Tách dữ liệu theo dấu phẩy
                if (parts.length == 4) { // Đảm bảo có đủ 3 phần tử: MaHD, MaSP, SoLuong
                    int maHD = Integer.parseInt(parts[0].trim());
                    int maSP = Integer.parseInt(parts[1].trim());
                    int soLuong = Integer.parseInt(parts[2].trim());
                    int Thanhtien = Integer.parseInt(parts[3].trim());

                    // Tạo đối tượng chitiethoadon
                    chitiethoadon ct = new chitiethoadon();
                    ct.setMaHD(maHD);
                    ct.setMaSP(maSP);
                    ct.setSoluong(soLuong);
                    ct.setThanhtien(Thanhtien); // Tính tiền dựa trên thông tin sản phẩm
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
     public void ghiFile(String filePath) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        for (chitiethoadon ct1 : ds) {
            // Ghi thông tin sản phẩm vào file, cách nhau bởi dấu phẩy
            bw.write(ct1.getMaHD() + "," +
                     ct1.getMaSP() + "," +
                     ct1.getSoluong()+ "," +
                     ct1.getThanhtien() + ",");
            bw.newLine(); // Xuống dòng sau mỗi sản phẩm
        }
        System.out.println("Ghi file thành công!");
    } catch (IOException e) {
        System.out.println("Lỗi khi ghi file: " + e.getMessage());
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
       public void xoa() {
        System.out.println("Nhap ma san pham can xoa: ");
        int id = sc.nextInt(); // Nhập mã sản phẩm cần xóa
        boolean found = false;
    
        // Duyệt qua danh sách để tìm sản phẩm cần xóa
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaHD() == id) {
                found = true;
    
                // Dịch các phần tử sau vị trí cần xóa lên một vị trí
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
    
                // Giảm kích thước mảng và loại bỏ phần tử cuối
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("da xoa hoa don: " + id);
                break;
            }
        }
    
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + id);
        }
    }
    public void nhapthem(dssanpham sp){
        int n;
        System.out.println("nhap vao so luong can them :");
        n=sc.nextInt();
        int current=ds.length;
        ds=Arrays.copyOf(ds, current + n);
        for(int i=0;i<n;i++){
             ds[current+i] = new chitiethoadon();
             ds[current+i].nhapct(sp);
        }
     }
    public void choose(dssanpham ds1){
        int choice;
        do { 
            System.out.println("1. Tao danh sach chi tiet hao don ");
            System.out.println("2. hien danh sach chi tiet hoa don");
            System.out.println("3. Xoa chi tiet don hang");
            System.out.println("4.them");
            System.out.println("5.thoat");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                taoDS(ds1);
                break;
                case 2:
                xuat();
                break;
                case 3:
                xoa();
                break;
                case 4:
                 nhapthem(ds1);
                 break;
                case 5:
                System.out.println("Thoát chương trình.");
                break;
                default:
                System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice!=5);
    }
      
}
