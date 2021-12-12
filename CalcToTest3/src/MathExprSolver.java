import java.util.ArrayList;


public class MathExprSolver {
	public static CalcTransmitStruct Calc(/*String s*/ArrayList<MathWord>expr, int FromN){
		CalcTransmitStruct R=new CalcTransmitStruct(), tr;
		//int FromN=tr.FromN;
		System.out.println("Calc starts working");
		//int operand1=0, operand2=0;
		MathWord TheOperand1=new MathWord(), TheOperand2=new MathWord();
		MathWord TheOperator1=new MathWord(), TheOperator2=new MathWord();
		int exprLen=expr.size();
		String operand1SpecStr;
		//
		TheOperand1=expr.get(FromN-1);
		//
		TheOperator1=expr.get(FromN+1-1);
		//
		System.out.println(" ___operand1= "+TheOperand1.toString()+" = "+Integer.toString(TheOperand1.GetNumberValue()));
		System.out.println(" operator1= "+TheOperator1.toString()+" Priority level: "+Integer.toString(TheOperator1.GetOperatorPriorityLevel()));
		//
		R.FromN=FromN;
		R.Val=TheOperand1;
		while(FromN<=exprLen-2){
			R=CalcPartial(expr, R);
			//operand1=R.Val;
			TheOperand1=R.Val;
			FromN=R.FromN;
			//
			if(FromN==-1){
				System.out.println("Error in expression");
				TheOperand1.SetSmart("0");
				break;
			}else{
				
			}
		}//while
		R.FromN=FromN;
		R.Val=TheOperand1;
		System.out.println("Result="+Integer.toString(TheOperand1.GetNumberValue()));
		System.out.println("FromN="+Integer.toString(FromN));
		System.out.println("Calc finishes working");
		//return operand1;
		return R;
	}//fn
	public static CalcTransmitStruct CalcPartial(ArrayList<MathWord>expr, CalcTransmitStruct tr){
		CalcTransmitStruct R=new CalcTransmitStruct();//, tr;
		int FromN=tr.FromN;
		System.out.println("CalcSimple starts working");
		System.out.println("FromN="+Integer.toString(FromN));
		boolean IsCorrect=true;
		boolean RecursionWasNotDone=true;
		boolean ArabianNotRoman;
		MathWord TheOperand1=new MathWord(), TheOperand2=new MathWord();
		MathWord TheOperator1=new MathWord(), TheOperator2=new MathWord();
		int operand1, operand2, operator1, operator2;
		int operatorLevel1=0, operatorLevel2=0;
		int exprLen=expr.size();
		String operand1S, operator2S;
		//String operand1S, operator1S, operand2S, operator2S="Not defined";
		if(FromN>=1){
			//
			//operand1S=expr.substring(FromN-1, FromN+1-1);
			//operand1=NumVal(operand1S);
			TheOperand1=tr.Val;
			//operand1S=TheOperand1.toString();
			operand1=TheOperand1.GetNumberValue();
			//
			ArabianNotRoman=(TheOperand1.GetTypeN()==Consts.ArabianNumberTypeN);
			//
			TheOperator1=expr.get(FromN+1-1);
			//operator1S=expr.substring(FromN+1-1, FromN+1+1-1);
			operator1=TheOperator1.GetOperatorValue();
			//operator1S=TheOperator1.toString();
			operatorLevel1=TheOperator1.GetOperatorPriorityLevel();
			//System.out.println(" operand1= "+operand1S+" = "+Integer.toString(operand1));
			//System.out.println(" operator1= "+operator1S+" Priority level: "+Integer.toString(operatorLevel1));
			System.out.println(" operand1= "+TheOperand1.toString()+" = "+Integer.toString(TheOperand1.GetNumberValue()));
			System.out.println(" operator1= "+TheOperator1.toString()+" Priority level: "+Integer.toString(operatorLevel1));
			//
			//while(FromN<=exprLen-2){
			TheOperand2=expr.get(FromN+2-1);
			if(ArabianNotRoman){
				TheOperand2.SetSmart(Integer.toString(TheOperand2.GetNumberValue()));
			}else{
				TheOperand2.SetSmart(MathExpressionParsingLib.RomanNumberSmalltoStringByCalculatedValue(TheOperand2.GetNumberValue()));
			}
			//operand2S=expr.substring(FromN+2-1, FromN+2+1-1);
			//operand2S=TheOperand2.toString();
			operand2=TheOperand2.GetOperatorValue();
			//operand2=NumVal(operand2S);
			//operand2.SetSmart(operand2S);
			//operator2S=s.substring(FromN+3-1, FromN+3+1-1);
			//operatorLevel2=OperatorPriorityLevel(operator2S);
			//System.out.println("FromN="+Integer.toString(FromN));
			//System.out.println(" operand1= "+operand1S+" = "+Integer.toString(operand1));
			//System.out.println(" operator1= "+operator1S+" Priority level: "+Integer.toString(operatorLevel1));
			//System.out.println("Previously:  operand2= "+operand2S+" = "+Integer.toString(operand2));
			System.out.println("FromN="+Integer.toString(FromN));
			System.out.println(" operand1= "+TheOperand1.toString()+" = "+Integer.toString(operand1));
			System.out.println(" operator1= "+TheOperator1.toString()+" Priority level: "+Integer.toString(operatorLevel1));
			System.out.println("Previously:  operand2= "+TheOperand2.toString()+" = "+Integer.toString(operand2));
			//
			if(FromN>=exprLen-2){
				//operatorLevel2=0;
				TheOperator2.SetSmart("NOP");
				operatorLevel2=TheOperator2.GetOperatorPriorityLevel();
				operator2=TheOperator2.GetOperatorValue();
				//operator2S=TheOperator2.toString();
				System.out.println("Operand 2 is the last number. There will be no operators after that");
			}else{
				TheOperator2=expr.get(FromN+3-1);
				//operator2S=expr.substring(FromN+3-1, FromN+3+1-1);
				//operatorLevel2=OperatorPriorityLevel(operator2S);
				//operator2S=TheOperator2.toString();
				operatorLevel2=TheOperator2.GetOperatorPriorityLevel();
				operator2=TheOperator2.GetOperatorValue();
				//operatorLevel2=OperatorPriorityLevel(s.substring(FromN+3-1, FromN+3+1-1));
				//System.out.println("Previously: operator2= "+operator2S+" Priority level: "+Integer.toString(operatorLevel2));
				System.out.println("Previously: operator2= "+TheOperator2.toString()+" Priority level: "+Integer.toString(operatorLevel2));
			}
			//if(operatorLevel2>operatorLevel1 && FromN<exprLen-2){
			if(operatorLevel2>operatorLevel1){
				System.out.println("Operator2 has > priority level than operator1. Next level of calc");
				//FromN=FromN+2;
				//tr.FromN=FromN;//works well
				tr.FromN=FromN+2;
				//tr.Val=TheOperand2;//works well
				tr.SetVal(TheOperand2);
				//
				tr=CalcPartial(expr, tr);
				//
				//TheOperand2=tr.Val;//works well
				TheOperand2=tr.GetVal();
				if(ArabianNotRoman){
					TheOperand2.SetSmart(Integer.toString(TheOperand2.GetNumberValue()));
				}else{
					TheOperand2.SetSmart(MathExpressionParsingLib.RomanNumberSmalltoStringByCalculatedValue(TheOperand2.GetNumberValue()));
				}
				operand2=TheOperand2.GetNumberValue();
				//operand2S=Integer.toString(operand2);
				FromN=tr.FromN;
				//System.out.println("CalcSimple next level finished working. FromN="+Integer.toString(FromN));
				//System.out.println("Now:  operand2= "+operand2S+" = "+Integer.toString(operand2));
				//System.out.println("and now:  operand1= "+operand1S+" = "+Integer.toString(operand1));
				//System.out.println("and now: operator1= "+operator1S+" Priority level: "+Integer.toString(operatorLevel1));
				System.out.println("CalcSimple next level finished working. FromN="+Integer.toString(FromN));
				System.out.println("Now:  operand2= "+TheOperand2.toString()+" = "+Integer.toString(operand2));//+"( here occurs smth strange!)");
				System.out.println("and now:  operand1= "+TheOperand1.toString()+" = "+Integer.toString(operand1));
				System.out.println("and now: operator1= "+TheOperator1.toString()+" Priority level: "+Integer.toString(operatorLevel1));
				if(FromN>=exprLen-2){
					//operatorLevel2=0;
					TheOperator2.SetSmart("NOP");
					operatorLevel2=TheOperator2.GetOperatorPriorityLevel();
					operator2=TheOperator2.GetOperatorValue();
					System.out.println("I repeat: operand 2 is the last number. There will be no operators after that");
				}
				//System.out.println("and now: operator2= "+operator2S+" Priority level: "+Integer.toString(operatorLevel2));
				System.out.println("and now: operator2= "+TheOperator2.toString()+" Priority level: "+Integer.toString(operatorLevel2));
				RecursionWasNotDone=false;
			}
			if(operatorLevel2<=operatorLevel1 || FromN<=exprLen-2){
				System.out.println("Operator2 has < priority level than 1, or end of expression");
				try{
					switch(operator1){
					//switch(operatorLevel1){
						case 1://+
							//System.out.println(operand1S+operator1S+operand2S+"=");
							System.out.println(TheOperand1.toString()+TheOperator1.toString()+TheOperand2.toString()+"=");
							operand1=operand1 + operand2;
							System.out.println("="+Integer.toString(operand1));
						break;
						case 2://-
							//System.out.println(operand1S+operator1S+operand2S+"=");
							System.out.println(TheOperand1.toString()+TheOperator1.toString()+TheOperand2.toString()+"=");
							operand1=operand1 - operand2;
							System.out.println("="+Integer.toString(operand1));
						break;
						case 3://*
							//System.out.println(operand1S+operator1S+operand2S+"=");
							System.out.println(TheOperand1.toString()+TheOperator1.toString()+TheOperand2.toString()+"=");
							operand1=operand1 * operand2;
							System.out.println("="+Integer.toString(operand1));
						break;
						case 4:///
							//System.out.println(operand1S+operator1S+operand2S+"=");
							System.out.println(TheOperand1.toString()+TheOperator1.toString()+TheOperand2.toString()+"=");
							operand1=operand1 / operand2;
							System.out.println("="+Integer.toString(operand1));
						break;
						case 5:///
							//System.out.println(operand1S+operator1S+operand2S+"=");
							System.out.println(TheOperand1.toString()+TheOperator1.toString()+TheOperand2.toString()+"=");
							try{
								operand1=PowerNatural(operand1, operand2);
								System.out.println("="+Integer.toString(operand1));
							}
							catch(ArithmeticException ex){
								System.out.println(ex.getMessage());
								IsCorrect=false;
							}
						break;
					}//switch
					System.out.println("operand1="+Integer.toString(operand1));//tried find error
					//
					if(ArabianNotRoman && TheOperand1.GetNumberValue()>Consts.ArabianMaxVal)throw new Exception("Result is greater than maximum for arabian numbers allowed "+Integer.toString(Consts.ArabianMaxVal));
					if(ArabianNotRoman && TheOperand1.GetNumberValue()>Consts.ArabianMaxVal)throw new Exception("Result is greater than minimum arabian numbers allowed "+Integer.toString(Consts.ArabianMinVal));
					if(ArabianNotRoman==false && TheOperand1.GetNumberValue()>Consts.RomanMaxVal)throw new Exception("Result is greater than maximum for arabian numbers allowed "+Integer.toString(Consts.RomanMaxVal));
					if(ArabianNotRoman==false && TheOperand1.GetNumberValue()>Consts.RomanMaxVal)throw new Exception("Result is greater than minimum arabian numbers allowed "+Integer.toString(Consts.RomanMinVal));
					//
					if(ArabianNotRoman){
						operand1S=Integer.toString(operand1);
					}else{
						operand1S=MathExpressionParsingLib.RomanNumberSmalltoStringByCalculatedValue(operand1);
					}
					TheOperand1.SetSmart(operand1S);
					System.out.println("operand1="+Integer.toString(TheOperand1.GetNumberValue()));//tried find error
					operand1=TheOperand1.GetNumberValue();
					System.out.println("operand1="+Integer.toString(operand1));//tried find error
				}//try
				catch(Exception ex){
					System.out.println(ex.getMessage());
					//IsCorrect=false;
					//
					if(ArabianNotRoman && TheOperand1.GetNumberValue()>Consts.ArabianMaxVal)operand1=Consts.ArabianMaxVal;
					if(ArabianNotRoman && TheOperand1.GetNumberValue()>Consts.ArabianMaxVal)operand1=Consts.ArabianMinVal;
					if(ArabianNotRoman==false && TheOperand1.GetNumberValue()>Consts.RomanMaxVal)operand1=Consts.RomanMaxVal;
					if(ArabianNotRoman==false && TheOperand1.GetNumberValue()>Consts.RomanMaxVal)operand1=Consts.RomanMinVal;
					System.out.println("operand1's value is corrected, now it is=="+Integer.toString(operand1));
				}
				System.out.println("operand1="+Integer.toString(operand1));//tried find error
				TheOperand1.SetSmart(Integer.toString(operand1));
				if(ArabianNotRoman){
					TheOperand1.SetSmart(Integer.toString(operand1));
				}else{
					TheOperand1.SetSmart(MathExpressionParsingLib.RomanNumberSmalltoStringByCalculatedValue(operand1));
				}
				System.out.println("operand1="+Integer.toString(TheOperand1.GetNumberValue()));//tried find error
				operand1=TheOperand1.GetNumberValue();
				System.out.println("operand1="+Integer.toString(operand1));//tried find error
				//! So, operand1 val is already calculated
				//
				//operatorLevel1=operatorLevel2;
				try{
					TheOperator1=(MathWord)TheOperator2.clone();
					operator1=TheOperator1.GetOperatorValue();
					operatorLevel1=TheOperator1.GetOperatorPriorityLevel();
				}
				catch (CloneNotSupportedException ex){
					System.out.println(ex.getMessage());
					IsCorrect=false;
				}
				//FromN+=2;
				if(RecursionWasNotDone)FromN+=2;
				//System.out.println("Operand1 now="+operand1S+", operator1 now="+operator1S+" FromN="+Integer.toString(FromN));
				System.out.println("Operand1 now="+TheOperand1.toString()+", operator1 now="+TheOperator1.toString()+" FromN="+Integer.toString(FromN));
			}//if
			//}//while
			if(!IsCorrect){
				System.out.println("Error! Calculaion stopped at "+Integer.toString(FromN)+"th word of math expression");
				FromN=-1;
				TheOperand1.SetSmart("0");
			}
		}//if to work
		R.FromN=FromN;
		//R.Val=TheOperand1;//works well
		R.SetVal(TheOperand1);
		System.out.println("Result="+Integer.toString(TheOperand1.GetNumberValue()));
		System.out.println("(FromN="+Integer.toString(FromN)+")");
		System.out.println("CalcSimple finishes working");
	//return operand1;
	return R;
}//fn
	static int PowerNatural(int x, int p){
		int y=1;
		for(int i=1; i<=p; i++){
			y*=x;
		}
		return y;
	}
}
