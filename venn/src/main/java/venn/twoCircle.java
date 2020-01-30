package venn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class twoCircle extends JPanel{
	
	
	
	
	public void paintComponent(Graphics g) {
	
		Color c = new Color(0,255,255,50);
		g.setColor(c);
		
		g.fillOval(525, 100, 500, 500);
		g.fillOval(265, 100, 500, 500);	
		}
	
}
