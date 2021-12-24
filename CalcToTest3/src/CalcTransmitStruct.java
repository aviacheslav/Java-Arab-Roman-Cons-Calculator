
public class CalcTransmitStruct {
	public int FromN;
	//public int Val;
	public MathWord Val;
	{
		FromN=0;
		//Val=0;
		Val=new MathWord();
		//Val.SetSmart("0", false);
		Val.SetSmart("0");
	}
	public void SetVal(MathWord val){//works well without this method, with simple '='
		try{
			this.Val=(MathWord)val.clone();
		}
		catch(CloneNotSupportedException ex){
			System.out.println(ex.getMessage());
		}
	}
	public MathWord GetVal(){//works well without this method, with simple '='
		MathWord val=null;
		try{
			val=(MathWord)this.Val.clone();
		}
		catch(CloneNotSupportedException ex){
			System.out.println(ex.getMessage());
		}
		return val;
	}
}
