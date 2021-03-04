package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	// 면적 : PI * radius * radius
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return ""+(Math.PI*radius*radius);
	}
	
	// 둘레 : PI * radius * 2
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		
		return ""+(Math.PI*radius*2); 
	}
	
	public String printCircle() {
		return c.toString();
	}
}
