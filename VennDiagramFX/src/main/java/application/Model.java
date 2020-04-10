package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class Model {

	static ArrayList<CustomLabel> getLeftLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		
		
		for (int i = 0; i < list.size(); i++) {
			Point2D tmp = new Point2D(list.get(i).getLABEL().getLayoutX()+(list.get(i).getLABEL().getWidth()/2),list.get(i).getLABEL().getLayoutY() + (list.get(i).getLABEL().getHeight()/2));
			if (leftCircle.contains(tmp) && (!rightCircle.contains(tmp))) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<CustomLabel> getRightLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		
		
		for (int i = 0; i < list.size(); i++) {
			Point2D tmp = new Point2D(list.get(i).getLABEL().getLayoutX()+(list.get(i).getLABEL().getWidth()/2),list.get(i).getLABEL().getLayoutY() + (list.get(i).getLABEL().getHeight()/2));
			if (rightCircle.contains(tmp) && (!leftCircle.contains(tmp))) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<CustomLabel> getMiddleLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		for (int i = 0; i < list.size(); i++) {
			Point2D tmp = new Point2D(list.get(i).getLABEL().getLayoutX()+(list.get(i).getLABEL().getWidth()/2),list.get(i).getLABEL().getLayoutY() + (list.get(i).getLABEL().getHeight()/2));
			
			if (rightCircle.contains(tmp) && leftCircle.contains(tmp)) {
				result.add(list.get(i));
			}
		}

		return result;
	}
	
	static ArrayList<Label> toLabelList(ArrayList<CustomLabel> list){
		ArrayList<Label> result = new ArrayList<>();
		for (int i =0;i<list.size();i++) {
			result.add(list.get(i).getLABEL());
		}
		return result;
	}
}
