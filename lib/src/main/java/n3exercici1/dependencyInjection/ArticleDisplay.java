package n3exercici1.dependencyInjection;

import java.util.HashMap;
import java.util.Map;

import n3exercici1.interfaces.CurrencyConverter;

public class ArticleDisplay {

	private Map<String, Double> articles;
    private CurrencyConverter currencyConverter;

    public ArticleDisplay(CurrencyConverter currencyConverter) {
        this.articles = new HashMap<>();
        this.currencyConverter = currencyConverter;
    }

    public void addArticle(String name, double price) {
        articles.put(name, price);
    }

    public void displayArticles(String currency) {
        System.out.println("Artículos:");
        for (Map.Entry<String, Double> entry : articles.entrySet()) {
            String name = entry.getKey();
            double price = entry.getValue();
            double convertedPrice = currencyConverter.convert(price, currency);
            System.out.println(name + ": " + convertedPrice + " " + currency);
        }
    }
}
