public class ExceptionNotSign extends Exception{
    private String sign;
    public String getSign(){return sign;}
    public ExceptionNotSign(String message, String sign1){
        super(message);
        sign = sign1;
    }
}
