import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLParser {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        String searchedValue = catalog.getInput();
        String newString = getRideOfSpaceWithinEachProductName();
        Document html = Jsoup.parse(newString);
        List<String> productName = getString(html, "name");
        List<String> price = getString(html, "prx");
        List<String> quantity = getString(html, "qty");
        List<Integer> indexList = extractedIndexListContainsSearchedValue(searchedValue, productName);
        if (indexList.isEmpty()) System.out.println("Nothing is found");

        for (Integer index : indexList) {
            System.out.println(productName.get(index).replace("_", " ") + "> prx: $" + price.get(index) + " qty: " + quantity.get(index));
        }
    }

    private static List<Integer> extractedIndexListContainsSearchedValue(String searchedValue, List<String> productName) {
        List<Integer> indexList = new ArrayList<Integer>();
        for (int i = 0; i < productName.size(); i++)
            if (productName.get(i).contains(searchedValue)) {
                indexList.add(i);
            }
        return indexList;
    }

    private static List<String> getString(Document html, String tagName) {
        String strings = html.getElementsByTag(tagName).text();
        List<String> listString= List.of(strings.split("\\s+"));
        return listString;
    }

    private static String getRideOfSpaceWithinEachProductName(){
        Catalog catalog = new Catalog();
        String s = catalog.s;
        String newString = s.replace(" ", "_");
        return newString;
    }
}
