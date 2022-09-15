import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RectangleIntoSquares {

    public boolean checkIfRectangle(int length, int width) {
        if (length == width) return false;
        return length >= 1 && width >= 1;
    }


    public List<Integer> calculateSquareSizes(int length, int width) {
            List<Integer> SquareSizeList = new ArrayList<>();
            int minSquareSize = min(length, width);
            int maxSquareSize = max(length, width);
            if (minSquareSize == maxSquareSize) {
                SquareSizeList.add(minSquareSize);
            } else{
                SquareSizeList.add(minSquareSize);
                SquareSizeList.addAll(calculateSquareSizes(maxSquareSize - minSquareSize, minSquareSize));
            }
            return SquareSizeList;
    }
}
