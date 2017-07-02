public class Battleships {
    int[][] Field = new int[10][10];

    //this method checks your coordinates to be within the array
    private boolean arrayBound(int i, int j) {
        return ((i >= 0) && (i <= 9)) && ((j >= 0) && (j <= 9));
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

    //randomly puts 4x1-ship on the field
    void Put4PShip(int[][] f) {
        // i - row, j - column
        int i, j;
        i = (int) (Math.random() * 10);
        j = (int) (Math.random() * 10);
        f[i][j] = 4;
        surroundValue(f, i, j, -2);
        //0 - up, 1 - right, 2 - down, 3 - left
        int direction;
        direction = (int) (Math.random() * 4);

        switch (direction) {
            case 0: {
                if (!(arrayBound(i - 3, j))) {
                    direction = 2;
                    break;
                }
            }
            case 1: {
                if (!(arrayBound(i, j + 3))) {
                    direction = 3;
                    break;
                }
            }
            case 2: {
                if (!(arrayBound(i + 3, j))) {
                    direction = 0;
                    break;
                }
            }
            case 3: {
                if (!(arrayBound(i, j - 3))) {
                    direction = 1;
                    break;
                }
            }
        }
        switch (direction) {
            case 0: {
                f[i - 3][j] = 4;
                surroundValue(f, i - 3, j, -2);
                f[i - 2][j] = 4;
                surroundValue(f, i - 2, j, -2);
                f[i - 1][j] = 4;
                surroundValue(f, i - 1, j, -2);
            }
            break;
            case 1: {
                f[i][j + 3] = 4;
                surroundValue(f, i, j + 3, -2);
                f[i][j + 2] = 4;
                surroundValue(f, i, j + 2, -2);
                f[i][j + 1] = 4;
                surroundValue(f, i, j + 1, -2);
            }
            break;
            case 2: {
                f[i + 3][j] = 4;
                surroundValue(f, i + 3, j, -2);
                f[i + 2][j] = 4;
                surroundValue(f, i + 2, j, -2);
                f[i + 1][j] = 4;
                surroundValue(f, i + 1, j, -2);
            }
            break;
            case 3: {
                f[i][j - 3] = 4;
                surroundValue(f, i, j - 3, -2);
                f[i][j - 2] = 4;
                surroundValue(f, i, j - 2, -2);
                f[i][j - 1] = 4;
                surroundValue(f, i, j - 1, -2);
            }
            break;
        }
        surroundEnd(f);
    }

    public int[][] randomlyFillField(int[][] f) {
        return f;
    }
}

