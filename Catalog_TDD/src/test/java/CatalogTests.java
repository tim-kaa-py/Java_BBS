import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CatalogTests {

    @Test
    public void takeUserSearchedCatalog() {
        Catalog catalog = new Catalog();
        String searchedCatalog = "saw";
        InputStream in = new ByteArrayInputStream(searchedCatalog.getBytes());
        System.setIn(in);

        assertEquals("saw", catalog.getInput());
    }

    @Test
    public void searchCatalogInInput(){
        Catalog catalog = new Catalog();
        String searchedCatalog = "saw";
        assertTrue(catalog.isContains(searchedCatalog));
    }

    @Test
    public void searchCatalogNotInInput(){
        Catalog catalog = new Catalog();
        String searchedCatalog = "was";
        assertFalse(catalog.isContains(searchedCatalog));
    }

    @Test
    public void searchCatalogInInputReturnLinesContains(){
        Catalog catalog = new Catalog();
        String searchedCatalog = "saw";
        assertEquals(2, catalog.getLinesContainsSearchedCatalog(searchedCatalog).size());
    }

    @Test
    public void searchCatalogNotInInputReturnLinesContains(){
        Catalog catalog = new Catalog();
        String searchedCatalog = "was";
        assertEquals(0, catalog.getLinesContainsSearchedCatalog(searchedCatalog).size());
    }

    @Test
    public void getCatalogInInputReturnOutput(){
        Catalog catalog = new Catalog();
        String searchedCatalog = "saw";
        assertEquals("table saw> prx: $1099.99 qty: 5" + "\n", catalog.getInfoOutput(catalog.getLinesContainsSearchedCatalog(searchedCatalog)).get(0));
    }

    @Test
    public void getCatalogNotInInputReturnOutput(){
        Catalog catalog = new Catalog();
        String searchedCatalog = "was";
        assertEquals(null, catalog.getInfoOutput(catalog.getLinesContainsSearchedCatalog(searchedCatalog)));
    }
}
