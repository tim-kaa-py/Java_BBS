package org.example;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.*;

import java.util.List;

public class Main {
    //Will this line of code be in the test file on confluence???
    public static void main(String[] args) {
        int towns=3;
        //int max_dist=230;
        //List<Integer> dist_vector = List.of(91, 74, 73, 85, 73, 81, 87);
        int max_dist=163;
        List<Integer> dist_vector = List.of(50, 55, 56, 57, 58);
        max_dist=chooseBestSum(max_dist,towns,dist_vector);
        System.out.println(max_dist);
    }

    public static int chooseBestSum(int max_dist, int towns, List<Integer> dist_vector) {
        int number_of_dist=dist_vector.size();
        if (number_of_dist<towns){
            System.out.println("Can't find best travel bc you gave more towns than distances");
            return -1;
        }
        List<int[]> index_combination_list = generate_all_index_combinations(number_of_dist, towns);

        int max_allowed_dist = 0;
        int one_dist;
        for (int[] one_combination : index_combination_list) {
            one_dist = calculate_dist(one_combination, dist_vector);
            if (one_dist<=max_dist && one_dist>max_allowed_dist){
                max_allowed_dist=one_dist;
            }
        }
        return max_allowed_dist;
    }

    private static Integer calculate_dist(int[] one_combination, List<Integer> dist_vector) {
        int single_dist;
        int total_dist=0;
        for (int one_index : one_combination) {
            single_dist = dist_vector.get(one_index);
            total_dist=total_dist+single_dist;
        }
        return total_dist;

    }

    public static List<int[]> generate_all_index_combinations(int n, int r) {
        //see: https://www.baeldung.com/java-combinations-algorithm
        List<int[]> index_combination_list = new ArrayList<>();
        Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(n, r);
        while (iterator.hasNext()) {
            int[] combination = iterator.next();
            index_combination_list.add(combination);
        }
        return index_combination_list;
    }
}