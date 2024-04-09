interface OperationCalculation{
    public String getResult(double a, double b);
}

class Addition implements OperationCalculation{
    @Override
    public String getResult(double a, double b) {
        return String.format("%.1f + %.1f = %.1f",a ,b, a + b);
    }
}

class Multiplication implements OperationCalculation{
    @Override
    public String getResult(double a, double b) {
        return String.format("%.1f * %.1f = %.1f",a ,b, a * b);
    }
}

class Division implements OperationCalculation{
    @Override
    public String getResult(double a, double b){
        try {
            if ((a / b) == Double.POSITIVE_INFINITY || (a / b) == Double.NEGATIVE_INFINITY)
                throw new ArithmeticException();
            return String.format("%.1f / %.1f = %.1f",a ,b, a / b);
        } catch (ArithmeticException ae) {
            return String.format("%.1f / %.1f = ArithmeticException occured!",a ,b);
        }
    }
}

public class OperationsSelect{
    public OperationCalculation selectOperation(Operations type){
        OperationCalculation operation = null;
        switch (type){
            case Addition:
                operation = new Addition();
                break;
            case Multiplication:
                operation = new Multiplication();
                break;
            case Division:
                operation = new Division();
                break;
        }
        return operation;
    }
}