
import java.util.Scanner;

public class caogot extends sanpham {
private String kieugot;
private int decao;
Scanner sc = new Scanner(System.in);
public caogot(){

};
public caogot(int MaSP,String tensp, int sl,int dongia,String mau,String chatlieu,int dodayde,String kieugot,int decao,int size){
super(MaSP,tensp,sl,dongia,mau,chatlieu,dodayde,size);
this.kieugot=kieugot;
this.decao=decao;
}
public caogot(caogot cg1 )
{    super((sanpham)cg1);
    this.kieugot=cg1.kieugot;
    this.decao=cg1.decao;
}
@Override
public void nhap(){
    super.nhap();
    this.kieugot=sc.nextLine();
    this.decao=sc.nextInt();
}
@Override
public void xuat(){
    super.xuat();
    System.out.println("kieu got :"+this.kieugot);
    System.out.println("de cao :"+this.decao);
}
}
