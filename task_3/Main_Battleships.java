public class Main_Battleships {
    public static void main(String[] args) {
        Battleships bs = new Battleships();
        int[][] field = bs.Field;
        bs.Put4PShip(field);
        for (int[] x : field){
            for (int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

