import data.CurrencyConverterAPIManagerData;
import data.CurrencyConverterData;
import data.CurrencyPairExchangeInfoData;
import util.HistoryConvertCurrency;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;


        Properties properties = new Properties();
        properties.load(new FileInputStream("config/secrets/properties"));
        String secretKey = properties.getProperty("SECRET_KEY");


        while (flag) {

            System.out.println("\n" + "╔══════════════════════════════════════════════════════════════════════════════════════════╗");

            System.out.println("                  🏦 Currency Codes to Check Exchange Rates 🏦                       ");
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println("\n       ARS 💵 BOB 💵 BRL 💵 CLP 💵 COP 💵 USD 💵 AED 💴 AZN 💼 BAM 💵 CAD       ");
            System.out.println("       DZD 💶 EUR 💴 FJD 💷 GBP 💵 HKD 💶 IRR 💴 JPY 💴 KRW 💶 LAK 💶 MUR       ");
            System.out.println("       NGN 💵 OMR 💵 PGK 💶 QAR 💵 RON 💵 SAR 💴 THB 💵 USD 💵 VND 💶 XOF       ");
            System.out.println("       YER 💵 ZWL   \n");
            System.out.println("                        ╔═════════════════════════════════╗                          ");
            System.out.println("                                    OPTIONS                                       ");
            System.out.println("                        ╠═════════════════════════════════╣                          ");
            System.out.println("                          1. View currency values (💵)                               ");
            System.out.println("                          2. Check specific currency (💰)                            ");
            System.out.println("                          3. Convert currency (🔄)                                  ");
            System.out.println("                          4. Conversion History (📜)                                 ");
            System.out.println("                          5. Exit (🚪)                                              ");
            System.out.println("                        ╚═════════════════════════════════╝                           " + "\n");
            System.out.print("╚══════════════════════════════════════════════════════════════════════════════════════════╝" + "\n");


            try {

                System.out.print("Please enter your choice: ");
                int option = scanner.nextInt();
                System.out.println("\n");

                switch (option) {

                    case 1:
                        CurrencyConverterAPIManagerData.getExchangeRates(secretKey);
                        break;
                    case 2:
                        CurrencyPairExchangeInfoData.CurrencyPairExchange(secretKey);
                        break;
                    case 3:
                        CurrencyConverterData.currencyConverter(secretKey);
                        break;
                    case 4:
                        HistoryConvertCurrency.historyConvertCurrency();
                        break;
                    case 5:
                        System.out.println("Exiting the Currency Converter. Goodbye! 👋🌟");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid option! Please select a valid option from the menu. ❌🤔");
                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer. ❌🔢");
                scanner.nextLine();
            }


        }


    }
}


