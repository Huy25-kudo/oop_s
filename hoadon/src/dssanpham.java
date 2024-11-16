import java.util.Arrays;
import java.util.Scanner;


public class dssanpham implements isanpham {
 private    static  sanpham[] sp = new sanpham[0];
        Scanner sc = new Scanner(System.in);
        public int check(int id)
        {
            for(int i=0;i<sp.length;i++)
            {
                if(sp[i].getMaSP()==id)     
                return -1;
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
        sp = Arrays.copyOf(sp, sp.length + 1);
        sp[sp.length - 1] = new sanpham(); 
        sp[sp.length - 1].nhap();
      
        System.out.println("trung ma san pham nhap lai");
        sp[sp.length - 1].nhap();
      
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
        System.out.println("Danh sách đã được sắp xếp theo đơn giá tăng dần!");
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
        System.out.println("Nhập tên sản phẩm cần tìm: ");
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
            System.out.println("Không tìm thấy sản phẩm nào gần đúng.");
        }
    }
}