
public interface Consts {
	public static final boolean ToShowExprParsing=false;//false;
	public static final boolean ToShowNumsParsing=false;//true;
	public static final boolean ToShowCalculating=false;//false;
	public static final boolean ToShowRomanNumsConstr=false;
	//
	public static final int RomanMaxVal=10;//10;
	public static final int RomanMinVal=1;
	public static final int ArabianMaxVal=10;//10;
	public static final int ArabianMinVal=0;
	//
	//types instead of enum
	public static final int ArabianNumberTypeN=1;
	public static final int RomanNumberTypeN=2;
	public static final int OperatorOf2OperandsOf1stPriorityLevel=3;
	public static final int OperatorOf2OperandsOf2ndPriorityLevel=4;
	public static final int OperatorOf2OperandsOf3rdPriorityLevel=5;
	public static final int OperatorOf2OperandsEmpty=6;
	//OPerators of 2 operands instead of enum
	public static final int PlusOperatorN=1;
	public static final int MinusOperatorN=2;
	public static final int MultiplyOperatorN=3;
	public static final int DivideOperatorN=4;
	public static final int PowerOperatorN=5;
	//
	public static final int SysBase=10;
}
