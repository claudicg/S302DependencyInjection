package n3exercici1.handler;

import java.util.HashMap;
import java.util.Map;

import n3exercici1.dependencyInjection.ArticleDisplay;
import n3exercici1.interfaces.CurrencyConverter;

public class AppHandler {

	private Map<String, Double> exchangeRates = new HashMap<>();
	private CurrencyConverter currencyConverter = new SimpleCurrencyConverter(exchangeRates);
	private ArticleDisplay articleDisplay = new ArticleDisplay(currencyConverter);
	
	public void addArticleDisplay() {
		
		articleDisplay.addArticle("Producto 1", 100.0);
	    articleDisplay.addArticle("Producto 2", 75.0);
	    articleDisplay.addArticle("Producto 3", 50.0);
	}
	
	public void AddExchanceRates() {
		
        exchangeRates.put("USD", 1.0); 
        exchangeRates.put("EUR", 0.85); 
        exchangeRates.put("GBP", 0.72);		 
	}
	
	public void printPrices() {
		
		System.out.println("Precios en USD:");
        articleDisplay.displayArticles("USD");

        System.out.println("\nPrecios en EUR:");
        articleDisplay.displayArticles("EUR");

        System.out.println("\nPrecios en GBP:");
        articleDisplay.displayArticles("GBP");
    }
	
	public void runApp() {
		
		addArticleDisplay();
		AddExchanceRates();
		printPrices();	
	}

}
