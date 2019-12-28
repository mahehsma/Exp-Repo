
public class Robot {
	String name;
	String color;
	int weight;
	int height;

	Robot(String n, String c, int w, int h) {
		this.name = n;
		this.color = c;
		this.weight = w;
		this.height = h;

	}

	void introduceSelf() {
		System.out.println("Hello, I am " + this.name + ". My color is " + this.color + ", my weight is " + this.weight
				+ " and I am " + this.height + " feet tall.");
	}
}
