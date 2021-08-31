import textio.TextIO;

public class Exercise1 {
    public static void main(String[] args) {
        String line;
        System.out.print("Enter line: ");
        line = TextIO.getln();
        boolean wasLetter = false;
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if (Character.isLetter(letter)) {
                if (!(wasLetter)) {
                    letter = Character.toUpperCase(letter);
                }
                wasLetter = true;
            } else {
                wasLetter = false;
            }
            System.out.print(letter);
        }
        System.out.println();
    }
}
