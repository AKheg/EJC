public class Main_Battleships {
    public static void main(String[] args) {
        Battleships bs = new Battleships();
        int[][] field = bs.Field;
        bs.PutNDeckShip(field,4);
        for (int i = 0; i < 3; i++) {
            bs.PutNDeckShip(field, 3);
        }
        for (int i = 0; i < 4; i++) {
            bs.PutNDeckShip(field, 2);
        }
        bs.Put1DeckShip4Times(field);
        for (int[] x : field){
            for (int y : x){
                if (!(y == -1)) System.out.print(" " + y + " ");
                else System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

