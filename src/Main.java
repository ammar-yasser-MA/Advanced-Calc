import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void res(double res) {
        if (res == (int) res) {
            System.out.println((int) res);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        Scanner userchoise = new Scanner(System.in);

        System.out.println("Enter your name:");
        String userName = userchoise.next();
    
        System.out.println("Enter your age:");
        int userAge = 0;

        while (true) {
            try {
                userAge = userchoise.nextInt();
                if (userAge <= 0) {
                    System.out.println("Please enter a valid age (greater than 0).");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for age.");
                userchoise.next();
            }
        }

        int Age = userAge;
        int thisYear = 2025;
        int born = thisYear - Age;

        while (true) {
            System.out.println("The operation to be done with your 2 numbers:");
            System.out.println("For percentage type (=%), for modulus type (%), for percentage type (%%), for root type (root), for square type (sqr)");

            double userchoise1 = 0;
            while (true) {
                System.out.println("Enter your first number:");
                try {
                    userchoise1 = userchoise.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    userchoise.next();
                }
            }

            System.out.println("Please choose an operation: ");
            String operation = userchoise.next();

            double userchoise2 = 0;
            if (!operation.equals("root") && !operation.equals("sqr")) {
                while (true) {
                    System.out.println("Enter your second number:");
                    try {
                        userchoise2 = userchoise.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number.");
                        userchoise.next();
                    }
                }
            }

            double result = 0;
            boolean validOperation = true;

            switch (operation) {
                case "+":
                    result = userchoise1 + userchoise2;
                    break;
                case "-":
                    result = userchoise1 - userchoise2;
                    break;
                case "*":
                    result = userchoise1 * userchoise2;
                    break;
                case "/":
                    if (userchoise2 == 0) {
                        System.out.println("You can't divide by 0.");
                        break;
                    }
                    result = userchoise1 / userchoise2;
                    break;
                case "=%":
                    if (userchoise1 > userchoise2) {
                        result = (userchoise2 / userchoise1) * 100;

                    } else if (userchoise1 < userchoise2) {
                        result = (userchoise1 / userchoise2) * 100;
                    }
                    break;
                case "%%":
                    result = (userchoise1 / 100) * userchoise2;
                    break;
                case "%":
                    if (userchoise2 == 0) {
                        System.out.println("You can't modulus by 0.");
                        break;
                    }
                    result = userchoise1 % userchoise2;
                    break;
                case "root":
                    if (userchoise1 < 0) {
                        System.out.println("You can't take square root of negative number.");
                        break;
                    }
                    result = Math.sqrt(userchoise1);
                    break;
                case "sqr":
                    result = userchoise1 * userchoise1;
                    break;
                default:
                    validOperation = false;
                    System.out.println("Error: Not a valid operation.");
            }

            if (validOperation) {
                System.out.print("Hi " + userName + "\nYou are " + Age + " years old.");
                System.out.println("\nYou were born in " + born + ".\nThe result of your operation is: ");
                res(result);
            }
            System.out.println("\nDo you want to perform another operation? (yes/no)");
            String continueChoice = userchoise.next();
            if (continueChoice.equalsIgnoreCase("no")) {
                System.out.println("Program ended.");
                break;
            }
        }
    }
}
