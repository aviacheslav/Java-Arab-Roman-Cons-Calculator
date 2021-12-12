import java.util.ArrayList;


public class MathExpressionParsingLib {
	public static int RomanDigitVal(String s, int Show1Hide0){
		if(Show1Hide0==1)System.out.println("RomanDigitVal starts working");
		int R=0;
		//try{
			if(s.equals("I")){
				R=1;
				if(Show1Hide0==1)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("V")){
				R=5;
				if(Show1Hide0==1)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("X")){
				R=10;
				if(Show1Hide0==1)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("L")){
				R=50;
				if(Show1Hide0==1)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("C")){
				R=100;
				if(Show1Hide0==1)System.out.println(s+" -> "+Integer.toString(R));
			}else{
				if(Show1Hide0==1)System.out.println(s+" - unknown character");
			}
			//if(R<Consts.RomanMinVal)throw new Exception("Roman number is less than minimum "+Integer.toString(Consts.RomanMinVal));
			//if(R>Consts.RomanMaxVal)throw new Exception("Roman number is greater than maximum "+Integer.toString(Consts.RomanMaxVal));
		//}
		//catch(Exception ex){
		//	System.out.println(ex.getMessage());
		//	R=Consts.RomanMinVal;
		//}
		if(Show1Hide0==1)System.out.println("RomanDigitVal finishe working");
		return R;
	}
	
