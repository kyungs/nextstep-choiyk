package step2;

/*
 * 주어진 문자열의 숫자를 계산하는 계산기 Util class
 * @author choiyk
 */
public class StringCalculator {

	//util class를 위해 생성자...?
	private StringCalculator() {}

	/*
	 * 더하기 계산 결과를 반환하는 메소드
	 * @param 계산할 문자열
	 * @return 계산 결과
	 */
	public static int add(String text){
		if(isNull(text)) return 0;
		return sum(toIntArray(split(text)));
	}

	/*
	 * 빈 문자열인지 검사
	 * @param 계산할 문자열
	 * @return 문자열이 빈 문자열이면 true 반환
	 */
	private static boolean isNull(String text) {
		return 	text==null || text.isEmpty();
	}

	/*
	 * 문자 배열을 int 배열로 변환
	 * @param 문자 배열
	 * @return int 배열
	 */
	private static int[] toIntArray(String[] args) {
		int[] newArr = new int[args.length];
		for(int i=0 ;i<args.length; i++)
			newArr[i] = Integer.parseInt(args[i]);
		return newArr;
	}

	/*
	 * 문자열 자르기
	 * @param 계산할 문자열
	 * @return 숫자인 문자들의 배열
	 */
	private static String[] split(String text) {
		String separator = getSeparator(text);
		if(text.startsWith("//"))
			text = text.substring(text.indexOf("\n")+1);
		return text.split(separator);
	}

	/*
	 * 구분자 구하기
	 * @param 계산할 문자열
	 * @return 구분자
	 */
	private static String getSeparator(String text) {
		if(text.startsWith("//"))
			return text.substring(2, text.indexOf("\n"));
		return ",|:";
	}

	/*
	 * 음수인지 확인
	 * @param int형 숫자
	 * @return int형 숫자
	 * @exception 음수이면 RuntimeException
	 */
	private static int isNegative(int num){
		if(num<0)  throw new RuntimeException();
		return num;
	}

	/*
	 * 숫자 배열의 합을 반환하는 메소드
	 * @param int형 배열
	 * @return int
	 */
	private static int sum(int[] args) {
		int sum=0;
		for(int n : args)
			sum += isNegative(n);
		return sum;
	}

}
