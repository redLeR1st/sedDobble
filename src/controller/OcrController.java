package controller;

import java.io.IOException;

import engine.Engine;
import javafx.scene.image.Image;
import view.OcrGUI;

public class OcrController {	
	private OcrGUI gui;

	
	public OcrController() {

	}

	public void startDesktop() {
		gui = new OcrGUI();
		gui.startGUI();
	}

	
}