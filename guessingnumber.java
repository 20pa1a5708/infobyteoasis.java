import java.util.*;
public class GuessNumber {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        GuessNumber methodChange = new GuessNumber();
        methodChange.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        GuessNumber methodChange = new GuessNumber();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("WELCOME TO THE NUMBER GAME");
        System.out.println("1. PLAY THE GAME");
        System.out.println("2. SCORE BOARD");
        System.out.println("3.EXIT THE GAME");
        System.out.println("--------------------");
        try {
            System.out.print("WHAT ACTION WOULD YOU LIKE TO DO FROM ABOVE? ");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"WHAT WOULD YOU LIKE THE RANGE OF THE NUMBERS TO BE? ");
                    int numberRange = input.nextInt();
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"THANKS FOR PLAYING!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("INVALID ENTRY.TRY AGAIN");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("ENTER YOUR GUESS NUMBER: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("LOWER");
            } else if (userGuess < randomNumber) {
                System.out.println("HIGHER");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("YOU ANSWERED NUMBER IS RIGHT IN " + guess + " TRY!");
        } else {
            System.out.println("YOU ANSWERED NUMBER IS RIGHT IN " + guess + " TRIES!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("SCORE BOARD");
        System.out.println("--------------------");
        System.out.println("YOUR FASTEST GAMES TODAY OUT OF ALL TRIES IS: " +"\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("FINISHED THE NUMBER GAME IN " + scores + " TRIES");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}
