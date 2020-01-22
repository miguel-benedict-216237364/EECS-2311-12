package venn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class makeCircle extends JPanel{
	private static int NOC;
	
	
	
	
	public void paintComponent(Graphics g) {
		if (getNOC()==0) {
			
		}else if (getNOC()==2){
			
		
		g.setColor(Color.BLACK);
		g.drawOval(525, 100, 500, 500);
		g.drawOval(265, 100, 500, 500);	
		}
	}
	public static int getNOC() {
		int result= NOC;
		return result;
	}
	
	public static void setNOC(int i) {
		NOC = i;
	}
	

}
