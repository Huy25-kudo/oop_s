
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
 
public class dshoadon {
   Scanner sc = new Scanner(System.in);
    private static hoadon[] dshd = new hoadon[0];
     // Hàm đọc file
   public void docFile(String filePath) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy"); // Định dạng ngày tháng
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Tách dữ liệu theo dấu phẩy
                if (parts.length == 5) { // Đảm bảo có đủ 5 phần tử: MaHD, MaNV, MaKH, Ngay, TongTien
                    int maHD = Integer.parseInt(parts[0].trim());
                    int maNV = Integer.parseInt(parts[1].trim());
                    int maKH = Integer.parseInt(parts[2].trim());
                    LocalDate ngayin = LocalDate.parse(parts[3].trim(), dateFormatter);
                    double tongtien = Double.parseDouble(parts[4].trim());

                    // Tạo đối tượng hoadon
                    hoadon hd = new hoadon(maHD, maNV, maKH, ngayin, tongtien);

                    // Thêm vào mảng dshd
                    dshd = Arrays.copyOf(dshd, dshd.length + 1);
                    dshd[dshd.length - 1] = hd;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng dữ liệu: " + e.getMessage());
        }
    }
   public  void TaoDS(dschitietdonhang ds1){
        int n;
        System.out.println("nhap vao so luong hoadon");
         n = sc.nextInt();
       for(int i=0;i<n;i++)
       {
          dshd =  Arrays.copyOf(dshd, dshd.length+1);
          dshd[dshd.length-1] = new hoadon();
          dshd[dshd.length-1].nhap(ds1);
   
       }
     }
    public void xuat(){
       for (hoadon dshd1 : dshd) {
           dshd1.xuat();
       } 
   }
   public double TongMonth(LocalDate start,LocalDate end)
   {
      double total=0;
       for (hoadon dshd1 : dshd) {
           LocalDate tranDate = dshd1.getNgayin();
           if ((tranDate.isEqual(start)||tranDate.isAfter(start))&&(tranDate.isEqual(end)||tranDate.isBefore(end))) {
               total += dshd1.getTongtien();
           }
       }
      return total;
   }
   public void sort() {
    for (int i = 0; i < dshd.length - 1; i++) {
        for (int j = 0; j < dshd.length - 1 - i; j++) {
            if (dshd[j].getMaHD() > dshd[j + 1].getMaHD()) {
               hoadon temp = dshd[j];
                dshd[j] = dshd[j + 1];
                dshd[j + 1] = temp;
            }
        }
    }
}
public hoadon FindID(int id1){
    int l=0;
    int  r=dshd.length-1;
    sort();
    while(l<=r)
    {
        int mid=(l+r)/2;
        if(dshd[mid].getMaHD()==id1)
        {
            return dshd[mid];

        } else 
            if(dshd[mid].getMaHD()<id1){
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return null;
    }
    public void xoa()
    {
        int id;
        System.out.println("nhap Ma SP can xoa: ");
        id=sc.nextInt();
        for(int i=0;i<dshd.length;i++)
        {
            if(dshd[i].getMaHD()==id)
            {
                dshd[i]=dshd[i+1];
                dshd[i+1]=null;
                dshd = Arrays.copyOf(dshd, dshd.length - 1);
            }
        }
    }
   public void sua(){
     System.out.println("nhap vao ma hoa don can sua");
     int id=sc.nextInt();
     hoadon hd=FindID(id);
     if(hd!=null)
     {  
        System.out.println("nhap vao ma hoa don moi 1 sua");
        hd.setMaHD(sc.nextInt());
        boolean exist=false;
         for (hoadon dshd1 : dshd) {
             if (dshd1.getMaHD() == hd.getMaHD() && dshd1 != hd) {
                 exist=false;
                 break;
             }
         }
        if(exist){
            System.out.println("ma hoa don da ton tai");
            return;
        }
        System.out.println("nhap vao ma khach hang:");
        hd.setMaKH(sc.nextInt());
        System.out.println("nhap vao ma nhan vien:");
        hd.setMaNV(sc.nextInt());
        System.out.println("nhap vao ngay lap:");
        System.out.println("nhap ngay");
        int ngay=sc.nextInt();
        System.out.println("nhap thang");
        int thang=sc.nextInt();
        System.out.println("nhap nam");
        int nam=sc.nextInt();
        hd.setNgayin(ngay,thang,nam);
     }
   }
}
