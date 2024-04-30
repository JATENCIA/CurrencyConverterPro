package request;

import java.util.ArrayList;
import java.util.List;

public class CurrencyNotPermitted {

    private final List<String> currencies = new ArrayList<>(List.of(
            "ARS",
            "BOB",
            "BRL",
            "CLP",
            "COP",
            "USD",
            "AED",
            "AZN",
            "BAM",
            "CAD",
            "DZD",
            "EUR",
            "FJD",
            "GBP",
            "HKD",
            "IRR",
            "JPY",
            "KRW",
            "LAK",
            "MUR",
            "NGN",
            "OMR",
            "PGK",
            "QAR",
            "RON",
            "SAR",
            "THB",
            "UZS",
            "VND",
            "XOF",
            "YER",
            "ZWL"
    ));

    private String message;

    public List<String> getCurrencies() {
        return currencies;
    }

    public String getMessage() {
        return message;
    }


    public Boolean isCurrencyAllowed(String currency) {

        boolean result = getCurrencies().contains(currency);


        if (!result) {
            this.message = "\n══════════════════════════════════════\n" +
                    "❌ The currency '" + currency + "' is not supported." +
                    "\n══════════════════════════════════════";
        }


        return result;

    }

}
