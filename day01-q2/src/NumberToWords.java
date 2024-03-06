public class NumberToWords {
    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final String[] thousands = {"", "thousand", "million", "billion"};

    public static void main(String[] args) {
        System.out.println(inWords(12345));
        System.out.println(inWords(101));
        System.out.println(inWords(999999999));
    }
    public static String inWords(int num) {
        if (num == 0) {
            return "zero";
        }

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }
    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return units[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return units[num / 100] + " hundred " + helper(num % 100);
        }
    }
}
