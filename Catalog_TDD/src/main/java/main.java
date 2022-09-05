import java.util.List;

public class main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        String s = catalog.s;
        String searchedValue = catalog.getInput();
        if (catalog.isContains(searchedValue)){
            List<String> lines = catalog.getLinesContainsSearchedCatalog(searchedValue);
            System.out.println(catalog.getInfoOutput(lines));
        }
        else {System.out.println("Nothing is found");}
    }
}
