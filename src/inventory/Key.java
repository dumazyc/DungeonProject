package inventory;

import java.util.ArrayList;
import java.util.List;

import passages.Passage;
import rooms.Room;

public class Key extends Item {
	protected List<Passage> passageWhichCanBeOpenWithThisKey;

	public Key(String name) {
		super(name);

		this.passageWhichCanBeOpenWithThisKey = new ArrayList<Passage>();
	}

	public void addPassageWhichCanBeOpenWithThisKey(Passage passage) {
		passageWhichCanBeOpenWithThisKey.add(passage);
	}

	public List<Passage> getPassageWhichCanBeOpenWithThisKey() {
		return passageWhichCanBeOpenWithThisKey;

	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean use(Room room) {
		boolean doorCanBeOpen = false;
		for (Passage passage : passageWhichCanBeOpenWithThisKey) {
			if (passage.getNextRoom().equals(room)) {
				doorCanBeOpen = true;
			}
		}
		if (doorCanBeOpen) {
			for (Passage passage : passageWhichCanBeOpenWithThisKey) {
				System.out.println("You have unlocked a door with this key !");
				passage.open();
			}
			return true;
		} else {
			System.out.println("The key is useless in this room.");
			return false;
		}

	}

}
