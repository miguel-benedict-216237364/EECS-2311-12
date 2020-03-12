package application;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.control.Label;

public class Save {
	private FileWriter writer;
	DataOutputStream dataOutStream;
	private Controller control;
	
	public Save() {
		this.initializeSave();
	}
	
	public void save(Controller control, File file) throws FileNotFoundException {
		this.control = control;		
		this.initializeSave();
		/*
		 * PrintWriter printWriter2 = new PrintWriter(writer); printWriter2.print("");
		 * printWriter2.close();
		 */
		
		PrintWriter printWriter = new PrintWriter(file);
		
		printWriter.println(control.getLeftTitle());
		printWriter.println(control.getMainTitle());
		printWriter.println(control.getRightTitle());
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
	
	public void initializeSave() {
		try {
			this.writer = new FileWriter("C:/Users/edshi/git/EECS-2311-12(4)/VennDiagramFX/save.txt");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
