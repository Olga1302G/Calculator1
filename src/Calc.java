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
           boolean RomanNumbOff = true;
           boolean off = true;
           String str = "";
           // String [] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
           //Integer [] number = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
           System.out.println("Введите выражение для расчета (числа от 1 до 10) :");
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

               str = reader.readLine().trim();
                if (str.contains("+")) {
                   operator = "+";
               } else if (str.contains("-")) {
                   operator = "-";
               } else if (str.contains("/")) {
                   operator = "/";
               } else if (str.contains("*")) {
                   operator = "*";
               } else {
                   throw new ExceptionNotSign("Не подходящая операция", null);
               }
               String str1 = str.substring(0, str.indexOf(operator));
               String str3 = str.substring((str.indexOf(operator) + 1));

               if (off == true) {
                   for (RomanNumb roman : RomanNumb.values()) {
                       String key1 = roman.getKey();
                       if (str1.contains(roman.getKey())) {
                           numb1 = roman.romanToArabic(str1);
                           RomanNumbOff = false;
                           if (numb1 > 10 || numb1 < 0) {
                               System.out.println(numb1 + " число не входит в заданный промежуток");
                               return;
                           }
                       } else {
                           off = false;
                       }
                   }
                   for (RomanNumb roman : RomanNumb.values()) {
                       if (str3.contains(roman.getKey())) {
                           numb2 = roman.romanToArabic(str3);
                           RomanNumbOff = false;
                           if (numb2 > 10 || numb2 < 0) {
                               System.out.println(numb2 + " число не входит в заданный промежуток");
                               return;
                           }
                       } else {
                           off = false;
                       }
                   }
               }
               if (RomanNumbOff == true) {
                   numb1 = Integer.parseInt(str1);
                   numb2 = Integer.parseInt(str3);
                   if (numb1 > 10 || numb1 < 0) {
                       System.out.println(numb1 + " число не входит в заданный промежуток");
                       return;
                   }
                   if (numb2 < 0 || numb2 > 10) {
                       System.out.println(numb2 + " число не входит в заданный промежуток");
                       return;
                   }
               }
              reader.close();
               Calc0 calc0 = new Calc0();
               if (numb1 != null && numb2 != null) {
                   resulted = calc0.result(numb1, numb2, operator);
                   System.out.println(resulted);
                   if (RomanNumbOff == true) {
                       System.out.println("Результат вычисления равен " + resulted);
                   }
                   if (RomanNumbOff == false) {
                       resultedRom = RomanNumb.arabicToRoman(resulted);
                       System.out.println("Результат вычисления равен " + resultedRom);
                   }
               } else {
                   System.out.println("Ошибка! Числа должны быть одного формата");return;
               }

           }
              }