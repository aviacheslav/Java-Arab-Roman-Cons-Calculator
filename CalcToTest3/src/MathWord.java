
public class MathWord  implements Cloneable{
	//boolean OperandNotOperator;
	//boolean RomanNotArabian;
	String content;
	int value;
	int TypeN;
	//0 - not defined
	//1- number, arabic digits
	//2 - number, roman digits
	//3 - 2-operands operator, 1st priority level (+,-)
	//4 - 2-operands operator, 2nd priority level (*,/)
	//5 - 2-operands operator, 2nd priority level (^, root, log)
	//6 - empty operator
	//operators of 1 operand, brackets
	public MathWord(){
		this.TypeN=0;
		this.value=0;
		this.content="";
		//this.RomanNotArabian=false;
	}
	public MathWord(String content/*, boolean ConsiderBounds*/){
		this.content=content;
		this.SetSmart(content/*, ConsiderBounds*/);
	}
	//public void Set(String content, int TypeN, boolean RomanNotArabian, int value){
	//	this.TypeN=TypeN;
	//	this.value=value;
	//	this.content=content;
	//	this.RomanNotArabian=RomanNotArabian;
	//}
	//public void Set(String content, int TypeN, int value){
	//	this.TypeN=TypeN;
	//	this.value=value;
	//	this.content=content;
	//	//this.RomanNotArabian=RomanNotArabian;
	//}
	public void SetSmart(String content, boolean considerBounds){
		this.content=content;
		//this.value=0;
		this.value=MathExpressionParsingLib.OperatorN(content);
		if(content.equals("NOP")){
			this.value=0;
			this.TypeN=Consts.OperatorOf2OperandsEmpty;
		}else if(this.value!=0){
			switch(this.value){
				case Consts.PlusOperatorN:
				case Consts.MinusOperatorN:
					this.TypeN=Consts.OperatorOf2OperandsOf1stPriorityLevel;
				break;
				case Consts.MultiplyOperatorN:
				case Consts.DivideOperatorN:
					this.TypeN=Consts.OperatorOf2OperandsOf2ndPriorityLevel;
				break;
				case Consts.PowerOperatorN: //power
				case 6: //future root
				case 7: //future log
					this.TypeN=Consts.OperatorOf2OperandsOf3rdPriorityLevel;
				break;
			}
		}else{
			this.value=MathExpressionParsingLib.RomanNumCalc(MathExpressionParsingLib.RomanDigits(content),0);
			if(this.value>0){
				this.TypeN=Consts.RomanNumberTypeN;
				//even if it is too big roman number, it is roman number, though it will be made less
				//so it is before try-catch
				//for less than 1 no digits in roman system
				//this exception will be handled not here, but during calculations
				try{
					if(this.value>Consts.RomanMaxVal && considerBounds) throw new Exception("Roman number is greater than maximum allowed");
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
					this.value=Consts.RomanMaxVal;
				}
			}
		}
		if(this.value==0){
			this.value=MathExpressionParsingLib.ArabNumCalc(MathExpressionParsingLib.ArabDigits(content));
			if(content.substring(1-1, 1+1-1).equals("-")){
				this.value=this.value*(-1);
			}
			this.TypeN=Consts.ArabianNumberTypeN;
			//try{
			//	if(this.value>Consts.ArabianMaxVal /*&& considerBounds*/) throw new Exception("Arabian number is greater than maximum allowed");
			//	if(this.value<Consts.ArabianMinVal /*&& considerBounds*/) throw new Exception("Arabian number is less than minimum allowed");
			//}
			//catch(Exception ex){
			//	System.out.println(ex.getMessage());
			//	if(this.value>Consts.ArabianMaxVal)this.value=Consts.ArabianMaxVal;
			//	if(this.value<Consts.ArabianMinVal)this.value=Consts.ArabianMinVal;
			//}
		}
	}
	public void SetSmart(String content){
		SetSmart(content, false);
	}
	//
	//public void SetByNumberVal(int val, boolean considerBounds){
	//	SetSmart(Integer.toString(val), considerBounds);
	//}
	//public void SetByNumberVal(int val){
	//	SetSmart(Integer.toString(val));
	//}
	//
	public boolean GetIfIsNumber(){return (TypeN==Consts.ArabianNumberTypeN || TypeN==Consts.RomanNumberTypeN);}
	public boolean GetIfIsOperatorOf2OPerands(){return (TypeN==Consts.OperatorOf2OperandsOf1stPriorityLevel || TypeN==Consts.OperatorOf2OperandsOf2ndPriorityLevel || TypeN==Consts.OperatorOf2OperandsOf3rdPriorityLevel);}
	public int GetOperatorPriorityLevel(){
		int R=0;
		switch(this.TypeN){
			case Consts.OperatorOf2OperandsOf1stPriorityLevel:
				R=1;
			break;
			case Consts.OperatorOf2OperandsOf2ndPriorityLevel:
				R=2;
			break;
			case Consts.OperatorOf2OperandsOf3rdPriorityLevel:
				R=3;
			break;
			//
			case Consts.OperatorOf2OperandsEmpty:
				R=0;
			break;
		}
		return R;
	}
	public int GetTypeN(){return this.TypeN;}
	//public int GetValue(){return this.value;}
	public int GetNumberValue(){return this.value;}
	public int GetOperatorValue(){return this.value;}
	@Override
	public String toString(){
		String s;
		s=this.content;
		return s;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
