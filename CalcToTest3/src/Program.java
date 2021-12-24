
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner in = new Scanner(System.in);
		String str;
	    int rNum;
		ArrayList<Integer>digits=MathExpressionParsingLib.RomanDigits(str);
	    //for(int i=1; i<=399; i++){
		//	rNum=i;
		//	//rNum=379;
		//	str=MathExpressionParsingLib.RomanNumberConstructor(rNum);
		//	System.out.println("Roman nuber: "+Integer.toString(rNum)+" = "+str);
		//}
		//System.out.println("This was testing roman numbers constructor before task ");
	    //System.out.println();
	    //str="8+6+4*3^2+5+7*7 , IX-VI";
		//System.out.printf("Example string: %s \n", str);
		//System.out.println("Now task ");
		System.out.print("Input arithmetic expression to solve: ");
		str = in.next();
		in.close();
		MathExpression mExpr=new MathExpression(str);
		if(Consts.ToShowExprParsing)mExpr.ShowToConsole();
		if(Consts.ToShowExprParsing)System.out.println();
		int FromN=1;
		boolean ToShow=false;
		CalcTransmitStruct R=MathExprSolver.Calc(mExpr.Get(), FromN);
		System.out.println("RESULT="+R.Val.toString());
	}

}
