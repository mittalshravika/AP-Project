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
 * GUI for displaying the courses taken by the faculty
 * 
 * @author Yajur
 * @author Shravika
 *
 */
public class faculty_Course_List extends Application {
	User current_User;

	/**
	 * Constructor
	 * 
	 * @param current_User
	 */
	public faculty_Course_List(User current_User) {
		this.current_User = current_User;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, IOException {
		primaryStage.setTitle("Classroom Booking System");
		Scene ListV;

		Label title = new Label("Course Page");

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
		Button Submit = new Button("View Course Page");
		A[0].setAlignment(Pos.CENTER_RIGHT);

		Button back = new Button("Back");
		A[0].getChildren().addAll(back);
		A[1].getChildren().addAll(Submit);
		A[1].setAlignment(Pos.CENTER_LEFT);
		s.getChildren().addAll(A[0], A[1]);
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
		 * Populates the course list for the faculty
		 */
		App.deserialize("courselist");
		for (int i = 0; i < App.course_List.size(); i++) {
			if (App.course_List.get(i).getInstructorname().equals(current_User.getName())
					&& !(App.course_List.get(i).getCoursename().split(";")[0].equals("TUT")
							|| App.course_List.get(i).getCoursename().split(";")[0].equals("LAB")
							|| App.course_List.get(i).getCoursename().split(";")[0].equals("TUT2"))) {
				data.add(App.course_List.get(i).getCoursename());
			}
		}
		App.serialize("courselist", "course");

		list.setOnMouseClicked(new EventHandler<MouseEvent>() {

			/**
			 * Returns the course object
			 * 
			 * @param str
			 * @return
			 */
			public Course get_Course(String str) {
				Course obj = null;
				for (int i = 0; i < App.course_List.size(); i++) {
					if (str.equals(App.course_List.get(i).getCoursename())) {
						obj = App.course_List.get(i);
					}
				}
				return obj;
			}

			/**
			 * Displays the course page with course details for the course
			 * selected
			 */
			@Override
			public void handle(MouseEvent event) {

				String str = list.getSelectionModel().getSelectedItem();

				Submit.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						Course object = get_Course(str);
						try {
							new course_Page_Faculty(object, current_User).start(primaryStage);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});

		/**
		 * Returns back to the faculty page
		 */
		back.setOnAction(e -> {
			try {
				new faculty_Page(current_User).start(primaryStage);
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