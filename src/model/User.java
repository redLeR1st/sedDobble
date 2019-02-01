package model;

import java.util.List;

public class User {
	String name = "";
	public int punushment = 0;
	List<Card> hand;
	
	public String getUserName() {
		return name;
	}
	
	public void punish() {
		this.punushment += 1;
		System.out.println(this.name + "nevu jatekos buntetest kapott: " + this.punushment + " db buntetopontja van.");

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
		if (hand.size() == 0) {
			return null;
		}
		
		Card ret = hand.get(hand.size() - 1);
		hand.remove(ret);
		return ret;
	}
	
	public List<Card> getCards() {
		return hand;
	}
}