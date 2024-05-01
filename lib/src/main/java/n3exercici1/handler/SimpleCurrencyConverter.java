package n3exercici1.handler;

import java.util.Map;

import n3exercici1.interfaces.CurrencyConverter;

public class SimpleCurrencyConverter implements CurrencyConverter{

	private Map<String, Double> exchangeRates;

    public SimpleCurrencyConverter(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    
	public Map<String, Double> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(Map<String, Double> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}


	@Override
	public double convert(double amount, String toCurrency) {
		if (exchangeRates.containsKey(toCurrency)) {
            double rate = exchangeRates.get(toCurrency);
            return amount * rate;
        } else {
            throw new IllegalArgumentException("No se encontró la tasa de cambio para la moneda " + toCurrency);
        }
	}

}
