import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RectangleIntoSquares {

    public boolean checkIfRectangle(int length, int width) {
        if (length == width  && length > 1) return false;
        if (length < 1 && width < 1) return false;
        return true;
    }


    public List<Integer> calculateSquareSizes(int length, int width) {
        if (checkIfRectangle(length, width)){
            List<Integer> SquareSizeList = new ArrayList<Integer>();
            int minSquareSize = min(length, width);
            int maxSquareSize = max(length, width);
            if (minSquareSize == maxSquareSize && minSquareSize == 1) {
                SquareSizeList.add(1);
            } else{
                SquareSizeList.add(minSquareSize);
                SquareSizeList.addAll(calculateSquareSizes(maxSquareSize - minSquareSize, minSquareSize));
            }
            return SquareSizeList;
        }
        System.out.println("Not Valid Rectangle");
        return null;
    }
}
