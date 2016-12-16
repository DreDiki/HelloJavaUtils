package com.drediki.exp.graphics;

public class Square extends Rectangle {
	public Square(){
		this(null,0);
	}
	public Square(int length){
		this(null,length);
	}
	public Square(String name,int length){
		super(name,length,length);
	}
	public void setLength(int length){
		set(length,length);
	}
	public int getLength(){
		return getWidth()==getHeight()?getWidth():-1;
	}
	
}
