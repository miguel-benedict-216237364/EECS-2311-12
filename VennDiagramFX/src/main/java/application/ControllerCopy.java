package application;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class ControllerCopy {
	
	ArrayList<Label> labels;
	Circle leftCircle;
	Circle rightCircle;
	TextField leftTitle;
	TextField rightTitle;
	TextField centerTitle;
	
	
	public ControllerCopy(ArrayList<Label> l, Circle leftC, Circle rightC, TextField left, TextField right, TextField center) {
		labels = new ArrayList<Label>();
		leftCircle = new Circle();
		rightCircle = new Circle();
		leftTitle = new TextField(left.getText());
		rightTitle = new TextField(right.getText());
		centerTitle = new TextField(center.getText());
		for(int i = 0; i < l.size(); i++) {
			labels.add(l.get(i));			
		}
		leftCircle.setLayoutX(leftC.getLayoutX());
		leftCircle.setLayoutY(leftC.getLayoutY());
		leftCircle.setRadius(leftC.getRadius());
		
		rightCircle.setLayoutX(rightC.getLayoutX());
		rightCircle.setLayoutY(rightC.getLayoutY());
		rightCircle.setRadius(rightC.getRadius());
		
	
	}
	
@Override

public String toString() {
	if(labels.size() == 0) {
		return "No labels yet....";
	}else {
		return labels.get(labels.size()-1).getText();
	}
}
	
	

}
