package vennDiagram;

//this is a comment
import javax.swing.*;
import java.awt.*;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseMotionAdapter;

public class VennDiagram {
	static JFrame mainFrame = new JFrame();
	static JLayeredPane pnlMain = new JLayeredPane();
	private static JTextField txtInsertTitle;
	private static JTextArea textArea;
	private static JPanel panel;

	// Create necesarry variables and Arraylist
	static ArrayList<JPanel> leftList = new ArrayList<JPanel>();
	static ArrayList<JPanel> rightList = new ArrayList<JPanel>();
	static ArrayList<JPanel> middleList = new ArrayList<JPanel>();

	static ArrayList<JTextArea> allTextArea = new ArrayList<JTextArea>();

	static int[] leftDimensions = { 10, 11, 155, 20 };

	static int[] leftPanelDimensions = { 10, 11, 161, 23 };

	static int leftTextAreaHeight = 14;

	public static void main(String[] args) {
		// JFrame mainFrame = new JFrame();
		initializeMenu();
		initialize();
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

		// Create Title
		txtInsertTitle = new JTextField();
		txtInsertTitle.setOpaque(false);
		txtInsertTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtInsertTitle.setText("Insert Title");
		txtInsertTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtInsertTitle.setBounds(497, 40, 250, 30);
		pnlMain.add(txtInsertTitle);
		txtInsertTitle.setColumns(10);

		// the first Panel for TextArea
		panel = new JPanel();
		panel.setBounds(0, 0, 161, 26);
		panel.setEnabled(false);
		panel.setOpaque(false);
		pnlMain.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		middleList.add(panel);
		leftList.add(panel);
		rightList.add(panel);

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
				leftTextAreaHeight = leftList.get(lowestTextArea(leftList)).getY()
						+ leftList.get(lowestTextArea(leftList)).getHeight() + 10;
				// Create a panel
				panel = new JPanel();
				panel.setBounds(0, leftTextAreaHeight, 161, 26);
				pnlLeft.add(panel);
				panel.setLayout(null);
				panel.setOpaque(false);
				txtInsertTitle.setText(Integer.toString(leftList.get(lowestTextArea(leftList)).getHeight())
						+ (Integer.toString(leftTextAreaHeight)));

				// Create the text Area
				textArea = new JTextArea();
				textArea.setBounds(13, 7, 155, 20);
				textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				textArea.setOpaque(false);
				textArea.setText("- This is text number " + leftList.size());
				textArea.requestFocus();
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				allTextArea.add(textArea);
				panel.add(textArea);
				leftList.add(panel);
				refresh();

				textArea.getDocument().addDocumentListener(new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						Math.ceil(width / 140.0);
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);
						removeEmptyTextArea(leftList);
						resortTextAreaList(leftList);

						refresh();

					}

					public void removeUpdate(DocumentEvent e) {
						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);

						if (textArea.getText().equals("")) {
							for (int i = 1; i < leftList.size(); i++) {
								if (textArea.getParent().equals(leftList.get(i))) {
									leftList.remove(i);
									break;
								}
							}
						}

