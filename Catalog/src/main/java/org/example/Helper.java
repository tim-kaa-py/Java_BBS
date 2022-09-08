package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Helper {

    public String getFileFromResourceAsString(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        String converted_string;
        if (inputStream != null) {
            converted_string = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
        }
        else {
            throw new IllegalArgumentException("file not found! " + fileName);
        }
        return converted_string;
    }


    public void catalog(String catalog, String tool) throws IOException {
        ArrayList<Catalog_item> catalog_list = catalog_to_list(catalog);
        //displayElements(catalog_list);
        if (tool.isEmpty()) {
            System.out.print("Please enter non empty string!");
            System.exit(0);
        }
        List<Catalog_item> result = catalog_list.stream()
                .filter(catalog_item -> catalog_item.name.contains(tool))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.print("Nothing");
        } else {
            for (Catalog_item product : result) {
                System.out.print(product.name + " > prx: $" + product.price + " qty: " + product.quantity + "\n");
            }
        }
    }



    private ArrayList<Catalog_item> catalog_to_list(String catalog_string) throws IOException {

        BufferedReader bufReader = new BufferedReader(new StringReader(catalog_string));
        ArrayList<Catalog_item> catalog = new ArrayList<>();
        String line;
        while( (line=bufReader.readLine()) != null )
        {
            if (!line.isEmpty()){//only read non empty lines
                //System.out.println(line);
                Document html = Jsoup.parse(line);
                String name = html.body().getElementsByTag("name").text();
                double price = parseDouble(html.body().getElementsByTag("prx").text());
                int quantity = parseInt(html.body().getElementsByTag("qty").text());
                //System.out.println(name);
                //System.out.println(price);
                //System.out.println(quantity);
                catalog.add(new Catalog_item(name, price, quantity));
            }
        }
        return catalog;
    }


    public void displayElements(ArrayList<Catalog_item> arraylist)
    {
        System.out.println("Name" + "   Price" + "     Quantity");
        //iteration over the ArrayList for accessing the elements
        for (Catalog_item product : arraylist) {
            //printing the elements to the console
            System.out.println(product.name + "    " + "    " + product.price + "       " + "  " + product.quantity);
        }
    }
}




