package venn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class threeCircle extends JPanel {
	public void paintComponent(Graphics g) {

		g.setColor(Color.BLACK);
		g.drawOval(525, 100, 100, 100);
		g.drawOval(265, 100, 100, 100);
	}
}
