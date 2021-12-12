public class Translator  {
    private int[] operand = new int[2];
    private int arabicOrRome = 0;
    public Translator(String [] input) throws InputException {
        String[][] number = {{"1","2","3","4","5","6","7","8","9","10"},
                {"I","II","III","IV","V","VI","VII","VIII","IX","X"}};
        for (int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                for(int k = 0; k < 10; k++)
                    if(input[j].equals(number[i][k])) {
                        operand[j] = k + 1;
                        arabicOrRome += (i+2);
                    }
        if(arabicOrRome != 4 && arabicOrRome != 6)
            throw new InputException("Input is incorrect");
    }
    public String TransToRome(int ans) throws InputException {
        String ansToRome = "";
        if (ans <= 0)
            throw new InputException("Input is incorrect");
        int modDec = Math.abs(ans % 10);
        int dec = Math.abs((ans - modDec) / 10);
        if(dec > 0)
            ansToRome = ansToRome + Dec(dec, 1);
        ansToRome = ansToRome + Dec(modDec, 0);
        return ansToRome;
    }
    private String Dec(int quantity, int dozens){
        String decStr = "";
        String[][] Rome = {{"I","V","X"},{"X","L","C"}};
        if(quantity < 4)
            for (int i = 0; i < quantity; i++ )
                decStr = decStr + Rome[dozens][0];
        else if (quantity == 4)
            decStr = Rome[dozens][0] + Rome[dozens][1];
        else if ( quantity < 9){
            decStr = Rome[dozens][1];
            for (int i = 0; i < (quantity-5); i++ )
                decStr = decStr + Rome[dozens][0];
        }
        else if ( quantity == 9)
            decStr = Rome[dozens][0] + Rome[dozens][2];
        else
            decStr = Rome[dozens][2];
        return decStr;
    }
    public int getArabicOrRome() {
        return arabicOrRome;
    }
    public int[] getOperand() {
        return operand;
    }
}