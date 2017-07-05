package BattleshipsTheGame;

public class Battleships {
    int[][] Field = new int[10][10];
    //this method checks your coordinates to be within the array
    boolean arrayBound(int i, int j) {
        return ((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9));
    }
    //check if we can put new deck
    private boolean testNewDeck(int[][] f, int i, int j) {
        return arrayBound(i, j) && ((f[i][j] == 0) || (f[i][j] == -2));
    }
    //set value into array cell
    private void setValue(int[][] f, int i, int j, int value) {
        if ((arrayBound(i, j)) && (f[i][j] == 0)) {
            f[i][j] = value;
        }
    }
    //next two methods surround array cells with value
    private void surroundValue(int[][] f, int i, int j, int value) {
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (!((k == 0) && (l == 0))) {
                    setValue(f, i + k, j + l, value);
                }
            }
        }
    }
    private void surroundEnd(int[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                if (f[i][j] == -2) f[i][j] = -1;
            }
        }
    }
    //randomly puts N_Deck_ship on the field
    private void PutNDeckShip(int[][] f, int deckNumber) {
        while (true) {
            // i row, j column - head of the ship coordinates
            int i, j;
            i = (int) (Math.random() * 10);
            j = (int) (Math.random() * 10);
            //Choose direction: 0 - up, 1 - right, 2 - down, 3 - left
            int direction;
            direction = (int) (Math.random() * 4);
            boolean flag = false;
            if (testNewDeck(f, i, j)) {
                    if (direction == 0) {
                        if (testNewDeck(f, i - (deckNumber - 1), j))
                            flag = true;
                    }
                    else if (direction == 1) {
                        if (testNewDeck(f, i, j + (deckNumber - 1)))
                            flag = true;
                    }
                    else if (direction == 2) {
                        if (testNewDeck(f, i + (deckNumber - 1), j))
                            flag = true;
                    }
                    else if (direction == 3) {
                        if (testNewDeck(f, i, j - (deckNumber - 1)))
                            flag = true;
                    }

            }
            if (flag) {
                f[i][j] = deckNumber;
                surroundValue(f, i, j, -2);
                switch (direction) {
                    case 0: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            f[i - k][j] = deckNumber;
                            surroundValue(f, i - k, j, -2);
                        }
                    }
                    break;
                    case 1: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            f[i][j + k] = deckNumber;
                            surroundValue(f, i, j + k, -2);
                        }
                    }
                    break;
                    case 2: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            f[i + k][j] = deckNumber;
                            surroundValue(f, i + k, j, -2);
                        }
                    }
                    break;
                    case 3: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            f[i][j - k] = deckNumber;
                            surroundValue(f, i, j - k, -2);
                        }
                    }
                    break;
                }
                break;
            }
        }
        surroundEnd(f);
    }
  private void Put1DeckShip4Times(int[][] f) {
      for (int k = 1; k < 5; k++) {
          while (true){
              int i = (int) (Math.random() * 10);
              int j = (int) (Math.random() * 10);
              if (f[i][j] == 0){
                  f[i][j] = 1;
                  surroundValue(f, i, j, -1);
                  break;
              }
          }
      }
    }
    void GenerateShipsOnTheField(int[][] f){
        PutNDeckShip(f, 4);
        for (int i = 1; i <= 2; i++) {
            PutNDeckShip(f, 3);
        }
        for (int i = 1; i <= 3; i++) {
            PutNDeckShip(f, 2);
        }
        Put1DeckShip4Times(f);
    }
    //next method draws the field from program perspective
    void DrawField(int[][] f){
        for (int[] x : f){
            for (int y : x){
                if (!(y == -1)) System.out.print(" " + y + " ");
                else System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

