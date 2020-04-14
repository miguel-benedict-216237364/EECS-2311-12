package application;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class ControllerCopy {
	
	boolean leftCircleChanged; 
	boolean rightCircleChanged;
	boolean customLabelListChanged;
	boolean centerTitleChanged;
	boolean leftTitleChanged;
	boolean rightTitleChanged;
	
	
	ArrayList<CustomLabel> labels;
	Circle leftCircle;
	Circle rightCircle;
	TextField leftTitle;
	TextField rightTitle;
	TextField centerTitle;
	
	
	public ControllerCopy() {
		
	}
	public ControllerCopy(ArrayList<CustomLabel> l, Circle leftC, Circle rightC, TextField left, TextField right, TextField center) {
		labels = new ArrayList<CustomLabel>();
		leftCircle = new Circle();
		rightCircle = new Circle();
		leftTitle = new TextField(left.getText());
		rightTitle = new TextField(right.getText());
		centerTitle = new TextField(center.getText());
		for(int i = 0; i < l.size(); i++) {
			labels.add(l.get(i));			
		}

		leftCircle.setRadius(leftC.getRadius());
		
		rightCircle.setRadius(rightC.getRadius());
		
	
	}
	
	public void makeAllTrue() {
		leftCircleChanged = true; 
		 rightCircleChanged = true; 
		customLabelListChanged = true; 
		 centerTitleChanged = true; 
		 leftTitleChanged = true; 
		 rightTitleChanged = true; 
	}
	public void changeLeftCircle(Circle c) {
		leftCircle = new Circle();
		leftCircle.setRadius(c.getRadius());
		this.leftCircleChanged = true;
	}
	
	public void changeRightCircle(Circle c) {
		rightCircle = new Circle();
		rightCircle.setRadius(c.getRadius());
		this.rightCircleChanged = true;
		
	}
	
@Override

public String toString() {
	if(labels.size() == 0) {
		return "No labels yet....";
	}else {
		return labels.get(labels.size()-1).getLabelText();
	}
}
	
	

}
