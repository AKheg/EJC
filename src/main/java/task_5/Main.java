package task_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Zlatopolsky task 9.153 and 9.154
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Main main = new Main();
            String input = reader.readLine();
            System.out.println(main.consecutiveChars(input));
            System.out.println(main.differentLetters(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int consecutiveChars(String str){
        int maxChars = 1;
        int currentMax = 1;
        if (str.length() == 0) return 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) currentMax++;
            else {
                currentMax = 1;
            }
            if (currentMax > maxChars) maxChars = currentMax;
        }
        return maxChars;
    }

    public int differentLetters(String str) {
        HashSet set = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size();
    }
}
