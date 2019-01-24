package step2;

public class StringCalculator {

	//계산할 문자열
	private String string;

	//커스텀 구분자
	private String separator;

	//생성자
	public StringCalculator() {
		this.separator = ",|:";
		this.string = null;
	}

	public StringCalculator(String s) {
		this.separator = ",|:";
		this.string = s;
	}

	//빈 문자열인지
	public boolean isNull() {
		return 	this.string==null || this.string.isEmpty();
	}

	//커스텀 문자열이 있는지 확인
	public boolean isCustomSeparator() {
		if(this.string.startsWith("//")) return true;
		return false;
	}

	//커스텀 문자열이 있으면 this.separator에 저장, 커스텀 문자열부분 자르고 this.operand에 저장
	public void setCustomSeparator() {
		String temp = this.string;
		this.separator = temp.substring(2, 3);
		this.string = temp.substring(temp.indexOf("\n")+1);
	}

	//음수인지 확인
	public int isNegative(int num){
		if(num<0)  throw new RuntimeException();
		return num;
	}

	//계산 결과를 반환하는 메소드
	public int add(){
		if(this.isNull()) return 0;
		if(this.isCustomSeparator())
			this.setCustomSeparator();
		String[] ops = this.string.split(this.separator);
		int sum=0;
		for(String o : ops)
			sum += this.isNegative(Integer.parseInt(o));
		return sum;
	}

	//Getter
	public String getOperand() {
		return this.string;
	}

	public String getSeparator() {
		return this.separator;
	}

}
