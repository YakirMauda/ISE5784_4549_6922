package renderer;

/**
 * The Pixel class represents a pixel with a row and column in a 2D grid.
 * It includes functionality for initializing pixel grid dimensions,
 * generating the next pixel in the grid, and tracking the progress of processed pixels.
 */
record Pixel(int row, int col) {

    private static int maxRows = 0;
    private static int maxCols = 0;
    private static long totalPixels = 0L;
    private static volatile int cRow = 0;
    private static volatile int cCol = -1;
    private static volatile long pixels = 0L;
    private static volatile int lastPrinted = 0;
    private static boolean print = false;
    private static long printInterval = 100L;
    private static final String PRINT_FORMAT = "%5.1f%%\r";
    private static Object mutexNext = new Object();
    private static Object mutexPixels = new Object();

    /**
     * Initializes the pixel grid dimensions and the printing interval.
     *
     * @param maxRows  the maximum number of rows in the grid
     * @param maxCols  the maximum number of columns in the grid
     * @param interval the interval at which to print the progress (as a percentage)
     */
    static void initialize(int maxRows, int maxCols, double interval) {
        Pixel.maxRows = maxRows;
        Pixel.maxCols = maxCols;
        Pixel.totalPixels = (long) maxRows * maxCols;
        printInterval = (int) (interval * 10);
        if (print = printInterval != 0) System.out.printf(PRINT_FORMAT, 0d);
    }

    /**
     * Returns the next pixel in the grid.
     *
     * @return the next Pixel object, or null if all pixels have been processed
     */
    static Pixel nextPixel() {
        synchronized (mutexNext) {
            if (cRow == maxRows) return null;
            ++cCol;
            if (cCol < maxCols) return new Pixel(cRow, cCol);
            cCol = 0;
            ++cRow;
            if (cRow < maxRows) return new Pixel(cRow, cCol);
        }
        return null;
    }

    /**
     * Marks a pixel as processed and prints the progress if the print interval is met.
     */
    static void pixelDone() {
        boolean flag = false;
        int percentage = 0;
        synchronized (mutexPixels) {
            ++pixels;
            if (print) {
                percentage = (int) (1000L * pixels / totalPixels);
                if (percentage - lastPrinted >= printInterval) {
                    lastPrinted = percentage;
                    flag = true;
                }
            }
        }
        if (flag) System.out.printf(PRINT_FORMAT, percentage / 10d);
    }
}
