import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Catalog {

    public String s = "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n" +
            "\n" +
            "<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>\n" +
            "\n" +
            "<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>\n" +
            "\n" +
            "<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>\n" +
            "\n" +
            "<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>";


    public static String getInput() {
        System.out.println("Please enter searched name");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public boolean isContains(String searchedCatalog) {
        return s.contains(searchedCatalog);
    }
    public List<String> getLinesContainsSearchedCatalog(String searchedCatalog){
            Stream<String> stream = s.lines();
            return stream.filter(x -> x.contains(searchedCatalog)).collect(Collectors.toList());
    }

    public List<String> getInfoOutput(List<String> Lines){
        List<String> output = new ArrayList<String>();
        for (String line : Lines) {
            String searched_line = line.replace("<prod><name>", "").
                    replace("</name><prx>", "> prx: $").
                    replace("</prx><qty>", " qty: ").replace("</qty></prod>", "\n");
            output.add(searched_line);
        }
        if (output.isEmpty()){
            return null;
        }
        return output;
    }
}
