package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Controller implements Initializable {
	@FXML
	private TextField tfSlider;
	@FXML
	private ComboBox<String> designTabComboBox;
	@FXML
	private TextField mainTitle;
	@FXML
	private TextField leftTitle;
	@FXML
	private TextField rightTitle;
	@FXML
	private AnchorPane Window;
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane centrePane;
	@FXML
	private Slider sizeSlider;
	@FXML
	private Circle leftCircle;
	@FXML
	private Circle rightCircle;
	@FXML
	private Label warningLabel;
	@FXML
	private ColorPicker colourPicker;
	@FXML
	private TabPane Menu;
	@FXML
	private Tab File;
	@FXML
	private Tab Home;
	@FXML
	private Tab Design;
	@FXML
	private Label lblConsole;
	@FXML
	private TextArea TA;
	@FXML
	private ChoiceBox<Double> textSize;
	@FXML
	private ChoiceBox<String> textFont;
	@FXML
	private ChoiceBox<String> textStyle;
	@FXML
	private ColorPicker textColour;
	@FXML
	private TextArea textArea;
	@FXML
	private Button textDelete;
	@FXML
	private Label toDelete;
	@FXML
	private CheckBox isAddLabel;
	@FXML
	private CheckBox isDraggable;

	static double initX;

	static double initY;

	private int counter = 1;

	private Label test = new Label("");

	Font defaultFont = new Font("Times New Roman", 12);

	Double defaultSize = (double) 12;

	Color defaultColour = Color.LIGHTGRAY;

	double defaultOpaq = 0.5;

	static ArrayList<Label> focusList = new ArrayList<Label>();

	static ArrayList<Label> labelList = new ArrayList<Label>();

	static ObservableList<TextField> textFieldTitle = FXCollections
			.observableArrayList(tf -> new Observable[] { tf.textProperty() });

	// static ObservableList<Label> labelListObservable =
	// FXCollections.observableArrayList(labelList);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// DO NOT TOUCH
		// START
//		ArrayList<TextField> labelList = new ArrayList<TextField>();
//		labelList.add(mainTitle);
//		labelList.add(leftTitle);
//		labelList.add(rightTitle);

//		textFieldTitle.addAll(labelList);
//		Model.setDefault(textFieldTitle);
//		textFieldTitle.addListener((ListChangeListener.Change<? extends TextField> c) -> {
//			Model.setDefault(textFieldTitle);
//		});
		// END

		// Set focus on centre pane
		//centrePane.requestFocus();
		lblConsole.setText(Boolean.toString(centrePane.isFocused()));

		// Add all Sizes
		double tmpSize = 4;
		for (int i = 0; i <= 25; i++) {
			textSize.getItems().add(tmpSize);
			tmpSize = tmpSize + 2;
		}
		textSize.setValue(textSize.getItems().get(4));
		textSize.valueProperty().addListener(new ChangeListener<Double>() {
			@Override
			public void changed(ObservableValue<? extends Double> arg0, Double arg1, Double arg2) {
				// TODO Auto-generated method stub
				removeFocus();
			}
		});

		// Add all Fonts
		for (int i = 0; i < Font.getFontNames().size(); i++) {
			textFont.getItems().add(Font.getFontNames().get(i));
		}
		textFont.setValue(textFont.getItems().get(529));
		textFont.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				removeFocus();
			}
		});

		// Add all Styles

		textStyle.getItems().add("Default");
		textStyle.getItems().add("Bold");
		textStyle.getItems().add("Italics");
		textStyle.getItems().add("Underlined");
		textStyle.setValue(textStyle.getItems().get(0));
		textStyle.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				removeFocus();
			}

		});

		// Set text Color to default
		textColour.setValue(Color.BLACK);

		// Tab Menu Add all and set Default
		Menu.getSelectionModel().select(Home);

		// Set sliders to default
		tfSlider.textProperty().bindBidirectional(sizeSlider.valueProperty(), NumberFormat.getNumberInstance());
		colourPicker.setValue(defaultColour);
		rightCircle.setFill(defaultColour);
		leftCircle.setFill(defaultColour);
		rightCircle.setOpacity(defaultOpaq);
		leftCircle.setOpacity(defaultOpaq);

		// Design Tab and events
		ArrayList<String> designTabComboBoxelSectCircle = new ArrayList<String>();
		designTabComboBoxelSectCircle.add("Select All");
		designTabComboBoxelSectCircle.add("Left Circle");
		designTabComboBoxelSectCircle.add("Right Circle");
		ObservableList<String> designTabComboBoxSelectCircleSet = FXCollections
				.observableList(designTabComboBoxelSectCircle);
		designTabComboBox.setValue(designTabComboBoxSelectCircleSet.get(0));
		designTabComboBox.setItems(designTabComboBoxSelectCircleSet);
		designTabComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (designTabComboBox.getValue().equals("Select All")) {
				} else if (designTabComboBox.getValue().equals("Left Circle")) {
					sizeSlider.setValue(leftCircle.getRadius());
					colourPicker.setValue((Color) leftCircle.getFill());
				} else if (designTabComboBox.getValue().equals("Right Circle")) {
					sizeSlider.setValue(rightCircle.getRadius());
					colourPicker.setValue((Color) rightCircle.getFill());
				}
			}
		});

		// Slider
		sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			if (designTabComboBox.getValue().equals("Select All")) {
				sizeSlider.setValue(newValue.intValue());
				leftCircle.setRadius(sizeSlider.getValue());
				rightCircle.setRadius(sizeSlider.getValue());
			} else if (designTabComboBox.getValue().equals("Left Circle")) {
				sizeSlider.setValue(newValue.intValue());
				leftCircle.setRadius(sizeSlider.getValue());
			} else if (designTabComboBox.getValue().equals("Right Circle")) {
				sizeSlider.setValue(newValue.intValue());
				rightCircle.setRadius(sizeSlider.getValue());
			}
		});

		// Circle Colour Picker
		colourPicker.valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				if (designTabComboBox.getValue().equals("Select All")) {
					leftCircle.setFill(colourPicker.getValue());
					rightCircle.setFill(colourPicker.getValue());
				} else if (designTabComboBox.getValue().equals("Left Circle")) {
					leftCircle.setFill(colourPicker.getValue());
				} else if (designTabComboBox.getValue().equals("Right Circle")) {
					rightCircle.setFill(colourPicker.getValue());
				}
			}
		});

		// Delete selected Label
		centrePane.onKeyPressedProperty().set(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyPressed) {
				if (!test.equals(null) && test instanceof Label) {
					if (keyPressed.getCode() == KeyCode.DELETE || keyPressed.getCode() == KeyCode.BACK_SPACE) {
						centrePane.getChildren().remove(test);
						lblConsole.setText(keyPressed.getCode().toString());
						counter--;
					}
				}
			}
		});

		centrePane.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				double x = event.getX();
				double y = event.getY();
				// int i =0;

