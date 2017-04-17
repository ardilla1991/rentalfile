package by.htp.rentalfile.entity;

final public class Bycicle extends MainEquipment{
	
	private int countSpeedMode;

	public Bycicle(int id, double price, double weight, double width, double height, CategoryEq category, int countSpeedMode) {
		super(id, price, weight, width, height, category);
		this.countSpeedMode = countSpeedMode;
	}

	public int getCountSpeedMode() {
		return countSpeedMode;
	}

	public void setCountSpeedMode(int countSpeedMode) {
		this.countSpeedMode = countSpeedMode;
	}
}
