package First_Package;
 
 import javafx.application.Application;
 import javafx.event.ActionEvent;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
 import javafx.scene.control.Button;
 import javafx.scene.control.TextField;
 import javafx.scene.layout.GridPane;
 import javafx.scene.layout.VBox;
 import javafx.scene.text.Font;
 import javafx.stage.Stage;
 
 public class Calculator extends Application {
 	TextField monitor=new TextField();
 	private int btdott=0;
 	void NumberClick(ActionEvent e)
 	{
 		Button b=(Button)e.getSource();
 		String v=b.getText();
 		monitor.setText(monitor.getText()+v);
 	}
 	void info(Button bt)
 	{
 		bt.setMinHeight(40);
 		bt.setMinWidth(40);
 		bt.setMaxHeight(40);
 		bt.setMaxWidth(40);
 		bt.setPrefSize(40, 40);
 	}
 	public void start(Stage stage)
 	{
 		GridPane pane=new GridPane();
 		
 		
 		monitor.setAlignment(Pos.CENTER_RIGHT);
 		monitor.setMinHeight(30);
 		monitor.setMinWidth(100);
 		monitor.setMaxHeight(60);
 		monitor.setMaxWidth(265);
 		monitor.setMinSize(100, 30);
 		monitor.setMaxSize(265, 60);
 		monitor.setPrefSize(265, 60);
 		monitor.setFont(Font.font(24));
 		monitor.setEditable(false);
 		pane.add(monitor,0,0);
 		
 		GridPane panebt=new GridPane();
 		panebt.setHgap(5);
 		panebt.setVgap(5);
 		
 		Button bt7=new Button("7");
 		info(bt7);
 		panebt.add(bt7, 0, 1);
 		bt7.setOnAction(e->NumberClick(e));
 		
 		Button bt8=new Button("8");
 		info(bt8);
 		panebt.add(bt8, 1, 1);
 		bt8.setOnAction(e->NumberClick(e));
 		
 		Button bt9=new Button("9");
 		info(bt9);
 		panebt.add(bt9, 2, 1);
 		bt9.setOnAction(e->NumberClick(e));
 		
 		Button btdiv=new Button("/");
 		info(btdiv);
 		panebt.add(btdiv, 3, 1);
 		
 		Button btce=new Button("←");
 		info(btce);
 		panebt.add(btce, 4, 1);
 		
 		
 		Button btc=new Button("⌂");
 		info(btc);
 		panebt.add(btc, 5, 1);
 		btc.setOnAction(e->{
 			monitor.clear();
 			btdott=0;
 		});
 		
 		Button bt4=new Button("4");
 		info(bt4);
 		panebt.add(bt4, 0, 2);
 		bt4.setOnAction(e->NumberClick(e));
 		
 		
 		Button bt5=new Button("5");
 		info(bt5);
 		panebt.add(bt5, 1, 2);
 		bt5.setOnAction(e->NumberClick(e));
 		
 		
 		Button bt6=new Button("6");
 		info(bt6);
 		panebt.add(bt6, 2, 2);
 		bt6.setOnAction(e->NumberClick(e));
 		
 		Button btmul=new Button("*");
 		info(btmul);
 		panebt.add(btmul, 3, 2);
 		
 		Button btl=new Button("(");
 		info(btl);
 		panebt.add(btl, 4, 2);
 		
 		Button btr=new Button(")");
 		info(btr);
 		panebt.add(btr, 5, 2);
 		
 		Button bt1=new Button("1");
 		info(bt1);
 		panebt.add(bt1, 0, 3);
 		bt1.setOnAction(e->NumberClick(e));
 		
 		
 		Button bt2=new Button("2");
 		info(bt2);
 		panebt.add(bt2, 1, 3);
 		bt2.setOnAction(e->NumberClick(e));
 		
 		Button bt3=new Button("3");
 		info(bt3);
 		panebt.add(bt3, 2, 3);
 		bt3.setOnAction(e->NumberClick(e));
 		
 		
 		Button btmin=new Button("-");
 		info(btmin);
 		panebt.add(btmin, 3, 3);
 		
 		Button btsquar=new Button("x^2");
 		info(btsquar);
 		panebt.add(btsquar, 4, 3);
 		btsquar.setOnAction(e->{
 			double num=Double.parseDouble(monitor.getText());
 			num=(double)Math.pow(num, 2);
 			String display=""+num;
 			monitor.setText(display);
 		});
 		
 		Button btsqrt=new Button("√");
 		info(btsqrt);
 		panebt.add(btsqrt, 5, 3);
 		btsqrt.setOnAction(e->{
 			double num=Double.parseDouble(monitor.getText());
 			num=(double)Math.sqrt(num);
 			String display=""+num;
 			monitor.setText(display);
 		});
 		
 		Button bt0=new Button("0");
 		info(bt0);
 		panebt.add(bt0, 0, 4);
 		bt0.setOnAction(e->NumberClick(e));
 		
 		
 		Button btdot=new Button(".");
 		info(btdot);
 		panebt.add(btdot, 1, 4);
 		btdot.setOnAction(e->{
 			if(btdott==0)
 			{
 				String num1=btdot.getText();
 				String num2=monitor.getText();
 				String display=num2+num1;
 				monitor.setText(display);
 				btdott=1;
 			}
 		});
 		
 		
 		
 		Button btmod=new Button("%");
 		info(btmod);
 		panebt.add(btmod, 2, 4);
 		btmod.setOnAction(e->{
 			double num=Double.parseDouble(monitor.getText());
 			num/=100;
 			String display=""+num;
 			monitor.setText(display);
 		});
 		
 		Button btplus=new Button("+");
 		info(btplus);
 		panebt.add(btplus, 3, 4);
 		
 		Button bteq=new Button("=");
 		info(bteq);
 		panebt.add(bteq, 4, 4);
		
 		Button btfact=new Button("X!");
 		info(btfact);
 		panebt.add(btfact, 5, 4);
 		btfact.setOnAction(e->{
 			int f=1;
 			int num=Integer.parseInt(monitor.getText());
 			for(int i=num;i>0;i--)
 				f*=i;
 			String display=""+f;
 			f=Integer.parseInt(display);
 			monitor.setText(display);
 		});
 		
 		
 		VBox Vbox=new VBox(pane,panebt);
 		Scene scene=new Scene(Vbox,265,230);
 		stage.setTitle("Casio");
 		stage.setScene(scene);
 		stage.show();
 	}
  
  	public static void main(String[] args) {
 		// TODO Auto-generated method stub
 	  Application.launch(args);
 
  	}
 }
  