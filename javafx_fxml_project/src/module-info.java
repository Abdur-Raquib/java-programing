module javafx_fxml_project {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens basic to javafx.graphics, javafx.fxml;
}
