import textio.TextIO;

public class Exercise8 {

    private static int[] firstNumbers;
    private static int[] secondNumbers;
    private static int[] answerNumbers;

    public static void main(String[] args) {
        createQuiz();
        startQuiz();
        checkAnswer();
    }

    public static void createQuiz() {
        firstNumbers = new int[10];
        secondNumbers = new int[10];
        answerNumbers = new int[10];
        for (int i = 0; i < 10; i++) {
            firstNumbers[i] = (int) (Math.random() * 1000 + 1);
            secondNumbers[i] = (int) (Math.random() * 1000 + 1);
        }
    }

    public static void startQuiz() {
        int questionNumber;
        for (int i = 0; i < 10; i++) {
            questionNumber = i + 1;
            System.out.printf("%2d: What is %3d + %3d equal to? ", questionNumber, firstNumbers[i], secondNumbers[i]);
            answerNumbers[i] = TextIO.getlnInt();
        }
    }

    public static void checkAnswer() {
        int questionNumber;
        int numberOfCorrectAnswers = 0;
        for (int i = 0; i < 10; i++) {
            questionNumber = i + 1;
            int correctAnswer = firstNumbers[i] + secondNumbers[i];
            System.out.printf("%2d: What is %3d + %3d equal to? %4d - ", questionNumber, firstNumbers[i], secondNumbers[i], correctAnswer);
            if ((firstNumbers[i] + secondNumbers[i]) == answerNumbers[i]) {
                System.out.printf("Congratulations you were correct.%n");
                numberOfCorrectAnswers++;
            } else {
                System.out.printf("Your answer of %4d was incorrect.%n", answerNumbers[i]);
            }
        }
        System.out.printf("You got a total of %d answers correct.%n", numberOfCorrectAnswers);
        int score = numberOfCorrectAnswers * 10;
        System.out.printf("You got a score of %d.%n", score);
    }
}
