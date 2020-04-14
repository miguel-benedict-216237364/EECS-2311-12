package application;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class ControllerCopy {
	
	ArrayList<CustomLabel> labels;
	Circle leftCircle;
	Circle rightCircle;
	TextField leftTitle;
	TextField rightTitle;
	TextField centerTitle;
	boolean addLabelBox = true;
	
	
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
	
	public void setAddLabelBox(boolean b) {
		this.addLabelBox = b;
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
