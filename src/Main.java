import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        CheckSpelling checkNumber = new CheckSpelling();
        int[] digitalArrayInputString = checkNumber.digitalArrayInputString(inputString);
        String compressedInputString = checkNumber.compressed(inputString);//Спрессованная строка
        int[] arrayInputString = new int[compressedInputString.length() + 3];
        try {
            arrayInputString = checkNumber.checkInputString1(arrayInputString, compressedInputString);
            arrayInputString = checkNumber.checkInputString2(arrayInputString, compressedInputString);
            int positionMath = checkNumber.positionMathOperatorInputString(arrayInputString, inputString);
            checkNumber.checkInputString3(digitalArrayInputString, positionMath);
            String operations = "";
            String[] words;
            operations += inputString.charAt(positionMath);
            if (operations.equals("+"))
                words = compressedInputString.split("\\+");
            else if (operations.equals("*"))
                words = compressedInputString.split("\\*");
            else words = compressedInputString.split(operations);
            Translator translator = new Translator(words);
            Arithmetic arithmetic = new Arithmetic(translator.getOperand(), operations);

            if (translator.getArabicOrRome() == 6) {
                System.out.println(translator.TransToRome(arithmetic.getAnswer()));
            } else {
                System.out.println(arithmetic.getAnswer());
            }
        } catch (ArithmeticException | InputException e) {
            e.printStackTrace();
        }

    }
}



