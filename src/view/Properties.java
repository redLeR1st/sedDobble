package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Constants;

public class Properties extends Application {


	private static int numberOfPlayers = Constants.NUMBER_OF_PLAYERS;
	private static String gameMode = Constants.DEFAULT_GAME_MODE;
	
	private static Stage stage;
	
	private static List<String> userNames;
	
	@Override
    public void start(Stage primaryStage) {
		stage = new Stage();
		stage.setTitle("Properties");
		userNames = new ArrayList<String>();
		userNames.add("");
		userNames.add("");
		userNames.add("");
		
        Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("properties.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (root != null) {
			stage.setScene(new Scene(root));
			
			TextField textField = (TextField) stage.getScene().lookup("#userName" + 1);
			textField.setDisable(true);
			textField = (TextField) stage.getScene().lookup("#userName" + 2);
			textField.setDisable(true);
			
			stage.show();
	        
		} else {
			System.out.println("Failed to load properties.fxml!");
		}
    }

	public void save() {
		
		for (int i = 0; i < numberOfPlayers; ++i) {
			TextField textField = (TextField) stage.getScene().lookup("#userName" + i);
			if (textField != null) {
				userNames.set(i, textField.getText());
			}
			
		}
		
		stage.close();
	}
	
	public void enablePlayer1(ActionEvent event) {
		CheckBox check = (CheckBox) event.getSource();
		TextField textField = (TextField) stage.getScene().lookup("#userName" + 1);
		if (check.isSelected()) {
			numberOfPlayers++;
			textField.setDisable(false);
		} else {
			numberOfPlayers--;
			textField.setDisable(true);
		}
		
	}
	
	public void enablePlayer2(ActionEvent event) {
		CheckBox check = (CheckBox) event.getSource();
		TextField textField = (TextField) stage.getScene().lookup("#userName" + 2);
		if (check.isSelected()) {
			numberOfPlayers++;
			textField.setDisable(false);
		} else {
			numberOfPlayers--;
			textField.setDisable(true);
		}
	}
	
	
	public void cancel() {
		gameMode = "";
		numberOfPlayers = Constants.NUMBER_OF_PLAYERS;
		userNames = new ArrayList<String>();
		userNames.add("");
		userNames.add("");
		userNames.add("");
		stage.close();
	}


	public static String getMode() {
		return gameMode;
	}
	
	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public static List<String> getUserNames() {
		return userNames;
	}
}