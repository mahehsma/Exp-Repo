
public class ClassTestsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r1 = new Robot("Tom", "red", 23, 12);
		//r1.introduceSelf();
		Robot r2 = new Robot("Tim", "blue", 12, 2);
		//r2.introduceSelf();
		
		Person p1 = new Person("Alice", "aggressive", false);
		Person p2 = new Person("Becky", "talkative", true);
		p1.robotOwned = r2;
		p2.robotOwned = r1;
		p1.robotOwned.introduceSelf();
	}

}
