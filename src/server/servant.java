package server;

import _final.CalcPOA;

public class servant extends CalcPOA{

	@Override
	public int calculate(String opcode, int op1, int op2) {
		int result=0;
		switch(opcode)
		{
		case "+":
			result=op1+op2;
			break;
		case "-":
			result=op1-op2;
			break;
		case "*":
			result=op1*op2;
			break;
		case "/":
			result=op1/op2;
			break;
		}
		return result;
	}

	@Override
	public int exit() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

}
