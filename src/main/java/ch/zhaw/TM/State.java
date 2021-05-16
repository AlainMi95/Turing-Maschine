package main.java.ch.zhaw.TM;

public class State {
	private int state;
	private char read;
	private int nextState;
	private char write;
	private char direction;
	
	public State(int state, char read, int nextState, char write, char direction) {
		this.state= state;
		this.read= read;
		this.nextState= nextState;
		this.write= write;
		this.direction= direction;
	}
}
