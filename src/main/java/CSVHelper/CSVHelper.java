package CSVHelper;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.nio.file.Files;


public class CSVHelper {

    /*public static void writeDataToCSV(String filename, String lineName, String... args){
        try {
            String[] next;
            Integer i = 0;
            String csv = System.getProperty("user.dir") + "\\csvFiles\\" + filename + ".csv";
            CSVReader reader = new CSVReader(new FileReader(csv));
            while (reader.readNext()!=null){
                i++;
            }
            FileWriter writer = new FileWriter(csv);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            csvWriter.writeNext(args);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }*/
    public static void findDuplicatesInCSVFileAndReplace(String fileName, String... data) {
        String csv = System.getProperty("user.dir") + "\\csvFiles\\" + fileName + ".csv";
        try {

            final CSVReader reader = new CSVReader(new FileReader(csv));

            reader.close();

        } catch (FileNotFoundException e) {

            saveNewRowToCSV(csv, " ", " ");

        } catch (IOException e) {

            e.printStackTrace();

        }

        if (findCSVDataRow(csv, data[0]) || findCSVDataRow(csv, data[1])) {

            replaceRowInCSV(csv, data);

        } else {

            saveNewRowToCSV(csv, data);

        }

    }



    public static void replaceRowInCSV(String filePathName, String... data) {

        try {

            final File oldFile = new File(filePathName);

            final File newFile = new File(oldFile.getParent(), oldFile.getName() + ".tmp");

            Files.move(oldFile.toPath(), newFile.toPath());



            final CSVWriter writer = new CSVWriter(new FileWriter(filePathName));

            final CSVReader reader = new CSVReader(new FileReader(filePathName + ".tmp"));



            String[] line;

            while ((line = reader.readNext()) != null) {

                // log.info("Line: " + Arrays.asList(line));

                if (line[0].equals(data[0]) || line[1].equals(data[1])) {

                    //  log.info("Found matching line, after update: " + Arrays.asList(data));

                    line = data;

                }

                writer.writeNext(line);

            }

            reader.close();

            writer.close();

        } catch (RuntimeException e) {

            throw e;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String countEntriesCSV(String fileName){
        String csv = System.getProperty("user.dir") + "\\csvFiles\\" + fileName + ".csv";
        try {
            final CSVReader reader = new CSVReader(new FileReader(csv));
            int i = 0;

            while ((reader.readNext()) != null) {
                i++;
            }
            reader.close();
            return i+"";
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        throw new NullPointerException();
    }

    public static Boolean findCSVDataRow(String filePathName, String value) {

        try {

            final CSVReader reader = new CSVReader(new FileReader(filePathName));

            String[] line;

            while ((line = reader.readNext()) != null) {

                if (line[0].equals(value) || line[1].equals(value)) {

                    reader.close();

                    return true;

                }

            }

            reader.close();

        } catch (Exception e) {

            //

        }

        return false;

    }

    public static void saveNewRowToCSV(String filePathName, String... data) {

        try {

            final CSVWriter writer = new CSVWriter(new FileWriter(filePathName, true));

            writer.writeNext(data);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
