package strings.strong_password;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        int minimumNumber = 0;

        // Return the minimum number of characters to make the password strong
        Pattern p1 = Pattern.compile("[0-9]");
        int isContainDigit = p1.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainDigit;

        Pattern p2 = Pattern.compile("[a-z]");
        int isContainLowerCase = p2.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainLowerCase;

        Pattern p3 = Pattern.compile("[A-Z]");
        int isContainUpperCase = p3.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainUpperCase;

        Pattern p4 = Pattern.compile("[!@#$%^&*()\\-+]");
        int isContainSpecialChar = p4.matcher(password).find() ? 0 : 1;
        minimumNumber += isContainSpecialChar;

        int isSatisfyLen = 0;
        int currentLen = n + minimumNumber;
        if (currentLen < 6) {
            return 6 - currentLen + minimumNumber;
        }

        return minimumNumber;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

