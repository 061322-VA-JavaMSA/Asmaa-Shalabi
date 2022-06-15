package com.revature.memory;

public class GarbageDreiver {
	public int id;
	public GarbageDreiver(int id) {
		this.id=id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++) {
			new GarbageDreiver(i);
			System.gc();
		}

	}
	@Override
	protected void finalize() {
		System.out.println("id :"+id+" has been garbage collected");
	}
	

}
