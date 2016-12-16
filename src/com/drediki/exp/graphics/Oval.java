package com.drediki.exp.graphics;

public class Oval extends Shape {
	private int a,b;
	public Oval(){
		this(null,0,0);
	}
	public Oval(int a,int b){
		this(null,a,b);
	}
	public Oval(String name,int a,int b){
		super(name);
		this.a = a;
		this.b = b;
	}
	public void set(int a,int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return (long)(Math.PI*a*b);
	}

	@Override
	public long getPermeter() {
		// TODO Auto-generated method stub
		//pi[3/2(a+b)-sqrt(ab)]
		return (long)(Math.PI*(1.5*(a+b)-Math.sqrt(a*b)));
	}


}
