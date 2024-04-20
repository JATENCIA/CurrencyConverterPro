package data;

import com.google.gson.*;
import models.CurrencyExchangeRatesModel;
import record.CurrencyCodeApiRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
// markdown
public class CurrencyConverterAPIManagerData {
    public static void getExchangeRates(String secretKey) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("🏦 🪙 Enter the currency code to check its exchange rate: ");
        String code = scanner.next().toUpperCase();


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

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

    }


}
