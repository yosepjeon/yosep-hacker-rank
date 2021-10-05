package strings.two_characters;

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
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        // Write your code here

        char[] carr = s.toCharArray();
        Set<Character> alphabetSet = new HashSet<>();
        int carrLen = carr.length;

        for (char c : carr) {
            alphabetSet.add(c);
        }

        int idx = 0;
        int alphabetSize = alphabetSet.size();
        char[] alphabets = new char[alphabetSize];
        for (Character c : alphabetSet) {
            alphabets[idx++] = c;
        }

        int max = 0;
        for (int i = 0; i < alphabetSize; i++) {
            for (int j = i + 1; j < alphabetSize; j++) {
                int count = 0;
                Stack<Character> stack = new Stack<>();
                char c1 = alphabets[i];
                char c2 = alphabets[j];
                int stackSize = 0;

                boolean isComplete = true;
                for (int k = 0; k < carrLen; k++) {
                    if (carr[k] == c1 || carr[k] == c2) {
                        if (stack.isEmpty()) {
                            stack.push(carr[k]);
                            stackSize++;
                        } else if (!stack.isEmpty() && stack.peek() == carr[k]) {
                            isComplete = false;
                            break;
                        } else if(!stack.isEmpty() && stack.peek() != carr[k]) {
                            stack.push(carr[k]);
                            stackSize++;
                        }
                    }
                }

                if(isComplete) {
                    max = max < stackSize ? stackSize : max;
                }
            }
        }

        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

