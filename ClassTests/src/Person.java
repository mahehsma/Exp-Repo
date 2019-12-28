
public class Person {
	String name;
	String personality;
	boolean isSitting;
	Robot robotOwned;

	Person(String n, String p, boolean i) {
		this.name = n;
		this.personality = p;
		this.isSitting = i;
	}

	void sitDown() {
		this.isSitting = true;
	}

	void standUp() {
		this.isSitting = false;
	}
}
