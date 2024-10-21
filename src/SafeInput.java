import java.util.Scanner;

public class SafeInput {

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean validInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                if (retInt >= low && retInt <= high) {
                    validInput = true;
                } else {
                    System.out.println("Error: Input must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer.");
                pipe.next(); // clear invalid input
            }
        } while (!validInput);
        pipe.nextLine(); // clear the newline character
        return retInt;
    }
}
