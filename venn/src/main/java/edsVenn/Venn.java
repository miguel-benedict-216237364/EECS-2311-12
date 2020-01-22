package edsVenn;


	


import java.util.ArrayList;

import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
	import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
	 
	public class Venn extends Application {
	    public static void main(String[] args) {
	        launch(args);
	    }
	    
	public String getString(ArrayList<String> a) {
		String s = "";
		for(int i = 0; i < a.size(); i++) {
			s += a.get(i);
		}
		
		return s;
	}
	    @Override
	    public void start(Stage primaryStage) {
		    ArrayList<String> lefta = new ArrayList<String>();
		    ArrayList<String> botha = new ArrayList<String>();
		    ArrayList<String> righta = new ArrayList<String>();
		    ArrayList<String> master = new ArrayList<String>();

	        primaryStage.setTitle("Venn");
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.TOP_LEFT);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));
	        
	        
	        Label userName = new Label("Item");
	        grid.add(userName, 0, 1);
	        
	        TextField field = new TextField();
	        grid.add(field, 1, 1);
	        
	        Button add = new Button("Add");
	        grid.add(add, 2,1 );
	        
	        final ToggleGroup group = new ToggleGroup();
	      
	        RadioButton lrd = new RadioButton();
	        grid.add(lrd, 4, 1);
	        lrd.setText("Left");
	        lrd.setToggleGroup(group);
	        
	        RadioButton rrd = new RadioButton();
	        grid.add(rrd, 6, 1);
	        rrd.setText("Right");
	        rrd.setToggleGroup(group);
	        
	        RadioButton brd = new RadioButton();
	        grid.add(brd, 8, 1);
	        brd.setText("Both");
	        brd.setToggleGroup(group);
	        
	        Button clear = new Button("Clear");
	        grid.add(clear, 10 ,1 );
	        
	        Text leftText = new Text();
	        grid.add(leftText, 1, 6);
	        
	        Text bothText = new Text();
	        grid.add(bothText, 5, 6);
	        
	        Text rightText = new Text();
	        grid.add(rightText, 9, 6);
	        
	        clear.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	            	lefta.clear();
	            	righta.clear();
	            	botha.clear();
	            	master.clear();
	            	leftText.setText(this.getString(lefta));
	            	rightText.setText(this.getString(righta));
	            	bothText.setText(this.getString(botha));
	                
	            }

				private String getString(ArrayList<String> a) {
					String s = "";
					for(int i = 0; i < a.size(); i++) {
						s += a.get(i);
					}
					
					return s;
				}
	        });
	        
	        

	        
	        add.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	                if(field.getLength() > 0 && lrd.isSelected() && doesntContainString(master,field.getText())) {	                	
	                	lefta.add(field.getText() + "\n");
	                	master.add(field.getText());
	                	field.clear();
	                	leftText.setText(this.getString(lefta));
	                }
	                
	                if(field.getLength() > 0 && rrd.isSelected() && doesntContainString(master,field.getText())) {
	                	righta.add(field.getText() + "\n");
	                	master.add(field.getText());
	                	field.clear();
	                	rightText.setText(this.getString(righta));
	                }
	                
	                if(field.getLength() > 0 && brd.isSelected() && doesntContainString(master,field.getText())) {
	                	botha.add(field.getText() + "\n");
	                	master.add(field.getText());
	                	field.clear();
	                	bothText.setText(this.getString(botha));
	                }
	            }

				private String getString(ArrayList<String> a) {
					String s = "";
					for(int i = 0; i < a.size(); i++) {
						s += a.get(i);
					}
					
					return s;
				}
				
				private Boolean doesntContainString(ArrayList<String> a, String s) {
						Boolean doesntContain = true;
					for(int i = 0; i < a.size(); i ++) {
						if(a.get(i).contentEquals(s)) {
							doesntContain = false;
						}
					}
					
					return doesntContain;
					
				}
	        });
	        
	        Scene scene = new Scene(grid, 800, 600);
	        primaryStage.setScene(scene);
	        
	        
	        primaryStage.show();
	    }
	}


