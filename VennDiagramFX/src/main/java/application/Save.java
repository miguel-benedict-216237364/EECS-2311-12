package application;

import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.control.Label;

public class Save {
	private FileWriter writer;
	DataOutputStream dataOutStream;
	private Controller control;
	
	public Save() {
		
		 try {
			this.writer = new FileWriter("C:/Users/edshi/git/EECS-2311-12(4)/VennDiagramFX/save.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save(Controller control) {
		this.control = control;		
		PrintWriter printWriter = new PrintWriter(writer);
		
		printWriter.write("----------------LabelStart------------------");
		printWriter.println();
		for(int i =0 ; i < control.labelList.size(); i++){
				Label label = control.labelList.get(i);
				printWriter.write(label.getText());
				printWriter.println();
		}
		printWriter.write("----------------LabelEnd-------------------");
		printWriter.println();
		
		printWriter.close();
	}

}
