package BattleshipsTheGame;

import java.util.Scanner;

public class PlayerAction {
    private static int ATTEMPTS_NUMBER = 50;

    private char[][] playerField = new char[10][10];
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerField[i][j] = '.';
            }
        }
    }

    /**'1' - one deck ship cell value,
     *'2' - two deck ship cell value, etc
     *'-1' - space around ship
     *After our shot we add 7 to the value in the cell.
     *So after our shot value in the cell lay between 6 and 11:
     *'6' - if we shot the space near ship, '7' - blank cell (value = 0),
     *'8' - we destroyed one deck ship,
     *'9' - '11' - decks of damaged ships.
     *If we destroyed ship, we'd add another 7 to the value in the cell
     *so their values would be lay in '15'-'18' range.
     *So if our game is finished, we would get
     *15*4+16*2*3+17*3*2+18*4 = 330 - sum of all destroyed ships.
     *If we get that number, the game'll end.
     */
    private int testGameEnd(int[][] field){
        int DestroyedDeckNumber = 0;
        int endNum = 330;
        for (int[] aF : field) {
            for (int j = 0; j < field.length; j++) {
                if (aF[j] >= 15) DestroyedDeckNumber += aF[j];
            }
        }
        if (DestroyedDeckNumber == endNum) return 1;
        else return 0;
    }

    private void setSurroundDamagedShip(int[][] field, int coordI, int coordJ) {
        if (((new Battleships()).arrayBound(coordI, coordJ)) &&
                ((field[coordI][coordJ] == -1) ||
                        (field[coordI][coordJ] == 6))) {
            field[coordI][coordJ]--;
            playerField[coordI][coordJ] = 'o';
        }
    }

    private void SurroundDamagedShip(int[][] field, int coordI, int coordJ){
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (!((k == 0) && (l == 0))) {
                    setSurroundDamagedShip(field, coordI + k, coordJ + l);
                }
            }
        }
    }

    private void ifThatShipDestroyedDeckSizeMatters(int[][] field, int coordI, int coordJ, int DeckNumber){
        int DamagedDeckNumber = 0;
        for (int k = coordI - (DeckNumber - 1); k <= coordI + (DeckNumber - 1); k++){
            for (int l = coordJ - (DeckNumber - 1); l <= coordJ + (DeckNumber - 1); l++){
                if (((new Battleships()).arrayBound(k, l)) && (field[k][l] == DeckNumber + 7)) DamagedDeckNumber++;
            }
        }
        playerField[coordI][coordJ] = 'x';
        if (DamagedDeckNumber == DeckNumber){
            System.out.println("You destroyed " + DeckNumber + "-Deck ship");
            for (int k = coordI - (DeckNumber - 1); k <= coordI + (DeckNumber - 1); k++){
                for (int l = coordJ - (DeckNumber - 1); l <= coordJ + (DeckNumber - 1); l++){
                    if (((new Battleships()).arrayBound(k, l)) && (field[k][l] == DeckNumber + 7)){
                        field[k][l] += 7;
                        SurroundDamagedShip(field, k, l);
                    }
                }
            }
        }
    }

    private void ifThatShipDestroyed(int[][] field, int coordI, int coordJ){
        switch (field[coordI][coordJ]){
            case 8:{
                playerField[coordI][coordJ] = 'x';
                System.out.println("You destroyed one deck ship!");
                field[coordI][coordJ] += 7;
                SurroundDamagedShip(field, coordI, coordJ);
            } break;
            case 9:  ifThatShipDestroyedDeckSizeMatters(field, coordI, coordJ, 2); break;
            case 10: ifThatShipDestroyedDeckSizeMatters(field, coordI, coordJ, 3); break;
            case 11: ifThatShipDestroyedDeckSizeMatters(field, coordI, coordJ, 4); break;
            default: break;
        }
    }

    private void DrawField(char[][] field){
        for (char[] x : field){
            for (char y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    void run(){
        Battleships bs = new Battleships();
        int[][] field = bs.Field;
        bs.GenerateShipsOnTheField(field);

        System.out.println("Enter your shoot coordinates in <letter>-<number> format.");
        System.out.println("Letters from <a> to <j>; Numbers from 1 to 10; For example: a-2, c-3, etc");
        System.out.println("You have " + ATTEMPTS_NUMBER + " tries to clear the battlefield. Good luck!");
        int attempts = ATTEMPTS_NUMBER;

       while (attempts >= 1){
            Scanner in = new Scanner(System.in);
            String coordinates = in.nextLine();
            int coordX = 0, coordY = 0;

            switch(coordinates.charAt(0)){
                case 'a': coordY = 0; break;
                case 'b': coordY = 1; break;
                case 'c': coordY = 2; break;
                case 'd': coordY = 3; break;
                case 'e': coordY = 4; break;
                case 'f': coordY = 5; break;
                case 'g': coordY = 6; break;
                case 'h': coordY = 7; break;
                case 'i': coordY = 8; break;
                case 'j': coordY = 9; break;
                default: System.out.println("Wrong format!"); continue;
            }

            if (!(coordinates.charAt(1) == '-')){
                System.out.println("Wrong format!");
                continue;
            }

            String sub = coordinates.substring(2);
            switch(Integer.parseInt(sub)) {
                case 1: coordX = 0; break;
                case 2: coordX = 1; break;
                case 3: coordX = 2; break;
                case 4: coordX = 3; break;
                case 5: coordX = 4; break;
                case 6: coordX = 5; break;
                case 7: coordX = 6; break;
                case 8: coordX = 7; break;
                case 9: coordX = 8; break;
                case 10: coordX = 9; break;
                default: System.out.println("Wrong format!"); continue;
            }

            switch (field[coordX][coordY]) {
                case -1:
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    field[coordX][coordY] += 7; break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    System.out.println("You already shot that area!"); continue;
                default: break;
            }

            switch (field[coordX][coordY]) {
                case 6:
                case 7: {
                    playerField[coordX][coordY] = '~';
                    System.out.println("Miss!");
                    break;
                }
                case 8:
                case 9:
                case 10:
                case 11: {
                    System.out.println("Hit!");
                    ifThatShipDestroyed(field, coordX, coordY);
                    attempts++; break;
                }
                case 5: {
                    System.out.println("You already shot that area and it's near the ship btw"); continue;
                }
                case -2:
                {System.out.println("This area is around ship that you already destroyed, this shot was meaningless...")
                ; break;}
                default: {
                    System.out.println("You already shot that area!"); continue;
                }
            }

            DrawField(playerField);
            if (testGameEnd(field) == 1) {System.out.println("Congratulations, you win!"); break;}
            else attempts--;
       }
    }
}
