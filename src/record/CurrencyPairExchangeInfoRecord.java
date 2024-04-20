package record;

public record CurrencyPairExchangeInfoRecord(String base_code, String target_code, String time_last_update_utc,
                                             String time_next_update_utc, double conversion_rate) {
}

