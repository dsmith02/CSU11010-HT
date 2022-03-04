//ResolveBet
//        I have correctly defined ResolveBet which takes the bet type(String)and the Wallet object,and a void return type[Mark out of 7: 7].
//        Comment: Yep, it follows the spec.
//        My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet[Mark out of 8: 8].
//        Comment: Yes, at the start.
//        My program ensures the bet amount is not greater than the cash in the wallet[Mark out of 5: 5].
//        Comment: Yes, it calls another subroutine for that.
//        My program creates three Dice objects,rolls them and creates a total variable with a summation of the roll values returned[Mark out of 15: 15]..
//        Comment: Yes, it uses different methods to accomplish these functions.
//        My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet[Mark out of 20: 20].
//        Comment: Yep, one method checks the results of other methods depending on the bet type and uses the functionality outlined.
//        My program outputs the results(win or loss)and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses[Mark out of 10: 10].
//        Comment: Yep, does it correctly.
//
//        2.Main
//        I ask the user for the amount of cash he/she has,create a Wallet object and put this cash into it[Mark out of 15: 15]
//        Comment: Yep, happens just fine.
//        My program loops continuously until the user either enters quit or the cash in the wallet is 0[Mark out of 5: 5]
//        Comment: Yep, it quits when it needs to.
//        I ask the user to enter any of the four bet types or quit[Mark out of 5: 5].
//        Comment: Yes, it uses a separate method for this.
//        My program calls resolveBet for each bet type entered[Mark out of 5: 5].
//        Comment: Yep, every time.
//        At the end of the game my program presents a summary message regarding winnings and losses[Mark out of 5: 5]
//        Comment: Yep, it prints some summary statistics.
//
//        Total Mark out of 100(Add all the previous marks): 100
//        */
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    /**
     * CONSTANTS
     */
    private static final String DIVIDER = "———————————————————————————————";
    private static final String BET_FORMAT = "([1-9]+0*.[0-9]*)";
    private static final String VALID_BET_TYPE = "(Triple|Field|High|Low|triple|field|high|low)";
    private static final Scanner scanner = new Scanner(System.in);
    private static final int NUM_OF_DICES = 3;
    private static final double MINIMUM_BALANCE = 0.0;
    private static int CORRECT_BETS = 0;
    private static int INCORRECT_BETS = 0;
    private static double STARTING_BALANCE = 0;

    public static void main(String[] args)
    {
        System.out.println(DIVIDER + "\nWelcome to Chuck-A-Luck\n" + DIVIDER);
        Wallet playerWallet = createPlayerWallet();
        while (playerWallet.check() > MINIMUM_BALANCE)
        {
            String betType = getBetType();
            if (betType.equalsIgnoreCase("quit"))
            {
                break;
            }
            resolveBet(betType, playerWallet);
        }
        printSummary(playerWallet);
    }

    /**
     * Prints the summary statistics of the players game.
     * @param playerWallet
     */
    public static void printSummary(Wallet playerWallet)
    {
        System.out.println(DIVIDER
                + "\nSUMMARY\n"
                + DIVIDER
                + "\nStarting balance: " + STARTING_BALANCE
                + "\nEnd balance: " + playerWallet.check()
                + "\nWins: " + CORRECT_BETS
                + "\nLosses: " + INCORRECT_BETS
                + "\nThanks for playing Chuck-a-Luck!");
    }

    /**
     * Gets the user to enter the bet it wishes to make or the word quit and returns this to main.
     * @return
     */
    public static String getBetType()
    {
        System.out.println("You can place the following bets:\n1. Triple\n2. Field\n3. High\n4. Low");
        System.out.print("Please enter the bet you wish to make> ");
        String betType = scanner.nextLine();
        while (!betType.equalsIgnoreCase("quit") && !betType.matches(VALID_BET_TYPE))
        {
            System.out.println("Invalid bet! It must be one of the following:\n1. Triple\n2. Field\n3. High\n4. Low");
            System.out.print("Please enter the bet you wish to make (enter quit to leave)> ");
            betType = scanner.nextLine();
        }
        return betType;
    }

    /**
     * Creates a player wallet and has the functionality to deal with invalid input.
     * @return
     */
    public static Wallet createPlayerWallet()
    {
        System.out.print("Enter the cash you have> ");
        String rawInput = scanner.nextLine();
        while (!rawInput.matches(BET_FORMAT))
        {
            System.out.print("Invalid input! Please enter a decimal number> ");
            rawInput = scanner.nextLine();
        }
        double userCash = Double.parseDouble(rawInput);
        STARTING_BALANCE = userCash;
        Wallet playerWallet = new Wallet();
        playerWallet.put(userCash);
        return playerWallet;
    }

    /**
     * Gets a valid value of a bet and makes sure it can be subtracted from the wallet.
     * @param playerWallet
     * @return
     */
    public static double getBet(Wallet playerWallet)
    {
        System.out.print("Wallet balance: " + playerWallet.check() + "\nHow much would you like to bet? ");
        String rawInput = scanner.nextLine();
        while (!rawInput.matches(BET_FORMAT) || Double.parseDouble(rawInput) > playerWallet.check())
        {
            if (!rawInput.matches(BET_FORMAT))
            {
                System.out.println("Incorrect input. You must enter a decimal number.");
            }
            else
            {
                System.out.println("Insufficient balance. Please place another bet!");
                System.out.println("Wallet balance: " + playerWallet.check());
            }
            System.out.print("How much would you like to bet? ");
            rawInput = scanner.nextLine();
        }
        return Double.parseDouble(rawInput);
    }

    /**
     * Checks if the player has won according to their bet type and the state of the dices.
     * @param betType
     * @param arrayOfDices
     * @return
     */
    public static boolean checkForWin(String betType, ArrayList<Dice> arrayOfDices)
    {
        if (betType.equalsIgnoreCase("Triple") && checkForTriple(arrayOfDices))
        {
            return true;
        }
        else if (betType.equalsIgnoreCase("Field") && checkForField(arrayOfDices))
        {
            return true;
        }
        else if (betType.equalsIgnoreCase("High") && checkForHigh(arrayOfDices))
        {
            return true;
        }
        else if (betType.equalsIgnoreCase("Low") && checkForLow(arrayOfDices))
        {
            return true;
        }
        return false;
    }

    /**
     * Directs all the other methods in determining if the player won or lost; also handles the addition/removal of money
     * from the player wallet.
     * @param betType
     * @param playerWallet
     */
    public static void resolveBet(String betType, Wallet playerWallet)
    {
        double bet = getBet(playerWallet);
        ArrayList<Dice> diceList = new ArrayList<>();
        initDiceArray(diceList, NUM_OF_DICES);
        rollDiceArray(diceList);
        if (checkForWin(betType, diceList))
        {
            System.out.println("You won! You successfully got a " + betType);
            playerWallet.put(betType.equalsIgnoreCase("Triple") ? (bet * 30) + bet : bet * 2);
            CORRECT_BETS++;
        }
        else
        {
            System.out.println("You lost! You failed to get a " + betType);
            playerWallet.get(playerWallet.check() < bet ? playerWallet.check() : bet);
            INCORRECT_BETS++;
        }
        System.out.println("After this round of betting, your balance is: " + playerWallet.check());
    }

    /**
     * Sums the faces of the die array.
     * @param arrayOfDices
     * @return
     */
    public static int computeTotalOfFaces(ArrayList<Dice> arrayOfDices)
    {
        int sum = 0;
        for (Dice dice : arrayOfDices)
        {
            sum += dice.topFace();
        }
        return sum;
    }

    /**
     * Initialises the indexes of the die array with Dice objects.
     * @param arrayOfDices
     * @param elemsToAdd
     * @return
     */
    public static ArrayList<Dice> initDiceArray(ArrayList<Dice> arrayOfDices, int elemsToAdd)
    {
        for (int index = 0; index < elemsToAdd; index++)
        {
            arrayOfDices.add(index, new Dice());
        }
        return arrayOfDices;
    }

    /**
     * Rolls all the dice in an array of arbitrary length.
     * @param arrayOfDices
     */
    public static void rollDiceArray(ArrayList<Dice> arrayOfDices)
    {
        for (Dice currentDice : arrayOfDices)
        {
            currentDice.roll();
        }
    }

    /**
     * Checks if the dice faces are a triple.
     * @param arrayOfDices
     * @return
     */
    public static boolean checkForTriple(ArrayList<Dice> arrayOfDices)
    {
        for (int index = 1; index < arrayOfDices.size(); index++)
        {
            int currentDiceTopFace = arrayOfDices.get(index).topFace();
            int previousDiceTopFace = arrayOfDices.get(index - 1).topFace();
            // 1 & 6 are excluded from the triple bet.
            if (currentDiceTopFace != previousDiceTopFace
                    || (currentDiceTopFace == 1 || currentDiceTopFace == 6))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the dice represent a field.
     * @param arrayOfDices
     * @return
     */
    public static boolean checkForField(ArrayList<Dice> arrayOfDices)
    {
        int total = computeTotalOfFaces(arrayOfDices);
        if (total < 8 || total > 12)
        {
            return true;
        }
        return false;
    }

    /**
     * Checks of the dice represent a high.
     * @param arrayOfDices
     * @return
     */
    public static boolean checkForHigh(ArrayList<Dice> arrayOfDices)
    {
        int total = computeTotalOfFaces(arrayOfDices);
        if (total > 10 && !checkForField(arrayOfDices))
        {
            return true;
        }
        return false;
    }

    /**
     * Checks if the dice represent a low.
     * @param arrayOfDices
     * @return
     */
    public static boolean checkForLow(ArrayList<Dice> arrayOfDices)
    {
        int total = computeTotalOfFaces(arrayOfDices);
        if (total < 11 && !checkForTriple(arrayOfDices))
        {
            return true;
        }
        return false;
    }
}
