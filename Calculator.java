import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
		//Enter the expression here:
		String input = scanner.nextLine();

        CalculatorLogic calculator = new CalculatorLogic();
        int result = calculator.calculate(input);

        System.out.println(result);
    }
}


class CalculatorLogic {
    public int calculate(String input) {
        String[] parts = input.split("\\+|-|\\*|\\/"); // split the input by +, -, *, or /
        if (parts.length != 2 && parts.length != 3) {
            throw new RuntimeException("Invalid input");
        }

        int a = parseInt(parts[0]);
        int b = parseInt(parts[1]);
        int c = 0;
        if (parts.length == 3) {
            c = parseInt(parts[2]);
        }

        int result = 0;
        if (input.contains("+")) {
            if (input.indexOf("+") < input.lastIndexOf("+")) {
                result = a + b + c;
            } else if (input.indexOf("+") < input.lastIndexOf("-")) {
                result = a + b - c;
            } else {
                result = a - b + c;
            }
        } else if (input.contains("-")) {
            if (input.indexOf("-") < input.lastIndexOf("-")) {
                result = a - b - c;
            } else if (input.indexOf("-") < input.indexOf("*")) {
                result = a - b * c;
            } else if (input.indexOf("-") < input.indexOf("/")) {
                result = a - b / c;
            } else if (input.indexOf("-") > input.indexOf("*")) {
                result = a * b - c;
            } else {
                result = a / b - c;
            }
        } else if (input.contains("*")) {
            if (input.indexOf("*") < input.indexOf("/")) {
                result = a * b * c;
            } else {
                result = a / b * c;
            }
        } else if (input.contains("/")) {
            result = a / b / c;
        }

        return result;
    }

    private int parseInt(String s) {
        int n = Integer.parseInt(s);
        if (n < 1 || n > 10) {
            throw new RuntimeException("Invalid number");
        }
        return n;
    }
}