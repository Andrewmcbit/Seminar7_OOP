// Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
// Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.
// Соблюдать принципы SOLID, паттерны проектирования.
class Main{
    public static void main(String[] args) {
        System.out.println("Calculator w/o logger");
        Calculator calculator1 = new Calculator(new OperationsSelect());
        calculator1.calculate(Operations.Multiplication,10.0,2.0);
        calculator1.calculate(Operations.Division,20.0, 2.0);
        calculator1.calculate(Operations.Division,30.0,0);
        System.out.println("Calculator with logger");
        Calculator calculator2 = new CalculatorLogger(new OperationsSelect());
        calculator2.calculate(Operations.Multiplication,30.0,2.0);
        calculator2.calculate(Operations.Division,10.0, 2.0);
        calculator2.calculate(Operations.Division,20.0,0);
    }
}