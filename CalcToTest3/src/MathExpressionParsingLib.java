import java.util.ArrayList;


public class MathExpressionParsingLib {
	public static int RomanDigitVal(String s){
		if(Consts.ToShowNumsParsing)System.out.println("RomanDigitVal starts working");
		int R=0;
		//try{
			if(s.equals("I")){
				R=1;
				if(Consts.ToShowNumsParsing)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("V")){
				R=5;
				if(Consts.ToShowNumsParsing)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("X")){
				R=10;
				if(Consts.ToShowNumsParsing)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("L")){
				R=50;
				if(Consts.ToShowNumsParsing)System.out.println(s+" -> "+Integer.toString(R));
			}else if(s.equals("C")){
				R=100;
				if(Consts.ToShowNumsParsing)System.out.println(s+" -> "+Integer.toString(R));
			}else{
				if(Consts.ToShowNumsParsing)System.out.println(s+" - unknown character");
			}
			//if(R<Consts.RomanMinVal)throw new Exception("Roman number is less than minimum "+Integer.toString(Consts.RomanMinVal));
			//if(R>Consts.RomanMaxVal)throw new Exception("Roman number is greater than maximum "+Integer.toString(Consts.RomanMaxVal));
		//}
		//catch(Exception ex){
		//	System.out.println(ex.getMessage());
		//	R=Consts.RomanMinVal;
		//}
		if(Consts.ToShowNumsParsing)System.out.println("RomanDigitVal finishe working");
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

	public static int ArabNumCalc(ArrayList<Integer> digits){
		int R=0;//, SysBase=10;
		//try {
			for (int i = 1; i <= digits.size(); i++) {
				R = R * Consts.SysBase + digits.get(i - 1);
			}
			//if()
		//}
		//catch(Exception ex){

		//}
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
	public static ArrayList<Integer> RomanDigits(String s){
		ArrayList<Integer>digits=new ArrayList<Integer>();
		String cs;
		int curDigit;
		if(Consts.ToShowNumsParsing)System.out.printf(" RomanDigits starts working\n");
		for(int i=1; i<=s.length(); i++){
			cs=s.substring(i-1,i+1-1);
			curDigit=RomanDigitVal(cs);
			//System.out.printf("Char: %s, Digit= %d \n,",cs,curDigit);
			if(Consts.ToShowNumsParsing)System.out.println(Integer.toString(i)+") Char: "+cs+" Digit= "+Integer.toString(curDigit));
			digits.add(curDigit);
		}
		if(Consts.ToShowNumsParsing)System.out.printf(" RomanDigits finishes working\n");
		return digits;
	}//fn
	public static ArrayList<Integer> ArabDigits(String s){
		ArrayList<Integer>R=new ArrayList<Integer>();
		int L=s.length(), curDigit;
		String cs;
		boolean Correct=true;
		for(int i=1; i<=L; i++){
			cs=s.substring(i-1,i+1-1);
			curDigit=ArabDigitVal(cs);
			if(curDigit==-1){
				Correct=false;
				if(Consts.ToShowNumsParsing)System.out.println("Wrong arab digit: "+cs);
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
	public static boolean IsOrderMarker(String s){
		return (s.equals("E")|| s.equals("e")|| s.equals("@"));
	}
	public static String RomanNumberConstructor(int value){
		String s="";
		int DigSetN;
		int x=value, DefdPart, MaxOperDig, MinBoundDig, MaxBoundDig, ActOperDigN, ActOperDigInSetN, QCurrentDigits;
		String 	 MaxOperDigS, MinBoundDigS, MaxBoundDigS, DefdPartS="";
		int[]DigitOfBounds={1, 5, 10, 50, 100, 400};
		int[]DigitToOperate={1, 10, 100};
		String[]DigitsChars={"I", "V", "X", "L", "C"};
		//
		if(Consts.ToShowRomanNumsConstr)System.out.println("RomanNumberConstructor starts working");
		//
		if(x>DigitOfBounds[DigitOfBounds.length-1] ){
			s="Too many";
			if(Consts.ToShowRomanNumsConstr)System.out.println(s);
		}else if(x<DigitOfBounds[1-1] ){
			s="Too few";
			if(Consts.ToShowRomanNumsConstr)System.out.println(s);
		}else{
			while(x>0) {
				if (Consts.ToShowRomanNumsConstr) System.out.println("External cycle: x=" + Integer.toString(x));
				//1) def bounds
				DigSetN = 6;
				while (!(x >= DigitOfBounds[DigSetN - 1 - 1] && x < DigitOfBounds[DigSetN - 1])) {
					DigSetN--;
					if (Consts.ToShowRomanNumsConstr) System.out.println("DigSetN=" + Integer.toString(DigSetN));
				}
				MinBoundDig = DigitOfBounds[DigSetN - 1 - 1];
				MaxBoundDig = DigitOfBounds[DigSetN - 1];
				MinBoundDigS = DigitsChars[DigSetN - 1 - 1];
				if (DigSetN == 6) MaxBoundDigS = "400";
				else MaxBoundDigS = DigitsChars[DigSetN - 1];
				if (Consts.ToShowRomanNumsConstr)System.out.println("bounds found: " + MinBoundDigS + "<=" + Integer.toString(x) + "<" + MaxBoundDigS);
				//2) def nearest oper digit
				ActOperDigN = DigitToOperate.length;
				while (DigitToOperate[ActOperDigN - 1] > MinBoundDig) {
					ActOperDigN--;
				}
				MaxOperDig = DigitToOperate[ActOperDigN - 1];
				//MaxOperDigS = Integer.toString(MaxOperDig);
				if (Consts.ToShowRomanNumsConstr) System.out.println("MaxOperDig= " + Integer.toString(MaxOperDig));
				//2/2 finding fitting char for this digit
				ActOperDigInSetN = 1;
				while (DigitOfBounds[ActOperDigInSetN - 1] < MaxOperDig) {
					if (Consts.ToShowRomanNumsConstr)System.out.println(Integer.toString(MaxOperDig) + "<" + "DigitOfBounds(" + Integer.toString(ActOperDigInSetN) + ")=" + Integer.toString(DigitOfBounds[ActOperDigInSetN - 1]));
					ActOperDigInSetN++;
				}
				MaxOperDig = DigitOfBounds[ActOperDigInSetN - 1];
				//MaxOperDigS = Integer.toString(MaxOperDig);
				MaxOperDigS = DigitsChars[ActOperDigInSetN - 1];;
				if (Consts.ToShowRomanNumsConstr) System.out.println("Checking: MaxOperDig= " + MaxOperDigS);
				//3) Def Q digits - 2 vrns
				DefdPart = 0;
				if (x == 0) {
					if (Consts.ToShowRomanNumsConstr) System.out.println("Whole nuber defined: " + s);
				}
				if (MaxOperDig < MinBoundDig && x >= MinBoundDig && x < MinBoundDig + 4 * MaxOperDig) {
					if (Consts.ToShowRomanNumsConstr) {
						System.out.println(MaxOperDigS + " < " + MinBoundDigS + " and");
						System.out.println(MinBoundDigS + " <= " + Integer.toString(x) + " < " + MinBoundDigS + " + 4 * " + MaxOperDigS);
					}
					DefdPart = MinBoundDig;
					DefdPartS = MinBoundDigS;
					s = s + DefdPartS;
					x -= DefdPart;
					if (Consts.ToShowRomanNumsConstr)System.out.println("DefdPartS=" + DefdPartS + "s= " + s + " x=" + Integer.toString(x));
					if (x == 0) {
						if (Consts.ToShowRomanNumsConstr) System.out.println("Whole number defined");
					}
				} else if (x > 0) { //else vrn 2: if MaxOperDig==MinBoundDig ( & x>0)
					if (Consts.ToShowRomanNumsConstr)
						System.out.println("Defining rest part of number, using operating digit " + MaxOperDigS);
					QCurrentDigits = 4;
					while (MaxOperDig * QCurrentDigits > x) {
						QCurrentDigits--;
					}
					if (QCurrentDigits == 4) {
						if (Consts.ToShowRomanNumsConstr)
							System.out.println(Integer.toString(x) + ">" + Integer.toString(4 * MaxOperDig));
						DefdPart = DefdPart + (MaxBoundDig - MaxOperDig);
						DefdPartS = DefdPartS + MaxOperDigS;
						DefdPartS = DefdPartS + MaxBoundDigS;
						s = s + DefdPartS;
						if (Consts.ToShowRomanNumsConstr) System.out.println("_DefdPart=" + DefdPartS);
					} else {
						if (Consts.ToShowRomanNumsConstr) System.out.println("Part of number defined: " + s);
						DefdPart = DefdPart + QCurrentDigits * MaxOperDig;
						for (int i = 1; i <= QCurrentDigits; i++) {
							DefdPartS = DefdPartS + MaxOperDigS;
						}
						s = s + DefdPartS;
						if (Consts.ToShowRomanNumsConstr) System.out.println("DefdPart_=" + DefdPartS);
					}
					if (Consts.ToShowRomanNumsConstr) System.out.println("Part of num defined=" + DefdPartS);
					x = x - DefdPart;
					if (Consts.ToShowRomanNumsConstr) System.out.println("x= " + Integer.toString(x));
					if (x == 0 && Consts.ToShowRomanNumsConstr) System.out.println("Whole number defined");
				}//if x>0, else NOp
				DefdPartS="";
			}//while,ext cycle lasts
		}//if x is within awllowed range
		if (Consts.ToShowRomanNumsConstr) System.out.println("Result= " + Integer.toString(value)+" = "+s+"( rest="+Integer.toString(x)+")");
		if (Consts.ToShowRomanNumsConstr) System.out.println("RomanNumberConstructor finishes working");
		return s;
	}//fn
}//cl
