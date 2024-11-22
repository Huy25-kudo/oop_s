import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class dssanpham implements isanpham {
    public void docFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Tách dữ liệu theo dấu phẩy
                if (parts.length == 8) { // Đảm bảo đủ thông tin 8 trường
                    int maSP = Integer.parseInt(parts[0].trim());
                    String tenSP = parts[1].trim();
                    int soLuong = Integer.parseInt(parts[2].trim());
                    int donGia = Integer.parseInt(parts[3].trim());
                    String mau = parts[4].trim();
                    String chatLieu = parts[5].trim();
                    int doDayDe = Integer.parseInt(parts[6].trim());
                    int size = Integer.parseInt(parts[7].trim());

                    // Tạo đối tượng sản phẩm
                    sanpham newSp = new sanpham(maSP, tenSP, soLuong, donGia, mau, chatLieu, doDayDe, size);

                    // Thêm vào mảng `sp`
                    sp = Arrays.copyOf(sp, sp.length + 1);
                    sp[sp.length - 1] = newSp;
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng dữ liệu: " + e.getMessage());
        }
    }
 private static sanpham[] sp = new sanpham[0];
        Scanner sc = new Scanner(System.in);
        public int check(int id)
        {
        for (sanpham sp1 : sp) {
            if (sp1.getMaSP() == id) {     
                return -1;
            }
        }
            return 1;
        }
   public void nhapSP(){
        int n;
        System.out.println("nhap so san pham can nhap them: ");
        n=sc.nextInt();
        int current=sp.length; sp = Arrays.copyOf(sp,sp.length+n);
       for(int i=0;i<n;i++)
       { 
        sp[current+i] = new sanpham();
        sp[current+i].nhap();
           }
    }
    @Override
    public void xoa()
    {
        int id;
        System.out.println("nhap Ma SP can xoa: ");
        id=sc.nextInt();
        for(int i=0;i<sp.length;i++)
        {
            if(sp[i].getMaSP()==id)
            {
                sp[i]=sp[i+1];
                sp[i+1]=null;
                sp = Arrays.copyOf(sp, sp.length - 1);
            }
        }
    }
    //tao danh sach moi
    @Override
 public void taoDS(){
    int n;
    System.out.println("Nhap so san pham moi can nhap: ");
    n = sc.nextInt();
    for(int i = 0; i < n; i++) {    
        sanpham newSp = new sanpham();
        newSp.nhap();
        while (check(newSp.getMaSP()) == -1) {
            System.out.println("Ma san pham bi trung, nhap lai:");
            newSp.nhap();
        }
        sp = Arrays.copyOf(sp, sp.length + 1);
        sp[sp.length - 1] = newSp;
    }
}
 public void showDs()
 {
        for (sanpham sp1 : sp) {
            sp1.xuat();
        }
    } 
  
    public void sort() {
        for (int i = 0; i < sp.length - 1; i++) {
            for (int j = 0; j < sp.length - 1 - i; j++) {
                if (sp[j].getDongia() > sp[j + 1].getDongia()) {
                    sanpham temp = sp[j];
                    sp[j] = sp[j + 1];
                    sp[j + 1] = temp;
                }
            }
        }
      
    }
   
    //tim id roi lay don gia gan vao chi tiet san pham
    @Override
    public int FindID(int id1){
    sort();
    int l=0;
    int  r=sp.length-1;
    sort();
    while(l<=r)
    {
        int mid=(l+r)/2;
        if(sp[mid].getMaSP()==id1)
        {
            return sp[mid].getDongia();

        } else 
            if(sp[mid].getMaSP()<id1){
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return 0;
    }
    public void TimTheoTen(){
        System.out.println("nhap vao  ten sinh vien can tim: ");
         String ten=sc.nextLine();
    
        String[] DanhSachTen=new String[sp.length];
        for(int i=0;i<sp.length;i++)
        {
            DanhSachTen[i]=sp[i].getTensp();
        }
        int index=Arrays.asList(DanhSachTen).indexOf(ten);   
        System.out.println("ten sinh vien tim thay: ");
        if(index!=-1)
        {   
             sp[index].xuat();       
        } else {
            System.out.println("khong tim thay");
            sc.nextLine();
        }
    }
    @Override
    public void timGanDungTen() {
        System.out.println("Nhap ten san pham can tim: ");
        sc.nextLine(); 
        String tenCanTim = sc.nextLine().toLowerCase(); 
        boolean found = false;
        for (sanpham sp1 : sp) {
            if (sp1.getTensp().toLowerCase().contains(tenCanTim)) {
                sp1.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham nao gan dung.");
        }
    }
}