import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
		primaryStage.setTitle("Time Table");
		
		Label l1 = new Label("Time Table for Core Courses");
		
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
		
		TextField ta = new TextField("Tue");
		TextField tb = new TextField("");
		TextField tc = new TextField("RA"+"\n"+" C02");
		TextField td = new TextField("S&S"+"\n"+" C21");
		TextField te = new TextField("LUNCH");
		TextField tf = new TextField("DM"+"\n"+" C21");
		TextField tg = new TextField("M-III"+"\n"+" C21");
		TextField th = new TextField("ES"+"\n"+" C24  IMS C03 TPEE C22  ISI C13");
		TextField ti = new TextField("PO C02");
		
		TextField w1 = new TextField("Wed");
		TextField w2 = new TextField("");
		TextField w3 = new TextField("NT"+"\n"+" C12");
		TextField w4 = new TextField("AP"+"\n"+" C21");
		TextField w5 = new TextField("LUNCH");
		TextField w6 = new TextField("Tut CO"+"\n"+" LR2, LR3, C22, C23");
		TextField w7 = new TextField("CO"+"\n"+" C21");
		TextField w8 = new TextField("IDE"+"\n"+" C11  PSY C01  POK C24  TA C12");
		
		TextField th1 = new TextField("Thurs");
		TextField th2 = new TextField("");
		TextField th3 = new TextField("RA"+"\n"+" C02");
		TextField th4 = new TextField("AP"+"\n"+" C21");
		TextField th5 = new TextField("Lab AP L21, L22, L23");
		TextField th6 = new TextField("LUNCH");
		TextField th7 = new TextField("S&S"+"\n"+" C21");
		TextField th8 = new TextField("M-III"+"\n"+" C21");
		TextField th9 = new TextField("CO"+"\n"+" C01");
		
		TextField f1 = new TextField("Fri");
		TextField f2 = new TextField("");
		TextField f3 = new TextField("NT"+"\n"+" C12");
		TextField f4 = new TextField("Tut NT"+"\n"+" LR1");
		TextField f5 = new TextField("DM C21");
		TextField f6 = new TextField("LUNCH");
		TextField f7 = new TextField("S&S"+"\n"+" C21");
		TextField f8 = new TextField("M-III"+"\n"+" C21");
		TextField f9 = new TextField("ES C24  IMS C03 TPEE C22  ISI C13");
		TextField f10 = new TextField("Tut DM LR1, LR2, LR3");
		
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
		root.add(t2, 1, 1, 4, 1);
		root.add(t3, 5, 1, 2, 1);
		root.add(t4, 7, 1, 2, 1);
		root.add(t5, 9, 1, 2, 1);
		root.add(t6, 11, 1, 1, 1);
		root.add(t7, 12, 1, 3, 1);
		root.add(t8, 15, 1, 2, 1);
		root.add(t9, 17, 1, 3, 1);
		
		root.add(ta, 0, 2, 1, 1);
		root.add(tb, 1, 2, 4, 1);
		root.add(tc, 5, 2, 2, 1);
		root.add(td, 7, 2, 2, 1);
		root.add(te, 9, 2, 3, 1);
		root.add(tf, 12, 2, 3, 1);
		root.add(tg, 15, 2, 2, 1);
		root.add(th, 17, 2, 3, 1);
		
		root.add(ti, 18, 3, 3, 1);
		
		root.add(w1, 0, 4, 1, 1);
		root.add(w2, 1, 4, 4, 1);
		root.add(w3, 5, 4, 2, 1);
		root.add(w4, 7, 4, 2, 1);
		root.add(w5, 9, 4, 3, 1);
		root.add(w6, 12, 4, 2, 1);
		root.add(w7, 14, 4, 3, 1);
		root.add(w8, 17, 4, 3, 1);
		
		root.add(th1, 0, 5, 1, 1);
		root.add(th2, 1, 5, 4, 1);
		root.add(th3, 5, 5, 2, 1);
		root.add(th4, 7, 5, 2, 1);
		root.add(th5, 9, 5, 2, 1);
		root.add(th6, 11, 5, 2, 1);
		root.add(th7, 13, 5, 2, 1);
		root.add(th8, 15, 5, 2, 1);
		root.add(th9, 17, 5, 3, 1);
		
		root.add(f1, 0, 6, 1, 1);
		root.add(f2, 1, 6, 3, 1);
		root.add(f3, 4, 6, 2, 1);
		root.add(f4, 6, 6, 2, 1);
		root.add(f5, 8, 6, 2, 1);
		root.add(f6, 10, 6, 3, 1);
		root.add(f7, 13, 6, 2, 1);
		root.add(f8, 15, 6, 2, 1);
		root.add(f9, 17, 6, 3, 1);
		root.add(f10, 17, 7, 3, 1);
		
		ScrollPane sp = new ScrollPane();
		sp.setContent(root);
		
		VBox y = new VBox();
		y.setAlignment(Pos.CENTER);
		y.setSpacing(30);
		y.getChildren().addAll(l1, sp);
		
		y.setPadding(new Insets(20));
		
		Scene scene	= new Scene(y, 800, 400);		
		primaryStage.setScene(scene);		
		primaryStage.show();		
	}	
}
