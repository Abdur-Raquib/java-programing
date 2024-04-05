package pactice;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FirstFX extends Application{


	@Override
	public void start(Stage stage) {
		Button btn = new Button("Say! hello world");
		btn.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("hello world");
			}
		});
		StackPane layout=new StackPane();
		layout.getChildren().add(btn);
		Scene scene = new Scene(layout,400,500);
		stage.setScene(scene);
		stage.setTitle("FirstFx");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
