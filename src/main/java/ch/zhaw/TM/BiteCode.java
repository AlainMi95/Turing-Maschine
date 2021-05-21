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
			System.out.println(stateCode);
			String[] parts = stateCode.split("1");
			if (parts.length==5) {
				allStates.add(new State(detState(parts[0]), detSymbol(parts[1]), 
							  detState(parts[2]),detSymbol(parts[3]), detDirection(parts[4])));
			} else if (parts.length==4) {
				allStates.add(new State(detState(parts[0]), detSymbol(parts[1]), 
						  -1, detSymbol(parts[3]), detDirection(parts[4])));
			}
		}
		return allStates;	
	}
	
	private int detState (String code) {
		return code.length()-1;
	}
	
	private int detDirection (String code) {
		int retVal= 0;
		if (code.equals("00")) {
			retVal= 1;
		} else if(code.equals("0")){
			retVal= -1;
		}
		return retVal;
	}
	
	private char detSymbol(String code) {
		char retVal='u';
		if (code.equals("0")) {
			retVal='0';
		} else if (code.equals("00")) {
			retVal='1';
		} else if (code.equals("000")) {
			retVal='_';
		}
		return retVal;
	}
}
