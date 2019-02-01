package model;

import java.util.ArrayList;
import java.util.List;

public class Card {
	List<Integer> symbols;
	
	Card() {
		symbols = new ArrayList<Integer>();
	}
	
	void addSymb(int sim) {
		symbols.add(sim);
	}
	
	
	public boolean match(int i){
		if (this.symbols.contains(i)) {
			return true;
		}
		else {return false;}	
	}
	
	public List<Integer> getSymbols() {
		return symbols;
	}
	
	public int getSymbolByIndex(int i) {
		return symbols.get(i);
	}
	
	boolean equals(Card c) {
		for (int i = 0; i < 8; i++) {
			if (this.symbols.get(i) != c.getSymbolByIndex(i)) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String ret = "";
		for (int i = 0; i < 8; i++) {
			ret += symbols.get(i) + " ";
		}
		ret += "\n";
		return ret;
	}
	
}
