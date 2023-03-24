package Compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Catalog catalogSave =
                new Catalog("MyDocuments");
        var book = new Document("article1");
        var article = new Document("book1");
        catalogSave.add(book);
        catalogSave.add(article);
        try {
            CatalogUtil.save(catalogSave, "d:/catalog.json");
            System.out.println(catalogSave);
        } catch (IOException e) {
            System.out.println("EROARE LA SAVE VERISOR");
        }

//        try {
//            Catalog catalogLoad = CatalogUtil.load("d:/catalog.json");
//            System.out.println(catalogLoad);
//        } catch (IOException e) {
//            System.out.println("EROARE LA LOAD VERISOR");
//        }

    }
}