package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Properties extends Application {


	private static int numberOfPlayers;
	private static String gameMode;
	
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