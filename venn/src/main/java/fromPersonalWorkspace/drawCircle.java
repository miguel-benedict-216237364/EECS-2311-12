package fromPersonalWorkspace;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class drawCircle extends JPanel {

	
	public void paint(Graphics g) {

		Color c = new Color(0, 255, 255, 50);
		g.setColor(c);
		g.fillOval(50, 10, 500, 500);
		g.fillOval(300, 10, 500, 500);
		
		
	}


}