	public static int OperatorN(String s){
		int R=0;
		if(s.equals("+"))R=1;
		else if(s.equals("-"))R=2;
		else if(s.equals("*"))R=3;
		else if(s.equals("/"))R=4;
		else if(s.equals("^"))R=5;
		return R;
	}
	public static int RomanNumberValPrimitive(String s){//Not used, but could be used, because task is too simple
		int R=0;
		if(s.equals("I"))R=1;
		if(s.equals("II"))R=2;
		if(s.equals("III"))R=3;
		else if(s.equals("IV"))R=4;
		else if(s.equals("V"))R=5;
		else if(s.equals("VI"))R=6;
		else if(s.equals("VII"))R=7;
		else if(s.equals("VIII"))R=8;
		else if(s.equals("IX"))R=8;
		else if(s.equals("X"))R=10;
		else if(s.equals("L"))R=50;
		else if(s.equals("C"))R=100;
		return R;
	}
	public static int ArabDigitVal(String s){
		int R=-1;
		if(s.equals("0"))R=0;
		else if(s.equals("1"))R=1;
		else if(s.equals("2"))R=2;
		else if(s.equals("3"))R=3;
		else if(s.equals("4"))R=4;
		else if(s.equals("5"))R=5;
		else if(s.equals("6"))R=6;
		else if(s.equals("7"))R=7;
		else if(s.equals("8"))R=8;
		else if(s.equals("9"))R=9;
		return R;
	}
	public static int ArabNumberValPrimitive(String s){//Not used, but could be used, because task is too simple
		int R=-1;
		if(s.equals("0"))R=0;
		else if(s.equals("1"))R=1;
		else if(s.equals("2"))R=2;
		else if(s.equals("3"))R=3;
		else if(s.equals("4"))R=4;
		else if(s.equals("5"))R=5;
		else if(s.equals("6"))R=6;
		else if(s.equals("7"))R=7;
		else if(s.equals("8"))R=8;
		else if(s.equals("9"))R=8;
		else if(s.equals("10"))R=10;
		return R;
	}
	public static int ArabNumCalc(ArrayList<Integer> digits){
		int R=0, SysBase=10;
		for(int i=1; i<=digits.size(); i++){
			R=R*SysBase+digits.get(i-1);
		}
		return R;
	}
	public static int RomanNumCalc(ArrayList<Integer> digits, int Show1Hide0){//, TValsShowHide vsh)
    
        int countI=0;
        boolean Correct=true;
		int R = 0;
        int i = 0;
        int CurDigit = 0, NextDigit=0, PrevDigit=0;// CurDigitN = 0;
        if(Show1Hide0==1)System.out.println("RomanNumCalc starts working");
        int L = digits.size();
        if(Show1Hide0==1)System.out.println("Given quantity of digits: " + Integer.toString(digits.size()) + "=" + Integer.toString(L));
        //for(int i=1; i<=digits.size(); i++){
        //try{
        	if (L == 1) R = digits.get(L - 1);
        	else        	{
        		PrevDigit=0;
            	i=1;
            	while(i<=L)
            	{
                	CurDigit = digits.get(i - 1);
                	if(i<L)NextDigit = digits.get(i +1- 1);
                	else NextDigit = 0;
                	//
                	if(
                			(CurDigit==5 && NextDigit==10)
                			||
                			(CurDigit==50 && NextDigit==100)
                		)
                	{
                		Correct=false;
                		if(Show1Hide0==1)System.out.println("Unsufficient pair of roman digits");
                	}
                	if(CurDigit==1)countI++;
                	if(NextDigit==1)countI++;
                	if( 
                		(CurDigit>1 || NextDigit>1) && countI>1
                		)
                	{
                		Correct=false;
                		if(Show1Hide0==1)System.out.println("too many 'I's in roman number");
                	}
                	//
                	if (NextDigit == CurDigit){
                    	R += CurDigit;
                    	R += NextDigit;
                    	if(Show1Hide0==1)System.out.println("ND=CD N " + Integer.toString(i) + " (of " + Integer.toString(L) + ") CurDigit" + " = " + Integer.toString(digits.get(i - 1)) + " NextDigit= " + Integer.toString(NextDigit) + " num= " + Integer.toString(R));
                    	i+=2;
                	}
                	else if (NextDigit > CurDigit)
                	{
                    	R += (NextDigit - CurDigit);
                    	if(Show1Hide0==1)System.out.println("ND>CDN " + Integer.toString(i) + " (of " + Integer.toString(L) + ") CurDigit" + " = " + Integer.toString(digits.get(i - 1)) + " NextDigit= " + Integer.toString(NextDigit) + " num= " + Integer.toString(R));
                    	i += 2;
                	}
                	else//(NextDigit < CurDigit => waiting
                	{
                    	R += CurDigit;
                    	if(Show1Hide0==1)System.out.println("ND>CDN " + Integer.toString(i) + " (of " + Integer.toString(L) + ") CurDigit" + " = " + Integer.toString(digits.get(i - 1)) + " NextDigit= " + Integer.toString(NextDigit) + " num= " + Integer.toString(R));
                    	i++;
                	}
            	}//while
        	}//if possible to work
        	//if(R<Consts.ArabianMinVal) throw new NumberBoundsExceedingException("Arabian number is less than minimum for arabian numbers "+Integer.toString(Consts.ArabianMinVal),new MathWord(Integer.toString(R)));
        	//if(R<Consts.RomanMinVal) throw new Exception("Roman number is less than minimum for arabian numbers "+Integer.toString(Consts.RomanMinVal));
        	//if(R>Consts.RomanMaxVal) throw new Exception("Roman number is greater than maximum for arabian numbers "+Integer.toString(Consts.RomanMaxVal));
        //}
        //catch(Exception ex){
        //	System.out.println(ex.getMessage());
        //	R=Consts.RomanMinVal;
        //}
        return R;
    }//fn
	public static ArrayList<Integer> RomanDigits(String s, int Show1Hide0){
		ArrayList<Integer>digits=new ArrayList<Integer>();
		String cs;
		int curDigit;
		if(Show1Hide0==1)System.out.printf(" RomanDigits starts working\n");
		for(int i=1; i<=s.length(); i++){
			cs=s.substring(i-1,i+1-1);
			curDigit=RomanDigitVal(cs, Show1Hide0);
			//System.out.printf("Char: %s, Digit= %d \n,",cs,curDigit);
			if(Show1Hide0==1)System.out.println(Integer.toString(i)+") Char: "+cs+" Digit= "+Integer.toString(curDigit));
			digits.add(curDigit);
		}
		if(Show1Hide0==1)System.out.printf(" RomanDigits finishes working\n");
		return digits;
	}//fn
	public static ArrayList<Integer> ArabDigits(String s, int Show1Hide0){
		ArrayList<Integer>R=new ArrayList<Integer>();
		int L=s.length(), curDigit;
		String cs;
		boolean Correct=true;
		for(int i=1; i<=L; i++){
			cs=s.substring(i-1,i+1-1);
			curDigit=ArabDigitVal(cs);
			if(curDigit==-1){
				Correct=false;
				if(Show1Hide0==1)System.out.println("Wrong arab digit: "+cs);
			}else{
				R.add(curDigit);
			}
		}
		return R;
	}//fn
	public static String RomanNumberSmalltoStringByCalculatedValue(int x){
		String R="#";
		switch(x){
			case 1:
				R="I";
			break;
			case 2:
				R="II";
			break;
			case 3:
				R="III";
			break;
			case 4:
				R="IV";
			break;
			case 5:
				R="V";
			break;
			case 6:
				R="VI";
			break;
			case 7:
				R="VII";
			break;
			case 8:
				R="VIII";
			break;
			case 9:
				R="IX";
			break;
			case 10:
				R="X";
			break;
		}
		return R;
	}
	//public static String GetStringDigit(int n){
	//	String s="";
	//	switch(n){
	//		case 0:
	//			s="0";
	//		break;
	//		case 1:
	//			s="1";
	//		break;
	//		case 2:
	//			s="2";
	//		break;
	//		case 3:
	//			s="3";
	//		break;
	//		case 4:
	//			s="4";
	//		break;
	//		case 5:
	//			s="5";
	//		break;
	//		case 6:
	//			s="6";
	//		break;
	//		case 7:
	//			s="7";
	//		break;
	//		case 8:
	//			s="8";
	//		break;
	//		case 9:
	//			s="9";
	//		break;
	//	}
	//	return s;
	//}
	//public static String GetStringOperator(int n){
	//	String s="";
	//	switch(n){
	//		case 1:
	//			s="+";
	//		break;
	//		case 2:
	//			s="-";
	//		break;
	//		case 3:
	//			s="*";
	//		break;
	//		case 4:
	//			s="/";
	//		break;
	//	}
	//	return s;
	//}
}
