package com.drediki.exp.graphics;

public class RegularHexagon extends Hexagonal {
	private int side;
	
	
	public RegularHexagon(String name,int side){
		setName(name);
		this.setSide(side);
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return (long) Math.sqrt(27)/2*side*side;
	}

	@Override
	public long getPermeter() {
		// TODO Auto-generated method stub
		return side*6;
	}
	
	public int getSide() {
		return side;
	}


	public void setSide(int side) {
		this.side = side;
	}
}
