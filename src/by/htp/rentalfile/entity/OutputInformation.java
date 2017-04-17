package by.htp.rentalfile.entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputInformation {
	public void createReport(HashMap<Integer, ArrayList<Order>> search) {
		
		FileWriter file = null;
		
		try {
				file = new FileWriter("D:\\java\\JD1\\rentalfile\\report.txt", true);
				BufferedWriter buffer = new BufferedWriter(file);  ///символьный поток
				
				
				for (int personHash : search.keySet()) {
					//buffer.write(val + "\n");
					for ( Order value : (search.get(personHash) ) ) {
						String val = value.toString();
						buffer.write(val + "\n");
					}
				}
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