						resortTextAreaList(leftList);
						refresh();

					}

					public void insertUpdate(DocumentEvent e) {
						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						Math.ceil(width / 140.0);
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);
						removeEmptyTextArea(leftList);
						resortTextAreaList(leftList);

						refresh();

					}
				});
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
				leftTextAreaHeight = rightList.get(lowestTextArea(rightList)).getY()
						+ rightList.get(lowestTextArea(rightList)).getHeight() + 10;
				// Create a panel
				panel = new JPanel();
				panel.setBounds(0, leftTextAreaHeight, 161, 26);
				pnlRight.add(panel);
				panel.setLayout(null);
				panel.setOpaque(false);
				txtInsertTitle.setText(Integer.toString(rightList.get(lowestTextArea(rightList)).getHeight())
						+ (Integer.toString(leftTextAreaHeight)));

				// Create the text Area
				textArea = new JTextArea();
				textArea.setBounds(13, 7, 155, 20);
				textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				textArea.setOpaque(false);
				textArea.setText("- This is text number " + rightList.size());
				textArea.requestFocus();
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				allTextArea.add(textArea);
				panel.add(textArea);
				rightList.add(panel);
				refresh();

				textArea.getDocument().addDocumentListener(new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						Math.ceil(width / 140.0);
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);
						removeEmptyTextArea(rightList);
						resortTextAreaList(rightList);

						refresh();

					}

					public void removeUpdate(DocumentEvent e) {
						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);

						if (textArea.getText().equals("")) {
							for (int i = 1; i < rightList.size(); i++) {
								if (textArea.getParent().equals(rightList.get(i))) {
									rightList.remove(i);
									break;
								}
							}
						}

						resortTextAreaList(rightList);
						refresh();

					}

					public void insertUpdate(DocumentEvent e) {
						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						Math.ceil(width / 140.0);
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);
						removeEmptyTextArea(rightList);
						resortTextAreaList(rightList);

						refresh();

					}
				});
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
				leftTextAreaHeight = middleList.get(lowestTextArea(middleList)).getY()
						+ middleList.get(lowestTextArea(middleList)).getHeight() + 10;
				// Create a panel
				panel = new JPanel();
				panel.setBounds(0, leftTextAreaHeight, 161, 26);
				pnlMiddle.add(panel);
				panel.setLayout(null);
				panel.setOpaque(false);
				txtInsertTitle.setText(Integer.toString(middleList.get(lowestTextArea(middleList)).getHeight())
						+ (Integer.toString(leftTextAreaHeight)));

				// Create the text Area
				textArea = new JTextArea();
				textArea.setBounds(13, 7, 155, 20);
				textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				textArea.setOpaque(false);
				textArea.setText("- This is text number " + middleList.size());
				textArea.requestFocus();
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				allTextArea.add(textArea);
				panel.add(textArea);
				middleList.add(panel);
				refresh();

				textArea.getDocument().addDocumentListener(new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {

						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						Math.ceil(width / 140.0);
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);
						removeEmptyTextArea(middleList);
						resortTextAreaList(middleList);

						refresh();

					}

					public void removeUpdate(DocumentEvent e) {
						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);

						if (textArea.getText().equals("")) {
							for (int i = 1; i < middleList.size(); i++) {
								if (textArea.getParent().equals(middleList.get(i))) {
									middleList.remove(i);
									break;
								}
							}
						}

						resortTextAreaList(middleList);
						refresh();

					}

					public void insertUpdate(DocumentEvent e) {
						textArea = (JTextArea) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
						int width = getStringPixel(textArea);
						txtInsertTitle.setText(Integer.toString(width));
						Math.ceil(width / 140.0);
						textArea.setSize(textArea.getWidth(), (int) ((int) 20 * Math.ceil(width / 145.0)));
						textArea.getParent().setSize(textArea.getWidth() + 6, textArea.getHeight() + 6);
						removeEmptyTextArea(middleList);
						resortTextAreaList(middleList);

						refresh();

					}
				});
			}
		});

		// Draw circle
		drawCircle circle = new drawCircle();
		circle.setBounds(247, 80, 750, 500);
		pnlMain.add(circle);
		pnlMain.setLayer(circle, 1);

	}

	// Refreshes the main Frame and the main Panel

	public static void refresh() {
		mainFrame.revalidate();
		mainFrame.repaint();
		pnlMain.revalidate();
		pnlMain.repaint();
	}

	public static void resortTextAreaList(ArrayList<JPanel> list) {
		for (int i = 1; i < list.size(); i++) {
			list.get(i).setBounds(0, list.get(i - 1).getY() + list.get(i - 1).getHeight() + 10, list.get(i).getWidth(),
					list.get(i).getHeight());
		}
	}

	public static int lowestTextArea(ArrayList<JPanel> list) {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {

			if (result < list.get(i).getY()) {
				result = i;
			}
		}
		return result;
	}

	public static int getStringPixel(JTextArea textarea) {

		Font font = textArea.getFont();
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(font);
		int width = fm.stringWidth(textArea.getText());
		return width;
	}

	public static void removeEmptyTextArea(ArrayList<JPanel> list) {
		for (int i = 0; i < allTextArea.size(); i++) {
			if (!(allTextArea.get(i).hasFocus()) && allTextArea.get(i).getText().equals("")) {
				for (int j = 1; j < list.size(); j++) {
					if (allTextArea.get(i).getParent().equals(list.get(j))) {
						list.remove(j);
					}
				}
			}
		}
	}

	public static void removeTextArea(ArrayList<JPanel> list, JTextArea textArea) {
		for (int i = 0; i < list.size(); i++) {
			if (textArea.getParent().equals(list.get(i))) {
				list.remove(i);
			}
		}
	}
}
