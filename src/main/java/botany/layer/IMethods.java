package botany.layer;

import javax.swing.JTable;

import models.Cactus;
import models.Ornamental;

public interface IMethods {
	public boolean createPlants(Object obj);

	public void readPlantsCAC(JTable table, Cactus cac);

	public boolean deletePlants(JTable table);

	public void readPlantsOrna(JTable table, Ornamental orn);

	public void orderplants(JTable table, int index);
}
