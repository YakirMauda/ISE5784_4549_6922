package renderer;

/**
 * The Pixel record represents a pixel with a row and column in a 2D grid.
 * It includes functionality for initializing pixel grid dimensions,
 * generating the next pixel in the grid, and tracking the progress of processed pixels.
 */
record Pixel(int row, int col) {

    // Maximum number of rows in the pixel grid
    private static int maxRows = 0;
    // Maximum number of columns in the pixel grid
    private static int maxCols = 0;
    // Total number of pixels in the grid
    private static long totalPixels = 0L;
    // Current row being processed
    private static volatile int cRow = 0;
    // Current column being processed
    private static volatile int cCol = -1;
    // Number of pixels processed so far
    private static volatile long pixels = 0L;
    // Last printed percentage progress
    private static volatile int lastPrinted = 0;
    // Flag to determine if progress should be printed
    private static boolean print = false;
    // Interval at which to print progress (in tenths of a percent)
    private static long printInterval = 100L;
    // Format string for printing progress
    private static final String PRINT_FORMAT = "%5.1f%%\r";
    // Mutex for synchronizing access to nextPixel method
    private static Object mutexNext = new Object();
    // Mutex for synchronizing access to pixel count and progress printing
    private static Object mutexPixels = new Object();

    /**
     * Initializes the pixel grid dimensions and the printing interval.
     *
     * @param maxRows  the maximum number of rows in the grid
     * @param maxCols  the maximum number of columns in the grid
     * @param interval the interval at which to print the progress (as a percentage)
     */
    static void initialize(int maxRows, int maxCols, double interval) {
        // Set the maximum dimensions of the grid
        Pixel.maxRows = maxRows;
        Pixel.maxCols = maxCols;

        // Calculate the total number of pixels in the grid
        Pixel.totalPixels = (long) maxRows * maxCols;

        // Convert the interval to tenths of a percent and store it
        printInterval = (int) (interval * 10);

        // Enable printing if the interval is non-zero, and print the initial 0% progress
        if (print = printInterval != 0) System.out.printf(PRINT_FORMAT, 0d);
    }

    /**
     * Returns the next pixel in the grid.
     * @return the next Pixel object, or null if all pixels have been processed
     */
    static Pixel nextPixel() {
        synchronized (mutexNext) {
            // Check if we've processed all rows
            if (cRow == maxRows) return null;

            // Move to the next column
            ++cCol;

            // If we're still within the current row, return the new pixel
            if (cCol < maxCols) return new Pixel(cRow, cCol);

            // If we've reached the end of the row, move to the next row
            cCol = 0;
            ++cRow;

            // If we're still within the grid, return the new pixel
            if (cRow < maxRows) return new Pixel(cRow, cCol);
        }
        // If we've processed all pixels, return null
        return null;
    }

    /**
     * Marks a pixel as processed and prints the progress if the print interval is met.
     */
    static void pixelDone() {
        boolean flag = false;
        int percentage = 0;
        synchronized (mutexPixels) {
            // Increment the count of processed pixels
            ++pixels;

            if (print) {
                // Calculate the current progress as a percentage (in tenths of a percent)
                percentage = (int) (1000L * pixels / totalPixels);

                // Check if we've reached the next print interval
                if (percentage - lastPrinted >= printInterval) {
                    lastPrinted = percentage;
                    flag = true;
                }
            }
        }
        // If we've reached a print interval, print the progress
        if (flag) System.out.printf(PRINT_FORMAT, percentage / 10d);
    }
}