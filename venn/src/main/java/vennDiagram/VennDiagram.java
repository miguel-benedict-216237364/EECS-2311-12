package vennDiagram;

import javax.swing.*;
import java.awt.*;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class VennDiagram {
	static JFrame mainFrame = new JFrame();
	static JLayeredPane pnlMain = new JLayeredPane();
	private static JTextField txtInsertTitle;
	private static JTextArea textArea;

	public static void main(String[] args) {
		// JFrame mainFrame = new JFrame();

		initialize();
		initializeMenu();
		initializeTwo();
	}

	// Initializes the main JFrame and the main Panel
	public static void initialize() {
		mainFrame.setAlwaysOnTop(true);
		mainFrame.setSize(1280, 720);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(null);
		pnlMain.setOpaque(false);

	}

	// Initializes the Menu
	public static void initializeMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 89, 21);
		// twoCircle.add(menuBar);
		mainFrame.setJMenuBar(menuBar);

		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(help);
		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");

		// Exit Event Handler
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
		});
		file.add(save);
		file.add(open);
		file.add(exit);

		JMenuItem about = new JMenuItem("About");
		help.add(about);
	}

	// Initializes Venn Diagram with Two Circles
	public static void initializeTwo() {

		// Create necesarry variables and Arraylist
		ArrayList<JTextArea> leftList = new ArrayList<JTextArea>();
		ArrayList<JTextArea> rightList = new ArrayList<JTextArea>();
		ArrayList<JTextArea> middleList = new ArrayList<JTextArea>();

		int[] leftDimensions = { 10, 11, 155, 20 };
		int[] rightDimensions = { 10, 11, 155, 20 };
		int[] middleDimensions = { 10, 11, 130, 20 };

		int[] leftPaneDimensions = { 10, 11, 155, 20 };
		int[] rightPaneDimensions = { 10, 11, 155, 20 };
		int[] middlePaneDimensions = { 10, 11, 130, 20 };

		// Create Title
		txtInsertTitle = new JTextField();
		txtInsertTitle.setOpaque(false);
		txtInsertTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtInsertTitle.setText("Insert Title");
		txtInsertTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsertTitle.setBounds(497, 40, 250, 30);
		pnlMain.add(txtInsertTitle);
		txtInsertTitle.setColumns(10);

		// Create Left Panel
		JPanel pnlLeft = new JPanel();
		pnlLeft.setOpaque(false);
		pnlLeft.setBounds(310, 180, 175, 300);
		pnlMain.add(pnlLeft);
		pnlLeft.setLayout(null);
		pnlMain.setLayer(pnlLeft, 1);

		// Create Action Event for Left Panel
		pnlLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				textArea = new JTextArea();
				textArea.setBounds(leftDimensions[0], leftDimensions[1], leftDimensions[2], leftDimensions[3]);
				leftDimensions[1] = leftDimensions[1] + 30;
				pnlLeft.add(textArea);
				textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				// textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				textArea.setOpaque(false);
				textArea.setText("- This is text number " + leftList.size());
				textArea.requestFocus();
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				leftList.add(textArea);
				refresh();

			}
		});

		// Create Right Panel
		JPanel pnlRight = new JPanel();
		pnlRight.setOpaque(false);
		pnlMain.setLayer(pnlRight, 1);
		pnlRight.setLayout(null);
		pnlRight.setBounds(760, 180, 175, 300);
		pnlMain.add(pnlRight);

		// Create Action Event for Right Panel
		pnlRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				textArea = new JTextArea();
				textArea.setBounds(rightDimensions[0], rightDimensions[1], rightDimensions[2], rightDimensions[3]);
				rightDimensions[1] = rightDimensions[1] + 30;
				textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				pnlRight.add(textArea);
				// textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				textArea.setOpaque(false);
				textArea.setText("- This is text number " + rightList.size());
				textArea.requestFocus();
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				rightList.add(textArea);
				refresh();

			}
		});

		// Create Middle Panel
		JPanel pnlMiddle = new JPanel();
		pnlMain.setLayer(pnlMiddle, 1);
		pnlMiddle.setLayout(null);
		pnlMiddle.setOpaque(false);
		pnlMiddle.setBounds(535, 180, 175, 300);
		pnlMain.add(pnlMiddle);

		// Create Action Event for Middle Panel
		pnlMiddle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				textArea = new JTextArea();
				textArea.setBounds(middlePaneDimensions[0], middlePaneDimensions[1], middlePaneDimensions[2],
						middlePaneDimensions[3]);
				middlePaneDimensions[1] = middlePaneDimensions[1] + 30;
				textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				pnlMiddle.add(textArea);

				textArea.setOpaque(false);
				textArea.setText("- This is text number " + middleList.size());
				textArea.requestFocus();
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				middleList.add(textArea);
				refresh();

			}
		});
		// Draw circle
		drawCircle circle = new drawCircle();
		circle.setBounds(247, 80, 750, 500);
		pnlMain.add(circle);
		pnlMain.setLayer(circle, 1);

	}

	public static void initializeTwoEvents() {

	}

	// Refreshes the main Frame and the main Panel

	public static void refresh() {
		mainFrame.revalidate();
		mainFrame.repaint();
		pnlMain.revalidate();
		pnlMain.repaint();
	}
}
