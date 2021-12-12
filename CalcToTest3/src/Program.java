
import java.util.ArrayList;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		System.out.printf("");
		Scanner in = new Scanner(System.in);
		String str;
	    str="CXLIX";
		System.out.printf("Example string: %s \n", str);
		System.out.println("Before task - testing roman numbers parser ");
		System.out.print("Input a roman number: ");
	    //int num = in.nextInt();
		//float num=in.nextFloat();
	    str= in.next();
	    ArrayList<Integer>digits=MathExpressionParsingLib.RomanDigits(str,1);
	    //int n=MathExprParser.RomanNumCalc(digits); 
	    int n=MathExpressionParsingLib.RomanNumCalc(digits, 1);
	    //System.out.printf("Your number: %d \n", num);
	    System.out.println();
	    str="8+6+4*3^2+5+7*7 , IX-VI";
		System.out.printf("Example string: %s \n", str);
		System.out.println("Now task ");
		System.out.print("Input arithmetic expression to solve: ");
		str = in.next();
		in.close();
		//MathExpression ME=new MathExpression();//
		//ArrayList<MathWord>expr=ME.SplitToMathWordsByOperands(str);//work well
		//ArrayList<MathWord>expr=null;
		MathExpression mExpr=new MathExpression(str);
		//expr=ME.Get();
		//System.out.println();
		//System.out.println("Program: Number of words in expr: "+Integer.toString(expr.size()));
		//System.out.println("Expr, splitted to words: ");
		//for(MathWord word:expr){
		//	System.out.println(word.toString());
		//}
		//System.out.println("Or: ");
		//for(int i=1; i<=expr.size(); i++){
		//	System.out.println(Integer.toString(i)+") "+expr.get(i-1).toString());
		//}
		mExpr.ShowToConsole();
		System.out.println();
		int FromN=1;
		CalcTransmitStruct R=MathExprSolver.Calc(mExpr.Get(), FromN);
		System.out.println("RESULT="+R.Val.toString());
	}

}
