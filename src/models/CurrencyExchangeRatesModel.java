package models;

import record.CurrencyCodeApiRecord;

public class CurrencyExchangeRatesModel {
    private final double ars;
    private final double bob;
    private final double brl;
    private final double clp;
    private final double cop;
    private final double usd;
    private final double aed;
    private final double azn;
    private final double bam;
    private final double cad;
    private final double dzd;
    private final double eur;
    private final double fjd;
    private final double gbp;
    private final double hkd;
    private final double irr;
    private final double jpy;
    private final double krw;
    private final double lak;
    private final double mur;
    private final double ngn;
    private final double omr;
    private final double pgk;
    private final double qar;
    private final double ron;
    private final double sar;
    private final double thb;
    private final double uzs;
    private final double vnd;
    private final double xof;
    private final double yer;
    private final double zwl;
    private final String baseCurrency;


    public CurrencyExchangeRatesModel(CurrencyCodeApiRecord currencyCodeApi, String code) {

        this.ars = currencyCodeApi.ars();
        this.bob = currencyCodeApi.bob();
        this.brl = currencyCodeApi.brl();
        this.clp = currencyCodeApi.clp();
        this.cop = currencyCodeApi.cop();
        this.usd = currencyCodeApi.usd();
        this.aed = currencyCodeApi.aed();
        this.azn = currencyCodeApi.azn();
        this.bam = currencyCodeApi.bam();
        this.cad = currencyCodeApi.cad();
        this.dzd = currencyCodeApi.dzd();
        this.eur = currencyCodeApi.eur();
        this.fjd = currencyCodeApi.fjd();
        this.gbp = currencyCodeApi.gbp();
        this.hkd = currencyCodeApi.hkd();
        this.irr = currencyCodeApi.irr();
        this.jpy = currencyCodeApi.jpy();
        this.krw = currencyCodeApi.krw();
        this.lak = currencyCodeApi.lak();
        this.mur = currencyCodeApi.mur();
        this.ngn = currencyCodeApi.ngn();
        this.omr = currencyCodeApi.omr();
        this.pgk = currencyCodeApi.pgk();
        this.qar = currencyCodeApi.qar();
        this.ron = currencyCodeApi.ron();
        this.sar = currencyCodeApi.sar();
        this.thb = currencyCodeApi.thb();
        this.uzs = currencyCodeApi.uzs();
        this.vnd = currencyCodeApi.vnd();
        this.xof = currencyCodeApi.xof();
        this.yer = currencyCodeApi.yer();
        this.zwl = currencyCodeApi.zwl();
        this.baseCurrency = code;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("---------------------\n");
        sb.append("Currency Exchange Rates for: ").append(baseCurrency).append("\n");
        sb.append("---------------------\n");
        sb.append(String.format("%-10s %15s\n", "Currency", "Exchange Rate"));
        sb.append("---------------------\n");
        sb.append(formatCurrency("ARS", ars));
        sb.append(formatCurrency("BOB", bob));
        sb.append(formatCurrency("BRL", brl));
        sb.append(formatCurrency("CLP", clp));
        sb.append(formatCurrency("COP", cop));
        sb.append(formatCurrency("USD", usd));
        sb.append(formatCurrency("AED", aed));
        sb.append(formatCurrency("AZN", azn));
        sb.append(formatCurrency("BAM", bam));
        sb.append(formatCurrency("CAD", cad));
        sb.append(formatCurrency("DZD", dzd));
        sb.append(formatCurrency("EUR", eur));
        sb.append(formatCurrency("FJD", fjd));
        sb.append(formatCurrency("GBP", gbp));
        sb.append(formatCurrency("HKD", hkd));
        sb.append(formatCurrency("IRR", irr));
        sb.append(formatCurrency("JPY", jpy));
        sb.append(formatCurrency("KRW", krw));
        sb.append(formatCurrency("LAK", lak));
        sb.append(formatCurrency("MUR", mur));
        sb.append(formatCurrency("NGN", ngn));
        sb.append(formatCurrency("OMR", omr));
        sb.append(formatCurrency("PGK", pgk));
        sb.append(formatCurrency("QAR", qar));
        sb.append(formatCurrency("RON", ron));
        sb.append(formatCurrency("SAR", sar));
        sb.append(formatCurrency("THB", thb));
        sb.append(formatCurrency("UZS", uzs));
        sb.append(formatCurrency("VND", vnd));
        sb.append(formatCurrency("XOF", xof));
        sb.append(formatCurrency("YER", yer));
        sb.append(formatCurrency("ZWL", zwl));
        sb.append("---------------------\n");
        return sb.toString();
    }

    private String formatCurrency(String currency, double rate) {
        return String.format("%-10s %15.4f\n", currency, rate);
    }

}

