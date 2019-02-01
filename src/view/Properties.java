package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Constants;

public class Properties extends Application {


	private static int numberOfPlayers = Constants.NUMBER_OF_PLAYERS;
	private static String gameMode = Constants.DEFAULT_GAME_MODE;
	
	private static Stage stage;
	
	@Override
    public void start(Stage primaryStage) {
		stage = new Stage();
		stage.setTitle("Properties");
        Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("properties.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (root != null) {
			stage.setScene(new Scene(root));
			
			
			
			stage.show();
	        
		} else {
			System.out.println("Failed to load properties.fxml!");
		}
    }

	public void save() {
		
		stage.close();
	}
	
	public void cancel() {
		gameMode = "";
		stage.close();
	}


	public static String getMode() {
		return gameMode;
	}
	
	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}


}