package com.cyrusian.academic.sra.element;


public class Coordinate implements Cloneable {
	
	private static final int MOVE_EAST = +1;
	private static final int MOVE_NORTH = -8;
	private static final int MOVE_SOUTH = +8;
	private static final int MOVE_WEST = -1;
	
	private int coord;
	
	public Coordinate(int crd) {
		if(crd >= 0 && crd <= 63)
			coord = crd;
		else
			coord = -1;
	}
	
	public Coordinate(int x, int y) {
		this(((x - 1) * 8) + y);
	}
	
	public int getCoordinate() {
		return coord;
	}
	
	@Override
	public Coordinate clone() {
		return new Coordinate(getCoordinate());
	}
	
	private void move(int toWhere) {
		coord+=toWhere;
	}
	
	public Coordinate moveEast() {
		move(MOVE_EAST);
		
		return this;
	}
	
	public Coordinate moveNorth() {
		move(MOVE_NORTH);
		
		return this;
	}
	
	public Coordinate moveSouth() {
		move(MOVE_SOUTH);
		
		return this;
	}
	
	public Coordinate moveWest() {
		move(MOVE_WEST);
		
		return this;
	}

}