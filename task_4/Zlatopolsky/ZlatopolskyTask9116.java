package Zlatopolsky;

public class ZlatopolskyTask9116 {
    public static void main(String[] args) {
        String firstString = "АРГЕНТИНА МАНИТ НЕГРА";
        String secondString = "ПОТ КАК ПОТОП";
        String thirdString = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";
        System.out.println(palindrome(firstString));
        System.out.println(palindrome(secondString));
        System.out.println(palindrome(thirdString));
    }
    private static boolean palindrome(String stringArg){
        stringArg = stringArg.replaceAll(" ", "");
        char[] charStringArg = stringArg.toCharArray();
        for (int i = 0; i < stringArg.length() / 2 + 1; i++){
            if (!(charStringArg[i] == charStringArg[stringArg.length() - i - 1])) return false;
        }
        return true;
    }
}
