
import java.util.Arrays;
import java.util.Scanner;

public class dschitietdonhang {
    private chitiethoadon[] ds = new chitiethoadon[0];
    Scanner sc = new Scanner(System.in);
    
    public void taoDS(dssanpham ds1) {
        int n;
        System.out.println("Nhập vào số lượng chi tiết hoá đơn:");
        n = sc.nextInt();
        for (int i = ds.length; i < n; i++) {
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length-1] = new chitiethoadon();
            ds[i].nhapct(ds1);
        }
    }
   
    public void xuat() {
        for(int i = 0; i < ds.length; i++) {
            ds[i].xuat();
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
       public double tongtien(int MaHD)
       {   int s=0;
         for(int i=0;i<ds.length;i++)
         {
            if(MaHD ==ds[i].getMaHD()) 
            {
                s=s+ds[i].getThanhtien();
            }
        }
   return s;
}

}