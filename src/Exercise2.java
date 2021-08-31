import textio.TextIO;

public class Exercise2 {
    public static void main(String[] args) {
        String line;
        System.out.print("Enter the Hex Line: ");
        line = TextIO.getlnWord();
        int value;
        value = 0;
        int number;
        for (int i = 0; i < line.length(); i++) {
            number = hexValue(line.charAt(i));
            if (number != -1) {
                value = value*16 + number;
            } else {
                System.out.println("Entered a number that isn't hexadecimal. Must be: a-f, A-F, or 0-9.");
                return;
            }
        }
        System.out.println("Base-10 Value is: " + value);
    }

    public static int hexValue(char character) {
        switch (character) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
            case 'a':
                return 10;
            case 'B':
            case 'b':
                return 11;
            case 'C':
            case 'c':
                return 12;
            case 'D':
            case 'd':
                return 13;
            case 'E':
            case 'e':
                return 14;
            case 'F':
            case 'f':
                return 15;
            default:
                return -1;
        }
    }
}
