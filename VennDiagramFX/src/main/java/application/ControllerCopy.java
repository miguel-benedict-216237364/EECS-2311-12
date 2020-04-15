package application;

import java.util.ArrayList;

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

	public ControllerCopy(ArrayList<CustomLabel> l, Circle leftC, Circle rightC, TextField left, TextField right,
			TextField center) {
		labels = new ArrayList<CustomLabel>();
		leftCircle = new Circle();
		rightCircle = new Circle();

		leftTitle = new TextField(left.getText());
		leftTitle.setLayoutX(left.getLayoutX());
		leftTitle.setLayoutY(left.getLayoutY());

		rightTitle = new TextField(right.getText());
		rightTitle.setLayoutX(right.getLayoutX());
		rightTitle.setLayoutY(right.getLayoutY());

		leftCircle.setRadius(leftC.getRadius());
		leftCircle.setLayoutX(leftC.getLayoutX());
		leftCircle.setLayoutY(leftC.getLayoutY());
		leftCircle.setCenterX(leftC.getCenterX());
		leftCircle.setCenterY(leftC.getCenterY());
		leftCircle.setFill(leftC.getFill());

		rightCircle.setRadius(rightC.getRadius());
		rightCircle.setRadius(rightC.getRadius());
		rightCircle.setLayoutX(rightC.getLayoutX());
		rightCircle.setLayoutY(rightC.getLayoutY());
		rightCircle.setCenterX(rightC.getCenterX());
		rightCircle.setCenterY(rightC.getCenterY());
		rightCircle.setFill(rightC.getFill());
		
		
		centerTitle = new TextField(center.getText());
		for (int i = 0; i < l.size(); i++) {
			CustomLabel copyLabel = l.get(i);
			CustomLabel addLabel = new CustomLabel(copyLabel.getText(), copyLabel.getAdditionalText());
			addLabel.setLayoutXY(copyLabel.getLayoutX(),copyLabel.getLayoutY());
			addLabel.setFont(copyLabel.getFont());
			addLabel.setTextFill(copyLabel.getTextFill());
			labels.add(addLabel);
		}

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
		if (labels.size() == 0) {
			return "No labels yet....";
		} else {
			return labels.get(labels.size() - 1).getText();
		}
	}

}
