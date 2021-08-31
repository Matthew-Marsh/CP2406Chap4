public class Exercise4 {
    public static void main(String[] args) {
        double numberOfRolls;
        System.out.println("Total On Dice     Average Number of Rolls");
        System.out.println("-------------     -----------------------");
        int numberWanted;
        for (numberWanted = 2; numberWanted <= 12; numberWanted++) {
            numberOfRolls = rollDice(numberWanted);
            System.out.printf("%7d%22.4f%n", numberWanted, numberOfRolls);
        }
    }

    public static double rollDice(int number) {
        int diceOne;
        int diceTwo;
        double numberOfRolls = 0.0;
        double averageNumberOfRolls;

        for (int i = 0; i <= 10000; i++) {
            diceOne = 0;
            diceTwo = 0;
            while ((diceOne + diceTwo) != number) {
                diceOne = (int) (Math.random() * 6 + 1);
                diceTwo = (int) (Math.random() * 6 + 1);
                numberOfRolls++;
            }
        }
        averageNumberOfRolls = (numberOfRolls / 10000);
        return averageNumberOfRolls;
    }
}
