
public class CheckSpelling {

    char numbers[][] = {{'I', 'V', 'X'}, {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}};
    int digitalNumbers[][] = {{1, 5, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}};
    char mathOperators[] = {'+', '-', '/', '*'};


    int[] digitalArrayInputString(String input) {
        int[] digitalInput = new int[input.length() + 2];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                digitalInput[i + 1] = 1;
            }
        }
        return digitalInput;
    }

    String compressed(String input) {
        return input.replaceAll(" ", "");
    }

    int[] checkInputString1(int[] inputArray, String compressedString) throws InputException {

        for (int i = 0; i < numbers[0].length; i++) {
            if (compressedString.charAt(0) == numbers[0][i]) {
                inputArray[0] = 1;
            }
        }
        for (int i = 0; i < numbers[1].length; i++) {
            if (compressedString.charAt(0) == (numbers[1][i])) {
                inputArray[0] = 2;
            }
        }
        if (inputArray[0] == 0) {
            throw new InputException("Input is incorrect");
        }
        return inputArray;
    }

    int[] checkInputString2(int[] inputArray, String compressedString) throws InputException {

        for (int i = 0; i < compressedString.length(); i++) {
            for (int j = 0; j < numbers[inputArray[0] - 1].length; j++) {
                if (compressedString.charAt(i) == numbers[inputArray[0] - 1][j]) {
                    inputArray[i + 1] = digitalNumbers[inputArray[0] - 1][j];
                } else if (j == numbers[inputArray[0] - 1].length - 1 && inputArray[i + 1] == 0) {
                    for (int k = 0; k < mathOperators.length; k++) {
                        if (compressedString.charAt(i) == mathOperators[k]) {
                            if (inputArray[inputArray.length - 1] != 0 || i == compressedString.length() - 1) {
                                throw new InputException("Input is incorrect");
                            }
                            inputArray[inputArray.length - 1] = i;
                            inputArray[inputArray.length - 2] = k;
                            inputArray[i + 1] = -1;
                        } else if (k == 3 && inputArray[i + 1] == 0) {
                            throw new InputException("Input is incorrect");
                        }
                    }
                }
            }
        }
        return inputArray;

    }

    void checkInputString3 (int [] digitalArrayInputString, int positionMath) throws InputException {

        int numberOfNumbers = 0;

        for (int i = 0; i < positionMath; i++) {
            if (digitalArrayInputString[i] == 0 && digitalArrayInputString[i + 1] == 1) {
                numberOfNumbers++;
            }
        }

        for (int i = positionMath + 1;  i < digitalArrayInputString.length - 2  ; i++) {
            if (digitalArrayInputString[i + 1] == 1 && digitalArrayInputString[i + 2] == 0) {
                numberOfNumbers++;
            }
        }

        if (numberOfNumbers > 2){
            throw new InputException("Input is incorrect");
        }
    }


    int positionMathOperatorInputString (int [] checkInputString2, String inputString){
        int positionMathOperator = 0;
        for (int i = 0; i < inputString.length(); i++){
            if (inputString.charAt(i) == mathOperators[checkInputString2[checkInputString2.length - 2]]){
                positionMathOperator = i;
            }
        }
        return positionMathOperator;
    }

}

