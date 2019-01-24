package step2;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void 빈문자열이면true리턴() {
		StringCalculator sc = new StringCalculator(" ");
		boolean result = sc.isNull();
		assertEquals(result, true);
	}

	@Test
	public void 문자열시작이커스텀구분자이면true리턴() {
		StringCalculator sc = new StringCalculator("//;\n");
		boolean result = sc.isCustomSeparator();
		assertEquals(result, true);
	}

	@Test
	public void 커스텀구분자저장테스트() {
		StringCalculator sc = new StringCalculator("//;\n");
		sc.isCustomSeparator();
		System.out.println(sc.getSeparator());
		assertThat(sc.getSeparator(), containsString(";"));
	}

	@Test
	public void 커스텀구분자이후문자열자르기테스트() {
		StringCalculator sc = new StringCalculator("//;\n1;2;3");
		sc.isCustomSeparator();
		System.out.println(sc.getOperand());
		assertThat(sc.getOperand(), containsString("1;2;3"));
	}

	@Test(expected = RuntimeException.class)
	public void 음수면Exception처리() {
		StringCalculator sc = new StringCalculator();
		sc.isNegative(-1);
	}

	@Test
	public void 계산테스트() {
		StringCalculator sc = new StringCalculator("1,2:3");
		int result  = sc.Calculation();
		assertEquals(result, 6);
	}

	@Test
	public void 커스텀구분자계산테스트() {
		StringCalculator sc = new StringCalculator("//;\n1;2;3");
		int result  = sc.Calculation();
		assertEquals(result, 6);
	}

	@Test(expected = RuntimeException.class)
	public void 음수테스트() {
		StringCalculator sc = new StringCalculator("//;\n-1;2;3");
		sc.Calculation();
	}

}
