import java.util.Scanner;
import java.util.Random;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String[] actualChoices = new String[]{"C", "D", "A", "B", "B", "D", "A", "C"};

        Random r = new Random();
        char[] actualChoices = new char[8];

        int[] indexesChosen = new int[]{10,10,10,10,10,10,10,10};

        for (int l = 0; l < actualChoices.length; l++){
            char memoryGameValue = (char)(r.nextInt(26) + 'A');

            //actualChoices[l] = memoryGameValue;
            for (int m = l; m < indexesChosen.length; m++){
                if (indexesChosen[m] != 10) {
                    l++;
                } else {
                    break;
                }
            }
            actualChoices[l] = memoryGameValue;
            indexesChosen[l] = l;
            int matchingLetterIndex = r.nextInt(8 - l) + l;
            boolean indexFound = false;
            while (indexFound == false) {
                // matchingLetterIndex is in the array of indexesChosen, then keep generating a number until its not in the array
                for (int j = l; j < indexesChosen.length; j++){
                    if (matchingLetterIndex == indexesChosen[j]) {
                        matchingLetterIndex = r.nextInt(8);
                        j = 0;
                    } else {
                        actualChoices[matchingLetterIndex] = memoryGameValue;
                        indexesChosen[matchingLetterIndex] = matchingLetterIndex;
                        indexFound = true;
                        break;
                    }
                }
            }
        }

        String[] appearance = new String[]{"null", "null", "null", "null", "null", "null", "null", "null"};

        for (int j = 0; j < appearance.length; j++) {
            System.out.print(appearance[j] + "| ");
        }
        System.out.println("");

        int i = 0;
        while (i < 20) {

            int firstIndex = 0;
            boolean validFirstIndexChoice = false;

            while (validFirstIndexChoice != true){
                System.out.println("Enter first index: ");
                firstIndex = scanner.nextInt();
                System.out.println(firstIndex + " = " + actualChoices[firstIndex]);
                if (appearance[firstIndex] != "null" && appearance[firstIndex] != " ") {
                    System.out.println("This index has already been found. Please choose another index.");
                } else {
                    break;
                }
            }

            boolean validSecondIndexChoice = false;
            int secondIndex = 0;

            while (validSecondIndexChoice != true){
                System.out.println("Enter second index: ");
                secondIndex = scanner.nextInt();
                System.out.println(secondIndex + " = " + actualChoices[secondIndex]);
                if (appearance[secondIndex] != "null" && appearance[secondIndex] != " ") {
                    System.out.println("This index has already been found. Please choose another index.");
                } else {
                    break;
                }
            }

            while (firstIndex == secondIndex) {
                    System.out.println("Can't choose the same index for both choices");
                    System.out.println("Enter second index");
                    secondIndex = scanner.nextInt();
            }

            //if choices match then they need appear permanently
            if (actualChoices[firstIndex] == actualChoices[secondIndex]) {
                appearance[firstIndex] = String.valueOf(actualChoices[firstIndex]);
                appearance[secondIndex] = String.valueOf(actualChoices[secondIndex]);
            } else if (actualChoices[firstIndex] != actualChoices[secondIndex]) {
                appearance[firstIndex] = " ";
                appearance[secondIndex] = " ";
            }

            for (int j = 0; j < appearance.length; j++) {
                System.out.print(appearance[j] + "| ");
            }
            System.out.println("");
            i++;

            int nullOrBlankCounter = 0;
            for (int k = 0; k < appearance.length; k++) {
                if (appearance[k] == "null" || appearance[k] == " ") {
                    nullOrBlankCounter+= 1;
                }
            }
            String playAgain;
            if (nullOrBlankCounter == 0) {
                i += 300;
                System.out.println("You won! Game Over.");
                System.out.println("Play again? Enter y for yes n for no");
                playAgain = scanner.next();
                if (playAgain.equals("y")) {
                    appearance = new String[]{"null", "null", "null", "null", "null", "null", "null", "null"};
                    i = 0;
                } else {
                    i+=20;
                }
            }
            nullOrBlankCounter = 0;
        }
    }
}
