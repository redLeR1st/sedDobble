package model;

public class User {
	String name = "";
	List<Card> hand;
	
	public String getUsername() {
		return name;
	}
	
	public void setName(String un) {
		name = un;
	}
	
	User() {
		name = "peldaBela";
	}
	
	Card getNextCard() {
		return hand.get(hand.size() - 1);
	}
	
	//TODO: WARNING!
	void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	Card dropCard() {
		Card ret hand.get(hand.size() - 1);
		hand.remove(ret);
		return ret;
	}
	
}