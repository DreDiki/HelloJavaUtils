package com.drediki.exp.graphics;

public abstract class Shape {
	private String name;
	private long shapeSize = -1;
	private long shapePerimeter = -1;
	public abstract long getSize();
	public abstract long getPermeter(); 
	public Shape(){
		//TODO ???
	}
	public Shape(String name){
		this.name = name;
	}
	@Override
	public String toString(){
		return "This shape is a "+getType()+" with name \""+getName()+"\"";
	}
	
	public String getType(){
		return this.getClass().getSimpleName();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void calculate(){
		shapeSize = getSize();
		shapePerimeter = getPermeter();
	}
	public long getShapeSize() {
		return shapeSize;
	}
	public long getShapePerimeter() {
		return shapePerimeter;
	}
}
