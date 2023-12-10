import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] actualChoices = new String[]{"C", "D", "A", "B", "B", "D", "A", "C"};

        String[] appearance = new String[]{"null", "null", "null", "null", "null", "null", "null", "null"};

        for (int j = 0; j < appearance.length; j++) {
            System.out.print(appearance[j] + "| ");
        }
        System.out.println("");

        int i = 0;
        while (i < 20) {
            System.out.println("Enter an index: ");
            int firstIndex = scanner.nextInt();

            System.out.println("Enter second index");
            int secondIndex = scanner.nextInt();

            while (firstIndex == secondIndex) {
                System.out.println("Can't choose the same index for both choices");
                System.out.println("Enter second index");
                secondIndex = scanner.nextInt();
            }
            //if choices match then they need appear permanently
            if (actualChoices[firstIndex] == actualChoices[secondIndex]) {
                appearance[firstIndex] = actualChoices[firstIndex];
                appearance[secondIndex] = actualChoices[secondIndex];
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
            if (nullOrBlankCounter == 0) {
                i += 300;
            }
            nullOrBlankCounter = 0;
        }
    }
}
