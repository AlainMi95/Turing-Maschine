package main.java.ch.zhaw.TM;

public class State {
	private int state;
	private char read;
	private int nextState;
	private char write;
	private int direction;
	
	public State(int state, char read, int nextState, char write, int direction) {
		this.state= state;
		this.read= read;
		this.nextState= nextState;
		this.write= write;
		this.direction= direction;
	}
	
	public int getState() {
		return state;
	}
	
	public int getnextState() {
		return nextState;
	}
	
	public char getRead() {
		return read;
	}
	
	public char getWrite() {
		return write;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public char getDirLetter() {
		if (direction==1) {
			return 'R';
		} else {
			return 'L';
		}
	}
	
	public void print() {
		System.out.println("q"+state+", " +read +"=> q"+ nextState+ ", "+write+ ", " +getDirLetter());
	}
}
