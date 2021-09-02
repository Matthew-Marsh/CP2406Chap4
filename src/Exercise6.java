import mosaic.Mosaic;

/**
 * This program opens a window full of randomly colored squares.  A "disturbance"
 * moves randomly around in the window, randomly changing the color of each
 * square that it visits.  The program runs until the user closes the window.
 *
 * Modified Version of RandomMosaicWalk2 for Exercise 4.6
 */
public class Exercise6 {

    final static int ROWS = 20;        // Number of rows in mosaic.
    final static int COLUMNS = 30;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 20; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    /**
     * The main program creates the window, removes the 3D effect,  fills it with black squares,
     * and then moves the disturbances in a random walk around the window
     * as long as the window is open.
     */
    public static void main(String[] args) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        Mosaic.setUse3DEffect(false);
        fillWithBlackColour();
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while (true) {
            int greenLevel = Mosaic.getGreen(currentRow, currentColumn);
            if (greenLevel < 255) {
                greenLevel += 25;
                Mosaic.setColor(currentRow,currentColumn,0, greenLevel, 0);
            }
            randomMove();
            Mosaic.delay(5);  // Remove this line to speed things up!
        }
    }  // end main

    /**
     * Fills the window with black squares.
     * Precondition:   The mosaic window is open.
     * Postcondition:  Each square has been set to black.
     */
    static void fillWithBlackColour() {
        for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                Mosaic.setColor(row,column,0, 0, 0);
            }
        }
    }  // end fillWithRandomColors

    /**
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  currentRow or currentColumn is changed to one of the
     *                 neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid.
     */
    static void randomMove() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
            case 0:  // move up
                currentRow--;
                if (currentRow < 0)
                    currentRow = ROWS - 1;
                break;
            case 1:  // move right
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
                break;
            case 2:  // move down
                currentRow ++;
                if (currentRow >= ROWS)
                    currentRow = 0;
                break;
            case 3:  // move left
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
                break;
        }
    }  // end randomMove

}
