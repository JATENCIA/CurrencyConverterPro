package data;

import com.google.gson.*;
import models.CurrencyPairExchangeInfoModel;
import record.CurrencyPairExchangeInfoRecord;
import request.CurrencyNotPermitted;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyPairExchangeInfoData {

    public static void CurrencyPairExchange(String secretKey) {

        try {

            CurrencyNotPermitted currencyNotPermitted = new CurrencyNotPermitted();

            System.out.println("*****************************");
            Scanner scanner = new Scanner(System.in);
            System.out.print("🪙 Enter the base currency code: ");
            String baseCode = scanner.nextLine().toUpperCase();
            System.out.print("💱 Enter the target currency code: ");
            String targetCode = scanner.nextLine().toUpperCase();
            System.out.println("*****************************");

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                    .setPrettyPrinting()
                    .create();

            boolean isExistsCurrencyBaseCode = currencyNotPermitted.isCurrencyAllowed(baseCode);
            boolean isExistsCurrencyTargetCode = currencyNotPermitted.isCurrencyAllowed(targetCode);

            if (isExistsCurrencyBaseCode && isExistsCurrencyTargetCode) {

                // Setting URL
                String url_str = "https://v6.exchangerate-api.com/v6/" + secretKey + "/pair/" + baseCode + "/" + targetCode;

                // Making Request
                URL url = new URL(url_str);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                // Convert to JSON
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject dataApi = root.getAsJsonObject();

                CurrencyPairExchangeInfoRecord currencyPairExchangeInfoRecord = gson.fromJson(dataApi, CurrencyPairExchangeInfoRecord.class);
                CurrencyPairExchangeInfoModel currencyPairExchangeInfoModel = new CurrencyPairExchangeInfoModel(currencyPairExchangeInfoRecord);

                System.out.println(" ");
                System.out.println(currencyPairExchangeInfoModel);
            } else {
                System.out.println(currencyNotPermitted.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Input/output error occurred. Please try again. ❌🔄");
        }


    }

}
