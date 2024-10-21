import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int year = SafeInput.getRangedInt(in, "Enter your birth year (1950-2015)", 1950, 2015);
        int month = SafeInput.getRangedInt(in, "Enter your birth month (1-12)", 1, 12);
        int day = getDayOfMonth(in, month);
        int hour = SafeInput.getRangedInt(in, "Enter your birth hour (1-24)", 1, 24);
        int minute = SafeInput.getRangedInt(in, "Enter your birth minute (0-59)", 0, 59);

        System.out.printf("\nYour birth date and time is: %02d/%02d/%04d %02d:%02d\n", day, month, year, hour, minute);

        in.close();
    }

    private static int getDayOfMonth(Scanner in, int month) {
        int day = 0;
        int maxDays;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxDays = 31;
                break;
            case 4: case 6: case 9: case 11:
                maxDays = 30;
                break;
            case 2:
                maxDays = 29; // Assume leap year; adjust if needed
                break;
            default:
                maxDays = 0; // This case shouldn't happen due to previous validation
        }

        day = SafeInput.getRangedInt(in, "Enter your birth day (1-" + maxDays + ")", 1, maxDays);
        return day;
    }
}
