package by.htp.rentalfile.interf;

import by.htp.rentalfile.entity.Equipment;

public interface IRentStation {

	void addEquipment(Equipment equipment);
	int[] getSpareEquipments();
	int[] getEngagedEquipments();
}
