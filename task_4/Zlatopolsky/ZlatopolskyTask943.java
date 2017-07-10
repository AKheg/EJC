package Zlatopolsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZlatopolskyTask943 {

    public static void main(String args[]){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String input = reader.readLine();
            char[] charInput = input.toCharArray();
            for (int i = 0; i < input.length(); i += 2) {
                System.out.print(charInput[i]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
