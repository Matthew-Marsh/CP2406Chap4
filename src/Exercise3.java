import textio.TextIO;

public class Exercise3 {
    public static void main(String[] args) {
        int numberOfRolls;
        System.out.print("Enter number of required roll: ");
        int numberWanted = TextIO.getInt();
        numberOfRolls = rollDice(numberWanted);
        System.out.printf("It took %d rolls to get a %d.", numberOfRolls, numberWanted);
    }

    public static int rollDice(int number) {
        if (number < 2 || number > 12) {
            throw new IllegalArgumentException("Invalid possible result.");
        }
        int diceOne = (int) (Math.random() * 6 + 1);
        int diceTwo = (int) (Math.random() * 6 + 1);
        int numberOfRolls = 1;

        while ((diceOne + diceTwo) != number) {
            diceOne = (int) (Math.random() * 6 + 1);
            diceTwo = (int) (Math.random() * 6 + 1);
            numberOfRolls++;
        }
        return numberOfRolls;
    }
}
