public class main {
    public static void main(String[] args) {
        RectangleIntoSquares rectangleIntoSquares = new RectangleIntoSquares();
        if (rectangleIntoSquares.checkIfRectangle(2,2)){
            System.out.println(rectangleIntoSquares.calculateSquareSizes(2,2));
        }
        else {System.out.println("Not Valid Square!");}
    }
}
