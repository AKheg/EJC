package Zlatopolsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task_9_43 {

    public static void main(String args[]){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String str = (reader.readLine());
            char[] str2 = str.toCharArray();
            for (int i = 0; i < str.length(); i+=2) {
                System.out.print(str2[i]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
