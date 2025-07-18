package Training.Training_22;

/*
 * Java 연습 문제 22
 * - 중위 표기법 -> 후위 표기법 으로 변환하기
 * - 사용자로부터 중위 표기법으로 된 수식을 입력 받아 후위 표기법으로 변환하기
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * Training 22
 */
public class CT01Training_22 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("수식 입력 : ");
		String oExpression_Infix = oScanner.nextLine();
		
		String oExpression_Postfix = infix_ToPostfix(oExpression_Infix);
		System.out.printf("\n결과 : %s\n", oExpression_Postfix);
		
		double dblResult = getResult_Calc(oExpression_Postfix);
		System.out.printf("수식 결과 : %f\n", dblResult);
	}
	
	/** 우선 순위를 반환한다 */
	private static int getPriority(String a_oToken, boolean a_bIsIn_Stack) {
		switch(a_oToken) {
			case "*": case "/":
				return 1;
				
			case "(":
				return a_bIsIn_Stack ? 3 : 0;
		}
		
		return 2;
	}
	
	/** 토큰을 반환한다 */
	private static String getToken(String a_oExpression, int a_nIdx_Start) {
		String oToken = "";
		
		for(int i = a_nIdx_Start; i < a_oExpression.length(); ++i) {
			oToken += a_oExpression.charAt(i);
			
			boolean bIsDigit = i + 1 < a_oExpression.length();
			bIsDigit = bIsDigit && Character.isDigit(a_oExpression.charAt(i));
			bIsDigit = bIsDigit && Character.isDigit(a_oExpression.charAt(i + 1));
			
			// 숫자가 아닐 경우
			if(!bIsDigit) {
				break;
			}
		}
		
		return oToken;
	}
	
	/** 수식 결과를 반환한다 */
	private static double getResult_Calc(String a_oExpression_Postfix) {
		int nIdx = 0;
		Stack<Double> oStackOperands = new Stack<>();
		
		while(nIdx < a_oExpression_Postfix.length()) {
			String oToken = getToken(a_oExpression_Postfix, nIdx);
			nIdx += oToken.length();
			
			// 공백 일 경우
			if(Character.isWhitespace(oToken.charAt(0))) {
				continue;
			}
			
			// 피연산자 일 경우
			if(Character.isDigit(oToken.charAt(0))) {
				double dblOperand = Double.parseDouble(oToken);
				oStackOperands.push(dblOperand);
				
				continue;
			}
			
			double dblRhs = oStackOperands.pop();
			double dblLhs = oStackOperands.pop();
			
			switch(oToken) {
				case "+":
					oStackOperands.push(dblLhs + dblRhs);
					break;
				
				case "-":
					oStackOperands.push(dblLhs - dblRhs);
					break;
				
				case "*":
					oStackOperands.push(dblLhs * dblRhs);
					break;
				
				case "/":
					oStackOperands.push(dblLhs / dblRhs);
					break;
			}
		}
		
		return oStackOperands.pop();
	}
	
	/** 중위 -> 후위 표기법 으로 변환한다 */
	private static String infix_ToPostfix(String a_oExpression_Infix) {
		int nIdx = 0;
		String oExpression_Postfix = "";
		Stack<String> oStackOperators = new Stack<String>();
		
		while(nIdx < a_oExpression_Infix.length()) {
			String oToken = getToken(a_oExpression_Infix, nIdx);
			nIdx += oToken.length();
			
			// 공백 일 경우
			if(Character.isWhitespace(oToken.charAt(0))) {
				continue;
			}
			
			// 피연산자 일 경우
			if(Character.isDigit(oToken.charAt(0))) {
				oExpression_Postfix += String.format("%s ", oToken);
				continue;
			}
			
			// ) 일 경우
			if(oToken.equals(")")) {
				while(!oStackOperators.empty()) {
					String oOperator = oStackOperators.pop();
					
					// ( 일 경우
					if(oOperator.equals("(")) {
						break;
					}
					
					oExpression_Postfix += oOperator;
				}
				
				continue;
			}
			
			while(!oStackOperators.empty()) {
				String oOperator = oStackOperators.pop();
				
				int nPriority_Token = getPriority(oToken, false);
				int nPriority_Operator = getPriority(oOperator, true);
				
				// 토큰 우선 순위가 높을 경우
				if(nPriority_Token < nPriority_Operator) {
					oStackOperators.push(oOperator);
					break;
				}
				
				oExpression_Postfix += oOperator;
			}
			
			oStackOperators.push(oToken);
		}
		
		while(!oStackOperators.empty()) {
			oExpression_Postfix += oStackOperators.pop();
		}
		
		return oExpression_Postfix;
	}
}
