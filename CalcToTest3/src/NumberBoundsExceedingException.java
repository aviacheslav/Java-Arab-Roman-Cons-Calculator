
public class NumberBoundsExceedingException extends Exception{//Not needed, not used
	//int val;
	//boolean ArabNotRoman;
	private MathWord num;
	public String getNumberAsString(){return this.num.toString();}
    public NumberBoundsExceedingException(String message, MathWord num){
    	 super(message);
    	 try{
    		 this.num=(MathWord)num.clone();
    	 }
    	 catch (CloneNotSupportedException ex){
			System.out.println(ex.getMessage());
		}
    }
}
