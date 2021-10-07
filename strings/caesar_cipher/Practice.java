package strings.caesar_cipher;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        String s = "middle-Outz";
        int k = 2;

        Map<Character, Integer> lowerAlphabetToInt = new HashMap<>();
        Map<Integer, Character> intToLowerAlphabet = new HashMap<>();

        for(int i=0;i<26;i++) {
            lowerAlphabetToInt.putIfAbsent((char)('a' + i),i);
            intToLowerAlphabet.putIfAbsent(i, (char)('a' + i));
        }

        StringBuilder sb = new StringBuilder();
        char[] carr = s.toCharArray();
        for(char c : carr) {
//            System.out.println("###" + c);
            if('a' <= c && c <= 'z') {
                int num = lowerAlphabetToInt.get(c);

                num = (num + k) % 26;
                sb.append(intToLowerAlphabet.get(num));
            }else if('A' <= c && c <= 'Z') {
                int num = lowerAlphabetToInt.get(Character.toLowerCase(c));

                num = (num + k) % 26;
                sb.append(Character.toUpperCase(intToLowerAlphabet.get(num)));
            }else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
