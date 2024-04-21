package data;

import com.google.gson.*;
import models.CurrencyConverterModel;
import util.SavedConvertCurrency;
import record.CurrencyConverterRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverterData {

    public static void currencyConverter(String secretKey) {

        try {

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            System.out.println("*****************************");
            Scanner scanner = new Scanner(System.in);
            System.out.print("🪙 Enter the base currency code: ");
            String baseCode = scanner.nextLine().toUpperCase();
            System.out.print("💱 Enter the target currency code: ");
            String targetCode = scanner.nextLine().toUpperCase();
            System.out.print("💲 Enter the amount to convert: ");
            double amountConvert = scanner.nextDouble();
            System.out.println("*****************************");


            // Setting URL
            String url_str = "https://v6.exchangerate-api.com/v6/" + secretKey + "/pair/" + baseCode + "/" + targetCode + "/" + amountConvert;

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject dataApi = root.getAsJsonObject();

            CurrencyConverterRecord currencyConverterRecord = gson.fromJson(dataApi, CurrencyConverterRecord.class);
            CurrencyConverterModel currencyConverterModel = new CurrencyConverterModel(currencyConverterRecord , amountConvert);

            SavedConvertCurrency.savedConvertCurrency(currencyConverterModel);

            System.out.println(" ");
            System.out.println(currencyConverterModel);


        } catch (IOException e) {
            System.out.println("Input/output error occurred. Please try again. ❌🔄");
        } catch (Exception e) {
            e.getMessage();
        }


    }

}
