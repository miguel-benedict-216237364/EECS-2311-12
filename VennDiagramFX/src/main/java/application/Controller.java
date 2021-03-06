package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller implements Initializable {
	@FXML
	private TextField tfSlider;
	@FXML
	private ComboBox<String> designTabComboBox;
	@FXML
	TextField mainTitle;
	@FXML
	TextField leftTitle;
	@FXML
	TextField rightTitle;
	@FXML
	private AnchorPane Window;
	@FXML
	private BorderPane mainPane;
	@FXML
	private Pane centrePane;
	@FXML
	private Slider sizeSlider;
	@FXML
	Circle leftCircle;
	@FXML
	Circle rightCircle;
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
	private TextField textField;
	@FXML
	private Button textDelete;
	@FXML
	private Label toDelete;
	@FXML
	CheckBox isAddLabel;
	@FXML
	private CheckBox isDraggable;
	@FXML
	private Pane homePane;
	@FXML
	private CheckBox isBold;
	@FXML
	private CheckBox isItalic;
	@FXML
	private CheckBox autoFocusText;
	@FXML
	private ChoiceBox<String> labelAlignment;
	@FXML
	private TextArea additionalText;
	@FXML
	private ScrollPane scrollPaneOfLabels;
	@FXML
	private Button exitNormal;
	@FXML
	private ChoiceBox<String> presentationBox;
	@FXML
	private Tab Present;
	@FXML
	private Button exitEvaluation;
	@FXML
	private Tab Evaluation;
	@FXML
	private VBox evaluationBox;
	@FXML
	private Button loadEvaluation;
	@FXML
	private Button removeEvaluation;
	@FXML
	private Label lblEvaluation;
	@FXML
	private TextField tfEvaluation;
	@FXML
	private Label lblLoadedEvaluation;
	@FXML
	private ScrollPane evaluationPane;

	static TabPane savedTabPane;

	static double[] defaultCircleLeftAlignment = { 220, 680, 540 }; // X values for left alignment ( Left, Right, Middle
																	// )

	static double[] defaultCircleRightAlignment = { 410, 870, 540 }; // X values for right alignment ( Left, Right,
																		// Middle )

	static double[] defaultCircleMiddleAlignment = { 320, 750, 540 }; // X values for right alignment ( Left, Right,
																		// Middle )
	static final KeyCombination undo = new KeyCodeCombination(KeyCode.Z, KeyCombination.SHORTCUT_DOWN);

	static double defaultYAlignment = 250;

	static double initX;

	static double initY;

	static String defaultTextFont = "Times New Roman";

	static Double defaultTextSize = (double) 12;

	static Color defaultTextColour = Color.BLACK;

	static String selectedTextFont = defaultTextFont;

	static double selectedTextSize = defaultTextSize;

	static Color selectedTextColour = defaultTextColour;

	static boolean isItalicBoolean = false;

	static boolean isBoldBoolean = false;

	static Color defaultColour = Color.LIGHTGRAY; // This is for the circle

	static double defaultOpaq = 0.5;

	public static ArrayList<CustomLabel> focusList = new ArrayList<CustomLabel>();

	public static ArrayList<CustomLabel> customLabelList = new ArrayList<CustomLabel>(); // List of Labels

	public static ArrayList<CustomLabel> evaluationList = new ArrayList<CustomLabel>();

	static Tooltip labelTooltip = new Tooltip();

	static ArrayList<ControllerCopy> undoStack = new ArrayList<ControllerCopy>();

	static ArrayList<ControllerCopy> redoStack = new ArrayList<ControllerCopy>();

	static ArrayList<TextField> textFieldFocus = new ArrayList<TextField>();

	static CustomLabel customLabel;
	
	static CustomLabel selectedLabel;
	
	static CustomLabel selectedLabelOriginalCopy;

	static String mainTitleText = "Insert Title";

	static String leftTitleText = "Insert Title";

	static String rightTitleText = "Insert Title";

	public static boolean isEvaluationPresentationOn = false;

	public static boolean isDraggableBoolean = true;

	static ObservableList<TextField> textFieldTitle = FXCollections
			.observableArrayList(tf -> new Observable[] { tf.textProperty() });

	int undoPointer = 0;

	int redoPointer = 0;
	
	boolean labelSelected;
	
	int oldSliderValue;
	
	int newSliderValue;
	
	int counter = 1;
	boolean undoWasClicked = false;

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


		disableEvaluation();
		presentationBox.getItems().add("Normal");
		presentationBox.getItems().add("Evaluation");
		presentationBox.setValue("Normal");
		exitNormal.setDisable(true);
		exitNormal.setVisible(false);
		exitEvaluation.setDisable(true);
		exitEvaluation.setVisible(false);
		this.Menu.getTabs().remove(Evaluation);

		mainTitle.setPrefWidth(250); // For some reason on launch, without this code the prefWidth is 0
		leftTitle.setPrefWidth(200);
		rightTitle.setPrefWidth(200);
		mainTitle.setPrefHeight(31);

		Menu.getSelectionModel().select(Home);

		leftTitle.setOpacity(0.5);

		leftTitle.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (leftTitle.getText().equals("Insert Title")) {
					leftTitle.selectAll();
				}
			}
		});

		leftTitle.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				leftTitleText = newValue;
				leftTitle.setOpacity(1.0);

			}
		});

		rightTitle.setOpacity(0.5);

		rightTitle.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (rightTitle.getText().equals("Insert Title")) {
					rightTitle.selectAll();
				}
			}
		});

		rightTitle.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				rightTitleText = newValue;
				rightTitle.setOpacity(1.0);

			}
		});

		mainTitle.setOpacity(0.5);

		mainTitle.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (mainTitle.getText().equals("Insert Title")) {
					mainTitle.selectAll();
				}
			}
		});
		
		
		mainTitle.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				mainTitleText = newValue;
				mainTitle.setOpacity(1.0);

			}
		});
		// Add Possible Alignments
		labelAlignment.getItems().add("Custom");
		labelAlignment.getItems().add("Left Justified");
		labelAlignment.getItems().add("Right Justified");
		labelAlignment.getItems().add("Centred");
		labelAlignment.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (designTabComboBox.getValue().equals("Left Circle")) { // left Circle is selected
					ArrayList<CustomLabel> tmp = Model.getLeftLabel(customLabelList, leftCircle, rightCircle);
					double height = defaultYAlignment;

					if (labelAlignment.getValue().equals("Left Justified")) { // Left Justified
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleLeftAlignment[0]);
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.LEFT);
							tmp.get(i).setLayoutY(height);
						}
					} else if (labelAlignment.getValue().equals("Right Justified")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleRightAlignment[0] - tmp.get(i).getWidth());
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.RIGHT);
							tmp.get(i).setLayoutY(height);
						}

					} else if (labelAlignment.getValue().equals("Centred")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleMiddleAlignment[0] - (tmp.get(i).getWidth() / 2));
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.CENTER);
							tmp.get(i).setLayoutY(height);
						}
					}
					addControllerCopy();
				} else if (designTabComboBox.getValue().equals("Right Circle")) { // Right Circle is selected
					ArrayList<CustomLabel> tmp = Model.getRightLabel(customLabelList, leftCircle, rightCircle);
					double height = defaultYAlignment;

					if (labelAlignment.getValue().equals("Left Justified")) { // Left Justified
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleLeftAlignment[1]);
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.LEFT);
							tmp.get(i).setLayoutY(height);
						}
					} else if (labelAlignment.getValue().equals("Right Justified")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleRightAlignment[1] - tmp.get(i).getWidth());
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.RIGHT);
							tmp.get(i).setLayoutY(height);
						}

					} else if (labelAlignment.getValue().equals("Centred")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleMiddleAlignment[1] - (tmp.get(i).getWidth() / 2));
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.CENTER);
							tmp.get(i).setLayoutY(height);
						}
					}
					addControllerCopy();
				} else if (designTabComboBox.getValue().equals("Select All")) { // Centre Justified

					ArrayList<CustomLabel> tmp = Model.getLeftLabel(customLabelList, leftCircle, rightCircle);
					double height = defaultYAlignment;

					if (labelAlignment.getValue().equals("Left Justified")) { // Left Justified
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleLeftAlignment[0]);
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.LEFT);
							tmp.get(i).setLayoutY(height);
						}
					} else if (labelAlignment.getValue().equals("Right Justified")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleRightAlignment[0] - tmp.get(i).getWidth());
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.RIGHT);
							tmp.get(i).setLayoutY(height);
						}

					} else if (labelAlignment.getValue().equals("Centred")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleMiddleAlignment[0] - (tmp.get(i).getWidth() / 2));
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.CENTER);
							tmp.get(i).setLayoutY(height);
						}
					}

					// Right Circle
					tmp = Model.getRightLabel(customLabelList, leftCircle, rightCircle);

					if (labelAlignment.getValue().equals("Left Justified")) { // Left Justified
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleLeftAlignment[1]);
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.LEFT);
							tmp.get(i).setLayoutY(height);
						}
					} else if (labelAlignment.getValue().equals("Right Justified")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleRightAlignment[1] - tmp.get(i).getWidth());
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.RIGHT);
							tmp.get(i).setLayoutY(height);
						}

					} else if (labelAlignment.getValue().equals("Centred")) {
						for (int i = 0; i < tmp.size(); i++) {
							tmp.get(i).setLayoutX(defaultCircleMiddleAlignment[1] - (tmp.get(i).getWidth() / 2));
							if (i > 0) {
								height = height + tmp.get(i - 1).getHeight() + 10;
							} else {
								height = defaultYAlignment;
							}
							tmp.get(i).setTextAlignment(TextAlignment.CENTER);
							tmp.get(i).setLayoutY(height);
						}
					}
					addControllerCopy();
				}
				ArrayList<CustomLabel> tmp = Model.getMiddleLabel(customLabelList, leftCircle, rightCircle);
				double height = defaultYAlignment;
				for (int i = 0; i < tmp.size(); i++) {
					tmp.get(i).setLayoutX(defaultCircleLeftAlignment[2] - (tmp.get(i).getWidth()) / 2);
					if (i > 0) {
						height = height + tmp.get(i - 1).getHeight() + 10;
					} else {
						height = defaultYAlignment;
					}
					tmp.get(i).setTextAlignment(TextAlignment.CENTER);
					tmp.get(i).setLayoutY(height);
				}
			}

		});
