package util;


import com.google.gson.Gson;
import models.CurrencyConverterModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HistoryConvertCurrency {
    /**
     * Method to display the conversion history from a JSON file.
     *
     * @throws IOException If an I/O error occurs.
     */
    public static void historyConvertCurrency() throws IOException {
        if (!Files.exists(Paths.get("convertCurrency.json"))) {
            System.out.println("No conversion history available. 📜");
            return;
        }

        // Read the content of the JSON file
        String content = new String(Files.readAllBytes(Paths.get("convertCurrency.json")));

        // Parse JSON content into CurrencyConverterModel array
        Gson gson = new Gson();
        CurrencyConverterModel[] conversionHistory = gson.fromJson(content, CurrencyConverterModel[].class);

        // Display the conversion history
        System.out.println("          📊 Currency Conversion Result history 📊          ");
        System.out.println("--------------------------------------");
        for (CurrencyConverterModel convertCurrency : conversionHistory) {
            System.out.println("🌟 Base Currency: " + convertCurrency.getBaseCode());
            System.out.println("🎯 Target Currency: " + convertCurrency.getTargetCode());
            System.out.println("⏰ Last Update Time (UTC): " + convertCurrency.getTimeLastUpdateUtc());
            System.out.println("⏳ Next Update Time (UTC): " + convertCurrency.getTimeNextUpdateUtc());
            System.out.println("💱 Conversion Rate: " + convertCurrency.getConversionRate());
            System.out.println("💶 Amount Convert: " + convertCurrency.getAmountConvert());
            System.out.println("💵 Conversion Result: " + convertCurrency.getConversionResult());
            System.out.println("--------------------------------------");
        }
        System.out.println();
    }
}

//