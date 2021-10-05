package strings.strong_password;

import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        String password = "2bb###AB";
        int n = password.length();


        int minimumNumber = 0;

        // Return the minimum number of characters to make the password strong
        Pattern p1 = Pattern.compile("[0-9]");
        int isContainDigit = p1.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainDigit;

        Pattern p2 = Pattern.compile("[a-z]]");
        int isContainLowerCase = p2.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainLowerCase;

        Pattern p3 = Pattern.compile("[A-Z]]");
        int isContainUpperCase = p3.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainUpperCase;

        Pattern p4 = Pattern.compile("[!@#$%^&*()\\-+]");
        int isContainSpecialChar = p3.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainSpecialChar;

        int isSatisfyLen = 0;
        int currentLen = n + minimumNumber;
        if (currentLen < 6) {
            System.out.println("##### " + (6 - currentLen + minimumNumber));
        }

        System.out.println("!!" + minimumNumber);
    }
}
