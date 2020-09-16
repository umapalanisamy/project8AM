package org.base;

public  class Singleton {

	static Singleton s;
	
	// Private Constructor
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton getInstance() {
		// default value of an object is null
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
