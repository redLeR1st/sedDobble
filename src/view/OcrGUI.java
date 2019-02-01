package view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import controller.OcrController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Card;
import model.Constants;
import model.User;

public class OcrGUI extends Application {
	
	private final OcrController controller = application.Main.controller;
	private static Stage stage;
	private Desktop desktop = Desktop.getDesktop();
	
	private static List<User> users;
	private int currentPlayer = 0;
	
	@Override
    public void start(final Stage primaryStage) {
		primaryStage.setTitle("SED DOBBLE");
		stage = primaryStage;
        Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("ui.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(root != null) {
			primaryStage.setScene(new Scene(root));
	        
			users = controller.startGame(Properties.getNumberOfPlayers());
			Card mainCard = controller.getMainCard();
			
			int i = 0;
			for (User user : users) {
				
				Label label = (Label) primaryStage.getScene().lookup("#user_" + i);
				
				
				label.setText(user.getUserName());
				label.setVisible(true);
				
				for (int j = 0; j < Constants.NUMBER_OF_CARDS; ++j) {
					
					
					Button button = (Button) primaryStage.getScene().lookup("#symbol_" + i + j);
					
					if (button == null) {
						System.out.println("#symbol_" + i + j);
					}
					
					button.setText(String.valueOf(user.getNextCard().getSymbolByIndex(j)));
					button.setVisible(true);
					
				}
				
				GridPane pane = (GridPane) primaryStage.getScene().lookup("#user_" + i + "_layout");
				
				System.out.println("#user_" + i + "_layout");
				
				pane.setVisible(true);
				
				++i;
			}
			for (int j = 0; j < Constants.NUMBER_OF_CARDS; ++j) {
				Button button = (Button) primaryStage.getScene().lookup("#main_" + 0 + j);
				
				button.setText(String.valueOf(mainCard.getSymbolByIndex(j)));
			}
			
			currentPlayer = 0;
			
			while (endGame()) {
				
				nextRound(Properties.getNumberOfPlayers());
			}

	        primaryStage.show();
	        
		} else {
			System.out.println("Failed to load ui.fxml!");
		}
    }
    
	private boolean endGame() {
		for (User user : users) {
			if (user.getCards().size() == 0) {
				return true;
			} 
		}
		return false;
	}
	
	public void match(ActionEvent event) {
		Button btn = (Button) event.getSource();
		String id = btn.getId().replace("symbol_", "");
		
		
		
		int userIndex = Character.getNumericValue(id.charAt(0));
		
		System.out.println(userIndex + " " + users.size());
		
		User user = users.get(userIndex);
		
		int index = Character.getNumericValue(id.charAt(1));
		
		
		
		if (controller.getMainCard().match(index)) {
			Card card = user.dropCard();
			controller.setMid(card);
			System.out.println("MATCH");
			
			for (int i = 0; i < Constants.NUMBER_OF_CARDS; ++i) {
				Button button = (Button) stage.getScene().lookup("#main_" + 0 + i);
				button.setText(String.valueOf(card.getSymbolByIndex(i)));
			}
			
			for (int i = 0; i < Constants.NUMBER_OF_CARDS; ++i) {
				Button button = (Button) stage.getScene().lookup("#symbol_" + userIndex + i);
				button.setText(String.valueOf(user.getNextCard().getSymbolByIndex(i)));
			}
			
		} else {
			
			System.out.println(controller.getMainCard() + " " + index);
		}
		
	}
	

	public void nextRound(int j) {
		currentPlayer = currentPlayer + 1 % Properties.getNumberOfPlayers();
		
		for (int i = 0; i < Properties.getNumberOfPlayers(); ++i) {
			GridPane pane = (GridPane) stage.getScene().lookup("#user_" + i + "_layout");
			pane.setDisable(true);
		}
		GridPane pane = (GridPane) stage.getScene().lookup("#user_" + currentPlayer + "_layout");
		pane.setDisable(false);
	}
	

	
    public void startGUI() {
    	launch();
    }
    
    public void quitMenuAction() {
        System.exit(0);
    }

    public void showProperties() {
    	Properties dialog = new Properties();
    	dialog.start(stage);
    }
}