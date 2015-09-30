package inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	protected List<Key> keysList;
	protected List<Potion> potionsList;
	protected Weapon weapon;
	
	public Inventory() {
		keysList = new ArrayList<Key>();
		potionsList = new ArrayList<Potion>();
	}
	
	public void addKey(Key key){
		keysList.add(key);
	}
	public void addPotion(Potion potion){
		potionsList.add(potion);
	}
	public void addWeapon(Weapon weapon){
		//TODO
	}
	public List<Key> getKey(){
		return keysList;
	}
	public List<Potion> getPotion(){
		return potionsList;
	}
}
