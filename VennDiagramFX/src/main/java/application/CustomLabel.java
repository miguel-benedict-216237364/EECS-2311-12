package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class CustomLabel {

	private Label LABEL; 
	private Tooltip toolTip;
	private int sequence = 0;

	
	public static int counter = 0;
	public static Label lblTmp = new Label();
	public static ArrayList<CustomLabel> focusList = Controller.focusList;
	public static ArrayList<CustomLabel> customLabelList = Controller.customLabelList;
	public static ArrayList<CustomLabel> evaluationList = Controller.evaluationList;
	public static double initX = 0;
	public static double initY = 0;
	public	static  double maxWidth=0;
	public static double maxHeight=0;
	


	CustomLabel(String text, String additionalText) {
	
		counter++;
		sequence++;
		this.sequence= counter; // Set Default Text
		Font font = Controller.getFont(Controller.selectedTextFont, Controller.selectedTextSize, Controller.isBoldBoolean, Controller.isItalicBoolean);
		this.LABEL = new Label(); // Create new object Label		
		this.LABEL.setFont(font);
		this.LABEL.setTextFill(Controller.selectedTextColour);
		if (text.trim().length()<=0) {
			this.LABEL.setText("Insert Text " );
		}else {
			this.LABEL.setText(text);
		}
		
		this.LABEL.setVisible(true);
		this.LABEL.setDisable(false);
		this.LABEL.setMaxWidth(150);
		this.LABEL.setWrapText(true);


		this.toolTip = new Tooltip(); // Create new Tooltip Label
		// Set the default properties for the panel
		Tooltip.install(LABEL, this.toolTip);
		if (additionalText.trim().length()<=0) {
			this.toolTip.setText("Additional Information can be added here");
		}else {
			this.toolTip.setText(additionalText);
		}
	
		this.toolTip.setShowDelay(Duration.millis(250));
		this.toolTip.setFont(Font.font("Times New Roman", 12));
		this.toolTip.setWrapText(true);
		this.toolTip.setMaxWidth(150);
		
		customLabelList.add(this);
		
		
		this.LABEL.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				final Label lblTmp = (Label) event.getSource(); // Select the Label
				if (event.isShiftDown()) { // If shift is selected, then add the label pressed to the focus List				
					focusList.add(findCustomLabel(lblTmp,customLabelList));
				} else { // If shit is not selected, then reset the focus List, and add the label pressed
							// to the focus List
					if (!(focusList.size() > 1)) {
						Controller.removeFocusToList();
						focusList.add(findCustomLabel(lblTmp,customLabelList));
					}
				}
				Controller.addFocusToList(); // Show that the clicked label is selected
				
			}
		});
				
		this.LABEL.onMousePressedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				 initX = event.getX(); // Initial position of the mouse (x)
				 initY = event.getY(); // Initial position of the mouse (y)

			}

		});

		this.LABEL.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {		
				final Label lblTmp = (Label) event.getSource(); // Select the Label 
					if (Controller.isDraggableBoolean  && focusList.contains(CustomLabel.findCustomLabel(lblTmp, customLabelList))) {
						for (int i = 0; i < focusList.size(); i++) {
							if ((focusList.get(i).getLABEL().getLayoutX() + (event.getX() - initX) >= 0)
									&& (focusList.get(i).getLABEL().getLayoutX() + (event.getX() - initX) <= maxWidth
											- focusList.get(i).getLABEL().getWidth())) { // Check that it is within the x
																				// boundaries
								focusList.get(i).getLABEL()
										.setLayoutX(focusList.get(i).getLABEL().getLayoutX() + (event.getX() - initX));
							}
							if ((focusList.get(i).getLABEL().getLayoutY() + (event.getY() - initY) >= 0)
									&& (focusList.get(i).getLABEL().getLayoutY() + (event.getY() - initY) <= maxHeight
											- focusList.get(i).getLABEL().getHeight())) { // Check that it is within the y
																				// boundaries
								focusList.get(i).getLABEL()
										.setLayoutY(focusList.get(i).getLABEL().getLayoutY() + (event.getY() - initY));
							}
						}
					}
			}
		});

		
	}

	CustomLabel(String text, String additionalText, Double x, Double y) {
		
		counter++;
		sequence++;
		this.sequence= counter; // Set Default Text
		Font font = Controller.getFont(Controller.selectedTextFont, Controller.selectedTextSize, Controller.isBoldBoolean, Controller.isItalicBoolean);
		this.LABEL = new Label(); // Create new object Label		
		this.LABEL.setFont(font);
		this.LABEL.setLayoutX(x);
		this.LABEL.setLayoutY(y);
		this.LABEL.setTextFill(Controller.selectedTextColour);
		if (text.trim().length()<=0) {
			this.LABEL.setText("Insert Text " );
		}else {
			this.LABEL.setText(text);
		}
		
		this.LABEL.setVisible(true);
		this.LABEL.setDisable(false);
		this.LABEL.setMaxWidth(150);
		this.LABEL.setWrapText(true);


		this.toolTip = new Tooltip(); // Create new Tooltip Label
		// Set the default properties for the panel
		Tooltip.install(LABEL, this.toolTip);
		if (additionalText.trim().length()<=0) {
			this.toolTip.setText("Additional Information can be added here");
		}else {
			this.toolTip.setText(additionalText);
		}
	
		this.toolTip.setShowDelay(Duration.millis(250));
		this.toolTip.setFont(Font.font("Times New Roman", 12));
		this.toolTip.setWrapText(true);
		this.toolTip.setMaxWidth(150);		
	}
	

	
	CustomLabel(CustomLabel customLabel){ // Used for the purposes of the creating a new CustomLabel for evaluation mode
		this.sequence= customLabel.getSequence(); // Set Default Text
		Font font =customLabel.LABEL.getFont();
		this.LABEL = new Label(); // Create new object Label		
		this.LABEL.setFont(font);
		this.LABEL.setTextFill(customLabel.getLABEL().getTextFill());
		this.LABEL.setText(customLabel.getLabelText());
		this.LABEL.setLayoutX(0.0);
		this.LABEL.setLayoutY(0.0);
		
		this.LABEL.setVisible(true);
		this.LABEL.setDisable(false);
		this.LABEL.setMaxWidth(150);
		this.LABEL.setWrapText(true);


		this.toolTip = new Tooltip(); // Create new Tooltip Label
		// Set the default properties for the panel
		Tooltip.install(LABEL, this.toolTip);
	
			this.toolTip.setText(customLabel.getToolTip().getText());
		
	
		this.toolTip.setShowDelay(Duration.millis(250));
		this.toolTip.setFont(Font.font("Times New Roman", 12));
		this.toolTip.setWrapText(true);
		this.toolTip.setMaxWidth(150);

		//evaluationList.add(customLabel);
	
	
		
		this.LABEL.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				final Label lblTmp = (Label) event.getSource(); // Select the Label
				if (event.isShiftDown()) { // If shift is selected, then add the label pressed to the focus List
				
					
					focusList.add(findCustomLabel(lblTmp,evaluationList));
					
				} else { // If shit is not selected, then reset the focus List, and add the label pressed
							// to the focus List
					if (!(focusList.size() > 1)) {
						Controller.removeFocusToList();
						focusList.add(findCustomLabel(lblTmp,evaluationList));
					}
				}
				Controller.addFocusToList(); // Show that the clicked label is selected
			}
		});

		this.LABEL.onMousePressedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				 initX = event.getX(); // Initial position of the mouse (x)
				 initY = event.getY(); // Initial position of the mouse (y)

			}

		});

		this.LABEL.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				final Label lblTmp = (Label) event.getSource(); // Select the Label 
					if (Controller.isDraggableBoolean  && focusList.contains(CustomLabel.findCustomLabel(lblTmp, evaluationList))) {
						for (int i = 0; i < focusList.size(); i++) {
							if ((focusList.get(i).getLABEL().getLayoutX() + (event.getX() - initX) >= 0)
									&& (focusList.get(i).getLABEL().getLayoutX() + (event.getX() - initX) <= maxWidth
											- focusList.get(i).getLABEL().getWidth())) { // Check that it is within the x
																				// boundaries
								focusList.get(i).getLABEL()
										.setLayoutX(focusList.get(i).getLABEL().getLayoutX() + (event.getX() - initX));
							}
							if ((focusList.get(i).getLABEL().getLayoutY() + (event.getY() - initY) >= 0)
									&& (focusList.get(i).getLABEL().getLayoutY() + (event.getY() - initY) <= maxHeight
											- focusList.get(i).getLABEL().getHeight())) { // Check that it is within the y
																				// boundaries
								focusList.get(i).getLABEL()
										.setLayoutY(focusList.get(i).getLABEL().getLayoutY() + (event.getY() - initY));
							}
						}
					}
			}
		});

		
	}
	
	
	
	public Label getLABEL() {
		return this.LABEL;
	}

	public void setLABEL(Label lABEL) {
		LABEL = lABEL;
	}

	public Tooltip getToolTip() {
		return toolTip;
	}

	public void setToolTip(Tooltip toolTip) {
		this.toolTip = toolTip;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int in) {
		this.sequence = in;
	}

	public String getLabelText() {
		return this.getLABEL().getText();
	}

	public void setLabelText(String mAIN_TEXT) {
		this.getLABEL().setText(mAIN_TEXT);
	}

	public String getADDITIONAL_TEXT() {
		return this.getToolTip().getText();
	}

	public void setADDITIONAL_TEXT(String aDDITIONAL_TEXT) {
		this.getToolTip().setText(aDDITIONAL_TEXT);;
	}

	public void setLayoutXY(double x, double y) {
		this.getLABEL().setLayoutX(x);
		this.getLABEL().setLayoutY(y);
	}
	public static void setMaxWidth(double value) {
		maxWidth = value;
	}
	
	public static void setMaxHeight(double value) {
		maxHeight = value;
	}
	
	
	public static CustomLabel findCustomLabel(Label label,ArrayList<CustomLabel> fromList) {
		CustomLabel result = null;
		for (int i =0;i<fromList.size();i++) {
			if (fromList.get(i).getLABEL().equals(label)) {
				result = fromList.get(i);
				break;
			}
		}
		return result;
	}
	
	public static boolean compareCustomLabel(CustomLabel labelx, CustomLabel labely) {
		System.out.println("Comparison between " + labelx.getLabelText() + " and " + labely.getLabelText());
		boolean result= true;
		if (!labelx.getLabelText().equals(labely.getLabelText())) {
			System.out.println("Text is false");
			return false;
		}
		if (!(labelx.getSequence()==labely.getSequence())) {
			System.out.println("Sequence is false");
			return false;
		}
		if (!labelx.getToolTip().getText().equals(labely.getToolTip().getText())) {
			System.out.println("Tooltip is false");
			return false;
		}
		System.out.println("True");
		return result;
	}
	
	

}
