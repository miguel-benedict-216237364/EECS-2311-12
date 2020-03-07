package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
	@FXML
	private Pane homePane;
	@FXML
	private CheckBox isBold;
	@FXML
	private CheckBox isItalic;

	static boolean isShift = false;

	static double initX;

	static double initY;

	private int counter = 1;

	private Label lblTmp = new Label("");
	

	static Font defaultTextFont = new Font("Times New Roman", 12);
	
	static Font selectedTextFont = defaultTextFont;
	
	static FontPosture defaultTextPosture = FontPosture.REGULAR;
	
	static FontPosture selectedTextPosture = defaultTextPosture;
	
	static FontWeight defaultTextWeight = FontWeight.NORMAL;
	
	static FontWeight selectedTextWeight = defaultTextWeight;

	static Double defaultTextSize = (double) 12;
	
	static double selectedTextSize = defaultTextSize;
	
	static Color defaultTextColour = Color.BLACK;
	
	static Color selectedTextColour = defaultTextColour;
	
	static Color defaultColour = Color.LIGHTGRAY; // This is for the circle

	static double defaultOpaq = 0.5;

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
		textArea.setWrapText(true);  // Set the textArea to be wrapped
		
		// Add all Sizes
		double tmpSize = 4;
		for (int i = 0; i <= 25; i++) {
			textSize.getItems().add(tmpSize);
			tmpSize = tmpSize + 2;
		}
		textSize.setValue(textSize.getItems().get(4));
		textSize.valueProperty().addListener(new ChangeListener<Double>() {
			@Override
			public void changed(ObservableValue<? extends Double> arg0, Double oldV, Double newV) {
				if (newV.equals(0.0)) {
					lblConsole.setText("Multiple sources detected");
				} else {
					lblConsole.setText("One source deetected");
					selectedTextSize = newV;
					for (int i = 0; i < focusList.size(); i++) {
						focusList.get(i).setFont(Font.font(selectedTextFont.getFamily(), selectedTextSize));
					}
				}
				removeFocus();
			}
		});

		// Add all Fonts
		String texttmp = null;
		for (int i = 0; i < Font.getFamilies().size(); i++) {
			textFont.getItems().add(Font.getFamilies().get(i));
			if (Font.getFamilies().get(i).toString().equals("Times New Roman")) { // Set the default to Times New Roman
				texttmp = Font.getFamilies().get(i).toString();
			}
		}
		textFont.setValue(texttmp);
		textFont.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldV, String newV) {
				if (newV.equals("")) {
					lblConsole.setText("Multiple sources detected");
				} else {
					lblConsole.setText("One source deetected");
					selectedTextFont = Font.font(newV, selectedTextSize);
					for (int i = 0; i < focusList.size(); i++) {
						focusList.get(i).setFont(Font.font(newV, selectedTextSize));
					}
				}
				removeFocus();
			}
		});

//		// Add all Styles
//		textStyle.getItems().add("Default");
//		textStyle.getItems().add("Bold");
//		textStyle.getItems().add("Italics");
//		textStyle.setValue(textStyle.getItems().get(0));
//		textStyle.valueProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
//				if (arg2.equals("Bold")) {
//					selectedTextWeight = FontWeight.BOLD;
//				} else if (arg2.equals("Italics")) {
//					selectedTextPosture = FontPosture.ITALIC;
//				} else if (arg2.equals("Default")) {
//					selectedTextWeight = defaultTextWeight;
//					selectedTextPosture = defaultTextPosture;
//				}
//				if (arg2.equals("")) {
//					lblConsole.setText("Multiple sources detected");
//				} else {
//					lblConsole.setText("One source deetected");
//					for (int i = 0; i < focusList.size(); i++) {
//						focusList.get(i).setFont(Font.font(selectedTextFont.getName(), selectedTextWeight,
//								selectedTextPosture, selectedTextSize));
//					}
//				}
//				removeFocus();
//			}
//
//		});

		// Set text Color to default
		textColour.setValue(Color.BLACK);
		textColour.valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				if (newValue.equals(Color.ALICEBLUE)) {
					lblConsole.setText("Multiple sources detected");
				} else {
					lblConsole.setText("One source deetected");
					selectedTextColour = newValue;
					for (int i = 0; i < focusList.size(); i++) {
						focusList.get(i).setTextFill(selectedTextColour);
					}
				}
				removeFocus();
			}
		});

		// Tab Menu Add all and set Default
		// Menu.getSelectionModel().select(Home);

		// Set sliders to default
		tfSlider.textProperty().bindBidirectional(sizeSlider.valueProperty(), NumberFormat.getNumberInstance());
		colourPicker.setValue(defaultColour);
		rightCircle.setFill(defaultColour);
		leftCircle.setFill(defaultColour);
		rightCircle.setOpacity(defaultOpaq);
		leftCircle.setOpacity(defaultOpaq);

		// Design Tab and events	
		designTabComboBox.getItems().add("Select All");
		designTabComboBox.getItems().add("Left Circle");
		designTabComboBox.getItems().add("Right Circle");
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

		sizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
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
				if (keyPressed.getCode() == KeyCode.DELETE || keyPressed.getCode() == KeyCode.BACK_SPACE) {
					for (int i = 0; i < focusList.size(); i++) {
						centrePane.getChildren().remove(focusList.get(i));
						lblConsole.setText(keyPressed.getCode().toString());
						counter--;
					}
					labelList.clear();
					removeFocusToList();
				}

				if (keyPressed.getCode() == KeyCode.SHIFT) {
					isShift = true;
				}
				if (keyPressed.getCode() == KeyCode.ESCAPE) {
					removeFocus();
					removeFocusToList();
				}
			}
		});

		centrePane.onKeyReleasedProperty().set(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyPressed) {
				if (keyPressed.getCode() == KeyCode.SHIFT) {
					isShift = false;
				}
			}
		});

		centrePane.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
