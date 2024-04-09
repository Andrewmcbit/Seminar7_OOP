import java.io.FileWriter;
import java.io.IOException;

interface Device{
    public String calculate(Operations operation, double a, double b);
}

class Calculator implements Device{
    private OperationsSelect op;
    public Calculator(OperationsSelect op){
        this.op = op;
    }
    @Override
    public String calculate(Operations operation, double a, double b){
        OperationCalculation operationResult = op.selectOperation(operation);
        System.out.println(operationResult.getResult(a, b));
        return operationResult.getResult(a, b);
    }
}

class CalculatorLogger extends Calculator{
    public CalculatorLogger(OperationsSelect op) {
        super(op);
    }
    @Override
    public String calculate(Operations operation, double a, double b){
        try {
            FileWriter writer = new FileWriter("Log.txt",true);
            writer.write(super.calculate(operation,a,b));
            writer.append('\n');
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
        return "Logged";
    }
}

