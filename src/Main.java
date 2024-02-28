import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static String arabicToRoman(String number) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII",
                "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII",
                "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
                "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[Integer.parseInt(number) - 1];
    }

    static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException exception) {
            return false;
        }
    }

    public static String calc(String input) throws Exception{
        String resultString = "";
        boolean isRoman = false;

        HashMap<String, Integer> romanToArabic = new HashMap<>();
        romanToArabic.put("I", 1);
        romanToArabic.put("II", 2);
        romanToArabic.put("III", 3);
        romanToArabic.put("IV", 4);
        romanToArabic.put("V", 5);
        romanToArabic.put("VI", 6);
        romanToArabic.put("VII", 7);
        romanToArabic.put("VIII", 8);
        romanToArabic.put("IX", 9);
        romanToArabic.put("X", 10);

        String[] arrayOfElements = input.split(" ");
        if (arrayOfElements.length != 3) {
            throw new Exception();
        }
        else if ((!isInteger(arrayOfElements[0]) && !romanToArabic.containsKey(arrayOfElements[0])) ||
                (!isInteger(arrayOfElements[2]) && !romanToArabic.containsKey(arrayOfElements[2]))) {
            throw new Exception();
        }
        else if (romanToArabic.containsKey(arrayOfElements[0]) ^ romanToArabic.containsKey(arrayOfElements[2])){
            throw new Exception();
        }
        else if (((isInteger(arrayOfElements[0]) && Integer.parseInt(arrayOfElements[0]) < 1) || (isInteger(arrayOfElements[0]) && Integer.parseInt(arrayOfElements[0]) > 10)) ||
        ((isInteger(arrayOfElements[2]) && Integer.parseInt(arrayOfElements[2]) < 1) || (isInteger(arrayOfElements[2]) && Integer.parseInt(arrayOfElements[2]) > 10))) {
            throw new Exception();
        }


        if (romanToArabic.containsKey(arrayOfElements[0])) {
            isRoman = true;
            switch (arrayOfElements[1]){
                case "+": resultString = String.valueOf(romanToArabic.get(arrayOfElements[0]) + romanToArabic.get(arrayOfElements[2])); break;
                case "-": resultString = String.valueOf(romanToArabic.get(arrayOfElements[0]) - romanToArabic.get(arrayOfElements[2])); break;
                case "*": resultString = String.valueOf(romanToArabic.get(arrayOfElements[0]) * romanToArabic.get(arrayOfElements[2])); break;
                case "/": resultString = String.valueOf(romanToArabic.get(arrayOfElements[0]) / romanToArabic.get(arrayOfElements[2])); break;
                default: throw new Exception();
            }

        } else {
            switch (arrayOfElements[1]){
                case "+": resultString = String.valueOf(Integer.parseInt(arrayOfElements[0]) + Integer.parseInt(arrayOfElements[2])); break;
                case "-": resultString = String.valueOf(Integer.parseInt(arrayOfElements[0]) - Integer.parseInt(arrayOfElements[2])); break;
                case "*": resultString = String.valueOf(Integer.parseInt(arrayOfElements[0]) * Integer.parseInt(arrayOfElements[2])); break;
                case "/": resultString = String.valueOf(Integer.parseInt(arrayOfElements[0]) / Integer.parseInt(arrayOfElements[2])); break;
                default: throw new Exception();

            }
        }
        if (isRoman) {
            if (Integer.parseInt(resultString)<=0) throw new Exception();
            resultString = arabicToRoman(resultString);
        }
        return resultString;
    }


    public static void main(String[] args) throws Exception {
        System.out.print("Введите выражение: ");
        Scanner input = new Scanner(System.in);
        String expression = null;
        expression = input.nextLine();
        String answer = calc(expression);
        System.out.print("Ответ: "+ answer);
    }
}