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
		circle.setBounds(200, 70, 825, 525);
	
		pnlMain.add(circle);
		
		JTextField lblTest = new JTextField("This is the Prototype");
		lblTest.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
	
		lblTest.setBounds(325, 25, 606, 34);
		lblTest.setBorder(null);
		lblTest.setOpaque(false);
		pnlMain.add(lblTest);
	
		pnlMain.setLayer(lblTest, 1);
		/*
		JTextArea txtLeftInput = new JTextArea();
		txtLeftInput.setOpaque(false);
		txtLeftInput.setText("1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n11\r\n12\r\n13\r\n14\r\n15\r\n\r\n");
		txtLeftInput.setWrapStyleWord(true);
		txtLeftInput.setLineWrap(true);
		txtLeftInput.setBounds(325, 200, 150, 275);
		pnlMain.add(txtLeftInput);
		pnlMain.setLayer(txtLeftInput, 1);
		*/
		
		JTextArea txtRightInput = new JTextArea();
		txtRightInput.setOpaque(false);
		txtRightInput.setText("1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n11\r\n12\r\n13\r\n14\r\n15\r\n\r\n");
		txtRightInput.setWrapStyleWord(true);
		txtRightInput.setLineWrap(true);
		txtRightInput.setBounds(775, 200, 150, 275);
		pnlMain.add(txtRightInput);
		pnlMain.setLayer(txtRightInput, 1);
		
		JTextArea txtMiddle = new JTextArea();
		txtMiddle.setWrapStyleWord(true);
		txtMiddle.setText("1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n11\r\n12\r\n13\r\n14\r\n15\r\n\r\n");
		txtMiddle.setOpaque(false);
		txtMiddle.setLineWrap(true);
		txtMiddle.setBounds(550, 200, 150, 275);
		pnlMain.add(txtMiddle);
		pnlMain.setLayer(txtMiddle, 1);
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JTextArea txtLeftInput = new JTextArea();
				txtLeftInput.setOpaque(false);
				txtLeftInput.setText("1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n11\r\n12\r\n13\r\n14\r\n15\r\n\r\n");
				txtLeftInput.setWrapStyleWord(true);
				txtLeftInput.setLineWrap(true);
				txtLeftInput.setBounds(325, 200, 150, 275);
				pnlMain.add(txtLeftInput);
				pnlMain.setLayer(txtLeftInput, 1);
			}
		});
		pnlLeft.setOpaque(false);
		pnlLeft.setBounds(325, 200, 150, 275);
		pnlMain.add(pnlLeft);
		pnlMain.setLayer(pnlLeft, 1);
	

	}
}
