package class_quynh;

import java.util.Scanner;

public class NhanVien {
	private String ten;
    private String phongBan;
    private float heSoLuong;
    private int soNgayCong;
    private int luongcoban;
	private Scanner input;
    NhanVien() {
    	this.setLuongcoban(2000000);
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhongBan() {
        return phongBan;
    }
    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }
    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getSoNgayCong() {
        return soNgayCong;
    }
    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }
    public int getLuongcoban() {
		return luongcoban;
	}
	public void setLuongcoban(int luongcoban) {
		this.luongcoban = luongcoban;
	}
    public float tinhLuong(){
    	//tinh luong nhan vien dua tren he so luong va luong co ban
        return this.getHeSoLuong() * this.getLuongcoban() + this.luongcoban; 
    }
    public float tienThuong(){
    	// tien thuong moi thang
        float bonus = 0;
        if(this.getSoNgayCong() > 25 && this.getPhongBan().equalsIgnoreCase("vip"))
            bonus += this.tinhLuong()*0.2;
        else if(this.getSoNgayCong() > 25)
            bonus += this.tinhLuong()*0.1;
        return bonus;
    }
    
    public float tongLuong(){
        return (Float) this.tienThuong() + this.tinhLuong();
    }
    public void printInfo() {
    	System.out.println("ten nhan vien: " + this.getTen());
    	System.out.println("phong ban: " + this.getPhongBan());
    	System.out.println("he so luong: " + this.getHeSoLuong());
    	System.out.println("so ngay cong: " + this.getSoNgayCong());
    	System.out.println("luong co ban: " + this.getLuongcoban());
    }
    public void importInfo() {
    	input = new Scanner(System.in);
    	System.out.print("nhap ten nhan vien: ");
    	this.setTen(input.nextLine());
    	System.out.print("nhap phong ban: ");
    	this.setPhongBan(input.nextLine());
    	System.out.print("nhap he so luong: ");
    	this.setHeSoLuong(input.nextFloat());
    	System.out.print("nhap so ngay cong: ");
    	this.setSoNgayCong(input.nextInt());
    	System.out.print("nhap luong co ban: ");
    	this.setLuongcoban(input.nextInt());
    }
    
    public static void main(String[] args) {
    	NhanVien nv1 = new NhanVien();
    	nv1.importInfo();
    	nv1.printInfo();
    	System.out.print("luong thang nay: " + nv1.tinhLuong());
    }
	
}
