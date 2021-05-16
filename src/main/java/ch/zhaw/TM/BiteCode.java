package main.java.ch.zhaw.TM;

import java.util.ArrayList;
import java.util.List;

public class BiteCode {
	private String bitecode;
	
	public BiteCode(String biteCode) {
		this.bitecode= biteCode;
	}
	
	public List<State> createState() {
		List<State> allStates = new ArrayList<State>();
		bitecode= bitecode.substring(1, bitecode.length());
		String[] stateCodes = bitecode.split("11");
		for (String stateCode:stateCodes) {
			String[] parts = stateCode.split("1");
			if (parts.length==5) {
				allStates.add(new State(detState(parts[0]), parts[1].charAt(0), 
							  detState(parts[2]), parts[3].charAt(0), detDirection(parts[4])));
				}
		}
		return allStates;	
	}
	
	private int detState (String code) {
		return code.length()-1;
	}
	
	private char detDirection (String code) {
		char retVal='0';
		if (code.equals("00")) {
			retVal= 'R';
		} else if(code.equals("0")){
			retVal= 'L';
		}
		return retVal;
	}	
}
