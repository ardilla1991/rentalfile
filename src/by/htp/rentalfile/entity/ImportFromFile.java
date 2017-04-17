package by.htp.rentalfile.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImportFromFile {
	
	public final static String dir_path = "D:\\java\\JD1\\rentalfile\\";

	public void addSpare(RentStation rentStation, String fileName) {
		try(FileReader file = new FileReader(dir_path + fileName)) {
			BufferedReader buffReader = new BufferedReader(file);
			String str;
			while ( (str = buffReader.readLine()) != null ) {
				createSpareObject(str, rentStation);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createSpareObject(String str, RentStation rentStation) {
		String[] strArr = str.split(";");

		Equipment mainEq1;
		
		if ( "Bycicle".equals(strArr[0]) ) {
			mainEq1 = new Bycicle(Integer.parseInt(strArr[1]), Double.parseDouble(strArr[2]), 
					Double.parseDouble(strArr[3]), Double.parseDouble(strArr[4]), 
					Double.parseDouble(strArr[5]), CategoryEq.valueOf(strArr[6]), Integer.parseInt(strArr[7]));
			rentStation.addEquipment(mainEq1);
		} else if ( "Skate".equals(strArr[0]) ) {
			mainEq1 = new Skate(Integer.parseInt(strArr[1]), Double.parseDouble(strArr[1]), 
					Double.parseDouble(strArr[3]), Double.parseDouble(strArr[4]), 
					Double.parseDouble(strArr[5]), CategoryEq.valueOf(strArr[6]), Integer.parseInt(strArr[7]));
			rentStation.addEquipment(mainEq1);
		} else if ( "Helmet".equals(strArr[0]) ) {
			mainEq1 = new Helmet(Integer.parseInt(strArr[1]), Double.parseDouble(strArr[2]), 
					Double.parseDouble(strArr[3]), Double.parseDouble(strArr[4]), 
					Double.parseDouble(strArr[5]), CategoryEq.valueOf(strArr[6]), MaterialType.valueOf(strArr[7]), Integer.parseInt(strArr[8]));
			rentStation.addEquipment(mainEq1);
		}
	}
	
	public void addEngaged(RentStation rentStation, RentalManager rentalManager, String fileName) {
		try(FileReader file = new FileReader(dir_path + fileName)) {
			BufferedReader buffReader = new BufferedReader(file);
			String str;
			while ( (str = buffReader.readLine()) != null ) {
				createEngagedObject(str, rentStation, rentalManager);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createEngagedObject(String str, RentStation rentStation, RentalManager rentalManager) {
		
		System.out.println("Create order");
		
		String[] strArr = str.split(";");
		Person person1 = new Person(strArr[0], strArr[1], strArr[2]);

		Equipment mainEq1;
		
		if ( "Bycicle".equals(strArr[4]) ) {
			mainEq1 = new Bycicle(Integer.parseInt(strArr[5]), Double.parseDouble(strArr[6]), 
					Double.parseDouble(strArr[7]), Double.parseDouble(strArr[8]), 
					Double.parseDouble(strArr[9]), CategoryEq.valueOf(strArr[10]), Integer.parseInt(strArr[11]));
			rentStation.addEquipment(mainEq1);
		} else if ( "Skate".equals(strArr[4]) ) {
			mainEq1 = new Skate(Integer.parseInt(strArr[5]), Double.parseDouble(strArr[6]), 
					Double.parseDouble(strArr[7]), Double.parseDouble(strArr[8]), 
					Double.parseDouble(strArr[9]), CategoryEq.valueOf(strArr[10]), Integer.parseInt(strArr[10]));
			rentStation.addEquipment(mainEq1);
		} else if ( "Helmet".equals(strArr[4]) ) {
			mainEq1 = new Helmet(Integer.parseInt(strArr[5]), Double.parseDouble(strArr[6]), 
					Double.parseDouble(strArr[7]), Double.parseDouble(strArr[8]), 
					Double.parseDouble(strArr[9]), CategoryEq.valueOf(strArr[10]), MaterialType.valueOf(strArr[11]), Integer.parseInt(strArr[12]));
			rentStation.addEquipment(mainEq1);
		}
		
		Order order1 = new Order();
		order1.createOrder(person1, Integer.parseInt(strArr[5]), Integer.parseInt(strArr[3]));
		boolean resRent1 = rentalManager.rent(order1);
		/*if ( resRent1 ) {
			print.printRes("Equipment was added");
		} else {
			print.printRes("Equipment wasn't added");
		}*/
	}

}
