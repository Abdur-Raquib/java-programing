package pactice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class firstJavaFxProgram extends Application {
	
	// this program shown some IlligalAccessException. we didn't add this package to the module
	
	public void init() {
		System.out.println("Befor");
	}

	@Override
	public void start(Stage stage) {
		Button btn = new Button();
		StackPane st = new StackPane();
		st.getChildren().add(btn);
		Scene scene = new Scene(st,300,250);
		stage.setTitle("hello world");
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void stop() {
		System.out.println("After");
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class Stage2{
	
}
