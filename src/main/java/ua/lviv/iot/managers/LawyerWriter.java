package ua.lviv.iot.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import ua.lviv.iot.models.Lawyer;

public class LawyerWriter {

    public static void writeToFile(List<Lawyer> listOfLawyers) {
        try (PrintWriter writer = new PrintWriter(new File("C:\\lawyerlist.csv"))) {

            StringBuilder sb = new StringBuilder(); 
            for (int i = 0; i < listOfLawyers.size(); i++) {
                Lawyer element = listOfLawyers.get(i);
                sb.append(element.getHeaders());
                sb.append("Stepan Batih");
                sb.append("\n");
                sb.append(element.toCSV());
                sb.append("\n-------------------------------------------------------------------------\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}