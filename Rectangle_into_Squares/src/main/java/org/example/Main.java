package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        sqInRect(10, 5);
    }

    public static void  sqInRect(int length, int width) {
        int cycle_length;
        int cycle_width;
        ArrayList<Integer> found_squares_Array = new ArrayList<>();

        cycle_length =length;
        cycle_width = width;

        while (cycle_length>0){
            int[] result_array = return_largest_rectangle(cycle_length, cycle_width);
            cycle_length=result_array[1];
            cycle_width=result_array[2];
            found_squares_Array.add(result_array[0]);
        }
        System.out.println(found_squares_Array);
    }


    public static int[] return_largest_rectangle(int length, int width) {
        int[] intArray = new int[3];


        //rotate rectangle to standard orientation
        int standard_length = rotate_rectangle(length, width)[0];
        int standard_width = rotate_rectangle(length, width)[1];

        int remaining_standard_length= standard_width-standard_length; //this variable will become 0 if the smallest possible square (1x1) is reached
        int remaining_standard_width = standard_length; //length becomes the width bc this side is now the larger side which is how we rotated our rectangle initially
        int larges_square_length=standard_length;

        intArray[0] = larges_square_length;
        intArray[1] = remaining_standard_length;
        intArray[2] = remaining_standard_width;

        return intArray;
    }

    public static int[] rotate_rectangle(int length, int width) {
        int[] rotated_rectangle_length_width_array = new int[2];

        int standard_orientation_width;
        int standard_orientation_length;

        if (length>width){//if the input_length is greater than width we switch the variables, so we can code exactly for that case (otherwise we'd need two cases)
            standard_orientation_width=length;
            standard_orientation_length=width;
        }
        else {
            standard_orientation_length=length;
            standard_orientation_width=width;
        }//now with>length, we have rotated the rectangle

        rotated_rectangle_length_width_array[0]=standard_orientation_length;
        rotated_rectangle_length_width_array[1]=standard_orientation_width;

        return rotated_rectangle_length_width_array;
    }


}