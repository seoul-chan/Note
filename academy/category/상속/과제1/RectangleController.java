package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	//면적 : width * height
	public String calcArea(int x, int y, int heigh, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(heigh);
		r.setWidth(width);
		
		return ""+(heigh*width);
	}
	
	// 둘레 : 2 * (width + height)
	public String calcPerimeter(int x, int y, int heigh, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(heigh);
		r.setWidth(width);
		
		return ""+(2*(heigh+width));
	}
	
	public String printRectangle() {
		return r.toString();
	}
	
}
