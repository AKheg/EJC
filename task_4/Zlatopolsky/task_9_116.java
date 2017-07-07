package Zlatopolsky;

public class task_9_116 {
    public static void main(String[] args) {
        String s = "АРГЕНТИНА МАНИТ НЕГРА";
        String s1 = "ПОТ КАК ПОТОП";
        String s2 = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";
        System.out.println(palindrom(s2));
    }
    private static boolean palindrom (String str){
        str = str.replaceAll(" ", "");
        char[] charstr = str.toCharArray();
        for (int i = 0; i < str.length() / 2 + 1; i++) {
            if (!(charstr[i] == charstr[str.length() - i - 1])) return false;
        }
        return true;
    }
}
