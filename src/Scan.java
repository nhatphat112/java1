import java.util.Scanner;

public class Scan {
	static Scanner scan = new Scanner(System.in);

	public Scan() {
		
	}
	// nhap so nguyen
	public static int scanInteger() {
		int number=0;
		boolean flag = true;
		do {
			try {
				number = Integer.parseInt(scan.nextLine());
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}while(!flag);
		return number;
	}
	public static float scanFloatNumber() {
		 float number=0;
		boolean flag = true;
		do {
			try {
				number = Float.parseFloat(scan.nextLine());
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}while(!flag);
		return number;
	}
	public static double scanDoubleNumber() {
		double number=0;
		boolean flag = true;
		do {
			try {
				number = Double.parseDouble(scan.nextLine());
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}while(!flag);
		return number;
	}
	

}
