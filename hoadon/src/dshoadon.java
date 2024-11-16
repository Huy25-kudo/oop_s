
import java.util.Arrays;
import java.util.Scanner;
;
 
public class dshoadon {
   Scanner sc = new Scanner(System.in);
    private hoadon[] dshd = new hoadon[0];
   public  void nhapmang(dschitietdonhang ds1){
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
      for(int i=0;i<dshd.length;i++){
         dshd[i].xuat();
    } 
   }
}
