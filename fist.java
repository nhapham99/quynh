package class_quynh;

import java.util.Scanner;

public class fist {
	private String name;
	private String type;
	private int cost;
	private String food;
	private int longevity;
	private Scanner input;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getLongevity() {
		return longevity;
	}

	public void setLongevity(int longevity) {
		this.longevity = longevity;
	}
	
	public void InportInfo() {
		input = new Scanner(System.in);
		System.out.print("nhap ten ca: ");
		this.setName(input.nextLine());
		System.out.print("nhap loai ca: ");
		this.setType(input.nextLine());
		System.out.print("nhap gia loai ca: ");
		this.setCost(input.nextInt());
		System.out.print("nhap loai thuc an: ");
		this.setFood(input.nextLine());
		System.out.print("nhap tuoi tho trung binh: ");
		this.setLongevity(input.nextInt());
	}
	public void pritInfo() {
		System.out.println("ten ca: " + this.getName());
		System.out.println("loai ca : " + this.getType());
		System.out.println("gia ca : " + this.getCost());
		System.out.println("loai thuc an cho ca : " + this.getFood());
		System.out.println("tuoi tho trung binh : " + this.getLongevity());
	}
	public int tinhGia(int soCon){
		return this.getCost() * soCon;
	}
	public boolean cungLoaiCa(fist f1) {
		if (this.getType() == f1.getType()) return true;
		else return false;
	}
	public void checkFoodForFist(String food) {
		if (this.getFood() == food) {
			System.out.println("this fist can eat this!");
		} else {
			System.out.println("this fist can't eat this!");
		}
	}
	public static void main(String[] args) {
	}
}
