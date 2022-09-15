import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RectangleIntoSquaresTest {

    @Test
    public void checkIfItIsARectangle(){
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        assertFalse(rectangleIntoSquares.checkIfRectangle(2, 2));
        assertTrue(rectangleIntoSquares.checkIfRectangle(3, 2));
    }

    @Test
    public void returnSquareSize(){
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
    public void returnSquareSize_2_2(){
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        List<Integer> SquareSizeList = new ArrayList<>();
        SquareSizeList.add(2);
        assertEquals(SquareSizeList, rectangleIntoSquares.calculateSquareSizes(2, 2));
    }

    @Test
    public void returnSquareSize_10_2(){
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        List<Integer> SquareSizeList = new ArrayList<>();
        SquareSizeList.add(2);
        SquareSizeList.add(2);
        SquareSizeList.add(2);
        SquareSizeList.add(2);
        SquareSizeList.add(2);
        assertEquals(SquareSizeList, rectangleIntoSquares.calculateSquareSizes(10, 2));
    }

    @Test
    public void returnSquareSize_10_5(){
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        List<Integer> SquareSizeList = Arrays.asList(5, 5);
        assertEquals(SquareSizeList, rectangleIntoSquares.calculateSquareSizes(10, 5));
    }
}


