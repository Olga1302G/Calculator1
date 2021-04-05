import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public enum RomanNumb {
    I("I",1),II("II", 2), III("III", 3),  IV("IV",4), V("V",5), VI("VI", 6), VII("VII", 7), VIII("VIII", 8 ), IX("IX",9), X("X",10), XL("XL",40), L("L",50), XC("XC",90), C("C",100), CD("CD",400), D("D",500), CM("CM",900), M("M",1000);
     private String key;
    private int value;
     RomanNumb (String key, int value) {
         this.key = key;
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKey(){
        return key;
    }
    public int getValue(){
        return value;
    }

    public static List<RomanNumb> getreversSortvalues(){
        return Arrays.stream(values()).sorted(Comparator.comparing((RomanNumb e)-> e.value).reversed()).collect(Collectors.toList());
           }
    public static int romanToArabic(String string) { String romanNum = string.toUpperCase(); int result = 0;
    List<RomanNumb> romanNumerals = RomanNumb.getreversSortvalues();
    int i = 0;
    while ((romanNum.length() > 0) && (i < romanNumerals.size())) {
        RomanNumb symbol0 = romanNumerals.get(i);
        if (romanNum.startsWith(symbol0.name())) { result += symbol0.getValue();
        romanNum = romanNum.substring(symbol0.name().length()); } else { i++; } }
    if (romanNum.length() > 0) { throw new IllegalArgumentException(string + " cannot be converted to a Roman Numeral"); }
    return result; }
    public static String arabicToRoman(Integer numbs) {
        if ((numbs<=0)||(numbs>4000)){
            throw new IllegalArgumentException(numbs+"не входит в промежуток от 0 до 4000");}
           List <RomanNumb> romanNumer = getreversSortvalues();
           int i =0;
           StringBuilder st = new StringBuilder();
           while ((numbs>0)&&(i<romanNumer.size())){
               RomanNumb symbol = romanNumer.get(i);
               if(symbol.getValue()<=numbs){
                   st.append(symbol.name());
                   numbs -= symbol.getValue();}
               else {i++;}
               }
           return st.toString();
           }

        }

