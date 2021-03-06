package controller;

import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.Deck;
import model.User;
import view.OcrGUI;

public class OcrController {	
	private OcrGUI gui;
	private Deck d = new Deck();
	
	private long startTime;
	
	private List<Card> midHand;
	
	
	
	public OcrController() {

	}

	public Card getMainCard() {
		Card ret = midHand.get(midHand.size()-1);
		//midHand.remove(midHand.size()-1);
		
		return ret;
		
	}
	
	public void startDesktop() {
		gui = new OcrGUI();
		gui.startGUI();
	}


	public void setMid(Card setIt) {
		midHand.add(setIt);
	}
	
	User getUserByIndex(int i) {
		
		return null;
	}

	public String endTime() {
		long end = System.nanoTime();
		
		long elapsed = end-startTime;
		
		double seconds = (double)elapsed / 1000000000.0;
		
		double min = seconds/60;
		double sec = seconds%60;
		Double m = min;
		Double s = sec;

		String ret = "";
		
		ret += Integer.toString(m.intValue()) + " min ";
		ret += Integer.toString(s.intValue()) + " sec\n";
		
		return ret;
	}
	
	
	//jatekosok listáját adja vissza 
	public List<User> startGame(int n) {
		midHand = new ArrayList<Card>();
		Card toMid = d.deal(1).get(0);
		setMid(toMid);
		List<User> users = new ArrayList<User>();
		
		for (int i = 0; i < n; i++) {
			User user = new User();
			user.setHand(d.deal(10));
			users.add(user);
		}	
		
		startTime = System.nanoTime();
		
		return users;
	}
	
}