package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String line = "";
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("Empty CSV file...");
                return;
            }

            System.out.println("======= Data Preview ======\n");

            String[] columns = headerLine.split(delimiter);
            System.out.println("Columns:");
            for (String column : columns) {
                System.out.print(column + " ");
            }

            System.out.println("\nTotal columns : " + columns.length);
            System.out.println("\n\n First 5 Records:\n");

            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                if (count < 5) {
                    System.out.println(String.join(" ", data));
                }
                count++;
            }

            System.out.println("\n\nTotal Records : " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}