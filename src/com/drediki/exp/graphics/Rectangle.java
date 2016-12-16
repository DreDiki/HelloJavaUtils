package com.drediki.exp.graphics;

public class Rectangle extends Shape {
	private int width,height;
	public Rectangle(){
		this(null,0,0);
	}
	public Rectangle(int width ,int height){
		this(null,width,height);
	}
	public Rectangle(String name,int width,int height){
		setName(name);
		this.width = width;
		this.height = height;
	}
	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public long getPermeter() {
		// TODO Auto-generated method stub
		return 2*(width+height);
	}

	public void set(int width,int height){
		setWidth(width);
		setHeight(height);
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
