package passages;

public class PaintingPassage extends ClosedPassage {
	
	@Override
	public void open() {
		System.out.println("Behind the painting, there is a door !");
		this.isOpen=true;
	}

}
