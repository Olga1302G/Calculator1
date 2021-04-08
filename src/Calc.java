import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calc  {
       public static void main(String[] args) throws IOException, ExceptionNotSign, NullPointerException {
           Integer numb1 = null, numb2 = null;
           Integer resulted;
           String resultedRom;
           String operator = "";
          boolean repeat = true;
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

           String str = "";

           // String [] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
           //Integer [] number = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
           do { boolean RomanNumbOff = true;
               boolean off = true;
               System.out.println("Введите выражение для расчета (числа от 1 до 10) :");


               str = reader.readLine().trim();
               if (str.contains("+")) {
                   operator = "+";
               } else if (str.contains("-")) {
                   operator = "-";
               } else if (str.contains("/")) {
                   operator = "/";
               } else if (str.contains("*")) {
                   operator = "*";
               } else { repeat = false;
                   throw new ExceptionNotSign("Не подходящая операция", null);
               }
               String str1 = str.substring(0, str.indexOf(operator));
               String str3 = str.substring((str.indexOf(operator) + 1));

                     for (RomanNumb roman : RomanNumb.values()) {
                       String key1 = roman.getKey();
                       if (str1.contains(key1)||str3.contains(key1)){
                           RomanNumbOff = false;
                           }}
                       if(RomanNumbOff==false){

                          try{ numb1 = RomanNumb.romanToArabic(str1);
                           numb2 = RomanNumb.romanToArabic(str3);}
                          catch (IllegalArgumentException e){ repeat = false;
                              System.out.println("Ошибка! Числа должны быть одного формата"); return;}
                           if (numb1 > 10 || numb1 < 0 ) {
                               repeat = false;
                               System.out.println(numb1 + " число не входит в заданный промежуток");
                               return;
                           }
                           if (numb2 > 10 || numb2 < 0) {
                               repeat = false;
                               System.out.println(numb2 + " число не входит в заданный промежуток");
                               return;
                           }
                       }
               if(RomanNumbOff == true){
                   numb1 = Integer.parseInt(str1);
                   if (numb1 > 10 || numb1 < 0) { repeat = false;
                       System.out.println(numb1 + " число не входит в заданный промежуток");
                       return;
                   }
                   numb2 = Integer.parseInt(str3);

                   if (numb2 < 0 || numb2 > 10) { repeat = false;
                       System.out.println(numb2 + " число не входит в заданный промежуток");
                       return;
                   }
               }


               Calc0 calc0 = new Calc0();
               if (numb1 != null && numb2 != null) {
                   resulted = calc0.result(numb1, numb2, operator);
                   //System.out.println(resulted);

               } else { repeat = false;
                   System.out.println("Ошибка! Числа должны быть одного формата");
                   return;
               }
               if ( RomanNumbOff==true) {
                   System.out.println("Результат вычисления равен " + resulted);
               }
               if (RomanNumbOff==false) {
                   resultedRom = RomanNumb.arabicToRoman(resulted);
                   System.out.println("Результат вычисления равен " + resultedRom);
               }
           } while(repeat==true);
       System.out.println("Спасибо! Пока!");
           reader.close();}
              }