package models;

import record.CurrencyPairExchangeInfoRecord;

public class CurrencyPairExchangeInfoModel {

    private final String baseCode;
    private final String targetCode;
    private final String timeLastUpdateUtc;
    private final String timeNextUpdateUtc;
    private final double conversionRate;

    public CurrencyPairExchangeInfoModel(CurrencyPairExchangeInfoRecord currencyPairExchangeInfoRecord) {

        this.baseCode = currencyPairExchangeInfoRecord.base_code();
        this.targetCode = currencyPairExchangeInfoRecord.target_code();
        this.timeLastUpdateUtc = currencyPairExchangeInfoRecord.time_last_update_utc();
        this.timeNextUpdateUtc = currencyPairExchangeInfoRecord.time_next_update_utc();
        this.conversionRate = currencyPairExchangeInfoRecord.conversion_rate();

    }


    @Override
    public String toString() {
        return "            📊 Currency Pair Exchange Info 📊\n" +
                "--------------------------------------\n" +
                "🌟 Base Currency: " + baseCode + "\n" +
                "🎯 Target Currency: " + targetCode + "\n" +
                "⏰ Last Update Time (UTC): " + timeLastUpdateUtc + "\n" +
                "⏳ Next Update Time (UTC): " + timeNextUpdateUtc + "\n" +
                "💱 Conversion Rate: " + conversionRate + "\n" +
                "---------------------------------------\n";
    }


}
