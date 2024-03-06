public class CalendarPrinter {
    public static void main(String[] args) {
        printCalendar(8, 2018);
    }

    public static void printCalendar(int month, int year) {
        if (isValidInput(month, year)) {
            printHeader();
            printMonth(month, year);
        } else {
            System.out.println("Invalid input for month or year.");
        }
    }

    public static boolean isValidInput(int month, int year) {
        return month >= 1 && month <= 12 && year >= 0;
    }

    public static void printHeader() {
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    public static void printMonth(int month, int year) {
        int numOfDays = getNumberOfDays(month, year);
        int startingDay = getStartingDay(month, 1, year);

        int dayOfWeek = 0;
        for (int i = 0; i < startingDay; i++) {
            System.out.print("   ");
            dayOfWeek++;
        }

        for (int day = 1; day <= numOfDays; day++) {
            System.out.printf("%3d ", day);
            dayOfWeek++;
            if (dayOfWeek == 7) {
                System.out.println();
                dayOfWeek = 0;
            }
        }
        System.out.println();
    }

    public static int getNumberOfDays(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year) && month == 2) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getStartingDay(int month, int day, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += daysInMonth[i - 1];
        }

        int startingDay = (totalDays + (year - 1) + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400 + day) % 7;

        return startingDay;
    }
}
