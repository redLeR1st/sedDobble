package model;

import java.util.List;

public class User {
	String name = "";
	List<Card> hand;
	
	public String getUserName() {
		return name;
	}
	
	public void setName(String un) {
		name = un;
	}
	
	public User() {
		name = "peldaBela";
	}
	
	public Card getNextCard() {
		return hand.get(hand.size() - 1);
	}
	
	//TODO: WARNING!
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public Card dropCard() {
		Card ret = hand.get(hand.size() - 1);
		hand.remove(ret);
		return ret;
	}
	
}