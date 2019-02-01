package model;

public class Card {
	List<int> symbols;
	
	Card() {
		symbols = new ArrayList<int>;
	}
	
	void addSymb(int sim) {
		symbols.add(sim);
	}
	
	
	boolean match(int i){
		if (this.symbols.contains(i)) {
			return true;
		}
		else false;	
	}
	
	List<int> getSymbols() {
		return symbols;
	}
	
	int getSymbolByIndex(int i) {
		symbols.get(i);
	}
	
	boolean equals(Card c) {
		for (int i = 0; i < 8; i++) {
			if (this.symbols.get(i) != c.getSymbolByIndex(i)) {
				return false;
			}
		}
		return true;
	}
}
