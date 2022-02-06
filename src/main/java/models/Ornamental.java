package models;

public class Ornamental extends Plants {

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Ornamental() {

	}

	public Ornamental(String code, String name, String description, String color) {
		super(code, name, description);
		this.color = color;
	}

	@Override
	public String flowerColor(String color) {
		// TODO Auto-generated method stub
		return color;
	}

	public String breedingMethod() {
		return "Use of pots with soil and direct light";
	}

}
