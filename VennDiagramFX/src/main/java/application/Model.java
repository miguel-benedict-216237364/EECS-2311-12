package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class Model {

	static ArrayList<Label> getLeftLabel(ArrayList<Label> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<Label> result = new ArrayList<Label>();
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
			double width = list.get(i).getLayoutX() + (list.get(i).getWidth() / 2);
			double height = list.get(i).getLayoutY() + (list.get(i).getHeight() / 2);

			if (width > leftMax && width < rightMax && height < topMax && height > bottomMax) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<Label> getRightLabel(ArrayList<Label> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<Label> result = new ArrayList<Label>();
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
			double width = list.get(i).getLayoutX() + (list.get(i).getWidth() / 2);
			double height = list.get(i).getLayoutY() + (list.get(i).getHeight() / 2);

			if (width > leftMax && width < rightMax && height < topMax && height > bottomMax) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<Label> getMiddleLabel(ArrayList<Label> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<Label> result = new ArrayList<Label>();
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
			double width = list.get(i).getLayoutX() + (list.get(i).getWidth() / 2);
			double height = list.get(i).getLayoutY() + (list.get(i).getHeight() / 2);

			if (width > leftMax && width < rightMax && height < topMax && height > bottomMax) {
				result.add(list.get(i));
			}
		}

		return result;
	}
}
