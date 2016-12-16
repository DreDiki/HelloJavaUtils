package com.drediki.exp.graphics;

public class Circle extends Oval {
	private int r;
	public Circle(){
		this(null,0);
	}
	public Circle(int r){
		this(null,r);
	}
	public Circle(String name,int r){
		setName(name);
		setRound(r);
	}
	public int getRound() {
		return r;
	}
	public void setRound(int r) {
		this.r = r;
	}
	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return (long)(Math.PI*r*r);
	}

	@Override
	public long getPermeter() {
		// TODO Auto-generated method stub
		return (long)(Math.PI*2*r);
	}

}
