package venn;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.TextField;
import javax.swing.JTextArea;
import java.awt.Label;
import javax.swing.JTextPane;

public class benedictVennDiagram extends JFrame {

	private JPanel pnlMain;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					benedictVennDiagram frame = new benedictVennDiagram();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});

	
	
	}

	/**
	 * Create the frame.
	 */
	public benedictVennDiagram() {

		 
		initComponents();
		
		createEvents();
			
	}
	
	
	
	
	
	//////////////////////////////////////////////
	// This method contains the events
	/////////////////////////////////////////////

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
	
/*
	public void paintComponent(Graphics i) {
		i.setColor(Color.BLACK);
		i.drawOval(500, 80, 600, 600);
		i.drawOval(240, 80, 600, 600);		
	}
*/
//////////////////////////////////////////////
//	This method contains the code for creating and initiializing parts
/////////////////////////////////////////////

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("The Diagram");
		
		
		
		pnlMain = new JPanel();
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMain);
		pnlMain.setLayout(null);
		pnlMain.setVisible(true);
		pnlMain.setOpaque(false);
		
		JTextPane txtpLeft = new JTextPane();
		txtpLeft.setText("1\r\n1\r\n1\r\n1\r\n11\r\n");
		txtpLeft.setBounds(325, 180, 150, 350);
		pnlMain.add(txtpLeft);
		
		JTextPane txtpMiddle = new JTextPane();
		txtpMiddle.setBounds(595, 180, 150, 350);
		pnlMain.add(txtpMiddle);
		
		JTextPane txtpRight = new JTextPane();
		txtpRight.setBounds(850, 180, 150, 350);
		pnlMain.add(txtpRight);
		
		
		
	
		
	}
}
