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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class personal_Time_Table extends Application
{
	public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage)	
	{	
		primaryStage.setTitle("Personalised Time Table");
		
		ChoiceBox<String> day = new ChoiceBox<>();
		day.getItems().addAll("Monday", "Tueday", "Wednesday", "Thursday", "Friday");
		
		day.setValue("Monday");
		
		Label l1 = new Label("Day");
		
		ChoiceBox<String> month = new ChoiceBox<>();
		month.getItems().addAll("August", "September", "October", "November");
		
		month.setValue("August");
		
		Label l2 = new Label("Month");
		
		ChoiceBox<String> date = new ChoiceBox<>();
		for(int i = 1 ; i<=31 ; i++)
		{
			date.getItems().add(Integer.toString(i));
		}
		
		date.setValue("1");
		
		Label l3 = new Label("Date");
		
		Button btn = new Button("Submit details");
		
		StackPane root2 = new StackPane();
		root2.setPadding(new Insets(20));
		
		HBox x = new HBox();
		x.setSpacing(35);
		x.getChildren().addAll(l1, day, l2, month, l3, date, btn);
		
		GridPane root = new GridPane();
		
		TextField t11 = new TextField("Day");
		TextField t12 = new TextField("8:00 - 8:30");
		TextField t13 = new TextField("8:30 - 9:00");
		TextField t14 = new TextField("9:00 - 9:30");
		TextField t15 = new TextField("9:30 - 10:00");
		TextField t16 = new TextField("10:00 - 10:30");
		TextField t17 = new TextField("10:30 - 11:00");
		TextField t18 = new TextField("11:00 - 11:30");
		TextField t19 = new TextField("11:30 - 12:00");
		TextField t20 = new TextField("12:00 - 12:30");
		TextField t21 = new TextField("12:30 - 1:00");
		TextField t22 = new TextField("1:00 - 1:30");
		TextField t23 = new TextField("1:30 - 2:00");
		TextField t24 = new TextField("2:00 - 2:30");
		TextField t25 = new TextField("2:30 - 3:00");
		TextField t26 = new TextField("3:00 - 3:30");
		TextField t27 = new TextField("3:30 - 4:00");
		TextField t28 = new TextField("4:00 - 4:30");
		TextField t29 = new TextField("4:30 - 5:00");
		TextField t30 = new TextField("5:00 - 5:30");
		TextField t31 = new TextField("5:30 - 6:00");
		
		TextField t1 = new TextField("Mon");
		TextField t2 = new TextField("");
		TextField t3 = new TextField("NT"+"\n"+" C12");
		TextField t4 = new TextField("AP"+"\n"+" C21");
		TextField t5 = new TextField("Tut AP"+"\n"+" S02");
		TextField t6 = new TextField("LUNCH");
		TextField t7 = new TextField("Tut RA"+"\n"+" LR2");
		TextField t8 = new TextField("RA"+"\n"+" C02");
		TextField t9 = new TextField("IDE"+"\n"+" C11  PSY C01  POK C24  TA C12");
		
		root.add(t11, 0, 0, 1, 1);
		root.add(t12, 1, 0, 1, 1);
		root.add(t13, 2, 0, 1, 1);
		root.add(t14, 3, 0, 1, 1);
		root.add(t15, 4, 0, 1, 1);
		root.add(t16, 5, 0, 1, 1);
		root.add(t17, 6, 0, 1, 1);
		root.add(t18, 7, 0, 1, 1);
		root.add(t19, 8, 0, 1, 1);
		root.add(t20, 9, 0, 1, 1);
		root.add(t21, 10, 0, 1, 1);
		root.add(t22, 11, 0, 1, 1);
		root.add(t23, 12, 0, 1, 1);
		root.add(t24, 13, 0, 1, 1);
		root.add(t25, 14, 0, 1, 1);
		root.add(t26, 15, 0, 1, 1);
		root.add(t27, 16, 0, 1, 1);
		root.add(t28, 17, 0, 1, 1);
		root.add(t29, 18, 0, 1, 1);
		root.add(t30, 19, 0, 1, 1);
		root.add(t31, 20, 0, 1, 1);
				
		root.add(t1, 0, 1, 1, 2);
		root.add(t2, 1, 1, 4, 2);
		root.add(t3, 5, 1, 2, 2);
		root.add(t4, 7, 1, 2, 2);
		root.add(t5, 9, 1, 2, 2);
		root.add(t6, 11, 1, 1, 2);
		root.add(t7, 12, 1, 3, 2);
		root.add(t8, 15, 1, 2, 2);
		root.add(t9, 17, 1, 3, 2);
		
		ScrollPane sp = new ScrollPane();
		sp.setContent(root);
		
		VBox y = new VBox();
		y.setSpacing(30);
		y.getChildren().addAll(x, sp);
		
		root2.getChildren().add(y);
		
		Scene scene	= new Scene(root2, 800, 400);		
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}
