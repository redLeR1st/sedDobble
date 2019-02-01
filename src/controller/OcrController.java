package controller;

import java.io.IOException;

import view.OcrGUI;

public class OcrController {	
	private OcrGUI gui;
	private Deck d = new Deck();
	

	private List<Card> midHand;
	
	
	
	public OcrController() {

	}

	Card getMainCard {
		Card ret = midHand.get(midHand.size()-1);
		midHand.remove(midHand.size()-1);
		
		return ret;
		
	}
	
	public void startDesktop() {
		gui = new OcrGUI();
		gui.startGUI();
	}

	boolean endGame() {
	}
	
	void setMid(Card setIt) {
		midHand.add(setIt);
	}
	
	User getUserByIndex(int i) {
		
		
	}

	
	//jatekosok listáját adja vissza 
	List<User> startGame(int n) {
		mindHand = new ArrayList<Card>();
		Card toMid = d.deal(0).get(0);
		setMid(toMid);
		List<User> users = new ArrayList<User>();
		
		for (int i = 0; i < n; i++) {
			user = new User();
			user.setHand(d.deal(10));
			users.add(user);
		}	
		
	}
	
}