package vennDiagram;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class drawCircle extends JPanel {
	private int lx;
	private int ly;
	private int lWidth;
	private int lHeight;
	
	private int rx;
	private int ry;
	private int rWidth;
	private int rHeight;
	
	public drawCircle() {
		lx = 0;
		ly = 0;
		lWidth = 500;
		lHeight = 500;
		
		rx = 250;
		ry = 0;
		rWidth = 500;
		rHeight = 500;
	}
	
	
	
	
	public void paint(Graphics g) {
		Color c = new Color(0, 255, 255, 50);
		g.setColor(c);
		g.fillOval(lx, ly, lWidth, lHeight);
		g.fillOval(rx, ry, rWidth, rHeight);		
	}


}