//.
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
				selectedTextSize = newV;
				for (int i = 0; i < focusList.size(); i++) {
					focusList.get(i)
							.setFont(getFont(selectedTextFont, selectedTextSize, isBoldBoolean, isItalicBoolean));
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
				selectedTextFont = newV;
				if (mainTitle.isFocused()) {
					Font tmp = getFont(selectedTextFont, selectedTextSize, isBoldBoolean, isItalicBoolean);
					mainTitle.setFont(tmp);
				}
				if (leftTitle.isFocused()) {
					Font tmp = getFont(selectedTextFont, selectedTextSize, isBoldBoolean, isItalicBoolean);
					leftTitle.setFont(tmp);
				}
				if (rightTitle.isFocused()) {
					Font tmp = getFont(selectedTextFont, selectedTextSize, isBoldBoolean, isItalicBoolean);
					rightTitle.setFont(tmp);
				}
				for (int i = 0; i < focusList.size(); i++) {
					focusList.get(i)
							.setFont(getFont(selectedTextFont, selectedTextSize, isBoldBoolean, isItalicBoolean));
				}
				removeFocus();
			}
		});
		
		// Set text Color to default
		textColour.setValue(Color.BLACK);
		textColour.valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				selectedTextColour = newValue;
				for (int i = 0; i < focusList.size(); i++) {
					focusList.get(i).setTextFill(selectedTextColour);
				}
				if (focusList.size() != 0) {
					
				}

				removeFocus();
			}
		});
		
		isBold.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				isBoldBoolean = isBold.isSelected();
				for (int i = 0; i < focusList.size(); i++) {
					focusList.get(i)
							.setFont(getFont(selectedTextFont, selectedTextSize, isBoldBoolean, isItalicBoolean));
				}
				if (focusList.size() != 0) {
					
				}
				removeFocus();
			}

		});
		
		isItalic.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				isItalicBoolean = isItalic.isSelected();
				for (int i = 0; i < focusList.size(); i++) {
					focusList.get(i)
							.setFont(getFont(selectedTextFont, selectedTextSize, isBoldBoolean, isItalicBoolean));
				}
				if (focusList.size() != 0) {
					
				}
				removeFocus();
			}
		});

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
		designTabComboBox.setValue("Select All");
		designTabComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				if (designTabComboBox.getValue().equals("Select All")) {
				} else if (designTabComboBox.getValue().equals("Left Circle")) {
					sizeSlider.setValue(leftCircle.getRadius());
					// colourPicker.setValue((Color) leftCircle.getFill());
				} else if (designTabComboBox.getValue().equals("Right Circle")) {
					sizeSlider.setValue(rightCircle.getRadius());
					// colourPicker.setValue((Color) rightCircle.getFill());
				}
			}
		});
		
		sizeSlider.setOnMouseClicked((MouseEvent event) -> {
			oldSliderValue = (int) sizeSlider.getValue();
		});
		
		// Event Listener to see when the mouse has been released from the slider
		sizeSlider.setOnMouseReleased((MouseEvent event) -> {
			newSliderValue = (int) sizeSlider.getValue();
			if(oldSliderValue != newSliderValue && oldSliderValue != 0) {
				leftCircle.setCenterX(415);
				rightCircle.setCenterX(665);
				moveTitles();
				addControllerCopy();
			}
		});

		sizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				if (designTabComboBox.getValue().equals("Select All")) {

					sizeSlider.setValue(newValue.intValue());
					leftCircle.setRadius(sizeSlider.getValue());
					rightCircle.setRadius(sizeSlider.getValue());

					double radius = leftCircle.getRadius() / 2;

					rightCircle.setCenterX((centrePane.getWidth() / 2) + radius);
					leftCircle.setCenterX((centrePane.getWidth() / 2) - radius);
					
				} else if (designTabComboBox.getValue().equals("Left Circle")) {
					sizeSlider.setValue(newValue.intValue());
					leftCircle.setRadius(sizeSlider.getValue());

					if (leftCircle.getRadius() > rightCircle.getRadius()) {

						rightCircle.setCenterX(leftCircle.getRadius() + leftCircle.getCenterX());
					}

				} else if (designTabComboBox.getValue().equals("Right Circle")) {
					sizeSlider.setValue(newValue.intValue());
					rightCircle.setRadius(sizeSlider.getValue());
					if (leftCircle.getRadius() < rightCircle.getRadius()) {
						leftCircle.setCenterX(-rightCircle.getRadius() + rightCircle.getCenterX());
					}
				}
				moveTitles();
			}

		});

		// Circle Colour Picker
		colourPicker.valueProperty().addListener(new ChangeListener<Color>() {
			@Override
			public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
				if (designTabComboBox.getValue().equals("Select All")) {
					leftCircle.setFill(colourPicker.getValue());
					rightCircle.setFill(colourPicker.getValue());
					addControllerCopy();
				} else if (designTabComboBox.getValue().equals("Left Circle")) {
					leftCircle.setFill(colourPicker.getValue());
					addControllerCopy();
				} else if (designTabComboBox.getValue().equals("Right Circle")) {
					rightCircle.setFill(colourPicker.getValue());
					addControllerCopy();
				}
			}
		});

		evaluationPane.onKeyPressedProperty().set(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.A && event.isControlDown() && evaluationPane.isFocused()) {
					System.out.println("Pressed");
					removeFocusToList();
					for (int i = 0; i < evaluationList.size(); i++) {
						if (evaluationList.get(i).getParent().equals(evaluationBox)) {
							focusList.add(evaluationList.get(i));
						}
					}
				}
				addFocusToList();
			}
		});

		centrePane.onKeyPressedProperty().set(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyPressed) {

				if (isEvaluationPresentationOn) {
					if (keyPressed.getCode() == KeyCode.A && keyPressed.isControlDown() && centrePane.isFocused()) {
						System.out.println("Pressed");
						removeFocusToList();
						for (int i = 0; i < evaluationList.size(); i++) {
							if (evaluationList.get(i).getParent().equals(centrePane)) {
								focusList.add(evaluationList.get(i));
							}
						}
					}
					addFocusToList();

				} else {
					if (keyPressed.getCode() == KeyCode.A && keyPressed.isControlDown() && centrePane.isFocused()) {
						removeFocusToList();
						for (int i = 0; i < customLabelList.size(); i++) {
							focusList.add(customLabelList.get(i));
						}
						
						addFocusToList();
						setDisableHomeItems(false);
					} else if (keyPressed.getCode() == KeyCode.DELETE) {
						CustomLabel tmp = null;
						
						while (focusList.size() != 0) {
							tmp = focusList.get(focusList.size() - 1);
							for (int i = 0; i < customLabelList.size(); i++) {
								if (tmp.equals(customLabelList.get(i))) {
									centrePane.getChildren().remove(tmp);
									focusList.remove(focusList.size() - 1);
									customLabelList.remove(tmp);
									CustomLabel.counter--;
									addControllerCopy();
								}
							}
						}
						
					}
				}

			}
		});

		centrePane.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue) {
					CustomLabel tmp = null;
					for (int i = 0; i < customLabelList.size(); i++) {
						if (customLabelList.get(i).getText().trim().length() <= 0) {
							tmp = customLabelList.get(i);
							centrePane.getChildren().remove(tmp);
							customLabelList.remove(tmp);
							CustomLabel.counter--;

						}
					}
				}
				removeEmptyValues();
			}

		});

		// Adds a new CustomLable to the centrePane
		centrePane.onMouseReleasedProperty().set(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				
				if (event.getButton().equals(MouseButton.PRIMARY) ) {
					Point2D pointTmp = new Point2D(event.getX(), event.getY());
					if ((leftCircle.contains(pointTmp) || rightCircle.contains(pointTmp))) {
						double x = event.getX();
						double y = event.getY();
						boolean isNotOnTop = true;
						for (int i = 0; i < customLabelList.size(); i++) { // Checks if the mouse is on top of another
																			// label
							if (((x > (customLabelList.get(i).getLayoutX() - customLabelList.get(i).getWidth() / 2)
									&& x < (customLabelList.get(i).getLayoutX() + customLabelList.get(i).getWidth()))
									&& y > (customLabelList.get(i).getLayoutY() - 10)
									&& y < (customLabelList.get(i).getLayoutY()
											+ customLabelList.get(i).getHeight()))) {
								isNotOnTop = false;
								if(labelSelected) {
									if(selectedLabel.getLayoutX() != x && selectedLabel.getLayoutY() != y && !selectedLabel.equals(selectedLabelOriginalCopy)) {
										addControllerCopy();
									}
								}
								
								labelSelected = true;
								selectedLabel = customLabelList.get(i);
								selectedLabelOriginalCopy = selectedLabel.labelCopy();
								break;
							}
						}
						if (isNotOnTop && isAddLabel.isSelected() && event.isStillSincePress()
								&& (leftCircle.contains(pointTmp) || rightCircle.contains(pointTmp)) && event.getClickCount() == 2) {
							removeFocusToList();
							customLabel = new CustomLabel(textField.getText(), additionalText.getText());
							counter++;
							customLabel.setLayoutX(event.getX());
							customLabel.setLayoutY(event.getY());
							customLabelList.add(customLabel);
							centrePane.getChildren().add(customLabel);
							
							setDisableHomeItems(false);
							labelSelected = true;
							selectedLabel = customLabel;
							selectedLabelOriginalCopy = selectedLabel.labelCopy();
							// addLabelUndo
							addControllerCopy();
							setHandlers(customLabel);

							

							if (event.isShiftDown()) {
								focusList.add(customLabel);
							} else {
								focusList.clear();
								focusList.add(customLabel);
							}
							addFocusToList();

							/*if (autoFocusText.isSelected()) {
								Platform.runLater(() -> textField.requestFocus());
							}*/

						}
						if(isNotOnTop && event.getClickCount() == 1 ) { //checking to see if the click was not on a label and if the click count was 1
							setDisableHomeItems(true);		
							if(labelSelected && !selectedLabel.equals(selectedLabelOriginalCopy)) { //checking to see if a lablel was previously selected 
								
								addControllerCopy();
							}
							
							labelSelected = false;
						}	
						
						
						}
					
					
					
					

				} else {
					removeFocusToList();
				}
				if (focusList.size() > 1) {
					textField.setText(focusList.get(focusList.size() - 1).getText());
				} else if (focusList.size() == 1) {
					textField.setText(focusList.get(0).getText());
					additionalText.setText(focusList.get(0).getToolTip().getText());
					//Platform.runLater(() -> textField.requestFocus());
				}
			}

		});
		textField.setDisable(true);
		textField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (textField.isFocused()) {
					for (int i = 0; i < focusList.size(); i++) {
						focusList.get(i).setText(newValue);
					}
				}

			}

		});
		
		
		evaluationPane.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.SECONDARY)) {
					removeFocusToList();
				}

			}

		});
		
		additionalText.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				for (int i = 0; i < focusList.size(); i++) {
					focusList.get(i).getToolTip().setText(newValue);

				}

			}

		});
		
		additionalText.setOnKeyReleased(t -> {
			if (t.getCode() == KeyCode.ENTER) {
	            addControllerCopy();
	            t.consume();
	        }
		});

		centrePane.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

				isDraggable.setLayoutY(centrePane.getHeight() - 20);
				isAddLabel.setLayoutY(isDraggable.getLayoutY() - 20);
				autoFocusText.setLayoutY(isAddLabel.getLayoutY() - 20);
				
				
				CustomLabel.maxHeight = ((Double) newValue);
				exitNormal.setLayoutY(centrePane.getHeight() - 30);
			}

		});

		centrePane.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double offSetX = 0;
				if ((Double) oldValue == 0) {
					offSetX = 0;

				} else {
					offSetX = (Double) newValue - (Double) oldValue;

				}

				// offSetX =(mainTitle.getPrefWidth()/2) + (centrePane.getWidth()/2 - 250)-415;
				offSetX = offSetX / 2;

				mainTitle.setLayoutX(mainTitle.getLayoutX() + offSetX);

				
				leftCircle.setCenterX(leftCircle.getCenterX() + offSetX);
				rightCircle.setCenterX(rightCircle.getCenterX() + offSetX);

				leftTitle.setLayoutX(leftTitle.getLayoutX() + offSetX);
				rightTitle.setLayoutX(rightTitle.getLayoutX() + offSetX);
				
				CustomLabel.maxWidth = ((Double) newValue);
				
				exitNormal.setLayoutX(15);
			}

		});

		isDraggable.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				isDraggableBoolean = newValue;

			}

		});

		presentationBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.equals("Normal")) {
					disableEvaluation();
				} else {
					enableEvaluation();
				}

			}

		});

		// Initializes the undo stack
		undoStack.add(undoPointer,
				new ControllerCopy(customLabelList, leftCircle, rightCircle, leftTitle, rightTitle, mainTitle));
		setDisableHomeItems(true);

	}

