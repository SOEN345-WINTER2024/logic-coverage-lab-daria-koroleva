import static org.junit.Assert.*;

import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;

public class CheckItTest {
	
	OutputStream os = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(os);

	@Before
	public void setUp() {
		// Prepare to redirect output
		System.setOut(ps);
	}

	@After
	public void restore() {
		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}

	@Test
	public void predicateCoverageTrueTest() {
		boolean a=true;
		boolean b=false;
		boolean c=false;
		String expected ="P is true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}
	
	@Test
	public void predicateCoverageFalseTest() {
		boolean a=false;
		boolean b=false;
		boolean c=true;
		String expected ="P isn't true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}	
	@Test
	public void clauseCoverageTrueTest() {
		boolean a=true;
		boolean b=true;
		boolean c=true;
		String expected ="P is true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}
	
	@Test
	public void clauseCoverageFalseTest() {
		boolean a=false;
		boolean b=false;
		boolean c=false;
		String expected ="P isn't true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}
	@Test
	public void caccTrueTest() {
		boolean a=true;
		boolean b=false;
		boolean c=true;
		String expected ="P is true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}
	
	@Test
	public void caccFalseTest() {
		boolean a=false;
		boolean b=true;
		boolean c=false;
		String expected ="P isn't true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}
	@Test
	public void raccTrueTest() {
		boolean a=true;
		boolean b=true;
		boolean c=false;
		String expected ="P is true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}
	
	@Test
	public void raccFalseTest() {
		boolean a=false;
		boolean b=true;
		boolean c=false;
		String expected ="P isn't true" +  System.getProperty("line.separator"); 
		CheckIt.checkIt(a,b,c);	
		assertEquals(expected, os.toString());
	}
}
