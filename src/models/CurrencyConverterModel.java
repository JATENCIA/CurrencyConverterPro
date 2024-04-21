package models;


import data.CurrencyConverterData;
import record.CurrencyConverterRecord;

public class CurrencyConverterModel {

    private final String baseCode;
    private final String targetCode;
    private final String timeLastUpdateUtc;
    private final String timeNextUpdateUtc;
    private final double conversionRate;
    private final double conversionResult;
    private final double amountConvert;

    public CurrencyConverterModel(CurrencyConverterRecord currencyConverterRecord, double amountConvert) {

        this.baseCode = currencyConverterRecord.base_code();
        this.targetCode = currencyConverterRecord.target_code();
        this.timeLastUpdateUtc = currencyConverterRecord.time_last_update_utc();
        this.timeNextUpdateUtc = currencyConverterRecord.time_next_update_utc();
        this.conversionRate = currencyConverterRecord.conversion_rate();
        this.conversionResult = currencyConverterRecord.conversion_result();
        this.amountConvert = amountConvert;

    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public String getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public double getAmountConvert() {
        return amountConvert;
    }

    @Override
    public String toString() {
        return "             📊 Currency Conversion Result 📊\n" +
                "--------------------------------------\n" +
                "🌟 Base Currency: " + baseCode + "\n" +
                "🎯 Target Currency: " + targetCode + "\n" +
                "⏰ Last Update Time (UTC): " + timeLastUpdateUtc + "\n" +
                "⏳ Next Update Time (UTC): " + timeNextUpdateUtc + "\n" +
                "💱 Conversion Rate: " + conversionRate + "\n" +
                "💶 Amount Convert: " + amountConvert + "\n" +
                "💵 Conversion Result: " + conversionResult + "\n" +
                "--------------------------------------\n";
    }


}
