import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BestTravelTest {
    @Test
    public void getIntegerList(){
        BestTravel bestTravel = new BestTravel();
        List<Integer> ls = bestTravel.getListsOfDistance();
        assertTrue(ls.isEmpty());
    }

    @Test
    public void addOneElement(){
        BestTravel bestTravel = new BestTravel();
        bestTravel.addElement(30);
        List<Integer> ls = bestTravel.getListsOfDistance();
        assertEquals(Optional.of(30), Optional.of(ls.get(0)));

    }

    @Test
    public void removeOneElement(){
        BestTravel bestTravel = new BestTravel();
        bestTravel.addElement(30);
        bestTravel.addElement(50);
        bestTravel.removeElement(50);
        assertEquals(Arrays.asList(30),bestTravel.getListsOfDistance());
    }

    @Test
    public void getMultipleChoiceFromTheListOfThreeElement(){
        BestTravel bestTravel = new BestTravel();
        bestTravel.addElement(30);
        bestTravel.addElement(50);
        bestTravel.addElement(40);
        List<Integer> randomPicks = BestTravel.pickNChoices(bestTravel.getListsOfDistance(), 3);
        assertEquals(Arrays.asList(30,50,40),randomPicks);
    }

    @Test
    public void getMultipleChoiceFromTheListOfTwoElement(){
        BestTravel bestTravel = new BestTravel();
        bestTravel.addElement(30);
        bestTravel.addElement(50);
        List<Integer> randomPicks = BestTravel.pickNChoices(bestTravel.getListsOfDistance(), 3);
        assertEquals(null,randomPicks);
    }

    @Test
    public void getSumOfMultipleChoicesFromTheList(){
        BestTravel bestTravel = new BestTravel();
        bestTravel.addElement(30);
        bestTravel.addElement(50);
        bestTravel.addElement(40);
        List<Integer> randomPicks = BestTravel.pickNChoices(bestTravel.getListsOfDistance(), 3);
        assertEquals(120, bestTravel.SumOfDistances(randomPicks));
    }

    @Test
    public void getSumOfMultipleChoicesFromTheListHasNotEnoughElement(){
        BestTravel bestTravel = new BestTravel();
        bestTravel.addElement(30);
        bestTravel.addElement(50);
        List<Integer> randomPicks = BestTravel.pickNChoices(bestTravel.getListsOfDistance(), 3);
        assertEquals(null, bestTravel.SumOfDistances(randomPicks));
    }


}
