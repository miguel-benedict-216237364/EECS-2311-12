package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	public static Stage mainStage;
	public static Scene mainScene;
	public static Scene presentationScene;
	public static Scene evaluationScene;


	

	@Override
	public void start(final Stage primaryStage) {
		try {
			mainStage = primaryStage;
			Parent mainRoot = FXMLLoader.load(getClass().getResource("/application/mainFXML.fxml"));
			mainScene = new Scene(mainRoot, 1280, 720);	
		//mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			mainStage.setScene(mainScene);
			mainStage.sizeToScene();
			mainStage.requestFocus();
			mainStage.show();
			
			mainStage.setTitle("Venn DiagramFX");
			
			mainStage.setMinHeight(720);
			mainStage.setMinWidth(1280);
			

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		launch(args);
	}
	

	
	public static void switchScene(Scene scene) {
		mainStage.setScene(scene);
		mainStage.sizeToScene();
		mainStage.requestFocus();
		mainStage.show();
		
	}
	// this is a test
	// CircleCI test
	//test
}
