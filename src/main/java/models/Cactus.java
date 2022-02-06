package models;

public class Cactus extends Plants {

	public Cactus() {

	}

	public Cactus(String code, String name, String description) {
		super(code, name, description);
	}

	@Override
	public String flowerColor(String color) {
		return "They not have flower";
	}

	public String breedingMethod() {
		return " Use of substrate and direct light";
	}

}
