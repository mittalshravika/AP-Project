import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 * GUI displaying the course details of a course
 * 
 * @author Yajur - 2016121
 * @author Shravika - 2016093
 *
 */
public class CoursePage extends Application {

	private Course object;
	User current_User;

	/**
	 * Constructor
	 * 
	 * @param obj - course object
	 * @param student_User - student who is currently logged in
	 */
	public CoursePage(Course obj, User student_User) {
		object = obj;
		current_User = student_User;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene CourseView;
		GridPane Course;

		primaryStage.setTitle("Classroom Booking System");

		Course = new GridPane();
		Course.setPadding(new Insets(20, 20, 20, 20));
		Course.setVgap(8);
		Course.setHgap(10);

		Label title = new Label("Course Page");
		title.getStyleClass().add("admin_page_heading");

		HBox x = new HBox();
		x.getChildren().addAll(title);
		x.setAlignment(Pos.CENTER);
		VBox y = new VBox();

		Label Name = new Label("Course Name:");
		Name.setMinWidth(Region.USE_PREF_SIZE);
		Name.getStyleClass().add("Course");

		GridPane.setConstraints(Name, 0, 0);
		Label Name_D = new Label();
		Name_D.setText(object.getCoursename());
		Name_D.getStyleClass().add("Course");
		GridPane.setConstraints(Name_D, 1, 0);

		Label Number = new Label("Course Number:");
		Number.setMinWidth(Region.USE_PREF_SIZE);
		Number.getStyleClass().add("Course");
		GridPane.setConstraints(Number, 0, 1);
		Label Number_D = new Label();
		Number_D.getStyleClass().add("Course");
		Number_D.setText(object.getCoursecode());
		GridPane.setConstraints(Number_D, 1, 1);

		Label Instructor = new Label("Instructor:");
		Instructor.setMinWidth(Region.USE_PREF_SIZE);
		Instructor.getStyleClass().add("Course");
		GridPane.setConstraints(Instructor, 0, 2);
		Label Instructor_D = new Label();
		Instructor_D.setText(object.getInstructorname());
		Instructor_D.getStyleClass().add("Course");
		GridPane.setConstraints(Instructor_D, 1, 2);

		Label Type = new Label("Type of Course:");
		Type.setMinWidth(Region.USE_PREF_SIZE);
		Type.getStyleClass().add("Course");
		GridPane.setConstraints(Type, 0, 3);
		Label Type_D = new Label();
		Type_D.setText(object.getCoursetype());
		Type_D.getStyleClass().add("Course");
		GridPane.setConstraints(Type_D, 1, 3);

		Label PCond = new Label("Post Conditions:");
		PCond.setMinWidth(Region.USE_PREF_SIZE);
		PCond.getStyleClass().add("Course");
		GridPane.setConstraints(PCond, 0, 4);
		Label PCond_D = new Label();

		String postarr[] = object.getPostconditions().split(";");
		String postconditions = "";
		for (int i = 0; i < postarr.length; i++) {
			String str = postarr[i].replace("\"", "");
			postconditions = postconditions + str + "\n";
		}
		PCond_D.setText(postconditions);
		PCond_D.setWrapText(true);
		PCond_D.setMinHeight(200);
		PCond_D.getStyleClass().add("Course");
		GridPane.setConstraints(PCond_D, 1, 4);

		Label Timings = new Label("Timings:");
		Timings.setMinWidth(Region.USE_PREF_SIZE);
		Timings.getStyleClass().add("Course");
		GridPane.setConstraints(Timings, 0, 5);
		Label Timings_D = new Label();
		String timings = "";
		if (!(object.getMon().equals("-"))) {
			String arr[] = object.getMon().split(";");
			timings = timings + "Monday " + arr[0] + "\n";
		}
		if (!(object.getTue().equals("-"))) {
			String arr[] = object.getTue().split(";");
			timings = timings + "Tuesday " + arr[0] + "\n";
		}
		if (!(object.getWed().equals("-"))) {
			String arr[] = object.getWed().split(";");
			timings = timings + "Wednesday " + arr[0] + "\n";
		}
		if (!(object.getThurs().equals("-"))) {
			String arr[] = object.getThurs().split(";");
			timings = timings + "Thursday " + arr[0] + "\n";
		}
		if (!(object.getFri().equals("-"))) {
			String arr[] = object.getFri().split(";");
			timings = timings + "Friday " + arr[0] + "\n";
		}
		Timings_D.setText(timings);
		Timings_D.setWrapText(true);
		Timings_D.getStyleClass().add("Course");
		Timings_D.setPrefHeight(150);
		GridPane.setConstraints(Timings_D, 1, 5);

		/**
		 * Returns back to the Search Course list of the student
		 */
		Button Back = new Button("Back");
		Back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				new CourseList(current_User).start(primaryStage);

			}

		});
		Button Register = new Button("Register Course");

		/**
		 * Adds the course to the student time table
		 */
		Register.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				String course_Name = object.getCoursename();
				try {
					App.deserialize("courselist");
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}

				try {
					if (current_User.newcourse_List.size() > 0) {
						App.deserialize(current_User.getEmail_id() + "new");
					}
				} catch (ClassNotFoundException | IOException e2) {
					e2.printStackTrace();
				}

				for (int i = 0; i < App.course_List.size(); i++) {
					if (App.course_List.get(i).getCoursename().equals(course_Name)) {
						Course obj = App.course_List.get(i);
						current_User.newcourse_List.add(obj);
					}
					if (App.course_List.get(i).getCoursename().split(";")[0].equals("TUT")) {
						if (App.course_List.get(i).getCoursename().split(";")[1].equals(course_Name)) {
							Course obj = App.course_List.get(i);
							current_User.newcourse_List.add(obj);
						}
					}
				}

				try {
					App.serialize(current_User.getEmail_id() + "new", "register");
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				try {
					App.serialize("courselist", "course");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		Label l = new Label("IIIT-D");
		l.setAlignment(Pos.TOP_LEFT);
		l.getStyleClass().add("labelIIITD");

		HBox x1 = new HBox();
		x1.getChildren().addAll(Back, Register);
		x1.setAlignment(Pos.BOTTOM_LEFT);
		x1.setSpacing(600);

		Course.getChildren().addAll(Name, Name_D, Number, Number_D, Instructor, Instructor_D, Type, Type_D, PCond,
				PCond_D, Timings, Timings_D);
		Course.getStyleClass().add("gridCourse");
		y.getChildren().addAll(l, x, Course, x1);
		y.setSpacing(30);
		y.setPadding(new Insets(20));
		y.setAlignment(Pos.TOP_CENTER);

		y.getStyleClass().add("background");

		CourseView = new Scene(y, 1100, 800);
		CourseView.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setScene(CourseView);
		primaryStage.show();

	}
}