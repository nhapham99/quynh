package class_quynh;

import java.util.Scanner;

public class Library {
	
	// class co chuc nang quan ly sinh vien muon sach tai thu vien

	private String nameBook;
	private String author;
	private String typeBook;
	private String studentName;
	private String borrowedDay;
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTypeBook() {
		return typeBook;
	}
	public void setTypeBook(String typeBook) {
		this.typeBook = typeBook;
	}	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBorrowedDay() {
		return borrowedDay;
	}
	public void setBorrowedDay(String borrowedDay) {
		this.borrowedDay = borrowedDay;
	}
	Library() {}
	Library(String name, String author, String type,String stName, String borowwed_day) {
		this.nameBook = name;
		this.author = author;
		this.typeBook = type;
		this.studentName = stName;
		this.borrowedDay = borowwed_day;
	}
	
	public void printInfo() {
		System.out.println("ten sach: " + this.nameBook);
		System.out.println("tac gia: " + this.author);
		System.out.println("the loai: " + this.typeBook);
		System.out.println("ten sinh vien muon sach: " + this.studentName);
		System.out.println("ngay muon: " + this.borrowedDay);
	}
	
	public String ngayTraSach() {
		String[] temp = this.borrowedDay.split("/"); // ham split dung de tach string ra tai ki tu cho truoc
		int mm = Integer.parseInt(temp[1]) + 5; // student can borrow a book 5 months
		int yy = Integer.parseInt(temp[2]);
		if (mm > 12) {
			mm -= 12;
			yy++;
		}
		String period = temp[0] + "/" + Integer.toString(mm) + "/" + Integer.toString(yy);
		return period;
	}
	
	public boolean KtTraSachDungHan(String dayReturnBook) {
		// ham kiem tra ngay tra co dung han khong
		String[] temp = dayReturnBook.split("/"); 
		String period = this.ngayTraSach();
		String[] temp2 = period.split("/");
		if (Integer.parseInt(temp[2]) > Integer.parseInt(temp2[2])) { 
		// kiem tra nam ngay tra va nam ngay phai tra
			return false;
		} else {
			if (Integer.parseInt(temp[1]) > Integer.parseInt(temp2[1])) { 
				// kiem tra thang tra va thang phai tra sach
				return false;
			}
		}
		return true;
	}
	
	public int phatTraMuon(String dayReturnBook) {
		if (this.KtTraSachDungHan(dayReturnBook) == true) {
			return 0;
		} else {
			int soNgayTraMuon = 0;
			String[] temp = dayReturnBook.split("/");
			String[] period = this.ngayTraSach().split("/");
			soNgayTraMuon = ( Integer.parseInt(temp[2]) - Integer.parseInt(period[2])) *  365 
						     + (Integer.parseInt(temp[1]) - Integer.parseInt(period[1])) * 30
						     + (Integer.parseInt(temp[0]) - Integer.parseInt(period[0]));
			return soNgayTraMuon * 1000; // moi ngay muon nop phat 1000 dong
		}
	}
	
	public void inportInfo() {
		Scanner input = new Scanner(System.in);
		System.out.print("nhap ten sach: ");
		this.setNameBook(input.nextLine());
		System.out.print("nhap ten tac gia: ");
		this.setAuthor(input.nextLine());
		System.out.print("nhap the loai sach: ");
		this.setTypeBook(input.nextLine());
		System.out.print("nhap ten sinh vien: ");
		this.setStudentName(input.nextLine());
		System.out.print("nhap ngay muon sach: ");
		this.setBorrowedDay(input.nextLine());
	}
	
	
	public static void main(String[] args) {
		//Library st1 = new Library("qwer", "yui", "yii", "thn", "12/8/1456");
		Library st1 = new Library();
		st1.inportInfo();
		System.out.print("ngay phai tra sach: ");
		System.out.println(st1.ngayTraSach());
		String ngayTraSach = "17/12/2017";
		if (st1.KtTraSachDungHan(ngayTraSach) == true) {
			System.out.println("tra sach dung han");
		} else {
			System.out.println("tra sach khong dung han");
		}
		System.out.println(st1.phatTraMuon(ngayTraSach) + " VND");
		st1.printInfo();
	}
}
