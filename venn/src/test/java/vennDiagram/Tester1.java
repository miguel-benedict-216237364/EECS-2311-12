package vennDiagram;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.junit.Test;

public class Tester1 {
	private VennDiagram venn;
	@Test
	public void test() {
		venn = new VennDiagram();
		venn.initialize();
		venn.initializeTwo();
		venn.initializeMenu();
	}

}
