package application;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Save {
	DataOutputStream dataOutStream;
	
	public Save() {
		
	}
	
	public void save(Controller control, File file, double lRadius, double rRadius) throws FileNotFoundException {		
		PrintWriter printWriter = new PrintWriter(file);
		printWriter.println("Main Title:");
		printWriter.println(Controller.mainTitleText);
		printWriter.println("Left Title:");
		printWriter.println(Controller.leftTitleText);
		printWriter.println("Right Title");
		printWriter.println(Controller.rightTitleText);
		printWriter.println("Left Radius");
		printWriter.println(lRadius);
		printWriter.println("Right radius");
		printWriter.println(rRadius);
		
		//printWriter.println("------------------------TitlesEnd--------------------");
		for(int i =0 ; i < Controller.customLabelList.size(); i++){
				printWriter.println("----------Start of Label----------");
				CustomLabel tmp = Controller.customLabelList.get(i);
				printWriter.println("Label Text:");
				printWriter.println(tmp.getText());
				printWriter.println("Label sequence:");
				printWriter.println(tmp.getSequence());
				printWriter.println("Layout X: ");
				printWriter.println(tmp.getLayoutX());
				printWriter.println("Layout Y: ");
				printWriter.println(tmp.getLayoutY());
				printWriter.println("Tooltip Text: ");
				printWriter.println(tmp.getToolTip().getText());	
				
				printWriter.println("Font Name: ");
				printWriter.println(tmp.getFont().getFamily());
				printWriter.println("Size: ");
				printWriter.println(tmp.getFont().getSize());
				boolean isItalic = false;
				boolean isBold = false;
				
				//Font test = tmp.getFont();
				if (tmp.getFont().getName().contains("Bold")) {
					isBold = true;
				}else{
					isBold = false;
				}
				if (tmp.getFont().getName().contains("Italic")) {
					isItalic=true;
				}else{
					isItalic = false;
				}
				printWriter.println("Bold: ");
				printWriter.println(isBold);
				printWriter.println("Italic: ");
				printWriter.println(isItalic);
				printWriter.println("Colour: ");
				printWriter.println(tmp.getTextFill().toString());
			}
		printWriter.println("---------- End of Labels ----------"); 
		
		
		printWriter.close();
	}

}
