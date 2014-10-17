package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	public void testMultipleNumbers(){
    		assertEquals(6, Calculator.add("1,2,3"));
        }
	@Test
	public void testmore(){
		assertEquals(10, Calculator.add("1,1,1,1,1,1,1,1,1,1"));
	}
	@Test
	public void testNewline() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testDelimeter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	public void testAnyLengthDelimeter() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void testMultipleDelimeters() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void testNegative() {
		RuntimeException exception = null;
		try{
			Calculator.add("-1,2");
		}
		catch(RuntimeException e) {
			exception = e;
		}
		assertEquals("Negatives not allowed: -1", exception.getMessage());
		
		exception = null;
                try{
                        Calculator.add("2,-4,3,-5");
                }
                catch(RuntimeException e) {
                        exception = e;
                }
                assertEquals("Negatives not allowed: -4,-5", exception.getMessage());

	}
	@Test
	public void testOver9000() {
		assertEquals(2, Calculator.add("1001,2"));
	}        

}
