import java.util.Scanner;

public class Calculator {
    private int valueA;
    private int valueB;
    private char op;

    // Construtor com valores padrão
    public Calculator() {
        this.valueA = 0;
        this.valueB = 0;
        this.op = ' ';
    }

    // Getters e Setters
    public int getValueA() {
        return valueA;
    }

    public void setValueA(int valueA) {
        this.valueA = valueA;
    }

    public int getValueB() {
        return valueB;
    }

    public void setValueB(int valueB) {
        this.valueB = valueB;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    // Método para testar se o operador é válido
    public boolean testOperator() {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    // Método para testar se o valor está dentro da faixa permitida
    public boolean testValue(int value) {
        return value >= -100 && value <= 100;
    }

    // Método para capturar informações do usuário
    @SuppressWarnings("resource")
    public void captureInformations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro numero: ");
        int num1 = scanner.nextInt();
        while (!testValue(num1)) {
            System.out.println("Valor inválido. Digite um número entre -100 e 100: ");
            num1 = scanner.nextInt();
        }
        this.setValueA(num1);

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();
        while (!testValue(num2)) {
            System.out.println("Valor inválido. Digite um número entre -100 e 100: ");
            num2 = scanner.nextInt();
        }
        this.setValueB(num2);

        System.out.println("Digite o operador (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        while (!testOperator()) {
            System.out.println("Operador inválido. Digite um operador válido (+, -, *, /): ");
            op = scanner.next().charAt(0);
        }
        this.setOp(op);
    }

    // Método para realizar o cálculo
    public int calculate() {
        switch (op) {
            case '+':
                return valueA + valueB;
            case '-':
                return valueA - valueB;
            case '*':
                return valueA * valueB;
            case '/':
                if (valueB == 0) {
                    throw new IllegalArgumentException("Divisão por zero não é permitida.");
                }
                return valueA / valueB;
            default:
                throw new IllegalArgumentException("Operador inválido.");
        }
    }

    // Método para exibir o resultado
    public void show() {
        System.out.println("Resultado: " + calculate());
    }
}