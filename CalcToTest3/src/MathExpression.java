import java.util.ArrayList;

public class MathExpression {
	ArrayList<Integer>  NNS, //Number char N Start
	NNF, //Number char N Fin
	NO,	 //Orerator char N (Start - for this task enough)
	NOF;//Orerator char N Fin - for future multy-char operations: power, sin, log2, lg, ln,...
	//also must be such bounds for brackets
	ArrayList<MathWord>expr;
	public MathExpression(){}
	public MathExpression(String sExt){
		expr=this.SplitToMathWordsByOperands(sExt);
	}
{
	this.NNS=new ArrayList<Integer>();
	this.NNF=new ArrayList<Integer>();
	this.NO=new ArrayList<Integer>();
	this.NOF=new ArrayList<Integer>();
	expr=null;
}
//public void SplitToMathWordsByOperands(String sExt){
public ArrayList<MathWord>SplitToMathWordsByOperands(String sExt){
	if(Consts.ToShowExprParsing)System.out.println("Expression was input: "+sExt);
	MathWord curMathWord=new MathWord(), CurMathWord1;
	String s="";
	String cs;
	boolean Correct=true;
	int ValRoma, ValArab, OperatN, CountRoman=0, CountArab=0, LW, Val=0;
	int LE=sExt.length();
	//
	boolean considerBounds=true;
	//
	for(int i=1; i<=LE; i++){
		cs=sExt.substring(i-1,i-1+1);
		ValRoma=MathExpressionParsingLib.RomanDigitVal(cs);
		ValArab=MathExpressionParsingLib.ArabDigitVal(cs);
		OperatN=MathExpressionParsingLib.OperatorN(cs);
		//ValRoma=this.ArabDigitVal(cs);
		//ValArab=this.ArabDigitVal(cs);
		//OperatN=this.OperatorN(cs);
		//
		if(ValRoma>0)CountRoman++;
		if(ValArab>-1)CountArab++;
		//if(CountRoman>0 && CountArab>0) throw new Exception("Forbidden Mixture of Arabian and Roman Numbers!");
		if(Consts.ToShowExprParsing)System.out.println(cs+" Arab="+Integer.toString(ValArab)+" Roma= "+Integer.toString(ValRoma)+" OperatorN="+Integer.toString(OperatN));
		if(OperatN==0 && ValRoma==0 && ValArab==-1 && !cs.equals(" ")){
			Correct=false;
			System.out.println("Incorrect character!");
		}
		if(CountRoman>0 && CountArab>0){
			Correct=false;
			System.out.println("Forbidden mix of Arabian and Roman digits!");
		}
		//
		if(OperatN>0 || ValRoma>0 || ValArab>-1){
			s=s+cs;
		}
	}
	if(Consts.ToShowExprParsing)System.out.println("Expression without spaces: "+s);
	int L=s.length();//, countOpers;
	for(int i=1; i<=L; i++){
		cs=s.substring(i-1,i-1+1);
		//if(cs.equals("+")||cs.equals("-")||cs.equals("*")||cs.equals("/")){
		//if(cs.equals("+")||cs.equals("-")||cs.equals("*")||cs.equals("/")||cs.equals("^")){
		if(MathExpressionParsingLib.OperatorN(cs)>0){
			if(i==1 || i==L){
				Correct=false;
				if(Consts.ToShowExprParsing)System.out.println("Operator must not be first or last character in math expr!");
			}else if(this.NO.size()>0 && this.NO.get(this.NO.size()-1)==i-1){
				Correct=false;
				System.out.println("Operators must be divided by operands!");
			}else{
				this.NO.add(i); 
				this.NOF.add(i);//not needed for 1-char operators, for future operators
				if(this.NO.size()==1){
					this.NNS.add(1);
				}else{
					//this.NNS.add(this.NO.get(this.NO.size()-1-1)+1);//yes for 1-char length operands 
					this.NNS.add(this.NOF.get(this.NOF.size()-1-1)+1);
				}
				this.NNF.add(i-1);
				if(Consts.ToShowExprParsing)System.out.println("Number: "+Integer.toString(this.NNS.get(this.NNS.size()-1))+" ... "+Integer.toString(this.NNF.get(this.NNF.size()-1)));
			}
		}
		if(i==L){
			this.NNF.add(i);
			if(this.NO.size()==0){
				this.NNS.add(1);
			}else{
				this.NNS.add(this.NO.get(this.NO.size()-1)+1);
			}
			if(Consts.ToShowExprParsing)System.out.println("Last number: "+Integer.toString(this.NNS.get(this.NNS.size()-1))+" ... "+Integer.toString(this.NNF.get(this.NNF.size()-1)));
			if(Consts.ToShowExprParsing)System.out.println("Operators");
		}
	}//for
	for(int i=1; i<=this.NO.size(); i++){
		if(Consts.ToShowExprParsing)System.out.println(Integer.toString(this.NO.get(i-1)));
	}
	//Recognizing and record!
	ArrayList<MathWord>expr=new ArrayList<MathWord>();
	LW=this.NO.size();
	if(Consts.ToShowExprParsing)System.out.println("Words prepared are:");
	cs=s.substring(NNS.get(1-1)-1,NNF.get(1-1)+1-1);
	Val=MathExpressionParsingLib.ArabNumCalc(MathExpressionParsingLib.ArabDigits(cs));
	if(Consts.ToShowExprParsing)System.out.println("First Number: "+cs+" = "+Integer.toString(Val));
	curMathWord.SetSmart(cs);
	try{
		if(CountRoman>0 && CountArab>0) throw new Exception("Forbidden Mixture of Arabian and Roman Numbers!");
		expr.add((MathWord)curMathWord.clone());
	}
	catch(CloneNotSupportedException exc){
		System.out.println(exc.getMessage());
		Correct=false;
	}
	catch(Exception ex){
		System.out.println(ex.getMessage());
		Correct=false;
	}
	////requires try catch
	if(Consts.ToShowExprParsing)System.out.println("First Number: "+cs+" = "+Integer.toString(Val)+ " == "+curMathWord.toString()+ " == "+expr.get(expr.size()-1).toString());
	for(int i=1; i<=LW; i++){
		cs=s.substring(this.NO.get(i-1)-1,this.NOF.get(i-1)+1-1);
		Val=MathExpressionParsingLib.OperatorN(cs);
		curMathWord.SetSmart(cs);
		try{
			expr.add((MathWord)curMathWord.clone());
		}
		catch(CloneNotSupportedException ex){
			System.out.println(ex.getMessage());
			Correct=false;
		}
		if(Consts.ToShowExprParsing)System.out.println("OPerator: "+cs+" N "+Integer.toString(Val)+ " == "+curMathWord.toString()+ " == "+expr.get(expr.size()-1).toString()+" Previous word = "+expr.get(expr.size()-1-1).toString());
		//
		cs=s.substring(NNS.get(i+1-1)-1,NNF.get(i+1-1)+1-1);
		Val=MathExpressionParsingLib.ArabNumCalc(MathExpressionParsingLib.ArabDigits(cs));
		curMathWord.SetSmart(cs);
		try{
			if(curMathWord.GetTypeN()==Consts.ArabianNumberTypeN && curMathWord.GetNumberValue()<Consts.ArabianMinVal){
				throw new NumberExceedsBoundsException("ArabianNumber "+Integer.toString(curMathWord.GetNumberValue())+" is less than allowed minimum "+Integer.toString(Consts.ArabianMinVal));
			}
			if(curMathWord.GetTypeN()==Consts.ArabianNumberTypeN && curMathWord.GetNumberValue()>Consts.ArabianMaxVal){
				throw new NumberExceedsBoundsException("ArabianNumber "+Integer.toString(curMathWord.GetNumberValue())+" is greater than allowed maximum "+Integer.toString(Consts.ArabianMaxVal));
			}
			if(curMathWord.GetTypeN()==Consts.RomanNumberTypeN && curMathWord.GetNumberValue()<Consts.RomanMinVal){
				throw new NumberExceedsBoundsException("RomanNumber "+Integer.toString(curMathWord.GetNumberValue())+" is less than allowed minimum "+Integer.toString(Consts.RomanMinVal));
			}
			if(curMathWord.GetTypeN()==Consts.RomanNumberTypeN && curMathWord.GetNumberValue()>Consts.RomanMaxVal){
				throw new NumberExceedsBoundsException("RomanNumber "+Integer.toString(curMathWord.GetNumberValue())+" is greater than allowed maximum "+Integer.toString(Consts.RomanMaxVal));
			}
			//
			expr.add((MathWord)curMathWord.clone());
		}
		catch(CloneNotSupportedException ex){
			System.out.println(ex.getMessage());
			Correct=false;
		}
		catch(NumberExceedsBoundsException ex1){
			System.out.println(ex1.getMessage());
			System.out.println("Note: number changed!");
			if(curMathWord.GetTypeN()==Consts.ArabianNumberTypeN && curMathWord.GetNumberValue()<Consts.ArabianMinVal){
				curMathWord.SetSmart(Integer.toString(Consts.ArabianMinVal));
			}
			if(curMathWord.GetTypeN()==Consts.ArabianNumberTypeN && curMathWord.GetNumberValue()>Consts.ArabianMaxVal){
				curMathWord.SetSmart(Integer.toString(Consts.ArabianMaxVal));
			}
			if(curMathWord.GetTypeN()==Consts.RomanNumberTypeN && curMathWord.GetNumberValue()<Consts.RomanMinVal){
				curMathWord.SetSmart("I");
			}
			if(curMathWord.GetTypeN()==Consts.RomanNumberTypeN && curMathWord.GetNumberValue()>Consts.RomanMaxVal){
				curMathWord.SetSmart("X");
			}
			System.out.println("Now number is: "+curMathWord.toString()+" = "+Integer.toString(curMathWord.GetNumberValue()));
		}
		if(Consts.ToShowExprParsing)System.out.println("Number: "+cs+" = "+Integer.toString(Val)+ " == "+curMathWord.toString()+ " == "+expr.get(expr.size()-1).toString()+" Previous word = "+expr.get(expr.size()-1-1).toString());
		//
	}
	if(Consts.ToShowExprParsing)System.out.println("Number of words in expr: "+Integer.toString(expr.size()));
	return expr;
}//fn
public ArrayList<MathWord>Get(){return this.expr;}
public void ShowToConsole(){
	System.out.println("Number of words in expr: "+Integer.toString(this.expr.size()));
	System.out.println("Expr, splitted to words: ");
	int count=0;
	for(MathWord word:expr){
		count++;
		System.out.println(Integer.toString(count)+") "+word.toString());
	}
}
}//cl
