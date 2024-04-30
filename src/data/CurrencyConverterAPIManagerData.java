package data;

import com.google.gson.*;
import models.CurrencyExchangeRatesModel;
import record.CurrencyCodeApiRecord;
import request.CurrencyNotPermitted;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

// markdown
public class CurrencyConverterAPIManagerData {
    public static void getExchangeRates(String secretKey) {


        try {

            Scanner scanner = new Scanner(System.in);
            CurrencyNotPermitted currencyNotPermitted = new CurrencyNotPermitted();
            System.out.print("🏦 🪙 Enter the currency code to check its exchange rate: ");
            String code = scanner.nextLine().toUpperCase();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();

            boolean isExistsCurrency = currencyNotPermitted.isCurrencyAllowed(code);

            if (isExistsCurrency) {

                // Setting URL
                String url_str = "https://v6.exchangerate-api.com/v6/" + secretKey + "/latest/" + code;

                // Making Request
                URL url = new URL(url_str);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                // Convert to JSON
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject dataApi = root.getAsJsonObject();

                /**
                 * Constructor to convert a CurrencyCodeApi object to a CurrencyExchangeRates object.
                 * @param api The CurrencyCodeApi object containing currency exchange rates.
                 */
                CurrencyCodeApiRecord currencyCodeApi = gson.fromJson(dataApi.getAsJsonObject("conversion_rates"), CurrencyCodeApiRecord.class);
                CurrencyExchangeRatesModel currencyExchangeRates = new CurrencyExchangeRatesModel(currencyCodeApi, code);
                System.out.println("\n" + currencyExchangeRates);


            } else {
                System.out.println(currencyNotPermitted.getMessage());
            }


        } catch (IOException e) {
            System.out.println("Input/output error occurred. Please try again. ❌🔄");
        }


    }


}
