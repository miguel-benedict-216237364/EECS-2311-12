package venn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class makeCircle extends JPanel{
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(525, 100, 500, 500);
		g.drawOval(265, 100, 500, 500);	
	}
	

}
