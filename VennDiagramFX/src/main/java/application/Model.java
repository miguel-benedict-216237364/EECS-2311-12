package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class Model {

	static ArrayList<CustomLabel> getLeftLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		double rightMax = rightCircle.getCenterX() - rightCircle.getRadius();
		double leftMax = leftCircle.getCenterX() - leftCircle.getRadius();
		double topMax = 0;
		double bottomMax = 0;
		if (leftCircle.getRadius() + leftCircle.getCenterY() > rightCircle.getRadius() + rightCircle.getCenterY()) {
			topMax = leftCircle.getRadius() + leftCircle.getCenterY();
			bottomMax = leftCircle.getCenterY() - leftCircle.getRadius();
		} else {
			topMax = rightCircle.getRadius() + rightCircle.getCenterY();
			bottomMax = rightCircle.getCenterY() - rightCircle.getRadius();
		}
		for (int i = 0; i < list.size(); i++) {
			double width = list.get(i).getLABEL().getLayoutX() + (list.get(i).getLABEL().getWidth() / 2);
			double height = list.get(i).getLABEL().getLayoutY() + (list.get(i).getLABEL().getHeight() / 2);

			if (width > leftMax && width < rightMax && height < topMax && height > bottomMax) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<CustomLabel> getRightLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		double rightMax = rightCircle.getCenterX() + rightCircle.getRadius();
		double leftMax = leftCircle.getCenterX() + leftCircle.getRadius();
		double topMax = 0;
		double bottomMax = 0;
		if (leftCircle.getRadius() + leftCircle.getCenterY() > rightCircle.getRadius() + rightCircle.getCenterY()) {
			topMax = leftCircle.getRadius() + leftCircle.getCenterY();
			bottomMax = leftCircle.getCenterY() - leftCircle.getRadius();
		} else {
			topMax = rightCircle.getRadius() + rightCircle.getCenterY();
			bottomMax = rightCircle.getCenterY() - rightCircle.getRadius();
		}
		for (int i = 0; i < list.size(); i++) {
			double width = list.get(i).getLABEL().getLayoutX() + (list.get(i).getLABEL().getWidth() / 2);
			double height = list.get(i).getLABEL().getLayoutY() + (list.get(i).getLABEL().getHeight() / 2);

			if (width > leftMax && width < rightMax && height < topMax && height > bottomMax) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<CustomLabel> getMiddleLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		double rightMax = leftCircle.getCenterX() + leftCircle.getRadius();
		double leftMax = rightCircle.getCenterX() - rightCircle.getRadius();
		double topMax = 0;
		double bottomMax = 0;
		if (leftCircle.getRadius() + leftCircle.getCenterY() > rightCircle.getRadius() + rightCircle.getCenterY()) {
			topMax = leftCircle.getRadius() + leftCircle.getCenterY();
			bottomMax = leftCircle.getCenterY() - leftCircle.getRadius();
		} else {
			topMax = rightCircle.getRadius() + rightCircle.getCenterY();
			bottomMax = rightCircle.getCenterY() - rightCircle.getRadius();
		}
		for (int i = 0; i < list.size(); i++) {
			double width = list.get(i).getLABEL().getLayoutX() + (list.get(i).getLABEL().getWidth() / 2);
			double height = list.get(i).getLABEL().getLayoutY() + (list.get(i).getLABEL().getHeight() / 2);

			if (width > leftMax && width < rightMax && height < topMax && height > bottomMax) {
				result.add(list.get(i));
			}
		}

		return result;
	}
}
