package main.java.ch.zhaw.TM;

import java.util.List;

public class Calculation {
	private char[] band;
	private List<State> states;
	private int readerPos;
	private int stateNr;
	
	public Calculation(String input) {
		readerPos=0;
		stateNr=1;
		String[] parts = input.split("111");
		if (parts.length==2) {
			BiteCode biteCode= new BiteCode(parts[0]);
			states= biteCode.createState();
			stringToCharArray(parts[1]);
		}	
	}
	
    private void stringToCharArray(String band) {
    	this.band= new char[band.length()];
    	for (int i = 0; i < band.length(); i++) {
    		this.band[i] = band.charAt(i);
    	}
    }
    
    private void calculate() {
    	while(findState()!=null) {
    		State actState= findState();
    		band[readerPos]=actState.getWrite();
    		readerPos= readerPos+actState.getDirection();
    	}
    }
    
    private State findState() {
    	State state= null;
    	for (State st: states) {
    		if (st.getState()== stateNr && st.getRead()==  band[readerPos]) {
    			state= st;
    		}
    	}  	  	
    	return state;
    }
    
}