//			
//				if (labelList.size() > 0) {
//					for (int i =0;i<labelList.size();i++) {
//						if (x < (labelList.get(i).getLayoutX())|| x>(labelList.get(i).getLayoutX()+labelList.get(i).getWidth())) {
//							lblConsole.setText("Valid");
//						}else {
//							lblConsole.setText("Invalid");
//							
//						}
//					}
//					
//				}else {
//					addLabel(event);
//				}
				addLabel(event);
			}

		});

	}

	public void removeFocus() {
		centrePane.requestFocus();
		textArea.textProperty().unbind();
		// testLabel.setText("No Focus");
	}

	public void highlight() {
		for (int i = 0; i < textFieldTitle.size(); i++) {
			if (textFieldTitle.get(i).isFocused() && textFieldTitle.get(i).getText().equals("Insert Title")) {
				textFieldTitle.get(i).selectAll();
			}
		}
	}

	public void addLabel(MouseEvent initEvent) {
		if (isAddLabel.isSelected() && initEvent.isStillSincePress() && centrePane.isFocused()) {

			test = new Label("Insert Text " + counter);
			test.setMaxWidth(100);
			test.setFont(new Font(textFont.getValue(), textSize.getValue()));
			test.setTextFill(textColour.getValue());
			test.setLayoutX(initEvent.getX());
			test.setLayoutY(initEvent.getY());
			centrePane.getChildren().add(test);
			Menu.getSelectionModel().select(Home);
			removeFocus();
			counter++;
			textArea.setText(test.getText());
			toDelete.setText(test.getText().toString());
			labelList.add(test);
			System.out.println(labelList.size());

			// textArea.requestFocus();

			test.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

					test = (Label) event.getSource();
					textArea.textProperty().unbind();
					System.out.println(test.getText());
					Menu.getSelectionModel().select(Home);
					initX = event.getX(); // Initial position of the mouse (x)
					initY = event.getY(); // Initial position of the moouse (y)

					// Add created label to list of all labels
					// Add to focusList
					// focusList.add(test);

					textArea.setText(test.getText());
					toDelete.setText(test.getText().toString());

				}
			});
			test.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseDragged) {
					if (isDraggable.isSelected()) {
						test.setLayoutX(test.getLayoutX() + (mouseDragged.getX() - initX));
						test.setLayoutY(test.getLayoutY() + (mouseDragged.getY() - initY));
						// testLabel.setText("X is: " + event.getX() + "Y is " + event.getY());
					}
				}
			});

			test.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> ov, String t, String t1) {
					System.out.println("Label Text Changed");
				}
			});

		}
	}

	public void textDelete() {
		centrePane.getChildren().remove(test);
	}

}