//---------------------END OF INITIALIZE-------------------------------

	public void removeFocus() {
		centrePane.requestFocus();

		// testLabel.setText("No Focus");
	}

	public void highlight() {
		for (int i = 0; i < textFieldTitle.size(); i++) {
			if (textFieldTitle.get(i).isFocused() && textFieldTitle.get(i).getText().equals("Insert Title")) {
				textFieldTitle.get(i).selectAll();
			}
		}
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

	static void removeCustomLabel() { // this method removes the custom labels from customLabelList based on the
										// custom labels on the focusList
		for (int i = 0; i < focusList.size(); i++) {
			for (int j = 0; j < customLabelList.size(); j++) {
				if (focusList.get(i).equals(customLabelList.get(j))) {
					customLabelList.remove(customLabelList.get(j));

				}
			}
		}
	}

	public void redo() {
		if (!redoStack.isEmpty()) {
			redoPointer--;
			ControllerCopy copy = redoStack.get(redoPointer);
			undoRedoHelper(copy);
			redoStack.remove(redoPointer);
			undoPointer++;
			undoStack.add(undoPointer,
					new ControllerCopy(customLabelList, leftCircle, rightCircle, leftTitle, rightTitle, mainTitle));
		}
	}

	public void undo() {
		if (undoPointer - 1 >= 0) {
			undoWasClicked = true;

			redoStack.add(redoPointer, undoStack.get(undoPointer));
			redoPointer++;

			undoPointer--;
			ControllerCopy copy = undoStack.get(undoPointer);
			undoRedoHelper(copy);
			undoStack.remove(undoPointer + 1);

		}
	}

	public void undoRedoHelper(ControllerCopy copy) {

		leftCircle.setRadius(copy.leftCircle.getRadius());
		leftCircle.setLayoutX(copy.leftCircle.getLayoutX());
		leftCircle.setLayoutY(copy.leftCircle.getLayoutY());
		leftCircle.setCenterX(copy.leftCircle.getCenterX());
		leftCircle.setCenterY(copy.leftCircle.getCenterY());
		leftCircle.setFill(copy.leftCircle.getFill());

		rightCircle.setRadius(copy.rightCircle.getRadius());
		rightCircle.setLayoutX(copy.rightCircle.getLayoutX());
		rightCircle.setLayoutY(copy.rightCircle.getLayoutY());
		rightCircle.setCenterX(copy.rightCircle.getCenterX());
		rightCircle.setCenterY(copy.rightCircle.getCenterY());
		rightCircle.setFill(copy.rightCircle.getFill());

		leftTitle.setText(copy.leftTitle.getText());
		leftTitle.setLayoutX(copy.leftTitle.getLayoutX());
		leftTitle.setLayoutY(copy.leftTitle.getLayoutY());

		rightTitle.setText(copy.rightTitle.getText());
		rightTitle.setLayoutX(copy.rightTitle.getLayoutX());
		rightTitle.setLayoutY(copy.rightTitle.getLayoutY());
		
		
		for (int i = 0; i < customLabelList.size(); i++) {
			centrePane.getChildren().remove(customLabelList.get(i));
		}
		customLabelList.clear();

		for (int i = 0; i < copy.labels.size(); i++) {
			CustomLabel labelFromCopy = copy.labels.get(i);
			CustomLabel labelToAdd = new CustomLabel(labelFromCopy.getText(), labelFromCopy.getAdditionalText());
			labelToAdd.setLayoutXY(labelFromCopy.getLayoutX(), labelFromCopy.getLayoutY());
			labelToAdd.setFont(labelFromCopy.getFont());
			labelToAdd.setTextFill(labelFromCopy.getTextFill());
			customLabelList.add(labelToAdd);
			this.setHandlers(labelToAdd);
		}
		
		for(int i = 0; i < customLabelList.size(); i++ ) {
			centrePane.getChildren().add(customLabelList.get(i));
			
			
		}
		
		addFocusToList();

	/*	if (autoFocusText.isSelected()) {
			Platform.runLater(() -> textField.requestFocus());
		}*/
		
	}

	public void load() {
		String path = "";
		path = this.loader();
		try {
			this.fileReader(path);
		} catch (IOException e) {
			System.out.println("No File Was Selected Or Wrong File Was Selected");
		}

	}

	private void fileReader(String path) throws IOException {
		// clears the centrePane and then reinitalizes it
		String line = "";// used to copy text from the file
		LineNumberReader lineReader = new LineNumberReader(new FileReader(path));
		
		for (int i = 0; i < customLabelList.size(); i++) {
			centrePane.getChildren().remove(customLabelList.get(i));
		}
		line = lineReader.readLine();
		HardReset();
		line = lineReader.readLine();
		this.mainTitle.setText(line);

		line = lineReader.readLine();
		line = lineReader.readLine();
		this.leftTitle.setText(line);

		line = lineReader.readLine();
		line = lineReader.readLine();
		this.rightTitle.setText(line);

		line = lineReader.readLine();
		line = lineReader.readLine();
		this.leftCircle.setRadius(Double.parseDouble(line));

		line = lineReader.readLine();
		line = lineReader.readLine();
		this.rightCircle.setRadius(Double.parseDouble(line));

		line = lineReader.readLine();

		while (!line.contentEquals("---------- End of Labels ----------")) {
			// double x = (Double.parseDouble(line));
			String labelText = "";
			double x;
			double y;
			double sequence;
			String toolTipText;
			boolean bold;
			boolean Italic;
			String fontName;
			double size;
			String stringColour;
			Color loadedColour;

			if (line.contains("Start of Label")) {
				line = lineReader.readLine();
				line = lineReader.readLine();
				labelText = line;

				line = lineReader.readLine();
				line = lineReader.readLine();
				sequence = (Double.parseDouble(line));

				line = lineReader.readLine();
				line = lineReader.readLine();
				x = (Double.parseDouble(line));

				line = lineReader.readLine();
				line = lineReader.readLine();
				y = (Double.parseDouble(line));

				line = lineReader.readLine();
				line = lineReader.readLine();
				toolTipText = line;

				line = lineReader.readLine();
				line = lineReader.readLine();
				fontName = line;

				line = lineReader.readLine();
				line = lineReader.readLine();
				size = (Double.parseDouble(line));

				line = lineReader.readLine();
				line = lineReader.readLine();
				bold = (Boolean.parseBoolean(line));

				line = lineReader.readLine();
				line = lineReader.readLine();
				Italic = (Boolean.parseBoolean(line));

				line = lineReader.readLine();
				line = lineReader.readLine();
				stringColour = line;
				loadedColour = (Color) Paint.valueOf(stringColour);

				CustomLabel tmp = new CustomLabel(labelText, toolTipText);
				tmp.setLayoutXY(x, y);
				tmp.setSequence((int) sequence);
				tmp.setFont(Controller.getFont(fontName, size, bold, Italic));
				tmp.setTextFill((Color) loadedColour);
				if (this.Menu.getSelectionModel().getSelectedItem().equals(Present)) {
					String strTmp = path.substring(path.lastIndexOf('\\') + 1);
					this.tfEvaluation.setText(strTmp);

				} else {
					centrePane.getChildren().add(tmp);
				}
				customLabelList.add(tmp);
			}
			line = lineReader.readLine();

		}
		System.out.println("Loaded");
		System.out.println(customLabelList.size());
		lineReader.close();
	}

//
	private String loader() {
		final FileChooser filechooser = new FileChooser();
		Stage stage = (Stage) Window.getScene().getWindow();
		File file = filechooser.showOpenDialog(stage);
		String path = "";
		if (file != null) {
			path = file.getAbsolutePath();
		}

		return path;
	}

	public void save() throws FileNotFoundException {

		Save save = new Save();
		FileChooser fileChooser = new FileChooser();
		Stage stage = (Stage) Window.getScene().getWindow();
		// Set extension filter for text files
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(stage);

		if (file != null) {
			save.save(this, file, this.leftCircle.getRadius(), this.rightCircle.getRadius());
		}

	}

	public String getLeftTitle() {
		return this.leftTitle.getText();

	}

	public String getRightTitle() {
		return this.rightTitle.getText();
	}

	public String getMainTitle() {
		return this.mainTitle.getText();
	}

	public void setLeftTitle(String s) {
		this.leftTitle.setText(s);
	}

	public void setRightTitle(String s) {
		this.rightTitle.setText(s);
	}

	public void setCenterTitle(String s) {
		this.mainTitle.setText(s);
	}

	public void moveCircles() {

	}

	public void moveTitles() {
		 leftTitle.setLayoutY(leftCircle.getCenterY()-leftCircle.getRadius() + 15);
	        rightTitle.setLayoutY(rightCircle.getCenterY()-rightCircle.getRadius()+ 15);

	        leftTitle.setLayoutX(leftCircle.getCenterX() - (leftTitle.getPrefWidth()/2)-15);
	        rightTitle.setLayoutX(rightCircle.getCenterX() - (rightTitle.getPrefWidth()/2)+15);

	        double size = leftCircle.getRadius()/15.625;

	        leftTitle.setFont(Font.font(leftTitle.getFont().getFamily(), size));
	        size = rightCircle.getRadius()/15.625;
	        rightTitle.setFont(Font.font(rightTitle.getFont().getFamily(), size));
	       
	}

	public void moveLabels(Double offSetX) {

		for (int i = 0; i < customLabelList.size(); i++) {
			customLabelList.get(i).setLayoutX(customLabelList.get(i).getLayoutX() + offSetX);
		}
	}

	public static Font getFont(String family, double size, boolean isBold, boolean isItalic) {
		Font result;
		if (isItalic && isBold) {
			result = (Font.font(family, FontWeight.BOLD, FontPosture.ITALIC, size));
		} else if (isItalic && !isBold) {
			result = (Font.font(family, FontWeight.NORMAL, FontPosture.ITALIC, size));
		} else if (!isItalic && isBold) {
			result = (Font.font(family, FontWeight.BOLD, FontPosture.REGULAR, size));
		} else {
			result = (Font.font(family, FontWeight.NORMAL, FontPosture.REGULAR, size));
		}
		return result;
	}

	public void HardReset() {

		while (customLabelList.size() != 0) {
			this.centrePane.getChildren().remove(customLabelList.get(0));
			customLabelList.remove(0);
		}

		while (evaluationList.size() != 0) {
			this.centrePane.getChildren().remove(evaluationList.get(0));
			evaluationList.remove(0);
		}
		undoPointer = 0;
		focusList.clear();
		this.mainTitle.setText("Insert Title");
		this.mainTitle.setOpacity(0.5);
		this.leftTitle.setText("Insert Title");
		this.leftTitle.setOpacity(0.5);
		this.rightTitle.setText("Insert Title");
		this.rightTitle.setOpacity(0.5);
		this.textField.setPromptText("Text Title");
		this.additionalText.setPromptText("Additional Information can be added here");
		selectedTextSize = defaultTextSize;
		selectedTextFont = defaultTextFont;
		selectedTextColour = defaultTextColour;
		this.isItalic.setSelected(false);
		this.isBold.setSelected(false);
		this.textColour.setValue(Color.BLACK);
		this.autoFocusText.setSelected(true);
		this.isAddLabel.setSelected(true);
		this.isDraggable.setSelected(true);
		this.leftCircle.setFill(defaultColour);
		this.rightCircle.setFill(defaultColour);
		this.leftCircle.setRadius(250);
		this.rightCircle.setRadius(250);
		this.leftCircle.setCenterX(415);
		this.leftCircle.setCenterY(350);
		this.rightCircle.setCenterX(665);
		this.rightCircle.setCenterY(350);
		this.labelAlignment.setValue("");
		this.colourPicker.setValue(defaultColour);
		this.designTabComboBox.setValue("Select All");
		this.sizeSlider.setValue(250);
		this.tfEvaluation.setText("");

		// this.presentationBox.setValue("Normal");
		// this.Menu.getSelectionModel().select(Home);

	}

	public void removeEmptyValues() {

		if (mainTitle.getText().trim().length() == 0) {
			mainTitle.setText("Insert Title");
			mainTitle.setOpacity(0.5);
		}
		if (leftTitle.getText().trim().length() == 0) {
			leftTitle.setText("Insert Title");
			leftTitle.setOpacity(0.5);
		}
		if (rightTitle.getText().trim().length() == 0) {
			rightTitle.setText("Insert Title");
			rightTitle.setOpacity(0.5);
		}

		for (int i = 0; i < customLabelList.size(); i++) {
			if (customLabelList.get(i).getText().trim().length() == 0) {
				this.centrePane.getChildren().remove(customLabelList.get(i));
				customLabelList.remove(i);
			}
		}
	}

	public void resetDesign() {
		this.leftCircle.setRadius(250);
		this.rightCircle.setRadius(250);
		this.colourPicker.setValue(Controller.defaultColour);
		this.labelAlignment.setValue("");
		this.designTabComboBox.setValue("Select All");
	}

	public void presentNormal() {

		removeTabs();
		removeCheckBoxes();
		this.mainPane.setLeft(null);
		this.exitNormal.setVisible(true);
		this.exitNormal.setDisable(false);

		this.isAddLabel.setSelected(false);
		this.isDraggable.setSelected(false);
		this.autoFocusText.setSelected(false);
		
		presentEvaluation();

	}

	public void backNormal() {

		addTabs();
		addCheckBoxes();
		this.exitNormal.setVisible(false);
		this.exitNormal.setDisable(true);
		this.mainPane.setLeft(this.Menu);

		this.isAddLabel.setSelected(true);
		this.isDraggable.setSelected(true);
		this.autoFocusText.setSelected(true);
	}

	public void presentEvaluation() {

		removeTabs();
		removeCheckBoxes();

		this.Menu.getTabs().add(this.Evaluation);
		isEvaluationPresentationOn = true;
		this.exitEvaluation.setDisable(false);
		this.exitEvaluation.setVisible(true);
		this.autoFocusText.setSelected(false);
		this.isAddLabel.setSelected(false);
		System.out.println(customLabelList.size());
		for (int i = 0; i < customLabelList.size(); i++) {
			CustomLabel tmp = new CustomLabel(customLabelList.get(i));
			evaluationList.add(tmp);
			tmp.setLayoutX(0.0);
			tmp.setLayoutY(0.0);
			this.evaluationBox.getChildren().add(tmp);
			System.out.println("It Reaches");
			System.out.println(tmp.getParent().toString());
		}

	}

	public void backEvaluation() {

		addTabs();
		addCheckBoxes();
		this.exitEvaluation.setDisable(true);
		this.exitEvaluation.setVisible(false);
		this.Menu.getTabs().remove(this.Evaluation);
		this.mainPane.setLeft(this.Menu);
		isEvaluationPresentationOn = false;
		this.evaluationBox.getChildren().clear();

		this.autoFocusText.setSelected(true);
		this.isAddLabel.setSelected(true);

		for (int i = 0; i < evaluationList.size(); i++) {
			if (this.centrePane.getChildren().contains(evaluationList.get(i))) {
				this.centrePane.getChildren().remove(evaluationList.get(i));
			}
		}

		for (int i = 0; i < customLabelList.size(); i++) {
			this.centrePane.getChildren().remove(customLabelList.get(i));
		}
		evaluationList.clear();
		customLabelList.clear();
		this.evaluationBox.getChildren().clear();
	}

	public void present() {

		if (this.presentationBox.getValue().equals("Normal")) {
			this.presentNormal();
		} else if (this.presentationBox.getValue().equals("Evaluation")) {
			this.presentEvaluation();
		}

	}

	public void removeTabs() {
		this.Menu.getTabs().remove(this.Home);
		this.Menu.getTabs().remove(this.File);
		this.Menu.getTabs().remove(this.Design);
		this.Menu.getTabs().remove(this.Present);
	}

	public void addTabs() {

		this.Menu.getTabs().add(0, this.File);
		this.Menu.getTabs().add(1, this.Home);
		this.Menu.getTabs().add(2, this.Design);
		this.Menu.getTabs().add(3, this.Present);

		this.Menu.getSelectionModel().select(this.Present);
	}

	public void removeCheckBoxes() {

		this.autoFocusText.setDisable(true);
		this.isDraggable.setDisable(true);
		this.isAddLabel.setDisable(true);
		this.autoFocusText.setVisible(false);
		this.isDraggable.setVisible(false);
		this.isAddLabel.setVisible(false);
	}

	public void addCheckBoxes() {
		this.autoFocusText.setDisable(false);
		this.isDraggable.setDisable(false);
		this.isAddLabel.setDisable(false);
		this.autoFocusText.setVisible(true);
		this.isDraggable.setVisible(true);
		this.isAddLabel.setVisible(true);
	}

	public void toCentrePane() {
		for (int i = 0; i < focusList.size(); i++) {
			this.centrePane.getChildren().add(focusList.get(i));
			this.evaluationBox.getChildren().remove(focusList.get(i));
		}

	}

	public void toEvaluationBox() {
		for (int i = 0; i < focusList.size(); i++) {
			focusList.get(i).setOpacity(1.0);
			this.centrePane.getChildren().remove(focusList.get(i));
			this.evaluationBox.getChildren().add(focusList.get(i));

		}
	}

	public void disableEvaluation() {

		this.lblEvaluation.setDisable(true);
		this.lblLoadedEvaluation.setDisable(true);
		this.loadEvaluation.setDisable(true);
		//this.removeEvaluation.setDisable(true);
		this.tfEvaluation.setDisable(true);

	}

	public void enableEvaluation() {
		this.lblEvaluation.setDisable(false);
		this.lblLoadedEvaluation.setDisable(false);
		this.loadEvaluation.setDisable(false);
		//this.removeEvaluation.setDisable(false);
		this.tfEvaluation.setDisable(false);
	}

	public void check() {

		ArrayList<CustomLabel> leftCorrectList = (Model.getLeftLabel(customLabelList, leftCircle, rightCircle));
		ArrayList<CustomLabel> leftList = (Model.getLeftLabel(evaluationList, leftCircle, rightCircle));

		ArrayList<CustomLabel> middleCorrectList = (Model.getMiddleLabel(customLabelList, leftCircle, rightCircle));
		ArrayList<CustomLabel> middleList = (Model.getMiddleLabel(evaluationList, leftCircle, rightCircle));

		ArrayList<CustomLabel> rightCorrectList = (Model.getRightLabel(customLabelList, leftCircle, rightCircle));
		ArrayList<CustomLabel> rightList = (Model.getRightLabel(evaluationList, leftCircle, rightCircle));

		for (int i = 0; i < leftList.size(); i++) {
			for (int j = 0; j < leftCorrectList.size(); j++) {
				if (!CustomLabel.compareCustomLabel(leftList.get(i), leftCorrectList.get(j))) {
					leftList.get(i).setOpacity(0.5);
					break;
				} else {
					leftList.get(i).setOpacity(1.0);
				}
			}
		}

		for (int i = 0; i < middleList.size(); i++) {
			for (int j = 0; j < middleCorrectList.size(); j++) {
				if (!CustomLabel.compareCustomLabel(middleList.get(i), middleCorrectList.get(j))) {
					middleList.get(i).setOpacity(0.5);
					break;
				} else {
					middleList.get(i).setOpacity(1.0);
				}
			}
		}

		for (int i = 0; i < rightList.size(); i++) {
			for (int j = 0; j < rightCorrectList.size(); j++) {
				if (!CustomLabel.compareCustomLabel(rightList.get(i), rightCorrectList.get(j))) {
					rightList.get(i).setOpacity(0.5);
					break;
				} else {
					rightList.get(i).setOpacity(1.0);
				}
			}
		}

	}

	public void addControllerCopy() {
		undoPointer++;
		undoStack.add(undoPointer,
				new ControllerCopy(customLabelList, leftCircle, rightCircle, leftTitle, rightTitle, mainTitle));
		System.out.println("added");
		redoStack.clear();
		redoPointer = 0;
	}

	public static CustomLabel findCustomLabel(Label label, ArrayList<CustomLabel> fromList) {
		CustomLabel result = null;
		for (int i = 0; i < fromList.size(); i++) {
			if (fromList.get(i).equals(label)) {
				result = fromList.get(i);

			}
		}
		return result;
	}
	
	//Sets the handlers for new labels being made.
	public void setHandlers(CustomLabel c) {
		c.onMousePressedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				initX = event.getX(); // Initial position of the mouse (x)
				initY = event.getY(); // Initial position of the mouse (y)
			}

		});

		
		
		c.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				final Label lblTmp = (Label) event.getSource(); // Select the Label
				if (event.isShiftDown()) { // If shift is selected, then add the label pressed to
											// the focus List
					focusList.add(findCustomLabel(lblTmp, customLabelList));
				} else { // If shit is not selected, then reset the focus List, and add the label
							// pressed
							// to the focus List
					if (!(focusList.size() > 1)) {
						Controller.removeFocusToList();
						focusList.add(findCustomLabel(lblTmp, customLabelList));
					}
				}
				addFocusToList(); // Show that the clicked label is selected

				if (initX != event.getX() && initY != event.getY()) { // checks if the label has
																		// been moved from it's
					
						// original spot
					addControllerCopy();

				}
			}
		});
		
	}
	
	//enables or disables items on the home tab
	public void setDisableHomeItems(boolean b) {
		textSize.setDisable(b);
		textFont.setDisable(b);
		textField.setDisable(b);
		additionalText.setDisable(b);
		textColour.setDisable(b);
		isBold.setDisable(b);
		isItalic.setDisable(b);
	}	
	
	public void aboutbox() {
		 final Stage dialog = new Stage();
         dialog.initModality(Modality.APPLICATION_MODAL);
         //dialog.initOwner(primaryStage);
         VBox dialogVbox = new VBox(20);
         Label l = new Label();
         l.setText("Prabhjyot Grewal 216195547" +"\n"+"Benedict Miguel 216237364" + "\n" + "Edward Shirinian 214456818");
         dialog.setTitle("About Us");
         dialogVbox.getChildren().add(l);
         Scene dialogScene = new Scene(dialogVbox, 300, 200);
         l.setWrapText(true);
         dialog.setScene(dialogScene);
         dialog.show();
	}
	
	
	
}
