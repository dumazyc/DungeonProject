package inventory;

import java.util.ArrayList;
import java.util.List;

import passages.Passage;

public class Key {
	protected String name;
	protected List<Passage> passageWhichCanBeOpenWithThisKey;
	
	public Key(String name) {
		this.name = name;
		this.passageWhichCanBeOpenWithThisKey = new ArrayList<Passage>();
	}
	
	public void addPassageWhichCanBeOpenWithThisKey(Passage passage){
		passageWhichCanBeOpenWithThisKey.add(passage);
	}
	
	public List<Passage> getPassageWhichCanBeOpenWithThisKey(){
		return passageWhichCanBeOpenWithThisKey;
		
		
	}
	public String getName(){
		return this.name;
	}
	
}
