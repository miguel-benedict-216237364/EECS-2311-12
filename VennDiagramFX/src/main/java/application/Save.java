package application;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.control.Label;

public class Save {
	DataOutputStream dataOutStream;
	
	public Save() {
		
	}
	
	public void save(Controller control, File file, double lRadius, double rRadius) throws FileNotFoundException {		
		PrintWriter printWriter = new PrintWriter(file);
		
		printWriter.println(control.getLeftTitle());
		printWriter.println(control.getMainTitle());
		printWriter.println(control.getRightTitle());
		printWriter.println(lRadius);
		printWriter.println(rRadius);
		
		//printWriter.println("------------------------TitlesEnd--------------------");
		for(int i =0 ; i < control.labelList.size(); i++){
				Label label = control.labelList.get(i);
				printWriter.println(label.getText());
				printWriter.println("----------------text----------------");
				printWriter.println(label.getLayoutX()+"");
				printWriter.println(label.getLayoutY()+"");
				//printWriter.println(label.getFont().toString());
				//printWriter.println(label.getTextFill().toString());
			}
		printWriter.println("----------------LabelEnd-------------------"); 
		
		
		printWriter.close();
	}

}
