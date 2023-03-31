package Homework.Commands;

import Homework.Catalog;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {

    @Override
    public void execute(Catalog catalog) throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template t = velocityEngine.getTemplate("hello.vm");

        VelocityContext context = new VelocityContext();
        context.put("Catalog", catalog);

        StringWriter writer = new StringWriter();
        t.merge(context, writer);

        Desktop desktop = Desktop.getDesktop();
        try {
            FileWriter myWriter = new FileWriter("d:/CatalogReport.html");
            myWriter.write(writer.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        desktop.print(new File("d:/CatalogReport.html"));
        desktop.open(new File("d:/CatalogReport.html"));

        System.out.println(writer.toString());
    }
}


