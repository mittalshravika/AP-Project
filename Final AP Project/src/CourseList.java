import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBox.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class CourseList extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Classroom Booking System");
		Scene ListV;

		Label title = new Label("Course Page");
		
		HBox x = new HBox();
		x.getChildren().addAll(title);

		x.setAlignment(Pos.CENTER);
		VBox y = new VBox();
		HBox s = new HBox();
		Button Submit = new Button("Submit");
		Button home = new Button("Home");
		s.getChildren().addAll(home, Submit);
		s.setAlignment(Pos.CENTER_RIGHT);
		s.setSpacing(770);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");

		ListView<String> list = new ListView<String>();
		ObservableList<String> data = FXCollections.observableArrayList("Advanced Programing", "Discrete Maths", "DSA", "Introduction to Programing", "Linear Algebra", "Probability and Statistics", "Computer Organistation", "Operating Systems", "System Management", "Digital Circuits", "Basic Electronics", "Real Analysis", "Calculus", "Differential Equations", "Advanced Design of Algorithms", "Number Theory", "DBMS", "Signals and Systems", "Circuit Theory and Devices");
		list.setItems(data);
		ScrollPane pane = new ScrollPane();
		pane.setContent(list);
		pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		y.getChildren().addAll(l, x, list, s);
		
		y.setAlignment(Pos.CENTER);
		
		y.setStyle("-fx-background-color: #00DDDD");
		y.setSpacing(30);
		y.setPadding(new Insets(20));
		
		ListV = new Scene(y, 1000, 600);
		ListV.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(ListV);
		primaryStage.show();
	}

}