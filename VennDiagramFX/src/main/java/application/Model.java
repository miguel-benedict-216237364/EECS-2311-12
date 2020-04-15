package application;

import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class Model {

	static ArrayList<CustomLabel> getLeftLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<CustomLabel>  result = new ArrayList<CustomLabel>();
		
		
		for (int i = 0; i < list.size(); i++) {
			Point2D tmp = new Point2D(list.get(i).getLayoutX()+(list.get(i).getWidth()/2),list.get(i).getLayoutY() + (list.get(i).getHeight()/2));
			if (leftCircle.contains(tmp) && (!rightCircle.contains(tmp))) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<CustomLabel> getRightLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		
		
		for (int i = 0; i < list.size(); i++) {
			Point2D tmp = new Point2D(list.get(i).getLayoutX()+(list.get(i).getWidth()/2),list.get(i).getLayoutY() + (list.get(i).getHeight()/2));
			if (rightCircle.contains(tmp) && (!leftCircle.contains(tmp))) {
				result.add(list.get(i));
			}
		}

		return result;
	}

	static ArrayList<CustomLabel> getMiddleLabel(ArrayList<CustomLabel> list, Circle leftCircle, Circle rightCircle) {
		ArrayList<CustomLabel> result = new ArrayList<CustomLabel>();
		for (int i = 0; i < list.size(); i++) {
			Point2D tmp = new Point2D(list.get(i).getLayoutX()+(list.get(i).getWidth()/2),list.get(i).getLayoutY() + (list.get(i).getHeight()/2));
			
			if (rightCircle.contains(tmp) && leftCircle.contains(tmp)) {
				result.add(list.get(i));
			}
		}

		return result;
	}
	
	static ArrayList<Label> toLabelList(ArrayList<CustomLabel> list){
		ArrayList<Label> result = new ArrayList<>();
		for (int i =0;i<list.size();i++) {
			result.add(list.get(i));
		}
		return result;
	}
}
