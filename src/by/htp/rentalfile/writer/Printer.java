package by.htp.rentalfile.writer;

import by.htp.rentalfile.entity.Equipment;
import by.htp.rentalfile.entity.RentStation;

public class Printer {

	public void printRes(String str, Equipment[] eq) {
		System.out.println(str);
		for ( int i = 0; i < eq.length; i++ ) {
			System.out.println("Equipment" + i + ": obj: " + eq[i].getClass() 
			+ "; price: " + eq[i].getPrice() + "; spare: "); 
		}
	}
	
	public void printRes(String str, RentStation rentSt) {
		System.out.println(str);
		System.out.println(rentSt);
	}
	
	public void printRes(String str, int[] eq) {
		System.out.println(str);
		for ( int i = 0; i < eq.length; i++ ) {
			System.out.println("Equipment" + i + ": obj: " + eq[i]); 
		}
	}
	
	public void printRes(String str) {
		System.out.println(str);
	}
}
