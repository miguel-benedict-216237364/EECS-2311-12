package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;



import javafx.scene.input.MouseEvent;

import javafx.scene.text.Font;
import javafx.util.Duration;

public class CustomLabel extends Label{

	
	private Tooltip toolTip;
	private int sequence = 0;

	
	public static int counter = 0;
	//public static Label lblTmp = new Label();
	 public static ArrayList<CustomLabel> focusList = Controller.focusList;
	public static ArrayList<CustomLabel> customLabelList = Controller.customLabelList;
	public static ArrayList<CustomLabel> evaluationList = Controller.evaluationList;
	public static double initX = 0;
	public static double initY = 0;
	public static double maxWidth=0;
	public static double maxHeight=0;
	


	CustomLabel(String text, String additionalText) {
	
		/*counter++;
		sequence++;
		this.sequence= counter; // Set Default Text
		Font font = Controller.getFont(Controller.selectedTextFont, Controller.selectedTextSize, Controller.isBoldBoolean, Controller.isItalicBoolean);	
		this.setFont(font);
		this.setTextFill(Controller.selectedTextColour);
		if (text.trim().length()<=0) {
			this.setText("Insert Text " );
		}else {
			this.setText(text);
		}
		
		this.setVisible(true);
		this.setDisable(false);
		this.setMaxWidth(150);
		this.setWrapText(true);


		this.toolTip = new Tooltip(); // Create new Tooltip Label
		// Set the default properties for the panel
		Tooltip.install(this, this.toolTip);
		if (additionalText.trim().length()<=0) {
			this.toolTip.setText("Additional Information can be added here");
		}else {
			this.toolTip.setText(additionalText);
		}
	
		this.toolTip.setShowDelay(Duration.millis(250));
		this.toolTip.setFont(Font.font("Times New Roman", 12));
		this.toolTip.setWrapText(true);
		this.toolTip.setMaxWidth(150);*/
		
		this.initializeLabel(text, additionalText);
		
		

		/*
		this.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {
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
				
		this.onMousePressedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				 initX = event.getX(); // Initial position of the mouse (x)
				 initY = event.getY(); // Initial position of the mouse (y)

			}

		});
*/
		this.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {		
				final Label lblTmp = (Label) event.getSource(); // Select the Label 
					if (Controller.isDraggableBoolean  && focusList.contains(CustomLabel.findCustomLabel(lblTmp, customLabelList))) {
						for (int i = 0; i < focusList.size(); i++) {
							if ((focusList.get(i).getLayoutX() + (event.getX() - initX) >= 0)
									&& (focusList.get(i).getLayoutX() + (event.getX() - initX) <= maxWidth
											- focusList.get(i).getWidth())) { // Check that it is within the x
																				// boundaries
								focusList.get(i).setLayoutX(focusList.get(i).getLayoutX() + (event.getX() - initX));
								
							}
							if ((focusList.get(i).getLayoutY() + (event.getY() - initY) >= 0)
									&& (focusList.get(i).getLayoutY() + (event.getY() - initY) <= maxHeight
											- focusList.get(i).getHeight())) { // Check that it is within the y
																				// boundaries
								focusList.get(i).setLayoutY(focusList.get(i).getLayoutY() + (event.getY() - initY));
							}
						}
						
					}
			}
			
		});
			
	}
		
	CustomLabel(CustomLabel customLabel){ // Used for the purposes of the creating a new CustomLabel for evaluation mode
		this.sequence= customLabel.getSequence(); // Set Default Text
		Font font =customLabel.getFont();
		this.setFont(font);
		this.setTextFill(customLabel.getTextFill());
		this.setText(customLabel.getText());
		this.setLayoutX(0.0);
		this.setLayoutY(0.0);
		
		this.setVisible(true);
		this.setDisable(false);
		this.setMaxWidth(150);
		this.setWrapText(true);


		this.toolTip = new Tooltip(); // Create new Tooltip Label
		// Set the default properties for the panel
		Tooltip.install(this, this.toolTip);
	
			this.toolTip.setText(customLabel.getToolTip().getText());
		
	
		this.toolTip.setShowDelay(Duration.millis(250));
		this.toolTip.setFont(Font.font("Times New Roman", 12));
		this.toolTip.setWrapText(true);
		this.toolTip.setMaxWidth(150);

		//evaluationList.add(customLabel);
	
	
		
		this.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {
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

		this.onMousePressedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				 initX = event.getX(); // Initial position of the mouse (x)
				 initY = event.getY(); // Initial position of the mouse (y)

			}

		});

		this.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				final Label lblTmp = (Label) event.getSource(); // Select the Label 
					if (Controller.isDraggableBoolean  && focusList.contains(CustomLabel.findCustomLabel(lblTmp, evaluationList))) {
						for (int i = 0; i < focusList.size(); i++) {
							if ((focusList.get(i).getLayoutX() + (event.getX() - initX) >= 0)
									&& (focusList.get(i).getLayoutX() + (event.getX() - initX) <= maxWidth
											- focusList.get(i).getWidth())) { // Check that it is within the x
																				// boundaries
								focusList.get(i)
										.setLayoutX(focusList.get(i).getLayoutX() + (event.getX() - initX));
							}
							if ((focusList.get(i).getLayoutY() + (event.getY() - initY) >= 0)
									&& (focusList.get(i).getLayoutY() + (event.getY() - initY) <= maxHeight
											- focusList.get(i).getHeight())) { // Check that it is within the y
																				// boundaries
								focusList.get(i)
										.setLayoutY(focusList.get(i).getLayoutY() + (event.getY() - initY));
							}
						}
					}
			}
		});

		
	}
	
	
	public void initializeLabel(String text, String additionalText) {
		counter++;
		sequence++;
		this.sequence= counter; // Set Default Text
		Font font = Controller.getFont(Controller.selectedTextFont, Controller.selectedTextSize, Controller.isBoldBoolean, Controller.isItalicBoolean);	
		this.setFont(font);
		this.setTextFill(Controller.selectedTextColour);
		if (text.trim().length()<=0) {
			this.setText("Insert Text " );
		}else {
			this.setText(text);
		}
		
		this.setVisible(true);
		this.setDisable(false);
		this.setMaxWidth(150);
		this.setWrapText(true);


		this.toolTip = new Tooltip(); // Create new Tooltip Label
		// Set the default properties for the panel
		Tooltip.install(this, this.toolTip);
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

	public String getAdditionalText() {
		return this.getToolTip().getText();
	}

	public void setAdditionalText(String additonalText) {
		this.getToolTip().setText(additonalText);
	}

	public void setLayoutXY(double x, double y) {
		this.setLayoutX(x);
		this.setLayoutY(y);
	}
	
	public static CustomLabel findCustomLabel(Label label,ArrayList<CustomLabel> fromList) {
		CustomLabel result = null;
		for (int i =0;i<fromList.size();i++) {
			if (fromList.get(i).equals(label)) {
				result = fromList.get(i);
				break;
			}
		}
		return result;
	}
	
	public static boolean compareCustomLabel(CustomLabel labelx, CustomLabel labely) {
		System.out.println("Comparison between " + labelx.getText() + " and " + labely.getText());
		boolean result= true;
		if (!labelx.getText().equals(labely.getText())) {
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
	
	//returns a copy of this label
	public CustomLabel labelCopy() {
		CustomLabel custom = new CustomLabel(this.getText(), this.getAdditionalText());
		custom.setFont(this.getFont());
		custom.setTextFill(this.getTextFill());
		
		return custom;
	}
	
	//checks if this label has the same font size etc as another label
	public boolean equals(CustomLabel c) {
		return 
			this.getFont().getSize() == c.getFont().getSize()
			&&
			this.getFont().getStyle() == c.getFont().getStyle()
			&&
			this.getText() == c.getText()
			&&
			this.getAdditionalText() == c.getAdditionalText()
			&&
			this.getFont().getFamily() == c.getFont().getFamily()
			&&
			this.getTextFill() == c.getTextFill();
		
		
	}
	

}
