package Homework;

import Homework.Commands.AddCommand;
import Homework.Commands.ReportCommand;
import Homework.Commands.ViewCommand;

import java.io.IOException;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        Catalog catalogSave = new Catalog("MyDocuments");

        IntStream.range(0, 10).
                forEach(i -> catalogSave.add(new Document("document (" + i + ")", "d:/documents/" + "document" + i + ".txt")));

        catalogSave.execute(new ReportCommand());


//        try {
//            CatalogUtil.save(catalogSave, "d:/catalog.json");
//            System.out.println(catalogSave);
//        } catch (IOException e) {
//            System.out.println("EROARE LA SAVE VERISOR");
//        }

//        try {
//            Catalog catalogLoad = CatalogUtil.load("d:/catalog.json");
//            System.out.println(catalogLoad);
//        } catch (IOException e) {
//            System.out.println("EROARE LA LOAD VERISOR");
//            System.out.println(e);
//        }

    }
}