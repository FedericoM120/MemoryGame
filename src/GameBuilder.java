import java.util.Scanner;
import java.util.Random;
public class GameBuilder {
    private Random r;
    private static char[] actualChoices;
    private static int[] indexesChosen;
    private char memoryGameValue;

    public GameBuilder() {
        r =  new Random();
        actualChoices = new char[]{'!', '!','!', '!','!', '!','!', '!'};
        indexesChosen = new int[]{10,10,10,10,10,10,10,10};
        memoryGameValue = (char)(r.nextInt(26) + 'A');
    }
    private static void playGame() {
        int breakForLoop = 0;

        int l = 0;

        for (l = 0; l < actualChoices.length; l++){
            if (breakForLoop == 8){
                break;
            }
        }
    }
    private static void firstIndexFound(int l) {
        for (int m = l; m < indexesChosen.length; m++){
            if (indexesChosen[m] != 10) {
                l++;
            } else {
                break;
            }
        }
    }

    private static void secondIndexFound(){

    }

    private static void letterFound() {

    }

}

