package workshop02.com.Test3;

public class Student {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Student() {	}

	public Student(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public int getAge() {return age;}
	public int getHeight() {return height;}
	public String getName() {return name;}	
	public int getWeight() {return weight;}
	public void setAge(int age) {this.age = age;}
	public void setHeight(int height) {this.height = height;}
	public void setName(String name) {this.name = name;}
	public void setWeight(int weight) {this.weight = weight;}
	
	public String studentInfo() {
		return name +"\t"+ age +"\t"+ height +"\t"+ weight;
	}
	
	
	
}
