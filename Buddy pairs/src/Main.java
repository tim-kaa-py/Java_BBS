import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Integer> get_divisors(Integer input){
        List<Integer> proper_divisor_list = new ArrayList<>();
        proper_divisor_list.add(1);//every number can be divided by one, so we do not need to test that
        int test_divisor=2;
        while (test_divisor < input) {
            if (input % test_divisor==0) {
                proper_divisor_list.add(test_divisor);
            }
            test_divisor++;
        }
        //System.out.println(Arrays.toString(proper_divisor_list.toArray()));
        return proper_divisor_list;
    }


    public static int get_divisors_sum(Integer input){
        List<Integer>  proper_divisor_list= get_divisors(input);
        int sum=0;
        if(proper_divisor_list.stream().reduce(Integer::sum).isPresent()){ //this was suggested by the intelliJ problem correction... so why not :-D also works without this check though
        sum = proper_divisor_list.stream().reduce(Integer::sum).get(); //sum over complete list
             }
        //System.out.println(sum);
        return sum;
    }


    public static List<Integer> buddy(Integer start, Integer limit) {

        List<Integer> buddy_pair_list = new ArrayList<>();//empty return list

        if (start>limit || start<=0 ) { //check input and return empty list if input is incorrect
            System.out.println("Please enter two positive integers, the second one hast to be larger than the first.");
            return buddy_pair_list;
        }

        int n = start;
        boolean pair_found = false;
        int m_trial = 0;


        while (n <= limit) {
            m_trial=get_divisors_sum(n) -1;//calculate m trial from  s(n) = m + 1

            if (n+1==get_divisors_sum(m_trial)) { //check if m_trial fulfills second condition  s(m) = n + 1
                //System.out.println(n);
                //System.out.println(m_trial);
                pair_found=true;
                break;
            }
            n++;
        }

        if (pair_found)
        {
            System.out.println("found a pair");
            buddy_pair_list.add(n);
            buddy_pair_list.add(m_trial);
        }
        else {
        System.out.println("Sorry we tried everything but couldn't find a buddy pair in the given range.");
        }
        return buddy_pair_list;
    }






    public static void main(String[] args)
    {
        List<Integer> result = buddy(1, 100);
        System.out.println(Arrays.toString(result.toArray())); //print return value

    }
}