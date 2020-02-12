package venn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class twoCircle extends JPanel{
	
	
	
	
	public void paintComponent(Graphics g) {
	
		Color c = new Color(0,255,255,50);
		g.setColor(c);
		Graphics2D g2d = (Graphics2D)g.create(); 
		g2d.scale(2.5, 2.5);
		g.fillOval(525, 100, 500, 500);
		g.fillOval(265, 100, 500, 500);	
		}
	
}
