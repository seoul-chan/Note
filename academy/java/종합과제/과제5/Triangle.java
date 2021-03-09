package workshop5;

public class Triangle extends Shape implements Resize{
	
	public Triangle() {	}
	public Triangle(int width, int height, String colors) {
		super(width,height,colors);
	}
	
	@Override
	public double getArea() {
		return super.getWidth()*super.getHeight()/2;
	}
	
	@Override
	public void setResize(int size) {
		super.setHeight(super.getHeight()+size);
	}
	
	@Override
	public String toString() {
		return "Triangle\t"+getArea()+"\t"+super.getColors();
	}
}
