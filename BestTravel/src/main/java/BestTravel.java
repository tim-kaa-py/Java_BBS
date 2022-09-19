import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestTravel {
    List<Integer> ListOfDistance = new ArrayList<>();

    public BestTravel(){
    }
    public void addElement(int Distance) {
        ListOfDistance.add(Distance);
    }

    public void removeElement(int Distance){
        if (ListOfDistance.contains(Distance)){
            ListOfDistance.remove(Integer.valueOf(Distance));}
        System.out.printf("Nothing can be removed");
    }

    public List<Integer> getListsOfDistance() {
        return ListOfDistance;
    }

    public static List<Integer> pickNChoices(List<Integer> ListOfDistance, int n) {
        List<Integer> copy = new ArrayList<Integer>(ListOfDistance);
        Collections.shuffle(copy);
        if (n > copy.size()){return null;}
        return n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n);
    }

    public Object SumOfDistances(List<Integer> pickNChoices){
        if (pickNChoices == null) return null;
        return pickNChoices.stream()
                .reduce(0, Integer::sum);
    }

    private void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    public List<int[]> generateNChoices(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }


}
