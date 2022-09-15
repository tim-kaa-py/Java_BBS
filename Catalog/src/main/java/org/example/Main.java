package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Helper helper_class = new Helper();
        String catalog_string=helper_class.getFileFromResourceAsString("catalog.txt");
        helper_class.catalog(catalog_string,"was");
    }
}