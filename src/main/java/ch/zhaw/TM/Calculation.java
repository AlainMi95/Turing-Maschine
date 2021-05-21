package main.java.ch.zhaw.TM;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
	private List<Character>band;
	private List<State> states;
	private int readerPos;
	private int stateNr;
	
	public Calculation(String input) {
		band= new ArrayList<Character>();
		readerPos=0;
		stateNr=0;
		String[] parts = input.split("111");
		BiteCode biteCode= new BiteCode(parts[0]);
		states= biteCode.createState();
		printStates();
		System.out.println("Band: "+input.substring(parts[0].length()+3));
		stringToArrayList(input.substring(parts[0].length()+3));	
	}
	
	
    private void stringToArrayList(String band) {
    	for (int i = 0; i < band.length(); i++) {
    		this.band.add(band.charAt(i));
    	}
    }
    
    public void calculate() {
    	while(findState()!=null) {
    		State actState= findState();
    		band.set(readerPos, actState.getWrite());
    		readerPos= readerPos+actState.getDirection();
    		stateNr= actState.getnextState();
    		checkPos();
    		System.out.println("-| q"+actState.getState()+", "+ actState.getRead()+", "+actState.getWrite()+", "+actState.getDirLetter());      
    		printBand(actState.getState());
    	}
    	System.out.println("Result: "+countOnes());
    }
    
    private int countOnes() {
		int count=0;
		for (char c: band) {
			if (c=='1') {
				count++;
			}
		}
		return count;
	}


	private State findState() {
    	State state= null;
    	for (State st: states) {
    		if (st.getState()== stateNr && st.getRead()== band.get(readerPos)) {
    			state= st;
    		}
    	}  	  	
    	return state;
    }
    
    private void  checkPos() {
    	if (readerPos==-1) {
    		readerPos=0;
    		band.add(0, '0');
    	} else if (readerPos== band.size()) {
    		band.add('0');
    	}
    }
    
    private void printBand(int statNr) {
    	List<Character> printBand= new ArrayList<Character>();
    	for(char c: band) {
    		printBand.add(c);
    	}
    	String stringBand="";
    	printBand.add(readerPos, 'q');
    	for (char c: printBand) {
    		if (c!='q') {
    			stringBand= stringBand+ String.valueOf(c);
    		} else {
    			stringBand= stringBand+"(q"+statNr+")";
    		} 		
    	}
    	System.out.println("Band: "+stringBand);
    	
    }
    
    private void printStates() {
    	for (State s: states) {
    		s.print();
    	}
    }
}
