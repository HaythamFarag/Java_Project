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
	
	private Boolean ch=false;
	private TextField monitor=new TextField();
	public int btdott=0;
	private int bracketsCounter=0;
	private int number;
	public double num;
	public String num1;
	public String num2;
	private String Op;
	public String display;
	private Infix calculation=new Infix();
	
	//check for operation
		public void check_op()
		{
			String display1 = monitor.getText();
			if(display1.length()>0)
			{
			 if(display1.endsWith("/") || display1.endsWith("*") 
				|| display1.endsWith("+") || display1.endsWith("-")
				|| display1.endsWith("."))
			{
				display1=display1.substring(0, display1.length()-1);
				display1+=Op;
				monitor.setText(display1);
			}
			 else 
			    display1+=Op;
				monitor.setText(display1);
			}
			else if(display1.length()==0)
			{
				monitor.setText("0");
				display1=monitor.getText();
				display1+=Op;
				monitor.setText(display1);
			}
			btdott=0;
		}
		
		//check for monitor
		public void check_monitor()
		{
			if(ch)
			{
				display=monitor.getText();
				if(!display.endsWith("+")&&!display.endsWith("-")
				&&!display.endsWith("*")&&!display.endsWith("/")
				&&!display.endsWith(".")&&display.length()>0)
				{
				monitor.clear();
				ch=false;
				}
			}
		}	
	
	public void btclickedNum(ActionEvent e)
	{
		check_monitor();
		display=monitor.getText();
		if(!display.endsWith(")"))
		{
			num1=((Button)e.getSource()).getText();
			num2=monitor.getText();
			display="";
			display=num2+num1;
			monitor.setText(display);
		}
	}
	
	public void btOpclicked(ActionEvent e)
	{
		String s= monitor.getText();
		Op=((Button)e.getSource()).getText();
		switch(Op)
		{
			case "âŒ‚":	monitor.clear();
					 	btdott=0;
					 	break;
					 
			case "Xآ²":	if(s.length()>0)
						{
							num=Double.parseDouble(monitor.getText());
						  	num=(double)Math.pow(num, 2);
						  	display=""+num;
						  	monitor.setText(display);
						}
						ch=true;
					  	break;
			
			case "âˆڑ":	if(s.length()>0)
						{
							num=Double.parseDouble(monitor.getText());
							num=(double)Math.sqrt(num);
							display=""+num;
							monitor.setText(display);
						}
						ch=true;
						break;
						
			case ".":	if(btdott==0&&!s.endsWith(")"))
						{
							num1=((Button)e.getSource()).getText();
							num2=monitor.getText();
							if(num2.length()==0||num2.endsWith("+")||
									num2.endsWith("-")||num2.endsWith("*")||
									num2.endsWith("/")||num2.endsWith("("))
								num2+="0";
							display=num2+num1;
							monitor.setText(display);
							btdott=1;
						}
						break;
			
			case "%":	if(s.length()>0)
						{
							num=Double.parseDouble(monitor.getText());
							num/=100;
							display=""+num;
							monitor.setText(display);
						}
						ch=true;
						break;
						
			case "X!":	if(s.length()>0)
						{
							int f=1;
							number=Integer.parseInt(monitor.getText());
							for(int i=number;i>0;i--)
								f*=i;
							display=""+f;
							f=Integer.parseInt(display);
							monitor.setText(display);
						}
						ch=true;
						break;
			
			case "â†گ":	if(s.length()>0)
						{
						String removeDigit=s.substring(0,s.length()-1);
						monitor.clear();
						monitor.setText(removeDigit);
						if(s.endsWith("."))
							if(!removeDigit.endsWith("."))
								btdott=0;
						if(s.endsWith(")"))
							if(!removeDigit.endsWith(")"))
								bracketsCounter++;
						if(s.endsWith("("))
							if(!removeDigit.endsWith("("))
								bracketsCounter--;
						}
						break;
			
			case "+":	check_op();
						break;
			
			case "-":	check_op();
						break;
			
			case "*":	check_op();
						break;
			
			case "/":	check_op();
						break;
						
			case "=":	display= monitor.getText();
			if(display.length()>0)
			{
				double result=calculation.infix(display);
				display=""+result;
				monitor.clear();
				monitor.setText(display);
			}
			btdott=1;
			ch=true;
			break;
						
			case "(":	if(s.endsWith("+")||s.endsWith("-")||s.endsWith("*")||
							s.endsWith("/")||s.endsWith("(")||s.length()==0)
						{
							num1=((Button)e.getSource()).getText();
							num2=monitor.getText();
							display=num2+num1;
							monitor.setText(display);
							bracketsCounter++;
						}
						break;
			
			case ")":	if(bracketsCounter>0)
						{
							num1=((Button)e.getSource()).getText();
							num2=monitor.getText();
							display=num2+num1;
							monitor.setText(display);
							bracketsCounter--;
						}
						break;
			
			default:	monitor.setText("Invalid Operation");
						break;
		}
	}
	
	public void btInfo(Button bt)
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
		
		Button bt1=new Button("1");
		btInfo(bt1);
		panebt.add(bt1, 0, 3);
		bt1.setOnAction(e->btclickedNum(e));
		
		Button bt2=new Button("2");
		btInfo(bt2);
		panebt.add(bt2, 1, 3);
		bt2.setOnAction(e->btclickedNum(e));
		
		Button bt3=new Button("3");
		btInfo(bt3);
		panebt.add(bt3, 2, 3);
		bt3.setOnAction(e->btclickedNum(e));
		
		Button bt4=new Button("4");
		btInfo(bt4);
		panebt.add(bt4, 0, 2);
		bt4.setOnAction(e->btclickedNum(e));
		
		Button bt5=new Button("5");
		btInfo(bt5);
		panebt.add(bt5, 1, 2);
		bt5.setOnAction(e->btclickedNum(e));
		
		Button bt6=new Button("6");
		btInfo(bt6);
		panebt.add(bt6, 2, 2);
		bt6.setOnAction(e->btclickedNum(e));
		
		Button bt7=new Button("7");
		btInfo(bt7);
		panebt.add(bt7, 0, 1);
		bt7.setOnAction(e->btclickedNum(e));
		
		Button bt8=new Button("8");
		btInfo(bt8);
		panebt.add(bt8, 1, 1);
		bt8.setOnAction(e->btclickedNum(e));
		
		Button bt9=new Button("9");
		btInfo(bt9);
		panebt.add(bt9, 2, 1);
		bt9.setOnAction(e->btclickedNum(e));
		
		Button bt0=new Button("0");
		btInfo(bt0);
		panebt.add(bt0, 0, 4);
		bt0.setOnAction(e->btclickedNum(e));
		
		
		
		Button btce=new Button("â†گ");
		btInfo(btce);
		panebt.add(btce, 4, 1);
		btce.setOnAction(e->btOpclicked(e));
			
		Button btc=new Button("âŒ‚");
		btInfo(btc);
		panebt.add(btc, 5, 1);
		btc.setOnAction(e->btOpclicked(e));
		
		
		
		Button btdiv=new Button("/");
		btInfo(btdiv);
		panebt.add(btdiv, 3, 1);
		btdiv.setOnAction(e->btOpclicked(e));
		
		Button btmul=new Button("*");
		btInfo(btmul);
		panebt.add(btmul, 3, 2);
		btmul.setOnAction(e->btOpclicked(e));
		
		Button btmin=new Button("-");
		btInfo(btmin);
		panebt.add(btmin, 3, 3);
		btmin.setOnAction(e->btOpclicked(e));
		
		Button btplus=new Button("+");
		btInfo(btplus);
		panebt.add(btplus, 3, 4);
		btplus.setOnAction(e->btOpclicked(e));
		
		Button bteq=new Button("=");
		btInfo(bteq);
		panebt.add(bteq, 4, 4);
		bteq.setOnAction(e->btOpclicked(e));
		
		Button btl=new Button("(");
		btInfo(btl);
		panebt.add(btl, 4, 2);
		btl.setOnAction(e->btOpclicked(e));
		
		Button btr=new Button(")");
		btInfo(btr);
		panebt.add(btr, 5, 2);
		btr.setOnAction(e->btOpclicked(e));
	
		Button btdot=new Button(".");
		btInfo(btdot);
		panebt.add(btdot, 1, 4);
		btdot.setOnAction(e->btOpclicked(e));
		
		Button btsquar=new Button("Xآ²");
		btInfo(btsquar);
		panebt.add(btsquar, 4, 3);
		btsquar.setOnAction(e->btOpclicked(e));
		
		Button btsqrt=new Button("âˆڑ");
		btInfo(btsqrt);
		panebt.add(btsqrt, 5, 3);
		btsqrt.setOnAction(e->btOpclicked(e));
		
		Button btmod=new Button("%");
		btInfo(btmod);
		panebt.add(btmod, 2, 4);
		btmod.setOnAction(e->btOpclicked(e));
		
		Button btfact=new Button("X!");
		btInfo(btfact);
		panebt.add(btfact, 5, 4);
		btfact.setOnAction(e->btOpclicked(e));
		
		
		
		VBox Vbox=new VBox(pane,panebt);
		Scene scene=new Scene(Vbox,265,230);
		stage.setTitle("Casio");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
