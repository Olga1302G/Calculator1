public class Calc0 {
    private Integer CalcNumb, CalcNumb1;
    private String CalcOperator;
    public Calc0 (){
        this.CalcNumb = CalcNumb;
        this.CalcNumb1 = CalcNumb1;
        this.CalcOperator = CalcOperator;
    }

    public void setCalcNumb(java.lang.Integer calcNumb) {
        CalcNumb = calcNumb;
    }

    public void setCalcNumb1(Integer calcNumb1) {
        CalcNumb1 = calcNumb1;
    }

    public void setCalcOperator(String calcOperator) {
        CalcOperator = calcOperator;
    }

    public Integer getCalcNumb(){
        return CalcNumb;
    }
    public Integer getCalcNumb1(){
        return CalcNumb1;
    }
    public String getCalcOperator(){
        return CalcOperator;
    }
    public Integer result(Integer a, Integer b, String op) throws ExceptionNotSign {
        Integer res;
        switch (op){
            case "+": res = a+b; break;
            case "-": res = a-b; break;
            case "/": res = a/b; break;
            case "*": res = a*b; break;
            default: throw new  ExceptionNotSign("Не подходящая операция!", op);
        }
        return res;
    }
}
