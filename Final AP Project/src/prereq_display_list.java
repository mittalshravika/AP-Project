import java.io.IOException;
import java.util.ArrayList;

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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/**
 * GUI for displaying the courses student can take in further semesters by
 * checking if any subject in the current semester is a prereq for further
 * courses
 * 
 * @author Yajur
 * @author Shravika
 *
 */
public class prereq_display_list extends Application {
	User current_User;

	/**
	 * Constructor
	 * 
	 * @param current_User - user who is currently logged in
	 */
	public prereq_display_list(User current_User) {
		this.current_User = current_User;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, IOException {
		primaryStage.setTitle("Classroom Booking System");
		Scene ListV;

		Label title = new Label("Courses student can take in further semesters");

		HBox x = new HBox();
		x.getChildren().addAll(title);

		x.setAlignment(Pos.CENTER);
		VBox y = new VBox();
		HBox s = new HBox();
		VBox[] A = new VBox[2];

		for (int i = 0; i < 2; i++) {
			A[i] = new VBox();
			A[i].setSpacing(150);

		}
		A[0].setAlignment(Pos.CENTER_RIGHT);

		Button back = new Button("Back");
		A[0].getChildren().addAll(back);
		s.getChildren().addAll(A[0]);
		s.setAlignment(Pos.CENTER);
		s.setSpacing(400);

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");
		ListView<String> list = new ListView<String>();
		ObservableList<String> data = FXCollections.observableArrayList("Advanced Programing", "Discrete Maths", "DSA",
				"Introduction to Programing", "Linear Algebra", "Probability and Statistics", "Computer Organistation",
				"Operating Systems", "System Management", "Digital Circuits", "Basic Electronics", "Real Analysis",
				"Calculus", "Differential Equations", "Advanced Design of Algorithms", "Number Theory", "DBMS",
				"Signals and Systems", "Circuit Theory and Devices");
		list.setItems(data);
		data.clear();

		/**
		 * Populates the prerequisite list for the student
		 */
		App.deserialize("prereqlist");
		App.deserialize("corecourselist");

		for (int i = 0; i < App.core_Course_List.size(); i++) {
			for (int j = 0; j < App.prereqlist.size(); j++) {
				if (App.core_Course_List.get(i).getCoursename().equals(App.prereqlist.get(j).coursename)) {
					for (int k = 0; k < App.prereqlist.get(j).courses.size(); k++) {
						data.add(App.prereqlist.get(j).courses.get(k));
					}
					break;
				}
			}
		}

		App.serialize("corecourselist", "corecourse");

		try {
			App.deserialize(current_User.getEmail_id() + "new");
		} catch (NullPointerException e) {
			System.out.println("New File");
		}

		for (int i = 0; i < current_User.newcourse_List.size(); i++) {
			for (int j = 0; j < App.prereqlist.size(); j++) {
				if (current_User.newcourse_List.get(i).getCoursename().equals(App.prereqlist.get(j).coursename)) {
					for (int k = 0; k < App.prereqlist.get(j).courses.size(); k++) {
						data.add(App.prereqlist.get(j).courses.get(k));
					}
					break;
				}
			}
		}

		try {
			if (current_User.newcourse_List.size() > 0) {
				App.serialize(current_User.getEmail_id() + "new", "register");
			}
		} catch (IOException e2) {

			e2.printStackTrace();
		}

		App.serialize("prereqlist", "prereq");

		/**
		 * Returns back to the student page
		 */
		back.setOnAction(e -> {
			try {
				new student_Page(current_User).start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		ScrollPane pane = new ScrollPane();
		pane.setContent(list);
		pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		y.getChildren().addAll(l, x, list, s);

		y.setAlignment(Pos.CENTER);

		y.getStyleClass().add("background");
		y.setSpacing(30);
		y.setPadding(new Insets(20));

		ListV = new Scene(y, 1100, 800);
		ListV.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(ListV);
		primaryStage.show();
	}

}