package step2;

public class StringCalculator {

	//계산할 문자열
	private String operand;

	//커스텀 구분자
	private String separator;

	//생성자
	public StringCalculator() {
		this.separator = null;
	}

	public StringCalculator(String s) {
		this.separator = null;
		this.operand = s;
	}

	//빈 문자열인지
	public boolean isNull() {
		String temp = this.operand;
		temp = temp.replace(" ", "");
		return 	temp.isEmpty() || temp==null;
	}

	//첫글자가 //인지 확인하고 맞으면 this.separator에 저장, 커스텀 문자열부분 자르고 this.operand에 저장
	public boolean isCustomSeparator() {
		String temp = this.operand;
		if(temp.startsWith("//")) {
			this.separator = temp.substring(2, 3);
			this.operand = temp.substring(temp.indexOf("\n")+1);
			return true;
		}
		else return false;
	}

	//음수인지 확인
	public int isNegative(int num){
		if(num<0)  throw new RuntimeException();
		else return num;
	}

	//계산 결과를 반환하는 메소드
	public int Calculation(){
		if(this.isNull()) return 0;
		else{
			this.isCustomSeparator();

			String[] ops;
			if(this.separator!=null) {
				ops = this.operand.split(this.separator);
			}
			else{
				ops = this.operand.split(",|:");
			}

			int sum=0;
			for(String o : ops) {
				sum += this.isNegative(Integer.parseInt(o));
			}
			return sum;
		}
	}

	//Getter
	public String getOperand() {
		return this.operand;
	}

	public String getSeparator() {
		return this.separator;
	}

}
