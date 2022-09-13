import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class rectangleIntoSquaresTest {

    @Test
    public void checkIfItIsARectangle() throws Exception {
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        assertFalse(rectangleIntoSquares.checkIfRectangle(2, 2));
        assertTrue(rectangleIntoSquares.checkIfRectangle(3, 2));
    }

    @Test
    public void returnSquareSize() throws Exception {
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        List<Integer> SquareSizeList = new ArrayList<>();
        SquareSizeList.add(3);
        SquareSizeList.add(2);
        SquareSizeList.add(1);
        SquareSizeList.add(1);
        assertEquals(SquareSizeList, rectangleIntoSquares.calculateSquareSizes(5, 3));
        assertEquals(SquareSizeList, rectangleIntoSquares.calculateSquareSizes(3, 5));

    }

    @Test
    public void returnSquareSizeNull() throws Exception {
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        assertEquals(null, rectangleIntoSquares.calculateSquareSizes(2, 2));
    }
}


