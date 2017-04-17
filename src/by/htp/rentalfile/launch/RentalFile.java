package by.htp.rentalfile.launch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import by.htp.rentalfile.entity.Bycicle;
import by.htp.rentalfile.entity.CategoryEq;
import by.htp.rentalfile.entity.Equipment;
import by.htp.rentalfile.entity.Helmet;
import by.htp.rentalfile.entity.ImportFromFile;
import by.htp.rentalfile.entity.MaterialType;
import by.htp.rentalfile.entity.Order;
import by.htp.rentalfile.entity.OrderDB;
import by.htp.rentalfile.entity.OutputInformation;
import by.htp.rentalfile.entity.Person;
import by.htp.rentalfile.entity.RentStation;
import by.htp.rentalfile.entity.RentalManager;
import by.htp.rentalfile.entity.Skate;
import by.htp.rentalfile.writer.Printer;

public class RentalFile {

	public static void main(String[] args) {
		RentStation rentStation = new RentStation();
		
		ImportFromFile importObj = new ImportFromFile();
		
		importObj.addSpare(rentStation, "spare.txt");
	
		Printer print = new Printer();
		
		print.printRes("All Equipments", rentStation);
		
		OrderDB orderDB = new OrderDB();
		RentalManager rentalManager = new RentalManager(rentStation, orderDB);
		
		//  Create order for person //
		importObj.addEngaged(rentStation, rentalManager, "engaged.txt");

		//print.printRes("spare=", rentStation.getSpareEquipments());
		//print.printRes("engaged=", rentStation.getEngagedEquipments());
		//System.out.print(orderDB.getUnits());
		
		////   find equipment by params
		rentalManager.resetEquipments();
		print.printRes("There are founded equipments", rentStation.findEquipmentByParams(40));
		
		print.printRes("There are founded equipments by last hour");
		rentalManager.getRentedEquipmentsByTime(new Date().getTime() - 60 * 60, new Date().getTime());
		System.out.println("file");
		HashMap<Integer, ArrayList<Order>> search = new HashMap<>();
		search = rentalManager.getRentedEquipmentsByTimeOutput(new Date().getTime() - 60 * 60, new Date().getTime());
		OutputInformation outInf = new OutputInformation();
		outInf.createReport(search);
		
		
	}
}
