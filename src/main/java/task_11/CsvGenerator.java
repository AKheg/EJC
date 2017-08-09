package task_11;

import java.io.*;
import java.util.ArrayList;

public class CsvGenerator {
    private static String file_name =
            "C:\\Users\\Артём\\IdeaProjects\\EJC\\src\\main\\java\\task_11\\main_data\\document16.csv";

    private ArrayList<String> inputData(BufferedReader bufferedReader){
        String strLine;
        ArrayList<String> words = new ArrayList<>();
        try {
            while ((strLine = bufferedReader.readLine()) != null){
                words.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    private String stringGeneration(ArrayList<String> nameData){
        int random_number = 100 + (int)(Math.random() * 901);
        int random_number2 = (int)(Math.random() * 21);
        int random_number3 = 21 + (int)(Math.random() * 21);
        int random_number4 = (int)(Math.random() * 1000000001);

        String sites = nameData.get(random_number3);
        String names = nameData.get(random_number2);
        return random_number + ";" + sites + ";" + random_number4 + ";" + names;
    }

    private void dataGeneration(BufferedWriter bufferedWriter, ArrayList<String> nameData) {
        try {
        String mainLine = "id;url;time;user";

        bufferedWriter.write(mainLine + "\n");
            for (int i = 0; i < 19; i++) {
                String string = stringGeneration(nameData);
                bufferedWriter.write(string + "\n");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CsvGenerator gen = new CsvGenerator();

        try {
            FileInputStream names = new FileInputStream(
                 "C:\\Users\\Артём\\IdeaProjects\\EJC\\src\\main\\java\\task_11\\main_data\\namesAndSites.txt");
            DataInputStream in = new DataInputStream(names);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            FileWriter offstream = new FileWriter(file_name);
            BufferedWriter out = new BufferedWriter(offstream);

            ArrayList<String> data = new CsvGenerator().inputData(br);

            br.close();
            gen.dataGeneration(out, data);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
