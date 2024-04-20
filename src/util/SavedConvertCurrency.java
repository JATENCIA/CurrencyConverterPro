package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.CurrencyConverterModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SavedConvertCurrency {

    /**
     * Method to save converted currency data to a JSON file.
     *
     * @param convertCurrency The converted currency data to be saved.
     * @throws IOException If an I/O error occurs.
     */
    public static void savedConvertCurrency(CurrencyConverterModel convertCurrency) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File file = new File("convertCurrency.json");

        // Check if the file exists
        boolean fileExists = file.exists();

        if (!fileExists) {
            // If the file does not exist, create a new one and save the conversion in a list
            List<CurrencyConverterModel> conversionList = new ArrayList<>();
            conversionList.add(convertCurrency);

            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(gson.toJson(conversionList));
            printWriter.close();
        } else {
            // If the file exists, read the current content and add the new conversion
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonString.append(line);
            }
            bufferedReader.close();

            // Convert the content to a list of CurrencyConverterModel
            CurrencyConverterModel[] existingConversions = gson.fromJson(jsonString.toString(), CurrencyConverterModel[].class);
            List<CurrencyConverterModel> conversionList = new ArrayList<>();
            if (existingConversions != null) {
                conversionList.addAll(Arrays.asList(existingConversions));
            }

            // Add the new conversion
            conversionList.add(convertCurrency);

            // Write everything back to the file
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(gson.toJson(conversionList));
            printWriter.close();
        }
    }
}




