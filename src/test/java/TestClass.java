import static org.junit.Assert.*;

import javax.swing.JTable;

import org.junit.Test;

import controller.Methods_Data_Imple;
import models.Cactus;
import models.Ornamental;

public class TestClass {

	Methods_Data_Imple nn = new Methods_Data_Imple();
	JTable table = new JTable();

	@Test
	public void tesOr() {
		Ornamental or = new Ornamental("fef44", "Monter", "this plant need more water", "red");
		nn.createPlants(or);
	}

	@Test
	public void tesCac() {
		Cactus or = new Cactus("fef44", "Monter", "this plant need more water");
		nn.createPlants(or);
	}

	@Test
	public void testShowCac() {
		Cactus or = new Cactus("fef44", "Monter", "this plant need more water");
		nn.readPlantsCAC(table, or);
	}

	@Test
	public void testShowOr() {
		Ornamental or = new Ornamental("fef44", "Monter", "this plant need more water", "red");
		nn.readPlantsOrna(table, or);
	}

}
