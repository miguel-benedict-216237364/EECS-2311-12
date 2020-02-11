package vennDiagram;

import static org.junit.Assert.*;

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
