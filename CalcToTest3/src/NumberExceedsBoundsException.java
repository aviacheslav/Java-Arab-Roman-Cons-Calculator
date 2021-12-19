public class NumberExceedsBoundsException  extends Exception{
    //String Msg;
    public NumberExceedsBoundsException(String Msg){
        //int TypeN=mathWord.GetTypeN();
        //int value=mathWord.GetNumberValue();
        //if(TypeN==Consts.ArabianNumberTypeN && value < Consts.ArabianMinVal){
        //    Msg="Arabian number "+Integer.toString(value)+" is less than allowed minimum " +Integer.toString(Consts.ArabianMinVal);
        //}
        //if(TypeN==Consts.ArabianNumberTypeN && value > Consts.ArabianMaxVal){
        //    Msg="Arabian number "+Integer.toString(value)+" is greater than allowed maximum " +Integer.toString(Consts.ArabianMaxVal);
        //}
        //if(TypeN==Consts.RomanNumberTypeN && value < Consts.RomanMinVal){
        //    Msg="Roman number "+Integer.toString(value)+" is less than allowed minimum " +Integer.toString(Consts.RomanMinVal);
       // }
        //if(TypeN==Consts.RomanNumberTypeN && value > Consts.RomanMaxVal){
        //    Msg="Roman number "+Integer.toString(value)+" is greater than allowed maximum " +Integer.toString(Consts.RomanMaxVal);
        //}
        super(Msg);//error: cannot reference Msg before super constructor called. So what for to create new class, if it can do nothing?!
    }

}
