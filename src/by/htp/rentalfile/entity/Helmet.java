package by.htp.rentalfile.entity;

final public class Helmet extends Accessory{
	
	private MaterialType material;
	private int size;
	
	public Helmet(int id, double price, double weight, double width, double height, CategoryEq category, MaterialType material, int size) {
		super(id, price, weight, width, height, category);
		this.material = material;
		this.size = size;
	}

	/*public MaterialType getMaterial() {
		return material;
	}

	public void setMaterial(MaterialType material) {
		this.material = material;
	}*/

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Helmet [material=" + material + ", size=" + size + "]";
	}
	
	

}
