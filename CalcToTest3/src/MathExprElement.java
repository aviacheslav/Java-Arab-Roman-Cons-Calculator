
public class MathExpElement {//Not needed, not used. Instead of it works recursive solver, where only 2 operators and operands
	public int[] operand;
	public int[] operator;
	public int GivenN;
	//public int result;
	public MathExpElement(){}
	{
		operand=new int[4];
		operator=new int[3];
		for(int i=1; i<=3; i++){
			operator[i-1]=0;
		}
		for(int i=1; i<=4; i++){
			operand[i-1]=0;
		}
		GivenN=0;
	}
	public void AddWord(MathWord word){
		//int R=0;
		int TypeN=word.GetTypeN();
		int val=0;
		//val=word.GetValue();//eclipse didn't bother to run prg with thuis err, intelliJ does
		int OperatorOrder; 
		boolean Correct=true;
		switch(GivenN){
			case 0://nil
				if(word.GetIfIsOperatorOf2OPerands()){//but it can't be so
					Correct=false;
					System.out.println("Error! 2-operands operator must not be first in expression!");
				}else if(word.GetIfIsNumber()){
					operand[1-1]=val;
					GivenN++;
				}//else it may be bracket or 1-operand function - for future
			break;
			case 1://1st operand given
				if(word.GetIfIsNumber()){//but it can't be so
					Correct=false;
					System.out.println("Error! Numbers, not divided by operator!");
				}else if(word.GetIfIsOperatorOf2OPerands()){
					operator[1-1]=val;
					GivenN++;
				}//else it may be bracket or 1-operand function - for future
			break;
			case 2://1st operand and 1st operator given
				if(word.GetIfIsOperatorOf2OPerands()){//but it can't be so
					//Correct=false;
					//System.out.println("Error! 2-operands operator after operator");
					//
					//may be as commented. But better let it be simple correction
					//
					System.out.println("Attention! Operator changed! Was N "+Integer.toString(operator[1-1])+" , now is: "+Integer.toString(val));
					operator[1-1]=val;
				}else if(word.GetIfIsNumber()){
					operand[1-1]=val;
					GivenN++;
				}//else it may be bracket or 1-operand function - for future
			break;
			case 3:
					
			break;
			case 4:
				
			break;
			case 5:
					
			break;
			case 6:
					
			break;
			case 7:
						
			break;
		}
		//return R;
	}
	public int MaxOperatorRange(){
		int R=0;
		switch(GivenN){
			case 0:
			
			break;
			case 1:
			
			break;
			case 2:
			
			break;
			case 3:
				
			break;
			case 4:
			
			break;
			case 5:
				
			break;
			case 6:
				
			break;
			case 7:
					
			break;
		}
		return R;
	}
	public int MaxOperandNGiven(){
		int R=0;
		switch(GivenN){
			case 0:
			
			break;
			case 1:
			
			break;
			case 2:
			
			break;
			case 3:
				
			break;
			case 4:
			
			break;
			case 5:
				
			break;
			case 6:
				
			break;
			case 7:
					
			break;
		}
		return R;
	}
	public int GetNGiven(){
		return GivenN;
	}
}
