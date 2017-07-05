package BattleshipsTheGame;

import java.util.Scanner;

public class PlayerAction {
    private static int ATTEMPTS_NUMBER = 50;
    //test after every move if we destroyed all ships
    /**'1' - one deck ship cell value,
     '2' - two deck ship cell value, etc
     '-1' - space around ship
     After our shot we add 7 to the value in the cell.
     So after our shot value in the cell lay between 6 and 11:
     '6' - if we shot the space near ship, '7' - blank cell (value = 0),
     '8' - we destroyed one deck ship,
     '9' - '11' - decks of damaged ships.
     If we destroyed ship, we'd add another 7 to the value in the cell
     so their values would be lay in '15'-'18' range.
     So if our game is finished, we would get
     15*4+16*2*3+17*3*2+18*4 = 330 - sum of all destroyed ships.
     If we get that number, the game'll end.
     */
    private int testGameEnd(int[][] f){
        int DestroyedDeckNumber = 0;
        int endNum = 330;
        for (int[] aF : f) {
            for (int j = 0; j < f.length; j++) {
                if (aF[j] >= 15) DestroyedDeckNumber += aF[j];
            }
        }
        if (DestroyedDeckNumber == endNum) return 1;
        else return 0;
    }
    // surround destroyed ships with their value - 1
    private void setSurroundDamagedShip(int[][] f, int i, int j){
        if (((new Battleships()).arrayBound(i, j)) && ((f[i][j] == -1) || (f[i][j] == 6))) f[i][j]--;
    }
    private void SurroundDamagedShip(int[][] f, int i, int j){
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (!((k == 0) && (l == 0))) {
                    setSurroundDamagedShip(f, i + k, j + l);
                }
            }
        }
    }
    // next two methods check if we destroyed next ship
    private void ifThatShipDestroyedDeckSizeMatters(int[][] f, int i, int j, int DeckNumber){
        int DamagedDeckNumber = 0;
        for (int k = i - (DeckNumber - 1); k <= i + (DeckNumber - 1); k++){
            for (int l = j - (DeckNumber - 1); l <= j + (DeckNumber - 1); l++){
                if (((new Battleships()).arrayBound(k, l)) && (f[k][l] == DeckNumber + 7)) DamagedDeckNumber++;
            }
        }
        if (DamagedDeckNumber == DeckNumber){
            System.out.println("You destroyed " + DeckNumber + "-Deck ship");
            for (int k = i - (DeckNumber - 1); k <= i + (DeckNumber - 1); k++){
                for (int l = j - (DeckNumber - 1); l <= j + (DeckNumber - 1); l++){
                    if (((new Battleships()).arrayBound(k, l)) && (f[k][l] == DeckNumber + 7)){
                        f[k][l] += 7;
                        SurroundDamagedShip(f, k, l);
                    }
                }
            }
        }
    }
    private void ifThatShipDestroyed(int[][] f, int i, int j){
        switch (f[i][j]){
            case 8:{
                System.out.println("You destroyed one deck ship!");
                f[i][j] += 7;
                SurroundDamagedShip(f, i, j);
            } break;
            case 9: ifThatShipDestroyedDeckSizeMatters(f, i, j, 2); break;
            case 10: ifThatShipDestroyedDeckSizeMatters(f, i, j, 3); break;
            case 11: ifThatShipDestroyedDeckSizeMatters(f, i, j, 4); break;
            default: break;
        }
    }
    //main method
    void run(){
        Battleships bs = new Battleships();
        int[][] field = bs.Field;
        bs.GenerateShipsOnTheField(field);
        System.out.println("Enter your shoot coordinates in <letter>-<number> format.");
        System.out.println("Letters from <a> to <j>; Numbers from 1 to 10; For example: a-2, c-3, etc");
        System.out.println("You have " + ATTEMPTS_NUMBER + " tries to clear the battlefield");
        int attempts = ATTEMPTS_NUMBER;
        bs.DrawField(field);
       while (attempts >= 1){
           //here we'll get coordinates of our shot from the console
            Scanner in = new Scanner(System.in);
            String coordinates = in.nextLine();
            int x = 0, y = 0;
            for (int i = 1; i <= 10 ; i++) {
                if (i == (coordinates.charAt(2) - '0')) x = i - 1;
            }
            switch(coordinates.charAt(0)){
                case 'a': y = 0; break;
                case 'b': y = 1; break;
                case 'c': y = 2; break;
                case 'd': y = 3; break;
                case 'e': y = 4; break;
                case 'f': y = 5; break;
                case 'g': y = 6; break;
                case 'h': y = 7; break;
                case 'i': y = 8; break;
                case 'j': y = 9; break;
                default: System.out.println("no such tile on the field exception");
            }
            field[x][y] += 7;
            switch (field[x][y]) {
                case 6:
                case 7: {
                    System.out.println("Miss!");
                    break;
                }
                case 8:
                case 9:
                case 10:
                case 11: {
                    System.out.println("Hit!");
                    ifThatShipDestroyed(field, x, y);
                    attempts++; break;
                }
                case 5:
                case -2:
                {System.out.println("This area is around ship that you already destroyed, this shot was meaningless...")
                ; break;}
                default: {
                    System.out.println("You already shot that area!"); break;
                }
            }
            if (testGameEnd(field) == 1) {System.out.println("Congratulations, you win!"); break;}
            else attempts--;
       }
    }
}
