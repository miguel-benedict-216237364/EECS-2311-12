package vennDiagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class VennTest {
	private VennDiagram venn;
	@Test
	public void test() {
		venn = new VennDiagram();
		venn.initialize();
		venn.initializeTwo();
		venn.initializeMenu();
		
	}

}