//				Point2D pointTmp = new Point2D(event.getX(),event.getY());
//				lblConsole.setText(pointTmp.toString());
//				lblConsole.setText(pointTmp.toString());
//				if ((leftCircle.contains(pointTmp) || rightCircle.contains(pointTmp))) { // Check if the mouse clicked inside the circle
					double x = event.getX();
					double y = event.getY();
					boolean isOnTop = true;
					for (int i = 0; i < labelList.size(); i++) { // Checks if the mouse is on top of another label
						if (((x > (labelList.get(i).getLayoutX() - labelList.get(i).getWidth() / 2)
								&& x < (labelList.get(i).getLayoutX() + labelList.get(i).getWidth()))
								&& y > (labelList.get(i).getLayoutY() - 10)
								&& y < (labelList.get(i).getLayoutY() + labelList.get(i).getHeight()))) {
							isOnTop = false;
						
							break;
						}
					}

					if (isOnTop && isAddLabel.isSelected()&& event.isStillSincePress()) {
						addLabel(event);
					}
				} else {
					removeFocusToList();
				}
			}
		});

		isBold.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		    	for (int i =0;i<focusList.size();i++) {
		    		focusList.get(i).setFont(getFont(isBold,isItalic));
		    	}    removeFocus();
		    }
		
		});
		
		isItalic.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		    	for (int i =0;i<focusList.size();i++) {
		    		focusList.get(i).setFont(getFont(isBold,isItalic));
		    	} removeFocus();
		    }
		});

		textArea.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (textArea.isFocused()) {
						for (int i=0;i<focusList.size();i++) {
					focusList.get(i).setText(newValue);
				}
				}
				
			
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
		if (  centrePane.isFocused()) { // sees of the click happened in the proper pane, which is the centrePane			
			removeBindToList(); 
			lblTmp.textProperty().unbind();
			lblTmp = new Label("Insert Text " + counter); // Sets the text of the label created, counter counts how may labels have been created
			lblTmp.setMaxWidth(150); // Sets the maximum width of the label, which works with the wrapping of the label.
			textArea.setMaxWidth(lblTmp.getMaxWidth()); // Sets the text area maximum width to reflect how the text looks like in the label
			lblTmp.setFont(getFont(isBold,isItalic)); // Sets to the font and size to the current font and size selected 
			lblTmp.setTextFill(selectedTextColour); // Sets the colour with the colour selected 
			lblTmp.setLayoutX(initEvent.getX()); // Position the x direction of the label to be on the x position of the mouse
			lblTmp.setLayoutY(initEvent.getY()); // Position the y direction of the label to be on the y position of the mouse
			centrePane.getChildren().add(lblTmp); // Adds the label create to the centrePane
			Menu.getSelectionModel().select(Home); // Sets the tab to the Home tab
			lblTmp.setWrapText(true); // Allow label to wrap text
			//removeFocus(); // Remove the focus
			counter++; // Adds to the current number of labels
			labelList.add(lblTmp); // adds to the list of all the labels
			textArea.setText(lblTmp.getText()); // Set the text area to display the label's text;
		
		
			if (isShift) { // if shift is enabled, add the label to the focus list
				focusList.add(lblTmp);
			} else { // if shit is disabled, remove the focus list and add the label created.
			
				removeFocusToList();
				focusList.add(lblTmp);
			}
			Platform.runLater(()->textArea.requestFocus());
			addFocusToList(); // display what is currently selected
			lblTmp.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() { // Release of the mouse selects the label
				@Override
				public void handle(MouseEvent event) {
					lblTmp = (Label) event.getSource();		// Select the Label 		
					Menu.getSelectionModel().select(Home); // Set the tab to Home
					textArea.setText(lblTmp.getText()); // Set the text area to the selected Label
//					lblConsole.setText(event.getSource().toString());					
//					initX = event.getX(); // Initial position of the mouse (x)
//					initY = event.getY(); // Initial position of the mouse (y)				
					if (isShift) { // If shift is selected, then add the label pressed to the focus List
						focusList.add(lblTmp);
					}else { // If shit is not selected, then reset the focus List, and add the label pressed to the focus List
						if (!(focusList.size()>1)) { 
								removeFocusToList();
								focusList.add(lblTmp);
						}				
					}
					
//					if (focusList.size()>1) { // Set all text Filters to nothing
//						textSize.setValue(0.0);
//						textFont.setValue("");
//						isBold.setSelected(false);
//						isItalic.setSelected(false);
//						//textStyle.setValue("");
//						textColour.setValue(Color.ALICEBLUE);
//					}else {
//						textSize.setValue(focusList.get(0).getFont().getSize());
//						textFont.setValue(focusList.get(0).getFont().getName());
//						
//						//textStyle.setValue(focusList.get(0).getStyle());
//						textColour.setValue((Color) focusList.get(0).getTextFill());
//					}
					addFocusToList(); // Show that the clicked label is selected
				}
			});

			lblTmp.onMousePressedProperty().set(new EventHandler<MouseEvent>() { // This sets the initial position the mouse was set in, allows for smooth dragging to occur
				@Override
				public void handle(MouseEvent arg0) {
				initX = arg0.getX(); // Initial position of the mouse (x)
				initY = arg0.getY(); // Initial position of the mouse (y)			
				}
			});

			lblTmp.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() { // Moves the Labels on the focus list, within the boundaries of x ( 0 < x < 1080 ) and y ( 0 < y < 720 ). 
				@Override
				public void handle(MouseEvent mouseDragged) {
					if (focusList.contains(mouseDragged.getSource())) {
						if (isDraggable.isSelected()) {
							for (int i = 0; i < focusList.size(); i++) {
								if ((focusList.get(i).getLayoutX() + (mouseDragged.getX() - initX) >= 0)
										&& (focusList.get(i).getLayoutX() + (mouseDragged.getX() - initX) <= 1080
												- focusList.get(i).getWidth())) { // Check that it is within the x boundaries																					
									focusList.get(i)
											.setLayoutX(focusList.get(i).getLayoutX() + (mouseDragged.getX() - initX));
								}
								if ((focusList.get(i).getLayoutY() + (mouseDragged.getY() - initY) >= 0)
										&& (focusList.get(i).getLayoutY() + (mouseDragged.getY() - initY) <= 720
												- focusList.get(i).getHeight())) { // Check that it is within the y boundaries																					
									focusList.get(i)
											.setLayoutY(focusList.get(i).getLayoutY() + (mouseDragged.getY() - initY));
								}
							}
						}
					}
				}
			});
		
			lblTmp.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> ov, String t, String t1) {
					System.out.println("Label Text Changed");
				}
			});

		}
	}

	public void textDelete() {
		centrePane.getChildren().remove(lblTmp);
	}

	static void addFocusToList() {
		for (int i = 0; i < focusList.size(); i++) {
			focusList.get(i).setStyle("-fx-border-style: dashed;");
		}
	}

	static void removeFocusToList() {
		for (int i = 0; i < focusList.size(); i++) {
			focusList.get(i).setStyle(null);
		}
		focusList.clear();

	}

	static void removeBindToList() {
		for (int i = 0; i < focusList.size(); i++) {

			focusList.get(i).textProperty().unbind();
		}

	}
	
	static Font getFont(CheckBox Bold, CheckBox italic) {
		Font result = Font.font(selectedTextFont.getName(), selectedTextWeight, selectedTextPosture, selectedTextSize);
		if (Bold.isSelected()) {
			selectedTextWeight = FontWeight.BOLD;
		}else {
			selectedTextWeight = FontWeight.NORMAL;
		}
		if (italic.isSelected()) {
			selectedTextPosture = FontPosture.ITALIC;
		}else {
			selectedTextPosture = FontPosture.REGULAR;
		}
		 result = Font.font(selectedTextFont.getName(), selectedTextWeight, selectedTextPosture, selectedTextSize);
		 return result;
	}
}
