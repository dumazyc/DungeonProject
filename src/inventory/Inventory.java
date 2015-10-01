package inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	protected List<Item> itemList;

	public Inventory() {
		itemList = new ArrayList<Item>();
	}

	public void addItemTonventory(Item item) {
		itemList.add(item);
	}

	public List<Item> getItemList() {
		return itemList;
	}
}
