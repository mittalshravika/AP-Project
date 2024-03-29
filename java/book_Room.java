import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class book_Room extends Application
{
	public static void main(String[] args)	
	{	
		launch(args);	
	}	
	@Override	
	public void start(Stage	primaryStage)	
	{	
		primaryStage.setTitle("Personalised Time Table");
		
		Button btn = new Button("Submit details");
		Button btn2 = new Button("Submit Room Bookings");
		
		Label Date = new Label("Date:");
		DatePicker cal = new DatePicker();
		
		HBox x = new HBox();
		x.setSpacing(35);
		x.getChildren().addAll(Date, cal, btn);
		
		HBox x2 = new HBox();
		x2.setSpacing(35);
		x2.getChildren().addAll(btn2);
		x2.setAlignment(Pos.CENTER);
		
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
		
		TextField t1 = new TextField("C01");
		TextField t2 = new TextField("C02");
		TextField t3 = new TextField("C03");
		TextField t4 = new TextField("C04");
		TextField t5 = new TextField("C11");
		TextField t6 = new TextField("C12");
		TextField t7 = new TextField("C13");
		TextField t8 = new TextField("C14");
		TextField t9 = new TextField("C21");
		TextField ta = new TextField("C22");
		TextField tb = new TextField("C23");
		TextField tc = new TextField("C24");
		TextField td = new TextField("LR1");
		TextField te = new TextField("LR2");
		TextField tf = new TextField("LR3");
		TextField tg = new TextField("S01");
		TextField th = new TextField("S02");
		TextField ti = new TextField("L21");
		TextField tj = new TextField("L22");
		TextField tk = new TextField("L23");
		
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
				
		root.add(t1, 0, 1, 1, 1);
		
		root.add(t2, 0, 2, 1, 1);
		root.add(t3, 0, 3, 1, 1);
		root.add(t4, 0, 4, 1, 1);
		root.add(t5, 0, 5, 1, 1);
		root.add(t6, 0, 6, 1, 1);
		root.add(t7, 0, 7, 1, 1);
		root.add(t8, 0, 8, 1, 1);
		root.add(t9, 0, 9, 1, 1);
		root.add(ta, 0, 10, 1, 1);
		root.add(tb, 0, 11, 1, 1);
		root.add(tc, 0, 12, 1, 1);
		root.add(td, 0, 13, 1, 1);
		root.add(te, 0, 14, 1, 1);
		root.add(tf, 0, 15, 1, 1);
		root.add(tg, 0, 16, 1, 1);
		root.add(th, 0, 17, 1, 1);
		root.add(ti, 0, 18, 1, 1);
		root.add(tj, 0, 19, 1, 1);
		root.add(tk, 0, 20, 1, 1);
		
		for(int j = 1 ; j<=20 ; j++)
		{
			for(int i = 1 ; i<=20 ; i++)
			{
				root.add(new CheckBox("Book"), i, j, 1, 1);
			}
		}
		
		for (Node node : root.getChildren()) {
	        if ((GridPane.getColumnIndex(node)%2==0 && GridPane.getColumnIndex(node)>0) && (GridPane.getRowIndex(node)%2==0 && GridPane.getRowIndex(node)>0)) {
	            node.setDisable(true);
	        }
	    }
			
		ScrollPane sp = new ScrollPane();
		sp.setContent(root);
		
		sp.setVisible(false);
		btn2.setVisible(false);
		
		btn.setOnAction(e	->	{	
			sp.setVisible(true);
			btn2.setVisible(true);
		});	
		
		VBox y = new VBox();
		y.setSpacing(30);
		y.getChildren().addAll(x, sp, x2);
		y.setPadding(new Insets(20));
		
		Scene scene	= new Scene(y, 800, 400);		
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}
