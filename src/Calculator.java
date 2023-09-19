import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, 2 + 3):");

        try {
            String input = scanner.nextLine();
            int result = calc(input);
            System.out.println("Результат: " + result);

        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Введите целые числа от 1 до 10.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static int calc(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода. Используйте пример: 2 + 3");
        }

        int a = Integer.parseInt(parts[0]);
        char operator = parts[1].charAt(0);
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 & b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10.");
        }

        int result = 0;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неверная операция. Используйте +, -, *, /.");
        }

        return result;
    }
}