package fromPersonalWorkspace;

import javax.swing.*;
import java.awt.*;


import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VennDiagram {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setAlwaysOnTop(true);
		mainFrame.setSize(1280, 720);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane pnlMain = new JLayeredPane();
		mainFrame.getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(null);
		pnlMain.setOpaque(false);
		
		drawCircle circle = new drawCircle();
		circle.setBounds(480, 110, 750, 500);
	
		pnlMain.add(circle);
		
		JTextField lblTest = new JTextField("Edit for title");
		lblTest.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
	
		lblTest.setBounds(550, 40, 600, 30);
		lblTest.setBorder(null);
		lblTest.setOpaque(false);
		pnlMain.add(lblTest);
	
		pnlMain.setLayer(lblTest, 1);
		
		JPanel pnlConfig = new JPanel();
		pnlConfig.setBounds(100, 160, 280, 400);
		pnlMain.add(pnlConfig);
		pnlConfig.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configuration");
		lblNewLabel.setBounds(74, 18, 148, 16);
		pnlConfig.add(lblNewLabel);
	

	}
}
