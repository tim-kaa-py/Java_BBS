package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[][] validSudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        int[][] invalidBlockSudoku = {
                {5, 3, 6, 4, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        int[][] invalidRowSudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 9, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 3}
        };


        int[][] invalidColumnSudoku = {
                {5, 3, 4, 6, 8, 7, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };



        if (validSolution(validSudoku)){
            System.out.println("The sudoku is VALID!");
        }
        else {
            System.out.println("The sudoku is INVALID!");
        }
    }

    private static Boolean validSolution(int[][] sudoku) {

        return isHistogramCorrect(sudoku) && validBlocks(sudoku) && validRows(sudoku) && validColumns(sudoku);


    }

    private static Boolean isHistogramCorrect(int[][] sudoku) {

        List<Integer> allElementList = arrayToList(sudoku,1,9,1,9);

        int[] allowedEntries = new int[]{1,2,3,4,5,6,7,8,9};

        for (int allowedEntry : allowedEntries){
            //Check that all allowed entries exist exactly 9 times
            int occurrences = Collections.frequency(allElementList, allowedEntry);
            if (occurrences != 9){
                System.out.printf("Element %s exists %s times instead of 9 times.%n",allowedEntry,occurrences);
                return false;
            }
        }
        return true;
    }

    private static List<Integer> arrayToList(int[][] sudoku,int startRow, int endRow, int startColumn, int endColumn) {

        List<Integer> dataArray = new ArrayList<>();


        for (int row = startRow; row <= endRow; ++row) {
            int rowIndex = row - 1;
            for (int column = startColumn; column <= endColumn; ++column) {
                int columnIndex = column - 1;
                dataArray.add(sudoku[rowIndex][columnIndex]);
            }
        }
        return dataArray;
    }





    private static Boolean validBlocks(int[][] sudoku) {

        int[] blocks = new int[]{1,2,3,4,5,6,7,8,9};

        for (int block:blocks){
            if(!isOneBlockValid(block,sudoku)){
                return false;
            }
        }
        return true;
    }

    private static boolean isOneBlockValid(int block, int[][] sudoku) {

        int[][] blockIndexList = new int[][]{
                //minRow,maxRow,minColumn,maxColumn per block (1-9)
                {1, 3, 1, 3},  //block 1
                {1, 3, 4, 6},
                {1, 3, 7, 9},
                {4, 6, 1, 3},  //block 4
                {4, 6, 4, 6},
                {4, 6, 7, 9},
                {7, 9, 1, 3},  //block 7
                {7, 9, 4, 6},
                {7, 9, 7, 9},
        };

        int blockIndex=  block-1;
        int minRow = blockIndexList[blockIndex][0];
        int maxRow= blockIndexList[blockIndex][1];
        int minColumn =  blockIndexList[blockIndex][2];
        int maxColumn= blockIndexList[blockIndex][3];


        List<Integer> blockData=arrayToList(sudoku,minRow,maxRow,minColumn,maxColumn);
        blockData.sort(null);

        ArrayList<Integer> expectedArray = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6,7,8,9));

        if (!blockData.equals(expectedArray)){
            System.out.printf("Block %s is invalid.%n",block);
            return false;

        }


        return true;
    }

    private static Boolean validRows(int[][] sudoku) {

        int[] rows = new int[]{1,2,3,4,5,6,7,8,9};

        for (int row:rows){
            if(!isOneRowValid(row,sudoku)){
                return false;
            }
        }
        return true;
    }

    private static boolean isOneRowValid(int row, int[][] sudoku) {


        List<Integer> rowData=arrayToList(sudoku,row,row,1,9);
        rowData.sort(null);

        ArrayList<Integer> expectedArray = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6,7,8,9));

        if (!rowData.equals(expectedArray)){
            System.out.printf("Row %s is invalid.%n",row);
            return false;

        }


        return true;
    }

    private static Boolean validColumns(int[][] sudoku) {

        int[] columns = new int[]{1,2,3,4,5,6,7,8,9};

        for (int column:columns){
            if(!isOneColumValid(column,sudoku)){
                return false;
            }
        }
        return true;
    }

    private static boolean isOneColumValid(int column, int[][] sudoku) {


        List<Integer> columnData=arrayToList(sudoku,1,9,column,column);
        columnData.sort(null);

        ArrayList<Integer> expectedArray = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6,7,8,9));

        if (!columnData.equals(expectedArray)){
            System.out.printf("Column %s is invalid.%n",column);
            return false;
        }
        return true;
    }

}