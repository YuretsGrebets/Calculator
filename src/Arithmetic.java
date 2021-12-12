public class Arithmetic {
    private int answer;
    public Arithmetic(int[] operand, String operation) throws ArithmeticException {
        if (operation.equals("+"))
            answer = operand[0] + operand[1];
        else if (operation.equals("-"))
            answer = operand[0] - operand[1];
        else if (operation.equals("*"))
            answer = operand[0] * operand[1];
        else if (operation.equals("/"))
            answer = (operand[0]-operand[0]%operand[1]) / operand[1];
        else
            throw new ArithmeticException("Unknown operation or remainder division");
    }
    public int getAnswer() {
        return answer;
    }
}