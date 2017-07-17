package task_3;

/**
 * Generates ships on the field randomly
 */
public class Battleships {
    int[][] field = new int[10][10];

    boolean arrayBound(int coordI, int coordJ) {
        return ((coordI >= 0) && (coordI <= 9)) && ((coordJ >= 0) && (coordJ <= 9));
    }

    private boolean testNewDeck(int[][] field, int coordI, int coordJ) {
        return arrayBound(coordI, coordJ) && ((field[coordI][coordJ] == 0) || (field[coordI][coordJ] == -2));
    }

    private void setValue(int[][] field, int coordI, int coordJ, int value) {
        if ((arrayBound(coordI, coordJ)) && (field[coordI][coordJ] == 0)) {
            field[coordI][coordJ] = value;
        }
    }

    private void surroundValue(int[][] field, int coordI, int coordJ, int value) {
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (!((k == 0) && (l == 0))) {
                    setValue(field, coordI + k, coordJ + l, value);
                }
            }
        }
    }

    private void surroundEnd(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == -2) field[i][j] = -1;
            }
        }
    }

    private void putNDeckShip(int[][] field, int deckNumber) {
        while (true) {
            // coordI row, coordJ column - head of the ship coordinates;
            int coordI;
            int coordJ;
            coordI = (int) (Math.random() * 10);
            coordJ = (int) (Math.random() * 10);
            //Choose direction: 0 - up, 1 - right, 2 - down, 3 - left
            int direction;
            direction = (int) (Math.random() * 4);
            boolean flag = false;
            if (testNewDeck(field, coordI, coordJ)) {
                    if (direction == 0) {
                        if (testNewDeck(field, coordI - (deckNumber - 1), coordJ))
                            flag = true;
                    }
                    else if (direction == 1) {
                        if (testNewDeck(field, coordI, coordJ + (deckNumber - 1)))
                            flag = true;
                    }
                    else if (direction == 2) {
                        if (testNewDeck(field, coordI + (deckNumber - 1), coordJ))
                            flag = true;
                    }
                    else if (direction == 3) {
                        if (testNewDeck(field, coordI, coordJ - (deckNumber - 1)))
                            flag = true;
                    }

            }
            if (flag) {
                field[coordI][coordJ] = deckNumber;
                surroundValue(field, coordI, coordJ, -2);
                switch (direction) {
                    case 0: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            field[coordI - k][coordJ] = deckNumber;
                            surroundValue(field, coordI - k, coordJ, -2);
                        }
                    }
                    break;
                    case 1: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            field[coordI][coordJ + k] = deckNumber;
                            surroundValue(field, coordI, coordJ + k, -2);
                        }
                    }
                    break;
                    case 2: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            field[coordI + k][coordJ] = deckNumber;
                            surroundValue(field, coordI + k, coordJ, -2);
                        }
                    }
                    break;
                    case 3: {
                        for (int k = deckNumber - 1; k >= 1; k--) {
                            field[coordI][coordJ - k] = deckNumber;
                            surroundValue(field, coordI, coordJ - k, -2);
                        }
                    }
                    break;
                }
                break;
            }
        }
        surroundEnd(field);
    }

  private void put1DeckShip4Times(int[][] field) {
      for (int k = 1; k < 5; k++) {
          while (true){
              int i = (int) (Math.random() * 10);
              int j = (int) (Math.random() * 10);
              if (field[i][j] == 0){
                  field[i][j] = 1;
                  surroundValue(field, i, j, -1);
                  break;
              }
          }
      }
    }

    void generateShipsOnTheField(int[][] field){
        putNDeckShip(field, 4);
        for (int i = 1; i <= 2; i++) {
            putNDeckShip(field, 3);
        }
        for (int i = 1; i <= 3; i++) {
            putNDeckShip(field, 2);
        }
        put1DeckShip4Times(field);
    }
}

