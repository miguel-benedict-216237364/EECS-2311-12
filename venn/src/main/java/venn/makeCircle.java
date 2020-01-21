package venn;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class makeCircle extends JPanel{
	
	int x;int y;int height;int length;
	
	public makeCircle(){
		super();
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.BLACK);
		g.drawOval(500, 80, 600, 600);
		g.drawOval(240, 80, 600, 600);	
		
	}

}
