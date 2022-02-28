package test.a;

public class Calculator {
	
	private int number1;
	private int number2;
	private String op;

	
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param number1
	 * @param number2
	 * @param op
	 */
	public Calculator(int number1, int number2, String op) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.op = op;
	}
	
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	
	public int getResultNumber() {
		
		return number1 + number2;
	}




	

}
