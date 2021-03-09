package workshop5;

public class Student {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Student() { }

	public Student(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {return name;}
	public int getAge() {return age;}
	public int getHeight() {return height;}
	public int getWeight() {return weight;}
	
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setHeight(int height) {this.height = height;}
	public void setWeight(int weight) {this.weight = weight;}
	
	
	
}
